package accountdatabase;

/**
 * The meat under the circular linked
 * list. holds the machine for the account
 * database and points to its next node.
 * 
 * @author Russell Miller
 */
class CLLNode {
	
	/** the data structure stored in this list */
	private Machine account_system;
	
	/** link to the rest of the list */
	private CLLNode next;
	
	/** 
	 * Constructor
	 * @param m 			Machine that's going to be stored in the node.
	 */
	public CLLNode(Machine m) {
		account_system = m;
		next = null;
	}
	
	/**			
	 * OBSERVERS
	 * 
	 * @return 				next field (iterate)
	 */
	public CLLNode getNext() {
		return this.next;
	}
	
	/**
	 * Used for getting machine name or 
	 * calling the bootup function
	 * 
	 * @return 				the account_system stored at this node
	 */
	public Machine getMachine() {
		return this.account_system;
	}
	
	/**	
	 * build onto the list
	 * 
	 * @param n 			node to be linked
	 */
	public void setNext(CLLNode n) {
		this.next = n;
	}
	
}
