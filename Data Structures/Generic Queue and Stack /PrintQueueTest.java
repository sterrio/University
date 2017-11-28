import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PrintQueueTest {
	public static void main(String[] args) throws IOException{
		
		Scanner keyboard = new Scanner(System.in); 
		System.out.print("Enter the filename to read from: ");
		String filename = keyboard.nextLine();
		
		
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		StringTokenizer token;
		
		//Creating stack1 to hold StudentRecord objects
		PrintQueue Q = new PrintQueue(); 
		
		while (inputFile.hasNext()){	
			
			String line = inputFile.nextLine();
			token = new StringTokenizer(line, " ");
			String owner = token.nextToken();
			String jobId = token.nextToken();
			int JobI = Integer.parseInt(jobId);
			Q.lpr(owner, JobI);
		}
		
		inputFile.close();
		
		Q.lpq();
		Q.lprmAll("ronaldinho");
		Q.lpq();
	}
}