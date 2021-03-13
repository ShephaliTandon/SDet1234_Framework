package com.crm.comcast.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProduct {

	public CreateNewProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "productname")
	private WebElement productName;

	public WebElement getProductName() {
		return productName;
	}
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	@FindBy(id = "dtlview_Product Name")
	private WebElement printproductname;
	
	public WebElement getPrintproductname() {
		return printproductname;
	}

	public void createNewProduct(String productname)
	{
		productName.sendKeys(productname);
		saveBtn.click();
		printproductname.getText();
	}
}
