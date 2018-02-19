package eu.company.hosel.bsl.test.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import eu.company.hosel.bsl.test.BaseSs;
import eu.company.hosel.bsl.test.steps.serenity.ProductSteps;
import eu.company.hosel.bsl.test.steps.serenity.SaleRoomSteps;
import net.thucydides.core.annotations.Steps;

public class ProductStorySteps {

	@Steps
	ProductSteps productSteps;

	@Steps
	SaleRoomSteps saleRoomSteps;

	//ProductViewPage productViewPage;
	//ProductSearchPage productSearchPage;

	// SaleRoomPage saleRoomPage;

	public static String NEW_PRODUCT_CODE_CD = "";
	public static String NEW_PRODUCT_CODE_TW = "";
	String EXISTING_PRODUCT_CODE = "";
	
	public static String DATE_VALID_FROM = BaseSs.getTomorrowDate();
	
	String PRODUCT_NAME_SUFFIX = " Automation Product Testing";


	@Given("Go to Search for a CD product code: $productCode")
	public void goToProductTWDetailPage(String productCode) {
		EXISTING_PRODUCT_CODE = BaseSs.getDefaultPropertiesData(productCode, "PRODUCT_CODE_CD");
		productSteps.searchForProductCode(EXISTING_PRODUCT_CODE);
	}

	@Given("Go to Search for a TW product code: $productCode")
	public void goToProductCDDetailPage(String productCode) {
		EXISTING_PRODUCT_CODE = BaseSs.getDefaultPropertiesData(productCode, "PRODUCT_CODE_TW");
		productSteps.searchForProductCode(EXISTING_PRODUCT_CODE);
	}

	@Given("Go to Search for a random product code")
	public void goToProductDetailPage() {
		productSteps.clickSearchButton();
		productSteps.clickViewButtonOfAProductOnTop();
		EXISTING_PRODUCT_CODE = "AUTO_"; // maximum 5 char
	}

	private void copyProductType(String type) {

		String code = "";
		int randomSuffixCode = BaseSs.genRandomNumber(10000);

		if (type.equals("CD")) {

			NEW_PRODUCT_CODE_CD = EXISTING_PRODUCT_CODE + "_" + Integer.toString(randomSuffixCode);
			
			code = NEW_PRODUCT_CODE_CD;

		} else {

			NEW_PRODUCT_CODE_TW = EXISTING_PRODUCT_CODE + "_" + Integer.toString(randomSuffixCode);
			
			code = NEW_PRODUCT_CODE_TW;
		}

		//DATE_VALID_FROM = "17/07/2017";

		String productName = "0_" + code + PRODUCT_NAME_SUFFIX;
		
		productSteps.clickCopyProductButton();
		
		productSteps.enterProductCodeRandom(code);
		
		productSteps.fillInformationOfTheNewCopyProduct(productName, DATE_VALID_FROM);

	}

	@When("I want to create new product CD from existing one")
	public void copyProductTypeCD() {
		copyProductType("CD");
	}

	@When("I want to create new product TW from existing one")
	public void copyProductTypeTW() {
		copyProductType("TW");
	}

	private void verifyProduct(String type) {
		
		productSteps.verifyProductViewPageCurrentDisplay();

		if (type.equals("CD")) {
			productSteps.verifyNewProductCodeCreatedSuccessfully(NEW_PRODUCT_CODE_CD);
		} else {
			productSteps.verifyNewProductCodeCreatedSuccessfully(NEW_PRODUCT_CODE_TW);
		}

		productSteps.verifyNewProductValidCreatedInTheFutureSuccessfully(DATE_VALID_FROM);
	}

	@Then("I should see new product CD created sucessfully")
	public void verifyProductCD() {
		verifyProduct("CD");
	}

	@Then("I should see new product TW created sucessfully")
	public void verifyProductTW() {
		verifyProduct("TW");
	}

	@When("I want to activate the product that I just made a copy")
	public void activateProduct() {
		
		productSteps.clickButtonActivateProduct();

	}

	@Then("I should see the product is activate")
	public void verifyProductActivate() {
		productSteps.verifyProductVersionStatusIsActive();
	}

	@When("I want to create new version for the product that I just made a copy")
	public void createNewProductVersion() {
		productSteps.clickButtonNewProductVersion();
	}

	@Then("I should see the product version increase to number $version")
	public void verifyProductVersion(String version) {
		productSteps.verifyProductVersion(version);
	}

	// Sale room assign product page===============================

	@Given("I search for salesroom code $saleroomCode")
	public void searchForSaleroomCode(String saleroomCode) {
		String dataCode = BaseSs.getDefaultPropertiesData(saleroomCode, "SALEROOM_CODE");
		saleRoomSteps.searchForSaleroomCode(dataCode);
	}

	@Given("I go to Assign Product to Sale Room page")
	public void clickOnTabLinkCreditProducts() {
		saleRoomSteps.clickOnTabLinkCreditProducts();
		saleRoomSteps.clickOnLinkAssign();
	}

	@When("I want to add product CD to salesroom")
	public void addProductCDToSaleroom() {
		saleRoomSteps.enterProductDateValidFrom(DATE_VALID_FROM);
		saleRoomSteps.selectProductToSaleRoom(NEW_PRODUCT_CODE_CD);
	}

	@When("I want to add product TW to salesroom")
	public void addProductTWToSaleroom() {
		saleRoomSteps.enterProductDateValidFrom(DATE_VALID_FROM);
		saleRoomSteps.selectProductToSaleRoom(NEW_PRODUCT_CODE_TW);
	}

	@Then("I should see product CD added to salesroom successfully")
	public void checkProductCDAddedToSaleroom() {
		//data test CD
		//NEW_PRODUCT_CODE_CD = "CD02_8659";
		
		saleRoomSteps.checkProductCodeExistInTableProductAssignment(NEW_PRODUCT_CODE_CD);
	}

	@Then("I should see product TW added to salesroom successfully")
	public void checkProductTWAddedToSaleroom() {
		saleRoomSteps.checkProductCodeExistInTableProductAssignment(NEW_PRODUCT_CODE_TW);
	}

}
