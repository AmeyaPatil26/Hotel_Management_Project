package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagementsystem.bean.BookingInformationBean;
import com.capgemini.hotelmanagementsystem.bean.EmployeeInformationBean;
import com.capgemini.hotelmanagementsystem.bean.HotelInformationBean;
import com.capgemini.hotelmanagementsystem.bean.RoomInformationBean;
import com.capgemini.hotelmanagementsystem.dao.AdminOperationDao;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemException;
import com.capgemini.hotelmanagementsystem.validation.HotelValidation;

@Service
public class AdminOperationServiceImpl implements AdminOperationService {

	@Autowired
	private AdminOperationDao adminOperationsDao;

	@Autowired
	private HotelValidation hotelValidation;

	@Override
	public HotelInformationBean addHotel(HotelInformationBean hotelInformationBean) {
		String hotelName = hotelInformationBean.getHotelName();
		String hotelContactNumber = hotelInformationBean.getHotelContactNumber();
		String hotelLicenseNumber = hotelInformationBean.getLicenceNumber();
		if (hotelName.isEmpty() || hotelContactNumber.isEmpty() || hotelLicenseNumber.isEmpty()
				|| hotelInformationBean.getHotelAddress().isEmpty()
				|| hotelInformationBean.getHotelImageURL().isEmpty()) {
			throw new HotelManagementSystemException("Some Empty value is passed");
		} else {
				if (hotelValidation.contactNumberValidation(hotelContactNumber)) {
					if (hotelValidation.licenseValidation(hotelLicenseNumber)) {
						return adminOperationsDao.addHotel(hotelInformationBean);
					} else {
						throw new HotelManagementSystemException(
								"Liscence Number must begin with H and must have 8 integer");
					} // End of else for licenseValidation()
				} else {
					throw new HotelManagementSystemException(
							"Contact Number first Integer must be between [7-9] and rest as follow");
				} // End of else for contactNumberValidation()
		} // End of if for avoiding null
	}

	@Override
	public List<HotelInformationBean> getHotelList() {
		return adminOperationsDao.getHotelList();
	}

	@Override
	public boolean updateHotelInformation(HotelInformationBean hotelInformationBean) {
		String hotelName = hotelInformationBean.getHotelName();
		String hotelContactNumber = hotelInformationBean.getHotelContactNumber();
		String hotelLicenseNumber = hotelInformationBean.getLicenceNumber();
		if (hotelInformationBean.getHotelId() == 0 || hotelName.isEmpty() || hotelContactNumber.isEmpty()
				|| hotelLicenseNumber.isEmpty() || hotelInformationBean.getHotelAddress().isEmpty()
				|| hotelInformationBean.getHotelImageURL().isEmpty()) {
			throw new HotelManagementSystemException("Some Empty value is passed");
		} else {
			if (hotelValidation.nameValidation(hotelName)) {
				if (hotelValidation.contactNumberValidation(hotelContactNumber)) {
					if (hotelValidation.licenseValidation(hotelLicenseNumber)) {
						return adminOperationsDao.updateHotelInformation(hotelInformationBean);
					} else {
						throw new HotelManagementSystemException(
								"Liscence No. must begin with H and must have 8 integer");
					} // End of else for licenseValidation()
				} else {
					throw new HotelManagementSystemException(
							"Contact Number first Integer must be between [7-9] and rest as follow");
				} // End of else for contactNumberValidation()
			} else {
				throw new HotelManagementSystemException("Hotel Name must be in xyz abc fromat");
			} // End of else for nameValidation()
		} // End of else for null	
		}

	@Override
	public boolean deleteHotelInformation(int hotelId) {
		String hotelNewId = Integer.toString(hotelId);
		if (hotelNewId.isEmpty()) {
			throw new HotelManagementSystemException("Empty value is Passed");
		} else {
			if (hotelValidation.idValidation(hotelNewId)) {
				int hotelUpdateId = Integer.parseInt(hotelNewId);
				return adminOperationsDao.deleteHotelInformation(hotelUpdateId);
			} else {
				throw new HotelManagementSystemException("Enter Valid hotelId");
			} // End of else
		} // End of else for Empty
	}

