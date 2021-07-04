//
// Created by Alex Brodsky on 2021-04-24.
//

#ifndef MINER_SIGGEN_H
#define MINER_SIGGEN_H

/* These functions are provided to allow easy computation of the signature of sequence of integers and
 * strings.  The following is an example of how to compute the signature of a block in pseudocode
 *
 * sig = siggen_new();              // start a new signature
 * sig = siggen_int(sig, id);
 * sig = siggen_int(sig, prev_id);
 * sig = siggen_int(sig, prev_sig);
 * sig = siggen_int(sig, num_transactions);
 *
 * for t in block_transactions:
 *   sig = siggen_int(sig, t.id);
 *   sig = siggen_string(sig, t.payer);
 *   sig = siggen_string(sig, t.payee);
 *   sig = siggen_int(sig, t.amount);
 *   sig = siggen_int(sig, t.fee);
 *
 * sig = siggen_int(sig, nonce);           //  full signature is computed
 */

/* Return the initial signature value to start the signature computation process
 * Params: None
 * Returns: integer representing the initial signature
 */
extern unsigned int siggen_new();

/* Return an updated signature that includes the supplied integer value
 * Params:
 *     sig:   current signature value
 *     value: integer value to be included in the signature computation
 * Returns: integer representing the updated signature
 */
extern unsigned int siggen_int(unsigned int sig, unsigned int value);

/* Return an updated signature that includes the supplied string value
 * Params:
 *     sig:   current signature value
 *     value: string value to be included in the signature computation
 * Returns: integer representing the updated signature
 */
extern unsigned int siggen_string(unsigned int sig, char *value);

#endif //MINER_SIGGEN_H
