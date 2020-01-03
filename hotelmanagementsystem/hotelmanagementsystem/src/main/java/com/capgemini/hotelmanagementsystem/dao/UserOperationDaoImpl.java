package com.capgemini.hotelmanagementsystem.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelmanagementsystem.bean.AdminEmployeeUserBean;
import com.capgemini.hotelmanagementsystem.bean.BookingInformationBean;
import com.capgemini.hotelmanagementsystem.bean.HotelInformationBean;
import com.capgemini.hotelmanagementsystem.bean.RoomInformationBean;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemException;

@Repository
public class UserOperationDaoImpl implements UserOperationDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public List<RoomInformationBean> roomList(HotelInformationBean hotelInformationBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<RoomInformationBean> roomlList = null;
		try {

			String jpql = "from RoomInformationBean where licenceNumber=:licenceNumber";
			Query query = entityManager.createQuery(jpql);
			String licenceNumber = hotelInformationBean.getLicenceNumber();
			query.setParameter("licenceNumber", licenceNumber);

			roomlList = query.getResultList();
		} catch (Exception e) {
			throw new HotelManagementSystemException("Something went wrong... room list not found");
		}
		return roomlList;

	}

	@Override
	public BookingInformationBean bookRoomUser(BookingInformationBean bookingInformationBean) {
		System.out.println("........bean book inside impl...." + bookingInformationBean);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(bookingInformationBean);
			transaction.commit();
		} catch (Exception e) {
			throw new HotelManagementSystemException("Something went wrong...cant book room now");
		}
		return bookingInformationBean;
	}

	@Override
	public double calculateTotalDaysAmount(BookingInformationBean bookingInformationBean) {
		Date checkIn = bookingInformationBean.getCheckInDate();
		Date checkOut = bookingInformationBean.getCheckOutDate();
		double roomAmount = bookingInformationBean.getBookingAmount();
		double totalBill = 0;
		double noOfDays = 0;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MM dd");
		long difference = checkOut.getTime() - checkIn.getTime();
		noOfDays = (difference / (1000 * 60 * 60 * 24));
		totalBill = (noOfDays + 1) * roomAmount;

		return totalBill;
	}

	@Override
	public int updateRoomCount(int roomId) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			int updatedRoomCount = 0;
			RoomInformationBean roomInformationBean = entityManager.find(RoomInformationBean.class, roomId);
			boolean isUpdated = false;
			if (roomInformationBean != null) {
				int roomCount = roomInformationBean.getRoomCount();
				if (roomCount != 0) {
					updatedRoomCount = roomCount - 1;
					roomInformationBean.setRoomCount(updatedRoomCount);
					transaction.begin();
					entityManager.persist(roomInformationBean);
					transaction.commit();
					entityManager.close();
					isUpdated = true;
					System.out.println(".....................updateRoomCount" + updatedRoomCount);
				}
			}

			// isUpdated = true;
			return updatedRoomCount;
		} catch (Exception e) {
			throw new HotelManagementSystemException("Something went wrong... user can't be updated");
		}

	}

	@Override
	public String updateRoomStatus(int roomId) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			String updatedRoomStatus = null;
			RoomInformationBean roomInformationBean = entityManager.find(RoomInformationBean.class, roomId);
			boolean isUpdated = false;
			if (roomInformationBean != null) {
				String roomStatus = roomInformationBean.getRoomStatus();
				if (roomStatus != null) {
					updatedRoomStatus = "Not Available";
					roomInformationBean.setRoomStatus(updatedRoomStatus);
					transaction.begin();
					entityManager.persist(roomInformationBean);
					transaction.commit();
					entityManager.close();
					isUpdated = true;
					System.out.println(".....................updatedRoomStatus" + updatedRoomStatus);
				}
			}

			// isUpdated = true;
			return updatedRoomStatus;
		} catch (Exception e) {
			throw new HotelManagementSystemException("Something went wrong... user can't be updated");
		}
	}

	@Override
	public List<BookingInformationBean> getBookingHistory(String email) {
		List<BookingInformationBean> bookingDetails = null;
		try {
			String jpql = "from BookingInformationBean where email =: email";
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			Query query = entityManager.createQuery(jpql);
			query.setParameter("email", email);
			bookingDetails = query.getResultList();
			// return bookingDetails;
		} catch (Exception e) {
			throw new HotelManagementSystemException("Failed to load list");
		}
		return bookingDetails;

	}

	@Override
	public boolean cancelBooking(int bookingId) {
		boolean isDeleted = false;
		String jpql = "delete from BookingInformationBean where bookingId =: bookingId";
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createQuery(jpql);
		query.setParameter("bookingId", bookingId);
		int result = query.executeUpdate();
		transaction.commit();
		if (result > 0) {
			isDeleted = true;
		} else {
			isDeleted = false;
		}
		return isDeleted;
	}

}// end of class
