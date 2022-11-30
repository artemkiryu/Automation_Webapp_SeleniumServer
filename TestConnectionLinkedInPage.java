package pageObjects;


import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by infoobjects on 10/21/2016.
 */
public class TestConnectionLinkedInPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@name='session_key']")
    public WebElement EMAIL_TEXTBOX;

    @FindBy(xpath = "//input[@name='session_password']")
    public WebElement PASSWORD_TEXTBOX;

    @FindBy(xpath = "//input[@value='Allow access']")
    public WebElement ALLOW_ACCESS_BUTTON;

    @FindBy(xpath = "//button[text()='Sign in']")
    public WebElement SIGN_IN_BUTTON;

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement OK_BUTTON;

    @FindBy(xpath = "//td[text()='firstName']/following-sibling::td")
    public WebElement FIRST_NAME_VALUE;

    @FindBy(xpath = "//td[text()='lastName']/following-sibling::td")
    public WebElement LAST_NAME_VALUE;

    @FindBy(xpath = "//td[text()='emailAddress']/following-sibling::td")
    public WebElement EMAIL_ADDRESS_VALUE;


    public TestConnectionLinkedInPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) throws Exception {
        // webDriver.waitFor().waitForPageToLoad();
        Wait(EMAIL_TEXTBOX, 30);
        type(EMAIL_TEXTBOX, email, true);
    }

    public void enterPassword(String password) {
        type(PASSWORD_TEXTBOX, password, true);
    }

    public void clickAllowAccessButton() throws Exception {
        if (verifyElementDisplayed(ALLOW_ACCESS_BUTTON, 10)) {
            click(ALLOW_ACCESS_BUTTON);
            logReport("Allow access button clicked successfully");
            VerifyPageReady(30);
        }
        if (verifyElementDisplayed(SIGN_IN_BUTTON, 10)) {
            click(SIGN_IN_BUTTON);
            logReport("Sign in button clicked successfully");
            VerifyPageReady(30);
        }

    }

    public String getFirstNameFieldValue() throws Exception {
        VerifyPageReady(30);
        Wait(FIRST_NAME_VALUE, 20);
        return FIRST_NAME_VALUE.getText().trim();
    }

    public String getLastNameFieldValue() {
        return LAST_NAME_VALUE.getText().trim();
    }

    public String getEmailAddressFieldValue() {
        return EMAIL_ADDRESS_VALUE.getText().trim();
    }
}
