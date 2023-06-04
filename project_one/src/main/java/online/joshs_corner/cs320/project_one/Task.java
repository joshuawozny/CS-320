/**
 * 
 */
package online.joshs_corner.cs320.project_one;

/**
 * @author Joshua Wozny
 *
 */
public final class Task extends Entity {
	/*
    The task object shall have a required unique task ID String that cannot be longer than 10 characters. The task ID shall not be null and shall not be updatable.
    The task object shall have a required name String field that cannot be longer than 20 characters. The name field shall not be null.
    The task object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.
	 */

	private String name;
	private String description;
	
	/**
	 * @param id
	 * @throws Exception 
	 */
	public Task(String id, String name, String description) throws Exception {
		super(id);
		this.setName(name);
		this.setDescription(description);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 * @throws Exception 
	 */
	public void setName(String name) throws Exception {
		//Validations
		if(name==null) throw new Exception("Name cannot be null");
		if(name.trim().length()>20) throw new Exception("Name cannot be more than 20 characters long");
		
		//Setter
		this.name = name;
	}

	/**
	 * @return the description 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param descritption the description to set
	 */
	public void setDescription(String description) throws Exception {
		//Validation
		if(description==null) throw new Exception("Description cannot be null");
		if(description.trim().length()>50) throw new Exception("Description cannot be more than 50 characters long");
		
		//Setter
		this.description = description;
	}
}

