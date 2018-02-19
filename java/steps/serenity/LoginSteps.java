package eu.company.hosel.bsl.test.steps.serenity;

import static org.junit.Assert.assertTrue;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import eu.company.hosel.bsl.test.IntegrationTestContext;
import eu.company.hosel.bsl.test.pages.HomePage;
import eu.company.hosel.bsl.test.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.util.EnvironmentVariables;

@ContextConfiguration(classes = IntegrationTestContext.class)
public class LoginSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;
	LoginPage loginPage;
	HomePage homePage;

	@Autowired
	private EnvironmentVariables environmentVariables;

	@Step
	public void launchBrowserAndGoToBslLoginPage() {

		String defaultBaseUrl = environmentVariables.getProperty("BSL_BASE_URL"); // BSL_LOGIN_URL
		loginPage.setDefaultBaseUrl(defaultBaseUrl);
		loginPage.open();

	}
	
	@Step
	public void enterUsernameAndPassword(String username, String password) {

		loginPage.enterUserName(username);
		loginPage.enterPassword(password);

		loginPage.clickLoginButton();

	}
	
	

	@Step
	public void should_see_results_summary() {
		assertTrue(loginPage.getListErrorItem().size() > 0);
	}

	@Step
	public void should_see_results_summaryContaining(String keyword) {
		assertTrue(loginPage.getListErrorItem().stream().filter(error -> error.getErrorMessage().contains(keyword))
				.collect(Collectors.toList()).size() > 0);
	}

	/*
	 * @Step public void searches_for_shop_called(String shopName) {
	 * //homePage.searchForShopCalled(shopName);
	 * assertThat("Bla").containsIgnoringCase(shopName); }
	 * 
	 * @Step public void should_see_shop_search_result_summary_of(String
	 * expectedMessage) {
	 * assertThat(searchResultsPage.getResultSummary()).isEqualToIgnoringCase(
	 * expectedMessage); }
	 * 
	 * @Step public ListingItem selects_listing(int articleNumber) { return
	 * searchResultsPage.selectListing(articleNumber); }
	 * 
	 * @Step public void should_see_product_details_for(ListingItem
	 * selectedListingItem) { ListingItem displayedListingItem =
	 * listingPage.getDisplayedListing();
	 * assertThat(displayedListingItem).isEqualTo(selectedListingItem); }
	 * 
	 * @Step public void adds_current_listing_to_cart() {
	 * listingPage.selectOptionIfPresent(); listingPage.addToCart(); }
	 * 
	 * @Step public void should_see_item_in_cart(ListingItem selectedItem) {
	 * assertThat(cartPage.getOrderCostSummaries() .stream().anyMatch(order ->
	 * order.getName().equals(selectedItem.getName()))).isTrue(); }
	 * 
	 * @Step public void should_see_total_including_shipping_for(ListingItem
	 * selectedItem) { OrderCostSummary orderCostSummary =
	 * cartPage.getOrderCostSummaryFor(selectedItem).get();
	 * 
	 * double itemTotal = orderCostSummary.getItemTotal(); double shipping =
	 * orderCostSummary.getShipping();
	 * 
	 * assertThat(itemTotal).isEqualTo(selectedItem.getPrice());
	 * assertThat(shipping).isGreaterThan(0.0); }
	 * 
	 * @Step public void should_see_product_rating() {
	 * assertThat(listingPage.getRating()).isGreaterThan(0); }
	 * 
	 * @Step public void should_see_twitter_link() {
	 * listingPage.twitterIcon().shouldBeVisible(); }
	 * 
	 * @Step public void should_see_tumblr_link() {
	 * listingPage.tumblrIcon().shouldBeVisible(); }
	 * 
	 * @Step public void should_see_facebook_link() {
	 * listingPage.facebookIcon().shouldBeVisible(); }
	 * 
	 * 
	 * @Step public void should_see_nonexistant_field() {
	 * assertThat(listingPage.clickImaginaryButton()).isFalse(); }
	 * 
	 * 
	 * @Step public void filters_by_local_region() {
	 * searchResultsPage.filterByLocalRegion(); }
	 */
}
