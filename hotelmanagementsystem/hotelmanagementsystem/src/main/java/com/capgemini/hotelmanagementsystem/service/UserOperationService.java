package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.AdminEmployeeUserBean;
import com.capgemini.hotelmanagementsystem.bean.BookingInformationBean;
import com.capgemini.hotelmanagementsystem.bean.HotelInformationBean;
import com.capgemini.hotelmanagementsystem.bean.RoomInformationBean;

public interface UserOperationService {

	public List<RoomInformationBean> roomList(HotelInformationBean hotelInformationBean);

	public BookingInformationBean bookRoomUser(BookingInformationBean bookingInformationBean);

	public double calculateTotalDaysAmount(BookingInformationBean bookingInformationBean);

	public int updateRoomCount(int roomId);

	public String updateRoomStatus(int roomId);

	public List<BookingInformationBean> getBookingHistory(String email);

	public boolean cancelBooking(int bookingId);
}// end of interface
