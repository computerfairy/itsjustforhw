import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;

class AppointmentTest {

	@Test
	void testDBConnect() {
		AppointmentDAO testDAO1 = new AppointmentDAO();
		testDAO1.DBConnect();
		assertNotNull(testDAO1.conn);
	}

	@Test
	void testDeleteAppointment() throws SQLException {
		AppointmentDAO testDAO2 = new AppointmentDAO();
		testDAO2.SelectAppointment("listAll", 0);
		int NUMBER_OF_APPOINTMENTS_BEFORE_DELETING = testDAO2.dataNum - 1;
		
		String test_aid = testDAO2.SelectAppointment("getAid", 1);
		testDAO2.DeleteAppointment(test_aid);
		int NUMBER_OF_APPOINTMENTS_AFTER_DELETING = testDAO2.dataNum;
		assertEquals(NUMBER_OF_APPOINTMENTS_BEFORE_DELETING, NUMBER_OF_APPOINTMENTS_AFTER_DELETING);		
	}

}
