package accountdatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * The UI for working with account Machines.
 * Once Machines are created, (which are synonymous
 * with "Systems") Users can be created and application
 * information can be saved.
 * 
 * @author Russell Miller
 */
class Menu {

	/**a circular linked list of machines*/
	private CLL system_list;
	
	/**allows reading from STDIO*/
	private BufferedReader stdin;
	
	/** 
	 * constructor. 
	 */
	public Menu() {
		system_list = new CLL();
		stdin = new BufferedReader(new InputStreamReader(System.in));
	}
	
	/** 
	 * Displays the menu options and runs selected function
	 */
	public void display() {
		while (true) {
			System.out.println("MillerTime's multi-user AccountDatabase");
			System.out.println("---------------------------------------");
			System.out.println("1. Add a System");
			System.out.println("2. Display Systems");
			System.out.println("3. Boot up System");
			System.out.println("4. Exit");
			/** s: for getting input as a string 
			 *  i: for converting it to an int
			 */
			String s; int choice;
			try {
				s = stdin.readLine();
				if (s.compareTo("") == 0) System.exit(-1);
				/** numArray: works some magic to get an int
				 */
				String[] numArray = s.split(" ");
				choice = Integer.parseInt(numArray[0]);
			} catch(IOException e) {
				throw new RuntimeException(e);
			}
			switch(choice) {
			case 1:
				add_Machine();
				break;
			case 2:
				system_list.display();
				break;
			case 3:
				login();
				break;
			case 4:
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
	 * invalidInput - simple error statement and exit
	 */
	public void invalidInput() {
		System.out.println("Invalid option selected.");
		System.exit(-1);
	}
	
	/** 
	 * Add a machine to the list
	 */
	public void add_Machine() {
		System.out.print("System name: ");
		String m = get_input();
		Machine newmachine = new Machine(m);
		system_list.insert(newmachine);
	}
	
	/** 
	 * Boots up a system from the list
	 * if able to find one that matches name
	 */
	public void login() {
		System.out.print("System name: ");
		String s = get_input();
		/**find returns a machine, so this will 
		 * point to a machine if a match is found*/
		Machine m = system_list.find(s);
		if (m == null) {
			/**do nothing*/
		}
		else {
			m.bootup();
		}
	}
	
}
