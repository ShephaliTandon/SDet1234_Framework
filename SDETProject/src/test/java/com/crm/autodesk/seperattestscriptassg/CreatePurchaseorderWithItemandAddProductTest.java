package com.crm.autodesk.seperattestscriptassg;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericlib.BaseClass;
import com.crm.comcast.objectrepositoryutility.CreateNewProduct;
import com.crm.comcast.objectrepositoryutility.CreateNewPurchaseOrder;
import com.crm.comcast.objectrepositoryutility.Home;
import com.crm.comcast.objectrepositoryutility.ProductInfoPage;
import com.crm.comcast.objectrepositoryutility.PurchaseOrderInfoPage;

/**
 * 
 * @author SHEPHALI
 *
 */
public class CreatePurchaseorderWithItemandAddProductTest extends BaseClass {

	@Test(retryAnalyzer = com.crm.comcast.genericlib.RetryAnalyzer.class)
	public void CreatePurchaseorderWithItemandAddProduct() throws Throwable
	{	
		/*read test script data */
		String productname = eLib.getExcelData("Sheet2", 1, 2)+jLib.generateRandomNum();
		String Subjectname = eLib.getExcelData("Sheet2", 1, 3)+jLib.generateRandomNum();
		String number = eLib.getExcelData("Sheet2", 2, 3);
		
		/* step1 navigate to product info order */
			Home home = new Home(driver);
			home.getNavigateToProduct().click();
			new ProductInfoPage(driver).newproductclick();
			
		/* step2 details of product order in create new product */
			CreateNewProduct cnp = new CreateNewProduct(driver);
			cnp.createNewProduct(productname);
		
		/* step3 navigate to purchaseorder info page */
			home.getNavigate().click();
			home.getClickonPurchaseOrder().click();
			PurchaseOrderInfoPage pip = new PurchaseOrderInfoPage(driver);
			pip.getCreateNewPurchaseOrder().click();
			 
		/* step4 details of purchase order to create new purchase order */
			CreateNewPurchaseOrder cpo = new CreateNewPurchaseOrder(driver);
			cpo.createNewPurchaseOrder(Subjectname, productname, number);
			String actProductname = cpo.getPrintproductname().getText();
		
	   /* step5 validate */
			boolean flag = actProductname.contains(productname);
			Assert.assertTrue(flag);
	}
	
}
