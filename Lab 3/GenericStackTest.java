//Lab 3 - Data Structures and Algorithms, October 1st, 2017. Stephen Terrio, B00755443.

public class GenericStackTest {
	
//Using code from the PDF to test my GenericStack class.
public static void main(String [] args){
		
		GenericStack<String> stack1 = new GenericStack<String>();
		
		stack1.push("London");
		stack1.push("Paris");
		stack1.push("Halifax");
		
		GenericStack<Integer> stack2 = new GenericStack<Integer>();
		stack2.push(1);
		stack2.push(2);
		stack2.push(3);
	}
}
