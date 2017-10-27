// Assignment 2 - Binary Tree, October 25th - Stephen Terrio, B00755443

public class BinaryTree<T> 
{
	private T data;
	private BinaryTree<T> parent;
	private BinaryTree<T> left;
	private BinaryTree<T> right;
	
	public BinaryTree()
	{
		parent = left = right = null;
		data = null;
	}
	
	
	public void makeRoot(T data)
	{
		if (!isEmpty())
		{
			System.out.println("Can't make root. Already exists");
		}
		else
			this.data = data;
	}
	
	public void setData(T data)
	{
		this.data = data;
	}
	
	public void setLeft(BinaryTree<T> tree)
	{
		left = tree;
	}
	public void setRight(BinaryTree<T> tree)
	{
		right = tree;
	}
	public void setParent(BinaryTree<T> tree)
	{
		parent = tree;
	}
	
	public T getData()
	{
		return data;
	}
	public BinaryTree<T> getParent()
	{
		return parent;
	}
	public BinaryTree<T> getLeft()
	{
		return left;
	}
	public BinaryTree<T> getRight()
	{
		return right;
	}
	
	
	public void attachLeft(BinaryTree<T> tree)
	{
		if (tree==null) return;
		else if (left!=null || tree.getParent()!=null)
		{
			System.out.println("Can't attach");
			return;
		}
		else
		{
			
				tree.setParent(this);
				this.setLeft(tree);
		}
	}
	
	public void attachRight(BinaryTree<T> tree)
	{
		if (tree==null) return;
		else if (right!=null || tree.getParent()!=null)
		{
			System.out.println("Can't attach");
			return;
		}
		else
		{
	
				tree.setParent(this);
				this.setRight(tree);
		}
	}
	
	public BinaryTree<T> detachLeft()
	{
		if (this.isEmpty()) return null;
		BinaryTree<T> retLeft = left;
		left = null;
		if (retLeft!=null) retLeft.setParent(null);
		return retLeft;
	}
	public BinaryTree<T> detachRight()
	{
		if (this.isEmpty()) return null;
		BinaryTree<T> retRight = right;
		right =null;
		if (retRight!=null) retRight.setParent(null);
		return retRight;
	}
	public boolean isEmpty()
	{
		if (data == null)
			return true;
		else
			return false;
	}
	public void clear()
	{
		left = right = parent =null;
		data = null;
	}
	
	public BinaryTree<T> root()
	{
		if (parent == null)
			return this;
		else
		{
			BinaryTree<T> next = parent;
			while (next.getParent()!=null)
				next = next.getParent();
			return next;
		}
	}
	
	public static <T> void preorder(BinaryTree<T> t)
	{
		if (t!=null)
		{
			System.out.print(t.getData()+"\t");
			preorder(t.getLeft());	
			preorder(t.getRight());
		}
	}
	
	public static <T> void inorder(BinaryTree<T> t)
	{
		if (t!=null)
		{
			inorder(t.getLeft());
			System.out.print(t.getData() + "\t");
			inorder(t.getRight());
		}
	}
	
	public static <T> void postorder(BinaryTree<T> t)
	{
		if (t!=null)
		{
			postorder(t.getLeft());
			postorder(t.getRight());
			System.out.print(t.getData() + "\t");
		}
	}
	
	// Get the number of nodes in a tree.
	public <T> int nodeNumber(BinaryTree<T> tree){
		//If the tree is empty, return 0.
		if (tree == null){return 0;}
		
		//If the tree is not empty, return the number of nodes on the left and right side of the original node.
		if (tree != null){
			return 1 + nodeNumber(tree.getLeft()) + nodeNumber(tree.getRight());
		}
		//System.out.println("test");
		return 0;
	}
	
	// Get the maximum height of the tree.
	public <T> int treeHeight(BinaryTree<T> tree){
		//If the tree is empty, return 0.
		if (tree == null){return 0;}
		
		else {
			// If the true isn't empty, take the highest value of the right of left tree path and add one to account for the route.
		return ( Math.max(treeHeight(tree.getLeft()),treeHeight(tree.getRight())) + 1 );
		}
	}
	
	public <T> String treeBalance(BinaryTree<T> tree){
		//If the tree is empty, return 0.
		if (tree == null){return null;}
		
		else {
			if ( Math.max(treeHeight(tree.getLeft().getLeft()), treeHeight(tree.getLeft().getRight()))
			==   Math.max(treeHeight(tree.getRight().getLeft()), treeHeight(tree.getRight().getRight()))
			||   Math.max(treeHeight(tree.getLeft().getLeft()), treeHeight(tree.getLeft().getRight()))
			==	 Math.max(treeHeight(tree.getRight().getLeft()), treeHeight(tree.getRight().getRight())) + 1
			||   Math.max(treeHeight(tree.getLeft().getLeft()), treeHeight(tree.getLeft().getRight()))
			==	 Math.max(treeHeight(tree.getRight().getLeft()), treeHeight(tree.getRight().getRight())) - 1){
				return "The tree is balanced.";
			}
			
			return "The tree is not balanced.";
		}
	}
}