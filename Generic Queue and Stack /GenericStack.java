//Lab 3 - Data Structures and Algorithms, October 1st, 2017. Stephen Terrio, B00755443.

import java.util.ArrayList;

public class GenericStack<T> {
	
	// Creating a new array list of a generic type called Stack.
	private ArrayList<T> stack;
	// Initializing GenericStack so methods can be called.
	public GenericStack(){stack = new ArrayList<T>();}
	
	//Returns the last value in the stack.
	public T peek(){return stack.get(stack.size()- 1);}
	//Removes and returns the last value in the stack
	public T pop(){return stack.remove(stack.size()- 1);}
	//Adds a generic element to the top of the stack
	public void push(T e) {stack.add(e);}
	//Returns the current length of the stack.
	public int getSize() {return stack.size();}
	//Returns true if the stack is currently empty.
	public boolean isEmpty() {if (stack.isEmpty()) {return true;} else return false;}
}

