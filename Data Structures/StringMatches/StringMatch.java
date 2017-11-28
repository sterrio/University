// A1 - String Match, Oct.2nd 2017, Stephen Terrio B00755443.

import java.util.Scanner;

public class StringMatch {
	public static void main(String [] args){
		System.out.println("Enter in your word, followed by the sub word.");
		 
		//Using user input to determine which word to loop through and what to look for.
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		String subWord = sc.next();
		
		// Initializing variables to be used in check procedure.
		int check = subWord.length();
		int counter = 0;
		boolean contains = false;
		
		//If the sub word is bigger than the main word, return this message.
		if(subWord.length() > word.length()){
			System.out.println("No matches - The subword "+ subWord +" was not found in "+ word +".");
		}else{
			
			//loop through length of the main word
			for (int i = 0; i < word.length() - check; i++){
				
				//check if current char is equal to first char of the sub word.
				if (word.charAt(i) == subWord.charAt(0)){
					
					//loop through all characters of the sub word.
					for(int j = 0; j < check; j++){
						
						//check if the whole word is contained, if so increase counter 
						if (j == check - 1 && word.charAt(i + j) == subWord.charAt(j)){
							contains = true;
							counter++;
						}
					}
				}
			}			
		}
		if(contains); System.out.println("Substring " + subWord + " was found in " + word + " " + counter + " " + "times");
		
	}
}
