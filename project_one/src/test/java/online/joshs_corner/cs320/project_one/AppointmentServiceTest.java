/**
 * 
 */
package online.joshs_corner.cs320.project_one;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Joshua WOzny
 *
 */
class AppointmentServiceTest {

	AppointmentService appointmentService;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		appointmentService = new AppointmentService();
	}

	/**
	 * Test method for {@link online.joshs_corner.cs320.project_one.AppointmentService#addAppointment(online.joshs_corner.cs320.project_one.Appointment)}.
	 */
	@Test
	final void testAddAppointmentWithUniqueId() {
		try {
			Date todaysDate = new Date();
			long ltime = todaysDate.getTime()+8*24*60*60*1000;
			Appointment appointment = new Appointment("JWOZNY001",new Date(ltime),"Dr's Appoint in Wells River");
			appointmentService.addAppointment(appointment);
			assertTrue(appointmentService.appointmentExists("JWOZNY001"));
		}catch(Exception e) {
			fail(e.getMessage());
		}

	}
	@Test
	final void testAddAppointmentWithDuplicateId() {
		try {
			Date todaysDate = new Date();
			long ltime = todaysDate.getTime()+8*24*60*60*1000;
			Appointment appointment1 = new Appointment("JWOZNY001",new Date(ltime),"Dr's Appoint in Wells River");
			Appointment appointment2 = new Appointment("JWOZNY001",new Date(ltime),"Dr's Appoint in Wells River");
			appointmentService.addAppointment(appointment1);
			appointmentService.addAppointment(appointment2);
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
	final void testAddAppointmentWithInvalidAppointment() {
		try {
			Appointment appointment = new Appointment("JWOZNY001",null,"Dr's Appoint in Wells River");
			appointmentService.addAppointment(appointment);
			fail("Should throw exception");
		}catch(Exception e) {
			if(e.getMessage()=="Date cannot be null") {
				assertTrue(true);
			}
			else {
				fail(e.getMessage());
			}			
		}
	}

	/**
	 * Test method for {@link online.joshs_corner.cs320.project_one.AppointmentService#deleteAppointment(java.lang.String)}.
	 */
	@Test
	final void testDeleteAppointmentAppointmentExists() {
		try {
			Date todaysDate = new Date();
			long ltime = todaysDate.getTime()+8*24*60*60*1000;
			Appointment appointment = new Appointment("JWOZNY001",new Date(ltime),"Dr's Appoint in Wells River");
			appointmentService.addAppointment(appointment);
			appointmentService.deleteAppointment("JWOZNY001");
			assertTrue(!appointmentService.appointmentExists("JWOZNY001"));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	@Test
	final void testDeleteAppointmentAppointmentDoesNotExists() {
		try {
			appointmentService.deleteAppointment("JSWOZNY001");
			assertTrue(!appointmentService.appointmentExists("JSWOZNY001"));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link online.joshs_corner.cs320.project_one.AppointmentService#updateDate(java.lang.String, java.util.Date)}.
	 */
	@Test
	final void testUpdateAppointmentDateWithExistingAppointment() {
		try {
			Date todaysDate = new Date();
			long ltime = todaysDate.getTime()+8*24*60*60*1000;
			long ltime2 = ltime + 24*60*60*1000;
			long ltime2MinusOffset = ltime2 - 60*1000;
			long ltime2PlusOffset = ltime2 + 60*1000;
			Appointment appointment = new Appointment("JWOZNY001",new Date(ltime),"Dr's Appoint in Wells River");
			appointmentService.addAppointment(appointment);
			appointmentService.updateAppointmentDate("JWOZNY001",new Date(ltime2));
			assertTrue(appointment.getAppointmentDate().after(new Date(ltime2MinusOffset))&appointment.getAppointmentDate().before(new Date(ltime2PlusOffset)) );
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	@Test
	final void testUpdateAppointmentDateWithNonExistingTask() {
		try {
			Date todaysDate = new Date();
			long ltime = todaysDate.getTime()+8*24*60*60*1000;
			appointmentService.updateAppointmentDate("JSWOZNY001",new Date(ltime));
			fail("Should throw exception");
		}catch(Exception e) {
			if(e.getMessage()=="Appointment does not exist") {
				assertTrue(true);
			}else {
			fail(e.getMessage());
			}
		}
	}
	@Test
	final void testUpdateAppointmentDateWithInvalidAppointmentDate() {
		try {
			Date todaysDate = new Date();
			long ltime = todaysDate.getTime()+ 24*60*60*1000;
			Appointment appointment = new Appointment("JWOZNY001",new Date(ltime),"Dr's Appoint in Wells River");
			appointmentService.addAppointment(appointment);
			appointmentService.updateAppointmentDate("JWOZNY001",null);
			fail("Should throw exception");
		}catch(Exception e) {
			if(e.getMessage()=="Date cannot be null") {
				assertTrue(true);
			}else {
			fail(e.getMessage());
			}
		}
	}

	/**
	 * Test method for {@link online.joshs_corner.cs320.project_one.AppointmentService#updateDescription(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testUpdateDescriptionWithExistingAppointment() {
		try {
			Date todaysDate = new Date();
			long ltime = todaysDate.getTime()+ 24*60*60*1000;
			Appointment appointment = new Appointment("JWOZNY001",new Date(ltime),"Dr's Appoint in Wells River");
			appointmentService.addAppointment(appointment);
			appointmentService.updateDescription("JWOZNY001","Dr's Appoint in Woodsville");
			assertTrue(appointmentService.getAppointmentById("JWOZNY001").getDescription()=="Dr's Appoint in Woodsville");
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	@Test
	final void testUpdateDescriptionWithNonExistingAppointment() {
		try {
			appointmentService.updateDescription("JSWOZNY001","Dr's Appoint in Woodsville");
			fail("Should throw exception");
		}catch(Exception e) {
			if(e.getMessage()=="Appointment does not exist") {
				assertTrue(true);
			}else {
			fail(e.getMessage());
			}
		}
	}
	@Test
	final void testUpdateDescriptionWithInvalidDescription() {
		try {
			Date todaysDate = new Date();
			long ltime = todaysDate.getTime()+ 24*60*60*1000;
			Appointment appointment = new Appointment("JWOZNY001",new Date(ltime),"Dr's Appoint in Wells River");
			appointmentService.addAppointment(appointment);
			appointmentService.updateDescription("JWOZNY001",null);
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
