/**
 * 
 */
package online.joshs_corner.cs320.project_one;

/**
 * @author Joshua Wozny
 *
 */
public final class Contact extends Entity {
	/*
    The contact object shall have a required firstName String field that cannot be longer than 10 characters. The firstName field shall not be null.
    The contact object shall have a required lastName String field that cannot be longer than 10 characters. The lastName field shall not be null.
    The contact object shall have a required phone String field that must be exactly 10 digits. The phone field shall not be null.
    The contact object shall have a required address field that must be no longer than 30 characters. The address field shall not be null.	
	 */

	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	/**
	 * @param id
	 * @throws Exception 
	 */
	public Contact(String id, String firstName, String lastName, String phone, String address) throws Exception {
		super(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhone(phone);
		this.setAddress(address);
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 * @throws Exception 
	 */
	public void setFirstName(String firstName) throws Exception {
		//Validations
		if(firstName==null) throw new Exception("First name cannot be null");
		if(firstName.trim().length()>10) throw new Exception("First name cannot be more than 10 characters long");
		
		//Setter
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) throws Exception {
		//Validation
		if(lastName==null) throw new Exception("Last name cannot be null");
		if(lastName.trim().length()>10) throw new Exception("Last name cannot be more than 10 characters long");
		
		//Setter
		this.lastName = lastName;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) throws Exception {
		//Validation
		if(phone==null) throw new Exception("Phone cannot be null");
		if(phone.trim().length()!=10) throw new Exception("Phone must be 10 characters long");
		if(!isDigit(phone)) throw new Exception("Phone must contain only digits");
		
		//Setter
		this.phone = phone;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) throws Exception {
		//Validation
		if(address==null) throw new Exception("Address cannot be null");
		if(address.trim().length()>30) throw new Exception("Address cannot be more than 30 characters long");
		
		
		//Setter
		this.address = address;
	}
	
	//Private method for checking if a string is a digit used to validate phone numbers
	private boolean isDigit(String str) throws Exception {
		char[] chars = str.toCharArray();
		System.out.println(chars);
        
	      for (char ch : chars) {
	            if(!Character.isDigit(ch)) return false;
	        }
	      return true;
	}
}
