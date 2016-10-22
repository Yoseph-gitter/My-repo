package src.DataStructures;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Currency;

public class MinHeap<T> implements Heap<T>{
	
	private T[] buffer = null;
	private int currIndex = -1;
	private Comparator<T> comparator = null;
	
	private static final int DEFAULT_BUFFER_SIZE = 100;
	
	public MinHeap(Class<T[]> theType, Comparator<T> comp) {
		
		this.buffer = theType.cast(Array.newInstance(theType.getComponentType(),DEFAULT_BUFFER_SIZE ));
		this.comparator = comp;
	}
	
	public MinHeap(Class<T[]> theType, int size, Comparator<T> comp){
		
		this.buffer= theType.cast(Array.newInstance(theType.getComponentType(),size));
		this.comparator = comp;
	}

	@Override
	public void insert(T data) throws Exception {
		if(currIndex >= buffer.length)
			throw new Exception("Heap is Full");
		//we have so we can insert data
		buffer[++currIndex] = data;
		trickleUp(currIndex);
		
	}

	@Override
	public T delete() throws Exception{
		if(currIndex == -1)
			throw new Exception("Can not delete an empty Heap");
		T deletedData = buffer[0];
		buffer[0] = buffer[currIndex];
		buffer[currIndex] = null;
		currIndex--;
		if(currIndex != -1){
		 trickleDown();
		}
		return deletedData;
	}
	
	private void trickleUp(int insertedIndex){
		
		int parentIndex ;
		
		do{	
			parentIndex = (int) Math.ceil(insertedIndex/2);
			
		  if( comparator.compare(buffer[(int) insertedIndex], buffer[parentIndex]) == -1)
		  {
			  
			  swap(parentIndex, (int) insertedIndex);			
		   }
		  else
		  {
			  break;//no need to trickle up as the inserted value is greater than the parent
		  }
			  
		  insertedIndex = parentIndex;
		  
		} while(parentIndex >= 0);
	}
	
	private void trickleDown(){
				
		int parentIndex = 0;
		int leftChild = -1, rightChild= -1;
		
		while( parentIndex < currIndex ){
			
			leftChild = 2*parentIndex + 1;
			rightChild = 2*parentIndex + 2; 
			
			if(rightChild > currIndex && leftChild > currIndex )
   				break;
			
			else if(rightChild > currIndex && comparator.compare(buffer[leftChild], buffer[parentIndex]) == -1 )
			  {
				swap(leftChild, parentIndex);
				parentIndex = leftChild;
			  }
			else
			{
			  Integer min = Math.min((int)buffer[leftChild], (int)buffer[rightChild]);
			
			   if(comparator.compare(buffer[leftChild], (T) min) == 0 && comparator.compare(buffer[leftChild], buffer[parentIndex]) == -1 ){
				
			    swap(leftChild, parentIndex);
				parentIndex = leftChild;
			   }
			  else if(comparator.compare(buffer[rightChild], (T) min) == 0 && comparator.compare(buffer[rightChild], buffer[parentIndex]) == -1 ){
				swap(rightChild, parentIndex);
				parentIndex = rightChild;
			   }
			}
				
		}//end of while loop
		
	}

	private void swap(int t, int t2) {
		
		T temp = buffer[(int) t];
		buffer[(int) t] = buffer[(int) t2];
		buffer[(int) t2] = temp;
	}
	private int log(int x, int base)
	{
	    return (int) (Math.log(x) / Math.log(base));
	}
	
	public void printFormattedHeap(){
		if(currIndex == -1){
			System.out.println("Empty Heap to print....");
			return;
		}
		else if(currIndex == 0){
			System.out.println(buffer[currIndex] + "######");	
	        return ;
		}
				int current =0; 
		
		int height = log(currIndex, 2) + 1;
		int currHeight = 0 ;
		int k=0 ;
		while( k <= currIndex){
			
			while(current < Math.pow(2, currHeight ) && currHeight <=height) {
				if(k + current <= currIndex){
					System.out.print(buffer[k + current]);
				}
				else
					break;
				current++;
			}
			k = current + k;
			currHeight++;
			current =0;
			System.out.println("######");			
		}
	}
	public static void main(String[] args) throws Exception{
		
		Comparator<Integer> comp = new IntComparator();
		MinHeap<Integer> mnHeap = new MinHeap<>(Integer[].class, 7, comp);
//		mnHeap.insert(7);
//		mnHeap.insert(6);
//		mnHeap.insert(5);
//		mnHeap.insert(4);
	    mnHeap.insert(3);
        mnHeap.insert(2);
		mnHeap.insert(1);
		mnHeap.delete();
		
		mnHeap.printFormattedHeap();
		
	}	
}
class IntComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer x, Integer y) {
		if(x.compareTo(y)== -1) 
			return -1;
		else if(x.compareTo(y) == 1)
		    return 1;
		return 0;
		
	}		
}
