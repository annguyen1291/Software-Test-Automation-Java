package eu.company.hosel.bsl.test.steps.serenity;

import eu.company.hosel.bsl.test.pages.HomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class HomePageSteps extends ScenarioSteps {
		
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7501779299693365656L;
	
	HomePage homePage;
	
	@Step
	public void checkCurrentHomepageLanding() {
		
		homePage.checkHomePageCurrentDisplayed();

/*		boolean isUserNameMatched = homePage.isUserNameMatched(userFullName);
		
		BaseSs.IS_ALREADY_LOGIN = isUserNameMatched;
		
		if (isUserNameMatched){
			assertTrue(isUserNameMatched);
		}else{
			boolean isLinkLogoutExist = homePage.isLinkLogoutExist();
			assertTrue(isLinkLogoutExist);
			BaseSs.IS_ALREADY_LOGIN = isLinkLogoutExist;
		}*/
		
	}
	
	@Step
	public void clickHomeMenuToGoBackToHomePage(){
		homePage.clickHomeIcon();
	}
	
	/*@Step
	public void clickManageProductIcon(){
		homePage.clickManageProductIcon();
	}*/
	
	

}
