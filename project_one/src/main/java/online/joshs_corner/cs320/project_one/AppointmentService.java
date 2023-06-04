/**
 * 
 */
package online.joshs_corner.cs320.project_one;

import java.util.Date;

/**
 * @author Joshua Wozny
 *
 */

import java.util.HashMap;

public final class AppointmentService {
	/*   
    The appointment service shall be able to add appointments with a unique appointmentId.
    The appointment service shall be able to delete appointments per appointmentId.
	 */

	final EntityService service = new EntityService();

	public void addAppointment(Appointment appointment) throws Exception {
		service.addEntity((Entity)appointment);
	}
	public void deleteAppointment(String id) {
		service.deleteEntityById(id);
	}
	public void updateAppointmentDate(String id, Date newAppointmentDate) throws Exception {
			Appointment appointment = (Appointment) service.getEntityById(id);
			if(appointment == null) throw new Exception("Appointment does not exist");	
			appointment.setAppointmentDate(newAppointmentDate);
			service.update(appointment);
	}
	public void updateDescription(String id, String newDescription) throws Exception {
		Appointment appointment = (Appointment) service.getEntityById(id);
		if(appointment == null) throw new Exception("Appointment does not exist");	
		appointment.setDescription(newDescription);
		service.update(appointment);
	}
	public Boolean appointmentExists(String id) {
		return service.entityExists(id);
	}
	public Appointment getAppointmentById(String id) {
		return (Appointment) service.getEntityById(id);
	}
}
