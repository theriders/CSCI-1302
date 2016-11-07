package uga.csci1302.test;

import uga.csci1302.myStack.*;

public class stacktest {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(90);
		stack.push(400);
		System.out.println(stack.toString());
	}
}
