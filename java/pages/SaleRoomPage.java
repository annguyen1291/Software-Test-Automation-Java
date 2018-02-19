package eu.company.hosel.bsl.test.pages;

import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class SaleRoomPage extends PageObject {

	@FindBy(xpath = "//div[@id='veil' and @style='display: block;']/div[@class='ajax-request']")
	WebElementFacade ajaxRequest;

	@FindBy(xpath = "//input[@type='text' and @data-uid='code']")
	WebElementFacade findSaleRoom_inputCode;

	@FindBy(xpath = "//input[@type='submit' and @value='Search']")
	WebElementFacade findSaleRoom_btnSearch;

	@FindBy(xpath = "//span[@data-uid='salesroom-detail-panel:code']")
	WebElementFacade saleRoomDetail_txtCode;

	@FindBy(xpath = "//a[@data-uid='salesroom-detail-bottom-panel:salesroom-detail-tabs:tabs-container:7']")
	WebElementFacade saleRoomDetail_CreditProductLink;

	@FindBy(xpath = "//a[@data-uid='salesroom-detail-bottom-panel:salesroom-detail-tabs:panel:assign-link']")
	WebElementFacade saleRoomDetail_AssignLink;

	@FindBy(xpath = "//input[@type='checkbox' and @data-uid='salesroom-detail-bottom-panel:salesroom-detail-tabs:panel:filter-credit-products']")
	WebElementFacade findSaleRoom_checkboxCurrentProductAssignment;

	@FindBy(xpath = "//a[@data-better-uid='available-products:top-toolbars:header:order-by-link']/span[contains(text(),'Valid from')]")
	WebElementFacade assignProduct_HeaderValidFrom;
	
	@FindBy(xpath = "//a[@data-better-uid='available-products:top-toolbars:header:order-by-link']/span[contains(text(),'Name')]")
	WebElementFacade assignProduct_HeaderName;

	@FindBy(xpath = "//a[@data-better-uid='salesroom-detail-bottom-panel:salesroom-detail-tabs:panel:credit-products:top-toolbars:header:order-by-link']/span[contains(text(),'Valid from')]")
	WebElementFacade saleRoomDetail_CreditProductTable_HeaderValidFrom;
	
	@FindBy(xpath = "//a[@data-better-uid='salesroom-detail-bottom-panel:salesroom-detail-tabs:panel:credit-products:top-toolbars:header:order-by-link']/span[contains(text(),'Name')]")
	WebElementFacade saleRoomDetail_CreditProductTable_HeaderName;

	@FindBy(xpath = "//input[@type='text' and @name='validFrom']")
	WebElementFacade assignProduct_validFrom;

	@FindBy(xpath = "//input[@type='text' and @name='validTo']")
	WebElementFacade assignProduct_validTo;

	@FindBy(xpath = "//input[@type='submit' and @data-uid='button-panel:ok']")
	WebElementFacade assignProduct_buttonOK;

	@FindBy(xpath = "//a[@data-uid='modal:yes']")
	WebElementFacade assignProduct_buttonYes;

	@FindBy(xpath = "//a[@data-better-uid='salesroom-detail-bottom-panel:salesroom-detail-tabs:panel:credit-products:body:cell:remove']")
	WebElementFacade assignProduct_buttonRemoveProduct;

	public void enterFindSaleRoom_Code(String code) {
		findSaleRoom_inputCode.waitUntilVisible();
		findSaleRoom_inputCode.type(code);
	}

	public void clickFindSaleRoom_SearchButton() {
		findSaleRoom_btnSearch.waitUntilVisible();
		findSaleRoom_btnSearch.click();
	}

	public boolean isSaleRoomDetail_Code(String code) {
		boolean result;

		saleRoomDetail_txtCode.waitUntilVisible();
		String actualCode = saleRoomDetail_txtCode.getText();

		result = actualCode.equals(code);

		return result;
	}

	/*private void scrollAndClick(WebElementFacade element) {
		int elementPosition = element.getLocation().getY();
		String js = String.format("window.scroll(0, %s)", elementPosition);

		WebDriver driver = getDriver();

		((JavascriptExecutor) driver).executeScript(js);

		element.click();
	}*/

	public void clickSaleRoomDetail_CreditProductLink() {
		saleRoomDetail_CreditProductLink.sendKeys(Keys.ENTER);
	}

	public void clickSaleRoomDetail_AssignLink() {
		saleRoomDetail_AssignLink.sendKeys(Keys.ENTER);
	}

	private void WaitForAjaxComplete() {
		while (true) {
			WebDriver driver = getDriver();

			Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
			if (ajaxIsComplete) {
				break;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void clickAssignProduct_TableHeader_Name() {

		assignProduct_HeaderName.waitUntilPresent();
		assignProduct_HeaderName.click();
		
		WaitForAjaxComplete();

		ajaxRequest.waitUntilNotVisible();

	}
	
public void clickSaleroomDetail_TableHeader_Name() {
	
		saleRoomDetail_CreditProductTable_HeaderName.sendKeys(Keys.ENTER);
		
		WaitForAjaxComplete();

		ajaxRequest.waitUntilNotVisible();

	}

	public void clickAssignProduct_ValidFromHeaderTwice() {

		assignProduct_HeaderValidFrom.waitUntilVisible();
		assignProduct_HeaderValidFrom.click();

		WaitForAjaxComplete();

		ajaxRequest.waitUntilNotVisible();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assignProduct_HeaderValidFrom.click();

		System.out.println("<clickAssignProduct_ValidFromHeaderTwice> click twice done");
	}
	
	

	public void clickSaleroomDetail_ValidFromHeaderTwice() {

		//saleRoomDetail_CreditProductTable_HeaderValidFrom.waitUntilVisible();
		//saleRoomDetail_CreditProductTable_HeaderValidFrom.click();
		
		WebDriver driver = getDriver();
		
		Actions actions = new Actions(driver);

		actions.moveToElement(saleRoomDetail_CreditProductTable_HeaderValidFrom).click().perform();

		WaitForAjaxComplete();

		ajaxRequest.waitUntilNotVisible();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		actions.moveToElement(saleRoomDetail_CreditProductTable_HeaderValidFrom).click().perform();

		System.out.println("<clickSaleroomDetail_ValidFromHeaderTwice> click twice done 2");
	}
	
	

	public void clickAssignProduct_CheckBoxProduct(String productCode) {

		System.out.println("<clickAssignProduct_CheckBoxProduct> PRODUCT_CODE: " + productCode);

		String elementParam = "//div[@data-better-uid='available-products:body:cell' and contains(text(),'"
				+ productCode + "')]/../preceding-sibling::td/div/input[@type='checkbox']";

		WebElementFacade assignProduct_checkboxProduct = find(ByXPath.xpath(elementParam));

		System.out.println(
				"<clickAssignProduct_CheckBoxProduct> Element found?: " + assignProduct_checkboxProduct.isVisible());

		// assignProduct_checkboxProduct.click();

		WebDriver driver = getDriver();

		Actions actions = new Actions(driver);

		actions.moveToElement(assignProduct_checkboxProduct).click().perform();

	}

	public void enterAssignProduct_ValidFrom(String validFrom) {
		assignProduct_validFrom.waitUntilVisible();
		assignProduct_validFrom.type(validFrom);
	}

	public void clickAssignProduct_OKButton() {
		assignProduct_buttonOK.waitUntilVisible();
		assignProduct_buttonOK.click();
	}

	public void clickAssignProduct_YesButton() {
		assignProduct_buttonYes.waitUntilClickable();
		assignProduct_buttonYes.click();
	}

	public void waitForButtonRemoveProductVisible() {
		assignProduct_buttonRemoveProduct.waitUntilVisible();
	}

	public void clickAssignProduct_UncheckCurrentProductAssignment() {
		findSaleRoom_checkboxCurrentProductAssignment.waitUntilVisible();
		findSaleRoom_checkboxCurrentProductAssignment.click();
	}

	public boolean isSaleRoomDetail_CreditProducts_ProductCodePresent(String productCode) {

		System.out.println("<isSaleRoomDetail_ProductCodeAssingment> PRODUCT_CODE: " + productCode);

		String elementParam = "//div[@data-better-uid='salesroom-detail-bottom-panel:salesroom-detail-tabs:panel:credit-products:body:cell' and contains(text(),'"
				+ productCode + "')]";

		WebElementFacade saleRoomDetail_TableCellProductCode = find(ByXPath.xpath(elementParam));

		return saleRoomDetail_TableCellProductCode.isPresent();

	}

}
