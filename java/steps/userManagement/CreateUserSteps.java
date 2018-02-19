package eu.company.hosel.bsl.test.steps.userManagement;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import eu.company.hosel.bsl.test.pages.userManagement.LDAPPages;

public class CreateUserSteps {
	LDAPPages LDAPPages;

	@Given("I am at create user page")
	public void givenSteps() {
		LDAPPages.verifyLDAPAccountPage();
	}

	@When("I want to create user")
	public void whenSteps() {
		LDAPPages.fillInAccountDetails();
		LDAPPages.fillInAccountRoles();
		}

	@Then("I should see user created sucessfully")
	public void thenSteps() {
		LDAPPages.verifyAccount();
	}
}