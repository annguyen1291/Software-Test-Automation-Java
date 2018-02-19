package eu.company.hosel.bsl.test.steps.serenity;

import eu.company.hosel.bsl.test.pages.ClientPage;
import eu.company.hosel.bsl.test.pages.ClientPifPage;
import net.thucydides.core.annotations.Step;

public class ClientSteps {
	
	ClientPifPage clientPifPage;
	ClientPage clientPage;

	@Step
	public void enterClientCuid(String cuid) {
		clientPage.enterSearchClient_CuidNumber(cuid);
	}
	
	@Step
	public void clickButtonSearch() {
		clientPage.clickSearchClient_SearchButton();
	}
	
	@Step
	public void checkClientDetailPageDisplayWithCorrectCuid(String cuid){
		clientPage.checkCuid(cuid);
	}
	
	@Step
	public void checkClientPifPageDisplayCorrectClientCuid(String cuid){
		clientPifPage.checkCuid(cuid);
	}
	
	@Step
	public void clickButtonEditClientName(){
		clientPifPage.clickButtonEdit();
	}
	
	@Step
	public void enterClientFullName(String lastName, String middleName, String firstName){
		clientPifPage.enterPifLastName(lastName);
		clientPifPage.enterPifMiddleName(middleName);
		clientPifPage.enterPifFirstName(firstName);
	}
	
	@Step
	public void clickButtonSaveClientFullName(){
		clientPifPage.clickButtonSave();
	}

	@Step
	public void checkClientFullNameUpdatedAccordinglyAtBif(String lastName, String middleName, String firstName) {
		
		clientPifPage.checkFirstName(firstName);
		clientPifPage.checkLastName(lastName);
		clientPifPage.checkMiddleName(middleName);
	}

	@Step
	public void checkClientFullNameUpdatedAccordinglyAtBsl(String lastName, String middleName, String firstName) {
		clientPage.checkFullName(firstName, lastName, middleName);
		
	}
	
	
}
