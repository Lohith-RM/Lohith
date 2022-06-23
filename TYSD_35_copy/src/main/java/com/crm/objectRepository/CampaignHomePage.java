package com.crm.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;

public class CampaignHomePage extends WebDriverUtility {
	
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement NewCampaignCreateIcon;
	
	@FindBy(name="campaignname")
	private WebElement campaignName;
	
	@FindBy(xpath="//input[@name='assigntype'][2]")
	private WebElement assignedTo;
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement addProductIcon;
		
	
	@FindBy(name="search_text")
	private WebElement searchText;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchButn;
	
	@FindBy(xpath="//a[@id='1']")
	private WebElement productselect;
	
//	@FindBy(xpath = "//a[.='Product Name ']/../../..")
//	private List<WebElement> productlist;
//	
	@FindBy(xpath = "//input[@title='Save [Alt+S]'][1]")
	private WebElement saveButn;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement titleText;
	
//	@FindBy(xpath="//a[.='Campaign Name']/../../../..//a[@title='Campaigns']")
//	private List<WebElement> tablelist;
	
	
	public CampaignHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getNewCampaignCreateIcon() {
		return NewCampaignCreateIcon;
	}

	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getAssignedTo() {
		return assignedTo;
	}
	
	public WebElement getAddProductIcon() {
		return addProductIcon;
	}
	
	public WebElement getSearchText() {
		return searchText;
	}

	public WebElement getSearchButn() {
		return searchButn;
	}

	public WebElement getProductselect() {
		return productselect;
	}

	public WebElement getSaveButn() {
		return saveButn;
	}

public WebElement getTitleText() {
		return titleText;
	}

public void clickimg(String campname, WebDriver driver, String productname) throws Throwable
{
	NewCampaignCreateIcon.click();
	campaignName.sendKeys(campname);
	assignedTo.click();
	addProductIcon.click();
	switchToWindow(driver, "Products&action");
	searchText.sendKeys(productname);
	searchButn.click();
	Thread.sleep(4000);
	productselect.click();
	switchToWindow(driver, "Administrator - Campaigns");
	saveButn.click();
	takeScreenShot(driver, "campntestNG1");
	
}

//public void verification(String campname)
//{
//	for (WebElement list:tablelist)
//	{
//		String camplist = list.getText();
//		
//		
//		if(camplist.contains(campname))
//		{
//			System.out.println("Campagin is created and product is added");
//		}
//		else
//		{
//			System.out.println("Campagin is not created and product is not added");
//		}
//	}
}
	
	

