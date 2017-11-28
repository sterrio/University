// Algorithm Complexity - Squares, October 22nd 2017 - Stephen Terrio B00755443
import java.util.Scanner;

public class Squares {
	public static void main (String [] Args){
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int sum = squares(num);
		System.out.println(sum);
		
	}
	
	public static int squares(int x){
		// Return 0 if entered number was 0
		if (x == 0){return 0;}
		
		// If input is greater than 0, return the numbers square plus the one of below it.
		if (x > 0){
			return x*x + squares(x-1);
		}
		return 0;
	}
}
