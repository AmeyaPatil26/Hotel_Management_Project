package com.capgemini.hotelmanagementsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.hotelmanagementsystem.bean.EmployeeInformationBean;
import com.capgemini.hotelmanagementsystem.bean.HotelInformationBean;
import com.capgemini.hotelmanagementsystem.bean.RoomInformationBean;
import com.capgemini.hotelmanagementsystem.dao.AdminOperationDaoImpl;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemException;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminOperationsTest {

	@Autowired
	private AdminOperationDaoImpl adminOperationsDaoImpl;

	// Hotel Test Cases

	// Valid test addHotel()
	@Test(expected = HotelManagementSystemException.class)
	public void testAddHotel() {
		HotelInformationBean hotelInformationBean = new HotelInformationBean();
		hotelInformationBean.setHotelAddress("Banglore");
		hotelInformationBean.setHotelContactNumber("7890123456");
		hotelInformationBean.setHotelName("WestWoods Hotel");
		hotelInformationBean.setHotelImageURL("qwerty.image.jpg");
		hotelInformationBean.setLicenceNumber("H00000000");
		hotelInformationBean.setHotelId(1);

		TestCase.assertNotNull(adminOperationsDaoImpl.addHotel(hotelInformationBean));

	}// End of testAddHotel()

	// Invalid test addHotel()
	@Test
	public void testInvalidAddHotel() {
		HotelInformationBean hotelInformationBean = new HotelInformationBean();
		hotelInformationBean.setHotelAddress("Mumbai");
		hotelInformationBean.setHotelContactNumber("9087654321");
		hotelInformationBean.setHotelName("Abcd Efgh");
		hotelInformationBean.setHotelImageURL("qwerty.image.url");
		hotelInformationBean.setLicenceNumber("");

		TestCase.assertNotNull(adminOperationsDaoImpl.addHotel(hotelInformationBean));

	}

	// Valid test updateHotelRoom()
	@Test(expected = HotelManagementSystemException.class)
	public void testUpdateHotel() {
		HotelInformationBean hotelInformationBean = new HotelInformationBean();
		hotelInformationBean.setHotelId(1);
		hotelInformationBean.setHotelContactNumber("8907654321");
		hotelInformationBean.setHotelImageURL("qwy.image.png");

		boolean actual = adminOperationsDaoImpl.updateHotelInformation(hotelInformationBean);
		assertEquals(true, actual);

	}// End of testUpdateHotelRoom()

	// Invalid updateHotelRoom()
	@Test(expected = HotelManagementSystemException.class)
	public void testInvalidUpdateHotel() {
		HotelInformationBean hotelInformationBean = new HotelInformationBean();
		hotelInformationBean.setHotelAddress("Mumbai");
		hotelInformationBean.setHotelContactNumber("8907654321");
		hotelInformationBean.setHotelName("Qwerty Hotel");
		hotelInformationBean.setHotelImageURL("qwy.image.url");
		hotelInformationBean.setLicenceNumber("H000");

		boolean actual = adminOperationsDaoImpl.updateHotelInformation(hotelInformationBean);
		assertEquals(false, actual);
	}

	// valid test deleteHotelInformation()
	@Test
	public void testDeleteHotelInformation() {

		boolean actual = adminOperationsDaoImpl.deleteHotelInformation(1);
		assertEquals(false, actual);

	}// End of testDeleteHotelInformation()

	// Invalid test deleteHotelInformation()
	@Test
	public void testInvalidDeleteHotelInformation() {

		boolean actual = adminOperationsDaoImpl.deleteHotelInformation(11);
		assertEquals(false, actual);

	}

	// Valid test getHotelList()
	@Test
	public void testGetHotelList() {
		TestCase.assertNotNull(adminOperationsDaoImpl.getHotelList());
	}

// Passed Just checking if particular License Number is present 

	@Test
	public void testLicenseNumberPresent() {
		boolean actual = adminOperationsDaoImpl.licenseNumberPresent("H70707070");
		assertEquals(true, actual);

	}// End of testLicenseNumberPresent()

	// Invalid test licenseNumberPresent
	@Test
	public void testInvalidLicenseNumberPresent() {
		boolean actual = adminOperationsDaoImpl.licenseNumberPresent("H0000000");
		assertEquals(false, actual);

	}

	// Room Test Cases

	// Valid addRoom()
	@Test
	public void testAddRoom() {
		HotelInformationBean hotelInformationBean = new HotelInformationBean();
		RoomInformationBean roomInformationBean = new RoomInformationBean();
		roomInformationBean.setLicenceNumber("H10101010");
		roomInformationBean.setRoomAmount(1000);
		roomInformationBean.setRoomCapacity("singleBed");
		roomInformationBean.setRoomCount(10);
		roomInformationBean.setRoomId(1);
		roomInformationBean.setRoomImageURL("abcd.wertyh.jpeg");
		roomInformationBean.setRoomStatus("Available");
		roomInformationBean.setRoomType("Non AC");
		TestCase.assertNotNull(adminOperationsDaoImpl.addRoom(roomInformationBean));

	}// End of testAddRoom()

	// Invalid test addRoom()
	@Test(expected = HotelManagementSystemException.class)
	public void testInvalidAddRoom() {
		HotelInformationBean hotelInformationBean = new HotelInformationBean();
		RoomInformationBean roomInformationBean = new RoomInformationBean();
		// roomInformationBean.setHotelId(1);
		// roomInformationBean.setHotelName("Jamun");
		roomInformationBean.setHotelId(2);
		roomInformationBean.setRoomAmount(123);
		roomInformationBean.setRoomCount(25);
		roomInformationBean.setRoomImageURL("asdf");
		roomInformationBean.setRoomStatus("avaliable");
		roomInformationBean.setRoomType("AC");
		roomInformationBean.setRoomCapacity("singleBed");

		TestCase.assertNull(adminOperationsDaoImpl.addRoom(roomInformationBean));

	}

	// Passed
	@Test
	public void testUpdateRoomInformation() {
		RoomInformationBean roomInformationBean = new RoomInformationBean();
		roomInformationBean.setRoomId(1);
		// roomInformationBean.setLicenceNumber("H90909090");
		// roomInformationBean.setHotelName("Abcd Efgh");
		// roomInformationBean.setHotelId(9);
		roomInformationBean.setRoomCount(5);
		roomInformationBean.setRoomImageURL("asdf.jpeg");

		boolean actual = adminOperationsDaoImpl.updateRoomInformation(roomInformationBean);
		assertEquals(true, actual);

	}// End of testUpdateRoomInformation()

	// Invalid test updateRoomInformation()
	@Test
	public void testInvalidUpdateRoomInformation() {
		RoomInformationBean roomInformationBean = new RoomInformationBean();
		roomInformationBean.setRoomId(4);
		roomInformationBean.setRoomCapacity("singleBed");

		boolean actual = adminOperationsDaoImpl.updateRoomInformation(roomInformationBean);
		assertEquals(false, actual);

	}

	@Test
	public void testDeleteRoomInformation() {

		boolean actual = adminOperationsDaoImpl.deleteRoomInformation(1);
		assertEquals(true, actual);

	}// End of testDeleteRoomInformation()

	// Invalid test deleteRoomInformation()
	@Test
	public void testInvalidDeleteRoomInformation() {
		boolean actual = adminOperationsDaoImpl.deleteRoomInformation(3);
		assertEquals(false, actual);
	}

	// Valid test getRoomList()
	@Test
	public void testValidGetRoomList() {
		TestCase.assertNotNull(adminOperationsDaoImpl.getRoomList());
	}

	// Employee Operation

	// Passed
	@Test
	public void testAddEmployee() {
		EmployeeInformationBean employeeInformationBean = new EmployeeInformationBean();
		employeeInformationBean.setAddress("Delhi");
		employeeInformationBean.setContactNumber("8901234567");
		employeeInformationBean.setEmail("employee2@gmail.com");
		employeeInformationBean.setHotelId(13);
		employeeInformationBean.setLicenceNumber("H70707070");
		// employeeInformationBean.setHotelName("Cosms");
		employeeInformationBean.setName("Employee Two");
		employeeInformationBean.setNationality("Indian");
		employeeInformationBean.setPassword("Empl@123");
		employeeInformationBean.setEmployeeId(1);

		TestCase.assertNotNull(adminOperationsDaoImpl.addEmployee(employeeInformationBean));

	}// End of testAddEmployee()

	// Invalid test addEmployee()
	@Test(expected = EmptyResultDataAccessException.class)
	public void testInvalidAddEmployee() {
		EmployeeInformationBean employeeInformationBean = new EmployeeInformationBean();
		employeeInformationBean.setAddress("Delhi");
		// employeeInformationBean.setContactNumber("123678");
		employeeInformationBean.setEmail("sm@gmail.com");
		employeeInformationBean.setHotelId(1);
		// employeeInformationBean.setHotelLicense("H00000001");
		employeeInformationBean.setHotelName("Cosms");
		employeeInformationBean.setName("manju");
		employeeInformationBean.setNationality("Inian");
		employeeInformationBean.setPassword("manjuBaba");

		TestCase.assertNull(adminOperationsDaoImpl.addEmployee(employeeInformationBean));

	}

	@Test(expected = NullPointerException.class)
	public void testUpdateEmployeeInformation() {

		EmployeeInformationBean employeeInformationBean = new EmployeeInformationBean();
		employeeInformationBean.setEmployeeId(1);
		employeeInformationBean.setAddress("Mumbai1");
		employeeInformationBean.setContactNumber("123456789");
		// employeeInformationBean.setHotelId(2);
		employeeInformationBean.setLicenceNumber("H70707070");
		// employeeInformationBean.setHotelName("Indus");
		employeeInformationBean.setNationality("Indian");
		employeeInformationBean.setPassword("Abcd@123");

		boolean actual = adminOperationsDaoImpl.updateEmployeeInformation(employeeInformationBean);
		assertEquals(true, actual);

	}// End of testUpdateEmployeeInformation()

	// Invalid test updateEmployeeInformation
	@Test(expected = NullPointerException.class)
	public void testInvalidUpdateEmployeeInformation() {

		EmployeeInformationBean employeeInformationBean = new EmployeeInformationBean();
		employeeInformationBean.setEmployeeId(1);
		employeeInformationBean.setAddress("Mumbai1");
		employeeInformationBean.setContactNumber("123456789");
		// employeeInformationBean.setHotelId(2);
		employeeInformationBean.setLicenceNumber("123");
		employeeInformationBean.setHotelName("Indus");
		employeeInformationBean.setNationality("Indian");
		employeeInformationBean.setPassword("");

		boolean actual = adminOperationsDaoImpl.updateEmployeeInformation(employeeInformationBean);
		assertEquals(false, actual);

	}

	// Passed
	@Test
	public void testDeleteEmployee() {
		boolean actual = adminOperationsDaoImpl.deleteEmployeeInformation(1);
		assertEquals(true, actual);

	}// End of testDeleteEmployee()

	// Invalid test deleteEmployee()
	@Test(expected = HotelManagementSystemException.class)
	public void testInvalidDeleteEmployee() {
		boolean actual = adminOperationsDaoImpl.deleteEmployeeInformation(6);
		assertEquals(false, actual);

	}

	// Passed
	// Valid test getEmployeeList()
	@Test
	public void testGetEmployeeList() {
		TestCase.assertNotNull(adminOperationsDaoImpl.getEmployeeList());
	}
}
