// Algorithm Complexity - Vertical October 19th 2017 - Stephen Terrio B00755443
import java.util.Scanner;

public class Vertical {
	public static void main(String [] args){
		
		Scanner sc = new Scanner (System.in);
		int converter = sc.nextInt();
		
		
		vertical(converter);
		
	}
	public static void vertical(int x){
		
		// Changing the integer to a string and getting the first character
		String temp = Integer.toString(x);
		System.out.println(temp.charAt(0));
		// Setting a variable to a substring of every number after the first
		String temp_x = temp.substring(1);
		
		// if there's more numbers.. run the following code
		if (temp_x.equals("")){return;}
		
		else{
			// Change the substring to an integer and run the function again
		int new_x = Integer.parseInt(temp_x);
		vertical(new_x);
		}
	}
}
