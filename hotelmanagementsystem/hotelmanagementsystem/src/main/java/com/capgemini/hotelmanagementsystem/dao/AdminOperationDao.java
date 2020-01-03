package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.BookingInformationBean;
import com.capgemini.hotelmanagementsystem.bean.EmployeeInformationBean;
import com.capgemini.hotelmanagementsystem.bean.HotelInformationBean;
import com.capgemini.hotelmanagementsystem.bean.RoomInformationBean;

public interface AdminOperationDao {

	// hotel crud
	public HotelInformationBean addHotel(HotelInformationBean hotelBean);

	public List<HotelInformationBean> getHotelList();

	public boolean updateHotelInformation(HotelInformationBean hotelBean);

	public boolean deleteHotelInformation(int hotelId);

	public boolean licenseNumberPresent(String licenseNumber);

	// room crud
	public RoomInformationBean addRoom(RoomInformationBean roomBean);

	public boolean deleteRoomInformation(int roomId);

	public List<RoomInformationBean> getRoomList();

	public boolean updateRoomInformation(RoomInformationBean roomBean);

	// employee crud
	public EmployeeInformationBean addEmployee(EmployeeInformationBean employeeBean);

	public List<EmployeeInformationBean> getEmployeeList();

	public boolean deleteEmployeeInformation(int employeeId);

	public boolean updateEmployeeInformation(EmployeeInformationBean employeeBean);
	
	public List<BookingInformationBean> getBookingHistory();

}// end of interface
