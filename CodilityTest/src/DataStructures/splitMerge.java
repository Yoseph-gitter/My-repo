package src.DataStructures;

import java.util.*;
public class splitMerge {

	public static void main(String[] args) {
        int[] arr = { 1,2 ,3, 4, 5 };
       int[] some =  splitAndMerge(arr);
       for(Integer x : some){
    	   System.out.print(x + "\t");
       }
	}
	
	public static int[] splitAndMerge(int[] someList){
		 
		   if(someList == null || someList.length == 0 )
		     return someList;
		     
		     Queue<Integer> q = new LinkedList();
		     Queue<Integer> p = new LinkedList();
		     
		     for(int k=0; k < someList.length ; k++)
		     {
		        if(k< someList.length/2 ){
		             q.add(someList[k]);
		          }
		          else 
		          {
		            p.add(someList[k]);
		             
		          }    
		     }
		     
		     int counter =-1 ; 
		     
		     while(! q.isEmpty()  && !p.isEmpty() ){
		     
		        someList[++counter] = q.remove();  
		        someList[++counter] = p.remove();  		            
		     }		     
		        
		     if(q.isEmpty())
		     {		     
		         while( !p.isEmpty() )
		          {
		           someList[++counter] = p.remove();        
		         }
		     }
		     else {
		        while( !q.isEmpty() )
		          {
		           someList[++counter] = q.remove();         
		         }		     
		     }
     return someList;
   }
}
