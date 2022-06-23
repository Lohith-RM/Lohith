package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.WebDriverUtility;

public class VtigerHomePage extends WebDriverUtility
{
	
	
	@FindBy(xpath="//a[.='Leads'][1]")
	private WebElement leadsTab;
	
	@FindBy(xpath="//a[.='Organizations'][1]")
	private WebElement organizationsTab;
	
	@FindBy(xpath="//a[.='Contacts']")
	private WebElement contactsTab;
	
	@FindBy(xpath="//a[.='Opportunities'][1]")
	private WebElement opportunitiesTab;
	
	@FindBy(xpath="//a[.='Products']")
	private WebElement productsTab;
	
	@FindBy(xpath="//a[.='More']")
	private WebElement moreMouseOver;
	
	@FindBy(xpath="//a[.='Campaigns']")
	private WebElement campaignsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement signoutLink;
	
	
	//initialization
	
	public VtigerHomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getLeadsTab() {
		return leadsTab;
	}

	public WebElement getOrganizationsTab() {
		return organizationsTab;
	}

	public WebElement getContactsTab() {
		return contactsTab;
	}

	public WebElement getOpportunitiesTab() {
		return opportunitiesTab;
	}

	public WebElement getProductsTab() {
		return productsTab;
	}

	public WebElement getMoreMouseOver() {
		return moreMouseOver;
	}
	

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getAdmimistratorImg() {
		return administratorImg;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}
	
	
	
	//utilization
	
	public void logout(WebDriver driver) throws InterruptedException
	{
		
		Thread.sleep(5000);
		mouseOverAnElement(driver, administratorImg);
		signoutLink.click();
		
	}
	
	public void mouseoverOnElement(WebDriver driver) 
	{
		mouseOverAnElement(driver, moreMouseOver);
	}
	

}
