package eu.company.hosel.bsl.test.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.FindBy;

import eu.company.hosel.bsl.test.BaseSs;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class ClientPifPage extends PageObject {
	
	
	@FindBy(xpath = "//div[@class='section']//button[contains(text(),'Ok')]")
	WebElementFacade buttonModalOk;
	@FindBy(xpath = "//div[@class='_localeSwitcher dropdown-right']//span[@class='ng-binding']")
	WebElementFacade txtLanguage;
	@FindBy(xpath = "//div[@class='_localeSwitcher dropdown-right']")
	WebElementFacade dropdownLanguage;
	@FindBy(xpath = "//a[@class='ng-binding']/span[@alt='English']")
	WebElementFacade linkEnglish;
	

	@FindBy(xpath = "//div[@data-input-name='externalId']/div//output")
	WebElementFacade txtPifCuid;

	@FindBy(xpath = "//div[@data-input-name='person.birthDate']/div//output")
	WebElementFacade txtPifBirthdate;

	@FindBy(xpath = "//div[@data-input-name='person.lastName']/div//output")
	WebElementFacade txtPifLastName;

	@FindBy(xpath = "//div[@data-input-name='person.middleName']/div//output")
	WebElementFacade txtPifMiddleName;

	@FindBy(xpath = "//div[@data-input-name='person.firstName']/div//output")
	WebElementFacade txtPifFirstName;

	@FindBy(xpath = "//div[@class='form-footer']//button[contains(text(),'Edit')]")
	WebElementFacade buttonEdit;

	@FindBy(xpath = "//div[@class='form-footer']//button[contains(text(),'Save')]")
	WebElementFacade buttonSave;

	@FindBy(xpath = "//div[@data-input-name='person.lastName']//input")
	WebElementFacade inputPifLastName;

	@FindBy(xpath = "//div[@data-input-name='person.middleName']//input")
	WebElementFacade inputPifMiddleName;

	@FindBy(xpath = "//div[@data-input-name='person.firstName']//input")
	WebElementFacade inputPifFirstName;

	@FindBy(xpath = "//div[@data-input-name='person.birthDate']//input")
	WebElementFacade inputPifBirthdate;

	
	// click method
	
	public void clickButtonEdit() {
		buttonEdit.click();
	}

	public void clickButtonSave() {
		buttonSave.click();
	}
	
	public void selectLanguageEnglishIfAny() {
		
		if (txtLanguage.getText().trim().equals("English") == false){
			
			System.out.println("<selectLanguageEnglishIfAny> Switch language to English");
			System.out.println();
			dropdownLanguage.click();
			linkEnglish.click();
			buttonModalOk.click();
			
			// wait ~10s for page reload
			BaseSs.wait(10);
			
		}else{
			System.out.println("<selectLanguageEnglishIfAny> Languguage ready English");
		}
	}
	
	

	// enter method
	
	public void enterPifLastName(String name) {
		inputPifLastName.type(name);
	}

	public void enterPifMiddleName(String name) {
		inputPifMiddleName.type(name);
	}

	public void enterPifFirstName(String name) {
		inputPifFirstName.type(name);
	}

	public void enterPifBirthdate(String date) {
		inputPifBirthdate.type(date);
	}
	
	// get method

	public String getPifFirstName() {
		return txtPifFirstName.getText();
	}

	public String getPifLastName() {
		return txtPifLastName.getText();
	}

	public String getPifMiddleName() {
		return txtPifMiddleName.getText();
	}

	public String getPifCuid() {
		return txtPifCuid.getText();
	}

	public String getPifBirthdate() {
		return txtPifBirthdate.getText();
	}
	
	// check method
	public void checkFirstName(String firstName) {
		BaseSs.checkText(txtPifFirstName, firstName);
	}
	
	public void checkLastName(String lastName) {
		BaseSs.checkText(txtPifLastName, lastName);
	}
	
	public void checkMiddleName(String midName) {
		BaseSs.checkText(txtPifMiddleName, midName);
	}
	
	public void checkCuid(String cuid) {
		BaseSs.checkText(txtPifCuid, cuid);
	}
	
	public void checkCuid(String cuid, int sec) {
		BaseSs.checkText(txtPifCuid, cuid, sec);
	}
	
	public void checkBirthdate(String birthdate) {
		BaseSs.checkText(txtPifBirthdate, birthdate);
	}
	
	

	public boolean isClientCuidMatched(String expectedClientCuid) {

		setImplicitTimeout(15, TimeUnit.SECONDS);
		String actualPifClientCUID = getPifCuid();
		resetImplicitTimeout();

		System.out.println("<isClientCuidMatched> actual CUID: " + actualPifClientCUID + "; Compare to expected CUID: "
				+ expectedClientCuid);
		boolean result = actualPifClientCUID.equals(expectedClientCuid);
		System.out.println("<isClientCuidMatched> Result: " + result);

		return result;
	}

	public boolean isClientBirthdateMatched(String expectedBirthdate) {
		setImplicitTimeout(15, TimeUnit.SECONDS);
		String actualPifClientBD = getPifBirthdate();
		resetImplicitTimeout();

		System.out.println("<isClientBirthdateMatched> actual CUID: " + actualPifClientBD
				+ "; Compare to expected CUID: " + expectedBirthdate);
		boolean result = actualPifClientBD.equals(expectedBirthdate);
		System.out.println("<isClientBirthdateMatched> Result: " + result);

		return result;
	}

}
