package com.stepdef;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.generic.DriverManager;
import com.pagefactory.MasterPageFactory;
import com.util.Highlighter;
import com.util.Screenshot;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {

	WebDriver driver;
	MasterPageFactory mpf;
	@Given("Open the Browser")
	public void open_the_browser() {
	    
	   DriverManager dm = new DriverManager();
	   driver = dm.getChromeDriver(driver);
	}

	@Given("pass the website url  {string}")
	public void pass_the_website_url(String URL) {
	    
		driver.navigate().to(URL);
	}

	@When("Enter the username {string}")
	public void enter_the_username(String username) {
		
	    mpf = new MasterPageFactory(driver);
	    //Highlighting 
	    Highlighter.addColor(driver, mpf.getUsername());
	    mpf.getUsername().sendKeys(username);
	   
	}

	@When("Enter the password {string}")
	public void enter_the_password(String password) {
	    //Highlighting 
	  // Highlighter.addColor(driver, mpf.getPassword());  
	   mpf.getPassword().sendKeys(password);
	}

	@When("Click on Login Button")
	public void click_on_login_button() {
	    //Highlighting 
	   //Highlighter.addColor(driver, mpf.getLogin_btn());   
	   mpf.getLogin_btn().click();
	}

	@Then("Validate the Login is successful")
	public void validate_the_login_is_successful() {
	    Assert.assertTrue(mpf.getHomepage().isDisplayed(),"Logged In");
	    
	    if(mpf.getHomepage().isDisplayed()==true)
	    {
	    	//	ScreenShot
	    	//Screenshot.getScreenShot(driver, "Homepage-login-successful");
	    	System.out.println("Log in Successful");
	    }else
	    {
	    	System.out.println("Log in Failed");
	    }
	}
	
	@Then("Validate the Login is failed")
	public void error_message() {
		
		
		mpf.getError_msg().isDisplayed();
		//		ScreenShot
		//Screenshot.getScreenShot(driver, "Login-Failed");
	}
	
	@When("Click on Logout Button")
	public void click_on_logout_button() {
	 
	   mpf.getLogout().click();
	   //		ScreenShot
	   //Screenshot.getScreenShot(driver, "Logged-out");
	}
	
	@When("Click on Open menu side bar")
	public void click_on_open_menu_side_bar() {
	   mpf.getMenu().click();
	}
	
	@Then("Validate the Logout  is successful")
	public void validate_the_logout_is_successful() {
	  
	SoftAssert sa = new SoftAssert();
	sa.assertTrue(mpf.getLogin_btn().isDisplayed(),"logged out");
	}

	@When("every test passed, take screenshot")
	public void take_screenshot() {
		Screenshot.getScreenShot(driver, "Logged-out");
		// how to take screenshot after every scenario test run ?
	}
	
	@Given("Quit the Browser")
	public void quit_the_browser() {
	   driver.quit();
	}
}
