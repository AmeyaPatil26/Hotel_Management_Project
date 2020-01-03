package com.capgemini.hotelmanagementsystem.response;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.AdminEmployeeUserBean;
import com.capgemini.hotelmanagementsystem.bean.BookingInformationBean;
import com.capgemini.hotelmanagementsystem.bean.EmployeeInformationBean;
import com.capgemini.hotelmanagementsystem.bean.HotelInformationBean;
import com.capgemini.hotelmanagementsystem.bean.RoomInformationBean;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelManagementResponse {

	private int statusCode;
	private String message;
	private String description;
	private String type;

	private double totalBill;
	private AdminEmployeeUserBean adminEmployeeUserBean;

	private HotelInformationBean hotelInformationBean;
	private List<HotelInformationBean> hotelList;

	private RoomInformationBean roomInformationBean;
	private List<RoomInformationBean> roomList;

	private EmployeeInformationBean employeeBean;
	private List<EmployeeInformationBean> employeeList;
	
	private List<BookingInformationBean> bookingDetailsList;
	
	// Getter Setter Method
	public int getStatusCode() {
		return statusCode;
	}

	

	public double getTotalBill() {
		return totalBill;
	}



	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}



	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public HotelInformationBean getHotelInformationBean() {
		return hotelInformationBean;
	}

	public void setHotelInformationBean(HotelInformationBean hotelInformationBean) {
		this.hotelInformationBean = hotelInformationBean;
	}

	public RoomInformationBean getRoomInformationBean() {
		return roomInformationBean;
	}

	public void setRoomInformationBean(RoomInformationBean roomInformationBean) {
		this.roomInformationBean = roomInformationBean;
	}

	public AdminEmployeeUserBean getAdminEmployeeUserBean() {
		return adminEmployeeUserBean;
	}

	public void setAdminEmployeeUserBean(AdminEmployeeUserBean adminEmployeeUserBean) {
		this.adminEmployeeUserBean = adminEmployeeUserBean;
	}

	public List<HotelInformationBean> getHotelList() {
		return hotelList;
	}

	public void setHotelList(List<HotelInformationBean> hotelList) {
		this.hotelList = hotelList;
	}

	public List<RoomInformationBean> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<RoomInformationBean> roomList) {
		this.roomList = roomList;
	}

	public EmployeeInformationBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeInformationBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	public List<EmployeeInformationBean> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<EmployeeInformationBean> employeeList) {
		this.employeeList = employeeList;
	}

	public List<BookingInformationBean> getBookingDetailsList() {
		return bookingDetailsList;
	}

	public void setBookingDetailsList(List<BookingInformationBean> bookingDetailsList) {
		this.bookingDetailsList = bookingDetailsList;
	}


}// end of class
