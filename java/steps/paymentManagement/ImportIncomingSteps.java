package eu.company.hosel.bsl.test.steps.paymentManagement;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

import eu.company.hosel.bsl.test.pages.HomePage;
import eu.company.hosel.bsl.test.pages.paymentManagement.ImportIncomingPages;

import org.jbehave.core.annotations.Then;

public class ImportIncomingSteps {
	HomePage homePage;
	ImportIncomingPages importingPaymentPages;
	
	@Given("I am at import incoming payment page")
	public void givenSteps() {
		homePage.clickHomeIcon();
		homePage.clickImportClientPaymentFile();
	}	
	
	@When("I want to import incoming payment")
	public void whenSteps() {
		importingPaymentPages.importIncomingFile();
		importingPaymentPages.browsetIncomingFile();
	}
		
	@Then("I should see incoming payment imported sucessfully")
	public void thenSteps() {
		importingPaymentPages.verifyIncomingPayment();
	}
}