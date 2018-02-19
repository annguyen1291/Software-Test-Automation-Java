package eu.company.hosel.bsl.test.pages.contractManagement;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

import eu.company.hosel.bsl.test.BaseSs;
import eu.company.hosel.bsl.test.pages.CommonPage;
import eu.company.hosel.bsl.test.pages.HomePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class ChooseProductPages extends PageObject {	
	HomePage homePage;	
	CommonPage commonPage;
	
	//Choose active salesroom	
	@FindBy(xpath = "//input[@data-better-uid='sales-agent.employee-number']")
	WebElementFacade employeeNumber;	
	@FindBy(xpath = "//a[@data-better-uid='get-salesrooms']")
	WebElementFacade getSalesrooms;	
	@FindBy(xpath = "//select[@data-better-uid='salesroom-id:drop-down-choice']")
	WebElementFacade salesroomId;
	@FindBy(xpath = "//input[@data-better-uid='button-panel:ok']")
	WebElementFacade buttonPanelOk;
	
	public void chooseActiveSaleroom() {
		homePage.clickUserSettings();		
		if (BaseSs.isTestEnvi()) {
			employeeNumber.waitUntilPresent();	
			employeeNumber.clear();
			getSalesrooms.waitUntilPresent();
			getSalesrooms.click();
			BaseSs.wait(1);
			salesroomId.selectByValue("6104599200");
		} else {
			salesroomId.waitUntilPresent();
			salesroomId.selectByValue("8474");
		}
		buttonPanelOk.waitUntilPresent();
		buttonPanelOk.click();
	}
	
	//Select product	
	@FindBy(xpath = "//div[@data-uid='modal:dialog:dialog-panel:add-choose-product-offer-link']")
	WebElementFacade selectProduct;
	
	//Choose commodity
	@FindBy(xpath = "//input[@data-better-uid='calculation-method:selection:standard:consumer-loan']")
	WebElementFacade consumerLoan;	
	@FindBy(xpath = "//select[@data-uid='product-offer-search:commodities:commodities:commodity-category']")
	WebElementFacade commodityCategory;
	@FindBy(xpath = "//select[@data-uid='product-offer-search:commodities:commodities:commodity-type']")
	WebElementFacade commodityType;		
	@FindBy(xpath = "//input[@data-uid='product-offer-search:commodities:commodities:money:value']")
	WebElementFacade price;	
	@FindBy(xpath = "//input[@data-uid='product-offer-search:financial-parameters:maximal-cash-payment-percentage']")
	WebElementFacade cashPayment;	
	@FindBy(xpath = "//input[@data-uid='button-panel:search']")
	WebElementFacade buttonPanelSearch;
	
	public void chooseCommodity(String txtCategory, String txtType, String txtPrice) {
		homePage.clickCreateContractIcon();
		selectProduct.waitUntilPresent();
		selectProduct.click();
		consumerLoan.waitUntilPresent();
		consumerLoan.click();
		price.waitUntilPresent();
		price.type(txtPrice);
		commodityCategory.waitUntilPresent();
		commodityCategory.selectByValue(txtCategory);
		commonPage.waitForAjaxComplete();
		commodityType.selectByValue(txtType);
		cashPayment.type("50");
		buttonPanelSearch.waitUntilPresent();
		buttonPanelSearch.click();
	}
	
	//Choose product	
	@FindBy(xpath = "//a[@data-uid='search-result-panel:search-result-table:body-container:body:action-column:1']")
	WebElementFacade fillInApplication;	
	@FindBy(xpath = "//input[@data-uid='button-panel:cancel']")
	WebElementFacade buttonPanelCancel;	
	
	public void chooseProduct() {
		fillInApplication.waitUntilPresent();
		fillInApplication.sendKeys(Keys.ENTER);
		buttonPanelCancel.waitUntilPresent();
		buttonPanelCancel.click();		
	}	
}
