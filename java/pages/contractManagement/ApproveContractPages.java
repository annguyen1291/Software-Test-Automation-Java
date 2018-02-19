package eu.company.hosel.bsl.test.pages.contractManagement;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

import eu.company.hosel.bsl.test.BaseSs;
import eu.company.hosel.bsl.test.pages.CommonPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class ApproveContractPages extends PageObject {	

	CommonPage commonPage;
	
	//Assign Contract
	@FindBy(xpath = "//span[contains(text(),'Supervisor')]")
	WebElementFacade supervisor;
	@FindBy(xpath = "//button[@data-automation-id='Supervisor > Assign Contract']")
	WebElementFacade assignContract;
	@FindBy(xpath = "//select[@data-automation-id='Assign contract > Operators']")
	WebElementFacade assignOperator;
	@FindBy(xpath = "//button[@data-automation-id='Assign contract > Yes']")
	
	WebElementFacade assignYes;
	@FindBy(xpath = "//input[@data-automation-id='Operator > Assignment mode AUTOMATIC']")
	WebElementFacade assignAutomatic;
	@FindBy(xpath = "//input[@data-automation-id='Info panel > Next']")
	WebElementFacade assignNext;

	public void assignContract(String contractCode) {
		WebElementFacade selectContract = findBy("//div[contains(text(),'" + contractCode + "')]");			
		while (!commonPage.waitForPresent(selectContract, 5)) {
			supervisor.waitUntilPresent();
			supervisor.click();	
			BaseSs.wait(5);
		}
		selectContract.click();
		assignContract.waitUntilPresent();
		assignContract.click();
		assignOperator.waitUntilPresent();
		assignOperator.selectByValue("0");
		assignYes.waitUntilPresent();
		assignYes.sendKeys(Keys.ENTER);
		assignAutomatic.waitUntilPresent();
		assignAutomatic.click();
		assignNext.waitUntilPresent();
		assignNext.click();
	}
	
	//Verify Phone
	@FindBy(xpath = "//select[@data-result-list='RL_PHONE']")
	WebElementFacade result;
	@FindBy(xpath = "//input[@data-automation-id='Further Verification']")
	WebElementFacade further;
	
	public void verifyPhone() {
		commonPage.waitForPresent(result, 30);		
		result.selectByValue("CA_CONF_SUCC");
		further.click();
	}	
}
