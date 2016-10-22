package src.DataStructures;

import java.util.*;

public class BStTree implements Tree  {
   

	private TreeNode root ;
    
    public TreeNode getRoot() {
		return root;
	}  
    
    public void setRoot(TreeNode root) {
		this.root = root;
	}
   
	public BStTree(){
    	this.root = null ;
    }
	public static void main(String[] args) throws Exception {
		
		BStTree bst = new BStTree();
		int[] in = {6 ,8,9,10,11,13,17}; //{3, 4, 5, 6, 7, 8, 10 };
		int[] pre = {10,8,6,9,13,11,17}; //{ 3, 5, 4,  7, 6 , 10, 8  };
		int[] post = { 17 ,13, 11, 10, 9,	8,	6  };
		int[] singleton = {3 };
		int[] same = {2,2,2,2,2,2, 6 };
		int[] empty = new int[0];
		for(int vlaue : pre){
		bst.insertRecursive(vlaue);
 	 // bst.insert(vlaue);
		}
		bst.printTreeInorder();
		bst.printTreeInorderIterative();
		
	 // bst.generateBSTFromInorderAndProorder(in, pre, 0, in.length-1);
		long init = System.currentTimeMillis();
		bst.printTreePreorder();
		long after = System.currentTimeMillis();
		System.out.println("It takes this much in secondes " + (after - init));
		
		init = System.currentTimeMillis();
		bst.printTreePreorderIterative();
		
		
		bst.printTreePostorder();
		bst.printTreePostorderIterator();
		System.out.println("******" + bst.levelOrderTraversal());
				
		System.out.println(bst.getMimimum());
		
		System.out.println(bst.getMinimumRecursive());
		
		
		System.out.println("Is it BST : " + bst.isBST());
		System.out.println("Is it BST : " + bst.isBSTInorder());
		
		bst.reflectBST();
		bst.printTreeInorder();
		bst.printTreePostorder();
		after = System.currentTimeMillis();
		System.out.println("It takes this much in secondes " + (after - init));
		System.out.println(bst.levelOrderTraversal());
	}
	public void convertBSTtoMinHeap(TreeNode root, Queue<Integer> queue){
		//while doing inorder traversal as you visit the element swap it with what ever is on the queue
		
		
		
	}
	
	public boolean searchRecurrsive(int i) throws Exception {
		
		return this.searchRecurrsive(root, i);
	}
	public void insertRecursive(int data){
		this.root = insertRecursive(this.root, data);
	}
	private TreeNode insertRecursive(TreeNode rootNode, int data){
			
		if (rootNode == null)
			rootNode = new TreeNode(data);
		else if(data < rootNode.getData() )
			rootNode.setLeft(insertRecursive(rootNode.getLeft(), data));
		else 
			rootNode.setRight(insertRecursive(rootNode.getRight(), data));
		
		return rootNode;
	}
	
	
	@Override
	public void insert(int value) {
		if(root == null ){
			root =new  TreeNode(value);	
			return;
		}
		
	   TreeNode temp = root;
	   TreeNode prev = null;
		
		while(temp != null)
		{
		  prev = temp ;
			
		  if(value >= temp.getData() )
			  
			temp = temp.getRight();
		  else
			temp = temp.getLeft();				
		}
		
		if(prev.getLeft() == null && prev.getRight() != null){
			prev.setLeft(new TreeNode(value));			
		}			
		else if(prev.getRight() == null && prev.getLeft() != null){
		   prev.setRight(new TreeNode(value));
		}
		else{
			
			  if(value >= prev.getData() )
				  
				  prev.setRight(new TreeNode(value));
			  else
				  prev.setLeft(new TreeNode(value));	
		}
	}
	
	public void printTreeInorder() throws Exception{
		ArrayList<Integer> myInorderInitial = new ArrayList();
	    inorder(root, myInorderInitial);
		
		for(Integer X : myInorderInitial ){
			System.out.print(X + "\t");
		}
		System.out.println("Inorder Traversal Done ...");
	}
	
	public void printTreeInorderIterative() throws Exception{
		ArrayList<Integer> myInorderInitial = inorderIterative();	    
		
		for(Integer X : myInorderInitial ){
			System.out.print(X + "\t");
		}
		System.out.println("Inorder Recursive Traversal Done ...");
	}
	
	public void printTreePreorder() throws Exception{
		
		ArrayList<Integer> myInorderInitial = new ArrayList();
	    preOrderTraverse(root, myInorderInitial);
		
		for(Integer X : myInorderInitial ){
			System.out.print(X + "\t");
		}
		System.out.println("PreOrder Traversal Done ...");
	}
	
public void printTreePreorderIterative() throws Exception{
		
		ArrayList<Integer> myInorderInitial = preOrderIterative();	    
		
		for(Integer X : myInorderInitial ){
			System.out.print(X + "\t");
		}
		System.out.println("PreOrder Iterative Traversal Done ...");
	}
	
