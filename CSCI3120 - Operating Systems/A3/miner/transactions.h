//
// Created by Alex Brodsky on 2021-04-24.
//

#ifndef MINER_TRANSACTIONS_H
#define MINER_TRANSACTIONS_H

typedef struct transaction {
    struct transaction *next;
    unsigned int id;
    char payer[32];
    char payee[32];
    unsigned int amount;
    unsigned int fee;
} trx_t;

typedef struct transaction_list {
    trx_t *head;
    trx_t *tail;
} trx_list_t;

extern trx_list_t * transaction_list();
extern void transaction_append(trx_list_t *list, trx_t *t);
extern trx_t *transaction_pop(trx_list_t *list);
extern trx_t *transaction_find(trx_list_t *list, unsigned id);
extern void transaction_remove(trx_list_t *list, trx_t *t);
extern trx_t *transaction_new();
extern void transaction_delete(trx_t *t);
extern int transaction_size(trx_t *t);

#endif //MINER_TRANSACTIONS_H
