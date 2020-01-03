package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.AdminEmployeeUserBean;
import com.capgemini.hotelmanagementsystem.bean.BookingInformationBean;
import com.capgemini.hotelmanagementsystem.bean.HotelInformationBean;
import com.capgemini.hotelmanagementsystem.bean.RoomInformationBean;

public interface EmployeeOperationService {

	public List<RoomInformationBean> getRoomList(AdminEmployeeUserBean adminEmployeeUserBean);

	public HotelInformationBean getHotelInformation(AdminEmployeeUserBean adminEmployeeUserBean);

	public BookingInformationBean bookUser(BookingInformationBean bookingInformationBean);
}// end of interface
