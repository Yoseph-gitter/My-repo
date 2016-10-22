package DataStructures;

public class BitManipulator {

	public static void main(String[] args) {
		
		System.out.print(BitManipulator.multiplyWithBit(8)+ "   Done with = \t");
		System.out.println(BitManipulator.multiplyWithLogBoundTime(8)+ "   Done with = \t");
		System.out.println(BitManipulator.multiplyWithAddition(8)+ "   Done with = \t");
		

	}
	
	public static int multiplyWithBit(int n){
		return n << 3;
	}
    
	public static int multiplyWithAddition(int n){
		
		int initialValue = n;
		int counter = 0;
		while(++counter <= 8){
			n = n + initialValue;
			System.out.print(counter + "\t");
		}
		System.out.println("Iterations");
		return n;
	}
	
	public static float multiplyWithLogBoundTime(int n){
		
		int initialValue = 0;
		int counter =0;
		
		while(counter < log(8, 2)){
			n = n + n ;
			counter++;
			System.out.print(counter + "\t");
		}
		System.out.println("Iterations");
		
		return n;
	}
	
	public static double log(int value, int base){
		
		return Math.log(value)/Math.log(base);
	}
}
