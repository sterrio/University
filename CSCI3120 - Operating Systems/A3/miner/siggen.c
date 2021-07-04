//
// Created by Alex Brodsky on 2021-04-24.
//

#include <string.h>
#include "siggen.h"

static unsigned int murmur3_32(const unsigned char* key, int len, unsigned int seed);

/* Return the initial signature value to start the signature computation process
 * Params: None
 * Returns: integer representing the initial signature
 */
extern unsigned int siggen_new() {
    return 0;
}


/* Return an updated signature that includes the supplied integer value
 * Params:
 *     sig:   current signature value
 *     value: integer value to be included in the signature computation
 * Returns: integer representing the updated signature
 */
extern unsigned int siggen_int(unsigned int sig, unsigned int value) {
    return murmur3_32((unsigned char *) &value, sizeof(unsigned int), sig);
}


/* Return an updated signature that includes the supplied string value
 * Params:
 *     sig:   current signature value
 *     value: string value to be included in the signature computation
 * Returns: integer representing the updated signature
 */
extern unsigned int siggen_string(unsigned int sig, char *value) {
    return murmur3_32((unsigned char *) value, strlen(value), sig);
}

// Using a Murmur Hash (https://en.wikipedia.org/wiki/MurmurHash)
// Code is used directly from the above link,
// From Wikipedia:
// MurmurHash is a non-cryptographic hash function suitable for general
// hash-based lookup.[1][2][3] It was created by Austin Appleby in 2008[4]
// and is currently hosted on GitHub along with its test suite named 'SMHasher'.
// It also exists in a number of variants,[5] all of which have been released
// into the public domain. The name comes from two basic operations, multiply
// (MU) and rotate (R), used in its inner loop.
// [1] "Hadoop in Java". Hbase.apache.org. 24 July 2011. Archived from the original on 12 January 2012. Retrieved 13 January 2012.
// [2] Chouza et al.
// [3] "Couceiro et al" (PDF) (in Portuguese). p. 14. Retrieved 13 January 2012.
// [4] Tanjent (tanjent) wrote,3 March 2008 13:31:00. "MurmurHash first announcement". Tanjent.livejournal.com. Retrieved 13 January 2012.
// [5] "MurmurHash2-160". Simonhf.wordpress.com. 25 September 2010. Retrieved 13 January 2012.
static inline unsigned int murmur_32_scramble(unsigned int k) {
    k *= 0xcc9e2d51;
    k = (k << 15) | (k >> 17);
    k *= 0x1b873593;
    return k;
}

static unsigned int murmur3_32(const unsigned char* key, int len, unsigned int seed) {
    unsigned int h = seed;
    unsigned int k;
    /* Read in groups of 4. */
    for (int i = len >> 2; i; i--) {
        // Here is a source of differing results across endiannesses.
        // A swap here has no effects on hash properties though.
        memcpy(&k, key, sizeof(unsigned int));
        key += sizeof(unsigned int);
        h ^= murmur_32_scramble(k);
        h = (h << 13) | (h >> 19);
        h = h * 5 + 0xe6546b64;
    }
    /* Read the rest. */
    k = 0;
    for (int i = len & 3; i; i--) {
        k <<= 8;
        k |= key[i - 1];
    }
    // A swap is *not* necessary here because the preceding loop already
    // places the low bytes in the low places according to whatever endianness
    // we use. Swaps only apply when the memory is copied in a chunk.
    h ^= murmur_32_scramble(k);
    /* Finalize. */
    h ^= len;
    h ^= h >> 16;
    h *= 0x85ebca6b;
    h ^= h >> 13;
    h *= 0xc2b2ae35;
    h ^= h >> 16;
    return h;
}
