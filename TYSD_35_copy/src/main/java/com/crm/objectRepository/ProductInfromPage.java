package com.crm.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;

public class ProductInfromPage extends WebDriverUtility {
	
	@FindBy(name="productname")
	private WebElement productName;
	
	@FindBy(name="discontinued")
	private WebElement productActive;
	
	@FindBy(name="productcategory")
	private WebElement prodcutDropDown;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement VendorNameAddIcon;
	
	@FindBy(name="search_text")
	private WebElement searchTxt;
	
	@FindBy(name="search")
	private WebElement searchButn;
	
	@FindBy(xpath = "//a[.='Akshay']")
	private WebElement Selectvendor;
	
	//@FindBy(xpath="//a[@class='listFormHeaderLinks']/../../..")
	//private List<WebElement> vendorList;
	
	//@FindBy(xpath = "//a[contains(.,'Organization Name')]/ancestor::table[@class='small'][2]//tr/td[1]/a")
	//private List<WebElement> allOrganizationList;
	
	@FindBy(name = "manufacturer")
	private WebElement ManufatrDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]'][1]")
	private WebElement saveButn;
	
	
	public ProductInfromPage(WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getProductName() {
		return productName;
	}


	public WebElement getProductActive() {
		return productActive;
	}


	public WebElement getProdcutDropDown() {
		return prodcutDropDown;
	}


	public WebElement getVendorNameAddIcon() {
		return VendorNameAddIcon;
	}


	public WebElement getSearchTxt() {
		return searchTxt;
	}


	public WebElement getSearchButn() {
		return searchButn;
	}


	//public List<WebElement> getVendorList() {
		//return vendorList;
	//}


	public WebElement getManufatrDropDown() {
		return ManufatrDropDown;
	}


	public WebElement getSaveButn() {
		return saveButn;
	}

	public void inputProductInfo(String prdtname, String childwindowtitle, WebDriver driver, String vendorname, String parentwindwtitle, 
			int dropdownindex, String dropdownvisibletxt, String ScreenshotName) throws Throwable
	
	{
		productName.sendKeys(prdtname);
		selectDropDown(prodcutDropDown, dropdownindex);
		VendorNameAddIcon.click();
		switchToWindow(driver, childwindowtitle);
		
		searchTxt.sendKeys(vendorname);
		
		searchButn.click();
		
		Selectvendor.click();
		
//		for(WebElement list:vendorList)
//		{
//			String t1 = list.getText();
//			
//			if(t1.equals("Akshay"))
//			{
//				list.click();
//				break;
//			}
//		}
		
		switchToWindow(driver, parentwindwtitle);
		selectDropDownByVtext(ManufatrDropDown, dropdownvisibletxt );
		saveButn.click();
		takeScreenShot(driver, ScreenshotName);
		
		
		
	}

}
