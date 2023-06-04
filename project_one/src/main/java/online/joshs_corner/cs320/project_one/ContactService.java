/**
 * 
 */
package online.joshs_corner.cs320.project_one;

/**
 * @author Joshua Wozny
 *
 */

import java.util.HashMap;

public final class ContactService {
	/*
	 * 
    The contact service shall be able to add contacts with unique ID.
    The contact service shall be able to delete contacts per contactId.
    The contact service shall be able to update contact fields per contactId. The following fields are updatable:
        firstName
        lastName
        PhoneNumber
        Address

	 */

	final EntityService service = new EntityService();

	public void addContact(Contact contact) throws Exception {
		service.addEntity((Entity)contact);
	}
	public void deleteContact(String id) {
		service.deleteEntityById(id);
	}
	public void updateFirstName(String id, String newFirstName) throws Exception {
			Contact contact = (Contact) service.getEntityById(id);
			if(contact == null) throw new Exception("Contact does not exist");	
			contact.setFirstName(newFirstName);
			service.update(contact);
	}
	public void updateLastName(String id, String newLastName) throws Exception {
		Contact contact = (Contact) service.getEntityById(id);
		if(contact == null) throw new Exception("Contact does not exist");	
		contact.setLastName(newLastName);
		service.update(contact);
	}
	public void updatePhone(String id, String newPhone) throws Exception {
		Contact contact = (Contact) service.getEntityById(id);
		if(contact == null) throw new Exception("Contact does not exist");	
		contact.setPhone(newPhone);
		service.update(contact);
	}
	public void updateAddress(String id, String newAddress) throws Exception {
		Contact contact = (Contact) service.getEntityById(id);
		if(contact == null) throw new Exception("Contact does not exist");	
		contact.setAddress(newAddress);
		service.update(contact);
	}
	public Boolean contactExists(String id) {
		return service.entityExists(id);
	}
	public Contact getContactById(String id) {
		return (Contact) service.getEntityById(id);
	}
}
