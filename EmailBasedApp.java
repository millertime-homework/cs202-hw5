package accountdatabase;

/**
 * Licensed application information
 * extends the password remembering functionality
 * of App, adding an update url to existing stored info.
 * 
 * @author Russell Miller
 */
class EmailBasedApp extends App {
	
	/**	data that makes email-based app unique */
	private String email_address;
	
	/**				
	 * CONSTRUCTOR
	 * 
	 * @param name				sets app name
	 * @param user				sets app username
	 * @param password			sets app password
	 * @param email				sets app email
	 */
	EmailBasedApp(String name, String user, String password, String email) {
		super(name, user, password);
		email_address = new String();
		email_address = email;
	}
	
	/**				
	 * COPY CONSTRUCTOR
	 * 
	 * @param a					App copying from
	 */
	public EmailBasedApp(EmailBasedApp a) {
		super(a.name, a.username, a.password);
		if (a.email_address != null)
			this.email_address = new String(a.email_address);
		else
			this.email_address = new String("");
	}
	
	/* 
	 * @see forgetmenot.App#copyTo(forgetmenot.App)
	 */
	public EmailBasedApp copyTo(App a) {
		return new EmailBasedApp((EmailBasedApp)a);
	}
	
	/* 
	 * @see forgetmenot.App#display()
	 */
	public void display() {
		System.out.println("");
		System.out.print("app: ");
		System.out.println(super.name);
		System.out.print("username: ");
		System.out.println(super.username);
		System.out.print("password: ");
		System.out.println(super.password);
		System.out.print("email address: ");
		System.out.println(email_address);
		System.out.println("");
		
	}
	
	/* 
	 * @see forgetmenot.App#write()
	 */
	public void write() {
		super.writer.append("\napp: ");
		super.writer.append(super.name);
		super.writer.append("\nusername: ");
		super.writer.append(super.username);
		super.writer.append("\npassword: ");
		super.writer.append(super.password);
		super.writer.append("\nemail address: ");
		super.writer.append(email_address);
		super.writer.append("\n");
		super.writer.close();
	}
	
}