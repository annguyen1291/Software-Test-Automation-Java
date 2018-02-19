package eu.company.hosel.bsl.test.pages.paymentManagement;

import org.openqa.selenium.support.FindBy;

import eu.company.hosel.bsl.test.archive.SM06_BSL_Payment;
import eu.company.hosel.bsl.test.pages.CommonPage;
import eu.company.hosel.bsl.test.pages.HomePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class ImportIncomingPages extends PageObject {
	CommonPage commonPage;
	HomePage homePage;

	// Import Incoming Payments File
	@FindBy(xpath = "//a[@data-uid='modal:yes']")
	WebElementFacade modalYes;
	@FindBy(xpath = "//a[@data-uid='modal:ok']")
	WebElementFacade modalOk;

	public void importIncomingFile() {
		WebElementFacade importFile = findBy("//div[contains(text(),'" + SM06_BSL_Payment.IMPORTING_NUMBER
				+ "')]/ancestor::tr[@data-better-uid='files:body']//a");
		commonPage.waitForPresent(importFile, 30);
		importFile.click();
		modalYes.waitUntilPresent();
		modalYes.click();
		modalOk.waitUntilPresent();
		modalOk.click();
	}

	// Browse Incoming Payments File
	@FindBy(xpath = "//input[@data-uid='file-name']")
	WebElementFacade fileName;
	@FindBy(xpath = "//input[@data-uid='button-panel:search']")
	WebElementFacade buttonSearch;
	@FindBy(xpath = "//a[@data-uid='search-result-panel:search-result-table:action-column:0']")
	WebElementFacade confirm;

	public void browsetIncomingFile() {
		homePage.clickHomeIcon();
		homePage.clickBrowseIncomingPaymentFiles();
		fileName.type("DO_NOT_TOUCH_FOR_TEST_AUTOMATION_ONLY_" + SM06_BSL_Payment.IMPORTING_NUMBER + ".xml");
		buttonSearch.click();
		confirm.waitUntilPresent();
		confirm.click();
		modalYes.waitUntilPresent();
		modalYes.click();
	}

	// Verify Importing Incoming Payment
	@FindBy(xpath = "//input[@data-uid='incoming-payment-search-to:transaction-number']")
	WebElementFacade transactionNumber;
	@FindBy(xpath = "//span[@data-uid='incoming-payment-detail-panel:pairing-status']")
	WebElementFacade pairingStatus;
	@FindBy(xpath = "//span[@data-uid='incoming-payment-detail-panel:transaction-number']")
	WebElementFacade txtTransactionNumber;

	public void verifyIncomingPayment() {
		homePage.clickHomeIcon();
		homePage.clickBrowseIncomingPaymentIcon();
		transactionNumber.waitUntilPresent();
		transactionNumber.type(SM06_BSL_Payment.IMPORTING_NUMBER);
		buttonSearch.click();		
		commonPage.checkDetails(pairingStatus, "Paired");
		commonPage.checkDetails(txtTransactionNumber, SM06_BSL_Payment.IMPORTING_NUMBER);
	}
}