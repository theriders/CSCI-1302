import java.io.Serializable;
/**
 * A sorted doubly linked list
 * @author Rohan Malik
 *
 * @param <T>
 */
public class SortedDblList<T extends Comparable<? super T>> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int size;
	private DoublyNode<T> head;
	
	/**
	 * Creates a SortedDblList object
	 */
	public SortedDblList() {
		head = null;
		size = 0;
	}

	/**
	* Returns the element at the specified position in this list.
	* @param index index of element to return.
	* @return the element at the specified position in this list.
	* @throw IndexOutOfBoundsException  if the index is out of range (index < 0 || index >= size()). 
	*/
	public T get(int index){
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		if(head == null){
			return null;
		}
		DoublyNode<T> temp = head;
		for(int x = 0; x < index; x++) {
			temp = temp.getNext();
		}
		return (T) temp.getData();	
	}
	
	/**
	* The add method will take an instance of the type variable T as the parameter element, 
	* and it will insert it at the correct place within the list using element's compareTo method. 
	* @param element object to be added to list
	* @return true if object was added
	*/
	public boolean add(T element){
		if(element == null){
			return false;
		}
		DoublyNode<T> toAdd = new DoublyNode<T>(element);
		boolean added = false;
		if(size == 0) {
			head = toAdd;
			size++;
			return true;
		}
		if(head.getData().compareTo(element) > 0){
			toAdd.setNext(head);
			head.setPrev(toAdd);
			head = toAdd;
			size++;
			return true;
		} else if(head.getData().compareTo(element) == 0){
			return false;
		}
		DoublyNode<T> curr = head;
		for(int x = 0;(x < size) && (curr.getData().compareTo(element) < 0); x++){
			if(curr.getNext() == null){
				curr.setNext(toAdd);
				toAdd.setPrev(curr);
				size++;
				return true;
			}
			curr = curr.getNext();
			if(curr.getData().compareTo(element) == 0){
				return false;
			}
			if(curr.getData().compareTo(element) > 0){
				toAdd.setNext(curr);
				toAdd.setPrev(curr.getPrev());
				curr.getPrev().setNext(toAdd);
				curr.setPrev(toAdd);
				size++;
				return true;
			}
		}
		return added;
	}
	
	/**
	* The remove method removes the first item with its id matching the ID value of the parameter o, 
	* and returns true if this list contained the specified element.
	* @param o the object to be removed
	* @return false if object is not found
	*/
	public boolean remove(Object o){
		DoublyNode<T> curr = head;
		boolean toReturn = false;
		if(size == 1 && curr.getData().equals(o)){
			size--;
			head = null;
		}
		for(int x = 0; x < size; x++){
			if(curr.getData().equals(o)){
				if(curr.getNext() == null){
					curr.getPrev().setNext(null);
					curr.setPrev(null);
				} else if(curr.getPrev() == null){
					head = curr.getNext();
					head.setPrev(null);
				}else{
				curr.getNext().setPrev(curr.getPrev());
				curr.getPrev().setNext(curr.getNext());
				curr.setNext(null);
				curr.setPrev(null);
				}
				size--;
				toReturn = true;
			}
			curr = curr.getNext();
		}
		return toReturn;
	}
	
	/**
	* The isEmpty method returns whether or not the list is empty (true or false) 
	* @return true if the list is empty
	*/
	public boolean isEmpty(){
		return (size == 0);
	}

	/**
	* The merge method returns a new SortedDblList that is the union of the current list 
	* and otherList while maintaining sortedness.
	* @param otherlist the list to be merged to the current list
	* @return a new list
	*/
	public SortedDblList<T> merge(SortedDblList<? extends T> otherlist){
		SortedDblList<T> temp = new SortedDblList<T>();
		for(int x = 0;x < size; x++){
			temp.add(get(x));
		}
		for(int j = 0; j < otherlist.size(); j++){
			temp.add(otherlist.get(j));
		}
		return temp;
	}
	
	/**
	* The isPrefix method returns true if the current Linked list is a prefix of the otherList.
	* @param otherlist list to check prefix against
	* @return true if a prefix
	*/
	public boolean isPrefix(SortedDblList<? extends T> otherlist){
		if(this.size() > otherlist.size || this.size() == 0)
			return false;
		boolean prefix = false;
		DoublyNode<T> temp = head;
		for(int x = 0; x < this.size(); x++){
			prefix = temp.getData().equals(this.get(x));
			if(!prefix)
				return prefix;
			temp = temp.getNext();
		}
		return prefix;
		
	}
	
	/**
	 * The printList method will print all elements of the list to the screen; one element per line. 
	 */
	public void printList(){
		System.out.println("Size: " + size);
		DoublyNode<T> temp = head;
		for(int x = 0; x < size; x++){
			System.out.println(temp.getData().toString());
			temp = temp.getNext();
		}
	}
	
	/**
	 * Returns the index in this list of the first occurrence of the specified element, 
	 * or -1 if this list does not contain this element
	 * @param o object to find indexOf
	 * @return the index of the object or -1 is it does not exist
	 */
	public int indexOf(Object o){
		int x = -1;
		DoublyNode<T> temp = head;
		/*
		while(!temp.getData().equals(o)){
			temp = temp.getNext();
			x++;
		}
		*/
		for(int j = 0; j < size;j++){
			if(temp.getData().equals(o))
				return j;
			temp = temp.getNext();
		}
		return x;
	}
	
	/**
	 * returns the size of the list
	 * @return the size
	 */
	public int size() {
		return size;
	}	
	
}
