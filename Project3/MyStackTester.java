package uga.csci1302.test;

import uga.csci1302.myStack.*;
import org.junit.*;
import static org.junit.Assert.*;
//import java.util.*;

/**
 * Test the stack class using JUnit
 * @author Rohan Malik
 */
public class MyStackTester {

Stack<Integer> stack;

@Before
public void setUp(){
	stack = new Stack<Integer>();
}

@Test
public void testPushOne(){
	stack.push(20);
	stack.push(15);
	stack.push(90);
	int a = stack.pop();
	stack.push(500);
	assertTrue(stack.pop() == 500);
	assertTrue(stack.pop() == 15);
	assertTrue(stack.pop() == 20);
}

@Test
public void testPushTwo(){
	stack = new Stack<Integer>(2);
	stack.push(20);
	stack.push(30);
	boolean caught = false;
	try {
		stack.push(9);
	} catch(FullStackException e){
		caught = true;	
	}
	assertTrue(caught);
}

@Test
public void testPopOne(){
	stack.push(5);
	stack.push(10);
	stack.push(20);
	assertTrue(stack.pop() == 20);
}

@Test
public void testPopTwo(){
	int a = 0;
	try{
		a = stack.pop();	
	} catch(EmptyStackException e) {
		a = 9;
	}
	assertTrue(a == 9);
}

@Test
public void testPeek(){
	stack.push(94);
	assertTrue(stack.peek() == 94);
}

@Test
public void testEmpty(){
	assertTrue(stack.isEmpty());
	stack.push(900);
	assertFalse(stack.isEmpty());
}

@Test
public void testFull(){
	stack = new Stack<Integer>(2);
	assertFalse(stack.isFull());
	stack.push(900);
	stack.push(5);
	assertTrue(stack.isFull());
}

@Test
public void testString(){
	stack.push(90);
	stack.push(400);
	assertTrue(stack.toString().length() > 0);
}

/**
 * Main method that runs the JUnit runner
 * @param args main method string array
 */
public static void main(String[] args) {
	org.junit.runner.JUnitCore.main("uga.csci1302.test.MyStackTester");
}

}
