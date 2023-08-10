
public class User {
	
	//Creating the fields
	private String username;
	private String password;
	private String email;
	private int contact;
	private String address;
	
	//Constructor
	public User(String username, String password, String email, int contact, String address) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.contact = contact;
		this.address = address;
		
	}
	
	//Getters	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public int getContact() {
		return contact;
	}

	public String getAddress() {
		return address;
	}
	
	//Setters
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
	
	
	
	
	
	

}
