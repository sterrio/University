// Lab 7 - Binary Search Tree, Nov 19th - Stephen Terrio, B00755443
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
	
	// Doing exercise 1 & 2, recursively 
	public static <T> T getMax(BinaryTree <T> t){
		// if the right node is null return the current node
		if (t.getRight() == null ){
			return t.getData();
			}
		
		else {
			// If the right node is not null make that the current node.
			return getMax(t.getRight());
		}
	}

	// Same as getMax but get left instead of right.
	public static <T> T getMin(BinaryTree <T> t){
		
		if (t.getLeft() == null ){
			return t.getData();
			}
		
		else {
			return getMax(t.getLeft());
		}
	}

	// Recursive search method
	public BinaryTree<T> recursiveSearch(BinaryTree <T> t, T key){
		if (t.isEmpty()){ return null;}
		else {
			// if the root is smaller than the key, get the right node
			if (((Comparable <T>)t.getData()).compareTo(key) < 0){
				if(t.getRight() == null){return null;}
			return recursiveSearch(t.getRight(), key);
			}
			// if the root is bigger than the key, get the left node
			if (((Comparable <T>)t.getData()).compareTo(key) > 0){
				if(t.getLeft() == null){return null;}
				return recursiveSearch(t.getLeft(), key);
			}
			// if the root is equal to the key, get the node
			if (((Comparable <T>)t.getData()).compareTo(key) == 0){
				return t.root();
			}
		}
		return null;
	}

	public boolean BinarySearchDet(BinaryTree <T> t){
		if (t.getData() == null){return true;}
		
		 if (((Comparable <T> )t.getLeft()).compareTo(null) != 0 && ((Comparable <T> )t.getLeft().getData()).compareTo(t.getData()) > 0){
			    return false;
			  }
		 if (((Comparable <T> )t.getRight()).compareTo(null) != 0 && ((Comparable <T> )t.getRight().getData()).compareTo(t.getData()) < 0){
			    return false;
			  }
		 
		  if (BinarySearchDet(t.getLeft()) == false || BinarySearchDet(t.getRight()) == false){
			    return false;
			  }
		  return true;
	}
}
	



