package eu.company.hosel.bsl.test.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import eu.company.hosel.bsl.test.BaseSs;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class PartnerPage extends PageObject {

	String activeText = "Active";
	
	// -------- Search Partner form
	@FindBy(xpath = "//input[@type='text' and @data-uid='code']")
	WebElementFacade inputPartnerCode;

	@FindBy(xpath = "//input[@type='submit' and @value='Search']")
	WebElementFacade btnSearch;

	// -------- View Partner form
	@FindBy(xpath = "//span[@data-uid='partner-detail-panel:code']")
	WebElementFacade txtPartnerCode;

	@FindBy(xpath = "//span[@data-uid='partner-detail-panel:status']")
	WebElementFacade txtPartnerStatus;
	
	// ---------- list elements inside tab
	
	@FindAll({@FindBy(xpath="//div[@data-better-uid='partner-detail-panel:disbursement-channel-list-pane:disbursement-channels-table:body:cell']"),})  
	List<WebElement> rowDataChannels;
	
	// ---------- list elements inside tab
	@FindAll({@FindBy(xpath="//div[@data-better-uid='partner-detail-tabbed-panel:panel:contact-informations:body:cell']"),})  
	List<WebElement> rowDataTab;
	
	
	

	// ----- tab link elements
	@FindBy(xpath = "//span[@data-label-value='GEN_Notices']")
	WebElementFacade tabNotices;

	@FindBy(xpath = "//span[@data-label-value='GEN_Contacts']")
	WebElementFacade tabContacts;

	@FindBy(xpath = "//span[@data-label-value='GEN_ContactPersons']")
	WebElementFacade tabContactPerson;

	@FindBy(xpath = "//span[@data-label-value='ACC_BankAccounts']")
	WebElementFacade tabBank;

	@FindBy(xpath = "//span[@data-label-value='ADR_Addresses']")
	WebElementFacade tabAddress;

	@FindBy(xpath = "//span[@data-label-value='PAR_Salesrooms']")
	WebElementFacade tabSalesroom;

	@FindBy(xpath = "//span[@data-label-value='EXT_ExtendedProperties']")
	WebElementFacade tabExtended;

	//=================================
	
	
	// ------------- check row data tab methods 
	
	public void checkRowDataTable(String dataExpected){
		BaseSs.checkRowData(rowDataTab, dataExpected);
	}
	
	// ------------- Click methods

	public void clickButtonSearch() {
		btnSearch.click();
	}

	public void clickTabContacts() {
		tabContacts.click();
	}

	public void clickTabContactPerson() {
		tabContactPerson.click();
	}

	public void clickTabBank() {
		tabBank.click();
	}

	public void clickTabAddress() {
		tabAddress.click();
	}

	public void clickTabSalesroom() {
		tabSalesroom.click();
	}

	public void clickTabExtended() {
		tabExtended.click();
	}

	// -------------- Enter methods

	public void enterPartnerCode(String code) {
		inputPartnerCode.type(code);
	}

	// ------------- Check methods

	public void checkPartnerStatusActive() {
		BaseSs.checkText(txtPartnerStatus, activeText);
	}

	public void checkPartnerCode(String code) {
		BaseSs.checkText(txtPartnerCode, code);
	}

}
