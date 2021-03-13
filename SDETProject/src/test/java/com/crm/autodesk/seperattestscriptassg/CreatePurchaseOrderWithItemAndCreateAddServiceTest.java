package com.crm.autodesk.seperattestscriptassg;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericlib.BaseClass;
import com.crm.comcast.objectrepositoryutility.CreateNewProduct;
import com.crm.comcast.objectrepositoryutility.CreateNewPurchaseOrder;
import com.crm.comcast.objectrepositoryutility.CreateNewService;
import com.crm.comcast.objectrepositoryutility.Home;
import com.crm.comcast.objectrepositoryutility.ProductInfoPage;
import com.crm.comcast.objectrepositoryutility.PurchaseOrderInfoPage;
import com.crm.comcast.objectrepositoryutility.ServiceInfopage;

/**
 * 
 * @author SHEPHALI
 *
 */

public class CreatePurchaseOrderWithItemAndCreateAddServiceTest extends BaseClass {

	@Test
	public void CreatePurchaseOrderWithItemAndCreateAddService() throws Throwable
	{
		/*read test script data */
		String productname = eLib.getExcelData("Sheet2", 1, 2)+jLib.generateRandomNum();
		String Servicename = eLib.getExcelData("Sheet2", 6, 2)+jLib.generateRandomNum();
		String Subjectname = eLib.getExcelData("Sheet2", 6, 3)+jLib.generateRandomNum();
		String number = eLib.getExcelData("Sheet2", 7, 3);
		String service = eLib.getExcelData("Sheet2", 7, 2);
		
		/* step1 navigate to product order */
			Home home = new Home(driver);
			home.getNavigateToProduct().click();
			new ProductInfoPage(driver).newproductclick();
		
		/* step2 details of product order in create new product */
			CreateNewProduct cnp = new CreateNewProduct(driver);
			cnp.createNewProduct(productname);
	
		/* step3 navigate to Servicepage */
			home.getNavigate().click();
			home.getClickonservice().click();
			ServiceInfopage sip =new ServiceInfopage(driver);
			sip.getCreatenewservice().click();
				
		/* step4 detail of service in create service page */
			CreateNewService cns = new CreateNewService(driver);
			cns.createNewService(Servicename);
			
		/* step5 navigate to purchaseorder */
			home.getNavigate().click();
			home.getClickonPurchaseOrder().click();
			PurchaseOrderInfoPage pip = new PurchaseOrderInfoPage(driver);
			pip.getCreateNewPurchaseOrder().click();
			
		/* step6 details of purchase order to create new purchase order */
			CreateNewPurchaseOrder cpo = new CreateNewPurchaseOrder(driver);
			cpo.createNewPurchaseOrderWithService(Subjectname, productname, number, Servicename, service);
			String actservicename = cpo.getPrintservicename().getText();
				
	  /* step7 validate */
			boolean flag = actservicename.contains(Servicename);		  		  
			Assert.assertTrue(flag);

}
}