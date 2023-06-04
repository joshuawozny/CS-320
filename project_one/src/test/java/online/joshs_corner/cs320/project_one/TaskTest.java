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
class TaskTest {

	/**
	 * Test method for {@link online.joshs_corner.cs320.project_one.Task#Task(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testTaskWithNullIdThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Task newTask = new Task(null,"Wash Dishes","Soak Pans\nWash Dishes\nRinse Dishes");
			}
		});
	}
	@Test
	final void testTaskWithEmptyIdThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Task newTask = new Task("","Wash Dishes","Soak Pans\nWash Dishes\nRinse Dishes");
			}
		});
	}
	@Test
	final void testTaskWithBlankIdThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Task newTask = new Task(" ","Wash Dishes","Soak Pans\nWash Dishes\nRinse Dishes");
			}
		});
	}
	@Test
	final void testTaskWithNewLineIdThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Task newTask = new Task("\n","Wash Dishes","Soak Pans\nWash Dishes\nRinse Dishes");
			}
		});
	}
	@Test
	final void testTaskWithValidProperties() throws Exception {
		Task newTask = new Task("JWOZNY-01","Wash Dishes","Soak Pans\nWash Dishes\nRinse Dishes");
		assertTrue(newTask.getId()=="JWOZNY-01");
		assertTrue(newTask.getName()=="Wash Dishes");
		assertTrue(newTask.getDescription()=="Soak Pans\nWash Dishes\nRinse Dishes");
	}

	/**
	 * Test method for {@link online.joshs_corner.cs320.project_one.Task#setName(java.lang.String)}.
	 */
	@Test
	final void testSetNameWithNullValueThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Task newTask = new Task("JWOZNY-01",null,"Soak Pans\\nWash Dishes\\nRinse Dishes");
			}
		});
	}
	@Test
	final void testSetNameWithLengthOverTwentyThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Task newTask = new Task("JWOZNY-01","ABCDEFGHIJKLMNOPQR123","Soak Pans\\nWash Dishes\\nRinse Dishes");
			}
		});
	}

	/**
	 * Test method for {@link online.joshs_corner.cs320.project_one.Task#setDescription(java.lang.String)}.
	 */
	@Test
	final void testSetDescriptionWithNullValueThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Task newTask = new Task("JWOZNY-01","Wash Dishes",null);
			}
		});
	}
	@Test
	final void testDescriptionWithLengthOverFiftyThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Task newTask = new Task("JWOZNY-01","Wash Dishes","ABCDEFGHIJKLMNOPQRSTUVWXYZ ABCDEFGHIJKLMNOPQRSTUVWX");
			}
		});
	}
}