	@Override
	public RoomInformationBean addRoom(RoomInformationBean roomInformationBean) {
		System.out.println(".....inside.............1");
		String hotelLicenseNumber = roomInformationBean.getLicenceNumber();
		int amount = roomInformationBean.getRoomAmount();
		String amountNew = Integer.toString(amount);
		int roomCount = roomInformationBean.getRoomCount();
		String roomCountNew = Integer.toString(roomCount);
			if (hotelValidation.licenseValidation(hotelLicenseNumber)) {
				if (hotelValidation.idValidation(roomCountNew)) {
					if (hotelValidation.idValidation(amountNew)) {
						System.out.println(".....2......"+roomInformationBean.getLicenceNumber());
						return adminOperationsDao.addRoom(roomInformationBean);
					} else {
						System.out.println("......fail1.....");
						throw new HotelManagementSystemException("Enter Valid Integer for Amount");
					} // End of else for AddRoom
				} else {
					System.out.println("......fail2.....");
					throw new HotelManagementSystemException("Enter Valid Integer for Room Count");
				} // End of else for RoomCount
			} else {
				System.out.println("......fail3.....");
				throw new HotelManagementSystemException("Liscence No. must begin with H and must have 8 integer");
			} // End of else for licenseValidation()
		} // End of else for Empty value
		


	@Override
	public boolean deleteRoomInformation(int roomId) {
		String roomNewId = Integer.toString(roomId);
		if (hotelValidation.idValidation(roomNewId)) {
			int roomUpdateId = Integer.parseInt(roomNewId);
			return adminOperationsDao.deleteRoomInformation(roomUpdateId);
		} else {
			throw new HotelManagementSystemException("Enter Valid hotelId");
		} // End of else
	}

	@Override
	public List<RoomInformationBean> getRoomList() {
		return adminOperationsDao.getRoomList();
	}

	@Override
	public boolean updateRoomInformation(RoomInformationBean roomInformationBean) {
		String hotelLicenseNumber = roomInformationBean.getLicenceNumber();
		int amount = roomInformationBean.getRoomAmount();
		String amountNew = Integer.toString(amount);
		int roomCount = roomInformationBean.getRoomCount();
		String roomCountNew = Integer.toString(roomCount);
		if (roomInformationBean.getLicenceNumber().isEmpty() || roomInformationBean.getHotelName().isEmpty()
				|| roomInformationBean.getHotelId() == 0 || roomInformationBean.getRoomCount() == 0
				|| roomInformationBean.getRoomAmount() == 0 || roomInformationBean.getRoomCapacity().isEmpty()
				|| roomInformationBean.getRoomImageURL().isEmpty() || roomInformationBean.getRoomStatus().isEmpty()
				|| roomInformationBean.getRoomType().isEmpty()) {
			throw new HotelManagementSystemException("Some Empty value is passed");
		} else {
			if (hotelValidation.licenseValidation(hotelLicenseNumber)) {
				if (hotelValidation.idValidation(roomCountNew)) {
					if (hotelValidation.idValidation(amountNew)) {
						return adminOperationsDao.updateRoomInformation(roomInformationBean);
					} else {
						throw new HotelManagementSystemException("Enter Valid Integer for Amount");
					} // End of else for AddRoom
				} else {
					throw new HotelManagementSystemException("Enter Valid Integer for Room Count");
				} // End of else for RoomCount
			} else {
				throw new HotelManagementSystemException("Liscence No. must begin with H and must have 8 integer");
			} // End of else for licenseValidation()
		} // End of else for empty value

	}

