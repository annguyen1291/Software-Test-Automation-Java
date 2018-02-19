package eu.company.hosel.bsl.test.pages.contractManagement;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

import eu.company.hosel.bsl.test.BaseSs;
import eu.company.hosel.bsl.test.pages.CommonPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class CreateContractPages extends PageObject {

	CommonPage commonPage;

	public void fillInApplication() {
		personalData();
		primaryDocuments();
		additionalDocuments();
		clientContact();
		clientAddress();
		additionalPersonalData();
		relatedPerson();
		employmentInformation();
		contractFinalization();
	}

	// Personal data
	@FindBy(xpath = "//input[@data-better-uid='personal-info-section:personal-data-pane:name1']")
	WebElementFacade firstName;
	@FindBy(xpath = "//input[@data-better-uid='personal-info-section:personal-data-pane:name2']")
	WebElementFacade familyName;
	@FindBy(xpath = "//input[@data-better-uid='personal-info-section:personal-data-pane:name3']")
	WebElementFacade middleName;
	@FindBy(xpath = "//select[@data-better-uid='personal-info-section:personal-data-pane:gender-type']")
	WebElementFacade genderType;
	@FindBy(xpath = "//input[@data-better-uid='personal-info-section:personal-data-pane:birth-date']")
	WebElementFacade birthDate;

	public void personalData() {
		firstName.waitUntilPresent();
		firstName.type(commonPage.randomCharacter(10));
		familyName.type(commonPage.randomCharacter(10));
		middleName.type("Amrit");
		genderType.selectByValue("M");
		birthDate.type("02011991");
	}

	// Primary ID proof documents
	@FindBy(xpath = "//input[@data-better-uid='personal-info-section:primary-documents-pane:documents:id-card:doc-id:value']")
	WebElementFacade idCard;
	@FindBy(xpath = "//input[@data-better-uid='personal-info-section:primary-documents-pane:documents:id-card:iss-date:value']")
	WebElementFacade issueDate;
	@FindBy(xpath = "//select[@data-better-uid='personal-info-section:primary-documents-pane:documents:id-card:iss-by:value']")
	WebElementFacade issueBy;
	@FindBy(xpath = "//select[@data-better-uid='personal-info-section:primary-documents-pane:documents:photo-person:photo-taking-result']")
	WebElementFacade photoPerson;
	
	public void primaryDocuments() {
		idCard.waitUntilPresent();
		idCard.type(commonPage.randomNumber(10));
		issueDate.type("21112014");
		issueBy.selectByValue("HC");
		photoPerson.selectByValue("TECHNICAL_PROBLEM");
		
	}
	
	// Additional ID proof documents	
	@FindBy(xpath = "//span[@data-better-uid='header-section:base-product-1sp-header-pane:credit-information-panel:credit-type']")
	WebElementFacade creditType;
	@FindBy(xpath = "//input[@data-better-uid='personal-info-section:primary-documents-pane:documents:family-book:doc-id:value']")
	WebElementFacade familyBook;
	@FindBy(xpath = "//select[@data-better-uid='personal-info-section:primary-documents-pane:document-types']")
	WebElementFacade documentType;
	@FindBy(xpath = "//input[@data-better-uid='personal-info-section:primary-documents-pane:add-document']")
	WebElementFacade addDocument;
	@FindBy(xpath = "//input[@data-better-uid='personal-info-section:primary-documents-pane:documents:drivers-license:doc-id:value']")
	WebElementFacade driversLicense;

	public void additionalDocuments() {
		if (commonPage.waitForPresent(familyBook, 5)) {
			familyBook.type(commonPage.randomNumber(10));			
		} else {
			documentType.selectByValue("DRIVERS_LICENSE");
			addDocument.sendKeys(Keys.ENTER);
			driversLicense.waitUntilPresent();
			driversLicense.type(commonPage.randomNumber(10));
		}		
	}

	// Contact to client
	@FindBy(xpath = "//input[@data-better-uid='personal-info-section:client-contact-pane:primary-mobile']")
	WebElementFacade primaryMobile_PP;
	@FindBy(xpath = "//input[@data-better-uid='personal-info-section:client-contact-pane:fix-contacts-container:primary-mobile']")
	WebElementFacade primaryMobile_C1;	
	@FindBy(xpath = "//a[@data-better-uid='personal-info-section:client-contact-pane:add-contact-button-container:add-contact']")
	WebElementFacade addContact;
	@FindBy(xpath = "//button[@data-better-uid='personal-info-section:base-product-client-contact-verification-pane:contact-verifications-form-panel:contact-verifications:repeated-row:container:skip']")
	WebElementFacade skipVerification;
	@FindBy(xpath = "//a[@data-better-uid='windows-holder:modal:dialog:buttons-container:yes']")
	WebElementFacade skipVerificationYes;

	public void clientContact() {
		if (commonPage.waitForPresent(primaryMobile_C1, 5)) {
			primaryMobile_C1.type("09" + commonPage.randomNumber(8));			
		} else { 
			primaryMobile_PP.type("09" + commonPage.randomNumber(8));
		}
		addContact.click();
		skipVerification.waitUntilPresent();
		skipVerification.sendKeys(Keys.ENTER);
		skipVerificationYes.click();
	}

	// Client Address
	@FindBy(xpath = "//input[@data-better-uid='personal-info-section:primary-address-pane:address:house-number-office-number']")
	WebElementFacade houseNumber;
	@FindBy(xpath = "//input[@data-better-uid='personal-info-section:primary-address-pane:address:street-name']")
	WebElementFacade houseStreet;
	@FindBy(xpath = "//select[@data-better-uid='personal-info-section:primary-address-pane:address:region-code']")
	WebElementFacade houseRegion;
	@FindBy(xpath = "//select[@data-better-uid='personal-info-section:primary-address-pane:address:district-code']")
	WebElementFacade houseDistrict;
	@FindBy(xpath = "//select[@data-better-uid='personal-info-section:primary-address-pane:address:district-code']/option[@value='HC_05']")
	WebElementFacade houseDistrictOption;
	@FindBy(xpath = "//input[@data-better-uid='personal-info-section:primary-address-pane:address:town']")
	WebElementFacade houseWard;
	@FindBy(xpath = "//li[@data-better-uid='personal-info-section:primary-address-pane:address:town']")
	WebElementFacade houseWardOption;

	public void clientAddress() {
		houseRegion.waitUntilPresent();
		houseRegion.selectByValue("HC");
		houseDistrictOption.waitUntilPresent();
		houseDistrict.selectByValue("HC_05");
		houseNumber.waitUntilPresent();
		houseNumber.type("194");
		houseStreet.type("Do Ngoc Thanh");
		BaseSs.wait(2);
		houseWard.waitUntilPresent();
		houseWard.type("P. 12");
	}

	// Additional personal data
	@FindBy(xpath = "//select[@data-better-uid='personal-info-section:additional-personal-data-pane:marital-status-code']")
	WebElementFacade maritalStatus;
	@FindBy(xpath = "//select[@data-better-uid='personal-info-section:additional-personal-data-pane:accompaniment-type']")
	WebElementFacade accompaniment;
	@FindBy(xpath = "//input[@data-better-uid='personal-info-section:additional-personal-data-pane:children-count']")
	WebElementFacade childrenNumber;
	@FindBy(xpath = "//select[@data-better-uid='personal-info-section:additional-personal-data-pane:education-code']")
	WebElementFacade education;

	public void additionalPersonalData() {
		maritalStatus.waitUntilPresent();
		maritalStatus.selectByValue("MARRIED");
		accompaniment.selectByValue("AC");
		childrenNumber.type("0");
		education.selectByValue("MASTERS");
	}

	// Related person
	@FindBy(xpath = "//select[@data-better-uid='contact-information-section:contact-information-pane:persons-container:1:pane-content:relation-type']")
	WebElementFacade relatedPerson1;
	@FindBy(xpath = "//input[@data-better-uid='contact-information-section:contact-information-pane:persons-container:1:pane-content:name1']")
	WebElementFacade firstName1;
	@FindBy(xpath = "//input[@data-better-uid='contact-information-section:contact-information-pane:persons-container:1:pane-content:name2']")
	WebElementFacade familyName1;
	@FindBy(xpath = "//input[@data-better-uid='contact-information-section:contact-information-pane:persons-container:1:pane-content:name3']")
	WebElementFacade middleName1;
	@FindBy(xpath = "//input[@data-better-uid='contact-information-section:contact-information-pane:persons-container:1:pane-content:phone.value1']")
	WebElementFacade phone1;
	@FindBy(xpath = "//select[@data-better-uid='contact-information-section:contact-information-pane:persons-container:2:pane-content:relation-type']")
	WebElementFacade relatedPerson2;
	@FindBy(xpath = "//input[@data-better-uid='contact-information-section:contact-information-pane:persons-container:2:pane-content:name1']")
	WebElementFacade firstName2;
	@FindBy(xpath = "//input[@data-better-uid='contact-information-section:contact-information-pane:persons-container:2:pane-content:name2']")
	WebElementFacade familyName2;
	@FindBy(xpath = "//input[@data-better-uid='contact-information-section:contact-information-pane:persons-container:2:pane-content:name3']")
	WebElementFacade middleName2;
	@FindBy(xpath = "//input[@data-better-uid='contact-information-section:contact-information-pane:persons-container:2:pane-content:phone.value1']")
	WebElementFacade phone2;

	public void relatedPerson() {
		relatedPerson1.selectByValue("FATHER");
		firstName1.type("Tien");
		familyName1.type("Nguyen");
		middleName1.type("Van");
		phone1.type("09" + commonPage.randomNumber(8));
		relatedPerson2.selectByValue("MOTHER");
		firstName2.type("Thanh");
		familyName2.type("Le");
		middleName2.type("Thi");
		phone2.type("09" + commonPage.randomNumber(8));
	}

	// Employment information
	@FindBy(xpath = "//select[@data-better-uid='employment-section:employment-pane:economical-status']")
	WebElementFacade economicalStatus;
	@FindBy(xpath = "//input[@data-better-uid='employment-section:vietnam-employer-pane:university-name']")
	WebElementFacade companyName;
	@FindBy(xpath = "//select[@data-better-uid='employment-section:vietnam-employer-pane:profession.code']")
	WebElementFacade professionCode;
	@FindBy(xpath = "//input[@data-better-uid='employment-section:vietnam-employer-pane:employed-from']")
	WebElementFacade employedFrom;
	@FindBy(xpath = "//input[@data-better-uid='employment-section:income-expenses-pane:occupation-income:value']")
	WebElementFacade occupationIncome;
	@FindBy(xpath = "//input[@data-better-uid='employment-section:income-expenses-pane:other-debts:value']")
	WebElementFacade otherDebts;
	@FindBy(xpath = "//input[@data-better-uid='employment-section:employer-address-pane:address:house-number-office-number']")
	WebElementFacade companyNumber;
	@FindBy(xpath = "//input[@data-better-uid='employment-section:employer-address-pane:address:street-name']")
	WebElementFacade companyStreet;
	@FindBy(xpath = "//select[@data-better-uid='employment-section:employer-address-pane:address:region-code']")
	WebElementFacade companyRegion;
	@FindBy(xpath = "//select[@data-better-uid='employment-section:employer-address-pane:address:district-code']")
	WebElementFacade companyDistrict;
	@FindBy(xpath = "//select[@data-better-uid='employment-section:employer-address-pane:address:district-code']/option[@value='HC_02']")
	WebElementFacade companyDistrictOption;
	@FindBy(xpath = "//input[@data-better-uid='employment-section:employer-address-pane:address:town']")
	WebElementFacade companyWard;

	public void employmentInformation() {
		economicalStatus.waitUntilPresent();
		economicalStatus.selectByValue("EMPLOYED");
		companyRegion.waitUntilPresent();
		companyRegion.selectByValue("HC");
		companyDistrictOption.waitUntilPresent();
		companyDistrict.selectByValue("HC_02");
		companyName.waitUntilPresent();
		companyName.type("Home Credit Vietnam");
		professionCode.selectByValue("ENGINEER");
		employedFrom.type("0317");
		occupationIncome.type("22000000");
		otherDebts.type("0");
		companyNumber.type("20");
		companyStreet.type("Nguyen Dang Giai");
		BaseSs.wait(1);
		companyWard.waitUntilPresent();
		companyWard.type("P. Th???o ??i???n");
	}

	// Contract Finalization
	@FindBy(xpath = "//input[@data-better-uid='commodities-section:commodity-pane:commodities-container:commodity-pane:producer-value']")
	WebElementFacade producerValue;
	@FindBy(xpath = "//input[@data-better-uid='commodities-section:commodity-pane:commodities-container:commodity-pane:serial-number']")
	WebElementFacade serialNumber;
	@FindBy(xpath = "//select[@data-better-uid='other-info-section:other-information-pane:internal-code-type']")
	WebElementFacade internalCode;
	@FindBy(xpath = "//input[@data-better-uid='evaluate']")
	WebElementFacade evaluate;

	public void contractFinalization() {
		producerValue.waitUntilPresent();
		producerValue.type("APPLE");
		if (commonPage.waitForPresent(serialNumber, 5)) {
			serialNumber.type(commonPage.randomNumber(10));
		}
		internalCode.selectByValue("1");
		evaluate.click();
	}
}
