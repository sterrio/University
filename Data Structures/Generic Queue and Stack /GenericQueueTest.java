import java.util.ArrayList;

public class GenericQueueTest{
	public static void main(String [] args){
		
		 GenericQueue<String> Q = new GenericQueue<String>();
		 
		 Q.enqueue("hey");
		 Q.positionOf("hey");
		System.out.println(Q.peek());
		 Q.isEmpty();
	}
}
