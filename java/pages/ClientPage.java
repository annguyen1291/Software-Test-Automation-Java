package eu.company.hosel.bsl.test.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import static org.junit.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import eu.company.hosel.bsl.test.BaseSs;

public class ClientPage extends PageObject {

	// =================Client Search

	@FindBy(xpath = "//input[@type='text' and @data-uid='contract-number']")
	WebElementFacade inputClientContractNumber;
	
	@FindBy(xpath = "//input[@type='text' and @data-uid='cuid']")
	WebElementFacade inputClientCuidNumber;

	@FindBy(xpath = "//input[@type='submit' and @data-uid='button-panel:search']")
	WebElementFacade buttonSearchClient;

	// =================Client Detail

	@FindBy(xpath = "//span[@data-uid='client-detail-panel:cif-client.full-name']")
	WebElementFacade txtFullName;

	@FindBy(xpath = "//span[@data-uid='client-detail-panel:cif-client.cuid-for-display']")
	WebElementFacade txtCuid;

	@FindBy(xpath = "//span[@data-uid='client-detail-panel:cif-client.birth-date']")
	WebElementFacade txtBirthdate;

	@FindBy(xpath = "//span[@data-uid='client-detail-panel:cif-client.primary-mobile']")
	WebElementFacade txtPrimaryMobile;

	@FindBy(xpath = "//span[@data-uid='client-detail-panel:cif-client.home-phone']")
	WebElementFacade txtHomePhone;

	@FindBy(xpath = "//span[@data-uid='client-detail-panel:cif-client.primary-email']")
	WebElementFacade txtPrimaryEmail;

	@FindBy(xpath = "//span[@data-uid='client-detail-panel:cif-client.contact-address']")
	WebElementFacade txtContactAddress;

	@FindBy(xpath = "//span[@data-uid='client-detail-panel:cif-client.permanent-address']")
	WebElementFacade txtPermanentAddress;

	//@FindBy(xpath = "//div[@data-better-uid='client-detail-panel:ident-documents:body:cell']")
	//WebElementFacade listIdDocuments; // list of identification document

	//@FindBy(xpath = "//div[@data-better-uid='client-detail-tabbed-panel:panel:client-contracts:body:cell']")
	//WebElementFacade txtContractNumber; // list of identification document
	
	@FindAll({@FindBy(xpath="//div[@data-better-uid='client-detail-tabbed-panel:panel:client-contracts:body:cell']"),})  
	List<WebElement> tableClientContract;
	

	@FindBy(xpath = "//a[@data-uid='client-detail-panel:button-container:cif-field']")
	WebElementFacade linkManageClient;
	
	
	
	private String getUrlOfLinkManageClient(){
		String pifUrl = linkManageClient.getAttribute("href");
		System.out.println("<getUrlOfLinkManageClient> pifUrl:" + pifUrl);
		return pifUrl;
	}
	
	public void clickLinkManageClient(){
		getDriver().get(getUrlOfLinkManageClient());
	}
	
	// get method
	
	public String getClientCUID() {
		return txtCuid.getText();
	}

	public String getClientContractNumber() {
		return tableClientContract.get(1).getText();
	}
	
	public String getClientBirthdate() {
		return txtBirthdate.getText();
	}

	public void enterSearchClient_ContractNumber(String contractNum) {
		inputClientContractNumber.type(contractNum);
	}
	
	public void enterSearchClient_CuidNumber(String CuidNum) {
		inputClientCuidNumber.type(CuidNum);
	}

	public void clickSearchClient_SearchButton() {
		buttonSearchClient.click();
	}
	
	
	// check method
	
	public void checkFullName(String firstName, String lastName, String midName) {
		BaseSs.checkText(txtFullName, lastName + " " + midName + " " + firstName);
	}
	
	public void checkBirthdate(String birthdate) {
		BaseSs.checkText(txtBirthdate, birthdate);
	}
	
	public void checkCuid(String cuid) {
		BaseSs.checkText(txtCuid, cuid);
	}
	
	public void checkContract(String contractNumber) {
		String actualContract = getClientContractNumber();
		assertTrue(actualContract.equals(contractNumber));
	}
	

	public boolean isClientCuidMatched(String expectCUID) {
		return txtCuid.getText().equals(expectCUID);
	}
	
	public boolean isClientContractNumberMatched(String expectContractNumber) {
		return getClientContractNumber().equals(expectContractNumber);
	}
	
	
	
	
	
	
	
	

}
