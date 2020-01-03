package com.capgemini.hotelmanagementsystem.stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserStepDefination {

	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	WebDriver driver = new ChromeDriver();

	@Given("^Open the chrome and launch the application$")
	public void open_the_chrome_and_launch_the_application() throws Throwable {
		driver.get("http://localhost:4200");
		driver.manage().window().maximize();
		Thread.sleep(3000);

	}

	@When("^Click on Register Link$")
	public void click_on_Register_Link() throws Throwable {
		driver.get("http://localhost:4200/register");
		Thread.sleep(3000);
	}

	@When("^Enter the valid data$")
	public void enter_the_valid_data() throws Throwable {
		driver.findElement(By.name("name")).sendKeys("Komal Gunaki");
		driver.findElement(By.name("contactNumber")).sendKeys("7887959912");
		driver.findElement(By.name("email")).sendKeys("komal@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Komal@123");
		driver.findElement(By.name("address")).sendKeys("New Delhi");
		driver.findElement(By.name("nationality")).sendKeys("Algeria");
		Thread.sleep(3000);
	}

	@When("^Click on Register button$")
	public void click_on_Register_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-register/div/div/form/div[4]/button[1]")).click();
		Thread.sleep(6000);
		driver.close();
	}

	@When("^Click on Login Link$")
	public void click_on_Login_Link() throws Throwable {
		driver.get("http://localhost:4200/login");
		Thread.sleep(3000);
	}

	@When("^Enter the valid Login Data$")
	public void enter_the_valid_Login_Data() throws Throwable {
		driver.findElement(By.name("email")).sendKeys("simran@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Simran@123");
		Thread.sleep(3000);
	}

	@When("^Click on Login button$")
	public void click_on_Login_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/form/div[3]/button[1]")).click();
		Thread.sleep(6000);
		driver.close();

	}

	@When("^Click on Login button for Book Room$")
	public void click_on_Login_button_for_Book_Room() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/form/div[3]/button[1]")).click();
		Thread.sleep(6000);
	}

	@When("^Click on View Room Button$")
	public void click_on_View_Room_Button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav-content/app-user-hotel-list/div[2]/div/button")).click();
		Thread.sleep(6000);
		
	}

	@When("^Click on Book Room Button$")
	public void click_on_Book_Room_Button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav-content/app-user-room-list/div/div[1]/div/button")).click();
		Thread.sleep(6000);
		
	}

	@When("^Enter CheckIn and CheckOut Date$")
	public void enter_CheckIn_and_CheckOut_Date() throws Throwable {
		driver.findElement(By.name("checkInDate")).sendKeys("31-12-2019");
		driver.findElement(By.name("checkOutDate")).sendKeys("01-01-2020");
		Thread.sleep(3000);
	}

	@Then("^Click On Submit$")
	public void click_On_Submit() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav-content/app-user-room-booking/div/div/form/button")).click();
		Thread.sleep(6000);
		
	}

	@When("^Enter Payment Valid Data$")
	public void enter_Payment_Valid_Data() throws Throwable {
		driver.findElement(By.name("username")).sendKeys("ABC ABC");
		driver.findElement(By.name("cardNumber")).sendKeys("1234567890123456");
		driver.findElement(By.name("expirationDate")).sendKeys("5-01-2020");
		driver.findElement(By.name("cvv")).sendKeys("123");
		
		Thread.sleep(3000);
		
	}

	@Then("^Click on Pay Button$")
	public void click_on_Pay_Button() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"nav-tab-card\"]/form/div[6]/button[2]")).click();
		Thread.sleep(6000);
	}
	
	@Then("^Click on Booking Report Link$")
	public void click_on_Booking_Report_Link() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav/div/mat-nav-list/a[3]/div")).click();
		Thread.sleep(6000);
		
	}
	
	@Then("^Click on Profile  Link$")
	public void click_on_Profile_Link() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav/div/mat-nav-list/a[1]/div")).click();
		Thread.sleep(6000);
	}

	@Then("^Click on logout Link$")
	public void click_on_logout_Link() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-vertical-header/mat-sidenav-container/mat-sidenav/div/mat-nav-list/a[4]/div")).click();
		Thread.sleep(6000);
	}



}
