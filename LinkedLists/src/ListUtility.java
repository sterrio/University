// Lab 4 - Linked Lists, October 14th, 2017, Stephen Terrio

public class ListUtility {
	
	// Finding all new objects in list 1 and 2, and adding them to list 3
	public static <T> List<T> findUnion(List<T> list1, List<T> list2){
		// creating a new list to hold objects
		List <T> list3 = new List<T>();
		
		//Setting a cursor to keep position in the list
		T cursor = list1.first();
		
		//looping through the list and checking if the item was repeated, if not - add it to list 3
		while (cursor != null){
			if(!list3.contains(cursor)); list3.add(cursor);
		}
		
		// looping through the list and checking if the item was repeated, if not - add it to list 3
		cursor = list2.first();
		while (cursor !=null){
			if(!list3.contains(cursor)); list3.add(cursor);
		}
		
		// returning our new list.
		return list3;
		
		}
	
	// Finding all objects that are both in list 1 & 2, without duplicates.
	public static <T> List<T> findIntersection(List<T> list1, List<T> list2){
		
		//Creating a third list to store the values.
		List <T> list3 = new List<T>();
		
		//Creating a cursor for position
		T cursor = list1.first();
		
		// Checking if list3 hasn't found cursor yet and if list 2 contains it.
		while(cursor != null){
			if(!list3.contains(cursor) && list2.contains(cursor)); list3.add(cursor);
		}
		
		// Returning our new list.
		return list3;	
	}
	
	//Creating and returning a third list that contains the items in list1 interleaved with the items in list2.
	public static <T> List<T> interleave(List<T> list1, List<T> list2){
		
		List <T> list3 = new List<T>();
		
		//Creating two cursors, to keep track of positions in both list 1 & 2
		T cursor = list1.first();
		T cursor2 = list2.first();
		
		// While the cursor 1 is not null, add - if 2 isn't either, add. Increment both
		while (cursor != null){
			
			list3.add(cursor);
			if (cursor2 != null); list3.add(cursor2);
			
			cursor = list1.next();
			cursor2 = list2.next();
		}
		
		// If list 2 still isn't null, add
		while(cursor2 != null){
			list3.add(cursor2);
		}
		
		return list3;
	}
	
	//Creating and returning a list that has the items in list1 with every second item removed.
	public static <T> List<T> chopSkip(List<T> list1){
		
		//Creating a list to store values for the new one.
		List <T> list2 = new List<T>();
		
		// Creating yet another cursor object (if you don't know what this does yet - I'm concerned)
		T cursor = list1.first();
		
		while(cursor != null){
			list2.add(cursor);
			
			// Skipping past the next object
			cursor = list1.next();
			cursor = list1.next();
			
		}
		// Returning the new list filled with objects.
		return list2;
	}
}
