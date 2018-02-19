package eu.company.hosel.bsl.test.pages.contractCreation;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

import eu.company.hosel.bsl.test.BaseSs;
import eu.company.hosel.bsl.test.pages.CommonPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class ViewContractPages extends PageObject {

	CommonPage commonPage;
	ApproveContractPages approveContractPages;

	@FindBy(xpath = "//span[@data-uid='contract-detail-panel:status']")
	WebElementFacade txtContractStatus;
	@FindBy(xpath = "//span[@data-uid='contract-detail-panel:contract-code']")
	WebElementFacade txtContractCode;
	@FindBy(xpath = "//div[@id='content']//h1")
	WebElementFacade txtContractTitle;

	// Verify Contract
	@FindBy(xpath = "//a[@data-uid='refresh-evaluation-information']")
	WebElementFacade refreshEvaluation;

	public void verifyContract() {
		commonPage.waitForPresent(txtContractTitle, 30);
		if (commonPage.isViewPageCurrent(txtContractTitle, "Contract detail")) {
			System.out.println("[verifyContract] checkDetails() ContractStatus: " + txtContractStatus);
		} else {
			// throw some error here and
			System.out.println("[ERRORCODE: NAVIGATION_WRONG] " + "ViewContractPages.verifyContract()");
		}
	}

	// Approve Contract
	public void verifyApproved() {
		commonPage.waitForPresent(txtContractCode, 30);
		String contractCode = txtContractCode.getText();
		if (BaseSs.isTestEnvi()) {
			while (txtContractStatus.getText().equals("In Process")) {
				refreshEvaluation.waitUntilPresent();
				refreshEvaluation.click();
				txtContractStatus.waitUntilPresent();
				BaseSs.wait(1);
			}			
		} else {
			String contractUrl = getDriver().getCurrentUrl();
			getDriver().get("https://lap.vn01p.vn.nonprod/lap/");
			approveContractPages.assignContract(contractCode);
			approveContractPages.verifyPhone();
			BaseSs.wait(5);
			getDriver().get(contractUrl);
			commonPage.waitForPresent(txtContractCode, 30);
		}
		System.out.println("[verifyApproved] verifyApproved() Contract Status: " + txtContractStatus);
		commonPage.checkDetails(txtContractStatus, "Approved");
	}

	// Sign Contract
	@FindBy(xpath = "//a[@data-uid='sign-contract']")
	WebElementFacade signContract;
	@FindBy(xpath = "//a[@data-uid='prepare-materials']")
	WebElementFacade prepareMaterials;
	@FindBy(xpath = "//a[@data-uid='prepare-materials:yes']")
	WebElementFacade prepareMaterialsYes;
	@FindBy(xpath = "//a[@data-uid='materials-prepared:ok']")
	WebElementFacade prepareMaterialsOk;
	@FindBy(xpath = "//input[@data-uid='contract-signed']")
	WebElementFacade contractSigned;
	@FindBy(xpath = "//input[@data-uid='sign-on-back-office-window:dialog:button-panel:ok']")
	WebElementFacade buttonPanelOk;

	public void signContract() {
		commonPage.waitForPresent(signContract, 30);
		signContract.click();
		prepareMaterials.waitUntilPresent();
		prepareMaterials.click();
		prepareMaterialsYes.waitUntilPresent();
		prepareMaterialsYes.click();
		commonPage.waitForPresent(prepareMaterialsOk, 30);
		prepareMaterialsOk.click();
		contractSigned.waitUntilEnabled();
		contractSigned.click();
		signContract.waitUntilEnabled();
		signContract.click();
		commonPage.waitForPresent(buttonPanelOk, 30);
		buttonPanelOk.click();
	}

	public void verifySigned() {
		commonPage.waitForPresent(txtContractStatus, 30);
		System.out.println("[verifySigned] checkDetails() Contract Status: " + txtContractStatus);
		commonPage.checkDetails(txtContractStatus, "Signed");
	}

	// Register Contract
	@FindBy(xpath = "//a[@data-better-uid='contract-detail-tabbed-panel:tabs-container:contract-detail-registration-tab-panel-tab-link']")
	WebElementFacade registrationTab;
	@FindBy(xpath = "//input[@data-uid='contract-detail-tabbed-panel:contract-detail-tabbed-panel:panel:contract-detail-registration-container-panel:contract-detail-registration-document-list-pane:1:contract-detail-registration-document-item-detail-pane:document-check']")
	WebElementFacade documentItem1;
	@FindBy(xpath = "//input[@data-uid='contract-detail-tabbed-panel:contract-detail-tabbed-panel:panel:contract-detail-registration-container-panel:contract-detail-registration-document-list-pane:2:contract-detail-registration-document-item-detail-pane:document-check']")
	WebElementFacade documentItem2;
	@FindBy(xpath = "//input[@data-uid='contract-detail-tabbed-panel:contract-detail-tabbed-panel:panel:contract-detail-registration-container-panel:contract-detail-registration-document-list-pane:3:contract-detail-registration-document-item-detail-pane:document-check']")
	WebElementFacade documentItem3;
	@FindBy(xpath = "//input[@data-uid='contract-detail-tabbed-panel:contract-detail-tabbed-panel:panel:contract-detail-registration-container-panel:contract-detail-registration-document-list-pane:4:contract-detail-registration-document-item-detail-pane:document-check']")
	WebElementFacade documentItem4;
	@FindBy(xpath = "//input[@data-uid='contract-detail-tabbed-panel:contract-detail-tabbed-panel:panel:contract-detail-registration-container-panel:contract-detail-registration-document-list-pane:5:contract-detail-registration-document-item-detail-pane:document-check']")
	WebElementFacade documentItem5;
	@FindBy(xpath = "//input[@data-uid='contract-detail-tabbed-panel:contract-detail-tabbed-panel:panel:contract-detail-registration-container-panel:contract-detail-registration-document-list-pane:6:contract-detail-registration-document-item-detail-pane:document-check']")
	WebElementFacade documentItem6;
	@FindBy(xpath = "//a[@data-uid='contract-detail-tabbed-panel:contract-detail-tabbed-panel:panel:register-contract']")
	WebElementFacade registerContract;
	@FindBy(xpath = "//a[@data-uid='modal:ok']")
	WebElementFacade modalOk;

	public void registerContract() {
		commonPage.waitForPresent(registrationTab, 30);
		registrationTab.sendKeys(Keys.ENTER);
		commonPage.waitForAjaxComplete();
		documentItem1.sendKeys(Keys.SPACE);
		commonPage.waitForAjaxComplete();
		documentItem2.sendKeys(Keys.SPACE);
		commonPage.waitForAjaxComplete();
		documentItem3.sendKeys(Keys.SPACE);
		commonPage.waitForAjaxComplete();
		documentItem4.sendKeys(Keys.SPACE);
		if (commonPage.waitForPresent(documentItem5, 1)) {
			documentItem5.sendKeys(Keys.SPACE);
		}
		if (commonPage.waitForPresent(documentItem6, 1)) {
			documentItem6.sendKeys(Keys.SPACE);
		}
		BaseSs.wait(5);
		registerContract.sendKeys(Keys.ENTER);
		commonPage.waitForPresent(modalOk, 30);
		modalOk.click();
	}

	public void verifyRegistered() {
		commonPage.waitForPresent(txtContractStatus, 30);
		System.out.println("[verifyActive] checkDetails() Contract Status: " + txtContractStatus);
		commonPage.checkDetails(txtContractStatus, "Active");
	}
}
