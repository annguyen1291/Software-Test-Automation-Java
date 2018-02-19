package eu.company.hosel.bsl.test.steps;

import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

import eu.company.hosel.bsl.test.BaseSs;
import eu.company.hosel.bsl.test.pages.HomePage;
import eu.company.hosel.bsl.test.steps.serenity.HomePageSteps;
import net.thucydides.core.annotations.Steps;

public class HomePageStorySteps {

	@Steps
	HomePageSteps homePageSteps;
	
	HomePage homePage;

	@Given("I am at Manage Product page")
	public void goToManageProductPage() {
		homePage.clickManageProductIcon();
	}
	
	@Given("I am at BSL Homepage")
	public void goToBSLHomePage() {
		homePage.clickHomeIcon();
	}
	
	@Given("I am at Find salesroom page")
	public void goToFindSalesroomPage() {
		homePage.clickFindSaleRoomIcon();
	}
	

	@Then("I should see BSL home page")
	public void resultsForValidLogin() {

		String userFullName = BaseSs.USER_FULL_NAME;
		System.out.println("<resultsForValidLogin> userFullName: " + userFullName);
		
		boolean isUserName = homePage.isUserNameMatched(userFullName);
		
		BaseSs.IS_ALREADY_LOGIN = isUserName;
		
		if (isUserName){
			assertTrue(isUserName);
		}else{
			boolean isLinkLogoutExist = homePage.isLinkLogoutExist();
			assertTrue(isLinkLogoutExist);
			BaseSs.IS_ALREADY_LOGIN = isLinkLogoutExist;
		}
		
		//TODO [LOGIN] handle flag, remove this line when done
		BaseSs.IS_ALREADY_LOGIN = false;

	}

}
