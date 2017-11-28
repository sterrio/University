// Algorithm Complexity - Fib series, October 17th 2017 - Stephen Terrio B00755443

import java.util.Scanner;
import java.util.ArrayList;

public class Fibonacci_series {
	public static void main (String [] args){
		
		//Initializing an array list with the first two values of the Fibonacci series.
		ArrayList <Integer> series = new ArrayList<Integer>();
		series.add(0); // 
		series.add(1);
		
		//Creating a scanner and n variable for user input
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
	
		fib(n, 0, series);
	}
	
	// Creating a function that takes in an input for the Fibonacci series and stores the value in a list.
	public static int fib(int i,int count, ArrayList <Integer> list){
		
		//If i is either 1 or 0, return themselves and increase the count
		if (count == 0 && count < i) {System.out.println(0); count ++; fib(i,count,list); return 0;}
		if (count == 1 && count < i) {System.out.println(1); count ++; fib(i,count,list); return 1;}
		
		//Get the previous two values and add them together - then add to the list. (if conditions are met)
		if(count < i && count > 0 && count > 1){
			
			int value = list.get(count - 1) + list.get(count - 2);
			list.add(value);
			System.out.println(value);
			count++; // increase count to get the next number in fib series
			fib(i,count,list); //running again if count is less than i.
			return value;
		}
		return 0;
	}
}
