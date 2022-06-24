package com.crm.vtiger.testcases.TestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUtility;
import com.crm.comcast.genericutility.Ipathconstants;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.WebDriverUtility;
import com.crm.objectRepository.LoginPage;
import com.crm.objectRepository.ProductHomePage;
import com.crm.objectRepository.ProductInfromPage;
import com.crm.objectRepository.VtigerHomePage;


@Listeners(com.crm.comcast.genericutility.ItestListenerImplmnt.class)
public class CreateNewProductWithVendorTestNGTest extends BaseClass {

	@Test()
	
	public void CreateNewProductWithVendorTest() throws Throwable
	{
		int random = jlib.getRandomNumber(); //getting Random number
		
		//fetching test data from excel sheet
		String productName = elib.readDataFromExcel("Sheet1", 5, 1)+random;
		String childWndwTitle = elib.readDataFromExcel("Sheet1", 11, 1);
		String parentWndwTitle = elib.readDataFromExcel("Sheet1", 11, 2);
		String vendorName = elib.readDataFromExcel("Sheet1", 5, 0);
		String dropDownVisibletxt = elib.readDataFromExcel("Sheet1", 11, 3);
		String pngName = elib.readDataFromExcel("Sheet1", 11, 4)+random;
		
		//opening homepage and click on product module
		VtigerHomePage homepage = new VtigerHomePage(driver);
		homepage.getProductsTab().click();
		
		//opening product homepage and click on new product img
		ProductHomePage prdthomepage = new ProductHomePage(driver);
		prdthomepage.clickOnPrdctIcon();
		
		//inserting new contact information and adding vendorname and save
		ProductInfromPage infopage = new ProductInfromPage(driver);
		infopage.inputProductInfo(productName, parentWndwTitle, driver, vendorName, childWndwTitle, 2, dropDownVisibletxt, pngName);
		
		//clicking on product module
		//homepage.getProductsTab().click();
		
		//fetching title of new created product name
		wlib.waitForPageToLoad(driver);
		String list = prdthomepage.getProductList().getText();
		 
		//verification of new product created using soft assert 
		SoftAssert a = new SoftAssert();
		a.assertTrue(list.contains(productName));
		System.out.println("New Product is Created and Vendor is Added");
		a.assertAll();
		
		
		
//		String title = list.getText();
//		if(title.contains(productName))
//		{
//			System.out.println("New Product is Created and Vendor is Added");
//		}
//		else
//		{
//			System.out.println("New Prodcut is not Created and Vendor is not Added");
//		}
		
		//prdthomepage.verfication(productName);
		
	}

}
