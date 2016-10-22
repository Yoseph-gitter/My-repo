package src.DataStructures;

public class TreeNode {
	
	private TreeNode left ;
	private TreeNode right ;
	private boolean isVisited = false;

	private int data ;
	
	
	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	
	public TreeNode(int data){
		this.left = null;
		this.right = null;
		this.data = data ;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	

}
