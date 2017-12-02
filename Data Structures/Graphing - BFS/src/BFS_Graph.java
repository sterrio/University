// Lab 8 - Graphing, Dec. 1st - Stephen Terrio, B00755443 

import java.util.Scanner;
import java.io.*;
import java.util.HashMap;
import java.util.*;

public class BFS_Graph {
	public static void main (String [] args)throws IOException{
		
		// Getting inputs from input file.
		Scanner sc = new Scanner(System.in);
		String fileloc = sc.next();
		
		File file = new File(fileloc);
		Scanner reader = new Scanner(file);
		
		// Getting the amount of nodes in the graph
		int size = reader.nextInt();
		
		// creating a hash map to store values of the edges
		HashMap <String, Integer> map = new HashMap <String,Integer>();
		// creating a second map to search via integer values for the 2d array
		HashMap <Integer,String> mapSearch = new HashMap <Integer,String>();
		
		// Creating count to keep track of how many values were stored.
		int count = 0;
		
		//Creating the 2d array
		int [][] matrix = new int [size][size];
	
		// looping through the connections and putting each node into 
		while (reader.hasNext()){
			
			// Separating the connection
			String node = reader.next();
			String edge = reader.next();
			
			// if the node has not been accounted for, add it to the map and reverse add it to the search map
			if (!map.containsKey(node)){
				map.put(node, count);
				
				mapSearch.put(count,node);
				count++;
			}
			// if the edge has not been accounted for, add it to the map and reverse add it to the search map
			if (!map.containsKey(edge)){
				map.put(edge,count);
				mapSearch.put(count,edge);
				count++;
			}
			
			// Setting connections equal to 1 to state true from each side.
			matrix[map.get(node)][map.get(edge)] = 1;
			matrix[map.get(edge)][map.get(node)] = 1;
		}
		
		System.out.println(Arrays.deepToString(matrix));
		
		/* IMPORTANT
		* 
		*Order
		*E A B D C
		* 
		*/
		
		// Making a queue and result list to perform BFS searching and to store the results
		ArrayList <Integer> queue = new ArrayList <Integer>();
		ArrayList <Integer> results = new ArrayList <Integer>();
		
		// Adding source node to the queue
		queue.add(0);
		
		//While the queue is not empty
		while (!queue.isEmpty()){
			// get the current vertex
			int vertex = queue.get(0);
			// dequeue and add to result list
			results.add(queue.remove(0));
			
			// checking for vertices
			for (int i = 0; i < 5; i++){
				if (matrix [vertex][i] == 1){
					// if a vertices is found and it's not in the result or queue list, enqueue it
					 if (!queue.contains(i) && !results.contains(i)) {
						 queue.add(i);
					 }
				}
			}
		}
			
		// print result lists
		for (int i = 0; i < results.size(); i++){
			System.out.println(mapSearch.get(results.get(i)));
		}

	}
}
