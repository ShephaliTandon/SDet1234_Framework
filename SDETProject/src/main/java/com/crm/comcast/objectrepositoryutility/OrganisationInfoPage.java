package com.crm.comcast.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage {
	public OrganisationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//click to new organisation
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement organisationcreate;

	public WebElement getOrganisationcreate() 
	{
		return organisationcreate;
	}
	
	public void organisationcreate()
	{
		organisationcreate.click();
	}
	
}
