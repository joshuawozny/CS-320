/**
 * 
 */
package online.joshs_corner.cs320.project_one;

/**
 * @author Joshua Wozny
 *
 */
abstract class Entity {
	/*
    The contact object shall have a required unique contact ID String that cannot be longer than 10 characters. The contact ID shall not be null and shall not be updatable.
	 */
	private final String id;  //final makes it immutable
	
	/**
	 * @param id
	 * @throws Exception 
	 */
	public Entity(String id) throws Exception {
		super();
		// Validation
		if(id==null) throw new Exception("Id cannot be null");
		if(id.trim().length()<1||id.trim().length()>10) throw new Exception("Id must be between 1 and 10 characters long");
		
		this.id = id.trim();
	}

	public String getId() {
		return id;
	}
}
