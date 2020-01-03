package com.capgemini.hotelmanagementsystem.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hotel_information")
public class HotelInformationBean {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hotelId;
	@Column
	private String licenceNumber;
	@Column
	private String hotelName;
	@Column
	private String hotelAddress;
	@Column
	private String hotelContactNumber;
	@Column
	private String hotelImageURL;

	// getter setter method

	public int getHotelId() {
		return hotelId;
	}

	public String getHotelImageURL() {
		return hotelImageURL;
	}

	public void setHotelImageURL(String hotelImageURL) {
		this.hotelImageURL = hotelImageURL;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public String getHotelContactNumber() {
		return hotelContactNumber;
	}

	public void setHotelContactNumber(String hotelContactNumber) {
		this.hotelContactNumber = hotelContactNumber;
	}

}// end of class