	@Override
	public EmployeeInformationBean addEmployee(EmployeeInformationBean employeeInformationBean) {
		
			if (hotelValidation.licenseValidation(employeeInformationBean.getLicenceNumber())) {
				
					if (hotelValidation.emailValidation(employeeInformationBean.getEmail())) {
						if (hotelValidation.passwordValidation(employeeInformationBean.getPassword())) {
							if (hotelValidation
									.contactNumberValidation(employeeInformationBean.getContactNumber())) {
								if (hotelValidation.nameValidation(employeeInformationBean.getName())) {
									System.out.println("............2...........");
									return adminOperationsDao.addEmployee(employeeInformationBean);
								} else {
									throw new HotelManagementSystemException("Name must be in abc efg format");
								} // End of name else
							} else {
								throw new HotelManagementSystemException(
										"Contact Number first Integer must be between [7-9] and rest as follow");
							} // End of contactNumber else
						} else {
							throw new HotelManagementSystemException("Password must have 6-20 character in it");
						} // End of else for password
					} else {
						throw new HotelManagementSystemException("Email must be in abc@gmail.com format");
					} // End of else for email
				
			} else {
				throw new HotelManagementSystemException("Liscence No. must begin with H and must have 8 integer");
			} // End of else for licenseValidation()
		} // End of else for empty value

		

	@Override
	public List<EmployeeInformationBean> getEmployeeList() {
		return adminOperationsDao.getEmployeeList();
	}

	@Override
	public boolean deleteEmployeeInformation(int employeeId) {
		String employeeNewId = Integer.toString(employeeId);
		if (hotelValidation.idValidation(employeeNewId)) {
			int employeeUpdateId = Integer.parseInt(employeeNewId);
			return adminOperationsDao.deleteEmployeeInformation(employeeUpdateId);
		} else {
			throw new HotelManagementSystemException("Enter Valid employeeId");
		} // End of else
	}

	@Override
	public boolean updateEmployeeInformation(EmployeeInformationBean employeeInformationBean) {
		System.out.println("...........inside service.............");
		System.out.println("..............."+employeeInformationBean.getLicenceNumber());
				if (hotelValidation.licenseValidation(employeeInformationBean.getLicenceNumber())) {
					System.out.println(".........inside1.....");
//					if (hotelValidation.nameValidation(employeeInformationBean.getHotelName())) {
						if (hotelValidation.emailValidation(employeeInformationBean.getEmail())) {
							System.out.println(".........inside2.....");
							if (hotelValidation.passwordValidation(employeeInformationBean.getPassword())) {
								System.out.println(".........inside3.....");
								if (hotelValidation
										.contactNumberValidation(employeeInformationBean.getContactNumber())) {
									System.out.println(".........inside4.....");
									if (hotelValidation.nameValidation(employeeInformationBean.getName())) {
										System.out.println("...................2..........................");
										return adminOperationsDao.updateEmployeeInformation(employeeInformationBean);
									} else {
										System.out.println("..............fail1............");
										throw new HotelManagementSystemException("Name must be in abc efg format");
									} // End of name else
								} else {
									System.out.println("..............fail2............");
									throw new HotelManagementSystemException(
											"Contact Number first Integer must be between [7-9] and rest as follow");
								} // End of contactNumber else
							} else {
								System.out.println("..............fail3............");
								throw new HotelManagementSystemException("Password must have 6-20 character in it");
							} // End of else for password
						} else {
							System.out.println("..............fail4............");
							throw new HotelManagementSystemException("Email must be in abc@gmail.com format");
						} // End of else for email
				} else {
					
					throw new HotelManagementSystemException(
							"Liscence No. must begin with H and must have 8 integer");
			} // End of else for licenseValidation()
		} // End of else for empty value

//	}

	@Override
	public boolean licenseNumberPresent(String licenseNumber) {
		if (licenseNumber.isEmpty()) {
			throw new HotelManagementSystemException("Some where Empty value is passed");
		} else {
			if (hotelValidation.licenseValidation(licenseNumber)) {
				return adminOperationsDao.licenseNumberPresent(licenseNumber);
			} else {
				throw new HotelManagementSystemException("Liscence No. must begin with H and must have 8 integer");
			} // End of else for licenseValidation()
		} // End of else for null value
	}
	@Override
	public List<BookingInformationBean> getBookingHistory() {
		return adminOperationsDao.getBookingHistory();
	}
}// end of class
