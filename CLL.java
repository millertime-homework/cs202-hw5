package accountdatabase;

/**
 * A circular linked list. Its nodes
 * hold machines to structure together the
 * Systems for the AccountDatabase.
 * This type of list focuses on quick inserting
 * and removing and uses do-while to iterate.
 * I    LOVE    IT.
 * 
 * @author Russell Miller
 */
class CLL {
	
	/** head - single access point to the circle
	 *  of nodes. */
	private CLLNode head;
	
	/** 
	 * constructor
	 */
	public CLL() {
		head = null;
	}
	
	/** 
	 * public function for putting a machine 
	 * into a node. calls overloaded private
	 * helper function.
	 * 
	 * @param m 			Machine to be inserted
	 */
	public void insert(Machine m) {
		CLLNode newnode = new CLLNode(m);
		this.insert(newnode);
	}
	
	/** 
	 * Takes new node and inserts it into the list
	 * 
	 * @param newnode 		CLLNode that goes into list
	 */
	private void insert(CLLNode newnode) {
		if (head == null) {
			/** with the empty list the head
			 * and its next both refer to the new element */
			head = newnode;
			head.setNext(newnode);
		}
		else {
			/** with non-empty list the head's next
			 *  is the new element and the new element's
			 *  next is whatever the head's next was */
			newnode.setNext(head.getNext());
			head.setNext(newnode);
		}
	}
	
	/** 
	 * Simply print out the name of all
	 * machines in the list
	 */
	public void display() {
		if (head != null) {
			System.out.println("");
			System.out.println("Systems:");
			CLLNode current = head;
			do {
				System.out.println(current.getMachine().getname());
				current = current.getNext();
			} while (current != head);
			System.out.println("^^^^^^^^");
		}
	}
	
	/** 
	 * Look for the machine by name, return the machine
	 * if found and null otherwise
	 * 
	 * @param name 			String for what you're looking for
	 * @return 				the Machine that matches that name, or null
	 */
	public Machine find(String name) {
		if (head == null) {
			/** empty list, don't need to compare anything */
			return null;
		}
		else {
			/** current - used for iterating the list */
			CLLNode current = head;
			do {
				if (name.compareTo(current.getMachine().getname()) == 0) {
					/** the names matched, so return this one */
					return current.getMachine();
				}
				/** haven't found it yet, so move down the list */
				current = current.getNext();
			/** testing exit condition AFTER the loop!
			 *  avoids endlessly circling the list  */
			} while (current != head);
		}
		/** went all the way around the circle, didn't find it */
		System.out.println("Machine not found, please try again.");
		return null;
	}
	
}
