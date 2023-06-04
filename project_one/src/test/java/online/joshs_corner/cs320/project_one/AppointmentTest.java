/**
 * 
 */
package online.joshs_corner.cs320.project_one;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * @author Joshua Wozny
 *
 */
class AppointmentTest {

	/**
	 * Test method for {@link online.joshs_corner.cs320.project_one.Appointment#Appointment(java.lang.String, java.util.Date, java.lang.String)}.
	 */
	@Test
	final void testAppointmentWithNullIdThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Date todaysDate = new Date();
				long ltime = todaysDate.getTime()+8*24*60*60*1000;
				Appointment newAppointment = new Appointment(null,new Date(ltime),"Dr's Appoint in Wells River");
			}
		});
	}
	@Test
	final void testAppointmentWithEmptyIdThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Date todaysDate = new Date();
				long ltime = todaysDate.getTime()+8*24*60*60*1000;
				Appointment newAppointment = new Appointment("",new Date(ltime),"Dr's Appoint in Wells River");
			}
		});
	}
	@Test
	final void testAppointmentWithBlankIdThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Date todaysDate = new Date();
				long ltime = todaysDate.getTime()+8*24*60*60*1000;
				Appointment newAppointment = new Appointment(" ",new Date(ltime),"Dr's Appoint in Wells River");
			}
		});
	}
	@Test
	final void testAppointmentWithNewLineIdThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Date todaysDate = new Date();
				long ltime = todaysDate.getTime()+8*24*60*60*1000;
				Appointment newAppointment = new Appointment("\n",new Date(ltime),"Dr's Appoint in Wells River");
			}
		});
	}
	@Test
	final void testAppointmentWithValidProperties() throws Exception {
		Date todaysDate = new Date();
		long ltime = todaysDate.getTime()+8*24*60*60*1000;
		long ltimeMinusOffset = ltime - 60*1000;
		long ltimePlusOffset = ltime + 60*1000;
		Appointment newAppointment = new Appointment("JWOZNY001",new Date(ltime),"Dr's Appoint in Wells River");
		assertTrue(newAppointment.getId()=="JWOZNY001");
		assertTrue(newAppointment.getAppointmentDate().after(new Date(ltimeMinusOffset))&newAppointment.getAppointmentDate().before(new Date(ltimePlusOffset)) );
		assertTrue(newAppointment.getDescription()=="Dr's Appoint in Wells River");
	}

	/**
	 * Test method for {@link online.joshs_corner.cs320.project_one.Appointment#setAppointmentDate(java.util.Date)}.
	 */
	@Test
	final void testSetAppointmentDateWithNullValueThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Appointment newAppointment = new Appointment("JWOZNY001",null,"Dr's Appoint in Wells River");
			}
		});
	}
	@Test
	final void testSetAppointmentDateBeforeTodayThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Date todaysDate = new Date();
				long ltime = todaysDate.getTime()-24*60*60*1000;
				Appointment newAppointment = new Appointment("JWOZNY001",new Date(ltime),"Dr's Appoint in Wells River");
			}
		});
	}

	/**
	 * Test method for {@link online.joshs_corner.cs320.project_one.Appointment#setDescription(java.lang.String)}.
	 */
	@Test
	final void testSetDescriptionWithNullValueThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Date todaysDate = new Date();
				long ltime = todaysDate.getTime()+8*24*60*60*1000;
				Appointment newAppointment = new Appointment("JWOZNY001",new Date(ltime),null);
			}
		});
	}
	@Test
	final void testDescriptionWithLengthOverFiftyThrowsException() {
		Exception thrown = assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Date todaysDate = new Date();
				long ltime = todaysDate.getTime()+8*24*60*60*1000;
				Appointment newAppointment = new Appointment("JWOZNY001",new Date(ltime),"ABCDEFGHIJKLMNOPQRSTUVWXYZ ABCDEFGHIJKLMNOPQRSTUVWX");
			}
		});
	}
}
