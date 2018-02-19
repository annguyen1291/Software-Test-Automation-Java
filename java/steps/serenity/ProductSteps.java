package eu.company.hosel.bsl.test.steps.serenity;

import static org.junit.Assert.assertTrue;

import eu.company.hosel.bsl.test.pages.ProductSearchPage;
import eu.company.hosel.bsl.test.pages.ProductUpdatePage;
import eu.company.hosel.bsl.test.pages.ProductViewPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ProductSteps extends ScenarioSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1132039504039339013L;

	ProductSearchPage productSearchPage;
	ProductUpdatePage productUpdatePage;
	ProductViewPage productViewPage;

	@Step
	public void clickButtonNewProductVersion() {
		productViewPage.clickButtonNewVersion();
	}

	@Step
	public void clickButtonActivateProduct() {

		productViewPage.clickButtonActivate();

		productViewPage.clickButtonOKActivate();

		productViewPage.clickButtonActivateNow();
	}

	@Step
	public void searchForProductCode(String productCode) {
		productSearchPage.searchForProductCode(productCode);
	}

	@Step
	public void clickSearchButton() {
		productSearchPage.clickSearchButton();
	}

	@Step
	public void clickViewButtonOfAProductOnTop() {
		productSearchPage.clickViewProduct();
	}

	@Step
	public void clickCopyProductButton() {
		productViewPage.clickButtonCopyProduct();
	}

	@Step
	public void enterProductCodeRandom(String newProductCode) {

		System.out.println("[copyProduct] PRODUCT_CODE: " + newProductCode);
		try {
			if (productViewPage.isNewVersionConfirmDialogPopup()) {
				System.out.println("<enterProductCodeRandom> CLICK button YES New Version.");
				productViewPage.clickButtonYesNewVersion();
			}
		} catch (Exception e) {
			System.out
					.println("[EXCEPTION-EXPECTED]<enterProductCodeRandom> Dialog confirm new version not showing up");
			System.out.println("[EXCEPTION-EXPECTED]" + e.getMessage());
		}

		productViewPage.enterProductCode(newProductCode);

		productViewPage.clickButtonOKCopyProduct();

		// verify the product code is filled in the form Update Product
		productUpdatePage.checkProductCode(newProductCode);
	}

	@Step
	public void fillInformationOfTheNewCopyProduct(String productName, String validFrom) {

		// -----Fill information of the new copy product

		productUpdatePage.enterProductName(productName);

		productUpdatePage.enterProductValidFrom(validFrom);

		productUpdatePage.clickButtonOKUpdateProduct();

	}

	@Step
	public void verifyProductViewPageCurrentDisplay() {
		assertTrue(productViewPage.isProductViewPageCurrent());
	}

	@Step
	public void verifyNewProductCodeCreatedSuccessfully(String newProductCode) {
		productViewPage.checkProductCode(newProductCode);
	}

	@Step
	public void verifyNewProductValidCreatedInTheFutureSuccessfully(String dateValidFrom) {
		productViewPage.checkProductValidFrom(dateValidFrom);
	}

	@Step
	public void verifyProductVersionStatusIsActive() {
		productViewPage.checkVersionStatusActive();
	}

	@Step
	public void verifyProductVersion(String version) {
		productViewPage.checkProductVersion(version);
	}

}
