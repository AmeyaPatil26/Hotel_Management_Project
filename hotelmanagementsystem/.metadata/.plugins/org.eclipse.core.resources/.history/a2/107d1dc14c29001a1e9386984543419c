package com.capgemini.hotelmanagementsystem.validation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Repository;

import java.util.regex.Matcher;

@Repository
public class HotelValidationDaoImpl implements HotelValidationDao {

	Pattern pattern = null;
	Matcher matcher = null;

	public boolean emailValidation(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		pattern = Pattern.compile(emailRegex);
		if (pattern.matcher(email).matches()) {
			return true;
		}
		return false;
	}// end of emailValidation()

	@Override
	public boolean passwordValidation(String password) {
		// pattern = Pattern.compile("\\w+");

		pattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
		matcher = pattern.matcher(password);
		if (matcher.matches()) {
			return true;
		}
		return false;

	}// end of passwordValidation()

	@Override
	public boolean licenseValidation(String hotelLicence) {
		pattern = Pattern.compile("^(H)[0-9]{8}$");
		matcher = pattern.matcher(hotelLicence);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contactNumberValidation(String contactNumber) {
		pattern = Pattern.compile("[7-9]{1}[0-9]{9}");
		matcher = pattern.matcher(contactNumber);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

}// end of class
