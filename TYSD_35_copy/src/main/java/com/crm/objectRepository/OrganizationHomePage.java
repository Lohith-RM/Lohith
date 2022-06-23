package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationHomePage {
	
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createNewOrgButn;
	
	
	@FindBy(xpath="//a[.='Organization Name']//..//..//..")
	private WebElement OrganizationTable;
	
	public OrganizationHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateNewOrgButn() {
		return createNewOrgButn;
	}
	
	public WebElement getOrganizationTable() {
		return OrganizationTable;
	}



	public void clickonimagebtun()
	{
		createNewOrgButn.click();
	}
	
	
	

}
