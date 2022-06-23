package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
	
	@FindBy(name="accountname")
	private WebElement organizationNameTxtEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]'][1]")
	private WebElement saveButn;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement organizername;
	
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	public WebElement getOrganizationNameTxtEdt() {
		return organizationNameTxtEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveButn() {
		return saveButn;
	}
	
	
	public WebElement getOrganizername() {
		return organizername;
	}


	public void CreateNewOrganizationPage(String orgname, String industryType, String accountType, WebDriver driver) throws Throwable
	{
		organizationNameTxtEdt.sendKeys(orgname);
		
		selectDropDownByVtext(industryDropDown, industryType);
		
		selectDropDownByVtext(typeDropDown, accountType);
		
		saveButn.click();
		
		takeScreenShot(driver, "OrganizationTestNG");
		
	}
}