	public void printTreePostorder() throws Exception{
		
		ArrayList<Integer> myInorderInitial = new ArrayList();
	    postOrderTraverse(root, myInorderInitial);
		
		for(Integer X : myInorderInitial ){
			System.out.print(X + "\t");
		}
		System.out.println("Post order Traversal Done ...");
	}
	
   public void printTreePostorderIterator() throws Exception{
		
		ArrayList<Integer> myInorderInitial = postOrderIterative();
	    		
		for(Integer X : myInorderInitial ){
			System.out.print(X + "\t");
		}
		System.out.println("Post order Iterative Traversal Done ...");
	}
	
	@Override
	public void delete(int value) {
		
	}
	@Override
	public boolean searchRecurrsive(TreeNode treeNode , int value)  throws Exception{
		
		if(root == null) throw new Exception("BST is Null");
		
		if(treeNode == null)
			return false;		
		
		if(value == treeNode.getData())
			return true ;
		else if(value < treeNode.getData())
			return searchRecurrsive(treeNode.getLeft(), value);
		else 
			return searchRecurrsive(treeNode.getRight(), value);
		
	}
	public ArrayList<Integer> inorder() throws Exception{
		ArrayList<Integer> inorderList = new ArrayList<Integer>();
		inorder(root,inorderList);
		return inorderList; 
	}
	public void inorder(TreeNode node, ArrayList<Integer> inorderList ) throws Exception{
		
		if(node == null) 
			return ; // throw new Exception("Null Node");
		
		if(node.getLeft() == null && node.getRight() == null ){
			
	    	inorderList.add(node.getData());		
			return ;
			
		}
	    inorder(node.getLeft(), inorderList);
		inorderList.add(node.getData());
	    inorder(node.getRight(), inorderList);		
		
	}
	
	public void preOrderTraverse (TreeNode node, ArrayList<Integer> preorderList)throws Exception  {
		
		if(node == null ) 
			return ; // throw new Exception("Empty Tree!");
		
		//if node is a leaf save the node and return
		if(node.getLeft() == null && node.getRight() == null){
			preorderList.add(node.getData());
			return;
		}
		//else visit the node first and move to left end first and then right
		
		preorderList.add(node.getData());
		preOrderTraverse(node.getLeft(), preorderList);
		preOrderTraverse(node.getRight(), preorderList);
				
	}
	
	public void postOrderTraverse(TreeNode node , ArrayList<Integer> postOrderList)throws Exception{
		
		if(node == null ) 
			return ; // throw new Exception("Empty Tree");
		
		if(node.getLeft() == null && node.getRight() == null){
			postOrderList.add(node.getData());
			return;
		}
		
		postOrderTraverse(node.getLeft(), postOrderList);
		postOrderTraverse(node.getRight(), postOrderList);
		postOrderList.add(node.getData());
	}
	
		
	public void generateBSTFromInorderAndProorder(int[] in, int[] pre, int start, int end) throws Exception{
		int index = 0;
		
		generateBSTFromInorderAndProorder(root, in , pre , start , end, index);
	  
	}
		
	private void generateBSTFromInorderAndProorder(TreeNode rt, int[] in, int[] pre, int start, int end, Integer index)
	   throws Exception 
	{	
		if(index >= in.length)
			return;
		
		TreeNode newNode = new TreeNode(in[index]);
		 if(rt == null )
			rt = newNode ;
		 else {			
		 
			if(start == end ){				
			  if(end < start) 	end = start;
			}
			
			if(rt.getData() > in[start]){
				rt.setLeft(newNode);
				rt = rt.getLeft();
			}
			else{
				rt.setRight(newNode);
				rt = rt.getRight();
			}
			
		}		
		
	    int pivotInorder = pre[index];
	
		int newIndex = getInorderIndex(pivotInorder, in );
		    if(newIndex - 1 < 0 ) 
		    	newIndex = 1;
		    		
			generateBSTFromInorderAndProorder(rt.getLeft() ,in, pre, start, newIndex - 1, index + 1);
			
		    generateBSTFromInorderAndProorder(rt.getRight() , in, pre, newIndex + 1 ,end, index + 1);
		
	}
	private int getInorderIndex(int indexIn , int[] arr) {
		for(int k=0 ;k < arr.length ; k++){
			if(indexIn == arr[k])
				return k;
		}
		return -1;
	}
	@Override
	public int search(int value) throws Exception {
		
		if(root == null) 
			throw new Exception("Tree is Empty");
		
		TreeNode runner = root ;
		
		while(runner != null ){
			
			if(value == runner.getData())
				return runner.getData();
			
			else if(value < runner.getData())
				runner = runner.getLeft();					
			else 
				runner = runner.getRight();
		}
				
		return Integer.MIN_VALUE;
	}
	
	public int getMimimum() throws Exception {
		if(root == null) throw new Exception("Tree is Empty");
		
		TreeNode temp = root ;
		
		while(temp.getLeft() != null){
			temp = temp.getLeft();
		}
		
		return temp.getData();
	}
	private TreeNode getMinimumRecursive(TreeNode rootNode, TreeNode minNode) throws Exception{
		
		if(rootNode == null ) throw  new Exception("Empty Tree");
		
		if(rootNode.getLeft() == null ) 
			return rootNode;		 
		
		return getMinimumRecursive(rootNode.getLeft(), rootNode);
		
	}
	
