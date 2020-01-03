package com.capgemini.hotelmanagementsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.hotelmanagementsystem.bean.AdminEmployeeUserBean;
import com.capgemini.hotelmanagementsystem.dao.AdminEmployeeUserDaoImpl;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemException;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminEmployeeUserTest {

	@Autowired
	private AdminEmployeeUserDaoImpl adminEmployeeUserDaoImpl; // autowired
	// Passed

	@Test
	public void testGetLogin() {
		TestCase.assertNotNull(adminEmployeeUserDaoImpl.adminEmployeeUserLogin("admin@gmail.com", "Admin@123"));

	}// End of testGetLogin()

	@Test
	// Invalid test getLogin
	public void testInvalidGetLogin() {
		TestCase.assertNull(adminEmployeeUserDaoImpl.adminEmployeeUserLogin("anji@gmail.com", "Anjali@123"));
	}
	
	@Test
	// Invalid test userRegister
	public void testInvalidUserRegister() {
		AdminEmployeeUserBean adminEmployeeUserBean = new AdminEmployeeUserBean();
		adminEmployeeUserBean.setAddress("Mumbai");
		adminEmployeeUserBean.setContactNumber("9012345678");
		adminEmployeeUserBean.setName("Xyz Abcd");
		adminEmployeeUserBean.setNationality("Indian");
		adminEmployeeUserBean.setType("User");

		TestCase.assertNull(adminEmployeeUserDaoImpl.userRegister(adminEmployeeUserBean));

	}

	@Test
	public void testCheckUserEmail() {
		TestCase.assertEquals(true, adminEmployeeUserDaoImpl.checkUserEmail("anjali@gmail.com"));
	}

	@Test
	public void testInvalidCheckUserEmail() {
		TestCase.assertEquals(false, adminEmployeeUserDaoImpl.checkUserEmail("anji@gmail.com"));
	}

	@Test
	public void testUpdateUserProfile() {
		AdminEmployeeUserBean userBean = new AdminEmployeeUserBean();
		userBean.setId(30);
		userBean.setEmail("anjali@gmail.com");
		userBean.setAddress("Indore");
		userBean.setContactNumber("9987648115");
		TestCase.assertNotNull(adminEmployeeUserDaoImpl.updateUserProfile(userBean));
	}

	@Test(expected = HotelManagementSystemException.class)
	public void testInvalidUpdateUserProfile() {
		AdminEmployeeUserBean userBean = new AdminEmployeeUserBean();
		userBean.setId(32);
		// userBean.setEmail("anjali@gmail.com");
		userBean.setAddress("Indore");
		userBean.setContactNumber("9987648115");
		TestCase.assertNull(adminEmployeeUserDaoImpl.updateUserProfile(userBean));
	}
}// End of AdminEmployeeUserTest()
