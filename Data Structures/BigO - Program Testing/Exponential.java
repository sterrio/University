// A2 - Algorithm Complexity, September 22nd 2017, Stephen Terrio.

import java.util.Scanner;

public class Exponential {
	public static void main(String [] args){
		
		System.out.println("Set the value of n to be used: ");
		Scanner sc = new Scanner(System.in);
		
		//setting the value of n vie input by user.
		 int n = sc.nextInt();
		 
		 long startTime, endTime, executionTime; 
			startTime = System.currentTimeMillis();
			
		 for (int i = 0; i <= Math.pow(2, n) - 1; i++){
			 String sb = Integer.toBinaryString(i);
		 }
		 endTime = System.currentTimeMillis();
		 executionTime = endTime - startTime;
		 System.out.println(executionTime);
	}
}
