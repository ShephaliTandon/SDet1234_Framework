package com.crm.autodesktestscriptassignment;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericlib.BaseClass;
import com.crm.comcast.genericlib.ExcelUtility;
import com.crm.comcast.genericlib.FileUtility;
import com.crm.comcast.genericlib.IConstant;
import com.crm.comcast.objectrepositoryutility.CreateNewProduct;
import com.crm.comcast.objectrepositoryutility.CreateNewPurchaseOrder;
import com.crm.comcast.objectrepositoryutility.CreateNewService;
import com.crm.comcast.objectrepositoryutility.Home;
import com.crm.comcast.objectrepositoryutility.ProductInfoPage;
import com.crm.comcast.objectrepositoryutility.PurchaseOrderInfoPage;
import com.crm.comcast.objectrepositoryutility.ServiceInfopage;
/**
 * @author SHEPHALI
 */
@Listeners(com.crm.comcast.genericlib.ListnerIMP.class)
public class CreatePurchaseOrderTest extends BaseClass {
	
	@Test(priority =1,retryAnalyzer = com.crm.comcast.genericlib.RetryAnalyzer.class)
	public void CreatePurchaseorderWithItemandAddProduct() throws Throwable
	{	
		/*read test script data */
		String productname = eLib.getExcelData("Sheet2", 1, 2)+jLib.generateRandomNum();
		String Subjectname = eLib.getExcelData("Sheet2", 1, 3)+jLib.generateRandomNum();
		String number = eLib.getExcelData("Sheet2", 2, 3);
		
		/* step1 navigate to product order */
			Home home = new Home(driver);
			home.getNavigateToProduct().click();
			new ProductInfoPage(driver).newproductclick();
			
		/* step2 details of product order in create new product*/
			CreateNewProduct cnp = new CreateNewProduct(driver);
			cnp.getProductName().sendKeys(productname);
			cnp.getSaveBtn().click();
		
		/* step3 navigate to purchaseorder*/
			home.getNavigate().click();
			home.getClickonPurchaseOrder().click();
			PurchaseOrderInfoPage pip = new PurchaseOrderInfoPage(driver);
			pip.getCreateNewPurchaseOrder().click();
			
		/* step4 details of purchase order to create new purchase order*/
			CreateNewPurchaseOrder cpo = new CreateNewPurchaseOrder(driver);
			cpo.getVendorname().click();
			wLib.swicthToWindow(driver, "module=Vendor");
			cpo.getSelectvendor().click();
			wLib.swicthToWindow(driver, "module=PurchaseOrde");
			cpo.getSubjectname().sendKeys(Subjectname);
			
			cpo.getAddproduct().click();
			wLib.swicthToWindow(driver, "module=Product");
			
			Thread.sleep(8000);
			cpo.getSearchproduct().sendKeys(productname);
			cpo.getSearch().click();
			WebElement cdf = cpo.getClickonproduct();
			wLib.waitForElemnetContainsText(driver, cdf, productname);
			cdf.click();
			wLib.swicthToWindow(driver, "module=PurchaseOrde");
			cpo.getQuantity().sendKeys(number);
			cpo.getSaveBtn().click();
			String actProductname = cpo.getPrintproductname().getText();
		
	   /* step5 validate */
			boolean flag = actProductname.contains(productname);
			Assert.assertTrue(flag);
	}
	
