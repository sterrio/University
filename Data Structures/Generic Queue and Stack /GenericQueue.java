import java.util.ArrayList;

//Lab 3 - Data Structures and Algorithms, October 1st, 2017. Stephen Terrio, B00755443.

public class GenericQueue <Q> {
	int cursor; // To be used in first() and next() functions.
	
	//Initializing an array list to be used to make a generic queue
	private ArrayList<Q> Queue;
	public GenericQueue(){Queue = new ArrayList<Q>();}
	
	//Creating enqueue and dequeue functions, the same as the stack with the exception of an index change
	public void enqueue(Q e){Queue.add(e);}
	public Q dequeue(){return Queue.remove(0);}
	
	//Creating methods to be used to get the size of the queue currently and to check if the queue is empty or not.
	public int size(){return Queue.size();}
	boolean isEmpty(){if (Queue.isEmpty()) {return true;} else return false;}
	
	// Creating methods to clear the current Queue and to peek at the first element in the queue
	void clear(){Queue.clear();}
	public Q peek(){return Queue.get(0);}
	
	//Creating methods to get the position of the specified element and to remove it.
	public int positionOf(Q e){return Queue.indexOf(e);}
	public void remove(Q e){Queue.remove(e);}
	
	// Get the first element in the queue at index 0.
	public Q first(){cursor = 0; return Queue.get(cursor);}
	
	//Get the next element in the queue, dependent on how many times "next" was called.
	public Q next() {cursor++; if (cursor < Queue.size()){ return Queue.get(cursor);}else{return null;}
	
	}
}
