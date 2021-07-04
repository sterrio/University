//
// Created by Alex Brodsky on 2021-05-19.
//

#include <stdio.h>
#include <assert.h>
#include "transactions.h"
#include "mempool.h"

#define PRIORITIES 10

static trx_list_t *queues[PRIORITIES];

extern void mempool_init() {
    for (int i = 0; i < PRIORITIES; i++) {
        queues[i] = transaction_list();
    }
}

extern void mempool_add(trx_t *trx) {
    assert(trx);

    unsigned priority = trx->fee / transaction_size(trx);

    if (priority >= PRIORITIES) {
        priority = PRIORITIES - 1;
    }

    transaction_append(queues[priority], trx);
}

extern trx_t * mempool_remove(unsigned int id) {
    trx_t *t = NULL;
    int priority;

    for (priority = 0; priority < PRIORITIES; priority++) {
         t = transaction_find(queues[priority], id);
         if (t != NULL) {
             transaction_remove(queues[priority], t);
             break;
         }
    }

    return t;
}

extern trx_t * mempool_select(int max_size) {
    int priority;

    for (priority = PRIORITIES - 1; priority >= 0; priority--) {
        for (trx_t *t = queues[priority]->head; t != NULL; t = t->next) {
            if (transaction_size(t) <= max_size) {
                transaction_remove(queues[priority], t);
                return t;
            }
        }
    }
    return NULL;
}

extern void mempool_age(void (*callback)(trx_t *, int)) {
    int priority;

    for (priority = PRIORITIES - 2; priority >= 0; priority--) {
        if (queues[priority]->head != NULL) {
            trx_t *t = transaction_pop(queues[priority]);
            transaction_append(queues[priority + 1], t);
            callback(t, priority + 1);
        }
    }
}
