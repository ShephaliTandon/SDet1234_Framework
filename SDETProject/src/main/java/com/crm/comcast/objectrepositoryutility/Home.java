package com.crm.comcast.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericlib.WebDriverUtiles;


/**
 * 
 * @author Deepak
 *
 */


public class Home  extends WebDriverUtiles{
	WebDriver driver;
	public Home(WebDriver driver) {     
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[contains(@src,'user.PNG')]")
	private WebElement adminstrationImg;
	
	@FindBy(linkText = "Sign Out")
    private WebElement signOutLnk;
	
	
	@FindBy(linkText = "Contacts")
    private WebElement contactLnk;
	
	@FindBy(linkText = "Organizations")
    private WebElement orgLnk;
	
	@FindBy(linkText = "Leads")
    private WebElement leadsLnk;
	

	public WebElement getContactLnk() {
		return contactLnk;
	}

	public WebElement getOrgLnk() {
		return orgLnk;
	}

	public WebElement getLeadsLnk() {
		return leadsLnk;
	}
	
	public void logout() {
		moveToExpectedElemnet(driver, adminstrationImg);
		signOutLnk.click();
	}
	
	
	//navigate to product 
		@FindBy(linkText = "Products")
		private WebElement navigateToProduct;


		public WebElement getNavigateToProduct()
		{
			return navigateToProduct;
		}
		public void productCreate(String name)
		{
			navigateToProduct.click();
		}
		@FindBy(xpath="//td[@class='tabSelected']")
		private WebElement clickonhome;
		
		public WebElement getClickonhome() {
			return clickonhome;
		}

		//navigate to purchaseorder
		@FindBy(linkText = "More")
		private WebElement navigate;

		public WebElement getNavigate() 
		{
			return navigate;
		}
		
		@FindBy(name = "Purchase Order")
		private WebElement clickonPurchaseOrder;
		
		public WebElement getClickonPurchaseOrder() 
		{
			return clickonPurchaseOrder;
		}
		public void purchaseorder()
		{
			navigate.click();
			clickonPurchaseOrder.click();
		}
		
		//navigate to servicepage
		@FindBy(linkText = "Services")
		private WebElement clickonservice;

		public WebElement getClickonservice() {
			return clickonservice;
		}

	
	
	
	
	}
