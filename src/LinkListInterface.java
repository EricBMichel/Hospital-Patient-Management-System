public interface LinkListInterface <E> { 
	public void addFirst(E item);
	
	public void addAfter(Node<E> node, E item);
	
	public E removeFirst();
	
	public E removeAfter(Node<E> node);
	
	public Node<E> getNode(int index);
	
	public E get(int index);
	
	public E set(int index, E newValue);
	
	public void add(int index, E item);
	
	public boolean add(E item);
	
	public E remove(int index);
	
	public boolean remove(E item);
	
	public int size();

	public int indexOf(E item);

	public void removeLast();

	public E getLast();
}
