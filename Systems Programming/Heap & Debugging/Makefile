heap: heap.o array_list.o
	gcc --std=c18 -I . heap.o array_list.o -o heap

rheap: heap.o array_list.o rheapM.o
	gcc --std=c18 -I . heap.o array_list.o rheapM.o -o rheap

array_list.o: array_list.c
	gcc --std=c18 -c array_list.c -o array_list.o

heap.o: array_list.c
	gcc --std=c18 -c heap.c -o heap.o

clean:
	-rm heap.o array_list.o

.PHONY: clean