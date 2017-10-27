// Assignment 2 - Binary Tree, October 25th - Stephen Terrio, B00755443
import java.util.Scanner;

public class BinaryTreeDemo1 {
	public static void main (String [] args){
		
		// Creating a Binary tree to store the values of the scanner.
		BinaryTree <String> A = new BinaryTree<String>();
		Scanner sc = new Scanner (System.in);
		
		while (sc.hasNext()){
			insertTree(sc.next(), A);
		}
		
		System.out.print("Preorder:\t");
		BinaryTree.preorder(A);
		System.out.println();
	}
	
	public static void insertTree(String sc, BinaryTree <String> tree){
		
		// If the tree is empty, make a root to be the start of the tree.
		if (tree.nodeNumber(tree) == 0){tree.makeRoot(sc);}
		
		else{
			// the left side of the parent is not filled.
			if (tree.getLeft() == null){
				tree.makeRoot(sc);
				tree.attachLeft(tree);
				
			}
			else{
			// the right side of the parent is not filled
				if (tree.getRight() == null){
				tree.makeRoot(sc);
				tree.attachRight(tree);
				}
			}
			
			// Both sides of the parent are filled
			if(tree.getLeft() != null && tree.getRight() != null){
				if (tree.getLeft().getLeft() != null){insertTree(sc,tree.getLeft());}
			}
			else{
				insertTree(sc, tree.getRight());
			}
		}
	}
}
