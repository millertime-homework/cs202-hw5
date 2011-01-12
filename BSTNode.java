package accountdatabase;

/**
 * Hold an application, and link to other nodes
 * 
 * @author Russell Miller
 */
class BSTNode {
	
	/** data in the node */
	private App application;
	
	/** link to other apps that are <-*/
	private BSTNode left;
	
	/** link to other apps that are ->*/
	private BSTNode right;
	
	/** 
	 * constructor
	 * 
	 * @param a			Application being held in this node
	 */
	public BSTNode(App a) {
		application = a;
		left = null;
		right = null;
	}
	
	/**     
	 * OBSERVERS
	 * 
	 * @return 			the left field (left subtree)
	 */
	public BSTNode getleft() {
		return left;
	}
	
	/**
	 * @return			the right field (right subtree)
	 */
	public BSTNode getright() {
		return right;
	}
	
	/**
	 * @return			the application field
	 */
	public App getapp() {
		return application;
	}
	
	/**     
	 * TRANSFORMERS
	 * 
	 * @param n			BSTNode to add on the left
	 */
	public void setleft(BSTNode n) {
		left = n;
	}
	
	/**
	 * @param n			BSTNode to add on the right
	 */
	public void setright(BSTNode n) {
		right = n;
	}
	
	/**
	 * @param a			App to copy into the node
	 */
	public void setapp(App a) {
		application = a.copyTo(a);
	}

}
