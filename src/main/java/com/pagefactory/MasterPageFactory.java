package com.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MasterPageFactory {

	public MasterPageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//input[@id='user-name']")
	private WebElement username;
	
	@FindBy (xpath="//input[@id='password']")
	private WebElement password;
	
	@FindBy (xpath="//input[@id='login-button']")
	private WebElement login_btn;
	
	
	//@FindBy (xpath = "https://www.saucedemo.com/v1/inventory.html")
	@FindBy (xpath = "//*[@id='inventory_container']")
	private WebElement homepage;

	@FindBy (xpath="//*[text()='Logout']")
	private WebElement logout;
	
	
	public WebElement getLogout() {
		return logout;
	}
	
	 public WebElement getMenu() {
		return menu;
	}
	@FindBy (xpath="//*[text()='Open Menu']")
		private WebElement menu;
	 
	@FindBy (xpath="//*[contains(text(),'Epic sadface: ')]")
	private WebElement error_msg;

	public WebElement getError_msg() {
		return error_msg;
	}
	public WebElement getUsername() {
		return username;
	}

	public WebElement getHomepage() {
		return homepage;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin_btn() {
		return login_btn;
	}
	
}
