// Assignment 2 - Binary Tree, October 30th - Stephen Terrio, B00755443
import java.util.Scanner;
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
		
		// Creating a queue to create a binary tree
		ArrayList<BinaryTree<Pair>> nodes = new ArrayList<BinaryTree<Pair>>();
		
		// adding all pairs to node tree
		for (int j = 0; j < pairs.size(); j++){
			BinaryTree<Pair> temp = new BinaryTree<Pair>();
			temp.makeRoot(pairs.get(j));
			nodes.add(temp);
		}	
		
		ArrayList<BinaryTree<Pair>> sortedNodes = new ArrayList<BinaryTree<Pair>>();
		
		while(nodes.size() > 0){
			BinaryTree<Pair> small = nodes.get(0);
			for (int i = 1; i < nodes.size(); i++){
				// If the current smallest is bigger than the current temporary, set new prob
				if (small.getData().getProb() > nodes.get(i).getData().getProb()){
					small = nodes.get(i);
				}
			}
			// removing to prevent infinite loop
			nodes.remove(small);
			sortedNodes.add(small);
		}
		
		ArrayList<BinaryTree<Pair>> copy = new ArrayList<BinaryTree<Pair>>(sortedNodes);
		
		//Setting a new tree to put them inside a Huffman tree
		ArrayList<BinaryTree<Pair>> T = new ArrayList<BinaryTree<Pair>>();
		
		while (sortedNodes.size() > 0) {
		
			BinaryTree <Pair> first;
			BinaryTree <Pair> second;
			
			if (T.size() == 0){
				//removing the first two nodes in sorted array list
				first = sortedNodes.remove(0);
				second = sortedNodes.remove(0);
			}
			else{
				// If t has a smaller probability, remove and make it the first node. If not remove it from sortedNodes.
				if (T.get(0).getData().getProb() < sortedNodes.get(0).getData().getProb()){
					first = T.remove(0);
				}
				else {
					first = sortedNodes.remove(0);
				}
				
				// If t has a smaller probability, remove and make it the first node. If not remove it from sortedNodes.
				if (sortedNodes.size() == 0 || (T.size() != 0 && T.get(0).getData().getProb() < sortedNodes.get(0).getData().getProb())){
					second = T.remove(0);
				}
				else {
					second = sortedNodes.remove(0);
				}
			}
			
			//Combining the previous trees
			BinaryTree <Pair> C = new BinaryTree<Pair>();
			C.makeRoot(new Pair("dummy", first.getData().getProb() + second.getData().getProb()));
			C.attachLeft(first);
			C.attachRight(second);
			T.add(C);
		}
		
		// Making T all one tree, and not a bunch of small trees.
		while (T.size() > 1){
			
			BinaryTree <Pair> first = T.remove(0);
			BinaryTree <Pair> second = T.remove(0);
			
			BinaryTree <Pair> C = new BinaryTree<Pair>();
			C.makeRoot(new Pair("dummy", first.getData().getProb() + second.getData().getProb()));
			C.attachLeft(first);
			C.attachRight(second);
			T.add(C);
		}
		
		// Saving the huffman tree into a new tree
		BinaryTree <Pair> Huff = T.get(0);
		// getting the huffman codes
		String [] codes = findEncoding(Huff);
		PrintWriter textfile = new PrintWriter("Huffman.txt");
		textfile.println("Symbol\tProb.\tHuffman code");
		System.out.println();
		
		// Making the text file filled with all the codes/ values / probabilities.
		for (int i = 0; i < copy.size(); i++){
			
			char temp = copy.get(i).getData().getValue();
			double tempprob = copy.get(i).getData().getProb();
			String codet = codes[(int) temp];
			
			textfile.println(temp + "\t" + tempprob + "\t" + codet);
		}
		textfile.close();
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
	public static void findEncoding(BinaryTree<Pair> t, String[] a, String prefix) {
	if (t.getLeft()==null&& t.getRight()==null) {
		a[(byte)(t.getData().getValue())]= prefix;
  
	} else {
		findEncoding(t.getLeft(), a, prefix+"0");
		findEncoding(t.getRight(), a, prefix+"1"); 
	}
}
	public static String[] findEncoding(BinaryTree<Pair> t) {
		String[] result = new String[256]; findEncoding(t, result, "");
		return result;
	}
}