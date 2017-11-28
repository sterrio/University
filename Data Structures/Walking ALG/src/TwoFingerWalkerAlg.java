// Assignment 2 - Linked Lists, October 24th - Stephen Terrio, B00755443
import java.io.*;
import java.util.Scanner;

public class TwoFingerWalkerAlg {
	
	public static void main(String [] args)throws IOException{
		
		// Taking in the location of the file and using the file to create an ordered list of names
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the location of your text file: ");
		
		String filename = sc.next();
		File file = new File(filename);
		Scanner scf = new Scanner(file);
		
		// Creating list to store the names from the file
		OrderedList<String> list1 = new OrderedList<String>();
		
		// looping through the file and adding items to the list.
		while (scf.hasNext()){
			list1.insert(scf.next());
		}
		scf.close();
		
		// Doing the same thing as before, for a new list for the second file
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter the location of your second text file: ");
		
		String filename2 = sc2.next();	
		File file2 = new File(filename2);
		Scanner scf2 = new Scanner(file2);
		
		OrderedList<String> list2 = new OrderedList<String>();
		
		while (scf2.hasNext()){
			list2.insert(scf2.next());
		}
		scf2.close();
		
		// Creating a third list to store the new values of the function.
		OrderedList<String> list3 = new OrderedList<String>();
		
		//Calling the method.
		list3 = mergeLists(list1,list2);
		
		// Returning the new list.
		list3.enumerate();
	}
	
	
	public static OrderedList<String> mergeLists(OrderedList<String> list1, OrderedList<String> list2){
		
		OrderedList<String> list3 = new OrderedList<String>();
		
		// Looping through list 1 and adding all to list 3
		for (int i = 0; i < list1.size(); i ++){
			list3.insert(list1.get(i));
		}
		
		// Looping through list 1 and adding all to list 3
		for (int i = 0; i < list2.size(); i ++){
			list3.insert(list2.get(i));
		}
		
		// returning the new list.
		return list3;
	}
}
