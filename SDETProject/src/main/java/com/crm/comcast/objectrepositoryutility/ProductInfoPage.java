package com.crm.comcast.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	
	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//click on new product
	
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement newproductclick;

	public WebElement getNewproductclick() {
		return newproductclick;
	}
	
	public void newproductclick()
	{
		newproductclick.click();
	}
}
