package com.crm.comcast.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServiceInfopage {

	public ServiceInfopage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//img[@title='Create Service...']")
	private WebElement createnewservice;

	public WebElement getCreatenewservice() {
		return createnewservice;
	}
	
}
