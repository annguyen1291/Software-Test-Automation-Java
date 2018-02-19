package eu.company.hosel.bsl.test.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.support.FindBy;

import eu.company.hosel.bsl.test.model.ErrorItems;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

//@DefaultUrl("https://bsl.vn01p.vn.nonprod/bsl/")
//@ContextConfiguration(classes = IntegrationTestContext.class)
public class LoginPage extends PageObject {

	//@Autowired
	//private EnvironmentVariables environmentVariables;
	
    @FindBy(xpath = "//input[@type='submit']")
    WebElementFacade btnLogin;
    @FindBy(id = "IDToken1")
    WebElementFacade inputUsername;
    @FindBy(id = "IDToken2")
    WebElementFacade inputPassword; 
    
    public void clickLoginButton() {
    	btnLogin.click();
    }
    
    public void enterUserName(String username) {
    	inputUsername.waitUntilVisible();
    	inputUsername.type(username)   ;    
    	//waitForUsernameToBeUpdatedTo(username);
    }
    public void enterPassword(String password) {
    	inputPassword.waitUntilVisible();
    	inputPassword.type(password)   ;      
    	//waitForPasswordToBeUpdatedTo(password);
    }

    
    /*private void waitForUsernameToBeUpdatedTo(String username) {
        waitForCondition()
                .withTimeout(5, TimeUnit.SECONDS)
                .pollingEvery(250,TimeUnit.MILLISECONDS)
                .until(usernameFieldIsUpdatedTo(username));
    }*/

    /*private Function<? super WebDriver, Boolean> usernameFieldIsUpdatedTo(String username) {
        return new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return inputPassword.getValue().equalsIgnoreCase(username);
            }
        };
    }*/
    
   /* private void waitForPasswordToBeUpdatedTo(String password) {
        waitForCondition()
                .withTimeout(5, TimeUnit.SECONDS)
                .pollingEvery(250,TimeUnit.MILLISECONDS)
                .until(passwordFieldIsUpdatedTo(password));
    }*/

    /*private Function<? super WebDriver, Boolean> passwordFieldIsUpdatedTo(String password) {
        return new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return inputPassword.getValue().equalsIgnoreCase(password);
            }
        };
    }*/

       
    
    public List<ErrorItems> getListErrorItem() {
        return findAll(".errors")
                .stream()
                .map(LoginPage::convertToErrorItem)
                .collect(Collectors.toList());
    }
    
    public static ErrorItems convertToErrorItem(WebElementFacade summaryElement) {       
        String errorMessage = summaryElement.getText();       
        return new ErrorItems(errorMessage);
    }
}
