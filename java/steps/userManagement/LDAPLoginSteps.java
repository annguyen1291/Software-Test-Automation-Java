package eu.company.hosel.bsl.test.steps.userManagement;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import eu.company.hosel.bsl.test.pages.userManagement.LDAPLoginPage;

import eu.company.hosel.bsl.test.pages.userManagement.LDAPPages;


public class LDAPLoginSteps {
	LDAPLoginPage LDAPLoginPage;
	LDAPPages LDAPPages;

	@Given("I am at LDAP Login page")
	public void givenSteps() {
		LDAPLoginPage.open();
	}

	@When("I want to login LDAP page")
	public void whenSteps() {
		LDAPLoginPage.loginLDAP();
	}

	@Then("I should see LDAP page")
	public void thenSteps() {
		LDAPPages.verifyLDAPHomePage();
		
	}
}