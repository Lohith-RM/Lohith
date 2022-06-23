package com.crm.objectRepository;

import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//declaration
	@FindBy(name="user_name")
	private WebElement userNameTxtEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordTxtEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginButn;
	
	//initialization
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getUserNameTxtEdt() {
		return userNameTxtEdt;
	}

	public WebElement getPasswordTxtEdt() {
		return passwordTxtEdt;
	}

	public WebElement getLoginButn() {
		return loginButn;
	}
	
	//business libraries
	
	public void loginToHomePage(String username, String password)
	{
		userNameTxtEdt.sendKeys(username);
		passwordTxtEdt.sendKeys(password);
		loginButn.click();
	}
	
	
	
	
	

}
