package java8;
/**
 * To solve the diamond problem 2 solutions
 * Solution 1 - You need to overwrite the methode at your concrete class
 * Solution 2 - change any one interface (Poet/Write) method to static 
 * 
 * output will be default method only
 * @author Yogesh Badgujar
 * email me in case any problem - badgujar.yogesh@gmail.com
 */
interface Poet {
	//Solution  1 - write same method which written in Writer interface
	static void write() {
		System.out.println("Poet's default method");
	}
}

interface Writer {
	default void write() {
		System.out.println("Writer's default method");
	}
}

public class DiamondProblem implements Poet, Writer {
	
	//Solution 1 - You need to overwrite the methode at your concrete class
	//Un-comment below
	//public void write() {
	//	System.out.println("DiamondProblem default method");
	//}
	public static void main(String args[]) {
		DiamondProblem john = new DiamondProblem();
		john.write();
	}
}
