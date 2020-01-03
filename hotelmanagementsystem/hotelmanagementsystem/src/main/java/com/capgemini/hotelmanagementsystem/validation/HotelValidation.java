package com.capgemini.hotelmanagementsystem.validation;

import java.util.Date;

public interface HotelValidation {
	public boolean emailValidation(String email);

	public boolean passwordValidation(String password);

	public boolean licenseValidation(String hotelLicence);
	
	public boolean contactNumberValidation (String contactNumber);
	
	public boolean idValidation(String id);
	
	public boolean nameValidation(String name);
	
	public boolean dateValidation(Date date, Date checkOutDate);
	
}// end of interface
