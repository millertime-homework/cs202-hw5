package accountdatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A system to store a list of users
 * who each store a tree of apps
 * 
 * @author Russell Miller
 */
class Machine {

	/** used for differentiating between different systems of users */
	private String machine_name;
	
	/** the list of users on the machine */
	private LLL user_list;
	
	/** allows reading from STDIO */
	private BufferedReader stdin;
	
	/** 
	 * Constructor
	 * 
	 * @param name			sets the machine name
	 */
	public Machine(String name) {
		machine_name = new String(name);
		user_list = new LLL();
		stdin = new BufferedReader(new InputStreamReader(System.in));
	}
	
	/** 
	 * @return 				name
	 */
	public String getname() {
		return machine_name;
	}
	
	/** 
	 * Similar to turning on a computer, takes you to a
	 * list of users where you can pick one and log in,
	 * or return to the main menu.
	 */
	public void bootup() {
		while (true) {
			System.out.print(machine_name);
			System.out.println(" - System Menu");
			System.out.println("-------------------");
			System.out.println("1. Add a User");
			System.out.println("2. Display Users");
			System.out.println("3. Log in");
			System.out.println("4. Return to Main menu");
			System.out.println("5. Exit");
			/** s: for getting input as a string 
			 *  i: for converting it to an int */
			String s; int choice;
			try {
				s = stdin.readLine();
				/** numArray: works some magic to get an int */
				String[] numArray = s.split(" ");
				choice = Integer.parseInt(numArray[0]);
			} catch(IOException e) {
				throw new RuntimeException(e);
			}
			switch(choice) {
			case 1:
				add_User();
				break;
			case 2:
				user_list.display();
				break;
			case 3:
				login();
				break;
			case 4:
				return;
			case 5:
				System.exit(0);
				break;
			default:
				invalidInput();
			}
		}
	}
	
	/**
	 * handy function to simplify input gathering
	 * 
	 * @return String		for using strings from STDIO
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
	 * simple error statement and exit
	 */
	public void invalidInput() {
		System.out.println("Invalid option selected.");
		System.exit(-1);
	}
	
	/** 
	 * creates a User that the user_list
	 * can insert. this does undo the functionality
	 * of the ForgetMeNot by asking for a password, 
	 * but think of this as a global password for
	 * having access to your full store of personal
	 * info
	 */
	public void add_User() {
		System.out.print("User name: ");
		String u = get_input();
		System.out.print("Type a password: ");
		String p = get_input();
		User newuser = new User(u, p);
		user_list.insert(newuser);
	}
	
	/** 
	 * first tries to find the given
	 * username in the list, then tries to match
	 * the given password to allow access. 
	 */
	public void login() {
		System.out.print("User name: ");
		String u = get_input();
		/** attempt to get a user by finding the given name */
		User user = user_list.find(u);
		if (user == null) {
			/** find returns null if not found. the
			 *  call below returns you to the menu */
			this.bootup();
		}
		System.out.print("Password: ");
		String p = get_input();
		if (p.compareTo(user.getpasswd()) == 0) {
			/** password matched, allow access */
			user.display();
		}
		else {
			System.out.println("Password mismatch, please try again.");
			/** return to the menu */
			this.bootup();
		}
	}
}
