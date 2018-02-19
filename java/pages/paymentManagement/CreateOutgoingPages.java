package eu.company.hosel.bsl.test.pages.paymentManagement;

import org.openqa.selenium.support.FindBy;

import eu.company.hosel.bsl.test.archive.SM06_BSL_Payment;
import eu.company.hosel.bsl.test.pages.CommonPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class CreateOutgoingPages extends PageObject {
	CommonPage commonPage;	

	// Browse Outgoing Payments
	@FindBy(xpath = "//input[@data-uid='preset-filters:unpaid']")
	WebElementFacade filtersUnpaid;
	@FindBy(xpath = "//select[@data-uid='outgoing-payment-search-unpaid-filter:payment-type']")
	WebElementFacade unpaidPaymentType;
	@FindBy(xpath = "//input[@data-uid='button-panel:search']")
	WebElementFacade buttonSearch;

	public void browseOutgoing(String paymentType) {
		filtersUnpaid.waitUntilPresent();
		filtersUnpaid.click();
		unpaidPaymentType.waitUntilPresent();
		unpaidPaymentType.selectByValue(paymentType);
		buttonSearch.waitUntilPresent();
		buttonSearch.click();
	}

	// Select Outgoing Payment
	@FindBy(xpath = "//tr[@data-uid='search-result-panel:search-result-panel:search-result-table:body-container:body:1']//input")
	WebElementFacade selectedCheckbox;
	@FindBy(xpath = "//tr[@data-uid='search-result-panel:search-result-panel:search-result-table:body-container:body:1']//span[@data-uid='search-result-panel:search-result-panel:search-result-table:body-container:body:contract-code:link-property-column.a:link-property-column.label']")
	WebElementFacade txtContractNumber;
	@FindBy(xpath = "//tr[@data-uid='search-result-panel:search-result-panel:search-result-table:body-container:body:1']//div[@data-uid='search-result-panel:search-result-panel:search-result-table:body-container:body:creation-date']")
	WebElementFacade txtCreationTime;
	@FindBy(xpath = "//a[@data-uid='search-result-panel:generate-orders']")
	WebElementFacade generateOrders;

	public void selectOutgoing() {
		commonPage.waitForPresent(selectedCheckbox, 30);
		commonPage.alternativeCheck(selectedCheckbox);
		txtContractNumber.waitUntilPresent();
		SM06_BSL_Payment.CONTRACT_NUMBER = txtContractNumber.getText();
		SM06_BSL_Payment.CREATION_TIME = txtCreationTime.getText().substring(0, 10).replaceAll("[^0-9.]", "");
		generateOrders.waitUntilPresent();
		generateOrders.click();
	}

	// Generate orders
	@FindBy(xpath = "//select[@data-uid='bank-account']")
	WebElementFacade bankAccount;
	@FindBy(xpath = "//input[@data-uid='button-panel:ok' and not(@disabled='disabled')]")
	WebElementFacade buttonOk;
	@FindBy(xpath = "//a[@data-uid='modal:ok']")
	WebElementFacade modalOk;

	public void generateOrders() {
		commonPage.waitForPresent(bankAccount, 30);
		bankAccount.selectByValue("9363378");
		buttonOk.waitUntilPresent();
		buttonOk.click();
		modalOk.waitUntilPresent();
		modalOk.click();
	}

	// Search Outgoing Payment
	@FindBy(xpath = "//select[@data-uid='outgoing-payment-search-standard-filter:payment-type']")
	WebElementFacade standardPaymentType;
	@FindBy(xpath = "//input[@data-uid='outgoing-payment-search-standard-filter:contract-number']")
	WebElementFacade contractNumber;
	@FindBy(xpath = "//select[@data-uid='outgoing-payment-search-standard-filter:status']")
	WebElementFacade filterStatus;
	@FindBy(xpath = "//input[@data-uid='outgoing-payment-search-standard-filter:created-from']")
	WebElementFacade createdFrom;

	public void searchOutgoing(String paymentType) {
		commonPage.waitForPresent(standardPaymentType, 30);
		standardPaymentType.selectByValue(paymentType);
		contractNumber.waitUntilPresent();
		contractNumber.type(SM06_BSL_Payment.CONTRACT_NUMBER);
		filterStatus.waitUntilPresent();
		filterStatus.selectByValue("P");
		createdFrom.type(SM06_BSL_Payment.CREATION_TIME);
		buttonSearch.waitUntilPresent();
		buttonSearch.click();
	}

	// Check Outgoing Payment
	@FindBy(xpath = "//tr[@data-uid='search-result-panel:search-result-panel:search-result-table:body-container:body:1']//div[@data-uid='search-result-panel:search-result-panel:search-result-table:body-container:body:transaction-type']")
	WebElementFacade txtPaymentType;
	@FindBy(xpath = "//tr[@data-uid='search-result-panel:search-result-panel:search-result-table:body-container:body:1']//div[@data-uid='search-result-panel:search-result-panel:search-result-table:body-container:body:status']")
	WebElementFacade txtStatus;
//
	public void checkOutgoing(String paymentType) {
		commonPage.waitForUpdate(txtStatus, "Paid", 5);
		commonPage.waitForPresent(txtContractNumber, 30);
		commonPage.checkDetails(txtContractNumber, SM06_BSL_Payment.CONTRACT_NUMBER);
		commonPage.checkDetails(txtPaymentType, paymentType);
		commonPage.checkDetails(txtStatus, "Paid");
	}
}