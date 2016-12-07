import java.io.Serializable;
/**
 * Node to be used by the sorted list
 * @author Rohan Malik
 *
 * @param <T>
 */
public class DoublyNode<T extends Comparable<? super T>> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private T data;
	private DoublyNode<T> prev;
	private DoublyNode<T> next;
	
	/**
	 * creates a DoublyNode object
	 * @param data data to be stored in the node
	 */
	public DoublyNode(T data){
		this.data = data;
		prev = null;
		next = null;
	}

	/**
	 * returns the data
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * sets the data
	 * @param data data to be set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * returns previous node
	 * @return previous node
	 */
	public DoublyNode<T> getPrev() {
		return prev;
	}

	/**
	 * sets previous node
	 * @param prev node to set as previous
	 */
	public void setPrev(DoublyNode<T> prev) {
		this.prev = prev;
	}

	/**
	 * returns the next node
	 * @return the next node
	 */
	public DoublyNode<T> getNext() {
		return next;
	}

	/**
	 * sets the next node
	 * @param next node to be set as next
	 */
	public void setNext(DoublyNode<T> next) {
		this.next = next;
	}
}
