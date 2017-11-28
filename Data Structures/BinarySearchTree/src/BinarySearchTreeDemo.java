import java.util.Scanner;

// Lab 7 - Binary Search Tree, Nov 19th - Stephen Terrio, B00755443
public class BinarySearchTreeDemo {
	public static void main(String [] args){
		
		// Creating a Binary tree to be used as the root of the tree
		BinarySearchTree <String> binary = new BinarySearchTree<String>();
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter in the values you want in the tree, seperated by spaces: ");
		
		// Reading the line of nodes, and putting them into a binary search tree.
		String inputLine = sc.nextLine();
		Scanner reader = new Scanner(inputLine);
		reader.useDelimiter(" ");
		// While there is still a String to add
		while (reader.hasNext()){
			binary.insert(reader.next());
		}
		
		// Separating inputs and results.
		System.out.println();
		
		System.out.println("The max value in the tree is: " + binary.getMax(binary.getTree()));
		System.out.println("The min value in the tree is: "+ binary.getMin(binary.getTree()));
		
		if (binary.BinarySearchDet(binary.getTree()) == true){
			System.out.println("The Tree is a Binary Search Tree");
		} else {
			System.out.println("The Tree is not a Binary Search Tree");
		}
		
		System.out.println("Enter in a key to search for: ");
		String key = sc.next();
		
		// If the key is found in the tree, print its found, if not - print that instead.
		if(binary.recursiveSearch(key) != null){
			System.out.println("There is a node with the key value in the tree.");
		}
		else {
			System.out.println("The tree has no node with the key value");
		}
	}
}	
