// Lab 7 - Binary Search Tree, Nov 19th - Stephen Terrio, B00755443 (Resource taken from class)

//Binary Search Tree class
//uses the Binary Tree class
public class BinarySearchTree<T extends Comparable<T>>
//you are using the compareTo method on objects of type T; hence T should extend Comparable<T>
{
	private BinaryTree<T> tree;
	private int size;
	
	public BinarySearchTree()
	{
		tree = new BinaryTree<T>();
		size=0;
	}
	public BinaryTree<T> getTree()
	{
		return tree;
	}
	public boolean isEmpty()
	{
		return tree.isEmpty();
	}
	public int size()
	{
		return size;
	}
	public BinaryTree<T> search(T key)
	{
		BinaryTree<T> t = tree;
		if (isEmpty()) return null;
		while (t!=null)
		{
			if (key.compareTo(t.getData())<0)
				t = t.getLeft();
			else if (key.compareTo(t.getData())>0)
				t = t.getRight();
			else // key is found
				return t;
		}
		return null;
	}
		
		
	public void insert(T item)
	{
		BinaryTree<T> newNode = new BinaryTree<T>(); //sets left, right, parent and data to null
		newNode.setData(item);

		if (size==0){tree = newNode; size++;return;}
		
		BinaryTree<T> t = tree;
		boolean done = false;
		while (!done)
		{
			int c = item.compareTo(t.getData());
			if (c==0)
			{
				System.out.println("Duplicate key. Can't insert");
				return;
			}
			else if (c<0) //need to go left
			{
				if (t.getLeft()==null)	//place to insert found
				{
					t.setLeft(newNode);
					newNode.setParent(t);
					size++;
					done = true;
				}
				else
					t = t.getLeft(); //otherwise go left one branch
			}
			else //c>0; need to go right
			{
				if (t.getRight()==null) //place to insert found
				{
					t.setRight(newNode);
					newNode.setParent(t);
					size++;
					done=true;
				}
				else
					t = t.getRight();
			}
		}
	}
	
	public BinaryTree<T> findPredecessor(BinaryTree<T> node)
	{
		if (node==null) return null;
		if (node.getLeft()==null) return null;
		BinaryTree<T> pred = node.getLeft();
		while (pred.getRight()!=null)
			pred = pred.getRight();
		return pred;
	}
	
	public void deleteHere(BinaryTree<T> deleteNode, BinaryTree<T> attach)
	{
		if (deleteNode==null) return;
		BinaryTree<T> parent = deleteNode.getParent();
		
		if (parent == null) return;
		if (attach == null)
		{
			if (parent.getLeft()==deleteNode)
				parent.setLeft(null);
			else
				parent.setRight(null);
			return;
		}
		if (deleteNode==parent.getRight())
		{
			parent.detachRight();
			deleteNode.setParent(null);
			//attach.setParent(parent);
			attach.setParent(null);
			parent.attachRight(attach);
			attach.setParent(parent);
		}
		else
		{
			parent.detachLeft();
			deleteNode.setParent(null);
			
			//attach.setParent(parent);
			attach.setParent(null);
			parent.attachLeft(attach);
			attach.setParent(parent);
		}
		deleteNode.clear();
	}
	
	public void delete(T key)
	{
		if (size==0){System.out.println("Can't delete. Empty tree"); return;}
		BinaryTree<T> deleteNode = search(key);
		if (deleteNode==null) {System.out.println("Key not found. Can't delete"); return;}
		
		BinaryTree<T> hold = null;
		if (deleteNode.getLeft()==null && deleteNode.getRight()==null)
		{
			deleteHere(deleteNode, null);
		}
		else if (deleteNode.getLeft()==null)
		{
			hold = deleteNode.getRight();
			deleteHere(deleteNode, hold);
		}
		else if (deleteNode.getRight()==null)
		{
			hold = deleteNode.getLeft();
			deleteHere(deleteNode, hold);
		}
		else
		{
			hold = findPredecessor(deleteNode);
			deleteNode.setData(hold.getData());
			deleteNode=hold;
			deleteHere(deleteNode, deleteNode.getLeft());
		}
		size--;
	}
	// Driver method for other recursive search
	public BinaryTree<T> recursiveSearch(T key){
		if (tree.isEmpty()) return null;
	else
		return recursiveSearch(tree, key);
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

	// Same as getMax but get left instead of right.
	public <T> T getMin(BinaryTree <T> t){
		
		if (t.getLeft() == null ){
			return t.getData();
			}
		
		else {
			return getMin(t.getLeft());
		}
	}

	// Doing exercise 1 & 2, recursively 
	public  <T> T getMax(BinaryTree <T> t){
			// if the right node is null return the current node
			if (t.getRight() == null ){
				return t.getData();
				}
			
			else {
				// If the right node is not null make that the current node.
				return getMax(t.getRight());
			}
		}

	// Determining if it is a binary search tree
	public boolean BinarySearchDet(BinaryTree <T> t){
		// if null return true
		if (t == null){return true;}
		// if there is a left node, check if it is smaller than parent
		 if (t.getLeft() != null && ((Comparable <T> )t.getLeft().getData()).compareTo(t.getData()) > 0){
			    return false;
			  }
		// if there is a right node, check if it is bigger than parent
		 if (t.getRight() != null  && ((Comparable <T> )t.getRight().getData()).compareTo(t.getData()) < 0){
			    return false;
			  }
		 
		 // check if both left & right passed criteria
		  if (BinarySearchDet(t.getLeft()) == false || BinarySearchDet(t.getRight()) == false){
			    return false;
			  }
		  
		  return true;
	}
}
	