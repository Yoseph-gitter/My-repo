package src.DataStructures;

public interface Heap<T> {
 
	void insert(T data)throws Exception;
	T delete() throws Exception;
}
