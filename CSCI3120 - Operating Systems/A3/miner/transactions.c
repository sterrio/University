//
// Created by Alex Brodsky on 2021-04-24.
//

#include <stdlib.h>
#include <string.h>
#include <assert.h>
#include "transactions.h"

extern trx_list_t * transaction_list() {
    return calloc(1, sizeof(trx_list_t));
}

extern void transaction_append(trx_list_t *list, trx_t *t) {
    assert(list);
    assert(t);

    if (list->head) {
        list->tail->next = t;
    } else {
        list->head = t;
    }
    list->tail = t;
    t->next = NULL;
}


extern trx_t * transaction_pop(trx_list_t *list) {
    assert(list);

    trx_t * t = list->head;
    if (t) {
        list->head = t->next;
    }
    return t;
}


extern trx_t *transaction_find(trx_list_t *list, unsigned id) {
    assert(list);

    for (trx_t *t = list->head; t; t = t->next) {
        if (t->id == id) {
            return t;
        }
    }
    return NULL;
}


extern void transaction_remove(trx_list_t *list, trx_t *t) {
    assert(list);

    if (list->head) {
        if (list->head->id == t->id) {
            list->head = list->head->next;
        } else {
            for (trx_t *p = list->head; p->next; p = p->next) {
                if (p->next->id == t->id) {
                    p->next = p->next->next;
                    if (!p->next) {
                        list->tail = p;
                    }
                    break;
                }
            }
        }
    }
}


extern trx_t *transaction_new() {
    return calloc(1, sizeof(trx_t));
}


extern void transaction_delete(trx_t *t) {
    assert(t);
    free(t);
}

extern int transaction_size(trx_t *t) {
    assert(t);
    // 3 * 4 + strlen(payer) + 1 + strlen(payee) + 1
    return 14 + strlen(t->payee) + strlen(t->payer);
}


