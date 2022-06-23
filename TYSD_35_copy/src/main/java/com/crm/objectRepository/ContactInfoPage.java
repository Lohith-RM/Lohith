package com.crm.objectRepository;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;

public class ContactInfoPage extends WebDriverUtility {
	
	@FindBy(name="salutationtype")
	private WebElement dropDown1;
	
	@FindBy(name="firstname")
	private WebElement firstName;
	
	@FindBy(name="lastname")
	private WebElement lastName;
	
	@FindBy(xpath="//img[@alt='Select'][1]")
	private WebElement organizationSelectTab;
	
	@FindBy(id="search_txt")
	private WebElement searchTxt;
	
	@FindBy(name="search")
	private WebElement searchTbtn;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(name="notify_owner")
	private WebElement notifyOwner;
	
	@FindBy(id="mobile")
	private WebElement mobileNumber;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]'][1]")
	private WebElement saveBtn;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement textHead;
	
	
	@FindBy(xpath = "//a[contains(.,'Organization Name')]/ancestor::table[@class='small'][2]//tr/td[1]/a")
	private List<WebElement> allOrganizationList;
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getDropDown1() {
		return dropDown1;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}
	
	public List<WebElement> getAllOrganizationList() 
	{
		return allOrganizationList;
	}
	
	public WebElement getSearchTxt()
	{
		return searchTxt;
	}

	public WebElement getSearchTbtn() 
	{
		return searchTbtn;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getNotifyOwner() {
		return notifyOwner;
	}

	public WebElement getMobileNumber() {
		return mobileNumber;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getTextHead() {
		return textHead;
	}

	public void addingInfoToContactPage(String name,String lastname,String num, WebDriver driver) throws Throwable
	{
		selectDropDownByVtext(dropDown1, "Mr.");
		firstName.sendKeys(name);
		lastName.sendKeys(lastname);
		organizationSelectTab.click();
		switchToWindow(driver, "Accounts&action");
		searchTxt.sendKeys("Jungle resort");
		searchTbtn.click();
		
for(WebElement allorglist:allOrganizationList)
{
	String allorg1 = allorglist.getText();
	
	if(allorg1.equals("Jungle resort.ltd350"))
	{
		allorglist.click();
		break;
	}
}	
		switchToWindow(driver, "Contacts&action");
		selectDropDown(leadSourceDropDown, 5);
		notifyOwner.click();
		mobileNumber.sendKeys(num);
		saveBtn.click();
		takeScreenShot(driver, "contactTestng");
	}	

}
