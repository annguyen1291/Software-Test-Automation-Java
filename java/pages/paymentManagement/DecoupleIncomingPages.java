package eu.company.hosel.bsl.test.pages.paymentManagement;

import org.openqa.selenium.support.FindBy;

import eu.company.hosel.bsl.test.archive.SM06_BSL_Payment;
import eu.company.hosel.bsl.test.pages.CommonPage;
import eu.company.hosel.bsl.test.pages.HomePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class DecoupleIncomingPages extends PageObject {

	CommonPage commonPage;
	HomePage homePage;

	// Search Incoming Payment
	@FindBy(xpath = "//input[@data-uid='incoming-payment-search-to:transaction-number']")
	WebElementFacade transactionNumber;
	@FindBy(xpath = "//input[@data-uid='button-panel:search']")
	WebElementFacade buttonSearch;

	public void searchIncomingPayment() {
		transactionNumber.waitUntilPresent();
		transactionNumber.type(SM06_BSL_Payment.TRANSACTION_NUMBER);
		buttonSearch.click();
	}

	// Decouple Incoming Payment
	@FindBy(xpath = "//a[@data-uid='incoming-payment-detail-buttons:submit']")
	WebElementFacade decouplePayment;
	@FindBy(xpath = "//a[@data-uid='modal:yes']")
	WebElementFacade modalYes;
	@FindBy(xpath = "//a[@data-uid='modal:ok']")
	WebElementFacade modalOk;

	public void decoupleIncomingPayment() {
		decouplePayment.waitUntilPresent();
		decouplePayment.click();
		modalYes.waitUntilPresent();
		modalYes.click();
		modalOk.waitUntilPresent();
		modalOk.click();
	}
	
	// Verify Decoupled Payment
	@FindBy(xpath = "//span[@data-uid='incoming-payment-detail-panel:pairing-status']")
	WebElementFacade pairingStatus;
	@FindBy(xpath = "//span[@data-uid='incoming-payment-detail-panel:provided-contract-number']")
	WebElementFacade txtContractNumber;
	@FindBy(xpath = "//span[@data-uid='incoming-payment-detail-panel:transaction-number']")
	WebElementFacade txtTransactionNumber;

	public void verifyDecoupledPayment() {
		commonPage.checkDetails(pairingStatus, "Unpaired");
		commonPage.checkDetails(txtContractNumber, SM06_BSL_Payment.CONTRACT_NUMBER);
		commonPage.checkDetails(txtTransactionNumber, SM06_BSL_Payment.TRANSACTION_NUMBER);
	}
}
