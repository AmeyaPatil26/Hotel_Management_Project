package com.capgemini.hotelmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelmanagementsystem.bean.AdminEmployeeUserBean;
import com.capgemini.hotelmanagementsystem.bean.BookingInformationBean;
import com.capgemini.hotelmanagementsystem.bean.HotelInformationBean;
import com.capgemini.hotelmanagementsystem.bean.RoomInformationBean;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemException;
import com.capgemini.hotelmanagementsystem.response.HotelManagementResponse;
import com.capgemini.hotelmanagementsystem.service.UserOperationService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class UserOperationController {

	@Autowired
	private UserOperationService userOperationService;

	@PostMapping(path = "/getRoomListForUser")
	public HotelManagementResponse getRoomListForUser(@RequestBody HotelInformationBean hotelInformationBean) {
		// String licenceNumber = roomInformationBean.getLicenceNumber();
		HotelManagementResponse response = new HotelManagementResponse();
		// try {
		List<RoomInformationBean> roomList = userOperationService.roomList(hotelInformationBean);
		if (roomList != null && !roomList.isEmpty()) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("room list displayed");
			response.setRoomList(roomList);
			;
		} else {
//				response.setStatusCode(400);
//				response.setMessage("Failed");
//				response.setDescription("room list can't be fetched");
			throw new HotelManagementSystemException("room list can't be fetched");
		}
//		} catch (Exception e) {
//			response.setStatusCode(400);
//			response.setMessage("Failed");
//			response.setDescription(e.getMessage());
//			System.out.println(e.getMessage());
//		}
		return response;
	}// end of getRoomListForUser

	@PutMapping(path = "/userRoomBooking", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HotelManagementResponse userRoomBooking(@RequestBody BookingInformationBean bookingInformationBean) {
		System.out.println("......booking......" + bookingInformationBean);
		HotelManagementResponse response = new HotelManagementResponse();
		BookingInformationBean bookingInformationBean1 = null;
		// try {
		bookingInformationBean1 = userOperationService.bookRoomUser(bookingInformationBean);
		if (bookingInformationBean1 != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("room booked successfully");

			int roomCount = userOperationService.updateRoomCount(bookingInformationBean1.getRoomId());
			if (roomCount != 0) {
				response.setStatusCode(200);
				response.setMessage("Success");
				response.setDescription("room count decreases successfully");
			} else if (roomCount == 0) {
				{
					String roomStatus = userOperationService.updateRoomStatus(bookingInformationBean1.getRoomId());
					if (roomStatus != null) {
						response.setStatusCode(200);
						response.setMessage("Success");
						response.setDescription("room status updated successfully");
					}
				}

			}
		} else {
//				response.setStatusCode(400);
//				response.setMessage("Failed");
//				response.setDescription("Unable to book room");
			throw new HotelManagementSystemException("Unable to book room");
		}
//		} catch (Exception e) {
//			response.setStatusCode(400);
//			response.setMessage("Failed");
//			response.setDescription(e.getMessage());
//			System.out.println(e.getMessage());
//		}
		return response;
	}// end of userRoomBooking

	@PostMapping(path = "/calculateTotalDaysAmount")
	public HotelManagementResponse calculateTotalDaysAmount(
			@RequestBody BookingInformationBean bookingInformationBean) {
		// String licenceNumber = roomInformationBean.getLicenceNumber();
		HotelManagementResponse response = new HotelManagementResponse();
		// try {
		double totalBill = userOperationService.calculateTotalDaysAmount(bookingInformationBean);
		if (totalBill != 0) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("room list displayed");
			response.setTotalBill(totalBill);
			;
		} else {
//				response.setStatusCode(400);
//				response.setMessage("Failed");
//				response.setDescription("room list can't be fetched");
			throw new HotelManagementSystemException("room list can't be fetched");
		}
//		} catch (Exception e) {
//			response.setStatusCode(400);
//			response.setMessage("Failed");
//			response.setDescription(e.getMessage());
//			System.out.println(e.getMessage());
//		}
		return response;
	}// end of getRoomListForUser

	@PostMapping(path = "/getBookingHistoryForUser")
	public HotelManagementResponse getBookingHistory(@RequestBody AdminEmployeeUserBean adminEmployeeUserBean) {
		HotelManagementResponse response = new HotelManagementResponse();
		System.out.println("...............email" + adminEmployeeUserBean.getEmail());
		// try {
		String email = adminEmployeeUserBean.getEmail();
		List<BookingInformationBean> bookingDetails = userOperationService.getBookingHistory(email);
		if (bookingDetails != null && !bookingDetails.isEmpty()) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Booking details list displayed");
			response.setBookingDetailsList(bookingDetails);
			;
		} else {
//				response.setStatusCode(400);
//				response.setMessage("Failed");
//				response.setDescription("Booking details can't be fetched");
			throw new HotelManagementSystemException("Booking details can't be fetched");
		}
//		} catch (Exception e) {
//			response.setStatusCode(400);
//			response.setMessage("Failed");
//			response.setDescription(e.getMessage());
//			System.out.println(e.getMessage());
//		}
		return response;
	}

	@DeleteMapping(path = "/cancelBooking/{bookingId}")
	public HotelManagementResponse cancelBooking(@PathVariable int bookingId) {
		HotelManagementResponse response = new HotelManagementResponse();
		boolean isDeleted = userOperationService.cancelBooking(bookingId);
		if (isDeleted) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Booking cancellation successfully");
		} else {
			throw new HotelManagementSystemException("Booking can't be cancelled");
		}
		return response;
	}
}// end of class
