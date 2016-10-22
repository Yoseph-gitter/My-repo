package src.DataStructures;

public interface Tree {
	
	void insert(int value);
	void delete(int value);
	int search(int value) throws Exception;
	boolean searchRecurrsive(TreeNode treeNode, int value) throws Exception;

}
