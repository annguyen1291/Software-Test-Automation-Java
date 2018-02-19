package eu.company.hosel.bsl.test.steps.serenity;

import static org.junit.Assert.assertTrue;

import eu.company.hosel.bsl.test.pages.SaleRoomPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SaleRoomSteps extends ScenarioSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1718555289104887830L;
	SaleRoomPage saleRoomPage;
	
	@Step
	public void searchForSaleroomCode(String saleroomCode) {
		
		saleRoomPage.enterFindSaleRoom_Code(saleroomCode);
		saleRoomPage.clickFindSaleRoom_SearchButton();
	}
	
	@Step
	public void clickOnTabLinkCreditProducts(){
		saleRoomPage.clickSaleRoomDetail_CreditProductLink();
	}
	
	@Step
	public void clickOnLinkAssign(){
		saleRoomPage.clickSaleRoomDetail_AssignLink();
	}
	
	@Step
	public void enterProductDateValidFrom(String dateValidFrom){
		saleRoomPage.enterAssignProduct_ValidFrom(dateValidFrom);
	}
	
	@Step
	public void selectProductToSaleRoom(String productCode){
		
		saleRoomPage.clickAssignProduct_TableHeader_Name();
		
		saleRoomPage.clickAssignProduct_CheckBoxProduct(productCode);

		saleRoomPage.clickAssignProduct_OKButton();
		
		saleRoomPage.clickAssignProduct_YesButton();
		
	}
	
	@Step
	public void checkProductCodeExistInTableProductAssignment(String productCode) {
		
		saleRoomPage.clickAssignProduct_UncheckCurrentProductAssignment();
		
		//saleRoomPage.waitForButtonRemoveProductVisible();
		
		saleRoomPage.clickSaleroomDetail_TableHeader_Name();
		
		assertTrue(saleRoomPage.isSaleRoomDetail_CreditProducts_ProductCodePresent(productCode));
		
	}

}
