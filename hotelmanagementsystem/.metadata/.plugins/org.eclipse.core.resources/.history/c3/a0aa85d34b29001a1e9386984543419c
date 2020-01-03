package com.capgemini.hotelmanagementsystem.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelmanagementsystem.bean.AdminEmployeeUserBean;
import com.capgemini.hotelmanagementsystem.dao.AdminEmployeeUserDao;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemException;

@Repository
public class AdminEmployeeUserDaoImpl implements AdminEmployeeUserDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public AdminEmployeeUserBean adminEmployeeUserLogin(String email, String password) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			AdminEmployeeUserBean adminEmployeeUserBean = null;

			String jpql = "from AdminEmployeeUserBean where email = :email and password = :password";
			Query query = entityManager.createQuery(jpql);

			query.setParameter("email", email);
			query.setParameter("password", password);

			adminEmployeeUserBean = (AdminEmployeeUserBean) query.getSingleResult();
			return adminEmployeeUserBean;
		} catch (Exception e) {
			// throw new HotelManagementException("Unable to Login..Please try agian");
			return null;
		}
	}// end of adminEmployeeUserLogin()

	@Override
	public AdminEmployeeUserBean userRegister(AdminEmployeeUserBean adminEmployeeUserBean) {

		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();

			entityTransaction.begin();
			entityManager.persist(adminEmployeeUserBean);
			entityTransaction.commit();

			return adminEmployeeUserBean;

		} catch (Exception e) {
			return null;
		}

	}// end of userRegister()

	@Override
	public boolean checkUserEmail(String email) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();

			String jpql = "from AdminEmployeeUserBean";
			Query query = entityManager.createQuery(jpql);
			List<AdminEmployeeUserBean> userEmailList = query.getResultList();

			for (AdminEmployeeUserBean UserEmail : userEmailList) {

				if (email.equals(UserEmail.getEmail())) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			return false;
		}

	}// end of checkUserEmail()

	@Override
	public AdminEmployeeUserBean userProfile(AdminEmployeeUserBean adminEmployeeUserBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityManagerFactory = entityManager.getTransaction();

		entityManagerFactory.begin();
		System.out.println(".....adminEmployeeUserBean" + adminEmployeeUserBean.getId());
		AdminEmployeeUserBean adminEmployeeUserBeanProfile = entityManager.find(AdminEmployeeUserBean.class,
				adminEmployeeUserBean.getId());

		entityManagerFactory.commit();
		return adminEmployeeUserBeanProfile;
	}

	@Override
	public AdminEmployeeUserBean updateUserProfile(AdminEmployeeUserBean adminEmployeeUserBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		AdminEmployeeUserBean adminEmployeeUserBean1 = entityManager.find(AdminEmployeeUserBean.class,
				adminEmployeeUserBean.getId());
		// boolean isUpdated = false;
		if (adminEmployeeUserBean1 != null) {
			String name = adminEmployeeUserBean.getName();
			if (name != null) {
				adminEmployeeUserBean1.setName(name);
			}
			String address = adminEmployeeUserBean.getAddress();

			if (address != null) {
				adminEmployeeUserBean1.setAddress(address);
			}

			String email = adminEmployeeUserBean.getEmail();
			if (email != null) {
				adminEmployeeUserBean1.setEmail(email);
			}
			String contactNumber = adminEmployeeUserBean.getContactNumber();
			if (contactNumber != null) {
				adminEmployeeUserBean1.setContactNumber(contactNumber);

			}
			String password = adminEmployeeUserBean.getPassword();
			if (password != null) {
				adminEmployeeUserBean1.setPassword(password);
			}
			String nationality = adminEmployeeUserBean.getNationality();
			if (nationality != null) {
				adminEmployeeUserBean1.setNationality(nationality);
			}

		}
		try {
			transaction.begin();
			entityManager.persist(adminEmployeeUserBean1);
			transaction.commit();
			// isUpdated = true;
		} catch (Exception e) {
			throw new HotelManagementSystemException("Something went wrong... user can't be updated");
		}
		entityManager.close();
		return adminEmployeeUserBean1;

	}

}// end of class
