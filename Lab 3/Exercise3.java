// Lab 3 - Data Structures and Algorithms, October 1st, 2017. Stephen Terrio, B00755443.

import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class Exercise3 {

	// Code from PDF
	public static void main(String[] args) throws IOException{
		
		Scanner keyboard = new Scanner(System.in); 
		System.out.print("Enter the filename to read from: ");
		String filename = keyboard.nextLine();
		
		
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		StringTokenizer token;
		
		//Creating stack1 to hold StudentRecord objects
		GenericStack<StudentRecord> stack1 = new GenericStack<StudentRecord>();
		
		while (inputFile.hasNext()){	
			
			String line = inputFile.nextLine();
			token = new StringTokenizer(line, " ");
			String f = token.nextToken();
			String l = token.nextToken();
			String bString = token.nextToken();
			
			//Converting bString to an Integer object
			int bint = Integer.parseInt(bString);
			
			//Creating a StudentRecord object with the first name, last name and //ID number, push it into stack1
			StudentRecord SR = new StudentRecord(f,l,bint);
			stack1.push(SR);
		} 
		inputFile.close();
		
		//Creating stack 2 to hold all last names
		GenericStack<String> stack2 = new GenericStack<String>();
		
		// Taking all Stack 1 last names and adding them to Stack 2
		for (int i = 0; i <= stack1.getSize(); i++){
			stack2.push(stack1.pop().getlN());
		}
		
		// looping through stack 2 and popping and displaying all last names.
		for(int i = 0; i <= stack2.getSize(); i++){
			System.out.println(stack2.pop());
		}
	} 
}
