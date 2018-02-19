package eu.company.hosel.bsl.test.pages;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class ProductViewPage extends PageObject {

	String pageTitle = "Product";
	String strActiveStatus = "Active";
	String strInactiveStatus = "Inactive";

	@FindBy(xpath = "//div[@data-uid='product-detail-container']/h1")
	WebElementFacade txtPageTitle;

	@FindBy(xpath = "//a[@data-uid='product-detail-container:button-panel:1:button']")
	WebElementFacade buttonActivate;

	@FindBy(xpath = "//a[@data-uid='product-detail-container:button-panel:3:button']")
	WebElementFacade buttonCopyProduct;

	@FindBy(xpath = "//a[@data-uid='product-detail-container:button-panel:4:button']")
	WebElementFacade buttonNewVersion;

	@FindBy(xpath = "//span[@data-uid='detail-content:code']")
	WebElementFacade txtProductCode;

	@FindBy(xpath = "//span[@data-uid='detail-content:name']")
	WebElementFacade txtProductName;

	@FindBy(xpath = "//span[@data-uid='detail-content:product-version']")
	WebElementFacade txtProductVersion;

	@FindBy(xpath = "//span[@data-uid='detail-content:valid-from']")
	WebElementFacade txtProductValidFrom;

	@FindBy(xpath = "//span[@data-uid='detail-content:version-status']")
	WebElementFacade txtVersionStatus;

	@FindBy(xpath = "//input[@type='text' and @data-uid='modal:dialog:product-code']")
	WebElementFacade inputProductCode;

	@FindBy(xpath = "//input[@type='submit' and @data-uid='modal:dialog:button-panel:ok']")
	WebElementFacade buttonOKCopyProduct;

	@FindBy(xpath = "//div[@data-better-uid='modal:dialog' and contains(@style,'display: block;')]//a[@data-better-uid='modal:dialog:buttons-container:yes']")
	WebElementFacade buttonYesNewVersion;

	@FindBy(xpath = "//a[@data-uid='validation-result-okinfo:ok']")
	WebElementFacade buttonOKActivate;

	@FindBy(xpath = "//a[@data-uid='activate-question:button1']")
	WebElementFacade buttonActivateNow;

	public boolean isNewVersionConfirmDialogPopup() {
		//setImplicitTimeout(3, TimeUnit.SECONDS);
		boolean result = buttonYesNewVersion.isDisplayed();
		//resetImplicitTimeout();
		System.out.println("<isNewVersionConfirmDialogPopup> Result:" + result);
		return result;
	}
	
	
	
	public void clickButtonYesNewVersion() {
		buttonYesNewVersion.click();
	}
	
	public void clickButtonYesNewVersionIfAny() {
		
		
	/*	Wait wait = new FluentWait(driver)
				 
			    .withTimeout(30, SECONDS)
			 
			    .pollingEvery(5, SECONDS)
			 
			    .ignoring(NoSuchElementException.class);
			 
			  */
		
		setImplicitTimeout(3, TimeUnit.SECONDS);
		
		if (buttonYesNewVersion.withTimeoutOf(3, TimeUnit.SECONDS).isDisplayed()){
			System.out.println("<clickButtonYesNewVersionIfAny> CLICK button YES New Version.");
			buttonYesNewVersion.click();
		}else{
			System.out.println("<clickButtonYesNewVersionIfAny> NONE button YES New Version.");
		}
		
		resetImplicitTimeout();
		
	}
	

	public void clickButtonOKActivate() {
		buttonOKActivate.click();
	}

	public void clickButtonActivateNow() {
		buttonActivateNow.click();
	}

	public void clickButtonActivate() {
		buttonActivate.waitUntilVisible();
		buttonActivate.click();
	}

	public void clickButtonCopyProduct() {
		buttonCopyProduct.waitUntilVisible();
		buttonCopyProduct.click();
	}

	public void clickButtonNewVersion() {
		buttonNewVersion.waitUntilVisible();
		buttonNewVersion.click();
	}

	public void clickButtonOKCopyProduct() {
		buttonOKCopyProduct.waitUntilVisible();
		buttonOKCopyProduct.click();
	}

	public void enterProductCode(String productCode) {
		inputProductCode.waitUntilVisible();
		inputProductCode.type(productCode);
	}

	public String getProductVersion() {
		String result;
		txtProductVersion.waitUntilVisible();
		result = txtProductVersion.getText();
		return result;
	}

	private String getVersionStatus() {
		String result;
		txtVersionStatus.waitUntilVisible();
		result = txtVersionStatus.getText();
		return result;
	}

	private String getPageTitle() {
		String result;
		txtPageTitle.waitUntilVisible();
		result = txtPageTitle.getText();
		return result;
	}

	public void checkVersionStatusActive() {
		String version = getVersionStatus();
		assertEquals(version, strActiveStatus);
		Serenity.takeScreenshot();
	}

	public boolean isProductPageTitle() {
		boolean result;
		String title = getPageTitle();
		result = title.equals(pageTitle);
		return result;
	}

	/*private void checkVersionStatusInactive() {
		String version = getVersionStatus();
		assertEquals(version, strInactiveStatus);
		Serenity.takeScreenshot();
	}*/

	public void checkProductVersion(String productVersion) {
		txtProductVersion.waitUntilVisible();
		String strProductVersion = txtProductVersion.getText();
		assertEquals(strProductVersion, productVersion);
		Serenity.takeScreenshot();
	}

	public boolean isProductViewPageCurrent() {

		// check if current page has title "Product"
		boolean result = isProductPageTitle();

		System.out.println("<isProductViewPageCurrent> Return: " + result);

		return result;

	}

	public void checkProductCode(String productCode) {

		System.out.println("<checkProductCode> wait for element become visible: txtProductCode");
		txtProductCode.waitUntilVisible();

		String actualProductCode = txtProductCode.getText();
		System.out.println("<checkProductCode> actualProductCode: " + actualProductCode);
		System.out.println("<checkProductCode> expectProductCode: " + productCode);

		assertEquals(productCode, actualProductCode);
		Serenity.takeScreenshot();
	}

	public void checkProductValidFrom(String productValidFrom) {

		System.out.println("<checkProductValidFrom> wait for element become visible: txtProductValidFrom");
		txtProductValidFrom.waitUntilVisible();

		String actualProductValidFrom = txtProductValidFrom.getText();
		System.out.println("<checkProductValidFrom> actualProductValidFrom: " + actualProductValidFrom);
		System.out.println("<checkProductValidFrom> expectProductValidFrom: " + productValidFrom);

		assertEquals(productValidFrom, actualProductValidFrom);
		Serenity.takeScreenshot();
	}

}
