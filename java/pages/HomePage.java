package eu.company.hosel.bsl.test.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

	@FindAll({ @FindBy(xpath = "//div[@class='menu-row']//div[@class='title']"), })
	List<WebElement> listSevenHomePageAreaTitle;

	public boolean isHomePageCurrentDisplayed() {
		boolean result1 = false, result2 = false;

		int size = listSevenHomePageAreaTitle.size();

		result1 = (size == 7) ? true : false;
		result2 = listSevenHomePageAreaTitle.get(0).getText().equals("Administration");

		return result1 & result2;
	}

	public void checkHomePageCurrentDisplayed() {
		assertTrue(isHomePageCurrentDisplayed());
	}

	// Header Menu
	@FindBy(xpath = "//a[@data-uid='home']")
	WebElementFacade lnkHome;

	public void clickHomeIcon() {
		lnkHome.waitUntilPresent();
		lnkHome.sendKeys(Keys.ENTER);
	}

	@FindBy(xpath = "//a[@data-uid='logout']")
	WebElementFacade lnkLogout;

	public boolean isLinkLogoutExist() {
		return lnkLogout.isCurrentlyVisible();
	}

	@FindBy(xpath = "//span[@data-uid='login-info:user-name']")
	WebElementFacade txtUserName;

	public boolean isUserNameMatched(String userName) {
		txtUserName.waitUntilVisible();
		String actualUserName = txtUserName.getText();
		System.out.println("<checkUserName> actualUserName: " + actualUserName);
		System.out.println("<checkUserName> expectUserName: " + userName);
		return userName.equals(actualUserName);
	}

	// Administration
	@FindBy(xpath = "//a[@data-uid='menu:1:1:1:target']")
	WebElementFacade userSettings;

	public void clickUserSettings() {
		userSettings.waitUntilPresent();
		userSettings.sendKeys(Keys.ENTER);
	}

	@FindBy(xpath = "//a[@data-uid='menu:1:1:2:target']")
	WebElementFacade createBankIcon;

	public void clickCreateBankIcon() {
		createBankIcon.waitUntilPresent();
		createBankIcon.sendKeys(Keys.ENTER);
	}

	@FindBy(xpath = "//a[@data-uid='menu:1:2:1:target']")
	WebElementFacade findBankIcon;

	public void clickFindBankIcon() {
		findBankIcon.waitUntilPresent();
		findBankIcon.sendKeys(Keys.ENTER);
	}

	// Contract Management
	@FindBy(xpath = "//a[@data-uid='menu:2:1:1:target']")
	WebElementFacade createContractIcon;

	public void clickCreateContractIcon() {
		createContractIcon.waitUntilPresent();
		createContractIcon.sendKeys(Keys.ENTER);
	}

	@FindBy(xpath = "//a[@data-uid='menu:2:2:1:target']")
	WebElementFacade searchContractIcon;

	public void clickSearchContractIcon() {
		searchContractIcon.waitUntilPresent();
		searchContractIcon.sendKeys(Keys.ENTER);
	}

	// Product & Services
	@FindBy(xpath = "//a[@id='UC02_090']")
	WebElementFacade manageProductIcon;

	public void clickManageProductIcon() {
		manageProductIcon.waitUntilVisible();
		manageProductIcon.sendKeys(Keys.ENTER);
	}

	// SNM
	@FindBy(xpath = "//a[@data-uid='menu:7:1:1:target']")
	WebElementFacade searchClientIcon;

	public void clickSearchClientIcon() {
		searchClientIcon.sendKeys(Keys.ENTER);
	}

	@FindBy(xpath = "//a[@data-uid='menu:4:2:2:target']")
	WebElementFacade findSaleRoomIcon;

	public void clickFindSaleRoomIcon() {
		findSaleRoomIcon.waitUntilVisible();
		findSaleRoomIcon.sendKeys(Keys.ENTER);
	}

	@FindBy(xpath = "//a[@data-uid='menu:4:2:1:target']")
	WebElementFacade findPartnerIcon;

	public void clickFindPartnerIcon() {
		findPartnerIcon.sendKeys(Keys.ENTER);
	}

	// Payments
	@FindBy(xpath = "//a[@data-uid='menu:5:2:1:target']")
	WebElementFacade createIncomingPaymentIcon;

	public void clickCreateIncomingPaymentIcon() {
		createIncomingPaymentIcon.waitUntilPresent();
		createIncomingPaymentIcon.sendKeys(Keys.ENTER);
	}

	@FindBy(xpath = "//a[@data-uid='menu:5:1:2:target']")
	WebElementFacade browseIncomingPaymentIcon;

	public void clickBrowseIncomingPaymentIcon() {
		browseIncomingPaymentIcon.waitUntilPresent();
		browseIncomingPaymentIcon.sendKeys(Keys.ENTER);
	}

	@FindBy(xpath = "//a[@data-uid='menu:5:3:1:target']")
	WebElementFacade browseOutgoingPayments;

	public void clickBrowseOutgoingPayments() {
		browseOutgoingPayments.waitUntilPresent();
		browseOutgoingPayments.sendKeys(Keys.ENTER);
	}

	@FindBy(xpath = "//a[@data-uid='menu:5:1:1:target']")
	WebElementFacade importClientPaymentFile;

	public void clickImportClientPaymentFile() {
		importClientPaymentFile.waitUntilPresent();
		importClientPaymentFile.sendKeys(Keys.ENTER);
	}

	@FindBy(xpath = "//a[@data-uid='menu:5:2:2:target']")
	WebElementFacade browseIncomingPaymentFiles;

	public void clickBrowseIncomingPaymentFiles() {
		browseIncomingPaymentFiles.waitUntilPresent();
		browseIncomingPaymentFiles.sendKeys(Keys.ENTER);
	}

	// Ticketing

	// Client Center
}
