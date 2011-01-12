package accountdatabase;

import java.io.*;

/**
 * Application information. This class alone can 
 * store a password for you. Because this is far 
 * too simple, it has been made abstract. 
 * 
 * @author Russell Miller
 */
abstract class App {
	
	/**main identifier, sorted by this.*/
	protected String name;
	/**very basic username storage*/
	protected String username;
	/**very basic password storage*/
	protected String password;
	
	/**the file the info is saved to*/
	protected static String file = ".myapps";
	
	/**customer PrintWriter to allow sending to file*/
	protected PrintWriter writer;
		
	/**				
	 * Constructor
	 * 
	 * @param n String - used to set name
	 * @param u String - used to set username
	 * @param p String - used to set password
	 */
	public App(String n, String u, String p) {
		if (n != null)
			name = new String(n);
		else
			name = "";
		if (u != null)
			username = new String(u);
		else
			username = "";
		if (p != null)
			password = new String(p);
		else
			password = "";
		
		try {
			writer = new PrintWriter(new BufferedWriter(
					new FileWriter(file, true)));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
		
	/**				
	 * @return		retrieves private field name
	 */
	public String getname() {
		return name;
	}
	
	/**
	 * @return		retrieves private field username
	 */
	public String getuser() {
		return username;
	}
		
	/**
	 * @return		retrieves private field password
	 */
	public String getpass() {
		return password;
	}
	
	/**
	 * Pure virtual function that
	 * allows dynamic copies to be made
	 * 
	 * @param a				App to be copied
	 */
	public abstract App copyTo(App a);
	
	/**
	 * Pure virtual function that
	 * allows dynamic printing
	 */
	public abstract void display();
	
	/**
	 * Pure virtual function that
	 * allows dynamic file-writing
	 */
	public abstract void write();

}