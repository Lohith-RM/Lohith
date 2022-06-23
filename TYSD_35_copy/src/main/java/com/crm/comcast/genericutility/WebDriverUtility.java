package com.crm.comcast.genericutility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;



/**
 * contains all reusable Actions of Webdriver 
 * @author Admin
 *
 */

public class WebDriverUtility {
	
	/**
	 * it's an implicitly wait  Always wait for Element in DOM document & release the control if element available 
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	 * it will wait for javascript elements
	 * @param driver
	 */
	public void waitForPageToLoadJSElement(WebDriver driver)
	
	{
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}
	
	/**
	 * it will check for the element in the GUI for polling time of 500ms
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	
	{
		WebDriverWait wait = new WebDriverWait(driver, 10 );
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	/**
	 * it will check the title in the GUI for polling time of 500ms
	 * @param driver
	 * @param title
	 */
	public void waitForTitleContains(WebDriver driver, String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	
	/**
	 * here we can change the polling time from default 500ms to any polling time 
	 * @param driver
	 * @param pollingTime
	 * @param element
	 */
	public void waitForElementToCustom(WebDriver driver, int pollingTime, WebElement element)
	{
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * here we are giving custom timeout
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException
	{
		int count=0;
		
		while(count<10)
		{
			try 
			{
				element.click();
			}
			catch(Exception e) 
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
		
		/**
		 * used to Switch to Any Window based on Window Title
		 */
		
		public void switchToWindow(WebDriver driver, String partialWindow)
		{
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it = set.iterator();
			
			while(it.hasNext())
			{
				String wTle=it.next();
				driver.switchTo().window(wTle);
				String currentWindow = driver.getTitle();
				
				if(currentWindow.contains(partialWindow))
				{
					break;
				}
			}
			
		}
	
		
		/**
		 * used to Switch to Frame Window based on index
		 * @param driver
		 * @param index
		 */

		public void switchToFrame(WebDriver driver, int index)
		{
			driver.switchTo().frame(index);
		}
		
		/**
		 * used to Switch to Frame Window based on id or name attribute
		 * @param driver
		 * @param id_attribute
		 */
		public void switchToFrame(WebDriver driver, String id_attribute)
		{
			driver.switchTo().frame(id_attribute);
		}
		
		/**
		 * switch from one frame to another by using absolute_path
		 * @param driver
		 * @param element
		 */
		public void switchToFrame(WebDriver driver, WebElement element)
		{
			driver.switchTo().frame(element);
		}
		
		/**
		 * its used to switch back from one child to parent frame
		 * @param driver
		 */
		public void switchBackToParentFrame(WebDriver driver)
		{
			driver.switchTo().parentFrame();
		}
		
		/**
		 * its used to switch back to main page
		 * @param driver
		 */
		public void switchbackToMainPage(WebDriver driver)
		{
			driver.switchTo().defaultContent();
		}
		
		/**
		 * used to Switch to Alert Window & click on OK button
		 * @param driver
		 */
		public void switchToAlertPopupAndAccept(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		
		/**
		 * used to Switch to Alert Window & click on Cancel button
		 * @param driver
		 */
		public void switchToAlertPopupAndDismiss(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		
		/**
		 * used to select the value from the dropDwon  based on index
		 * @param element
		 * @param index
		 */
		public void selectDropDown(WebElement element, int index)
		{
			Select select = new Select(element);
			select.selectByIndex(index);
		}
		
		/**
		 * it is used to switch to select dropdown by using value
		 * @param element
		 * @param value
		 */
		public void selectdropDown(WebElement element, String value)
		{
			Select select = new Select(element);
			select.selectByValue(value);
			
		}
		
		/**
		 * used to select the value from the dropDwon  based on value / option available in GUI
		 * @param element
		 * @param visible_text
		 */
		public void selectDropDownByVtext(WebElement element, String visible_text)
		{
			Select select = new Select(element);
			select.selectByVisibleText(visible_text);
		}
		
		/**
		 * used to place mouse cursor on specified element
		 * @param driver
		 * @param element
		 */
		public void mouseOverAnElement(WebDriver driver , WebElement element)
		{
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
		}
		
		/**
		 * used to right click on specified element
		 * @param driver
		 * @param element
		 */
		public void rightClickOnElement(WebDriver driver, WebElement element)
		{
			Actions action = new Actions(driver);
			action.contextClick(element).perform();
		}
		
		/**
		 * pass enter Key appertain in to Browser
		 * @param driver
		 */
		public void clickOnEnetrButton(WebDriver driver)
		{
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).perform();
		}
		
		/**
		 * it is used to take screenshot
		 * @param driver
		 * @param screenShotname
		 * @throws IOException
		 */
		public void takeScreenShot(WebDriver driver, String screenShotname) throws Throwable
		{
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
			File dest = new File("./screenShots/"+screenShotname+".PNG");
			Files.copy(src, dest);
		}
		
		/**
		 * it is used to perform scrollBar actions
		 * @param driver
		 */
		public void scrollBarAction(WebDriver driver)
		{
			JavascriptExecutor javascript=(JavascriptExecutor) driver;
			javascript.executeScript("window.scrollBy(0,500)");
			
		}
		
		/**
		 * 
		 * @param driver
		 * @param javaScript
		 */
		public void executeJavaScript(WebDriver driver , String javaScript) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeAsyncScript(javaScript, null);
		}

}


