#include "nonce.h"
#include <stdio.h>
#include <string.h>
#include <assert.h>

#include "transactions.h"
#include "mempool.h"
#include "siggen.h"

#define END_EVENT "END"
#define MINE_EVENT "MINE"
#define TRX_EVENT "TRX"
#define BLK_EVENT "BLK"
#define EPOCH_EVENT "EPOCH"

static void trx_read(trx_t *trx) {
    int n = scanf("%u %s %s %u %u", &trx->id, trx->payer,
                   trx->payee, &trx->amount, &trx->fee);
    assert(n == 5);
}

static void trx_print(char *prefix, trx_t *trx) {
    printf("%s%d %s %s %d %d\n", prefix, trx->id, trx->payer,
           trx->payee, trx->amount, trx->fee);
}

static void trx_age(trx_t *trx, int prio) {
    printf("Aging transaction (%d):", prio);
    trx_print("", trx);
}

int main() {
    char buffer[10]; // Assume input will be correct.
    trx_list_t *selected = transaction_list();
    unsigned int prev_id = 0;
    unsigned int prev_sig = 0;
    unsigned int num_threads = 0;

    mempool_init();

    for (;;) {
        scanf("%s", buffer);  // assume input will be correct
        if (!strcmp(buffer, END_EVENT)) {
            break;
        } else if (!strcmp(buffer, EPOCH_EVENT)) {
            mempool_age(trx_age);
        } else if (!strcmp(buffer, TRX_EVENT)) {
            trx_t * trx = transaction_new();
            trx_read(trx);
            trx_print("Adding transaction: ", trx);
            mempool_add(trx);
        } else if (!strcmp(buffer, BLK_EVENT)) {
            unsigned int block_id;
            unsigned int num_trx;
            trx_t trx;

            int n = scanf("%u %u %i %u", &block_id, &prev_id,
                           &prev_sig, &num_trx);
            assert(n == 4);

            for (int i = 0; i < num_trx; i++) {
                trx_read(&trx);
                trx_t *t = mempool_remove(trx.id);
                if (t != NULL) {
                    trx_print("Removing transaction: ", t);
                    transaction_delete(t);
                }
            }

            unsigned int nonce;
            prev_id = block_id;
            n = scanf("%i %i", &nonce, &prev_sig);
            assert(n == 2);
        } else if (!strcmp(buffer, MINE_EVENT)) {
            int n = scanf("%d", &num_threads);
            assert(n == 1);
            unsigned int id = prev_id + 1;
            unsigned int num_trx = 0;
            unsigned int available = 256 - 24; // 24 bytes in block without transactions

            for (trx_t *t = mempool_select(available); t != NULL; t = mempool_select(available)) {
                available -= transaction_size(t);
                num_trx++;
                transaction_append(selected, t);
            }

            unsigned int sig = siggen_new();
            sig = siggen_int(sig, id);
            sig = siggen_int(sig, prev_id);
            sig = siggen_int(sig, prev_sig);
            sig = siggen_int(sig, num_trx);
            printf("Block mined: %d %d 0x%8.8x %d\n", id, prev_id, prev_sig, num_trx);

            for (int i = 0; i < num_trx; i++) {
                trx_t *t = transaction_pop(selected);
                sig = siggen_int(sig, t->id);
                sig = siggen_string(sig, t->payer);
                sig = siggen_string(sig, t->payee);
                sig = siggen_int(sig, t->amount);
                sig = siggen_int(sig, t->fee);
                trx_print("", t);
                transaction_delete(t);
            }

            unsigned int nonce = get_nonce(sig,num_threads);
            sig = siggen_int(sig, nonce);
            printf("0x%8.8x 0x%8.8x\n", nonce, sig);
            prev_id = id;
            prev_sig = sig;
        }
    }
    return 0;
}
