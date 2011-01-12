package accountdatabase;

/**
 * A linear linked list whose nodes hold users.
 * 
 * @author Russell Miller
 */
class LLL {

	/** first element of the list */
	private LLLNode head;
	
	/** last element of the list  */
	private LLLNode tail;
	
	/** Constructor
	 */
	public LLL() {
		head = null;
		tail = null;
	}
	
	/** 
	 * takes a user and makes a node
	 * then inserts it into the list
	 * 
	 * @param u User
	 */
	public void insert(User u) {
		LLLNode newnode = new LLLNode(u);
		if (head == null) {
			/** empty list - this element is the first
			 *  and the last */
			head = newnode;
			tail = newnode;
		}
		else {
			/** non-empty list - put it after the tail
			 *  and it becomes the new tail */
			tail.setNext(newnode);
			tail = newnode;
		}
	}
	
	/** 
	 * simply print out the name of
	 * each user in the list
	 */
	public void display() {
		System.out.println("");
		System.out.println("Users:");
		LLLNode current = head;
		while (current != null) {
			if (current.getUser() != null) {
				System.out.println(current.getUser().getname());
			}
			current = current.getNext();
		}
		System.out.println("^^^^^^");
	}
	
	/** 
	 * attempts to match name with each
	 * user in the list, returns the user if it matches
	 * 
	 * @param name		name to search for
	 * @return User 	user that matches name
	 */
	public User find(String name) {
		if (head == null) {
			return null;
		}
		else {
			LLLNode current = head;
			while (current != null) {
				if (name.compareTo(current.getUser().getname()) == 0) {
					return current.getUser();
				}
				current = current.getNext();
			}
		}
		System.out.println("User not found, please try again.");
		return null;
	}
	
}