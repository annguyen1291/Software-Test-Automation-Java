package eu.company.hosel.bsl.test.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import eu.company.hosel.bsl.test.BaseSs;
import eu.company.hosel.bsl.test.pages.CommonPage;
import eu.company.hosel.bsl.test.pages.HomePage;
import eu.company.hosel.bsl.test.pages.PartnerPage;
import eu.company.hosel.bsl.test.steps.serenity.CommonSteps;
import eu.company.hosel.bsl.test.steps.serenity.HomePageSteps;
import eu.company.hosel.bsl.test.steps.serenity.PartnerSteps;
import net.thucydides.core.annotations.Steps;

public class PartnerStorySteps {
	
	public static String PARTNER_CODE = "";
	
	@Steps
	HomePageSteps homePageSteps;
	
	@Steps
	CommonSteps comSteps;

	HomePage homePage;
	CommonPage comPage;
	
	PartnerPage partnerPage;
	PartnerSteps partnerSteps;
	
	@Given("I am at Search Partner page")
	public void goToSearchPartnerPage() {
		homePage.clickFindPartnerIcon();
	}
	
	@When("I want to search for Partner having code: $code")
	public void searchForPartnerCode(String code) {
		PARTNER_CODE = BaseSs.getDefaultPropertiesData(code, "PARTNER_CODE");
		
		partnerPage.enterPartnerCode(PARTNER_CODE);
		partnerPage.clickButtonSearch();
	}
	
	@Then("I should see Partner detail page display accordingly")
	public void seePartnerDetailPageDisplay() {
		partnerPage.checkPartnerCode(PARTNER_CODE);
	}
	

	@When("I click on tab Contact Information")
	public void goToTabContactInfo() {
		partnerPage.clickTabContacts();
	}
	
	@Then("I should see row data of Contact Information display accordingly")
	public void seeDataTabContactInfo() {
		String data = BaseSs.getPropertiesValue("tabContactData");
		partnerSteps.checkRowDataTableDetail(data);
	}
	

	@When("I click on tab Contact Person")
	public void goToTabContactPerson() {
		partnerPage.clickTabContactPerson();
	}
	
	@Then("I should see row data of Contact Person display accordingly")
	public void seeDataTabContactPerson() {
		String data = BaseSs.getPropertiesValue("tabContactPersonData");
		partnerSteps.checkRowDataTableDetail(data);
	}
	
	@When("I click on tab Addresses")
	public void goToTabAddresses() {
		partnerPage.clickTabAddress();
	}
	
	@Then("I should see row data of Addresses display accordingly")
	public void seeDataTabAddresses() {
		String data = BaseSs.getPropertiesValue("tabAddressData");
		partnerSteps.checkRowDataTableDetail(data);
	}

	@When("I click on tab Bank Accounts")
	public void goToTabBankAccounts() {
		partnerPage.clickTabBank();
	}
	
	@Then("I should see row data of Bank Accounts display accordingly")
	public void seeDataTabBankAccounts() {
		String data = BaseSs.getPropertiesValue("tabBankData");
		partnerSteps.checkRowDataTableDetail(data);
	}
	
	@When("I click on tab Salesrooms")
	public void goToTabSalesrooms() {
		partnerPage.clickTabSalesroom();
	}
	
	@Then("I should see row data of Salesrooms display accordingly")
	public void seeDataTabSalesrooms() {
		String data = BaseSs.getPropertiesValue("tabSalesroomData");
		partnerSteps.checkRowDataTableDetail(data);
	}
	
	@When("I click on tab Extended Properties")
	public void goToTabExtendedProperties() {
		partnerPage.clickTabExtended();
	}
	
	@Then("I should see row data of Extended Properties display accordingly")
	public void seeDataTabExtendedProperties() {
		String data = BaseSs.getPropertiesValue("tabExtendedData");
		partnerSteps.checkRowDataTableDetail(data);
	}
	
}
