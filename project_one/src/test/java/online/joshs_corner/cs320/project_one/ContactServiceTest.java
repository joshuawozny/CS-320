/**
 * 
 */
package online.joshs_corner.cs320.project_one;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Joshua WOzny
 *
 */
class ContactServiceTest {

	ContactService contactService;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		contactService = new ContactService();
	}

	/**
	 * Test method for {@link online.joshs_corner.cs320.project_one.ContactService#addContact(online.joshs_corner.cs320.project_one.Contact)}.
	 */
	@Test
	final void testAddContactWithUniqueId() {
		try {
			Contact contact = new Contact("JWOZNY","Joshua","Wozny","6035559999","123 Any Street\nAnyTown USA");
			contactService.addContact(contact);
			assertTrue(contactService.contactExists("JWOZNY"));
		}catch(Exception e) {
			fail(e.getMessage());
		}

	}
	@Test
	final void testAddContactWithDuplicateId() {
		try {
			Contact contact1 = new Contact("JWOZNY","Joshua","Wozny","6035559999","123 Any Street\nAnyTown USA");
			Contact contact2 = new Contact("JWOZNY","Jeremy","Wozny","6035559998","123 Other Street\nAnyTown USA");
			contactService.addContact(contact1);
			contactService.addContact(contact2);
			fail("Should throw exception");
		}catch(Exception e) {
			if(e.getMessage()=="Entity already exists.") {
				assertTrue(true);
			}
			else {
				fail(e.getMessage());
			}			
		}
	}
	@Test
	final void testAddContactWithInvalidContact() {
		try {
			Contact contact = new Contact("JWOZNY","Jeremy","Wozny","6035559998","123 Any Other Street\nAnyTown USA");
			contactService.addContact(contact);
			fail("Should throw exception");
		}catch(Exception e) {
			if(e.getMessage()=="Address cannot be more than 30 characters long") {
				assertTrue(true);
			}
			else {
				fail(e.getMessage());
			}			
		}
	}

	/**
	 * Test method for {@link online.joshs_corner.cs320.project_one.ContactService#deleteContact(java.lang.String)}.
	 */
	@Test
	final void testDeleteContactContactExists() {
		try {
			Contact contact = new Contact("JWOZNY","Joshua","Wozny","6035559999","123 Any Street\nAnyTown USA");
			contactService.addContact(contact);
			contactService.deleteContact("JWOZNY");
			assertTrue(!contactService.contactExists("JWOZNY"));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	@Test
	final void testDeleteContactContactDoesNotExists() {
		try {
			Contact contact = new Contact("JWOZNY","Joshua","Wozny","6035559999","123 Any Street\nAnyTown USA");
			contactService.addContact(contact);
			contactService.deleteContact("JSWOZNY");
			assertTrue(!contactService.contactExists("JSWOZNY"));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link online.joshs_corner.cs320.project_one.ContactService#updateFirstName(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testUpdateFirstNameWithExistingContact() {
		try {
			Contact contact = new Contact("JWOZNY","Joshua","Wozny","6035559999","123 Any Street\nAnyTown USA");
			contactService.addContact(contact);
			contactService.updateFirstName("JWOZNY","Jeremy");
			assertTrue(contactService.getContactById("JWOZNY").getFirstName()=="Jeremy");
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	@Test
	final void testUpdateFirstNameWithNonExistingContact() {
		try {
			Contact contact = new Contact("JWOZNY","Joshua","Wozny","6035559999","123 Any Street\nAnyTown USA");
			contactService.addContact(contact);
			contactService.updateFirstName("JSWOZNY","Jeremy");
			fail("Should throw exception");
		}catch(Exception e) {
			if(e.getMessage()=="Contact does not exist") {
				assertTrue(true);
			}else {
			fail(e.getMessage());
			}
		}
	}
	@Test
	final void testUpdateFirstNameWithInvalidName() {
		try {
			Contact contact = new Contact("JWOZNY","Joshua","Wozny","6035559999","123 Any Street\nAnyTown USA");
			contactService.addContact(contact);
			contactService.updateFirstName("JWOZNY",null);
			fail("Should throw exception");
		}catch(Exception e) {
			if(e.getMessage()=="First name cannot be null") {
				assertTrue(true);
			}else {
			fail(e.getMessage());
			}
		}
	}

	/**
	 * Test method for {@link online.joshs_corner.cs320.project_one.ContactService#updateLastName(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testUpdateLastNameWithExistingContact() {
		try {
			Contact contact = new Contact("JWOZNY","Joshua","Wonzy","6035559999","123 Any Street\nAnyTown USA");
			contactService.addContact(contact);
			contactService.updateLastName("JWOZNY","Wozny");
			assertTrue(contactService.getContactById("JWOZNY").getLastName()=="Wozny");
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	@Test
	final void testUpdateLastNameWithNonExistingContact() {
		try {
			Contact contact = new Contact("JWOZNY","Joshua","Wonzy","6035559999","123 Any Street\nAnyTown USA");
			contactService.addContact(contact);
			contactService.updateLastName("JSWOZNY","Wozny");
			fail("Should throw exception");
		}catch(Exception e) {
			if(e.getMessage()=="Contact does not exist") {
				assertTrue(true);
			}else {
			fail(e.getMessage());
			}
		}
	}
	@Test
	final void testUpdateLastNameWithInvalidName() {
		try {
			Contact contact = new Contact("JWOZNY","Joshua","Wozny","6035559999","123 Any Street\nAnyTown USA");
			contactService.addContact(contact);
			contactService.updateLastName("JWOZNY",null);
			fail("Should throw exception");
		}catch(Exception e) {
			if(e.getMessage()=="Last name cannot be null") {
				assertTrue(true);
			}else {
			fail(e.getMessage());
			}
		}
	}

	/**
	 * Test method for {@link online.joshs_corner.cs320.project_one.ContactService#updatePhone(java.lang.String, java.lang.String)}.
	 */

	@Test
	final void testUpdatePhoneWithExistingContact() {
		try {
			Contact contact = new Contact("JWOZNY","Joshua","Wonzy","6035559999","123 Any Street\nAnyTown USA");
			contactService.addContact(contact);
			contactService.updatePhone("JWOZNY","6035559998");
			assertTrue(contactService.getContactById("JWOZNY").getPhone()=="6035559998");
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	@Test
	final void testUpdatePhoneWithNonExistingContact() {
		try {
			Contact contact = new Contact("JWOZNY","Joshua","Wonzy","6035559999","123 Any Street\nAnyTown USA");
			contactService.addContact(contact);
			contactService.updatePhone("JSWOZNY","6035559998");
			fail("Should throw exception");
		}catch(Exception e) {
			if(e.getMessage()=="Contact does not exist") {
				assertTrue(true);
			}else {
			fail(e.getMessage());
			}
		}
	}
	@Test
	final void testUpdatePhoneWithInvalidAddress() {
		try {
			Contact contact = new Contact("JWOZNY","Joshua","Wozny","6035559999","123 Other Street\nAnyTown USA");
			contactService.addContact(contact);
			contactService.updatePhone("JWOZNY","603555ABCD");
			fail("Should throw exception");
		}catch(Exception e) {
			if(e.getMessage()=="Phone must contain only digits") {
				assertTrue(true);
			}else {
			fail(e.getMessage());
			}
		}
	}

	/**
	 * Test method for {@link online.joshs_corner.cs320.project_one.ContactService#updateAddress(java.lang.String, java.lang.String)}.
	 */

	@Test
	final void testUpdateAddressWithExistingContact() {
		try {
			Contact contact = new Contact("JWOZNY","Joshua","Wonzy","6035559999","123 Any Street\nAnyTown USA");
			contactService.addContact(contact);
			contactService.updateAddress("JWOZNY","123 Other Street\nAnyTown USA");
			assertTrue(contactService.getContactById("JWOZNY").getAddress()=="123 Other Street\nAnyTown USA");
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	@Test
	final void testUpdateAddressWithNonExistingContact() {
		try {
			Contact contact = new Contact("JWOZNY","Joshua","Wonzy","6035559999","123 Any Street\nAnyTown USA");
			contactService.addContact(contact);
			contactService.updateAddress("JSWOZNY","123 Other Street\\\\nAnyTown USA");
			fail("Should throw exception");
		}catch(Exception e) {
			if(e.getMessage()=="Contact does not exist") {
				assertTrue(true);
			}else {
			fail(e.getMessage());
			}
		}
	}
	@Test
	final void testUpdateAddressWithInvalidAddress() {
		try {
			Contact contact = new Contact("JWOZNY","Joshua","Wozny","6035559999","123 Other Street\nAnyTown USA");
			contactService.addContact(contact);
			contactService.updateAddress("JWOZNY","123 Other Any Street\\nAnyTown USA");
			fail("Should throw exception");
		}catch(Exception e) {
			if(e.getMessage()=="Address cannot be more than 30 characters long") {
				assertTrue(true);
			}else {
			fail(e.getMessage());
			}
		}
	}

}
