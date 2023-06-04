/**
 * 
 */
package online.joshs_corner.cs320.project_one;

/**
 * @author Joshua Wozny
 *
 */

import java.util.HashMap;

public final class TaskService {
	/*
	 * 
    The task service shall be able to add tasks with a unique ID.
    The task service shall be able to delete tasks per taskId.
    The task service shall be able to update task fields per taskId. The following fields are updatable:
        name
        description
	 */

	final EntityService service = new EntityService();

	public void addTask(Task task) throws Exception {
		service.addEntity((Entity)task);
	}
	public void deleteTask(String id) {
		service.deleteEntityById(id);
	}
	public void updateName(String id, String newName) throws Exception {
			Task task = (Task) service.getEntityById(id);
			if(task == null) throw new Exception("Task does not exist");	
			task.setName(newName);
			service.update(task);
	}
	public void updateDescription(String id, String newDescription) throws Exception {
		Task task = (Task) service.getEntityById(id);
		if(task == null) throw new Exception("Task does not exist");	
		task.setDescription(newDescription);
		service.update(task);
	}
	public Boolean taskExists(String id) {
		return service.entityExists(id);
	}
	public Task getTaskById(String id) {
		return (Task) service.getEntityById(id);
	}
}
