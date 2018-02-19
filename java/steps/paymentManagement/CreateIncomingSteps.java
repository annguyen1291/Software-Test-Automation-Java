package eu.company.hosel.bsl.test.steps.paymentManagement;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import eu.company.hosel.bsl.test.pages.HomePage;
import eu.company.hosel.bsl.test.pages.contractManagement.SearchForContract;
import eu.company.hosel.bsl.test.pages.contractManagement.ViewContractPages;
import eu.company.hosel.bsl.test.pages.paymentManagement.CreateIncomingPages;

public class CreateIncomingSteps {
	HomePage homePage;
	CreateIncomingPages createIncomingPaymentPages;
	SearchForContract searchForContract;
	ViewContractPages viewContractPages;

	@Given("I am at create incoming payment page")
	public void givenSteps() {
		// Search for contract
		homePage.clickSearchContractIcon();
		searchForContract.searchContractByContractStatus("A");
		searchForContract.selectContract();

		// Installment schedule
		viewContractPages.getInstallmentInformation();
		homePage.clickHomeIcon();
		homePage.clickCreateIncomingPaymentIcon();
	}

	@When("I want to create incoming payment")
	public void whenSteps() {
		createIncomingPaymentPages.createIncomingPayment();
		}

	@Then("I should see incoming payment created sucessfully")
	public void thenSteps() {
		createIncomingPaymentPages.verifyIncomingPayment();
	}
}