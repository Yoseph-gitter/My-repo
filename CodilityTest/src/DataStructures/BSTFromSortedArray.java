package src.DataStructures;

public class BSTFromSortedArray {
	
	private int[] sortedArray ;
	private static TreeNode root;
	private static BStTree bstTree = new BStTree(); ;
	
	public static void main(String[] args) throws Exception {
		int[]  arr = {1,3,4,6,7,8,9,15 };
		BSTFromSortedArray bst = new BSTFromSortedArray(arr);
		TreeNode thrRoot = bst.generateBST(0 , arr.length-1);
		bstTree.setRoot(thrRoot);	
		
		bstTree.printTreePreorder();		
		bstTree.printTreePreorderIterative();
		
		bstTree.printTreePostorderIterator();
		bstTree.printTreePostorder();
		
		bstTree.printTreeInorder();
		bstTree.printTreeInorderIterative();
		
	}
	public BSTFromSortedArray(int[] sortedArr){
		this.sortedArray = sortedArr;
		this.root = null;
		
	}
    
	public TreeNode generateBST(int start , int end){
				
		if(end < start)
		  return null;
		  
		  int mid = ( start + end )/2;		
		  TreeNode root = new TreeNode(sortedArray[mid]);
		
	      root.setLeft(generateBST( start , mid - 1));
		  root.setRight(generateBST( mid + 1, end));
		 
	  	return root;
				
	}
}
