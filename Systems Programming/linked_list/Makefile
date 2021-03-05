bintree: bintree.o bintreeM.o
	gcc --std=c18 -I . bintree.o bintreeM.o -o bintree

bintree.o: bintree.c
	gcc --std=c18 -c bintree.c -o bintree.o

clean:
	-rm bintree.o

.PHONY: clean