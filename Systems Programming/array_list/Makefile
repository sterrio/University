array_list: array_list.o arrayM.o 
	gcc --std=c18 -I . array_list.o arrayM.o -o array_list

array_list.o: array_list.c
	gcc --std=c18 -c array_list.c -o array_list.o

clean:
	-rm array_list.o

.PHONY: clean