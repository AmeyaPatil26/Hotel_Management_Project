package com.capgemini.hotelmanagementsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.hotelmanagementsystem.bean.BookingInformationBean;
import com.capgemini.hotelmanagementsystem.bean.HotelInformationBean;
import com.capgemini.hotelmanagementsystem.bean.RoomInformationBean;
import com.capgemini.hotelmanagementsystem.dao.UserOperationDaoImpl;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserOperationTest {
	@Autowired
	private UserOperationDaoImpl userOperationImpl;

	@Test
	// valid roomList()
	public void testRoomList() {
		HotelInformationBean hotelInformation = new HotelInformationBean();
		hotelInformation.setLicenceNumber("H10101010");
		TestCase.assertNotNull(userOperationImpl.roomList(hotelInformation));
	}

	@Test
	// Invalid test roomList()
	public void testInvalidRoomList() {
		HotelInformationBean hotelInformation = new HotelInformationBean();
		hotelInformation.setLicenceNumber("H00");
		List<RoomInformationBean> roomList = userOperationImpl.roomList(hotelInformation);
		assertEquals(true, roomList.isEmpty());
	}

	@Test
	// Valid test getBookingHistroy()
	public void testGetBookingHistory() {
		List<BookingInformationBean> bookingHistroy = userOperationImpl.getBookingHistory("user@gmail.com");
		assertEquals(true, bookingHistroy.isEmpty());
	}

	@Test
	// invalid test getBookingHistroy()
	public void testInvalidGetBookingHistory() {
		List<BookingInformationBean> bookingHistroy = userOperationImpl.getBookingHistory("user12@gmail.com");
		assertEquals(true, bookingHistroy.isEmpty());
	}

}
