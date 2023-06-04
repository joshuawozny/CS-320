/**
 * 
 */
package online.joshs_corner.cs320.project_one;

import java.util.Date;

/**
 * @author Joshua Wozny
 *
 */
public final class Appointment extends Entity {
	/*
    The appointment object shall have a required unique appointment ID String that cannot be longer than 10 characters. The appointment ID shall not be null and shall not be updatable.
    The appointment object shall have a required appointment Date field. The appointmentDate field cannot be in the past. The appointmentDate field shall not be null. Note: Use java.util.Date for the appointmentDate field and use before(new Date()) to check if the date is in the past.
    The appointment object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.
	 */

	private Date appointmentDate;
	private String description;
	
	/**
	 * @param id
	 * @throws Exception 
	 */
	public Appointment(String id, Date appointmentDate, String description) throws Exception {
		super(id);
		this.setAppointmentDate(appointmentDate);
		this.setDescription(description);
	}

	/**
	 * @return the name
	 */
	public Date getAppointmentDate() {
		return appointmentDate;
	}

	/**
	 * @param appointmentDate the appointmentDate to set
	 * @throws Exception 
	 */
	public void setAppointmentDate(Date appointmentDate) throws Exception {
		//Validations
		if(appointmentDate==null) throw new Exception("Date cannot be null");
		if(appointmentDate.before(new Date())) throw new Exception("Date cannot be in the past");
		
		//Setter
		this.appointmentDate = appointmentDate;
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

