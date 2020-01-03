package com.capgemini.hotelmanagementsystem.dao;

import com.capgemini.hotelmanagementsystem.bean.AdminEmployeeUserBean;

public interface AdminEmployeeUserDao {

	public AdminEmployeeUserBean adminEmployeeUserLogin(String email, String password);

	public AdminEmployeeUserBean userRegister(AdminEmployeeUserBean adminEmployeeUserBean);

	public boolean checkUserEmail(String hotelLicenceNumber);
	
	public AdminEmployeeUserBean userProfile(AdminEmployeeUserBean adminEmployeeUserBean);
	
	public AdminEmployeeUserBean updateUserProfile(AdminEmployeeUserBean adminEmployeeUserBean);
	
}// end of interface
