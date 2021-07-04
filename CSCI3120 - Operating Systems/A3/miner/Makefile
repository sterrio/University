all: miner

miner: main.c siggen.c siggen.h nonce.c nonce.h
	gcc -Wall -lpthread -o miner main.c siggen.c nonce.c
