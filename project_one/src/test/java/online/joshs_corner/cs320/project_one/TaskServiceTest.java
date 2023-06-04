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
class TaskServiceTest {

	TaskService taskService;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		taskService = new TaskService();
	}

	/**
	 * Test method for {@link online.joshs_corner.cs320.project_one.TaskService#addTask(online.joshs_corner.cs320.project_one.Task)}.
	 */
	@Test
	final void testAddTaskWithUniqueId() {
		try {
			Task task = new Task("JWOZNY-01","Wash Dishes","Soak Pans\nWash Dishes\nRinse Dishes");
			taskService.addTask(task);
			assertTrue(taskService.taskExists("JWOZNY-01"));
		}catch(Exception e) {
			fail(e.getMessage());
		}

	}
	@Test
	final void testAddTaskWithDuplicateId() {
		try {
			Task task1 = new Task("JWOZNY-01","Wash Dishes","Soak Pans\nWash Dishes\nRinse Dishes");
			Task task2 = new Task("JWOZNY-01","Wash Dishes","Soak Pans\nWash Dishes\nRinse Dishes");
			taskService.addTask(task1);
			taskService.addTask(task2);
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
	final void testAddTaskWithInvalidTask() {
		try {
			Task task = new Task("JWOZNY-01","ABCDEFGHIJKLMNOPQR123","Soak Pans\\nWash Dishes\\nRinse Dishes");
			taskService.addTask(task);
			fail("Should throw exception");
		}catch(Exception e) {
			if(e.getMessage()=="Name cannot be more than 20 characters long") {
				assertTrue(true);
			}
			else {
				fail(e.getMessage());
			}			
		}
	}

	/**
	 * Test method for {@link online.joshs_corner.cs320.project_one.TaskService#deleteTask(java.lang.String)}.
	 */
	@Test
	final void testDeleteTaskTaskExists() {
		try {
			Task task = new Task("JWOZNY-01","Wash Dishes","Soak Pans\nWash Dishes\nRinse Dishes");
			taskService.addTask(task);
			taskService.deleteTask("JWOZNY-01");
			assertTrue(!taskService.taskExists("JWOZNY-01"));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	@Test
	final void testDeleteTaskTaskDoesNotExists() {
		try {
			taskService.deleteTask("JSWOZNY-01");
			assertTrue(!taskService.taskExists("JSWOZNY-01"));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link online.joshs_corner.cs320.project_one.TaskService#updateName(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testUpdateNameWithExistingTask() {
		try {
			Task task = new Task("JWOZNY-01","Wash Dishes","Soak Pans\nWash Dishes\nRinse Dishes");
			taskService.addTask(task);
			taskService.updateName("JWOZNY-01","Dishes");
			assertTrue(taskService.getTaskById("JWOZNY-01").getName()=="Dishes");
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	@Test
	final void testUpdateNameWithNonExistingTask() {
		try {
			taskService.updateName("JSWOZNY-01","Dishes");
			fail("Should throw exception");
		}catch(Exception e) {
			if(e.getMessage()=="Task does not exist") {
				assertTrue(true);
			}else {
			fail(e.getMessage());
			}
		}
	}
	@Test
	final void testUpdateNameWithInvalidName() {
		try {
			Task task = new Task("JWOZNY-01",null,"Soak Pans\nWash Dishes\nRinse Dishes");
			taskService.addTask(task);
			taskService.updateName("JWOZNY",null);
			fail("Should throw exception");
		}catch(Exception e) {
			if(e.getMessage()=="Name cannot be null") {
				assertTrue(true);
			}else {
			fail(e.getMessage());
			}
		}
	}

	/**
	 * Test method for {@link online.joshs_corner.cs320.project_one.TaskService#updateDescription(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testUpdateDescriptionWithExistingTask() {
		try {
			Task task = new Task("JWOZNY-01","Wash Dishes","Soak Pans\nWash Dishes\nRinse Dishes");
			taskService.addTask(task);
			taskService.updateDescription("JWOZNY-01","Soak Pans\nWash Dishes\nRinse Dishes");
			assertTrue(taskService.getTaskById("JWOZNY-01").getDescription()=="Soak Pans\nWash Dishes\nRinse Dishes");
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	@Test
	final void testUpdateDescriptionWithNonExistingTask() {
		try {
			taskService.updateDescription("JSWOZNY-01","Dishes");
			fail("Should throw exception");
		}catch(Exception e) {
			if(e.getMessage()=="Task does not exist") {
				assertTrue(true);
			}else {
			fail(e.getMessage());
			}
		}
	}
	@Test
	final void testUpdateDescriptionWithInvalidDescription() {
		try {
			Task task = new Task("JWOZNY-01","Wash Dishes","Soak Pans\nWash Dishes\nRinse Dishes");
			taskService.addTask(task);
			taskService.updateDescription("JWOZNY-01",null);
			fail("Should throw exception");
		}catch(Exception e) {
			if(e.getMessage()=="Description cannot be null") {
				assertTrue(true);
			}else {
			fail(e.getMessage());
			}
		}
	}
}
