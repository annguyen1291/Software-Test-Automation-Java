package eu.company.hosel.bsl.test.pages;

import static org.junit.Assert.assertEquals;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import eu.company.hosel.bsl.test.BaseSs;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class CommonPage extends PageObject {

	public void alternativeClick(WebElementFacade element) {
		element.sendKeys(Keys.ENTER);
	}

	public void alternativeCheck(WebElementFacade element) {
		element.sendKeys(Keys.SPACE);
	}

	@FindBy(xpath = "//div[@id='veil' and @style='display: block;']/div[@class='ajax-request']")
	WebElementFacade ajaxRequest;

	public boolean waitForPresent(WebElementFacade element, int second) {
		int i = 0;
		while (element.isPresent() != true & i < second) {
			BaseSs.wait(1);
			getDriver().navigate().refresh();
			i++;
			System.out.println(i);
		}
		return element.isPresent();
	}
	
	public void waitForUpdate(WebElementFacade actualDetails, String expectedDetails, int second) {
		int i = 0;
		while (expectedDetails.equals(actualDetails.getText()) != true & i < second) {
			BaseSs.wait(1);
			getDriver().navigate().refresh();
			i++;
			System.out.println(i);
		}
	}

	public void waitForAjaxComplete() {

		while (true) {
			WebDriver driver = getDriver();

			Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
			if (ajaxIsComplete) {
				break;
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		WaitForAjaxRequestElementNotVisible();
	}

	private void WaitForAjaxRequestElementNotVisible() {
		ajaxRequest.waitUntilNotVisible();
	}

	public void switchBackToHomePage() {
		getDriver().get(BaseSs.getPropertiesValue("BSL_BASE_URL"));
	}

	public void switchToUrl(String url) {
		getDriver().get(url);
	}

	public boolean isViewPageCurrent(WebElementFacade actualPageTitle, String expectedPageTitle) {

		actualPageTitle.waitUntilVisible();

		// check if the page is current
		boolean result = (actualPageTitle.getText()).equals(expectedPageTitle);
		System.out.println("<iskViewPageCurrent> Return: " + result);
		return result;

	}

	public void checkDetails(WebElementFacade actualDetails, String expectedDetails) {

		System.out.println("<checkDetails> wait for element become visible");
		actualDetails.waitUntilVisible();

		System.out.println("<checkDetails> actualDetails: " + actualDetails.getText());
		System.out.println("<checkDetails> expectedDetails: " + expectedDetails);

		waitForUpdate(actualDetails, expectedDetails, 5);

		assertEquals(expectedDetails, actualDetails.getText());
		Serenity.takeScreenshot();
	}

	// Random string of 10 characters

	private int getRandomNumber(int length) {
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(length);
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}

	public String randomCharacter(int length) {
		String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer randStr = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = getRandomNumber(length);
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}

	public String randomNumber(int length) {
		String NUMB_LIST = "0123456789";
		StringBuffer randStr = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = getRandomNumber(length);
			char ch = NUMB_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}
}
