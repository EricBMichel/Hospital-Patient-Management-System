
public class MyLinkList<E> implements LinkListInterface<E> {
	
	/*
	 * The first value in the LinkedList.
	 */
	Node<E> head = null;
	
	/*
	 * The size of the LinkedList.
	 */
	int size = 0;
	
	/*
	 *  Adds the first item to the LinkedList.
     *	@param item The object or item to be inserted.
     */
	@Override
	public void addFirst(E item) {
		Node<E> newNode = new Node<E>(item);
		newNode.setNext(head);
		head = newNode;
		size++;
	}
	
	/*
     * Adds a node after a given node.
     * @param node The node which the new item is inserted after.
     * @param item The object or item to be inserted.
     */
	@Override
	public void addAfter(Node<E> node, E item) {
		Node<E> newNode = new Node<E>(item);
		newNode.setNext(node.getNext());
		node.setNext(newNode);
		size++;
	}
	
	/*
     * Removes the first node from the LinkedList.
     * @returns the removed node's data or null if the LinkedList is empty.
     */
	@Override
	public E removeFirst() {
		if(size == 0) {
			return null;
		}
		E toReturn = head.getData();
		head = head.getNext();
		size--;
		return toReturn;
	}
	
	/*
     * Removes the node after a given node.
     * @param node The node before the one to be removed.
     * @returns the data from the removed node, or null if there is no node to remove.
     */
	@Override
	public E removeAfter(Node<E> node) {
		if(size == 0) {
			return null;
		}
		else if(node.getNext().equals(null)) {
			return null;
		}
		E toReturn = node.getNext().getData();
		node.setNext(node.getNext().getNext());
		size--;
		return toReturn;
	}
	
	/*
     * Finds the node at a specified index.
     * @param index The index of the node sought
     * @returns the node at index or null if it does not exist
     */
	@Override
	public Node<E> getNode(int index) {
		 Node<E> node = head;
	        for (int i = 0; i < index && node != null; i++) {
	            node = node.getNext();
	        }
	        return node;
	}

    /*
     * Gets the data value at a specified index.
     * @param index The index of the element to return
     * @returns The data at index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
	@Override
	public E get(int index) {
		if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.getData();
	}
	
	/*
     * Sets the data value at a specified index.
     * @param index The index of the item to change.
     * @param newValue The new value.
     * @returns The data value previously at index.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
	@Override
	public E set(int index, E newValue) {
		if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        E result = node.getData();
        
        return result;
	}
	
	/*
     * Inserts the specified item at the specified position in the LinkedList.
     * @param index Index at which the specified item is to be inserted
     * @param item The item to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
	@Override
	public void add(int index, E item) {
		if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            addFirst(item);
        } else { //Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices)
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
		
	}
	
	/**
     * Adds the specified item to the end of the LinkedList.
     * @param item The item to be added.
     * @returns true (as specified by the Collection interface).
     */
	@Override
	public boolean add(E item) {
		add(size, item);
        return true;
	}
	
	/*
     * Removes the item at the specified position in the LinkedList. 
     * @param index The index of the item to be removed
     * @returns The item that was at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
	@Override
	public E remove(int index) {
		if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }    
        if (index == 0) {
            return removeFirst();
        } else { //Shifts any subsequent items to the left (subtracts one from their indices). Returns the item that was removed.
            Node<E> node = getNode(index - 1);
            return removeAfter(node);
        }
	}
	
	/*
     * Removes the first occurrence of element item.
     * @param item The item to be removed.
     * @return true if item is found and removed; otherwise, return false.
     */
	@Override
	public boolean remove(E item) {
		if (head == null) {
            return false;
        }
        Node<E> current = head;
        if (item.equals(current.data)) {
            removeFirst();
            return true;
        }
        while (current.next != null) {
            if (item.equals(current.next.data)) {
                removeAfter(current);
                return true;
            }
            current = current.next;
        }
        return false;
	}
	
	/*
     * Returns the index of the specified item.
     * @param item The item for which the index is linked with.
     * @return the index at when the item is found
     */
	@Override
	public int indexOf(E item) {
		Node<E> node = head;
		int index = 0;
		
		while (node.getData() != null) {
	        if (node.getData().equals(item)) {
	            return index;
	        }
	        index++;
	        node = node.getNext();
	    }
	    return index;
	}
	
	/*
     * Removes the last item in the LinkedList.
     */
	@Override
	public void removeLast() {
		remove(size-1);        
    }
	
	/*
     * Returns the last item in the LinkedList.
     */
	@Override
	public E getLast() {
		return get(size-1);
	}
	
	/*
     * Returns the size of the LinkedList.
     */
	@Override
	public int size() {
		return size;
	}
		
}
