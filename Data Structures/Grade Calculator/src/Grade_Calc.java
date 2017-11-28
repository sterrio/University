// Grade Calculator - Stephen Terrio B00755443

import java.util.Scanner;

public class Grade_Calc {
	public static void main(String[] args){
	
		Scanner n = new Scanner (System.in); 
		
		System.out.println("Enter the amount of classes you took: ");
		int input;
		
		while((input= n.nextInt()) > 0){
		
			float[] Grades = new float[input];
			float sum = 0;
			float Mean = 0;
			float Median = 0;
			
			System.out.println("Enter your grades in each class: ");
			for(int i=0; i<input; i++ ){
				Grades[i] = n.nextFloat();
				}
			// Array values set 
		
			for (int i=0; i < Grades.length; i++){
				sum+=Grades[i];
				Mean = sum/Grades.length;
			}
			//mean calculation complete
		
			if (Grades.length % 2 == 0){
				Median = (Grades[Grades.length / 2] + Grades[(Grades.length / 2) - 1]) /2;	
			}
			else {
		Median = Grades[(Grades.length-1)/2];		
	}
		//Median calculations complete
			System.out.println("You're average grade is: " + Mean + "\t" + "With a median grade of: " + Median);
		}
	}
}

