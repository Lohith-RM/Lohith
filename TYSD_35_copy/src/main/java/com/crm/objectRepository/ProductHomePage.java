package com.crm.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductHomePage {
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement newProductIcon;
	
//	@FindBy(xpath="//a[.='Product Name']/../../..")
//	private List<WebElement> productList;
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement productList;
	
	public ProductHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getNewProductIcon() {
		return newProductIcon;
	}
	
	public WebElement getProductList() {
		return productList;
	}

	public void clickOnPrdctIcon()
	{
		newProductIcon.click();
	}
	
//	public void verfication(String newProductName)
//	{
//		for(WebElement list:productList)
//		{
//			String table = list.getText();
//			
//			if(table.contains(newProductName))
//			{
//				System.out.println(newProductName);
//				System.out.println("Product is created");
//			}
//			else
//			{
//				System.out.println(newProductName);
//				System.out.println("product is not created");
//			}
//		}
//	}

}
