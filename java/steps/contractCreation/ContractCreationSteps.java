package eu.company.hosel.bsl.test.steps.contractCreation;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import eu.company.hosel.bsl.test.pages.HomePage;
import eu.company.hosel.bsl.test.pages.contractManagement.ChooseProductPages;
import eu.company.hosel.bsl.test.pages.contractManagement.CreateContractPages;
import eu.company.hosel.bsl.test.pages.contractManagement.ViewContractPages;

public class ContractCreationSteps {
	HomePage homePage;
	ChooseProductPages chooseProductPages;
	CreateContractPages createContractPages;
	ViewContractPages viewContractPages;

	// SM3a.1 Create new CD contract

	@Given("I am at create CD contract page")
	public void chooseCDProduct() {
		chooseProductPages.chooseActiveSaleroom();
		chooseProductPages.chooseCommodity("CC_MOBILE", "CT_MOBILE_1", "10000000");
		chooseProductPages.chooseProduct();
	}

	@Given("I am at create TW contract page")
	public void chooseTWProduct() {
		chooseProductPages.chooseActiveSaleroom();
		chooseProductPages.chooseCommodity("CC_TW", "CT_TW_01", "50000000");
		chooseProductPages.chooseProduct();
	}

	@When("I want to create new contract")
	public void fillInApplication() {
		createContractPages.fillInApplication();
	}

	@Then("I should see new contract created sucessfully")
	public void verifyContract() {
		viewContractPages.verifyContract();
	}
}