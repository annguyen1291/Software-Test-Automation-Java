package eu.company.hosel.bsl.test.pages.paymentManagement;

import java.util.Calendar;
import java.util.Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.support.FindBy;

import eu.company.hosel.bsl.test.archive.SM06_BSL_Payment;
import eu.company.hosel.bsl.test.pages.CommonPage;
import eu.company.hosel.bsl.test.pages.HomePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class CreateIncomingPages extends PageObject {

	CommonPage commonPage;
	HomePage homePage;

	// Create Incoming Payment
	@FindBy(xpath = "//select[@data-uid='channel-type']")
	WebElementFacade repaymentChannel;
	@FindBy(xpath = "//input[@data-uid='amount:value']")
	WebElementFacade paymentAmount;
	@FindBy(xpath = "//input[@data-uid='deposit-date']")
	WebElementFacade depositDate;
	@FindBy(xpath = "//input[@data-uid='provided-contract-number']")
	WebElementFacade contractNumber;
	@FindBy(xpath = "//input[@data-uid='transaction-number']")
	WebElementFacade transactionNumber;
	@FindBy(xpath = "//input[@data-uid='button-panel:ok']")
	WebElementFacade buttonPanelOk;

	public void createIncomingPayment() {
		repaymentChannel.waitUntilPresent();
		repaymentChannel.selectByValue("OTHER");
		paymentAmount.type(SM06_BSL_Payment.INSTALLMENT_AMOUNT);
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		Date date = Calendar.getInstance().getTime();
		System.out.println(dateFormat.format(date));
		depositDate.type(dateFormat.format(date));
		contractNumber.type(SM06_BSL_Payment.CONTRACT_NUMBER);
		transactionNumber.type(SM06_BSL_Payment.TRANSACTION_NUMBER);
		buttonPanelOk.click();
	}

	// Verify Incoming Payment
	@FindBy(xpath = "//span[@data-uid='incoming-payment-detail-panel:pairing-status']")
	WebElementFacade pairingStatus;
	@FindBy(xpath = "//span[@data-uid='incoming-payment-detail-panel:contract.contract-code']")
	WebElementFacade txtContractNumber;
	@FindBy(xpath = "//span[@data-uid='incoming-payment-detail-panel:transaction-number']")
	WebElementFacade txtTransactionNumber;

	public void verifyIncomingPayment() {
		commonPage.checkDetails(pairingStatus, "Paired");
		commonPage.checkDetails(txtContractNumber, SM06_BSL_Payment.CONTRACT_NUMBER);
		commonPage.checkDetails(txtTransactionNumber, SM06_BSL_Payment.TRANSACTION_NUMBER);
	}
}
