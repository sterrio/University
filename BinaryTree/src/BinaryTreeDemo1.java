// Assignment 2 - Binary Tree, October 25th - Stephen Terrio, B00755443
import java.util.Scanner;
import java.util.*;

public class BinaryTreeDemo1 {
	public static void main (String [] args){
		
		// Creating a Binary tree to be used as the root of the tree
		BinaryTree <String> A = new BinaryTree<String>();
		Scanner sc = new Scanner (System.in);
		
		//Getting the input and setting it as the root of the tree to be formed.
		System.out.print("Enter Node Name or Done: ");
		String input = sc.next();
		A.makeRoot(input);
		
		// Setting the 
		System.out.print("Enter Node Name or Done: ");
		input = sc.next();
		
		while (!input.toLowerCase().equals("done")) {
			   
			BinaryTree<String> Btemp = new BinaryTree<String>();
			
			Btemp.makeRoot(input);
			insertInputTree(A, Btemp);   
			
			System.out.print("Enter Node Name or Done: ");
			input = sc.next();
		   }
		
		// Accessing methods in BinaryTree class.
		BinaryTree <String> binary = new BinaryTree<String>();
		
		// Separating inputs and results.
		System.out.println();
		
		System.out.print("Height of Tree: ");
		int i = binary.treeHeight(A);
		System.out.println(i);
		
		System.out.print("Number of Nodes: ");
		int j = binary.nodeNumber(A);
		System.out.println(j);
		
		System.out.print("Inorder:\t");
		BinaryTree.inorder(A);
		System.out.println();
		
		System.out.print("Preorder:\t");
		BinaryTree.preorder(A);
		System.out.println();
		
		System.out.print("Postorder:\t");
		BinaryTree.postorder(A);
		System.out.println();
		
	}
	
	// Method used to insert the inputs into the tree. 
	public static void insertInputTree(BinaryTree<String> root, BinaryTree<String> node) {
		
		// Setting up a queue to add in nodes from left to right.
        Queue<BinaryTree<String>> queue = new LinkedList<BinaryTree<String>>();
        
        // Adding the root of the tree to the queue.
        queue.add(root);
        
        // While the queue is not empty  (loops through until all nodes are added)
        while (!queue.isEmpty()) {
        	
        	// temporary variable = current node in queue
            BinaryTree<String> temp = queue.remove();
            
            // If the left side child is empty, insert the node there.
            if (temp.getLeft() == null) {
                temp.attachLeft(node); 
                return; 
            }
            // If it could not be added, add it back on to the queue to check the right side.
            queue.add(temp.getLeft());
            
            // If the right side child is empty, insert the node there.
            if (temp.getRight() == null) {
            	temp.attachRight(node);
                return;
            }
            // If it could not be added, add it back on to the queue to check the left side again.
            queue.add(temp.getRight());
        }

    }
}
