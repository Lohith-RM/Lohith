package com.crm.objectRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUtility;
import com.crm.comcast.genericutility.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class simple {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		
		ExcelUtility elib=new ExcelUtility();
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		
		int random = jlib.getRandomNumber();
		
		
		String URL = flib.getPropertyKeyValue("url");
		String UN = flib.getPropertyKeyValue("username");
		String PASS = flib.getPropertyKeyValue("password");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PASS);
		driver.findElement(By.id("submitButton")).click();
		
		
		driver.findElement(By.xpath("//a[.='Organizations'][1]")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		 WebElement e = driver.findElement(By.name("accounttype"));
		
		String e1 = e.getText();
		
		System.out.println(e1);
		
		
		
	}

}