	@Test(priority =2)
	public void CreatePurchaseOrderWithItemAndCreateAddService() throws Throwable
	{
		/*read test script data */
		String productname = eLib.getExcelData("Sheet2", 1, 2)+jLib.generateRandomNum();
		String servicename = eLib.getExcelData("Sheet2", 6, 2)+jLib.generateRandomNum();
		String subjectname = eLib.getExcelData("Sheet2", 6, 3)+jLib.generateRandomNum();
		String number = eLib.getExcelData("Sheet2", 7, 3);
		String service = eLib.getExcelData("Sheet2", 7, 2);
		
		/* step1 navigate to product order */
			Home home = new Home(driver);
			home.getNavigateToProduct().click();
			new ProductInfoPage(driver).newproductclick();
		
		/* step2 details of product order in create new product */
			CreateNewProduct cnp = new CreateNewProduct(driver);
			cnp.getProductName().sendKeys(productname);
			cnp.getSaveBtn().click();
	
		/* step3 navigate to Servicepage */
			home.getNavigate().click();
			home.getClickonservice().click();
			ServiceInfopage sip =new ServiceInfopage(driver);
			sip.getCreatenewservice().click();
				
		/* step4 detail of service in create service page */
			CreateNewService cns = new CreateNewService(driver);
			cns.getServicename().sendKeys(servicename);
			cns.getSaveBtn().click();

		/* step 5 navigate to purchaseorder */
			home.getNavigate().click();
			home.getClickonPurchaseOrder().click();
			PurchaseOrderInfoPage pip = new PurchaseOrderInfoPage(driver);
			pip.getCreateNewPurchaseOrder().click();
			
		/* step6 details of purchase order to create new purchase order */
			CreateNewPurchaseOrder cpo = new CreateNewPurchaseOrder(driver);
			cpo.getVendorname().click();
			wLib.swicthToWindow(driver, "module=Vendor");
			cpo.getSelectvendor().click();
			wLib.swicthToWindow(driver, "module=PurchaseOrde");
			cpo.getSubjectname().sendKeys(subjectname);
			cpo.getAddproduct().click();
			wLib.swicthToWindow(driver, "module=Product");
			Thread.sleep(8000);
			cpo.getSearchproduct().sendKeys(productname);
			cpo.getSearch().click();
			
			WebElement cdf = cpo.getClickonproduct();
			wLib.waitForElemnetContainsText(driver, cdf, productname);
			cdf.click();
			
			wLib.swicthToWindow(driver, "module=PurchaseOrde");
			cpo.getQuantity().sendKeys(number);
			
		//add service
			cpo.getAddservice().click();
			cpo.getClickonservice().click();
			wLib.swicthToWindow(driver, "module=Services");
			cpo.getSearchservice().sendKeys(servicename);
			cpo.getSelectservicename().sendKeys(service);
			cpo.getSearch().click();
				
			WebElement cdf1 = cpo.getClickservice();
			wLib.waitForElemnetContainsText(driver,cdf1,servicename);
			cdf1.click();
				
			wLib.swicthToWindow(driver, "module=PurchaseOrde");
			cpo.getQuantity1().sendKeys(number);
			cpo.getSaveBtn().click();
			String actservicename = cpo.getPrintservicename().getText();
				
	  /* step7 validate */
			boolean flag = actservicename.contains(servicename);		  		  
			Assert.assertTrue(flag);
	}
		
	@Test(priority =3)
	public void CreatePurchaseOrderwithItemAddExisitingService() throws Throwable
	{
		/*read test script data */
		String servicename = eLib.getExcelData("Sheet2", 6, 2)+jLib.generateRandomNum();
		String subjectname = eLib.getExcelData("Sheet2", 6, 3)+jLib.generateRandomNum();
		String number = eLib.getExcelData("Sheet2", 7, 3);
		String service = eLib.getExcelData("Sheet2", 7, 2);
		
		/* step1 navigate to Servicepage */
			Home home = new Home(driver);
			home.getNavigate().click();
			home.getClickonservice().click();
			ServiceInfopage sip =new ServiceInfopage(driver);
			sip.getCreatenewservice().click();
			
		/* step2 detail of service in create service page */
			CreateNewService cns = new CreateNewService(driver);
			cns.getServicename().sendKeys(servicename);
			cns.getSaveBtn().click();
		
		/* step3 navigate to purchaseorder */
			home.getNavigate().click();
			home.getClickonPurchaseOrder().click();
			PurchaseOrderInfoPage pip = new PurchaseOrderInfoPage(driver);
			pip.getCreateNewPurchaseOrder().click();
		
		/* step4 details of purchase order in create new purchase order*/
			CreateNewPurchaseOrder cpo = new CreateNewPurchaseOrder(driver);
			cpo.getVendorname().click();
			String partailWindowTitle = driver.getWindowHandle();
			wLib.swicthToWindow(driver, "module=Vendor");
			cpo.getSelectvendor().click();
			wLib.swicthToWindow(driver, "module=PurchaseOrde");
			cpo.getSubjectname().sendKeys(subjectname);
			
			cpo.getAddproduct().click();
			wLib.swicthToWindow(driver, "module=Product");
			cpo.getClickonproduct().click();
			wLib.swicthToWindow(driver, "module=PurchaseOrde");
			cpo.getQuantity().sendKeys(number);
			cpo.getAddservice().click();
			cpo.getClickonservice().click();
			wLib.swicthToWindow(driver, "module=Services");
			cpo.getSearchservice().sendKeys(servicename);
			cpo.getSelectservicename().sendKeys(service);
			cpo.getSearch().click();
			
			WebElement cdf = cpo.getClickservice();
			wLib.waitForElemnetContainsText(driver,cdf,servicename);
			cdf.click();
			
			wLib.swicthToWindow(driver, "module=PurchaseOrde");
			cpo.getQuantity1().sendKeys(number);
			cpo.getSaveBtn().click();
			String actservicename =cpo.getPrintservicename().getText();
			
		/* step5 validate */
			boolean flag = actservicename.contains(servicename);
			Assert.assertTrue(flag);
	}
	
