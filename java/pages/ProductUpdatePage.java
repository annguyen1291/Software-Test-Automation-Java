package eu.company.hosel.bsl.test.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;


public class ProductUpdatePage extends PageObject {
	
	
	@FindBy(xpath = "//input[@type='submit' and @data-uid='button-panel:ok']")
	WebElementFacade buttonOKUpdateProduct;
	
	@FindBy(xpath = "//span[@data-uid='code']")
	WebElementFacade txtProductCode;
	 
	@FindBy(xpath = "//input[@type='text' and @data-uid='valid-from']")
	WebElementFacade inputProductValidFrom;
	
	@FindBy(xpath = "//input[@type='text' and @data-uid='valid-to']")
	WebElementFacade inputProductValidTo;
	
	@FindBy(xpath = "//input[@type='text' and @data-uid='name']")
	WebElementFacade inputProductName;
	
	public void clickButtonOKUpdateProduct() {
		buttonOKUpdateProduct.waitUntilVisible();
		buttonOKUpdateProduct.click();
	}
	
	public void enterProductName(String productName) {
		inputProductName.waitUntilVisible();
		inputProductName.type(productName);
	}
	
	public void enterProductValidFrom(String futureDate) {
		futureDate = futureDate.replace("/", "");
		System.out.println("<enterProductValidFrom> futureDate after replace: " + futureDate);
		
		inputProductValidFrom.waitUntilVisible();
		inputProductValidFrom.type(futureDate);
	}
	
	public void checkProductCode(String productCode) {
		txtProductCode.waitUntilVisible();
		String actualProductCode = txtProductCode.getText();
		
		System.out.println("<checkProductCode> actualProductCode: " + actualProductCode);
		System.out.println("<checkProductCode> expectProductCode: " + productCode);
		assertEquals(productCode, actualProductCode);
	}
	

}

