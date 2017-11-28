// Algorithm Complexity - Fib series, October 17th 2017 - Stephen Terrio B00755443
import java.util.Scanner;

public class Countdown {
	public static void main(String [] args){
		
		// Merging Exercise 3 & 4 for convenience. Type Original or Modified to select.
		System.out.print("Are you testing the (Original) Countdown, or the (Modified) Countdown ? ");
		Scanner resp = new Scanner (System.in);
		
		// Saving answer in a variable for later checks.
		String response = resp.next().toLowerCase();
		
		if(response.equals("original")){
			
			System.out.println("From where do you want to countdown from? ");
			// Initializing a Scanner to take in user input size.
			Scanner sc = new Scanner (System.in);
			int n = sc.nextInt();
			// Calling the count down function
			countDown(n);
			
		}
		// If testing the modified version of the count down function.
		else if (response.equals("modified")){
			
			System.out.println("From where do you want to countdown from? ");
			// Initializing a Scanner to take in user input size.
			Scanner sc = new Scanner (System.in);
			int n = sc.nextInt();
			// Calling the count down (modified) function
			countDownMod(n);
			
		}
		// Catching and notifying any error in input.
		else {System.out.println("Entry error: Please input either (original) or (modified).");}
	}
	
	public static void countDown(int x){
		// If x is either equal to, or below 0, Blast off !!! Woooooo
		if (x <= 0 ) {System.out.print("BlastOff!");}
		// Else just print the current number, and get closer to blast off by decreasing x.
		else {System.out.print(x + "\t"); countDown(x-1);}
	}
	
	public static void countDownMod(int x){
		// If x is either equal to, or below 0, Blast off !!! Woooooo
		if (x <= 0 ) {System.out.print("BlastOff!");}
		// Else just print the current number, and get closer to blast off by decreasing x.
		else {
			
			// Handling when x is even
			if (x % 2 == 0){
				System.out.print(x + "\t");
				countDownMod(x -2);
			}
		}
		{
			// Handling when x is odd
			if ( x % 2 != 0 && x > 0){
				System.out.print(x + "\t");
				countDownMod(x -2);
			}
		}
	}
}
