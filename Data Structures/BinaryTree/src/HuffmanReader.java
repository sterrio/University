import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

// Assignment 2 - Binary Tree, Nov 15th. - Stephen Terrio, B00755443
public class HuffmanReader {
	public static void main (String [] args)throws IOException{
		
		// Getting the file locations
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter location of the Huffman text file: ");
		String Huffman = sc.nextLine();
		File hFile = new File(Huffman);
		
		System.out.println("Enter location of the Pokemon text file: ");
		String Pokemon = sc.nextLine();
		File pFile = new File(Pokemon);
		
		// Reading the Huffman file for the characters and the code values.
		Scanner reader = new Scanner (hFile); 
		reader.nextLine(); // ignoring the column names (The first row.)
		
		// Creating two hash maps to decode / encode
		HashMap<String, String> coder = new HashMap <String, String>();
		HashMap<String, String> reverse = new HashMap <String, String>();
		
		//Looping through the huffman text file and setting the character huffman codes based in the hash maps.
		while (reader.hasNext()){
			String val = reader.next();
			reader.next(); // Skipping the probabilities (Not used for encoding/decoding)
			String codes = reader.next();
			
			// Using those values to make a encode/ decode for that specific character
			coder.put(val, codes);
			reverse.put(codes, val);
		}
		// Encoding the Pokemon text file
		Scanner pokReader = new Scanner(pFile);
		pokReader.useDelimiter("");
		String pokData = "";
		
		while(pokReader.hasNext()){
			 pokData += pokReader.next();
		}
		
		PrintWriter ecFile = new PrintWriter("ec.txt");
		
		// Looping through the text file and changing all characters to codes.
		for(HashMap.Entry<String, String> codes : coder.entrySet()) {
             pokData = pokData.replace(codes.getKey(), codes.getValue());
		}
		// printing out the encoded text file.
		ecFile.println(pokData);
		ecFile.close();
	
			
		Scanner decoder = new Scanner (pokData);
		PrintWriter dcFile = new PrintWriter("dc.txt");
		
		// Gets every character of each word
		decoder.useDelimiter("");
		
		// setting variables to be used for stored words.
		String current = "";
		String decodedMessage = "";
		
		// Looping through each value in pokData (the encoded file essentially)
		for (int i = 0; i < pokData.length(); i++) {
			
			// setting temp to be used for current number / space.
            char temp = pokData.charAt(i);
            
            // if the temp value is not a space or new line, add it to the current combination.
            if (temp == '1' || temp == '0') {
                current += temp;
                
                // if the current combination is in the reversed huffman codes - add it to the decoded message and reset current
                if (reverse.containsKey(current)) {
                    decodedMessage += reverse.get(current).toString();
                    current = ""; // resetting
                }
            }
            
          // if it's not a value 1 or 0 then move on and rest the current.
            else {
                decodedMessage += temp;
                current = "";
            }
		}
		// Printing out the result into a new text file.
		dcFile.print(decodedMessage);
		dcFile.close();
	}
}

// ignore these, they are my paths...
// HUffman : /Users/jarretterrio/Documents/workspace/BinaryTree/Huffman.txt
// Pokemon : /Users/jarretterrio/Documents/workspace/BinaryTree/Pokemon.txt