package chapter25;


/* 
 * NGOC LUONG
 * COMPSCI II
 * Exercise 25.01 + 25.06 + 25.07
 */

/* 
 * Add the following new methods in BST
 * 		Exercise 25.01
 * a) Display the nodes in a breadth-first traversal
 * b) Return the height of the binary tree
 * 		Exercise 25.06
 * c) Return the number of leaf nodes
 * 		Exercise 25.07
 * d) Return the number of non-leaf nodes
 */


abstract class AbstractTree<E> implements Tree<E> 
{
  @Override /** Inorder traversal from the root*/
  public void inorder() {
  }

  @Override /** Postorder traversal from the root */
  public void postorder() {
  }

  @Override /** Preorder traversal from the root */
  public void preorder() {
  }

  @Override /** Return true if the tree is empty */
  public boolean isEmpty() {
    return getSize() == 0;
  }
}

 interface Tree<E> extends Iterable<E> {
	  /** Return true if the element is in the tree */
	  public boolean search(E e);

	  /** Insert element o into the binary tree
	   * Return true if the element is inserted successfully */
	  public boolean insert(E e);

	  /** Delete the specified element from the tree
	   * Return true if the element is deleted successfully */
	  public boolean delete(E e);

	  /** Inorder traversal from the root*/
	  public void inorder();

	  /** Postorder traversal from the root */
	  public void postorder();

	  /** Preorder traversal from the root */
	  public void preorder();

	  /** Get the number of nodes in the tree */
	  public int getSize();

	  /** Return true if the tree is empty */
	  public boolean isEmpty();
	}

public class NL_BST<E extends Comparable<E>>extends AbstractTree<E> 
{	
	/* 
	 * Add the following new methods in BST
	 * 		Exercise 25.01
	 * a) Display the nodes in a breadth-first traversal
	 * b) Return the height of the binary tree
	 * 		Exercise 25.06
	 * c) Return the number of leaf nodes
	 * 		Exercise 25.07
	 * d) Return the number of non-leaf nodes
	 */
	
	public static void main(String[] args)
	{
		NL_BST<String> tree = new NL_BST<>();
		
		tree.insert("Hannah");
		tree.insert("Betty");
		tree.insert("Kayla");
		tree.insert("Ruby");
		tree.insert("Sarah");
		tree.insert("Denver");
		tree.insert("Peter");
		tree.insert("Amy");
		tree.insert("Irvine");

		
		// Traverse tree breadth-first
		System.out.print("\nBreadth-first: ");
		tree.breadthFirstTraversal();
		
		// Height of tree
		System.out.print("\nHeight of tree: ");	
		System.out.println(tree.height());
		
		System.out.println("Number of leaf nodes: " + tree.getNumberOfLeaves());
		
		System.out.println("Number of nonleaf nodes: " + tree.getNumberOfNonLeaves());
		
		NL_BST<Integer> numericTree = new NL_BST<>();
		
		numericTree.insert(34);
		numericTree.insert(12);
		numericTree.insert(85);
		numericTree.insert(57);
		numericTree.insert(8);
		numericTree.insert(24);
		numericTree.insert(71);
		numericTree.insert(103);
		numericTree.insert(62);

		
		// Traverse tree breadth-first
		System.out.print("\nBreadth-first: ");
		numericTree.breadthFirstTraversal();
		
		// Height of tree
		System.out.print("\nHeight of tree: ");	
		System.out.println(numericTree.height());
		
		System.out.println("Number of leaf nodes: " + numericTree.getNumberOfLeaves());
		
		System.out.println("Number of nonleaf nodes: " + numericTree.getNumberOfNonLeaves());
	}
	
	protected TreeNode<E> root;
	protected int size = 0;
	
	/** Create a default binary tree */
	public NL_BST() {}
	
