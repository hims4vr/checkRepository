package testpackage.geeks.stack;

import java.util.Stack;

public class MyStackWithMin {

	private Stack<Integer> stk = new Stack<Integer>();
	private int minElement = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		
		MyStackWithMin myWithMin = new MyStackWithMin();
		myWithMin.push(100);
		myWithMin.push(105);
		myWithMin.push(95);
		
		System.out.println(myWithMin.getMin());
		
		myWithMin.push(110);
		myWithMin.push(90);
		myWithMin.push(120);
		
		System.out.println(myWithMin.getMin());
		
		myWithMin.push(80);
		myWithMin.push(130);
		
		System.out.println(myWithMin.getMin());
		myWithMin.push(150);
		myWithMin.push(85);
		
		System.out.println(myWithMin.getMin());
		
		System.out.println(myWithMin.pop());		
		System.out.println(myWithMin.getMin());
		
		System.out.println(myWithMin.pop());		
		System.out.println(myWithMin.getMin());
		
		System.out.println(myWithMin.pop());		
		System.out.println(myWithMin.getMin());
		
		System.out.println(myWithMin.pop());		
		System.out.println(myWithMin.getMin());
		
		System.out.println(myWithMin.pop());		
		System.out.println(myWithMin.getMin());
		
		System.out.println(myWithMin.pop());		
		System.out.println(myWithMin.getMin());
		
		System.out.println(myWithMin.pop());		
		System.out.println(myWithMin.getMin());
		
		System.out.println(myWithMin.pop());		
		System.out.println(myWithMin.getMin());
		
		System.out.println(myWithMin.pop());		
		System.out.println(myWithMin.getMin());
		
		System.out.println(myWithMin.pop());		
		System.out.println(myWithMin.getMin());
		
		System.out.println(myWithMin.pop());		
		System.out.println(myWithMin.getMin());

	}

	public void push(int elem) {
		if(stk.isEmpty()) {
			stk.push(elem);
			minElement = elem;
		}
		else if(elem < minElement) {
			stk.push((2*elem)-minElement);
			minElement = elem;
		}else {
			stk.push(elem);
		}
	}

	
	public Integer pop() {
		System.out.println("poping");
		int temp = stk.peek();
		
		if(temp>=minElement) {
			return stk.pop();
		}else {
			temp = minElement;
			minElement = (2*minElement) - stk.pop();
			return temp;
		}
	}
	
	public int getMin() {
		System.out.println("minmum");
		return minElement;
	}
	
}
