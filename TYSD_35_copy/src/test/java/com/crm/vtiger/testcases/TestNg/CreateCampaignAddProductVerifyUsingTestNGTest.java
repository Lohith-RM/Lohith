package com.crm.vtiger.testcases.TestNg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUtility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.WebDriverUtility;
import com.crm.objectRepository.CampaignHomePage;
import com.crm.objectRepository.LoginPage;
import com.crm.objectRepository.VtigerHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;


//@Listeners(com.crm.comcast.genericutility.ItestListenerImplmnt.class)
public class CreateCampaignAddProductVerifyUsingTestNGTest extends BaseClass {
	
	
	//@Test(groups = "regressionTest")
	@Test(retryAnalyzer = com.crm.comcast.genericutility.RetryAnalyser.class)
	//@Test
	public void CreateCampaignAddProductVerifyTest() throws Throwable
	
	
	{
		int random = jlib.getRandomNumber(); //random number
		//fetching data from excel sheet
		String productname = elib.readDataFromExcel("Sheet1", 5, 1); //extracting product name data
		System.out.println(productname);
		String Campaignname = elib.readDataFromExcel("Sheet1", 5, 2)+random; //extracting campaign name data
		System.out.println(Campaignname);
				
          // Homepage displayed and clik on campaign link using mouseovering
		VtigerHomePage homepage = new VtigerHomePage(driver);
				
				homepage.mouseoverOnElement(driver); //mouseover
		
				homepage.getCampaignsLink().click(); //campaign link
				
               //Campaignhome page displayed				
				CampaignHomePage campaignhomepage = new CampaignHomePage(driver);
				
				//Assert.fail();
				//entering name, assigned type and adding product and save
				campaignhomepage.clickimg(Campaignname, driver, productname);
				
				String actualname = campaignhomepage.getTitleText().getText();
				homepage.getCampaignsLink().click(); //campaign link
				
				
				//validation using Assert
				Assert.assertTrue(actualname.contains(Campaignname));
				System.out.println("Campagin is created and product is added");
				
			
				
				
				
				
//				WebElement list = campaignhomepage.getTitleText();
//				
//				String camplist = list.getText();
//					
//					if(camplist.contains(Campaignname))
//					{
//						System.out.println("Campagin is created and product is added");
//					}
//					else
//					{
//						System.out.println("Campagin is not created and product is not added");
//					}
	}
				    	
	}



