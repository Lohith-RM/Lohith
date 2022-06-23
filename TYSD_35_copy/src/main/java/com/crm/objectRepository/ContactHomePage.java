package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactHomePage {
	
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createcontctimg;
	
	public ContactHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreatecontctimg() {
		return createcontctimg;
	}
	
	public void clickonnewimg()
	{
		createcontctimg.click();
	}

}
