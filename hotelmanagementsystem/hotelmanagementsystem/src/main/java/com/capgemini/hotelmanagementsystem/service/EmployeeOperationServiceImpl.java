package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagementsystem.bean.AdminEmployeeUserBean;
import com.capgemini.hotelmanagementsystem.bean.BookingInformationBean;
import com.capgemini.hotelmanagementsystem.bean.HotelInformationBean;
import com.capgemini.hotelmanagementsystem.bean.RoomInformationBean;
import com.capgemini.hotelmanagementsystem.dao.EmployeeOperationDao;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemException;
import com.capgemini.hotelmanagementsystem.validation.HotelValidation;

@Service
public class EmployeeOperationServiceImpl implements EmployeeOperationService {

	@Autowired
	private EmployeeOperationDao employeeOperationDao;

	@Autowired
	private HotelValidation validation;

	@Override
	public List<RoomInformationBean> getRoomList(AdminEmployeeUserBean adminEmployeeUserBean) {
		return employeeOperationDao.getRoomList(adminEmployeeUserBean);
	}

	@Override
	public HotelInformationBean getHotelInformation(AdminEmployeeUserBean adminEmployeeUserBean) {
		return employeeOperationDao.getHotelInformation(adminEmployeeUserBean);
	}

	@Override
	public BookingInformationBean bookUser(BookingInformationBean bookingInformationBean) {
		if (validation.dateValidation(bookingInformationBean.getCheckInDate(),
				bookingInformationBean.getCheckOutDate())) {

			if (bookingInformationBean.getLicenceNumber().isEmpty() || bookingInformationBean.getHotelName().isEmpty()
					|| bookingInformationBean.getEmail().isEmpty()
					|| bookingInformationBean.getContactNumber().isEmpty()
					|| bookingInformationBean.getName().isEmpty()) {
				throw new HotelManagementSystemException("Somewhere null value is passed");
			} else {
				if (validation.licenseValidation(bookingInformationBean.getLicenceNumber())) {
					if (validation.nameValidation(bookingInformationBean.getHotelName())) {
						if (validation.emailValidation(bookingInformationBean.getEmail())) {
							if (validation.contactNumberValidation(bookingInformationBean.getContactNumber())) {
								if (validation.nameValidation(bookingInformationBean.getName())) {
									return employeeOperationDao.bookUser(bookingInformationBean);
								} else {
									throw new HotelManagementSystemException("The Name must be in abc efg format");
								} // End of name else
							} else {
								throw new HotelManagementSystemException(
										"The Contact Number first Integer must be between [7-9] and rest as follow");
							} // End of contactNumber else
						} else {
							throw new HotelManagementSystemException("Email must be in abc@gmail.com format");
						} // End of else for email
					} else {
						throw new HotelManagementSystemException("Hotel Name must be in xyz abc fromat");
					} // End of else for name
				} else {
					throw new HotelManagementSystemException(
							"The Liscence No. must begin with H and must have 8 integer");
				} // End of else for licenseValidation()
			} // End of else for null values
		} else {
			throw new HotelManagementSystemException("Enter valid check-in check-out date");
		}
	}
}// end of class
