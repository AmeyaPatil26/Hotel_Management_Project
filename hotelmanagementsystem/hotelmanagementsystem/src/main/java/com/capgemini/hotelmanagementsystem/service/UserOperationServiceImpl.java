package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagementsystem.bean.BookingInformationBean;
import com.capgemini.hotelmanagementsystem.bean.HotelInformationBean;
import com.capgemini.hotelmanagementsystem.bean.RoomInformationBean;
import com.capgemini.hotelmanagementsystem.dao.UserOperationDao;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemException;
import com.capgemini.hotelmanagementsystem.validation.HotelValidationImpl;

@Service
public class UserOperationServiceImpl implements UserOperationService {

	@Autowired
	private UserOperationDao userOperationDao;
	@Autowired
	private HotelValidationImpl hotelValidation;

	@Override
	public List<RoomInformationBean> roomList(HotelInformationBean hotelInformationBean) {
		return userOperationDao.roomList(hotelInformationBean);
	}

	@Override
	public BookingInformationBean bookRoomUser(BookingInformationBean bookingInformationBean) {

		System.out.println("book room for user ");
		return userOperationDao.bookRoomUser(bookingInformationBean);

	}

	@Override
	public double calculateTotalDaysAmount(BookingInformationBean bookingInformationBean) {
		if (hotelValidation.dateValidation(bookingInformationBean.getCheckInDate(),
				bookingInformationBean.getCheckOutDate())) {
			return userOperationDao.calculateTotalDaysAmount(bookingInformationBean);
		} else {
			throw new HotelManagementSystemException("Enter valid check-in check-out date");
		}
	}

	@Override
	public int updateRoomCount(int roomId) {
		return userOperationDao.updateRoomCount(roomId);
	}

	@Override
	public String updateRoomStatus(int roomId) {
		return userOperationDao.updateRoomStatus(roomId);
	}

	@Override
	public List<BookingInformationBean> getBookingHistory(String email) {
		return userOperationDao.getBookingHistory(email);
	}

	@Override
	public boolean cancelBooking(int bookingId) {
		return userOperationDao.cancelBooking(bookingId);
	}
}
