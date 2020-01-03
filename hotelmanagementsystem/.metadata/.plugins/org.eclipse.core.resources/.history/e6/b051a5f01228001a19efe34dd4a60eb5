package com.capgemini.hotelmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelmanagementsystem.bean.AdminEmployeeUserBean;
import com.capgemini.hotelmanagementsystem.bean.exception.HotelManagementSystemException;
import com.capgemini.hotelmanagementsystem.response.HotelManagementResponse;
import com.capgemini.hotelmanagementsystem.service.AdminEmployeeUserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminEmployeeUserController {

	@Autowired
	private AdminEmployeeUserService adminEmployeeUserService;

	// .............................AdminEmployeeUserLogin....................................//

	@PostMapping(path = "/adminEmployeeUserLogin", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public HotelManagementResponse adminEmployeeUserLogin(@RequestBody AdminEmployeeUserBean adminEmployeeUserBean) {
		String email = adminEmployeeUserBean.getEmail();
		String password = adminEmployeeUserBean.getPassword();
		AdminEmployeeUserBean adminEmployeeUserBean1 = adminEmployeeUserService.adminEmployeeUserLogin(email, password);

		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();

		if (adminEmployeeUserBean1 != null) {
			hotelManagementResponse.setStatusCode(200);
			hotelManagementResponse.setMessage("success");
			hotelManagementResponse.setDescription(adminEmployeeUserBean1.getEmail() + " Login successfully");
			hotelManagementResponse.setType(adminEmployeeUserBean1.getType());
			hotelManagementResponse.setAdminEmployeeUserBean(adminEmployeeUserBean1);

		} else {
			hotelManagementResponse.setStatusCode(400);
			hotelManagementResponse.setMessage("fail");
			hotelManagementResponse.setDescription("Enter correct Email Id or Password");
		}
		return hotelManagementResponse;
	}// end of adminEmployeeUserLogin()

	// .............................UserRegistration....................................//

	@PutMapping(path = "/userRegistration", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public HotelManagementResponse userRegister(@RequestBody AdminEmployeeUserBean adminEmployeeUserBean) {
		adminEmployeeUserBean.setType("User");
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		String userEmail = adminEmployeeUserBean.getEmail();
		if (!adminEmployeeUserService.checkUserEmail(userEmail)) {
			AdminEmployeeUserBean adminEmployeeUserBean1 = adminEmployeeUserService.userRegister(adminEmployeeUserBean);

			if (adminEmployeeUserBean1 != null) {
				hotelManagementResponse.setStatusCode(200);
				hotelManagementResponse.setMessage("success");
				hotelManagementResponse.setDescription(adminEmployeeUserBean1.getEmail() + "Registered Sucessfully");
			} else {
				hotelManagementResponse.setStatusCode(400);
				hotelManagementResponse.setMessage("fail");
				hotelManagementResponse.setDescription("Not Registered..Please Try Again");
			}

			return hotelManagementResponse;

		} else {
			hotelManagementResponse.setStatusCode(400);
			hotelManagementResponse.setMessage("fail");
			hotelManagementResponse.setDescription("This Email Id is already Present...Please Try Again ");

			return hotelManagementResponse;
		}
	}// end of adminuserRegister()
	
	@PostMapping(path = "/adminUserEmployeeProfile", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public HotelManagementResponse adminUserEmployeeProfile(@RequestBody  AdminEmployeeUserBean adminEmployeeUserBean ) {
		System.out.println(".........proffile"+adminEmployeeUserBean.getId());
		AdminEmployeeUserBean profile = adminEmployeeUserService.userProfile(adminEmployeeUserBean);
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();

		if (profile != null) {
			hotelManagementResponse.setStatusCode(200);
			hotelManagementResponse.setMessage("success");
			hotelManagementResponse.setDescription(profile.getName() + "Profile");
			hotelManagementResponse.setAdminEmployeeUserBean(profile);
			;

		} else {
			hotelManagementResponse.setStatusCode(400);
			hotelManagementResponse.setMessage("fail");
			hotelManagementResponse.setDescription("Profile Not Getting");
		}
		return hotelManagementResponse;
	}// End of adminUserEmployeeProfile()
	
	@PostMapping(path = "/updateUserProfile", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HotelManagementResponse updateUserProfile(@RequestBody AdminEmployeeUserBean adminEmployeeUserBean) {
		HotelManagementResponse response = new HotelManagementResponse();
		try {

			AdminEmployeeUserBean adminEmployeeUserBean1 = adminEmployeeUserService.updateUserProfile(adminEmployeeUserBean);
			if (adminEmployeeUserBean1!= null) {
				response.setStatusCode(200);
				response.setMessage("Success");
				response.setDescription("user profile updated successfully");
				response.setAdminEmployeeUserBean(adminEmployeeUserBean1);
			} else {
				response.setStatusCode(400);
				response.setMessage("Failed");
				response.setDescription("user profile not updated");
			}

		} catch (HotelManagementSystemException e) {
			response.setStatusCode(400);
			response.setMessage("Failed");
			response.setDescription(e.getMessage());
			System.err.println(e.getMessage());
		}
		return response;
	}

}// end of class