	/** Create a binary tree from an array of objects */
	public NL_BST(E[] objects) 
	{
		for (int i = 0; i < objects.length; i++)
			insert(objects[i]);
	}
	@Override /** Returns true if the element is in the tree */
	public boolean search(E e) 
	{
		TreeNode<E> current = root; // Start from the root
		while (current != null) 
		{
			if (e.compareTo(current.element) < 0) 
			{
				current = current.left;
			}
			else if (e.compareTo(current.element) > 0) 
			{
				current = current.right;
			}
			else // element matches current.element
				return true; // Element is found
		}
		return false;
	}
	@Override /** Insert element o into the binary tree
	*  Return true if the element is inserted successfully */
	public boolean insert(E e) 
	{
		if (root == null)
			root = createNewNode(e); // Create a new root
		else 
		{// Locate the parent node
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while (current != null)
				if (e.compareTo(current.element) < 0) 
				{
					parent = current;
					current = current.left;
				}
				else if (e.compareTo(current.element) > 0) 
				{
					parent = current;
					current = current.right;
				}
				else
					return false; // Duplicate node not inserted
			// Create the new node and attach it to the parent node
			if (e.compareTo(parent.element) < 0)
				parent.left = createNewNode(e);
			else
				parent.right = createNewNode(e);
			}
		size++;
		return true; // Element inserted successfully
		}
	protected TreeNode<E> createNewNode(E e) 
	{
		return new TreeNode<>(e);
	}
	//
	@Override /** Inorder traversal from the root */
	public void inorder()
	{
		inorder(root);
	}
	/** Inorder traversal from a subtree */
	protected void inorder(TreeNode<E> root)
	{
		if(root == null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.element + " ");
	}
	//
	@Override /** Postorder traversal from the  */
	public void postorder()
	{
		postorder(root);
	}
	/** Post-order traversal from a subtree */
	protected void postorder(TreeNode<E> root)
	{
		if(root == null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.element + " ");
	}
	//
	@Override /** Preorder traversal from the root */
	public void preorder()
	{
		preorder(root);
	}
	/** Pre-order traversal from a subtree */
	protected void preorder(TreeNode<E> root)
	{
		if(root == null)
			return;
		System.out.print(root.element + " ");
		preorder(root.left);
		preorder(root.right);
	}
	//
	/** This inner class is static, because it does not access
	 * any instance members defined in its outer class */	
	public static class TreeNode<E extends Comparable<E>>
	{
		protected E element; 
		protected TreeNode<E> left; 
		protected TreeNode<E> right;
		
		public TreeNode(E e) 
		{ 
			element = e;
		}
	}
	
	//
	
	@Override /** Get the number of nodes in the tree */
	public int getSize()
	{
		return size;
	}
	
	/** Returns the root of the tree */
	public TreeNode<E> getRoot()
	{
		return root;
	}
	
	/** Returns a path from the root leading to the specific element */
	public java.util.ArrayList<TreeNode<E>> path(E e)
	{
		java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<>();
		TreeNode<E> current = root; // Start from the root
		
		while (current != null)
		{
			list.add(current);
			if(e.compareTo(current.element) < 0)
			{
				current = current.left;
			}
			else if (e.compareTo(current.element) > 0)
			{
				current = current.right;
			}
			else
				break;
		}
		return list; 
	}
	
