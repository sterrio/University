import java.util.Scanner;
import java.io.*;

// Assignment 4 Heap sort - Stephen Terrio B00755443 
public class HeapDemo2 {
	public static void main(String [] args)throws IOException{
		// creating a heap and scanner to take in and save inputs
		Heap<String> myHeap = new Heap<String>();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the location of you text file: ");
		String location = sc.nextLine();
		
		//Getting the file location to read inputs.
		File file = new File(location);
		// Creating a scanner to read the file.
		Scanner reader = new Scanner(file);
		// Creating a writer to make the output text file.
		PrintWriter writer = new PrintWriter("Output.txt");
		
		// While there is another word input add it to the heap
		while (reader.hasNext()){
			myHeap.add(reader.next());
		}
		// While the heap isn't empty - delete the current max and print it into a file.
		while (!myHeap.isEmpty()){
			String temp = myHeap.deleteMax();
			writer.println(temp);
		}
		// Closing the writer
		writer.close();
	}
}
