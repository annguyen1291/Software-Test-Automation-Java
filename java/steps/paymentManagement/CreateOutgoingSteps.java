package eu.company.hosel.bsl.test.steps.paymentManagement;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

import eu.company.hosel.bsl.test.pages.HomePage;
import eu.company.hosel.bsl.test.pages.paymentManagement.CreateOutgoingPages;

import org.jbehave.core.annotations.Then;

public class CreateOutgoingSteps {
	HomePage homePage;
	CreateOutgoingPages outgoingPaymentPages;
	
	@Given("I am at create outgoing payment page")
	public void givenSteps() {
		homePage.clickHomeIcon();
		homePage.clickBrowseOutgoingPayments();
	}	
	
	@When("I want to create outgoing payment")
	public void whenSteps() {
		outgoingPaymentPages.browseOutgoing("INS");
		outgoingPaymentPages.selectOutgoing();
		outgoingPaymentPages.generateOrders();
	}
		
	@Then("I should see outgoing payment created sucessfully")
	public void thenSteps() {
		outgoingPaymentPages.searchOutgoing("INS");
		outgoingPaymentPages.checkOutgoing("Premium to insurance company");
	}
}