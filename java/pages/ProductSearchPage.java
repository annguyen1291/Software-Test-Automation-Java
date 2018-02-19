package eu.company.hosel.bsl.test.pages;

import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class ProductSearchPage extends PageObject {

	@FindBy(xpath = "//input[@type='submit' and @data-uid='button-panel:search']")
	WebElementFacade buttonSearch;
	
	@FindBy(xpath = "//a[@data-uid='search-result-panel:search-result-table:action-column:0']")
	WebElementFacade buttonViewProduct;
	
	@FindBy(xpath = "//input[@type='text' and @data-uid='code']")
	WebElementFacade inputCode;

	
	public void searchForProductCode(String productCode) {
		
		inputCode.waitUntilVisible();
		inputCode.type(productCode);
		
		buttonSearch.click();
	}
	
	public void clickSearchButton() {
		buttonSearch.click();
	}
	
		public void clickViewProduct() {
		buttonViewProduct.click();
	}

}