	@Override /** Delete an element from the binary tree.
	Return true if the element is deleted successfully
	Return false if the element is not in the tree */
	public boolean delete(E e)
	{
		// Locate the node to be deleted and also its parent node
		TreeNode<E> parent = null;
		TreeNode<E> current = root;
		while (current != null)
		{
			if (e.compareTo(current.element) <0)
			{
				parent = current;
				current = current.left;
			}
			else if (e.compareTo(current.element) > 0)
			{
				parent = current;
				current = current.right;
			}
			else
				break; //Element is in the tree pointed at by current
		}
		if (current == null)
			return false; // Element is not in the tree
		
		// Case 1: current has no left child
		if (current.left == null)
		{
			// Connect the parent with the right child of the current node
			if (parent == null)
			{
				root = current.right;
			}
			else
			{
				if (e.compareTo(parent.element) > 0)
					parent.left = current.right;
				else
					parent.right = current.right;
			}
		}
		// Case 2: The current node has a left child
		else
		{
			// Locate the rightmost node in the left subtree of
			// the current node and also its parent
			TreeNode<E> parentOfRightMost = current;
			TreeNode<E> rightMost = current.left;
			
			while (rightMost.right != null)
			{
				parentOfRightMost = rightMost;
				rightMost = rightMost.right; // Keep going to the right
			}
			
			// Replace the element in current by the element in rightMost
			current.element = rightMost.element;
			
			// Eliminate rightmost node
			if (parentOfRightMost.right == rightMost)
				parentOfRightMost.right = rightMost.left;
			else
				// Special case: parentOfRightMost == current
				parentOfRightMost.left = rightMost.left;
		}
		size--;
		return true; // Successfully delete
	}
	
	@Override /** Obtain an iterator. Use inorder. */
	public java.util.Iterator<E> iterator()
	{
		return new InorderIterator();
	}
	// Inner class InorderIterator
	private class InorderIterator implements java.util.Iterator<E>
	{
		// Store element in a list
		private java.util.ArrayList<E> list = new java.util.ArrayList<>();
		private int current = 0; // Point to the current element in list
		
		public InorderIterator()
		{
			inorder(); // Traverse binary tree and store element in list
		}
		
		/** Inorder traversal from the root */
		private void inorder()
		{
			inorder(root);
		}
		
		/** Inorder traversal from a subtree */
		private void inorder(TreeNode<E> node)
		{
			if (root == null)
				return;
			inorder(root.left);
			list.add(root.element);
			inorder(root.right);
		}
		
		@Override /** More element for traversing? */
		public boolean hasNext()
		{
			if (current < list.size())
				return true;
			return false;
		}
		@Override /** Get the current element and move to the next */
	    public E next() 
		{
	      return list.get(current++);
	    }
		@Override /** Remove the current element */
		public void remove()
		{
			delete(list.get(current)); // Delete the current element
			list.clear();
			inorder(); // Rebuild the list
		}
	
		/** Remove all elements from the tree */
		public void clear()
		{
			root = null;
			size = 0;
		}
	}
	
	/* a) Display the nodes in a breadth-first traversal */
	public void breadthFirstTraversal()
	{
		if (root == null) return;
		java.util.Queue<TreeNode<E>> queue = new java.util.LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty())
		{
			TreeNode<E> current = queue.element();
			if (current.left != null) 
			{
				queue.add(current.left);
			}
			if (current.right != null) 
			{
				queue.add(current.right);
			}
			System.out.print(queue.remove().element + " ");
		}
	}

	
	/* b) Return the height of this binary tree */
	public int height()
	{
		return height(root);
	}
	protected int height(TreeNode<E> root) 
	{
		if (root == null) return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	/* c) Return the number of leaf nodes */
	public int getNumberOfLeaves()
	{
		return getNumberOfLeaves(root);
	}
	public int getNumberOfLeaves(TreeNode<E> root) 
	{
		if (root == null) 
			return 0;
		if (root.left == null && root.right == null)	// if no children return 1
			return 1;
		else
			return (getNumberOfLeaves(root.left) + getNumberOfLeaves(root.right));
	}
	
	/* d) Return the number of non-leaf nodes */
	public int getNumberOfNonLeaves()
	{
		return getNumberOfNonLeaves(root);
	}
	protected int getNumberOfNonLeaves(TreeNode<E> root) 
	{
		if (root == null) 
			return 0;
		if (root.left == null && root.right == null) // if no children return 0
			return 0;
		else
			return (1 + getNumberOfNonLeaves(root.left) + getNumberOfNonLeaves(root.right)) ;
	}
}
