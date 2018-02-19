package eu.company.hosel.bsl.test.steps.paymentManagement;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import eu.company.hosel.bsl.test.pages.HomePage;
import eu.company.hosel.bsl.test.pages.contractManagement.SearchForContract;
import eu.company.hosel.bsl.test.pages.contractManagement.ViewContractPages;
import eu.company.hosel.bsl.test.pages.paymentManagement.DecoupleIncomingPages;

public class DecoupleIncomingSteps {
	HomePage homePage;
	DecoupleIncomingPages decoupleIncomingPages;
	SearchForContract searchForContract;
	ViewContractPages viewContractPages;

	@Given("I am at search incoming payment page")
	public void giveSteps() {
		homePage.clickHomeIcon();
		homePage.clickBrowseIncomingPaymentIcon();
		decoupleIncomingPages.searchIncomingPayment();
	}

	@When("I want to decouple incoming payment")
	public void whensteps() {
		decoupleIncomingPages.decoupleIncomingPayment();
	}

	@Then("I should see incoming payment decoupled sucessfully")
	public void thenSteps() {
		decoupleIncomingPages.verifyDecoupledPayment();
	}
}