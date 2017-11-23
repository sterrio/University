import java.util.Scanner;

// Assignment 4 Heap sort - Stephen Terrio B00755443 
public class HeapDemo3 {
	public static void main (String [] args){
		// creating the first heap
		Heap<String> Heap1 = new Heap<String>();
		// making scanner to read inputs
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter input into the first heap type 'done' when done: ");
		// getting the inputs
		String input = sc.next();
		// while there are still values to be added to the heap
		while (!input.toLowerCase().equals("done")){
			Heap1.add(input);
			// Get the next value
			input = sc.next();
		}
		// creating another heap.
		Heap<String> Heap2 = new Heap<String>();
		// making scanner to read inputs
		Scanner sc2 = new Scanner(System.in);
		System.out.print("Enter input into the second heap type 'done' when done: ");
		
		String input2 = sc2.next();
		
		// Same loop as before, just for the second heap
		while (!input2.toLowerCase().equals("done")){
			Heap2.add(input2);
			input2 = sc2.next();
		}
		// creating a new heap to store the merge of the other two.
		Heap <String> Heap3 = new Heap <String>();
		
		// merging the two heaps and printing one out 
		Heap3 = merge(Heap1,Heap2);
		Heap3.enumerate();
		
	}
	
	
	
	// Creating merge method.
	public static <T extends Comparable <T>> Heap<T> merge(Heap <T> heap1, Heap <T> heap2){
		
		// creating a new heap to merge the other two together.
		Heap <T> heap3 = new Heap <T>();
		// Set heap3 equal to heap 1.
		heap3 = heap1;
		// while the heap is not empty get it's max and add it to heap 3
		while (!heap2.isEmpty()){
			T temp = heap2.deleteMax();
			heap3.add(temp);
		}
		return heap3;
	}
}
