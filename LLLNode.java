package accountdatabase;

/**
 * Node for the Linear Linked List.
 * Holds users. 
 * 
 * @author Russell Miller
 */
class LLLNode {
	
	/** user stored in the node */
	private User user_account;
	
	/** next node, link down the list */
	private LLLNode next;
	
	/**
	 * constructor
	 * 
	 * @param u			User to be stored in node
	 */
	public LLLNode(User u) {
		user_account = u;
		next = null;
	}
	
	/**
	 * @return			next
	 */
	public LLLNode getNext() {
		return next;
	}
	
	/**
	 * @return			user
	 */
	public User getUser() {
		return user_account;
	}
	
	/**
	 * @param n			node being placed
	 */
	public void setNext(LLLNode n) {
		next = n;
	}
	
}
