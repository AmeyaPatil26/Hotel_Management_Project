package com.capgemini.hotelmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelmanagementsystem.bean.BookingInformationBean;
import com.capgemini.hotelmanagementsystem.bean.EmployeeInformationBean;
import com.capgemini.hotelmanagementsystem.bean.HotelInformationBean;
import com.capgemini.hotelmanagementsystem.bean.RoomInformationBean;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemException;
import com.capgemini.hotelmanagementsystem.response.HotelManagementResponse;
import com.capgemini.hotelmanagementsystem.service.AdminOperationService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class AdminOperationController {

	@Autowired
	private AdminOperationService adminOperationsService;

	@PostMapping(path = "/addHotel", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HotelManagementResponse addHotel(@RequestBody HotelInformationBean hotelbean) {
		HotelManagementResponse response = new HotelManagementResponse();
		HotelInformationBean hotelInformationBean = null;
		try {
			String licenseNumber = hotelbean.getLicenceNumber();
			if (!adminOperationsService.licenseNumberPresent(licenseNumber)) {
				hotelInformationBean = adminOperationsService.addHotel(hotelbean);
				if (hotelInformationBean != null) {
					response.setStatusCode(200);
					response.setMessage("Success");
					response.setDescription("Hotel added successfully");
					response.setHotelInformationBean(hotelInformationBean);
				} else {
//					response.setStatusCode(400);
//					response.setMessage("Failed");
//					response.setDescription("Unable to add hotel");
					throw new HotelManagementSystemException("Unable to add Hotel");
				}
			} else {
//				response.setStatusCode(400);
//				response.setMessage("Failed");
//				response.setDescription("This Hotel Licence number is already present");
				throw new HotelManagementSystemException("This Hotel number already exist");
			}
		} catch (HotelManagementSystemException e) {
			response.setStatusCode(400);
			response.setMessage("Failed");
			response.setDescription(e.getMessage());
			System.out.println(e.getMessage());
		}
		return response;
	}

	@GetMapping(path = "/getHotelList")
	public HotelManagementResponse getHotelList() {
		HotelManagementResponse response = new HotelManagementResponse();
		//try {
			List<HotelInformationBean> hotelList = adminOperationsService.getHotelList();
			if (hotelList != null && !hotelList.isEmpty()) {
				response.setStatusCode(200);
				response.setMessage("Success");
				response.setDescription("Hotel list displayed");
				response.setHotelList(hotelList);
			} else {
//				response.setStatusCode(400);
//				response.setMessage("Failed");
//				response.setDescription("Hotel list can't be fetched");
				throw new HotelManagementSystemException("Hotel list can't be fetched");
			}
//		} catch (Exception e) {
//			response.setStatusCode(400);
//			response.setMessage("Failed");
//			response.setDescription(e.getMessage());
//			System.out.println(e.getMessage());
//		}
		return response;
	}

	@PutMapping(path = "/updateHotelInformation", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HotelManagementResponse updateHotelInformation(@RequestBody HotelInformationBean hotelBean) {
		HotelManagementResponse response = new HotelManagementResponse();
	//	try {

			boolean isUpdated = adminOperationsService.updateHotelInformation(hotelBean);
			if (isUpdated) {
				response.setStatusCode(200);
				response.setMessage("Success");
				response.setDescription("Hotel information updated successfully");
				response.setHotelInformationBean(hotelBean);
			} else {
//				response.setStatusCode(400);
//				response.setMessage("Failed");
//				response.setDescription("Hotel information not updated");
				throw new HotelManagementSystemException("Hotel information not updated");
			}

//		} catch (HotelManagementSystemException e) {
//			response.setStatusCode(400);
//			response.setMessage("Failed");
//			response.setDescription(e.getMessage());
//			System.err.println(e.getMessage());
//		}
		return response;
	}

	@DeleteMapping(path = "/deleteHotel/{hotelId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public HotelManagementResponse deleteHotelInformation(@PathVariable int hotelId) {
		HotelManagementResponse response = new HotelManagementResponse();
	//	try {

			boolean isDeleted = adminOperationsService.deleteHotelInformation(hotelId);
			if (isDeleted) {
				response.setStatusCode(200);
				response.setMessage("Success");
				response.setDescription("Hotel deleted successfully");
			} else {
//				response.setStatusCode(400);
//				response.setDescription("Hotel not deleted");
//				response.setMessage("Failed");
				throw new HotelManagementSystemException("Hotel Not Deleted");
			}
//		} catch (Exception e) {
//			response.setStatusCode(400);
//			response.setDescription(e.getMessage());
//			response.setMessage("Failed");
//			System.err.println(e.getMessage());
//		}
		return response;
	}
	/* Room crud operations */

	@PutMapping(path = "/addRoomInformation", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HotelManagementResponse addRoomInformation(@RequestBody RoomInformationBean roomBean) {
		HotelManagementResponse response = new HotelManagementResponse();

		//try {
			String licenseNumber = roomBean.getLicenceNumber();
			System.out.println(".....1......"+licenseNumber);
			if (adminOperationsService.licenseNumberPresent(licenseNumber)) {
				RoomInformationBean roomInformationBean = adminOperationsService.addRoom(roomBean);
				if (roomInformationBean != null) {
					response.setStatusCode(200);
					response.setMessage("Success");
					response.setDescription("Room added successfully");
					response.setRoomInformationBean(roomInformationBean);
				} else {
//					response.setStatusCode(400);
//					response.setDescription("Room information can't be added");
//					response.setMessage("Failed");
					throw new HotelManagementSystemException("Room Information can't be Added");
				}
			} else {
//				response.setStatusCode(400);
//				response.setDescription("This hotel is not present.. please enter existing hotel Licence");
//				response.setMessage("Failed");
				throw new HotelManagementSystemException("This hotel is not present.. please enter existing hotel Licence");
			}
//		} catch (HotelManagementSystemException e) {
//			response.setStatusCode(400);
//			response.setDescription(e.getMessage());
//			response.setMessage("Failed");
//			System.err.println(e.getMessage());
//		}
		return response;
	}

	@DeleteMapping(path = "/deleteRoom//{roomId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public HotelManagementResponse deleteRoomInformation(@PathVariable int roomId) {
		HotelManagementResponse response = new HotelManagementResponse();
		//try {
		System.out.println("............................."+roomId);
			boolean isDeleted = adminOperationsService.deleteRoomInformation(roomId);
			if (isDeleted) {
				response.setStatusCode(200);
				response.setMessage("Success");
				response.setDescription("Room information deleted successfully");
			} else {
//				response.setStatusCode(400);
//				response.setDescription("Room information not deleted");
//				response.setMessage("Failed");
				throw new HotelManagementSystemException("Room information not deleted");
			}
//		} catch (HotelManagementSystemException e) {
//			response.setStatusCode(400);
//			response.setDescription(e.getMessage());
//			response.setMessage("Failed");
//			System.err.println(e.getMessage());
//		}
		return response;
	}

	@GetMapping(path = "/getRoomList")
	public HotelManagementResponse getRoomList() {
		HotelManagementResponse response = new HotelManagementResponse();
		//try {
			List<RoomInformationBean> roomList = adminOperationsService.getRoomList();
			if (roomList != null) {
				response.setStatusCode(200);
				response.setMessage("Success");
				response.setDescription("Room list displayed");
				response.setRoomList(roomList);
			} else {
//				response.setStatusCode(400);
//				response.setMessage("Failed");
//				response.setDescription("Room list can't be fetched");
				throw new HotelManagementSystemException("Room list can't be fetched");
			}
//		} catch (HotelManagementSystemException e) {
//			response.setStatusCode(400);
//			response.setMessage("Failed");
//			response.setDescription(e.getMessage());
//			System.out.println(e.getMessage());
//		}
		return response;
	}

	@PutMapping(path = "/addEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HotelManagementResponse addEmployee(@RequestBody EmployeeInformationBean employeeBean) {
		HotelManagementResponse response = new HotelManagementResponse();
		String licenseNumber = employeeBean.getLicenceNumber();
		EmployeeInformationBean employeeInformationBean = null;
		//try {
			System.out.println("............1..............");
			if (adminOperationsService.licenseNumberPresent(licenseNumber)) {
				employeeInformationBean = adminOperationsService.addEmployee(employeeBean);
				if (employeeInformationBean != null) {
					response.setStatusCode(200);
					response.setMessage("Success");
					response.setDescription("Employee added successfully");
					response.setEmployeeBean(employeeInformationBean);
				} else {
//					response.setStatusCode(400);
//					response.setMessage("Failed");
//					response.setDescription("Unable to add employee");
					throw new HotelManagementSystemException("Unable to add employee");
				}
			} else {
//				response.setStatusCode(400);
//				response.setDescription("This hotel is not present.. please enter existing hotel Licence");
//				response.setMessage("Failed");
				throw new HotelManagementSystemException("This hotel is not present.. please enter existing hotel Licence");
			}
//		} catch (Exception e) {
//			response.setStatusCode(400);
//			response.setMessage("Failed");
//			response.setDescription(e.getMessage());
//			System.out.println(e.getMessage());
//		}
		return response;
	}

	@PutMapping(path = "/updateRoomInforamtion")
	public HotelManagementResponse updateRoomInformation(@RequestBody RoomInformationBean roomBean) {
		HotelManagementResponse response = new HotelManagementResponse();
	//	try {
			boolean isUpdated = adminOperationsService.updateRoomInformation(roomBean);
			if (isUpdated) {
				response.setStatusCode(200);
				response.setMessage("Success");
				response.setDescription("Hotel information updated successfully");
				response.setRoomInformationBean(roomBean);
			} else {
//				response.setStatusCode(400);
//				response.setMessage("Failed");
//				response.setDescription("Room information not updated");
				throw new HotelManagementSystemException("Room information not updated");
			}
//		} catch (Exception e) {
//			response.setStatusCode(400);
//			response.setMessage("Failed");
//			response.setDescription(e.getMessage());
//			System.err.println(e.getMessage());
//		}
		return response;
	}

	@GetMapping(path = "/getEmployeeList")
	public HotelManagementResponse getEmployeeList() {
		HotelManagementResponse response = new HotelManagementResponse();
	//	try {
			List<EmployeeInformationBean> employeeList = adminOperationsService.getEmployeeList();
			if (employeeList != null && !employeeList.isEmpty()) {
				response.setStatusCode(200);
				response.setMessage("Success");
				response.setDescription("Employee list displayed");
				response.setEmployeeList(employeeList);
			} else {
//				response.setStatusCode(400);
//				response.setMessage("Failed");
//				response.setDescription("Employee list can't be fetched");
				throw new HotelManagementSystemException("Employee list can't be fetched");
			}
//		} catch (Exception e) {
//			response.setStatusCode(400);
//			response.setMessage("Failed");
//			response.setDescription(e.getMessage());
//			System.out.println(e.getMessage());
//		}
		return response;
	}

	@DeleteMapping(path = "/deleteEmployee/{employeeId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public HotelManagementResponse deleteEmployeeInformation(@PathVariable int employeeId) {
		HotelManagementResponse response = new HotelManagementResponse();
		//try {

			boolean isDeleted = adminOperationsService.deleteEmployeeInformation(employeeId);
			if (isDeleted) {
				response.setStatusCode(200);
				response.setMessage("Success");
				response.setDescription("Employee deleted successfully");
			} else {
//				response.setStatusCode(400);
//				response.setDescription("Employee not deleted");
//				response.setMessage("Failed");
				throw new HotelManagementSystemException("Employee not deleted");
			}
//		} catch (HotelManagementSystemException e) {
//			response.setStatusCode(400);
//			response.setMessage("Failed");
//			response.setDescription(e.getMessage());
//			System.err.println(e.getMessage());
//		}
		return response;
	}

	@PutMapping(path = "/updateEmployeeInformation", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HotelManagementResponse updateEmployeeInformation(@RequestBody EmployeeInformationBean employeeBean) {
		HotelManagementResponse response = new HotelManagementResponse();
	//	try {
		System.out.println("..................."+employeeBean.getLicenceNumber());
			boolean isUpdated = adminOperationsService.updateEmployeeInformation(employeeBean);
			if (isUpdated) {
				response.setStatusCode(200);
				response.setMessage("Success");
				response.setDescription("Employee information updated successfully");
				response.setEmployeeBean(employeeBean);
			} else {
//				response.setStatusCode(400);
//				response.setMessage("Failed");
//				response.setDescription("Employee information not updated");
				throw new HotelManagementSystemException("Employee information not updated");
			}
//		} catch (HotelManagementSystemException e) {
//			response.setStatusCode(400);
//			response.setMessage("Failed");
//			response.setDescription(e.getMessage());
//			System.err.println(e.getMessage());
//		}
		return response;
	}
	
	@GetMapping(path="/getBookingHistoryForAdmin" , produces = MediaType.APPLICATION_JSON_VALUE)
	public HotelManagementResponse getBookingHistory() {
		HotelManagementResponse response = new HotelManagementResponse();
	//	try {
			List<BookingInformationBean> bookingDetails = adminOperationsService.getBookingHistory();
			if (bookingDetails != null && !bookingDetails.isEmpty()) {
				response.setStatusCode(200);
				response.setMessage("Success");
				response.setDescription("Booking details list displayed");
				response.setBookingDetailsList(bookingDetails);
				;
			} else {
//				response.setStatusCode(400);
//				response.setMessage("Failed");
//				response.setDescription("Booking details can't be fetched");
				throw new HotelManagementSystemException("Booking details can't be fetched");
			}
	//	} catch (Exception e) {
//			response.setStatusCode(400);
//			response.setMessage("Failed");
//			response.setDescription(e.getMessage());
//			System.out.println(e.getMessage());
//		}
		return response;		
	}	

	
}// end of class
