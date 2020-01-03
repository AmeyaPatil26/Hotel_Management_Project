package com.capgemini.hotelmanagementsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.hotelmanagementsystem.bean.AdminEmployeeUserBean;
import com.capgemini.hotelmanagementsystem.dao.EmployeeOperationDaoImpl;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemException;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeOperationTest {

	@Autowired
	private EmployeeOperationDaoImpl employeeOperationDaoImpl;

	// Passed Case with valid Information
	@Test
	public void testGetHotelInformation() {
		AdminEmployeeUserBean employeeBean = new AdminEmployeeUserBean();
		employeeBean.setEmail("mayuri@taj.com");
		TestCase.assertNotNull(employeeOperationDaoImpl.getHotelInformation(employeeBean));

	}// End of testGetHotelInformation()

	// Invalid Test Case with invalid Information
	@Test
	public void testInvalidGetHotelInformation() {
		AdminEmployeeUserBean employeeBean = new AdminEmployeeUserBean();
		employeeBean.setEmail("emplo@qwerty.com");
		TestCase.assertNull(employeeOperationDaoImpl.getHotelInformation(employeeBean));

	}// End of testGetHotelInformation()

	@Test(expected = HotelManagementSystemException.class)
	public void testInvalidGetRoomList() {
		AdminEmployeeUserBean employeeBean = new AdminEmployeeUserBean();
		employeeBean.setEmail("employee3@tSaj.com");
		TestCase.assertNull(employeeOperationDaoImpl.getRoomList(employeeBean));
	}

	// Invalid test bookUser()
//	@Test(expected = NullPointerException.class)
//	public void testInvalidBookUser() throws ParseException {
//		BookingInformationBean bookingDetails = new BookingInformationBean();
//		bookingDetails.setAddress("Mumbai");
//		bookingDetails.setBookingAmount(2000);
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		bookingDetails.setCheckInDate(format.parse("2019-12-27"));
//		bookingDetails.setCheckOutDate(format.parse("2019-12-29"));
//		bookingDetails.setContactNumber("9876543210");
//		bookingDetails.setEmail("abcd@gmail.com");
//		bookingDetails.setHotelName("Qwerty");
//		bookingDetails.setLicenceNumber("H00");
//		bookingDetails.setName("Abcd Efgh");
//		bookingDetails.setNationality("Indian");
//		bookingDetails.setRoomCapacity("Single Bed");
//		bookingDetails.setRoomType("AC");
//
//		TestCase.assertNull(employeeOperationDaoImpl.bookUser(bookingDetails));
//	}
}// End of EmployeeOperationTest()
