package com.capgemini.hotelmanagementsystem.stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;

public class AdminStepDefination {

	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	WebDriver driver = new ChromeDriver();

	@When("^admin Click on Login Link$")
	public void admin_Click_on_Login_Link() throws Throwable {
		driver.get("http://localhost:4200/login");
		Thread.sleep(3000);
	}

	@When("^admin Enter the valid Login Data$")
	public void admin_Enter_the_valid_Login_Data() throws Throwable {
		driver.findElement(By.name("email")).sendKeys("admin@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Admin@123");
		Thread.sleep(3000);

	}

	@When("^admin Click on Login button$")
	public void admin_Click_on_Login_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/form/div[3]/button[1]")).click();
		Thread.sleep(6000);

	}

	
							/*Show hotel list and update*/
	@When("^admin Click on hotel list button$")
	public void admin_Click_on_hotel_list_button() throws Throwable {
		driver.findElement(By.xpath(
				"/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav/div/mat-nav-list/a[1]/div"))
				.click();
		Thread.sleep(6000);
	}

	@When("^admin click on hotel list update button$")
	public void admin_click_on_hotel_list_update_button() throws Throwable {
		driver.findElement(By.xpath(
				"/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav-content/app-admin-hotel-list/div[2]/div/div/button[2]")).click();
		Thread.sleep(6000);
	}

	@When("^admin click on update button$")
	public void admin_click_on_update_button() throws Throwable {
		driver.findElement(By.xpath(
				"/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav-content/app-admin-update-hotel/div/form/div[4]/button[2]"))
				.click();
		//the values are already present in update so it shows in console id is present and go to delete button i.e next step
		Thread.sleep(6000);
	}

	@When("^admin click on delete$")
	public void admin_click_on_delete() throws Throwable {
		driver.findElement(By.xpath(
				"/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav-content/app-admin-hotel-list/div[2]/div/div/button[1]"))
				.click();
		Thread.sleep(6000);
	}
	

			/*To add Hotel*/
	@When("^admin Click on add hotel button$")
	public void admin_Click_on_add_hotel_button() throws Throwable {
		driver.findElement(By.xpath(
				"/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav/div/mat-nav-list/a[2]/div"))
				.click();
		Thread.sleep(6000);
	}

	@When("^admin enter add hotel valid data$")
	public void admin_enter_add_hotel_valid_data() throws Throwable {
		driver.findElement(By.name("licenceNumber")).sendKeys("H10101010");
		driver.findElement(By.name("hotelName")).sendKeys("Taj Hotel");
		driver.findElement(By.name("hotelAddress")).sendKeys("Mumbai ");
		driver.findElement(By.name("hotelContactNumber")).sendKeys("9876543210");
		driver.findElement(By.name("hotelImageURL"))
				.sendKeys("https://cdn.pixabay.com/photo/2014/09/12/03/42/stockholm-442338__340.jpg");
		Thread.sleep(3000);
	}

	@When("^admin click on add button$")
	public void admin_click_on_add_button() throws Throwable {
		driver.findElement(By.xpath(
				"/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav-content/app-admin-add-hotel/div/form/div[4]/button[2]"))
				.click();
		Thread.sleep(6000);
	}

	//To update and delete room
	@When("^admin Click on room list button$")
	public void admin_Click_on_room_list_button() throws Throwable {
		driver.findElement(By.xpath(
				"/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav/div/mat-nav-list/a[3]/div"))
				.click();
		Thread.sleep(6000);
	}

	@When("^admin click on room list update button$")
	public void admin_click_on_room_list_update_button() throws Throwable {
		driver.findElement(By.xpath(
				"/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav-content/app-admin-update-room/div/form/div[4]/button[2]"))
				.click();
		Thread.sleep(6000);
	}

	@When("^admin click on delete room$")
	public void admin_click_on_delete_room() throws Throwable {
		driver.findElement(By.xpath(
				"/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav-content/app-admin-room-list/div[1]/div/div/button[1]"))
				.click();
		Thread.sleep(6000);
	   
	}
	
	//To add room
	@When("^admin Click on add room button$")
	public void admin_Click_on_add_room_button() throws Throwable {
		driver.findElement(By.xpath(
				"/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav/div/mat-nav-list/a[4]/div"))
				.click();
		Thread.sleep(6000);
	}
	
	@When("^admin click on room update button$")
	public void admin_click_on_room_update_button() throws Throwable {
		driver.findElement(By.xpath(
				"/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav-content/app-admin-update-room/div/form/div[4]/button[2]"))
				.click();
		Thread.sleep(6000);
	}



	@When("^admin enter add room valid data$")
	public void admin_enter_add_room_valid_data() throws Throwable {
		
		driver.findElement(By.name("licenceNumber")).sendKeys("H40404040");
		driver.findElement(By.name("roomCount")).sendKeys("2");
		driver.findElement(By.name("roomType")).sendKeys("AC");
		driver.findElement(By.name("roomCapacity")).sendKeys("singleBed ");
		driver.findElement(By.name("roomAmount")).sendKeys("8547");
		driver.findElement(By.name("roomStatus")).sendKeys("Available");
		driver.findElement(By.name("roomImageURL"))
				.sendKeys("https://cdn.pixabay.com/photo/2014/09/12/03/42/stockholm-442338__340.jpg");
		Thread.sleep(3000);
	}
	
	@When("^admin click on addRoom button in add Room$")
	public void admin_click_on_addRoom_button_in_add_Room() throws Throwable {
		driver.findElement(By.xpath(
				"/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav-content/app-admin-add-room/div/form/div[5]/button[2]"))
				.click();
		Thread.sleep(6000);
		
	}

	//to update employee

	@When("^admin Click on employee list button$")
	public void admin_Click_on_employee_list_button() throws Throwable {
		driver.findElement(By.xpath(
				"/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav/div/mat-nav-list/a[5]/div"))
				.click();
		Thread.sleep(3000);
	}
	@When("^admin click on employee list update button$")
	public void admin_click_on_employee_list_update_button() throws Throwable {
		driver.findElement(By.xpath(
				"/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav-content/app-admin-employee-list/div/table/tbody/tr[1]/td[8]/button"))
				.click();
		
		Thread.sleep(6000);
	}

	
	//To employee
	@When("^admin Click on add employee button$")
	public void admin_Click_on_add_employee_button() throws Throwable {
		driver.findElement(By.xpath(
				"/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav/div/mat-nav-list/a[6]/div"))
				.click();
		Thread.sleep(6000);
	}

	@When("^admin enter add employee valid data$")
	public void admin_enter_add_employee_valid_data() throws Throwable {
		driver.findElement(By.name("licenceNumber")).sendKeys("H40404040");
		driver.findElement(By.name("name")).sendKeys("Komal Gunaki");
		driver.findElement(By.name("contactNumber")).sendKeys("7887959912");
		driver.findElement(By.name("email")).sendKeys("komal@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Komal@123");
		driver.findElement(By.name("address")).sendKeys("New Delhi");
		driver.findElement(By.name("nationality")).sendKeys("Algeria");
		Thread.sleep(3000);
	}


@When("^admin click on employee update button$")
public void admin_click_on_employee_update_button() throws Throwable {
	driver.findElement(By.xpath(
			"/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav-content/app-admin-employee-list/div/table/tbody/tr[1]/td[8]/button"))
			.click();
}

@When("^admin click on delete employee$")
public void admin_click_on_delete_employee() throws Throwable {
	driver.findElement(By.xpath(
			"/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav-content/app-admin-employee-list/div/table/tbody/tr[2]/td[7]/button"))
			.click();
}


	
}
