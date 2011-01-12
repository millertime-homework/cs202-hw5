package accountdatabase;

/**
 * Licensed application information
 * extends the password remembering functionality
 * of App, adding an update url to existing stored info.
 * 
 * @author Russell Miller
 */
class MaintainedApp extends App {
	
	/**data that makes maintained app unique*/
	private String update_url;

	/**					
	 * CONSTRUCTOR
	 * 
	 * @param name				set app name
	 * @param user				set app username
	 * @param password			set app password
	 * @param url				set app update url
	 */
	public MaintainedApp(String name, String user, String password, String url) {
	
		super(name, user, password);
		update_url = new String();
		update_url = url;
	
	}
	
	/**					
	 * COPY CONSTRUCTOR
	 * 
	 * @param a					app to copy from
	 */
	public MaintainedApp(MaintainedApp a) {
		super(a.name, a.username, a.password);
		if (a.update_url != null)
			this.update_url = new String(a.update_url);
		else
			this.update_url = new String("");
	}
	
	/* 
	 * @see forgetmenot.App#copyTo(forgetmenot.App)
	 */
	public MaintainedApp copyTo(App a) {
		return new MaintainedApp((MaintainedApp)a);
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
		System.out.print("update url: ");
		System.out.println(update_url);
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
		super.writer.append("\nupdate url: ");
		super.writer.append(update_url);
		super.writer.append("\n");
		super.writer.close();
	}
	
}
