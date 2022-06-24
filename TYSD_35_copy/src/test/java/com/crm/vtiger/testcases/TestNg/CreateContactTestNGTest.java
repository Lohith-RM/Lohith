package com.crm.vtiger.testcases.TestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUtility;
import com.crm.comcast.genericutility.Ipathconstants;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.WebDriverUtility;
import com.crm.objectRepository.ContactHomePage;
import com.crm.objectRepository.ContactInfoPage;
import com.crm.objectRepository.LoginPage;
import com.crm.objectRepository.VtigerHomePage;


@Listeners(com.crm.comcast.genericutility.ItestListenerImplmnt.class)
public class CreateContactTestNGTest extends BaseClass {
	
	@Test()
	public void createContactTest() throws Throwable
	{
		int random = jlib.getRandomNumber();	//getting Random nymber	
		
		//extract test data from excel sheet
		String Fname = elib.readDataFromExcel("Sheet1", 1, 3);
		String Lname = elib.readDataFromExcel("Sheet1", 1, 4)+random;
		String mobileno = elib.readDataFromExcel("Sheet1", 1, 6);
		
		//opening homepage and click on contact module
		VtigerHomePage homepage = new VtigerHomePage(driver);
		homepage.getContactsTab().click();
		
		//opening contact page and click on newcontact img
		ContactHomePage cnt = new ContactHomePage(driver);
		cnt.clickonnewimg();
		
		//inserting new contact information and save
		ContactInfoPage info = new ContactInfoPage(driver);
		info.addingInfoToContactPage(Fname, Lname, mobileno, driver);
		
		//fetching title of new created contact
		String actualname = info.getTextHead().getText();
		
		//verification of new contact created using assert 
		Assert.assertTrue(actualname.contains(Fname));
		System.out.println("New Contact is Created");
		
		
		
		
//		WebElement text = info.getTextHead();
//		
//		String title = text.getText();
//		if(title.contains(Fname))
//		{
//			System.out.println("New Contact is Created");
//		}
//		else
//		{
//			System.out.println("New contact is not created");
//		}
//		
	}
}

