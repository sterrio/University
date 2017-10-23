// Algorithm Complexity - Tower of Hanoi, October 22nd 2017 - Stephen Terrio B00755443
import java.util.Scanner;

public class TowerOfHanoi {
	// Making a static variable count to count how many steps there was. 
	static int count; 
	
	public static void main(String [] Args){
		// Creating a scanner to take  in the amount of discs to be used.
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of discs: ");
		int numDiscs = sc.nextInt();
		
		// Calling the function and printing out the amount of steps.
		moveDiscs(numDiscs, 1, 3, 2);
		System.out.print("There was " + count +" steps to this solution.");
	}	
	
public static void moveDiscs(int n, int from, int to, int temp) {
	
	    if (n > 0){
	    	count ++;
	         moveDiscs(n - 1, from, temp, to);
	         moveDiscs(n - 1, temp, to, from);
	    	}
	  }
}
