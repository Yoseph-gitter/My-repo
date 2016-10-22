package src.DataStructures;

import org.testng.annotations.Test;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;

public class BStTreeTest {
  
  private BStTree bst ;
  
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }
  
  @BeforeMethod
  public void BeforeMethode(){
	  bst = new BStTree();
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[]{10},
      new Object[]{8},
      new Object[]{6}, 
      new Object[]{9} , 
      new Object[]{13}, 
      new Object[]{11}, 
      new Object[]{17}   
    };
  }

  @Test(dataProvider ="dp" , dependsOnMethods="insert")
  public void inorder(int someValue) throws Exception {
	  ArrayList<Integer> list = bst.inorder();
	  for(int x: list){
		  System.out.print("Inorder list of    : " + x + "\t");
		  Assert.assertEquals(x,someValue);
	  }
	 
	}

  @Test(dataProvider ="dp")
  public void insert(int someValue) {  
	 bst.insert(someValue);
	 System.out.println("some value is printed: " + someValue);
  }

  @Test
  public void insertRecursive() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void postOrderTraverse() {
   // bst.inorder(node, inorderList);
  }

  @Test
  public void preOrderTraverse() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void search() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void searchRecurrsive() {
    throw new RuntimeException("Test not implemented");
  }
}
