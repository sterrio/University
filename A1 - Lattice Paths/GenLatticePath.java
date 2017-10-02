// A1 - Lattice Paths, Oct.2nd 2017, Stephen Terrio B00755443.

import java.util.Scanner;
import java.util.ArrayList;

public class GenLatticePath {
	public static void main(String [] args){
		
		System.out.println("What is the nxn size of the grid?");
		
		//Creating scanner to take in the input size of n.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//Staring timer.
		
		long startTime, endTime, executionTime;
		startTime = System.currentTimeMillis();
		
		int twoN = n*2;
		//Setting a variable for n!
		int fact = factorial(n);

		//Calculating the amount of possible paths using given formula
		double form = (factorial(twoN))/Math.pow(fact, 2);
		
		//Converting from double to integer.
		int paths = (int)form;
		System.out.println("There are " + paths +" possible paths.");
		
		//creating and array list to save the possible routes.
		ArrayList<String> keys = new ArrayList<String>();
		
		//Calling the direction function and then printing out the list of keys.
		Direction(0,0,n,"", keys);
		System.out.println(keys);
		
		//Display endTime.
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		System.out.println("The program took " + executionTime + " milliseconds");
	}
	
	//Creating a function to get the paths of the lattice.
	public static void Direction(int x, int y, int n, String route, ArrayList<String> keys){
		
		// When we reach n, (both x and y values equal n) save it to an array list.
		if ( x == n && y == n){
			keys.add(route);
			return;
		}
		
		// Setting temporary values to save the original position of x and y.
		int x1 = x;
		int y1 = y;
		
		// When x and y are both less than n, increase them both and add corresponding letters to route.
		if (x < n && y < n){
			
			Direction(x+1,y,n, route + "E",keys);
			Direction(x1, y1+1, n, route + "N",keys);
		}
		
		// When x position is less than N, increase horizontally and add E to route.
		if ( x < n && y == n){
			Direction(x+1,y,n, route + "E",keys);
		}
		
		// When y position is less than n, increase vertically and add N to route.
		if (x == n && y < n){
			Direction(x, y+1, n, route + "N",keys);
		}
		
	}
	
	//Making a recursive function to be used to calculate the factorial of N
	public static int factorial(int e){
		
		if(e <= 1) {return e;}
		return e*factorial(e-1);

	}
}
