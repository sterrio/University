// Algorithm Complexity - Fib series, October 19th 2017 - Stephen Terrio B00755443
import java.util.Scanner;

public class Multiples {
	public static void main(String [] args){
		
		System.out.println("Enter in positive integers (n) and (m) to find multiples of (m) for: ");
		//Creating a scanner for user values.
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		//CAlling function
		multiples(n,m);
		
	}
	public static int multiples(int x, int y){
		// If (m) is 0 then just return 0;
		if  (y == 0){return 0;}
		
		// If y is bigger than 0, print out x * y and decrease y and run again.
		if (y > 0){
			
			System.out.print(y * x + "\t");
			
			int temp = multiples(x, y-1);
			return temp;
		}
		return 0;
	}
}
