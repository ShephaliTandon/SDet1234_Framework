package com.crm.comcast.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericlib.WebDriverUtiles;

public class CreateNewPurchaseOrder extends WebDriverUtiles
{
	 WebDriver driver;
	public CreateNewPurchaseOrder(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = ("(//img[@title='Select'])[1]"))
	private WebElement vendorname;

	public WebElement getVendorname() {
		return vendorname;
	}
	
	@FindBy(linkText = "Mary")
	private WebElement selectvendor;
	
	public WebElement getSelectvendor() {
		return selectvendor;
	}

	@FindBy(name = "subject")
	private WebElement subjectname;

	public WebElement getSubjectname() {
		return subjectname;
	}
	
	//addproduct
	@FindBy(id ="searchIcon1")
	private WebElement addproduct;

	public WebElement getAddproduct() {
		return addproduct;
	}

	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement searchproduct;
	
	public WebElement getSearchproduct() {
		return searchproduct;
	}
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement search;

	public WebElement getSearch() {
		return search;
	}

	@FindBy(xpath = "//a[contains(@id,'popup_product')]")
	private WebElement clickonproduct;

	public WebElement getClickonproduct() {
		return clickonproduct;
	}
	
	//add Service
	@FindBy(xpath = "//input[@value='Add Service']")
	private WebElement addservice;

	public WebElement getAddservice() {
		return addservice;
	}
	
	@FindBy(xpath = "//img[@title='Services']")
	private WebElement clickonservice;
	
	public WebElement getClickonservice() {
		return clickonservice;
	}
	
	@FindBy(id ="search_txt")
	private WebElement searchservice;
	
	public WebElement getSearchservice() {
		return searchservice;
	}

	@FindBy(name = "search_field")
	private WebElement selectservicename;
	
	public WebElement getSelectservicename() {
		return selectservicename;
	}

	@FindBy(xpath = "//a[contains(@id,'popup_product')]")
	private WebElement clickservice;
	
	public WebElement getClickservice() {
		return clickservice;
	}
	
	@FindBy(xpath = "//td[contains(text(),'laptop')]")
	private WebElement servicename2;
	
	public WebElement getServicename2() {
		return servicename2;
	}
	
	@FindBy(xpath = "//input[contains(@id,'productName')]")
	private WebElement gettextproduct;

	public WebElement getGettextproduct() {
		return gettextproduct;
	}

	@FindBy(xpath = "(//input[contains(@id,'productName')])[1]")
	private WebElement gettextservice;

	public WebElement getGettextservice() {
		return gettextservice;
	}
	
	@FindBy(xpath = "(//input[contains(@id,'productName')])[2]")
	private WebElement gettextservice2;

	public WebElement getGettextservice2() {
		return gettextservice2;
	}

	@FindBy(xpath = "//input[@name='qty1']")
	private WebElement quantity;

	public WebElement getQuantity() {
		return quantity;
	}
	@FindBy(xpath = "//input[@name='qty2']")
	private WebElement quantity1;
	
	public WebElement getQuantity1() {
		return quantity1;
	}
	
	@FindBy(xpath = "//tr[@id='row2']/td[1]/img")
	private WebElement deleteservice;
	
	public WebElement getDeleteservice() {
		return deleteservice;
	}

	@FindBy(xpath="//a[@title='Move Downward']")
	private WebElement movedownward;
	
	public WebElement getMovedownward() {
		return movedownward;
	}

	@FindBy(xpath="//a[@title='Move Upward']")
	private WebElement moveupward;
	
	public WebElement getMoveupward() {
		return moveupward;
	}

	@FindBy(xpath ="(//input[@type = 'submit'])[2]")
	private WebElement saveBtn;

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	@FindBy(xpath = "//td[@class='dvInnerHeader']/../../following::tbody[8]/tr[3]/td")
	private WebElement Printproductname;

	public WebElement getPrintproductname() {
		return Printproductname;
	}	
	
	@FindBy(xpath="//td[@class='dvInnerHeader']/../../following::tbody[8]/following::tr[1]/td")
	private WebElement printservicename;

	public WebElement getPrintservicename() {
		return printservicename;
	}
	
	
	public void createNewPurchaseOrder(String Subjectname , String productname , String number) throws InterruptedException
	{
		vendorname.click();
		swicthToWindow(driver, "module=Vendor");
		selectvendor.click();
		swicthToWindow(driver, "module=PurchaseOrde");
		subjectname.sendKeys(Subjectname);
		
		//addproduct to purchase order
		addproduct.click();
		swicthToWindow(driver, "module=Product");
		Thread.sleep(8000);
		searchproduct.sendKeys(productname);
		search.click();
		WebElement cdf = clickonproduct;
		waitForElemnetContainsText(driver, cdf, productname);
		cdf.click();
		swicthToWindow(driver, "module=PurchaseOrde");
		quantity.sendKeys(number);
		saveBtn.click();
	}
	
	public void createNewPurchaseOrderWithService(String Subjectname , String productname , String number,String Servicename, String service) throws InterruptedException
	{
		vendorname.click();
		swicthToWindow(driver, "module=Vendor");
		selectvendor.click();
		swicthToWindow(driver, "module=PurchaseOrde");
		subjectname.sendKeys(Subjectname);
		
		//addproduct to purchase order
		addproduct.click();
		swicthToWindow(driver, "module=Product");
		Thread.sleep(8000);
		searchproduct.sendKeys(productname);
		search.click();
		WebElement cdf = clickonproduct;
		waitForElemnetContainsText(driver, cdf, productname);
		cdf.click();
		swicthToWindow(driver, "module=PurchaseOrde");
		quantity.sendKeys(number);
		
		//add service to pruchaseorder
		addservice.click();
		clickonservice.click();
		swicthToWindow(driver, "module=Services");
		searchservice.sendKeys(Servicename);
		selectservicename.sendKeys(service);
		search.click();
			
		WebElement cdf1 = clickservice;
		waitForElemnetContainsText(driver,cdf1, Servicename);
		cdf1.click();
			
		swicthToWindow(driver, "module=PurchaseOrde");
		quantity1.sendKeys(number);
		saveBtn.click();
		
	}
}