	public int getMinimumRecursive() throws Exception{
		TreeNode min = getMinimumRecursive(this.root, null);
		return min.getData();
	}
	
	public boolean isBST(){
		return isBST(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isBST(TreeNode root, int min, int max){
		
		if(root == null )
			return true;
		
		if(root.getData() < min || root.getData() >= max)
			return false;
		
		return	 isBST(root.getLeft(), min, root.getData()) &&
				 isBST(root.getRight() , root.getData(), max);
	 
	}
	private boolean isBSTInorder(TreeNode root){
		if(root == null)
			return true;
		boolean l = isBSTInorder(root.getLeft());
		if(root.getLeft() != null && root.getLeft().getData() >  root.getData()){
			return false;
		}
		boolean r = isBSTInorder(root.getRight());
		
		return l && r;
	}
	
	public boolean isBSTInorder(){
		return isBSTInorder(root);
	}
	
	private TreeNode reflectBST(TreeNode root ){
		if(root == null)
			return root;
		TreeNode temp = root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(temp);
		
		root.setLeft(reflectBST(root.getLeft()));
		root.setRight(reflectBST(root.getRight()));
			
		return root;
		
	}
	
	public void reflectBST() throws Exception{
		this.root = reflectBST(root);
		
	}
	public ArrayList<Integer> inorderIterative(){
		if(root == null)
			return null;
		ArrayList<Integer> list = new ArrayList();
		Stack<TreeNode> stk = new Stack<>();
		
		stk.push(root);
		TreeNode temp = root ;
		
		while(! stk.isEmpty()){
			//go to the left end of the BST
			while(temp != null){
				if(temp.getLeft() == null)
					break;
				temp = temp.getLeft();
				stk.push(temp);
			}
			//once you are there start poping and check if the poped Node has a right child
			temp = stk.pop();
			list.add(temp.getData());
			
			temp = temp.getRight();
			if(temp != null)
				stk.push(temp);
			
		}
		return list;
	}
	
	public ArrayList<Integer>  preOrderIterative(){
		if(root == null)
			return null;
		ArrayList<Integer> preOrderList = new ArrayList();
		Stack<TreeNode>  stk = new Stack();
		
		TreeNode temp = root;		
		stk.push(temp);
		preOrderList.add(temp.getData());
		
		while(! stk.isEmpty()){
			//proceed to the left and push to stack as you go and to the list
			while(temp != null){
				if(temp.getLeft() == null )
					break;
				temp = temp.getLeft();
				stk.push(temp);
				preOrderList.add(temp.getData());
			}
			//once on the left most node pop stk and check if it has right node 
			//if so get right child and continue the loop as long as stk is not empty
			temp = stk.pop();
			temp = temp.getRight();
			if(temp != null )
			{  
				stk.push(temp);
				preOrderList.add(temp.getData());
			}
		}
		
		return preOrderList;
	}
    
	public ArrayList<Integer>  postOrderIterative(){

		if(root == null )
			return null ;
		ArrayList<Integer> postList = new ArrayList();
		Stack<TreeNode> stk = new Stack();
		
		TreeNode temp = root;
		stk.push(temp);
		
		while(!stk.isEmpty()){
			//go to left end 
			while(temp != null){
				if(temp.getLeft()== null)
					break;
				temp = temp.getLeft();
				stk.push(temp);
			}
			
			//peek from stk and set isVisited = true, make sure if there is right child
			
			temp  = stk.peek();
			temp = temp.getRight();
			
			if(temp != null && temp.isVisited() == true ){
				TreeNode pop = stk.pop();
				pop.setVisited(true);
				postList.add(pop.getData());
			}
			
			else if(temp != null){
				stk.push(temp);
			}
			else {
				TreeNode pop =	stk.pop();
				pop.setVisited(true);
				postList.add(pop.getData());
			}
			
		}
 		
		return postList;
	}
    
	public String  levelOrderTraversal(){
		if(root == null) 
			return null;
		
		StringBuilder levels = new StringBuilder();
		
		Queue<TreeNode>  que = new LinkedList();
		
		TreeNode temp = root;		
		que.add(temp);
		levels.append(temp.getData() + "\t\n");
		TreeNode prev = null;
		
		while(! que.isEmpty()){
			temp = que.peek();
			if(temp.getLeft() != null)
			{
				que.add(temp.getLeft());
				levels.append(temp.getLeft().getData() + "\t");
			}
			if(temp.getRight() != null)
			{
				que.add(temp.getRight());
				levels.append(temp.getRight().getData()+ "\t");							
			}				
			TreeNode removed = que.remove();
			if(!que.isEmpty() && removed.getData() > que.peek().getData()){
				levels.append("\n");
			}
		}
		levels.append("Level Order Traversal: \t" );
 		
		return levels.toString();
	}
	
}

