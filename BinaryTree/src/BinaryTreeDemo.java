// Assignment 2 - Binary Tree, October 25th - Stephen Terrio, B00755443

public class BinaryTreeDemo
{
	public static void main(String[] args)
	{
		
		// Multiple Binary trees to be merged together
		BinaryTree<String> A = new BinaryTree<String>();
		BinaryTree<String> B = new BinaryTree<String>();
		BinaryTree<String> C = new BinaryTree<String>();
		BinaryTree<String> D = new BinaryTree<String>();
		BinaryTree<String> E = new BinaryTree<String>();
		BinaryTree<String> F = new BinaryTree<String>();
		BinaryTree<String> G = new BinaryTree<String>();
		BinaryTree<String> H = new BinaryTree<String>();
		
		// Making specific routes to refer to the trees
		A.makeRoot("A");
		B.makeRoot("B");
		C.makeRoot("C");
		D.makeRoot("D");
		E.makeRoot("E");
		F.makeRoot("F");
		G.makeRoot("G");
		H.makeRoot("H");
		
		// Attaching certain routes to other routes. Super route being A.
		A.attachLeft(B);
		A.attachRight(C);
		B.attachLeft(D);
		B.attachRight(E);
		D.attachLeft(F);
		D.attachRight(G);
		G.attachLeft(H);
		
		
		System.out.print("Preorder:\t");
		BinaryTree.preorder(A);
		System.out.println();
		
		System.out.print("Inorder:\t");
		BinaryTree.inorder(A);
		System.out.println();
		
		System.out.print("Postorder:\t");
		BinaryTree.postorder(A);
		System.out.println();
		
		System.out.print("Number of Nodes:\t");
		
		BinaryTree bt = new BinaryTree();
		
		int j = bt.nodeNumber(A);
		System.out.println(j);
		
		
		System.out.println("Height of Tree:\t");
		int leftCount = 1;
		int rightCount = 1;
		int i = bt.treeHeight(A);
		System.out.print(i);
		
	}
	
}