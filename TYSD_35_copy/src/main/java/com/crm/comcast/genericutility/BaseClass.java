package com.crm.comcast.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.objectRepository.LoginPage;
import com.crm.objectRepository.VtigerHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver sdriver;
	public WebDriver driver;
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public DataBaseUtility dlib = new DataBaseUtility();
	
	
	/**
	 * Connecting to data base
	 */
	
	//@BeforeSuite(groups = {"smokeTest", "regressionTest"})
	@BeforeSuite
	public void connectToDataBase()
	{
		dlib.dataBaseConnection();
	}
//=====================================================================================================
	/**
	 * Launch the Browser
	 * @throws Throwable 
	 */
	
	
	//@Parameters("BROWSER")
	//@BeforeClass(groups = {"smokeTest", "regressionTest"})
	@BeforeClass
	public void launchTheBrowser() throws Throwable
	{
		String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");
		//String BROWSER = flib.getPropertyKeyValue("browser");
		//String URL = flib.getPropertyKeyValue("url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			
			//System.setProperty(Ipathconstants.chromeKey, Ipathconstants.chromePath);
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
			
		{
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}
		
		else
		{
			 driver = new ChromeDriver();
		}
		
		System.out.println("Browser launched");
		
		sdriver=driver;
		//maximize the window
		driver.manage().window().maximize();
		
		// enter the URL of the Application
		driver.get(URL);
		
		//implicitly wait
		wlib.waitForPageToLoad(driver);
		
		System.out.println("Website launched successfully");
//====================================================================================================================		
		/**
		 * Login to Application
		 */
	}
		
		//@BeforeMethod(groups = {"smokeTest", "regressionTest"})
		@BeforeMethod
		public void loginToAppln() throws Throwable
		{
			String USERNAME = flib.getPropertyKeyValue("username"); //fetching username
			String PASSWORD = flib.getPropertyKeyValue("password"); // fetching password
			
			LoginPage login = new LoginPage(driver);
			login.loginToHomePage(USERNAME, PASSWORD); //login into application
			
			System.out.println("login to application successfull");
			
		}
//==========================================================================================================================		
		/**
		 * logout from application
		 * @throws InterruptedException 
		 */
		
		//@AfterMethod(groups = {"smokeTest", "regressionTest"})
		@AfterMethod
		public void logoutFromAppln() throws InterruptedException
		
		{
			VtigerHomePage hp = new VtigerHomePage(driver);
			
			hp.logout(driver);
			
			System.out.println("logout from application successfully");
		}
//===========================================================================================================================		
		/**
		 * closing Browser
		 */
		
		//@AfterClass(groups = {"smokeTest", "regressionTest"})
		@AfterClass
		public void closeBrowser()
		{
			driver.quit();
			
			System.out.println("browser closed");
		}
//============================================================================================================================		
		/**
		 * closing DataBase
		 */
		
		//@AfterSuite(groups = {"smokeTest", "regressionTest"})
		@AfterSuite
		public void closeDataBase()
		{
			dlib.dataBaseClose();
		}
}


	

