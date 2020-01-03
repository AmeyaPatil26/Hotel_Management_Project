package com.capgemini.hotelmanagementsystem.service;

import com.capgemini.hotelmanagementsystem.bean.AdminEmployeeUserBean;

public interface AdminEmployeeUserService {

	public AdminEmployeeUserBean adminEmployeeUserLogin(String email, String password);

	public AdminEmployeeUserBean userRegister(AdminEmployeeUserBean adminEmployeeUserBean);

	public boolean checkUserEmail(String email);

	public AdminEmployeeUserBean userProfile(AdminEmployeeUserBean adminEmployeeUserBean);

	public AdminEmployeeUserBean updateUserProfile(AdminEmployeeUserBean adminEmployeeUserBean);

}// end of interface
