package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.AdminEmployeeUserBean;
import com.capgemini.hotelmanagementsystem.bean.BookingInformationBean;
import com.capgemini.hotelmanagementsystem.bean.HotelInformationBean;
import com.capgemini.hotelmanagementsystem.bean.RoomInformationBean;

public interface EmployeeOperationDao {

	public HotelInformationBean getHotelInformation(AdminEmployeeUserBean adminEmployeeUserBean);

	public List<RoomInformationBean> getRoomList(AdminEmployeeUserBean adminEmployeeUserBean);

	public BookingInformationBean bookUser(BookingInformationBean bookingInformationBean);

}// end of interface
