linked_list: linked_list.o linkedM.o 
	gcc --std=c18 -I . linked_list.o linkedM.o -o linked_list

linked_list.o: linked_list.c
	gcc --std=c18 -c linked_list.c -o linked_list.o

clean:
	-rm linked_list.o

.PHONY: clean