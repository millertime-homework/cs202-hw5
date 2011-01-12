package accountdatabase;

/**
 * Binary Search Tree of applications.
 * 
 * @author Russell Miller
 */
class BST {
	
	/**the root of the tree*/
	private BSTNode root;
	
	/** 
	 * constructor 
	 */
	public BST() {
		root = null;
	}
	
	/**
	 * Public function that adds an application 
	 * to the binary search tree. Needs private
	 * recursive helper function that is
	 * overloaded.
	 * 
	 * @param a			Application to be inserted
	 */
	public void insert(App a) {
		root = this.insert(a, root);
	}
	
	/**
	 * Private helper function that sorts and inserts 
	 * new applications by assigning references recursively. 
	 * The entire tree is returned to root in the public
	 * function implemented above.
	 * 
	 * @param a			Application to be inserted
	 * @param current	Current position in recursion
	 * @return 			reference to the tree, so root can access it.
	 */
	private BSTNode insert(App a, BSTNode current) {
		if (current == null) {
			return new BSTNode(a);
		}
		else if (a != null) {
			if (a.getname() != null && current.getapp() != null) {
				int compare = (a.getname()).compareTo(current.getapp().getname());
				if (compare < 0)
					current.setleft(insert(a, current.getleft()));
				else if (compare > 0)
					current.setright(insert(a, current.getright()));
				else {
					System.out.println("Application already exists!");
					return null;
				}
				return current;
			}
			else{
				System.out.println("Error inserting..");
				return null;
			}
		}
		else {
			System.out.println("Error inserting..");
			return null;
		}
	}
	
	/**
	 * Public function for finding an app within the tree, by looking 
	 * for the app name. Knowing the parent means being able to delete
	 * the child without losing its children.
	 * 
	 * @param name				Name to be match-searched
	 * @return					The node where that name matches
	 */
	public BSTNode retrieve(String name) {
		/** empty tree, unable to search */
		if (root == null) {
			return null;
		}
		else {
			return this.retrieve(name, root);
		}
	}
	
	/**
	 * Recursive helper function that is able to start at root and navigate 
	 * through tree to return the correct node.
	 * 
	 * @param name				Name to be match-searched
	 * @param current			Starts at root, works through tree recursively
	 * @return					The node where name matches, or null if not found
	 */
	private BSTNode retrieve(String name, BSTNode current) {
		/** if we have reached a null node, search has failed. */
		if (current == null) {
			System.out.println("App not found!");
			return null;
		}
		/** if the name matches current node */
		else if (name.compareTo(current.getapp().getname()) == 0) {
			return current;
		}
		/** if we need to go left to find the node with matching name */
		else if (name.compareTo(current.getapp().getname()) < 0) {
			return retrieve(name, current.getleft());
		}
		else {
			return retrieve(name, current.getright());
		}
	}
	
	/**
	 * This is a special helper function for when deleting nodes from the binary
	 * search tree. In order for the tree to stay completely attached have to get
	 * a node's parent. This traverses until it finds the matching nodes in one
	 * of it's children by comparing getleft and getright.
	 * 
	 * @param child								The node we're looking for
	 * @param current							Current node, is it the parent?
	 * @return									The child's parent node
	 */
	private BSTNode retrieveParent(BSTNode child, BSTNode current) {
		/**one of them is the child, so this is a match!*/
		if (current.getleft() == child || current.getright() == child)
			return current;
		else {
			/**need to go left to find it*/
			if (child.getapp().getname().compareTo(current.getapp().getname()) < 0)
				return retrieveParent(child, current.getleft());
			/**need to go right to find it*/
			else
				return retrieveParent(child, current.getright());
		}
	}
	
	/**
	 * Public function that allows deleting a node based on
	 * the given String. First searches for a node with matching
	 * name then deletes the node.
	 * 
	 * @param name				Name of node to be deleted
	 */
	public void delete(String name) {
		/**get the node to be deleted*/
		BSTNode node = retrieve(name);
		if (node != null) {
			/**if we're deleting a non-root node*/
			if (node != root) {
				BSTNode parent = retrieveParent(node, root);
				/**this allows tree to stay linked after deleting*/
				if (parent.getleft() == node)
					/**child is on left side*/
					parent.setleft(delete(node));
				else if (parent.getright() == node)
					/**child is on right side*/
					parent.setright(delete(node));
			}
			/**root needs to point to what is left after deleting old root*/
			else
				root = delete(node);
		}
	}
	
	/**
	 * Delete a node from the binary search tree
	 * 
	 * @param node				The node being deleted
	 */
	private BSTNode delete(BSTNode node) {
		/** usually only possible if tree is already empty */
		if (node == null) 
			return null;
		/** if node is leaf */
		else if (node.getleft() == null && node.getright() == null) 
			return null;
		/**uses findMin*/
		else if (node.getright() != null) {
			/**get the next in-order element of the tree*/
			BSTNode min = findMin(node.getright());
			/**get its parent - for rebuilding*/
			BSTNode minsparent = retrieveParent(min, root);
			/**just in case min had a right subtree*/
			minsparent.setleft(min.getright());
			/**don't lose node's left subtree!*/
			min.setleft(node.getleft());
			/**takes node's place, node will now be gone*/
			return min;
		}
		/**there was no right subtree, so have to use findMax*/
		else {
			/**get the previous in-order element of the tree*/
			BSTNode max = findMax(node.getleft());
			/**get its parent for rebuilding*/
			BSTNode maxparent = retrieveParent(max, root);
			/**just in case max had a left subtree*/
			maxparent.setright(max.getleft());
			/**takes node's place, node will now be gone*/
			return max;
		}
	}
	
	/**
	 * Special helper function for deleting nodes. Gives next in-order
	 * element of the tree by taking one step to the right, then sliding
	 * all the way left until it hits null.
	 * 
	 * @param current				Starts at node directly to the right, iterates leftward
	 * @return						minimum of right subtree - in-order successor.
	 */
	private BSTNode findMin(BSTNode current) {
		while (current.getleft() != null)
			current = current.getleft();
		return current;
	}
	
	/**
	 * Special helper symmetrical to findMin, used when traversing right
	 * subtree not possible. Instead rebuilds leftward by finding the
	 * in-order predecessor
	 * 
	 * @param current				Starts at node to the left, iterates rightward
	 * @return						max of the left subtree - in-order predecessor
	 */
	private BSTNode findMax(BSTNode current) {
		while (current.getright() != null)
			current = current.getright();
		return current;
	}
	
	/**
	 * Print entire tree by calling overloaded 
	 * private recursive helper function.
	 */
	public void printtree() {
		this.printtree(root);
	}
	
	/**
	 * starts at root and recursively prints each node
	 * in the tree
	 * 
	 * @param current		Current position in recursion
	 */
	private void printtree(BSTNode current) {
		if (current != null) {
			printtree(current.getleft());
			current.getapp().display();
			printtree(current.getright());
		}
	}
	
	/**
	 * sibling of printtree, but output
	 * is a file. has a recursive helper
	 */
	public void write() {
		this.write(root);
	}
	
	/**
	 * starts at root and recursively
	 * prints each node to the file
	 * 
	 * @param current		Current position in recursion
	 */
	private void write(BSTNode current) {
		if (current != null) {
			write(current.getleft());
			current.getapp().write();
			write(current.getright());
		}
	}

}
