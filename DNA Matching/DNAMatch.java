import java.util.Scanner;
import java.io.*;

public class DNAMatch {
	public static void main(String[] args) throws IOException{
		
		System.out.println("Enter the filename to read from: ");
		Scanner sc = new Scanner(System.in);	
		String fDNA = sc.next();
		
		System.out.println("Enter the test string: ");
		//Getting the test string
		String subWord = sc.next();
			
			
		File f = new File (fDNA);
		FileInputStream fInput = new FileInputStream(f);
			
		//Using BitStream to correctly read the file input. (Scanning the file path missed cases)
		byte [] fB = new byte[(int) f.length()];
		fInput.read(fB);
		fInput.close();
		String word = new String (fB);
			
			
		long startTime, endTime, executionTime;
		startTime = System.currentTimeMillis();		
		//Importing code from String match to be used to find DNA matches.
		int check = subWord.length();
		int counter = 0;
		boolean contains = false;
			
			//If the sub word is bigger than the main word, return this message.
		if(subWord.length() > word.length()){
			System.out.println("No matches - The subword "+ subWord +" was not found in "+ word +".");
		}else{
				
			//loop through length of the main word
			for (int i = 0; i < word.length() - (check - 1); i++){
										//check if current char is equal to first char of the sub word.
				if (word.charAt(i) == subWord.charAt(0)){
					
					//loop through all characters of the sub word.
					for(int j = 0; j < check; j++){
						
						if (j == check - 1 && word.charAt(i + j) == subWord.charAt(j)){
							contains = true;								counter++;
						}
						if(word.charAt(i + j) != subWord.charAt(j)) break;
					}
				}
			}			
		}
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
			
		if(contains); System.out.println("DNA " + subWord +  " was found " + counter + " times in " + executionTime + " milliseconds");
	}
}
