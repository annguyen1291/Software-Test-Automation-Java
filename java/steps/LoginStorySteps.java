package eu.company.hosel.bsl.test.steps;

import java.text.ParseException;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import eu.company.hosel.bsl.test.BaseSs;
import eu.company.hosel.bsl.test.pages.HomePage;
import eu.company.hosel.bsl.test.pages.LoginPage;
import eu.company.hosel.bsl.test.steps.serenity.HomePageSteps;
import eu.company.hosel.bsl.test.steps.serenity.LoginSteps;
import net.thucydides.core.annotations.Steps;

public class LoginStorySteps {
	@Steps
	LoginSteps loginSteps;
	@Steps
	HomePageSteps homePageSteps;

	LoginPage loginPage;
	HomePage homePage;
	
	@Given("I am at BSL Login page")
	public void open_bsl_login_page() {
		System.out.println("[open_bsl_login_page]BaseSs.IS_ALREADY_LOGIN:" + BaseSs.IS_ALREADY_LOGIN );
		
		if (BaseSs.IS_ALREADY_LOGIN == false){
			loginSteps.launchBrowserAndGoToBslLoginPage();
		}else{
			
			loginSteps.launchBrowserAndGoToBslLoginPage();
			
			//TODO [LOGIN] uncomment line below once the LOGIN flag ok
			//homePage.clickHomeIcon();

		}
	}

	@Given("Login username $username and password $password")
	public void bsl_pass_login_page_or_click_home_menu_back_to_home_page(String username, String password) {
		
		if (BaseSs.IS_ALREADY_LOGIN == false){
			
			loginSteps.launchBrowserAndGoToBslLoginPage();
			
			String dataUserName = BaseSs.getDefaultPropertiesData(username, "USER_NAME");
			String dataPassword = BaseSs.getDefaultPropertiesData(password, "USER_PASSWORD");
			loginSteps.enterUsernameAndPassword(dataUserName, dataPassword);
			
			homePageSteps.checkCurrentHomepageLanding();
			
		}else{
			
			homePageSteps.clickHomeMenuToGoBackToHomePage();
			
			homePageSteps.checkCurrentHomepageLanding();
		}
		
	}

	@When("I want to login with $username and $password")
	public void login(String username, String password) {

		if (BaseSs.IS_ALREADY_LOGIN == false){
			String dataUserName = BaseSs.getDefaultPropertiesData(username, "USER_NAME");
			String dataPassword = BaseSs.getDefaultPropertiesData(password, "USER_PASSWORD");
			loginSteps.enterUsernameAndPassword(dataUserName, dataPassword);
			
		}

	}

	@Then("I should see errors")
	public void resultsForInvalidLogin() throws ParseException {
		loginSteps.should_see_results_summary();
	}

	@Then("I should see errors containing $keyword")
	public void resultsForInvalidLogin(String keyword) throws ParseException {
		loginSteps.should_see_results_summaryContaining(keyword);
	}

	/*
	 * @Then("I should see only articles related to '<keyword>'")
	 * 
	 * @Alias("I should see only articles related to '$keyword'") public void
	 * resultsForACategoryAndKeywordInARegion(String keyword) throws
	 * ParseException { buyer.should_see_results_summary_containing(keyword); }
	 * 
	 * @Given("I want to see articles from a particular shop") public void
	 * givenIWantToSeeArticlesFromAParticularShop() { buyer.opens_home_page(); }
	 * 
	 * @When("I search by shop for '$shopName'") public void
	 * whenISearchByShopFor(String shopName) {
	 * buyer.searches_for_shop_called(shopName); }
	 * 
	 * @Then("I should find $count shop called '$shopName'")
	 * 
	 * @Alias("I should find $count shops called '$shopName'") public void
	 * thenIShouldFindShopsCall(int count, String shopName) { String
	 * expectedMessage = String.format("%d %s found for %s", count,
	 * pluralized(count,"shop"),shopName);
	 * buyer.should_see_shop_search_result_summary_of(expectedMessage); }
	 * 
	 * private String pluralized(int count, String word) { return
	 * Inflector.getInstance().pluralize(word, count);
	 * 
	 * }
	 */
}
