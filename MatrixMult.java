// A2 - Algorithm Complexity, September 21st 2017, Stephen Terrio.

import java.util.Scanner;

public class MatrixMult {
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in); int n;
		double num;
		
		//setting n variable to be used as the size of both matrices.
		System.out.print("Enter the size of each matrix: ");
		n = keyboard.nextInt();
		
		//Setting "number" variable to input to be used to form matrices.
		System.out.println("Enter the matrix element"); System.out.print("All elements of the matrices are assumed to be the same: ");
		num = keyboard.nextDouble();
		
		
		//Setting the two matrices to number from user.
		double[][] matrix1 = new double[n][n]; for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++) { matrix1[i][j] = num; }
		
		double[][] matrix2 = new double[n][n]; for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++) { matrix2[i][j] = num; }
		
		//starting timer and setting a result matrix to save the new values after equation is done.
		long startTime, endTime, executionTime; startTime = System.currentTimeMillis();
		double[][] resultMatrix = multiplyMatrix(matrix1, matrix2);
		
		//Getting execution time and printing after all code has finished running
		endTime = System.currentTimeMillis(); executionTime = endTime - startTime;
		System.out.println("Execution time: " + executionTime + " millisecs");
		
		}
	
		/** The method for multiplying two matrices */
		public static double[][] multiplyMatrix(double[][] m1, double[][] m2) {
		//include your code here }
			
			//Declaring a result matrix to return the new values of the equated matrix.
			double [][] resulting_Matrix = new double[m1.length][m2[0].length];
			
			//loop through all the rows.
			for (int i = 0; i < m1.length; i++) { 
				// loop through all the columns.
			    for (int j = 0; j < m1[0].length; j++) { 
			    	// loop through each value.
			        for (int x = 0; x < m1[0].length; x++) { 
			        	
			        	// Setting the resulting_Matrix index to the calculated value.
			            resulting_Matrix[i][j] += m1[i][x] * m2[x][j];
			        }
			    }
			}
			return resulting_Matrix;
		}
}
