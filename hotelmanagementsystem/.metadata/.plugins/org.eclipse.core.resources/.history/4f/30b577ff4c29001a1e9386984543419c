package com.capgemini.hotelmanagementsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagementsystem.bean.AdminEmployeeUserBean;
import com.capgemini.hotelmanagementsystem.bean.BookingInformationBean;
import com.capgemini.hotelmanagementsystem.bean.HotelInformationBean;
import com.capgemini.hotelmanagementsystem.bean.RoomInformationBean;
import com.capgemini.hotelmanagementsystem.dao.AdminOperationDao;
import com.capgemini.hotelmanagementsystem.dao.EmployeeOperationDao;
import com.capgemini.hotelmanagementsystem.service.EmployeeOperationService;
import com.capgemini.hotelmanagementsystem.validation.UserValidationDaoImpl;

@Service
public class EmployeeOperationServiceImpl implements EmployeeOperationService {

	@Autowired
	private EmployeeOperationDao employeeOperationDao;

	UserValidationDaoImpl userValidation = new UserValidationDaoImpl();

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
		if (userValidation.nameValidation(bookingInformationBean.getName())
				&& userValidation.emailValidation(bookingInformationBean.getEmail())) {
			System.out.println("......bookUser service.......");
			return employeeOperationDao.bookUser(bookingInformationBean);
		}
		System.out.println("......null.......");
		return null;
	}
}// end of class
