package com.crm.comcast.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewService {

	public  CreateNewService(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "servicename")
	private WebElement servicename;

	public WebElement getServicename() {
		return servicename;
	}
	
	@FindBy(xpath ="(//input[@type = 'submit'])[1]")
	private WebElement saveBtn;

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	/*@FindBy(id ="dtlview_Service Name")
	private WebElement printservicename;

	public WebElement getPrintservicename() {
		return printservicename;
	}*/
	
	public void createNewService(String Servicename)
	{
		servicename.sendKeys(Servicename);
		saveBtn.click();
	}
	
	
}
