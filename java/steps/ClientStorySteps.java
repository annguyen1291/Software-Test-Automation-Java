package eu.company.hosel.bsl.test.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import eu.company.hosel.bsl.test.BaseSs;
import eu.company.hosel.bsl.test.pages.ClientPage;
import eu.company.hosel.bsl.test.pages.ClientPifPage;
import eu.company.hosel.bsl.test.pages.CommonPage;
import eu.company.hosel.bsl.test.pages.HomePage;
import eu.company.hosel.bsl.test.steps.serenity.ClientSteps;
import eu.company.hosel.bsl.test.steps.serenity.CommonSteps;
import eu.company.hosel.bsl.test.steps.serenity.HomePageSteps;
import net.thucydides.core.annotations.Steps;

public class ClientStorySteps {

	@Steps
	ClientSteps clientSteps;
	
	@Steps
	HomePageSteps homePageSteps;
	
	@Steps
	CommonSteps comSteps;

	ClientPage clientPage;
	ClientPifPage clientPifPage;

	HomePage homePage;
	CommonPage comPage;

	// public static String CLIENT_CONTRACT_NUMBER = "";
	public static String CLIENT_CUID_NUMBER = "";
	public static String CLIENT_BIRTHDATE = "";

	public static String lastName = "LNAME", middleName = "MIDNAME", firstName = "FNAME";
	int numberOfChar = 5;

	@Given("I am at Search Client page")
	public void goToSearchClientPage() {
		homePage.clickSearchClientIcon();
	}

	@When("I want to search for Client having CUID number: $cuid")
	public void enterSearchClientContractNumber(String cuid) {

		String dataCuid = BaseSs.getDefaultPropertiesData(cuid, "CLIENT_CUID_NUMBER");
		System.out.println("[enterSearchClientContractNumber] CLIENT_CUID_NUMBER: " + dataCuid);

		clientSteps.enterClientCuid(dataCuid);

		// keep data public to check again later on PIF
		CLIENT_CUID_NUMBER = dataCuid;

		clientSteps.clickButtonSearch();
	}

	@Then("I should see client detail page display accordingly")
	public void checkClientDetailPageDisplayWithCorrectCuid() {
		clientSteps.checkClientDetailPageDisplayWithCorrectCuid(CLIENT_CUID_NUMBER);
	}

	@When("I click on button Manage Client")
	public void goToManageClientPifPage() {
		clientPage.clickLinkManageClient();
		BaseSs.wait(15);
		clientPifPage.selectLanguageEnglishIfAny();
	}

	@Then("I should see PIF page open with same client info at BSL")
	public void checkClientPifPageDisplayCorrectClientInfo() {
		clientSteps.checkClientPifPageDisplayCorrectClientCuid(CLIENT_CUID_NUMBER);
	}

	@When("I want to update client basic info at PIF")
	public void updateClientBasicInfoAtPif() {
		
		clientSteps.clickButtonEditClientName();

		lastName = lastName + BaseSs.genRandomCharacter(numberOfChar);
		middleName = middleName + BaseSs.genRandomCharacter(numberOfChar);
		firstName = firstName + BaseSs.genRandomCharacter(numberOfChar);

		clientSteps.enterClientFullName(lastName, middleName, firstName);
		
		clientSteps.clickButtonSaveClientFullName();
	}

	@Then("I should see basic info updated accordingly at BIF")
	public void checkBasicInfoUpdateAtBif() {
		clientSteps.checkClientFullNameUpdatedAccordinglyAtBif(lastName, middleName, firstName);
	}

	@Given("Now swicth back to BSL system")
	public void switchBackToBSLHomePage() {
		comSteps.switchBackToBSLHomePage();

		homePageSteps.checkCurrentHomepageLanding();
	}

	@Then("I should see client basic info updated at BSL same as BIF")
	public void checkBasicInfoUpdateAtBsl() {

		clientSteps.checkClientDetailPageDisplayWithCorrectCuid(CLIENT_CUID_NUMBER);
		// clientPage.checkContract(CLIENT_CONTRACT_NUMBER);

		clientSteps.checkClientFullNameUpdatedAccordinglyAtBsl(lastName, middleName, firstName);

	}

}
