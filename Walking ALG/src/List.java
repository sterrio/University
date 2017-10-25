//Unordered list class
public class List<T>
{
	//attributes
	private LinkedList<T> elements;
	private int cursor;
	
	//constructor
	public List()
	{
		elements = new LinkedList<T>();
		cursor = -1;
	}
	
	//add an item to the unordered list
	public void add(T item)
	{
		elements.add(item);
		
	}
	
	//get the size of the unordered list
	public int size()
	{
		return elements.size();
	}
	
	//check if the list is empty
	public boolean isEmpty()
	{
		return elements.isEmpty();
	}
	
	//check if the list contains a given item
	public boolean contains(T item)
	{
		return (elements.indexOf(item)!=-1);
	}
	
	//remove a given item
	public void remove(T item)
	{
		elements.remove(item);
	}
	
	//remove all occurrences of a given item
	public void removeAll(T item)
	{
		elements.removeAll(item);
	}
	
	//clear the list
	public void clear()
	{
		elements.clear();
	}
	
	//enumerate the list
	public void enumerate()
	{
		elements.enumerate();
	}
	
	//get the first item
	public T first()
	{
		if (elements.size()==0)
			return null;
		cursor=0;
		return elements.getAt(cursor);
	}
	
	//get the next item
	public T next()
	{
		if (cursor<0 || cursor==(elements.size()-1))
			return null;
		cursor++;
		return elements.getAt(cursor);
	}
	
}