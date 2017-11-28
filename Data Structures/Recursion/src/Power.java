// Algorithm Complexity - Fib series, October 17th 2017 - Stephen Terrio B00755443
import java.util.Scanner;

public class Power {
	public static void main (String [] args){
		
		System.out.println("Enter in the x (base) and n (power) you want to use: ");
		Scanner sc = new Scanner (System.in);
		
		//Setting base and power as user inputs
		int x = sc.nextInt();
		int n = sc.nextInt();
		
		int answer = power(x,n);
		System.out.println(x + " raised to the power of " + n + " is " + answer + ".");
	}
	
	public static int power(int x, int n){
		
		//  If the power is 0, then return 1.
		if (n == 0){return 1;}
		
		// If power is greater than 0 than set a temporary variable to hold current base level.
		if (n > 0){
			int temp = x * power(x, n-1);
			return temp;
		}
		
		return 0;
	}
}
