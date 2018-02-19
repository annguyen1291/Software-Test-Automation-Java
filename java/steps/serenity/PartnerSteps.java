package eu.company.hosel.bsl.test.steps.serenity;

import eu.company.hosel.bsl.test.pages.PartnerPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class PartnerSteps extends ScenarioSteps {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3801776662286508928L;
	
	PartnerPage partnerPage;
	
	@Step
	public void checkRowDataTableDetail(String rowDataText) {
		partnerPage.checkRowDataTable(rowDataText);
	}
	

}
