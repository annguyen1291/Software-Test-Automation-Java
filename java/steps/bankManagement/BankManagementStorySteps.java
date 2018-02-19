package eu.company.hosel.bsl.test.steps.bankManagement;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import eu.company.hosel.bsl.test.archive.SM02_BSL_Bank;
import eu.company.hosel.bsl.test.pages.HomePage;
import eu.company.hosel.bsl.test.pages.bankManagement.CreateBankPages;
import eu.company.hosel.bsl.test.pages.bankManagement.ViewBankPages;

public class BankManagementStorySteps {

	HomePage homePage;
	CreateBankPages createUpdatePages;
	ViewBankPages viewPages;
	
	//SM1.1 Create new bank
	
	@Given("I am at create bank page")
	public void clickCreateBankIcon() {
		homePage.clickCreateBankIcon();		
	}

	@When("I want to create new bank")
	public void createBank() {
		createUpdatePages.createBank();		
	}

	@Then("I should see new bank created sucessfully")
	public void verifyNewBank() {
		viewPages.verifyBank(SM02_BSL_Bank.CODE1, "Active", "0");		
	}
	
	//SM1.2 Create new branch
	
	@Given("I am at create branch page")
	public void clickCreateBranch() {
		viewPages.createBranch();		
	}

	@When("I want to create new branch")
	public void createBranch() {
		createUpdatePages.createBranch();		
	}

	@Then("I should see new branch created sucessfully")
	public void verifyNewBranch() {
		viewPages.verifyBranch(SM02_BSL_Bank.CODE1, "Active", "Hà Nội", "Q. Ba Đình");		
	}
	
	//SM1.3 Update existing bank
	
	@Given("I am at update bank page")
	public void clickUpdateBank() {
		homePage.clickHomeIcon();
		homePage.clickFindBankIcon();
		createUpdatePages.findBank();
		viewPages.clickUpdateBank();		
	}
	
	@When("I want to update existing bank")
	public void updateBank() {
		createUpdatePages.updateBank();		
	}

	@Then("I should see existing bank updated sucessfully")
	public void verifyExistingBank() {
		viewPages.verifyBank(SM02_BSL_Bank.CODE2, "Disable", "5");		
	}
	
	//SM1.4 Update existing branch
	
	@Given("I am at update branch page")
	public void clickUpdateBranch() {
		viewPages.clickUpdateBranch();		
	}
	
	@When("I want to update existing branch")
	public void updateBranch() {
		createUpdatePages.updateBranch();		
	}

	@Then("I should see existing branch updated sucessfully")
	public void verifyExistingBranch() {
		viewPages.verifyBranch(SM02_BSL_Bank.CODE2, "Disabled", "Hà Nội", "Q. Đống Đa");		
	}
}