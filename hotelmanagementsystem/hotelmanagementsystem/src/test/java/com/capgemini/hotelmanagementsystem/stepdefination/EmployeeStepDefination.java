package com.capgemini.hotelmanagementsystem.stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class EmployeeStepDefination {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	WebDriver driver = new ChromeDriver();
	
	@Given("^Open the chrome and launch the application by employee$")
	public void open_the_chrome_and_launch_the_application_by_employee() throws Throwable {
		driver.get("http://localhost:4200");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}


	
	@When("^employee Click on Login Link$")
	public void employee_Click_on_Login_Link() throws Throwable {
		driver.get("http://localhost:4200/login");
		Thread.sleep(3000);
	}

	@When("^employee Enter the valid Login Data$")
	public void employee_Enter_the_valid_Login_Data() throws Throwable {
		driver.findElement(By.name("email")).sendKeys("ameya@leela.com");
		driver.findElement(By.name("password")).sendKeys("Ameya@123");
		Thread.sleep(3000);
	}

	@When("^employee Click on Login button$")
	public void employee_Click_on_Login_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/form/div[3]/button[1]")).click();
		Thread.sleep(3000);
		
	}
	
	@When("^employee click on HotelInfo$")
	public void employee_click_on_HotelInfo() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav/div/mat-nav-list/a[1]/div")).click();
		Thread.sleep(3000);
	}
	
	@When("^employee click on Room List$")
	public void employee_click_on_Room_List() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav/div/mat-nav-list/a[2]/div")).click();
		Thread.sleep(3000);
	}

	@When("^employee click on User Booking$")
	public void employee_click_on_User_Booking() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav/div/mat-nav-list/a[3]/div")).click();
		Thread.sleep(3000);
	}

	@When("^employee enter User Booking Valid data$")
	public void employee_enter_User_Booking_Valid_data() throws Throwable {
		driver.findElement(By.name("bookingAmount")).sendKeys("5000");
		driver.findElement(By.name("roomType")).sendKeys("AC");
		driver.findElement(By.name("roomCapacity")).sendKeys("Double bed");
		driver.findElement(By.name("email")).sendKeys("dipanshu@gmail.com");
		driver.findElement(By.name("name")).sendKeys("Dipanshu Vartak");
		driver.findElement(By.name("address")).sendKeys("Boisar Cidco");
		driver.findElement(By.name("contactNumber")).sendKeys("7066020091");
		driver.findElement(By.name("nationality")).sendKeys("India");
		driver.findElement(By.name("checkInDate")).sendKeys("02-01-2020");
		driver.findElement(By.name("checkOutDate")).sendKeys("03-01-2020");
		Thread.sleep(3000);
	}
	
	@When("^employee click on Book User$")
	public void employee_click_on_Book_User() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav-content/app-employee-user-room-booking/div/form/div[7]/button[2]")).click();
		Thread.sleep(3000); 
	}

	@When("^employeee click on logout$")
	public void employeee_click_on_logout() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav/div/mat-nav-list/a[4]/div")).click();
		Thread.sleep(6000);
		driver.close();
	}




}//End of EmployeeStepDefination()
