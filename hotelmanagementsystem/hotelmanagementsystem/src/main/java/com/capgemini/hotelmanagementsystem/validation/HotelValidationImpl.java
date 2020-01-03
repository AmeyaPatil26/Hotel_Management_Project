package com.capgemini.hotelmanagementsystem.validation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemException;

@Repository
public class HotelValidationImpl implements HotelValidation {

	Pattern pattern = null;
	Matcher matcher = null;

	public boolean emailValidation(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,4}$";
		pattern = Pattern.compile(emailRegex);
		if (pattern.matcher(email).matches()) {
			return true;
		}//End of if
		return false;
	}//End of emailValidation()

	@Override
	public boolean passwordValidation(String password) {
		//pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$"
		//pattern = Pattern.compile("\\D+");
		pattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
		matcher = pattern.matcher(password);
		if (matcher.matches()) {
			return true;
		}//End of if
		return false;
	}//End of passwordValidation()

	@Override
	public boolean licenseValidation(String hotelLicence) {
		pattern = Pattern.compile("(H)[0-9]{8}");
		matcher = pattern.matcher(hotelLicence);
		if (matcher.matches()) {
			return true;
		}//End of if
		return false;
	}//End of licenseValidation()

	@Override
	public boolean contactNumberValidation(String contactNumber) {
		pattern = Pattern.compile("[7-9]{1}[0-9]{9}");
		matcher = pattern.matcher(contactNumber);
		if (matcher.matches()) {
			return true;
		}//End of if()
		return false;
	}//End of contactNumberValidation()
	
	@Override
	public boolean idValidation(String id) {
		pattern = Pattern.compile("\\d{1,10}");
		matcher = pattern.matcher(id);
		if (matcher.matches()) {
			return true;
		}//End of if
		return false;
	}//End of idValidation()
	
	@Override
	public boolean nameValidation(String name) {
		pattern = Pattern.compile("\\w+\\s\\w+");
		matcher = pattern.matcher(name);
		if (matcher.matches()) {
			return true;
		}//End of if
		return false;
	}//End of nameValidation()

	@Override
	public boolean dateValidation(Date checkInDate, Date checkOutDate) {
		System.out.println(".................from date validation..................");
		boolean isValid = false;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// Date checkInDate = dateFormat.parse(date);
		Date currentDate;
		try {
			currentDate = dateFormat.parse(dateFormat.format(new Date()));
			System.out.println(currentDate);
			isValid = (checkInDate.after(currentDate) || checkInDate.equals(currentDate)
					&& (checkOutDate.after(checkInDate) || checkOutDate.equals(checkInDate)));
		} catch (Exception e) {
			throw new HotelManagementSystemException("Enter proper check-in and check-out date");
		}
		return isValid;
	}


}// end of class