	@Test(priority =4)
	public void CreatePurchaseorderwithItemandDelete() throws Throwable
	{
		/*read test script data */
		String servicename = eLib.getExcelData("Sheet2", 6, 2)+jLib.generateRandomNum();
		String subjectname = eLib.getExcelData("Sheet2", 6, 3)+jLib.generateRandomNum();
		String number = eLib.getExcelData("Sheet2", 7, 3);
		String service = eLib.getExcelData("Sheet2", 7, 2);
		
		//homepage
			Home home = new Home(driver);
			
		/* step1 navigate to service */
			home.getNavigate().click();
			home.getClickonservice().click();
			ServiceInfopage sip =new ServiceInfopage(driver);
			sip.getCreatenewservice().click();
				
		/* step2 detail of service in create new service */
			CreateNewService cns = new CreateNewService(driver);
			cns.getServicename().sendKeys(servicename);
			cns.getSaveBtn().click();
			
		/* step3 navigate to purchaseorder */
			home.getNavigate().click();
			home.getClickonPurchaseOrder().click();
			PurchaseOrderInfoPage pip = new PurchaseOrderInfoPage(driver);
			pip.getCreateNewPurchaseOrder().click();
				
		/* step4 detail of purchaseorder in create new purchase order */
			CreateNewPurchaseOrder cpo = new CreateNewPurchaseOrder(driver);
			
		//add service in create new purchase order
			cpo.getAddservice().click();
			cpo.getClickonservice().click();
			//String partailWindowTitle = driver.getWindowHandle();
			wLib.swicthToWindow(driver, "module=Services");
			cpo.getSearchservice().sendKeys(servicename);
			cpo.getSelectservicename().sendKeys(service);
			cpo.getSearch().click();
			
			WebElement cdf = cpo.getClickservice();
			wLib.waitForElemnetContainsText(driver,cdf,servicename);
			cdf.click();
			
			wLib.swicthToWindow(driver, "module=PurchaseOrder");
			
		/* step5 validate */
			cpo.getDeleteservice().click();	
			cpo.getSaveBtn().click();
			wLib.alertOK(driver);		
	}
	
	@Test(priority =5)
	public void CreatePOwithItemandclickonUpwardsymbol() throws Throwable
	{
		/*read test script data */
		String servicename = eLib.getExcelData("Sheet2", 6, 2)+jLib.generateRandomNum();
		String subjectname = eLib.getExcelData("Sheet2", 6, 3)+jLib.generateRandomNum();
		String number = eLib.getExcelData("Sheet2", 7, 3);
		String service = eLib.getExcelData("Sheet2", 7, 2);
		
		//homepage
			Home home = new Home(driver);
		/*step1 navigate to service*/
			home.getNavigate().click();
			home.getClickonservice().click();
			ServiceInfopage sip =new ServiceInfopage(driver);
			sip.getCreatenewservice().click();
				
		/*step2 add detail of service */
			CreateNewService cns = new CreateNewService(driver);
			cns.getServicename().sendKeys(servicename);
			cns.getSaveBtn().click();
	
		/*step3 navigate to purchaseorder*/
			home.getNavigate().click();
			home.getClickonPurchaseOrder().click();
			PurchaseOrderInfoPage pip = new PurchaseOrderInfoPage(driver);
			pip.getCreateNewPurchaseOrder().click();
			
		/* step4 add detail of purchaseorder in create purchase order */
			CreateNewPurchaseOrder cpo = new CreateNewPurchaseOrder(driver);
			cpo.getVendorname().click();
			String partailWindowTitle = driver.getWindowHandle();
			wLib.swicthToWindow(driver, "module=Vendor");
			cpo.getSelectvendor().click();
			wLib.swicthToWindow(driver, "module=PurchaseOrde");
			cpo.getSubjectname().sendKeys(subjectname);
			
		/* step5 add service to purchase order */
			cpo.getAddproduct().click();
			wLib.swicthToWindow(driver, "module=Product");
			cpo.getClickonproduct().click();
			wLib.swicthToWindow(driver, "module=PurchaseOrde");
			cpo.getQuantity().sendKeys(number);
			cpo.getAddservice().click();
			cpo.getClickonservice().click();
			wLib.swicthToWindow(driver, "module=Services");
			cpo.getSearchservice().sendKeys(servicename);
			cpo.getSelectservicename().sendKeys(service);
			cpo.getSearch().click();
			WebElement cdf = cpo.getClickservice();
			wLib.waitForElemnetContainsText(driver,cdf,servicename);
			cdf.click();
			wLib.swicthToWindow(driver, "module=PurchaseOrde");
			wLib.waitForHTMLDOM(driver);
			cpo.getQuantity1().sendKeys(number);
			wLib.waitForHTMLDOM(driver);
			String getproducttext = cpo.getGettextservice().getText();
			cpo.getMoveupward().getText();
			String getservicetext = cpo.getGettextservice().getText();
			
		/* step6 validate */
			Assert.assertNotSame(getproducttext, getservicetext);
	}
	
