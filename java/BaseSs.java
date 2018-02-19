package eu.company.hosel.bsl.test;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.jbehave.core.annotations.BeforeStories;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import net.serenitybdd.jbehave.SerenityStory;
import net.thucydides.core.util.EnvironmentVariables;

import net.serenitybdd.core.pages.WebElementFacade;

@ContextConfiguration(classes = IntegrationTestContext.class)
public class BaseSs extends SerenityStory {

	@Autowired
	private static EnvironmentVariables environmentVariables;

	public static boolean IS_ALREADY_LOGIN;

	public static String LANGUAGE_SETTING = "";
	public static String USER_FULL_NAME = "";
	public static String TOMORROW_DATE_STRING = ""; // dd/MM/yyyy

	/*
	 * public static String CODE1; public static String CODE2;
	 */

	@BeforeStories
	public void beforeStories() {

		/*
		 * Random randomGenerator = new Random(); int randomSuffixCode =
		 * randomGenerator.nextInt(10000);
		 * 
		 * CODE1 = Integer.toString(randomSuffixCode); CODE2 = new
		 * StringBuilder(CODE1).reverse().toString();
		 */

	}

	/**
	 * Check row data text in table 
	 * @author duong.pk
	 * @param listElements is weblement list contains row data texts need to be checked
	 * @param expectedRowData is a string contains expected row data text with delimiter '|' 
	 */
	public static void checkRowData(List<WebElement> listElements, String expectedRowData) {

		boolean result = true;
		String[] arrData = expectedRowData.split("\\|", -1);
		String eText = "";

		for (int i = 0; i < arrData.length; i++) {
			if (arrData[i].isEmpty() == false) {
				eText = listElements.get(i).getText();
				System.out.println("<checkRowData> arrData[" + i + "]: " + arrData[i] + "; Element Text: " + eText);
				if (arrData[i].equals(eText) == false) {
					result = false;
					break;
				}
			}
		}

		assertTrue(result);

	}

	public static int genRandomNumber(int length) {
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(length);
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}

	public static String genRandomCharacter(int length, int capitalInclude) {

		int limit = 26;
		if (capitalInclude > 0) {
			limit = 52;
		}
		String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer randStr = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = genRandomNumber(limit);
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}

	public static String genRandomCharacter(int length) {
		return genRandomCharacter(length, 0);
	}

	public static boolean isTestEnvi() {
		String baseUrl = environmentVariables.getProperty("BSL_BASE_URL");
		return (baseUrl.equals("https://bsl.vn66c1.vn.infra/bsl/"));
	}

	public static String getTomorrowDate(String format) {

		Date dt = new Date();
		dt = currentDatePlus(1);

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(dt);

	}

	public static String getTomorrowDate() {

		return getTomorrowDate("dd/MM/yyyy");

	}

	private static Date currentDatePlus(int day) {
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 1);
		dt = c.getTime();

		return dt;
	}

	public static String getDefaultPropertiesData(String defaultText, String propertiesKey) {
		String dataValue = environmentVariables.getProperty(propertiesKey);
		return (defaultText.equals("default") == true) ? dataValue : defaultText;
	}

	public static String getPropertiesValue(String propertiesKey) {
		return environmentVariables.getProperty(propertiesKey);
	}

	public static void checkText(WebElementFacade element, String expectedText) {
		String actualText = element.getText();
		System.out.println("<checkText> actual: " + actualText + "; expected: " + expectedText);
		boolean result = actualText.equals(expectedText);
		assertTrue(result);
	}

	public static void checkText(WebElementFacade element, String expectedText, int sec) {

		wait(sec);
		String actualText = element.getText();
		System.out.println("<checkText> actual: " + actualText + "; expected: " + expectedText);
		boolean result = actualText.equals(expectedText);
		assertTrue(result);
	}

	public static void wait(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * @Override public List<String> storyPaths() { List<String> storiesToRun =
	 * new ArrayList<String>(); String storyProperty =
	 * System.getProperty("story");
	 * 
	 * if (storyProperty == null || storyProperty.isEmpty()) { throw new
	 * RuntimeException("Please specify which stories to run"); }
	 * 
	 * String[] storyNames = storyProperty.split(","); StoryFinder sf = new
	 * StoryFinder(); URL baseUrl =
	 * CodeLocations.codeLocationFromClass(this.getClass());
	 * 
	 * for (String storyName : storyNames) {
	 * storiesToRun.addAll(sf.findPaths(baseUrl, storyName, "")); }
	 * 
	 * return storiesToRun; }
	 */

}
