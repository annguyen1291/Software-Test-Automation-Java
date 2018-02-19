package eu.company.hosel.bsl.test.pages.contractManagement;

import org.openqa.selenium.support.FindBy;

import eu.company.hosel.bsl.test.pages.CommonPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class SearchForContract extends PageObject {
	CommonPage commonPage;
	
	@FindBy(xpath = "//input[@data-uid='button-panel:search']")
	WebElementFacade buttonPanelSearch;
	
	public void searchContractByContractStatus(String txtContractStatus) {
		WebElementFacade contractStatus = findBy("//input[@value='" + txtContractStatus + "']");	
		contractStatus.waitUntilPresent();
		contractStatus.click();
		buttonPanelSearch.click();
	}
	
	@FindBy(xpath = "//input[@data-uid='contract-search-custom-filter:contract-code']")
	WebElementFacade contractNumber;
	public void searchContractByContractNumber(String txtcontractNumber) {
		contractNumber.waitUntilPresent();
		contractNumber.type(txtcontractNumber);
		buttonPanelSearch.click();
	}	
	
	public void selectContract() {
		WebElementFacade selectedContract = findBy("//tr[@data-uid='search-result-panel:search-result-table:" + commonPage.randomNumber(1) + "']//a");	
		commonPage.waitForPresent(selectedContract, 30);
		selectedContract.click();
	}
}
