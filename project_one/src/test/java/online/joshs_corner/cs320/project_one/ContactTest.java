/**
 * 
 */
package online.joshs_corner.cs320.project_one;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * @author Joshua Wozny
 *
 */
class ContactTest {

	/**
	 * Test method for {@link online.joshs_corner.cs320.project_one.Contact#Contact(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testContactWithNullIdThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Contact newContact = new Contact(null,"Joshua","Wozny","6035559999","ANyStreet, AnyCity, USA");
			}
		});
	}
	@Test
	final void testContactWithEmptyIdThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Contact newContact = new Contact("","Joshua","Wozny","6035559998","ANyStreet, AnyCity, USA");
			}
		});
	}
	@Test
	final void testContactWithBlankIdThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Contact newContact = new Contact(" ","Joshua","Wozny","6035559997","ANyStreet, AnyCity, USA");
			}
		});
	}
	@Test
	final void testContactWithNewLineIdThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Contact newContact = new Contact("\n","Joshua","Wozny","6035559996","ANyStreet, AnyCity, USA");
			}
		});
	}
	@Test
	final void testContactWithValidProperties() throws Exception {
		Contact newContact = new Contact("JWOZNY","Joshua","Wozny","6035559995","ANyStreet, AnyCity, USA");
		assertTrue(newContact.getId()=="JWOZNY");
		assertTrue(newContact.getFirstName()=="Joshua");
		assertTrue(newContact.getLastName()=="Wozny");
		assertTrue(newContact.getPhone()=="6035559995");
		assertTrue(newContact.getAddress()=="ANyStreet, AnyCity, USA");
	}

	/**
	 * Test method for {@link online.joshs_corner.cs320.project_one.Contact#setFirstName(java.lang.String)}.
	 */
	@Test
	final void testSetFirstNameWithNullValueThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Contact newContact = new Contact("JWOZNY",null,"Wozny","6035559994","ANyStreet, AnyCity, USA");
			}
		});
	}
	@Test
	final void testSetFirstNameWithLengthOverTenThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Contact newContact = new Contact("JWOZNY","12345678910","Wozny","6035559993","ANyStreet, AnyCity, USA");
			}
		});
	}

	/**
	 * Test method for {@link online.joshs_corner.cs320.project_one.Contact#setLastName(java.lang.String)}.
	 */
	@Test
	final void testSetLastNameWithNullValueThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Contact newContact = new Contact("JWOZNY","Joshua",null,"60355599992","ANyStreet, AnyCity, USA");
			}
		});
	}
	@Test
	final void testSetLastNameWithLengthOverTenThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Contact newContact = new Contact("JWOZNY","Joshua","12345678910","6035559991","ANyStreet, AnyCity, USA");
			}
		});
	}

	/**
	 * Test method for {@link online.joshs_corner.cs320.project_one.Contact#setPhone(java.lang.String)}.
	 */
	@Test
	final void testSetPhoneWithNullValueThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Contact newContact = new Contact("JWOZNY","Joshua","Wozny",null,"ANyStreet, AnyCity, USA");
			}
		});
	}
	@Test
	final void testSetPhoneWithLengthLessThanTenThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Contact newContact = new Contact("JWOZNY","Joshua","Wozny","603555999","ANyStreet, AnyCity, USA");
			}
		});
	}
	@Test
	final void testSetPhoneWithLengthGreaterThanTenThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Contact newContact = new Contact("JWOZNY","Joshua","Wozny","60355599990","ANyStreet, AnyCity, USA");
			}
		});
	}
	final void testSetPhoneWithNonDigitWithLengthTenThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {			
			@Override
			public void execute() throws Throwable {
				Contact newContact = new Contact("JWOZNY","Joshua","Wozny","123555ABCD","ANyStreet, AnyCity, USA");
			}
		});
	}

	/**
	 * Test method for {@link online.joshs_corner.cs320.project_one.Contact#setAddress(java.lang.String)}.
	 */
	@Test
	final void testSetAddressWithNullValueThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Contact newContact = new Contact("JWOZNY","Joshua","Wozny","6035559989",null);
			}
		});
	}
	@Test
	final void testSetAddressWithLengthOverThirtyThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Contact newContact = new Contact("JWOZNY","Joshua","Wozny","6035559988","a123 ABC 456 DEF \t\n 7890 GHI JKL");
			}
		});
	}
	
}
