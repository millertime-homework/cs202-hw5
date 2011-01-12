package accountdatabase;

import java.io.*;

/**
 * The controlling class for ForgetMeNots.
 * Need to have a machine booted up, can then
 * create a login on that machine and that acts
 * as the security locking away your password
 * information. Remember to store the file
 * '.myapps' safely! 
 * 
 * @author Russell Miller
 */
class User {
	
	/** identifier to list users with */
	private String username;
	
	/** simulates security.. */
	private String password;
	
	/** tree of apps - stores temporary 
	  * information before saving file */
	private BST tree_of_apps;
	
	/** allows reading from STDIO */
	private BufferedReader stdin;

	/** Constructor	 */
	public User(String name, String passwd) {
		username = new String(name);
		password = new String(passwd);
		tree_of_apps = new BST();
		stdin = new BufferedReader(new InputStreamReader(System.in));
	}
	
	/** 
	 * @return 			username
	 */
	public String getname() {
		return username;
	}
	
	/** 
	 * @return			password
	 */
	public String getpasswd() {
		return password;
	}
	
	/** 
	 * Displays the menu options and runs selected function
	 */
	public void display() {
		while (true) {
			System.out.print(username);
			System.out.println("'s Forget-Me-Not");
			System.out.println("----------------------------");
			System.out.println("1. Add a  Maintained App  (uses an update url)");
			System.out.println("2. Add a  Licensed App    (uses product key / serial number)");
			System.out.println("3. Add an Email-Based App (uses e-mail address)");
			System.out.println("4. Print current apps");
			System.out.println("5. Remove an app");
			System.out.println("6. Export to file '.myapps' and quit");
			System.out.println("7. Return to System Menu");
			System.out.println("8. Exit");
			
			/**gets input as a string, converts it to an int*/
			String s; int choice;
			try {
				s = stdin.readLine();
				String[] numArray = s.split(" ");
				choice = Integer.parseInt(numArray[0]);
			} catch(IOException e) {
				throw new RuntimeException(e);
			}
			switch(choice) {
			case 1:
				add_MaintainedApp();
				break;
			case 2:
				add_LicensedApp();
				break;
			case 3:
				add_EmailBasedApp();
				break;
			case 4:
				tree_of_apps.printtree();
				break;
			case 5:
				remove_app();
				break;
			case 6:
				write_to_file();
				break;
			case 7:
				return;
			case 8:
				System.exit(0);
				break;
			default:
				invalidInput();
			}
		}
	}
	
	/**
	 * Handy function to help gather user input
	 * 
	 * @return 			a string from input
	 */
	public String get_input() {
		String input;
		try {
			input = stdin.readLine();
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
		return input;
	}
	
	/**
	 * adds the first of the three custom app types
	 * includes a String update url
	 */
	public void add_MaintainedApp() {
		System.out.print("Name of application? ");
		String a = get_input();
		System.out.print("Your user name? ");
		String u = get_input();
		System.out.print("Your password? ");
		String p = get_input();
		System.out.print("Update url? ");
		String r = get_input();
		App newapp = new MaintainedApp(a, u, p, r);
		tree_of_apps.insert(newapp);
	}
	
	/**
	 * adds the second of the three custom app types
	 * includes a String serial number
	 */
	public void add_LicensedApp() {
		System.out.print("Name of application? ");
		String a = get_input();
		System.out.print("Your user name? ");
		String u = get_input();
		System.out.print("Your password? ");
		String p = get_input();
		System.out.print("Serial number? ");
		String s = get_input();
		App newapp = new MaintainedApp(a, u, p, s);
		tree_of_apps.insert(newapp);
	}
	
	/**
	 * adds the third of the three custom app types
	 * includes a String e-mail address
	 */
	public void add_EmailBasedApp() {
		System.out.print("Name of application? ");
		String a = get_input();
		System.out.print("Your user name? ");
		String u = get_input();
		System.out.print("Your password? ");
		String p = get_input();
		System.out.print("E-mail address? ");
		String e = get_input();
		App newapp = new MaintainedApp(a, u, p, e);
		tree_of_apps.insert(newapp);
	}
	
	public void remove_app() {
		System.out.print("App to remove: ");
		String r = get_input();
		tree_of_apps.delete(r);
	}
	
	/**
	 * Copies all information
	 * from tree into a file and exits
	 */
	public void write_to_file() {
		tree_of_apps.write();
		System.exit(0);
	}
	
	/** simple error statement and exit */
	public void invalidInput() {
		System.out.println("Invalid option selected.");
		System.exit(-1);
	}
	
}
