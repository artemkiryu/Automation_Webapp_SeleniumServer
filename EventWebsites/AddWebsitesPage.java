package pageObjects.EventWebsites;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

/**
 * Created by infoobjects on 6/5/2017.
 */
public class AddWebsitesPage extends CommonActionsPage {
    @FindBy(xpath = "//input[@id='web_name']")
    public WebElement nameTextBox;

    public AddWebsitesPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='web_is_login_req']")
    public WebElement loginRequiredChk;

    @FindBy(xpath = "//label[text()='Url']//following-sibling::div/a")
    public WebElement loginUrl;

    @FindBy(xpath = "//input[@id='submitForm']")
    public WebElement saveButton;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameTextbox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordTextbox;

    @FindBy(xpath = "//font[text()='Home']")
    public WebElement homeHeader;


    public void enterWebsiteName(String name) throws Exception {
        Wait(nameTextBox, 30);
        type(nameTextBox, name);
        logReport("Entered name value " + name);
    }

    public void checkLoginRequired() {
        check(loginRequiredChk);
        logReport("Login required checkbox checked");

    }

    public void clickSaveButton() throws Exception {
        Wait(saveButton, 30);
        click(saveButton);
        VerifyPageReady(30);
    }

    public void openLoginUrl() throws Exception {
        Wait(loginUrl, 30);
        click(loginUrl);
    }

    public void loginWebsiteUsingProfileCreds(String username, String pwd) throws Exception {
        type(usernameTextbox, username, true);
        type(passwordTextbox, pwd, true);
        click(saveButton);
        VerifyPageReady(30);
    }
}
