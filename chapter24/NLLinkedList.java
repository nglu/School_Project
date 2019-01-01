package chapter24;

/*	NGOC LUONG
 * 	COMPSCI II
 * 	Excercise 24.02
 */

public class NLLinkedList<E> extends MyAbstractList<E>
{
	public static void main(String[] arg)
	{
		NLLinkedList<String> list = new NLLinkedList<>(); 
		
		list.add("Adam");
		System.out.println(list);
		System.out.println();
		
		list.addFirst("Jenny");
		System.out.println("Add Jenny at the beginning of the list");
		System.out.println(list);
		System.out.println();

		list.addLast("Ben");
		System.out.println("Add Ben at the end of the list");
		System.out.println(list);
		System.out.println();

		list.add(1, "Henry");
		System.out.println("Add Henry to the list at index 1");
		System.out.println(list);
		System.out.println();
		
		list.add(2, "Kenny");
		System.out.println("Add Kenny to the list at index 2");
		System.out.println(list);
		System.out.println();
		
		list.add("Ray");
		System.out.println("Add Ray to the list");
		System.out.println(list);
		System.out.println();
		
		list.add("Marie");
		System.out.println("Add Marie to the list");
		System.out.println(list);
		System.out.println();
		
		list.remove(1);
		System.out.println("Remove index 1 from the list");
		System.out.println(list);
		System.out.println();
		
		list.removeFirst();
		System.out.println("Remove the first index");
		System.out.println(list);
		System.out.println();
		
		list.removeLast();
		System.out.println("Remove the last index");
		System.out.println(list);
		System.out.println();
		
		System.out.println("The list contains Ari: " + list.contains("Ari"));
		System.out.println("The list contains Marie: " + list.contains("Ben"));
		System.out.println("The index of Ben is: " + list.indexOf("Ben"));
		System.out.println("The index of Ray is: " + list.lastIndexOf("Ray"));
 		System.out.println("Replace the first index with Hannah");
		list.set(0, "Hannah");
		System.out.println(list);
		System.out.println();
		
	}
	
	private Node<E> head, tail;
	
	public NLLinkedList() {}
	public NLLinkedList(E[] objects) 
	{
		super(objects);
	}
	
	public E getFirst() 
	{
		if (size == 0)
			return null;
		else
			return head.element;
	}
	public E getLast() 
	{
		if (size == 0)
			return null;
		else
			return tail.element;
	}
	
	public void addFirst(E e) 
	{
		Node<E> newNode = new Node<>(e); // Create a new node
		newNode.next = head; // link the new node with the head
		head = newNode; // head points to the new node
		size++; // Increase list size

		if (tail == null) // The new node is the only node in list
			tail = head;
	}
	public void addLast(E e) 
	{
		Node<E> newNode = new Node<>(e); // Create a new node for e
		if (tail == null)
			head = tail = newNode; // The only node in list
		else 
		{
			tail.next = newNode; // Link the new node with the last node
			tail = tail.next; // tail now points to the last node
		}
		size++; // Increase size
	}
	@Override
	public void add(int index, E e) 
	{
		if (index == 0) addFirst(e); // Insert first
		else if (index >= size) addLast(e); // Insert last
		else 			// Insert in the middle
		{ 
			Node<E> current = head;
			for (int i = 1; i < index; i++)
				current = current.next;
			Node<E> temp = current.next;
			current.next = new Node<>(e);
			(current.next).next = temp;
			size++;
		}
	}
	
	public E removeFirst() 
	{
		if (size == 0)
			return null; // Nothing to delete
		else 
		{
			Node<E> temp = head; // keep the first node temporarily
			head = head.next; // Move head to point to next node
			size--; // Reduce size by 1
			return temp.element; // Return the deleted element
		}
	}
	public E removeLast() 
	{
		if (size == 0) 
			return null; // Nothing to remove
		else if (size == 1) // Only one element in the list
		{	
			Node<E> temp = head;
			head = tail = null; // list becomes empty
			size = 0;
			return temp.element;
		}
		else 
		{
			Node<E> current = head;

			for (int i = 0; i < size - 2; i++)
				current = current.next;		

			Node<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;
		}
	}
	@Override /** Remove the element at the specified position in this
		* list. Return the element that was removed from the list. */
	public E remove(int index) 
	{
		if (index < 0 || index >= size) 
			return null; // Out of range
		else if (index == 0) 
			return removeFirst(); // Remove first
		else if (index == size - 1) 
			return removeLast(); // Remove last
		else 
		{
			Node<E> previous = head;

			for (int i = 1; i < index; i++)
				previous = previous.next;

			Node<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}
	}
	
	
	public void clear() 
	{
		size = 0;
		head = tail = null;
	}
	
	// implement contains(E e), get(int index), 
	// indexOf(E e), lastIndexOf(E e), and set(int index, E e)
	
	@Override
	public boolean contains(E e)
	{
		if (size == 0) 
			return false;
		else 
		{
			Node<E> current = head;
			while (current != null) 
			{
				if (current.element == e)
				{
					return true;
				}
				else
				{
					current = current.next;
				}
			}
		}
		return false;
	}
	

	@Override 
	public E get(int index) 
	{
		if (index < 0 || index >= size) return null; 
		else if (index == 0) 
			return getFirst();
		else if (index == size - 1) 
			return getLast();
		else 
		{
			Node<E> current = head.next;
			for (int i = 1; i < index; i++)
				current = current.next;
			return current.element;
		}

	}

	@Override 
	public int indexOf(E e) 
	{
		if (head.element == e) return 0;
		else if (tail.element == e) 
			return size - 1;
		else 
		{
			Node<E> current = head.next;
			int index = 1;
			while (current != null) 
			{
				if (current.element == e)
					return index;
				current = current.next;
				index++;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(E e) 
	{
		int index = -1;		// if the list doesn't have this element, returns a negative number
		Node<E> current = head;
		for (int i = 0; i < size; i++) 
		{
			if (current.element == e)
				index = i;
			current = current.next;
		}
		return index;
	}

	@Override
	public E set(int index, E e) 
	{
		if (index < 0 || index > size - 1) 		// out of bound
			return null;
		else 
		{
			Node<E> current = head;
			for (int i = 0; i < index; i++)
				current = current.next;
			current.element = e;
			return current.element;
		}
	}
	
	//
		
	@Override /** Override iterator() defined in Iterable */
	public java.util.Iterator<E> iterator() 
	{
		return new LinkedListIterator();
	}

	public class LinkedListIterator implements java.util.Iterator<E> 
	{
		private Node<E> current = head; // Current index

		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public E next() {
			E e = current.element;
			current = current.next;
			return e;
		}
	}
	
	private static class Node<E> 
	{
		E element;
		Node<E> next;

		public Node(E element) 
		{
			this.element = element;
		}
	}

	public String toString() 
	{
		StringBuilder result = new StringBuilder("[");

		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			result.append(current.element);
			current = current.next;
			if (current != null) {
				result.append(", "); // Separate two elements with a comma
			}
			else {
				result.append("]"); // Insert the closing ] in the string
			}
		}

		return result.toString();
	}
}
