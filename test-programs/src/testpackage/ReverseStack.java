package testpackage;

import java.util.ListIterator;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReverseStack {
	
//	ReentrantReadWriteLock
//	ConcurrentHashMap<K, V>

	static void reverse(Stack<Integer> s) {
		
		if(!s.isEmpty()) {
			int temp = s.pop();
//			System.out.println(temp);
			reverse(s);
			insertAtBottom(s,temp);
		}
	}

	private static void insertAtBottom(Stack<Integer> s, int temp) {
		
//		System.out.println("---------------"+temp);

		if(s.isEmpty())
			s.push(temp);
		else {
			int tt = s.pop();
			insertAtBottom(s, temp);
			s.push(tt);
		}
		
		
	}
	
	public static void main(String[] args) {
		
		Stack<Integer> ss = new Stack<Integer>();
		ss.push(1);
		ss.push(2);
		ss.push(3);
		ss.push(4);
		ss.push(5);
	
		printStack(ss);
		
		reverse(ss);
		printStack(ss);
	}
	

	// Utility Method to print contents of stack
	static void printStack(Stack<Integer> s) {
		ListIterator<Integer> lt = s.listIterator();

		// forwarding
		while (lt.hasNext())
			lt.next();

		// printing from top to bottom
		while (lt.hasPrevious())
			System.out.print(lt.previous() + " ");
	
		System.out.println();
	}


	
	
}
