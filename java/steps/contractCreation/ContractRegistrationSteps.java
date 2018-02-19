package eu.company.hosel.bsl.test.steps.contractCreation;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import eu.company.hosel.bsl.test.pages.HomePage;
import eu.company.hosel.bsl.test.pages.contractManagement.ChooseProductPages;
import eu.company.hosel.bsl.test.pages.contractManagement.CreateContractPages;
import eu.company.hosel.bsl.test.pages.contractManagement.ViewContractPages;

public class ContractRegistrationSteps {
	HomePage homePage;
	ChooseProductPages chooseProductPages;
	CreateContractPages createContractPages;
	ViewContractPages viewContractPages;
	
	//SM3a.2 Create new CD contract
	
	@Given("I have approved contract automatically or manually")
	public void approveContract() {
		viewContractPages.verifyApproved();
	}
	
	@When("I want to sign and register contract")
	public void signRegisterContract() {	
		viewContractPages.signContract();
		viewContractPages.verifySigned();
		viewContractPages.registerContract();	
	}
	@Then("I should see contract registered sucessfully")
	public void verifyRegistered() {
		viewContractPages.verifyRegistered();
	}
	
}