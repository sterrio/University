// Algorithm Complexity - Fib series, October 17th 2017 - Stephen Terrio B00755443

import java.util.Scanner;

public class factorial {
	public static void main(String [] args){
		
		// Initializing a scanner to take input
		Scanner sc = new Scanner (System.in);
		System.out.println("Are you evaluating the factorial 1 through 10? ");
		
		//If calculating a random number
		if (sc.next().toLowerCase().equals("no")){
			
			// Calculate by recursion using the fact() function
			System.out.println("What number are you evaluating? ");
			int n = sc.nextInt();
			int answer = fact(n);
			System.out.println("The factorial of "+ n + " is " + answer);
			return;
			
		// else, they are calculating for number 1 - 10.
		} else {
			// loop through 1 to 10
			for(int i = 1; i <= 10; i++){
				// run the factorial function on the current integer in the loop.
				int answer = fact(i);
				System.out.println("The factorial for " + i + " is " + answer);
			}
		}
	}
	
	public static int fact(int i){
		// Checking if input is equal to 0, if so return 1.
		if (i == 0 ){return 1;}
		
		// Checks if input is greater or equal to 1, if so continue evaluating.
		if (i >= 1){
			int temp = i * fact(i - 1);
			return temp;
		}
		return 1;
	}
}
