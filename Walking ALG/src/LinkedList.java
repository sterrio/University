public class LinkedList<T>
{
	//attributes
	private Node<T> front;
	private int count;
	
	//constructor
	public LinkedList()
	{
		front = null;
		count=0;
	}
	public Node<T> getFront()
	{
		return front;
	}
	
	//adds an item to the front of the linked list
	public void add(T item)
	{
		Node<T> newNode = new Node<T>(item, front);
		front = newNode;
		count++;
	}
	
	//returns the current size of the linked list
	public int size()
	{
		return count;
	}
	
	//clears the linked list
	public void clear()
	{
		front = null;
		count=0;
	}
	
	//returns true if the linked list is empty
	public boolean isEmpty()
	{
		return (count==0);
	}
	
	//scans the linked list and prints the data
	public void enumerate()
	{
		Node<T> curr = front;
	
		while (curr!=null)
		{
			System.out.print(curr.getData() + "--> ");
			curr = curr.getNext();
		}
		
	}
	
	//returns the data at a given index
	public T getAt(int index)
	{
		Node<T> curr = front;
		if (index<0||index>=count)
		{
			System.out.println("Error. Index out of bounds");
			return null;
		}
		else
		{
			
			for(int i=0; i<index; i++)
				curr = curr.getNext();
			return curr.getData();
		}			

	}
	
	//inserts an item at a given index
	public void insertAt(T item, int index)
	{
		if (index<0||index>count)
		{
			System.out.println("Can't insert. Index out of bounds.");
			System.exit(0);
		}
		else
		{
			if (index==0)
			{
				add(item);
				return;
			}
			Node<T> prev = front;
			for(int i=0;i<index-1;i++)
				prev = prev.getNext();
			Node<T> itemnode = new Node<T>(item,prev.getNext());
			prev.setNext(itemnode);
			count++;
		}
	}
	
	//sets the data at a node at a given index
	public void setAt(T item, int index)
	{
		if (index<0||index>=count)
		{
			System.out.println("Can't set. Index out of bounds");
			System.exit(0);
		}
		else
		{
			Node<T> curr = front;
			for(int i=0;i<index;i++)
				curr = curr.getNext();
			curr.setData(item);
		}
	}
	
	//returns the index of the first occurrence of a given item, -1 if not found
	public int indexOf(T item)
	{
		Node<T> curr = front;
		for(int i=0;i<count;i++)
		{
			if (item.equals(curr.getData()))
				return i;
			curr = curr.getNext();
		}
		return -1;
	}
	
	//removes the node at a given index
	public T removeAt(int index)
	{
		T result = null;
		if (index<0||index>=count)
		{
			System.out.println("Can't remove. Index out of bounds");
			System.exit(0);
		}
		else
		{
			
			if (index==0)
			{
				result = front.getData();
				front = front.getNext();
			}
			else
			{
				Node<T> prev = front;
				for(int i=0;i<index-1;i++)
					prev = prev.getNext();
				result=prev.getNext().getData();
				prev.setNext(prev.getNext().getNext());
					
			}
			count--;
		}
		return result;
	}
	
	//removes the node containing the first occurrence of a given item
	public void remove (T item)
	{
		int i = indexOf(item);
		if (i==-1)
		{
			System.out.println("No such item");
			System.exit(0);
		}
		else
			removeAt(i);
	}
	
	//Removes all nodes containing a given item
	//Does it in one scan (O(n))
	public void removeAll(T item)
	{
		
		Node<T> curr=front, prev=null;
		
		while (curr!=null)
		{
			if (front.getData().equals(item))
			{
				front = front.getNext();
				curr = curr.getNext();
				count--;
			}
			else if (curr == front)
			{
				prev = curr;
				curr = curr.getNext();
			}
			else
			{
				if (curr!=null)
				{
					if (curr.getData().equals(item))
					{
						prev.setNext(curr.getNext());
						curr= prev.getNext();
						count--;
					}
					else
					{
					prev = curr;
					curr = curr.getNext();
					}
				}
			}
		}
	}
	
		
		
}