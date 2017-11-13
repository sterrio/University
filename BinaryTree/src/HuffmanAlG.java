// Assignment 2 - Binary Tree, October 30th - Stephen Terrio, B00755443
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;
import java.util.ArrayList;


public class HuffmanAlG {
	public static void main (String [] agrs)throws IOException{
		
		// Getting the file location
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the location of your text file: ");
		String filename = "/Users/jarretterrio/Desktop/Pokemon.txt";
		
		// Reading the file
		File text = new File(filename);
		Scanner file = new Scanner(text);
		
		// Getting every character instead of every word
		file.useDelimiter("");
		
		StringTokenizer token;
		ArrayList<Pair> pairs = new ArrayList<Pair>();
		
		// Setting variable to keep track of array size.
		int arraySize = 0;
		
		while (file.hasNext()){
			String temp = file.next();
			if(!temp.equals(" ") && !temp.equals("\n") ){
				arraySize++;
				Pair p = contain(pairs, temp);
				if (p == null){
					
					p = new Pair(temp, 1);
					pairs.add(p);
				}
				else{
					double tempprob = p.getProb();
					p.setProb(tempprob + 1);
				}
			}
		}
		
		// Converted them into frequencies
		for (int j = 0; j < pairs.size(); j++){
			pairs.get(j).setProb(pairs.get(j).getProb() / arraySize);
		}
	}

	// new contain method to correctly check if the value has been added already
	public static Pair contain(ArrayList<Pair> Al, String s){
		
		for (int i = 0; i < Al.size(); i++){
			if (Al.get(i).getValue() == s.charAt(0)){
				return Al.get(i);
			}
		}
		return null;
	}
}
