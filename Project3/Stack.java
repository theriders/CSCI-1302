package uga.csci1302.myStack;

import java.util.ArrayList;

/**
 * an array implementation of a Stack
 * @author Rohan Malik
 */
public class Stack<T> implements StackADT<T> {

	private final int DEFAULT_CAPACITY = 100;
	private int top;
	private ArrayList stack;
	private int capacity;

	/**
         * Creates a stack of specified capacity
         * @param size the capacity of the stack
         */ 		
	public Stack(int size)
	{
		stack = new ArrayList<T>(size);
		top = -1;
		capacity = size;
	}

	/**
         * Creates a stack of default capacity
         */
	public Stack() {
		stack = new ArrayList<T>(DEFAULT_CAPACITY);
		top = -1;
		capacity = DEFAULT_CAPACITY;	
	}

	public void push(T element) {
		if (stack.size()  == capacity) {
			throw new FullStackException();
		}
		top++;
		stack.add(top,element);
	}

	public T pop() {
		if (stack.size() == 0) {
			throw new EmptyStackException();
		}
		top--;
		return (T) (stack.remove(top + 1));	
	}

	public T peek(){
		if (stack.size() == 0) {
			throw new EmptyStackException();
		}
		return (T) (stack.get(top));	
	}

	public boolean isEmpty(){
		return (stack.size() == 0);
	}

	public boolean isFull(){
		return (stack.size() == capacity);
	}

	public int size() {
		return stack.size();
	}
	
	/**
         * Doubles the capacity of the stack
         */ 	
	public void expandCapacity() {
		capacity = capacity * 2;
		stack.ensureCapacity(capacity);
	}

	public String toString(){
		String toReturn = "Size: " + stack.size() + " \n";
		for(int x = 0; x < stack.size(); x++) {
			toReturn = toReturn + stack.get(x).toString() + " --> ";
		}
		toReturn = toReturn.substring(0,toReturn.length() - 5);
		return toReturn;
	}
  
}
