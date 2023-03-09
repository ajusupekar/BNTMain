package com.cucumber.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.utility.LogCapture;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MasonsWebPortalStepDef 
{
	public static WebDriver driver;
	
	@Given("^User should be able to launch the chrome browser and navigates to masons super admin portal$")
	public void user_should_be_able_to_launch_the_chrome_browser_and_navigates_to_masons_super_admin_portal() throws Throwable 
	{
		// Set the path to the Chrome driver executable
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");       
        // Create a new ChromeDriver object
        driver = new ChromeDriver();
        // Navigate to the URL
        driver.get("https://masons.agoracoretech.com/superadmin-login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        LogCapture.info("User launched the chrome browser successfully and navigates to Masons portal URL...");
	}

	@Then("^User land on masons super admin portal login screen$")
	public void user_land_on_masons_super_admin_portal_login_screen() throws Throwable 
	{
		String masonsLoginScreen = "//*[text()='Super User']";
		WebElement loginScreen = driver.findElement(By.xpath(masonsLoginScreen));
		loginScreen.isDisplayed();
		LogCapture.info("User is on Masons Super Admin portal login screen...");
	}

	@When("^User provides masons super admin Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void user_provides_masons_super_admin_Username_and_Password(String SAEmail, String SAPass) throws Throwable 
	{
		String masonsEamilInput = "//*[@id='email']";
		String masonsPassInput = "//*[@id='password']";
		WebElement emailInput = driver.findElement(By.xpath(masonsEamilInput));
		emailInput.isDisplayed();
		emailInput.sendKeys(SAEmail);
		LogCapture.info("User entered the email successfully..."+SAEmail);
		
		WebElement passInput = driver.findElement(By.xpath(masonsPassInput));
		passInput.isDisplayed();
		passInput.sendKeys(SAPass);
		LogCapture.info("User entered the password successfully..."+SAPass);
	}

	@When("^User click on the masons super admin portal LOGIN button$")
	public void user_click_on_the_masons_super_admin_portal_LOGIN_button() throws Throwable
	{
		String masonsLoginButton = "//*[@type='submit']";
		WebElement loginButton = driver.findElement(By.xpath(masonsLoginButton));
		loginButton.isDisplayed();
		loginButton.click();
		LogCapture.info("User clicked on the Login button...");
	}

	@Then("^User land on masons super admin dashboard screen$")
	public void user_land_on_masons_super_admin_dashboard_screen() throws Throwable 
	{
		String superAdminDashboard = "//*[text()='SUPER USR']";
		WebElement dashScreen = driver.findElement(By.xpath(superAdminDashboard));
		
		dashScreen.isDisplayed();
		LogCapture.info("User is on Super Admin dashboard screen...");
	}

	@When("^User click on the masons super admin portal Logout button$")
	public void user_click_on_the_masons_super_admin_portal_Logout_button() throws Throwable 
	{
		String logoutButton = "//*[text()='Logout']";
		WebElement logoutBtn = driver.findElement(By.xpath(logoutButton));
		logoutBtn.isDisplayed();
		logoutBtn.click();
		LogCapture.info("User clicked on the Logout button...");
	}
	
	@Then("^User quit the browser$")
	public void user_quit_the_browser() throws Throwable 
	{
		driver.quit();
	}
	
}
