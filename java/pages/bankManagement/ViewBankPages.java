package eu.company.hosel.bsl.test.pages.bankManagement;

import org.openqa.selenium.support.FindBy;

import eu.company.hosel.bsl.test.pages.CommonPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class ViewBankPages extends PageObject {

	CommonPage commonPage;
	
	//Common elements
	
	@FindBy(xpath = "//span[@data-uid='detail-content:name']")
	WebElementFacade txtName;

	@FindBy(xpath = "//span[@data-uid='detail-content:code']")
	WebElementFacade txtCode;
	
	@FindBy(xpath = "//span[@data-uid='detail-content:status']")
	WebElementFacade txtStatus;
	
	//Bank elements
	
	@FindBy(xpath = "//div[@data-uid='bank-detail-container']/h1")
	WebElementFacade txtBankTitle;
	
	@FindBy(xpath = "//span[@data-uid='detail-content:dd-due-date-offset']")
	WebElementFacade txtDueDateOffset;
	
	@FindBy(xpath = "//a[@data-uid='bank-detail-tabbed-panel:bank-detail-tabbed-panel:panel:bank-branch-create-link']")
	WebElementFacade btnCreateBranch;
	
	@FindBy(xpath = "//a[@data-uid='bank-detail-container:button-panel:1:button']")
	WebElementFacade btnUpdateBank;	
	
	@FindBy(xpath = "//a[@data-uid='bank-detail-tabbed-panel:bank-detail-tabbed-panel:panel:table:body:1:7:0']")
	WebElementFacade btnUpdateBranch;
	
	//Branch elements
	
	@FindBy(xpath = "//div[@data-uid='bank-branch-detail-container']/h1")
	WebElementFacade txtBranchTitle;
	
	@FindBy(xpath = "//span[@data-uid='detail-content:address.region-code']")
	WebElementFacade txtAddressRegionCode;
	
	@FindBy(xpath = "//span[@data-uid='detail-content:address.district-code']")
	WebElementFacade txtAddressDistrictCode;
	
	@FindBy(xpath = "//a[@data-uid='branch-branch-detail-container:button-panel:2:button']")
	WebElementFacade btnBankDetails;
	
	//Bank methods
	
	public void verifyBank(String code, String status, String dueDateOffset) {
		System.out.println("[verifyBank] Check if the page in view is current then verify the bank details");
		
		if (commonPage.isViewPageCurrent(txtBankTitle, "Bank Detail")){
			
			System.out.println("[verifyBank] checkDetails() BankCode: " + code);
			commonPage.checkDetails(txtCode, code);
			
			System.out.println("[verifyBank] checkDetails() BankName: " + "AUTO_BANK_" + code);
			commonPage.checkDetails(txtName, "AUTO_BANK_" + code);
			
			System.out.println("[verifyBank] checkDetails() BankStatus: " + status);
			commonPage.checkDetails(txtStatus, status);
			
			System.out.println("[verifyBank] checkDetails() DueDateOffset: " + dueDateOffset);
			commonPage.checkDetails(txtDueDateOffset, dueDateOffset);
			
		}else{
			
			// throw some error here and 
			System.out.println("[ERRORCODE: NAVIGATION_WRONG] " + "BankViewPage.checkBankDetails()");
		}
	}
	
	public void createBranch() {
		btnCreateBranch.click();
	}
	
	public void clickUpdateBank() {
		btnUpdateBank.click();
	}
	
	public void clickUpdateBranch() {
		btnUpdateBranch.click();
	}
	
	//Branch methods
	
	public void verifyBranch(String code, String status, String region, String district) {
		System.out.println("[verifyBranch] Check if the page in view is current then verify the branch details");
		
		if (commonPage.isViewPageCurrent(txtBranchTitle, "Bank branch detail")){
			
			System.out.println("[verifyBranch] checkDetails() BranchCode: " + code);
			commonPage.checkDetails(txtCode, code);
			
			System.out.println("[verifyBranch] checkDetails() BranchName: " + "AUTO_BRANCH_" + code);
			commonPage.checkDetails(txtName, "AUTO_BRANCH_" + code);
			
			System.out.println("[verifyBranch] checkDetails() BranchStatus: " + status);
			commonPage.checkDetails(txtStatus, status);
			
			System.out.println("[verifyBranch] checkDetails() Region: " + region);
			commonPage.checkDetails(txtAddressRegionCode, region);
			
			System.out.println("[verifyBranch] checkDetails() District: " + district);
			commonPage.checkDetails(txtAddressDistrictCode, district);
			
		}else{
			
			// throw some error here and 
			System.out.println("[ERRORCODE: NAVIGATION_WRONG] " + "BranchViewPage.checkBranchDetails()");
		}
	}
}
