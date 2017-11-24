// Lab 8 - Hashing, November 23rd - Stephen Terrio, B00755443 
import java.util.Scanner;
import java.util.*;

public class HashTables {
	public static void main (String [] args){
		
		System.out.println("Enter in the table size for your hashMap: ");
		// Getting the user input for table size
		Scanner sc = new Scanner (System.in);
		int tableSize = sc.nextInt();
		// Setting a variable to store the total amount of conflicts
		int conflicts = 0;
		// Initializing the array list of linked lists of integers.
		ArrayList <LinkedList<Integer>> hash = new ArrayList <LinkedList<Integer>>(tableSize);
		
		// Adding "Table size" amount of linked lists to the array list.
		for (int i = 0; i < tableSize; i++){
			LinkedList <Integer> fill = new LinkedList<Integer>();
			hash.add(fill);
		}
		
		// Getting user input for number of keys to be generated.
		System.out.println("Enter the amount of keys to be hashed: ");
		int keys = sc.nextInt();
		
		// Generating random keys using Random and add it to the array list
		for (int i = 0; i < keys; i++){
			Random gen = new Random();
			int key = gen.nextInt(10000);
			
			// checking where the best position should be.
			int position = key % tableSize;
			
			// Adding the key to the most fitting position.
			hash.get(position).add(key);
		}
		
		
		// Looping through and enumerating all linked lists.
		for (int i = 0; i < tableSize; i++){
			
			// If the current list is not empty.
			if (!hash.get(i).isEmpty()){
				System.out.println("\nThe list at index " + i + " contains: ");
				
				// Get all elements of the linked list.
				for (int j = 0; j < hash.get(i).size(); j++){
					
					if (hash.get(i).size() > 1 && j > 0){conflicts ++;}
			
					System.out.print(hash.get(i).get(j).toString() + " ");
				}
				
			}
		}	
		
		System.out.println("\nThe total number of conflicts is: " + conflicts + ".");
	}
}
