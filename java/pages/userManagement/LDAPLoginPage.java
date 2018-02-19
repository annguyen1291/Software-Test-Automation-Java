package eu.company.hosel.bsl.test.pages.userManagement;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://um.vn01p.vn.nonprod/user-management/")
public class LDAPLoginPage extends PageObject {

	@FindBy(xpath = "//input[@type='submit']")
	WebElementFacade btnLogin;
	@FindBy(id = "IDToken1")
	WebElementFacade inputUsername;
	@FindBy(id = "IDToken2")
	WebElementFacade inputPassword;

	public void loginLDAP() {
		inputUsername.waitUntilPresent();
		inputUsername.type("umc_admin");
		inputPassword.type("hDkjw0JxpeIe");
		btnLogin.click();
	}
}
