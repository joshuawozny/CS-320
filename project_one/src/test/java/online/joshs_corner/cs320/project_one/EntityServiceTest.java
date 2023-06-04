package online.joshs_corner.cs320.project_one;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntityServiceTest {

	EntityService service;
	
	@BeforeEach
	void setUp() throws Exception {
		service = new EntityService();
	}

	@Test
	final void testUpdateIfIdDoesNotExist() {
		try{
			Contact contact = new Contact("JWOZNY","Joshua","Wozny","6035559999","123 Any Street\nAnyTown USA");
			service.update(contact);
			fail("Should throw exception.");
		}catch(Exception e){
			if(e.getMessage()=="Entity does not exist.") {
				assertTrue(true);
			}else {
			fail(e.getMessage());
			}
		}
		
	}

}
