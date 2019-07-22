

public class Node<E> {

    /*
     * The data value. 
     */
    E data;
    
    /*
 	 * The link.
 	 */
    Node<E> next = null;
    
    /*
     * Default constructor for a Node.
     */
    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }
    
    /*
     * Default constructor for the last Node.
     */
    public Node(E data) {
        this(data, null);
    }
	
    /*
     * Returns data of the Node.
     */
	public E getData(){
		return data;
	}
	
	/*
	 * Sets the data of the Node.
	 */
	public void setData(E data){
		this.data = data;
	}

	/*
	 * Returns the Node next in the LinkedList.
	 */
	public Node<E> getNext(){
		return next;
	}
	
	/*
	 * Sets the Node next in the LinkedList.
	 */
	public void setNext(Node<E> next){
		this.next = next;
	}
	
}
