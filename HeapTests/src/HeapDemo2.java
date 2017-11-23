import java.util.Scanner;
import java.io.*;

// Assignment 4 Heap sort - Stephen Terrio B00755443 
public class HeapDemo2 {
	public static void main(String [] args)throws IOException{
		
		Heap<String> myHeap = new Heap<String>();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the location of you text file: ");
		String location = sc.nextLine();
		
		File file = new File(location);
		Scanner reader = new Scanner(file);
		PrintWriter writer = new PrintWriter("Output.txt");
		
		while (reader.hasNext()){
			myHeap.add(reader.next());
		}
		
		while (!myHeap.isEmpty()){
			String temp = myHeap.deleteMax();
			writer.println(temp);
		}
		writer.close();
	}
}
