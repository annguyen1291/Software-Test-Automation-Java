package eu.company.hosel.bsl.test.pages.userManagement;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

import eu.company.hosel.bsl.test.archive.SM10_LDAP_User;
import eu.company.hosel.bsl.test.pages.CommonPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://um.vn01p.vn.nonprod/user-management/")
public class LDAPPages extends PageObject {
	CommonPage commonPage;

	// Verify LDAP Home Page
	@FindBy(xpath = "//span[@data-better-uid='header-menu:login']")
	WebElementFacade userName;

	public void verifyLDAPHomePage() {
		commonPage.checkDetails(userName, "umc_admin");
	}

	// Verify LDAP Account Page
	@FindBy(xpath = "//a[@data-better-uid='account-create']")
	WebElementFacade accountCreate;
	@FindBy(xpath = "//span[@data-better-uid='panel-title']")
	WebElementFacade accountPageTitle;

	public void verifyLDAPAccountPage() {
		accountCreate.waitUntilPresent();
		accountCreate.click();
		commonPage.checkDetails(accountPageTitle, "Accounts");
	}

	// Account Details
	@FindBy(xpath = "//input[@data-better-uid='detail.name']")
	WebElementFacade detailName;
	@FindBy(xpath = "//input[@data-better-uid='detail.surname']")
	WebElementFacade detailSurname;
	@FindBy(xpath = "//input[@data-better-uid='detail.mail']")
	WebElementFacade detailMail;
	@FindBy(xpath = "//input[@data-better-uid='detail.hr-code']")
	WebElementFacade detailCode;
	@FindBy(xpath = "//input[@data-better-uid='detail.employed-since']")
	WebElementFacade detailSince;
	@FindBy(xpath = "//input[@data-better-uid='detail.login']")
	WebElementFacade detailLogin;
	@FindBy(xpath = "//input[@data-better-uid='detail.pwd']")
	WebElementFacade detailPwd;
	@FindBy(xpath = "//input[@data-better-uid='detail.pwd2']")
	WebElementFacade detailPwd2;

	public void fillInAccountDetails() {
		detailName.waitUntilPresent();
		detailName.type(commonPage.randomCharacter(5));
		detailSurname.type(commonPage.randomCharacter(5));
		detailMail.type(SM10_LDAP_User.EMPLOYEE_CODE + "@company.vn");
		detailCode.type(SM10_LDAP_User.EMPLOYEE_CODE);
		detailSince.type("2017-07-07");
		detailLogin.type(SM10_LDAP_User.EMPLOYEE_CODE);
		detailPwd.type("12345678");
		detailPwd2.type("12345678");
	}

	// Account Roles
	@FindBy(xpath = "//select[@data-better-uid='role-palette:available-field'][1]")
	WebElementFacade firstRole;
	@FindBy(xpath = "//button[@data-better-uid='role-palette:button-add']")
	WebElementFacade buttonAdd;
	@FindBy(xpath = "//button[@data-better-uid='save-button']")
	WebElementFacade saveButton;

	public void fillInAccountRoles() {
		firstRole.click();
		firstRole.sendKeys(Keys.chord(Keys.SHIFT, Keys.END));		
		buttonAdd.click();
		saveButton.click();
	}
	
	// Verify account
	@FindBy(xpath = "//a[@data-better-uid='menu:link-accounts']")
	WebElementFacade accountTab;
	@FindBy(xpath = "//input[@data-better-uid='filter']")
	WebElementFacade filter;
	@FindBy(xpath = "//input[@data-better-uid='submit-button']")
	WebElementFacade submitButton;
	@FindBy(xpath = "//a[@data-better-uid='search-results:account-detail']")
	WebElementFacade accountDetail;
	@FindBy(xpath = "//span[@data-better-uid='employee-number']")
	WebElementFacade employeeNumber;
	@FindBy(xpath = "//span[@data-better-uid='status']")
	WebElementFacade status;
	

	public void verifyAccount() {
		commonPage.waitForPresent(accountTab, 60);
		accountTab.click();		
		filter.waitUntilPresent();
		filter.type(SM10_LDAP_User.EMPLOYEE_CODE);
		submitButton.waitUntilPresent();
		submitButton.click();
		accountDetail.waitUntilPresent();
		accountDetail.click();
		commonPage.checkDetails(employeeNumber, SM10_LDAP_User.EMPLOYEE_CODE);
		commonPage.checkDetails(status, "Active");
	}
}
