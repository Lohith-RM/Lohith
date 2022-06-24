package com.crm.vtiger.testcases.TestNg;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUtility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.objectRepository.CreateNewOrganizationPage;
import com.crm.objectRepository.LoginPage;
import com.crm.objectRepository.OrganizationHomePage;
import com.crm.objectRepository.VtigerHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;


@Listeners(com.crm.comcast.genericutility.ItestListenerImplmnt.class)
public class CreateOrganizationTestNGTest extends BaseClass{
	
	//@Test(groups = "smokeTest")
	@Test
	public void createOrganizationTest() throws Throwable
	{
		int random = jlib.getRandomNumber(); // getting Random number
		
		//fetching test data from excel sheet
		String Orgname = elib.readDataFromExcel("Sheet1", 1, 5)+random;
		String industrytype = elib.readDataFromExcel("Sheet2", 6, 0);
		String accountType = elib.readDataFromExcel("Sheet2", 4, 1);
		
		//opening homepage and click on organization module
		VtigerHomePage homepage = new VtigerHomePage(driver);
		homepage.getOrganizationsTab().click();
		
		//Assert.fail();
		
		//opening product homepage and click on new organization img
		OrganizationHomePage orghp = new OrganizationHomePage(driver);
		orghp.getCreateNewOrgButn().click();
		
		//inserting new organization information and save
		CreateNewOrganizationPage info = new CreateNewOrganizationPage(driver);
		info.CreateNewOrganizationPage(Orgname, industrytype, accountType, driver);
		
		//fetching title of new created organization name
		String text = info.getOrganizername().getText();
		  
		//verification of new organization created using soft assert
		SoftAssert a = new SoftAssert();
		a.assertTrue(text.contains(Orgname));
		System.out.println("New organization is Created"); //soft assert for validation
		a.assertAll();
		
	}
}
		
		
		
		
//String title = text.getText();
//
//if(title.contains(Orgname))
//{
//	System.out.println("New organization is Created");
//}
//else
//{
//	System.out.println("New organization is not created");
//}	
		
		
		
		
		
		
		
		
		
//		String website = elib.readDataFromExcel("Sheet1", 5, 3);
//		String pn = elib.readDataFromExcel("Sheet1", 1, 6);
//		String Tickersymbol = elib.readDataFromExcel("Sheet1", 8, 0);
//		String Billingadd = elib.readDataFromExcel("Sheet1", 8, 1);
//		String pobox = elib.readDataFromExcel("Sheet1", 8, 2);
//		String city = elib.readDataFromExcel("Sheet1", 8, 3);
//		String state = elib.readDataFromExcel("Sheet1", 8, 4);
//		String postalcode = elib.readDataFromExcel("Sheet1", 8, 5);
//		String country = elib.readDataFromExcel("Sheet1", 8, 6);
//		String description = elib.readDataFromExcel("Sheet1", 11, 0);

		



