package eu.company.hosel.bsl.test.steps.serenity;

import eu.company.hosel.bsl.test.pages.CommonPage;
import net.thucydides.core.annotations.Step;

public class CommonSteps {
	
	CommonPage comPage;

	@Step
	public void switchBackToBSLHomePage(){
		comPage.switchBackToHomePage();
	}
}
