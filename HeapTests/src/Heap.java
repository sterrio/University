// Assignment 4 Heap sort - Stephen Terrio B00755443 

import java.util.ArrayList;

public class Heap<T extends Comparable<T>>
{
	ArrayList<T> heapList;
	
	public Heap()
	{
		heapList = new ArrayList<T>();
	}
	
	public int size()
	{
		return heapList.size();
	}
	
	public boolean isEmpty()
	{
		return heapList.isEmpty();
	}
	
	public void clear()
	{
		heapList.clear();
	}
	public void enumerate()
	{
		System.out.println(heapList);
	}
	
	public void add(T item)
	{
		heapList.add(item);
		
		int index = heapList.size()-1;
		int pindex = (index-1)/2;
		T parent = heapList.get(pindex);
		
		while (index>0 && item.compareTo(parent)>0)
		{
			heapList.set(index, parent);
			heapList.set(pindex, item);
			index = pindex;
			pindex = (index-1)/2;
			parent = heapList.get(pindex);
		}
	}
	
	public T deleteMax()
	{
		if (isEmpty())
		{
			System.out.println("Heap is empty");
			return null;
		}
		
		else
		{
			T ret = heapList.get(0);	//get the item in the root. This is the largest item.
			
			T item = heapList.remove(heapList.size()-1);	//remove the last item.
			
			if (heapList.size()==0)
				return ret;						//if there was only one item in the heap to begin with, we are done.
				
			heapList.set(0, item);			//otherwise, proceed. Put the item in the root.
			int index, lIndex, rIndex, maxIndex;
			T maxChild;
			boolean found=false;
			index = 0;
			lIndex = index*2+1;
			rIndex = index*2+2;
			
			while (!found)
			{
				if (lIndex<size()&&rIndex<size())	//case 1: item to be sifted down has two children
				{
					//find the maxChild and maxIndex
					if (heapList.get(lIndex).compareTo(heapList.get(rIndex))>0)
					{
						maxChild = heapList.get(lIndex);
						maxIndex = lIndex;
					}
					else
					{
						maxChild = heapList.get(rIndex);
						maxIndex = rIndex;
					}
					
					//sift down if necesssary
					if (item.compareTo(maxChild)<0)
					{
						heapList.set(maxIndex, item);
						heapList.set(index, maxChild);
						index = maxIndex;
					}
					else
						found = true;
				}
						
				else if (lIndex < size()) //case 2: item to be sifted down has only left child
				//note: item to be sifted down cannot have only right child - it will violate the complete binary tree property
				{
					if (item.compareTo(heapList.get(lIndex))<0)
					{
						heapList.set(index, heapList.get(lIndex));
						heapList.set(lIndex,item);
						
						index = lIndex;
					}
				
					else
						found = true;
				}
				else //case 3: item to be sifted down has no children
					found = true;
						
				lIndex = index*2+1;
				rIndex = index*2+2;
			}
			return ret;
		}

	}			
	
	// Finding the Minimum value in the array List
	public T findMin(){
		// if the heap has no values, return null
		if (isEmpty()){
			return null;
		}
		
		// If there's only one or two nodes, return respective node.
		if (size() < 3){return heapList.get(size()-1);}
		
		// Setting the smallest to the first leaf node
		T smallest = heapList.get((size()/2) + 1);
		
		// If there's only 3 nodes, start at 1 instead
		if(size() == 3){
			smallest = heapList.get(1);
		}
		
		// checking all other leaf nodes
		for (int i = (size()/2) + 1; i < size(); i ++ ){
			// if the current leaf is smaller than the smallest leaf, set it as smallest
			if (heapList.get(i).compareTo(smallest) < 0){
				smallest = heapList.get(i);
			}
		}
		// return the smallest leaf node.
		return smallest;
	}

	// dequeuing the smallest value and re-organizing the heap.
	public T dequeueMin(){
		// if the heap has no values return null.
		if (isEmpty()){
			return null;
		}else {
			
			if(size() < 2){
				T temp = heapList.get(size() - 1);
				heapList.remove(size() - 1);
				return temp;
			}
			
			// getting the smallest value
			T removed = findMin();
			int index = heapList.indexOf(removed);
	
			
			// Replacing the recently removed with the last element
			T last = heapList.get(heapList.size() - 1);
			// Saving the index of the removed minimum to be used to re organize.
			T lost  = heapList.get(index);
			
			heapList.set(index , last);
			heapList.remove(heapList.size() - 1);
					
			// sift and re organize
			// If the current key is greater than the parent key, switch
			while (((Comparable <T>) heapList.get(index )).compareTo(heapList.get(((index -1)/2))) > 0){
				
				int indexTemp = (index - 1)/2;
				T switched = heapList.get(indexTemp);
				// Setting the key to the parent
				heapList.set(indexTemp, heapList.get(index));
				//setting the parent to the key
				heapList.set(index, switched);
				// Setting the new index.
				index = indexTemp;
			}
			
			return removed;
		}

	}
}