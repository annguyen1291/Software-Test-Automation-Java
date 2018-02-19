package eu.company.hosel.bsl.test.pages.bankManagement;

import org.openqa.selenium.support.FindBy;

import eu.company.hosel.bsl.test.archive.SM02_BSL_Bank;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class CreateBankPages extends PageObject {
	
	//Common elements

	@FindBy(xpath = "//input[@data-uid='code']")
	WebElementFacade code;

	@FindBy(xpath = "//input[@data-uid='name']")
	WebElementFacade name;
	
	@FindBy(xpath = "//select[@data-uid='status']")
	WebElementFacade status;
	
	@FindBy(xpath = "//input[@data-uid='button-panel:ok']")
	WebElementFacade buttonPanelOk;
	
	@FindBy(xpath = "//a[@data-uid='modal:yes']")
	WebElementFacade modalYes;
	
	//Bank elements

	@FindBy(xpath = "//input[@data-uid='dd-due-date-offset']")
	WebElementFacade dueDateOffset;
	
	@FindBy(xpath = "//input[@data-uid='button-panel:search']")
	WebElementFacade buttonPanelSearch;
	
	@FindBy(xpath = "//a[@data-uid='search-result-panel:search-result-table:action-column:0']")
	WebElementFacade searchResultPanel;
	
	//Branch element
	
	@FindBy(xpath = "//select[@data-uid='address.region-code']")
	WebElementFacade addressRegionCode;
	
	@FindBy(xpath = "//select[@data-uid='address.district-code']")
	WebElementFacade addressDistrictCode;
	
	@FindBy(xpath = "//select[@data-uid='address.district-code']/option[@value='HN_BD']")
	WebElementFacade addressDistrictCodeOption;
	
	//Bank methods
	
	public void createBank() {
		code.type(SM02_BSL_Bank.CODE1);
		name.type("AUTO_BANK_" + SM02_BSL_Bank.CODE1);
		status.selectByValue("ACTIVE");
		dueDateOffset.type("0");
		buttonPanelOk.click();
	}
	
	public void updateBank() {		
		code.type(SM02_BSL_Bank.CODE2);
		name.type("AUTO_BANK_" + SM02_BSL_Bank.CODE2);
		status.selectByValue("DISABLED");
		dueDateOffset.type("5");
		buttonPanelOk.click();
		modalYes.waitUntilPresent();
		modalYes.click();
	}

	public void findBank() {		
		code.type(SM02_BSL_Bank.CODE1);
		name.type("AUTO_BANK_" + SM02_BSL_Bank.CODE1);
		status.selectByValue("ACTIVE");
		buttonPanelSearch.click();
		searchResultPanel.waitUntilPresent();
		searchResultPanel.click();
	}
	
	//Branch methods
	
	public void createBranch() {
		addressRegionCode.selectByValue("HN");
		code.type(SM02_BSL_Bank.CODE1);
		name.type("AUTO_BRANCH_" + SM02_BSL_Bank.CODE1);
		status.selectByValue("ACTIVE");				
		addressDistrictCodeOption.waitUntilPresent();
		addressDistrictCode.selectByValue("HN_BD");
		buttonPanelOk.click();
	}
		
	public void updateBranch() {		
		code.type(SM02_BSL_Bank.CODE2);
		name.type("AUTO_BRANCH_" + SM02_BSL_Bank.CODE2);
		addressDistrictCode.selectByValue("HN_DD");
		buttonPanelOk.click();
	}
}
