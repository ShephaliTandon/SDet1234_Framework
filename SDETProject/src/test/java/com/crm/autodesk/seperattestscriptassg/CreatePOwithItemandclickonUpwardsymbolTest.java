package com.crm.autodesk.seperattestscriptassg;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericlib.BaseClass;
import com.crm.comcast.objectrepositoryutility.CreateNewPurchaseOrder;
import com.crm.comcast.objectrepositoryutility.CreateNewService;
import com.crm.comcast.objectrepositoryutility.Home;
import com.crm.comcast.objectrepositoryutility.PurchaseOrderInfoPage;
import com.crm.comcast.objectrepositoryutility.ServiceInfopage;

/**
 * 
 * @author SHEPHALI
 *
 */

public class CreatePOwithItemandclickonUpwardsymbolTest extends BaseClass {

	@Test
	public void CreatePOwithItemandclickonUpwardsymbol() throws Throwable
	{
		/*read test script data */
		String productname = eLib.getExcelData("Sheet2", 1, 2)+jLib.generateRandomNum();
		String Servicename = eLib.getExcelData("Sheet2", 6, 2)+jLib.generateRandomNum();
		String Subjectname = eLib.getExcelData("Sheet2", 6, 3)+jLib.generateRandomNum();
		String number = eLib.getExcelData("Sheet2", 7, 3);
		String service = eLib.getExcelData("Sheet2", 7, 2);
		
		//homepage
			Home home = new Home(driver);
		/* step1 navigate to service */
			home.getNavigate().click();
			home.getClickonservice().click();
			ServiceInfopage sip =new ServiceInfopage(driver);
			sip.getCreatenewservice().click();
				
		/* step2 add detail of service */
			CreateNewService cns = new CreateNewService(driver);
			cns.createNewService(Servicename);
	
		/* step3 navigate to purchaseorder */
			home.getNavigate().click();
			home.getClickonPurchaseOrder().click();
			PurchaseOrderInfoPage pip = new PurchaseOrderInfoPage(driver);
			pip.getCreateNewPurchaseOrder().click();
			
		/* step4 add detail of purchaseorder in create purchase order */
			CreateNewPurchaseOrder cpo = new CreateNewPurchaseOrder(driver);
			
		//add service to purchase order
			cpo.getAddproduct().click();
			wLib.swicthToWindow(driver, "module=Product");
			cpo.getClickonproduct().click();
			wLib.swicthToWindow(driver, "module=PurchaseOrde");
			cpo.getQuantity().sendKeys(number);
			cpo.getAddservice().click();
			cpo.getClickonservice().click();
			wLib.swicthToWindow(driver, "module=Services");
			cpo.getSearchservice().sendKeys(Servicename);
			cpo.getSelectservicename().sendKeys(service);
			cpo.getSearch().click();
			WebElement cdf = cpo.getClickservice();
			wLib.waitForElemnetContainsText(driver,cdf,Servicename);
			cdf.click();
			wLib.swicthToWindow(driver, "module=PurchaseOrde");
			wLib.waitForHTMLDOM(driver);
			cpo.getQuantity1().sendKeys(number);
			wLib.waitForHTMLDOM(driver);
			String getproducttext = cpo.getGettextservice().getText();
			cpo.getMoveupward().getText();
			String getservicetext = cpo.getGettextservice().getText();
			
		/* step5 validate */
			Assert.assertNotSame(getproducttext, getservicetext);
	}
}