	@Test(priority = 6)
	public void CreatePOwithItemandclickonDownwardSymbol() throws Throwable
	{
		/*read test script data */
		String servicename = eLib.getExcelData("Sheet2", 6, 2)+jLib.generateRandomNum();
		String subjectname = eLib.getExcelData("Sheet2", 6, 3)+jLib.generateRandomNum();
		String number = eLib.getExcelData("Sheet2", 7, 3);
		String service = eLib.getExcelData("Sheet2", 7, 2);
		
		/*step1  navigate to home pagehomepage */
			Home home = new Home(driver);
		
		//navigate to service
			home.getNavigate().click();
			home.getClickonservice().click();
			ServiceInfopage sip =new ServiceInfopage(driver);
			sip.getCreatenewservice().click();
			
		/* step2 add detail of service */
			CreateNewService cns = new CreateNewService(driver);
			cns.getServicename().sendKeys(servicename);
			cns.getSaveBtn().click();

		/* step3 navigate to purchaseorder */
			home.getNavigate().click();
			home.getClickonPurchaseOrder().click();
			PurchaseOrderInfoPage pip = new PurchaseOrderInfoPage(driver);
			pip.getCreateNewPurchaseOrder().click();
			
		/* step4 add detail of purchaseorder in create purchase order */
			CreateNewPurchaseOrder cpo = new CreateNewPurchaseOrder(driver);
			cpo.getVendorname().click();
			String partailWindowTitle = driver.getWindowHandle();
			wLib.swicthToWindow(driver, "module=Vendor");
			cpo.getSelectvendor().click();
			wLib.swicthToWindow(driver, "module=PurchaseOrde");
			cpo.getSubjectname().sendKeys(subjectname);
			
		/* step4 add service to purchase order */
			cpo.getAddproduct().click();
			wLib.swicthToWindow(driver, "module=Product");
			cpo.getClickonproduct().click();
			wLib.swicthToWindow(driver, "module=PurchaseOrde");
			cpo.getQuantity().sendKeys(number);
			cpo.getAddservice().click();
			cpo.getClickonservice().click();
			wLib.swicthToWindow(driver, "module=Services");
			cpo.getSearchservice().sendKeys(servicename);
			cpo.getSelectservicename().sendKeys(service);
			cpo.getSearch().click();
			WebElement cdf = cpo.getClickservice();
			wLib.waitForElemnetContainsText(driver,cdf,servicename);
			cdf.click();
			wLib.swicthToWindow(driver, "module=PurchaseOrde");
			wLib.waitForHTMLDOM(driver);
			cpo.getQuantity1().sendKeys(number);
			wLib.waitForHTMLDOM(driver);
			String getproducttext = cpo.getGettextservice().getText();
			cpo.getMovedownward().click();
			String getservicetext = cpo.getGettextservice().getText();
			
		/* step5 validate */
			Assert.assertNotSame(getproducttext, getservicetext);
	}
}
