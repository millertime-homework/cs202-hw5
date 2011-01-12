package accountdatabase;

/**
 * Licensed application information
 * extends the password remembering functionality
 * of App, adding a serial number to the existing stored info.
 * 
 * @author Russell Miller
 */
class LicensedApp extends App {
	
	/**the data that makes LicensedApp unique*/
	private String serial_number;
	
	/**
	 * Constructor
	 * 
	 * @param name				sets app name
	 * @param password			sets app password
	 * @param serial			sets app serial number
	 */
	public LicensedApp(String name, String user, String password, String serial) {
		super(name, user, password);
		serial_number = new String(serial);
	}
	
	/**
	 * Copy Constructor
	 * 
	 * @param a					App to be copied from
	 */
	public LicensedApp(LicensedApp a) {
		super(a.name, a.username, a.password);
		if (a.serial_number != null)
			this.serial_number = new String(a.serial_number);
		else
			this.serial_number = new String("");
	}
	
	/* 
	 * @see forgetmenot.App#copyTo(forgetmenot.App)
	 */
	public LicensedApp copyTo(App a) {
		return new LicensedApp((LicensedApp)a);
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
		System.out.print("serial number: ");
		System.out.println(serial_number);
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
		super.writer.append("\nserial number: ");
		super.writer.append(serial_number);
		super.writer.append("\n");
		super.writer.close();
	}
	
}