package com.crm.comcast.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderInfoPage {

	public PurchaseOrderInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Purchase Order...']")
	private WebElement CreateNewPurchaseOrder;

	public WebElement getCreateNewPurchaseOrder()
	{
		return CreateNewPurchaseOrder;
	}
	
	public void CreateNewPurchaseOrder()
	{
		CreateNewPurchaseOrder.click();
	}
}
