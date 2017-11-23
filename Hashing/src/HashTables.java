// Lab 8 - Hashing, November 23rd - Stephen Terrio, B00755443 
import java.util.Scanner;
import java.util.*;

public class HashTables {
	public static void main (String [] args){
		
		System.out.println("Enter in the table size for your hashMap: ");
		Scanner sc = new Scanner (System.in);
		int tableSize = sc.nextInt();
		
		ArrayList <LinkedList<Integer>> hash = new ArrayList <LinkedList<Integer>>();
		
		System.out.println("Enter the amount of keys to be hashed: ");
		int keys = sc.nextInt();
		
		// Generating random keys using Random and add it to the array list
		for (int i = 0; i < keys + 1; i++){
			Random gen = new Random();
			int random = gen.nextInt(10000);
			
			// checking where the best position should be.
			int position = random % tableSize;
			
			// Making the random a Linked list to add to the array list
			LinkedList <Integer> temp = new LinkedList <Integer>();
			hash.set(position, temp);
		}
		// Looping through and enumarating all linked lists.
		for (int i = 0; i < hash.size(); i++){
			//hash.get(i).e;
		}
		
	}
}
