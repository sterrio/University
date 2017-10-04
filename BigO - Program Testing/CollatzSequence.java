//A2 - Algorithm Complexity, September 20th 2017, Stephen Terrio B00755443.

import java.util.Scanner;

public class CollatzSequence{
	public static void main(String [] args){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the beginning integer");
		int index;
		index = sc.nextInt();
		int steps = 0;
		int most = 0;
		
		for(int j = index; j >= 1; j --){	
			int i = j;
			int iterations = 1;// starting iteration count at 1 to account for the starting "set" step
			
			while(i > 0){
				if (i == 1){break;}
				
				if(i % 2 == 0 && i != 1){
					i = i/2;
					iterations++;
					if(iterations > steps){steps = iterations; most = j;}
				}
				
				if(i % 2 != 0 && i != 1){
					i = i*3 +1;
					iterations++;
					if(iterations > steps){steps = iterations; most = j;}
				}
			}
			if (j == 1){break;}
		}
		System.out.println(most);
		System.out.println(steps);
	}
}
