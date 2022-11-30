package pageObjects.Login;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

/**
 * Created by infoobjects on 8/3/2017.
 */
public class LoginPage extends CommonActionsPage {
    @FindBy(id= "username")
    public WebElement userNameTextBox;

    @FindBy(id= "password")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//input[@name='login']")
    public WebElement loginButton;

    public LoginPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    private void enterUsername(String userName) {
        logReport("Entering UserName : " + userName);
        type(userNameTextBox,userName,true);

    }

    /**
     * Method to enter password in the textbox.
     *
     * @param password : value of password.
     */
    private void enterPassword(String password) {
        logReport("Entering Password : ********" );
        type(passwordTextBox,password,true);

    }

    /**
     * Method to click on login button.
     */
    private void clickLogin() {
        logReport("Click on Login Button");
        loginButton.click();
    }

    @FindBy(xpath = "//button[@onclick='ssoAdminLogin()']")
    public WebElement LOGIN_SSO_BUTTON;
    @FindBy(xpath = "//input[@id='okta-signin-username']")
    public WebElement USER_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@id='okta-signin-password']")
    public WebElement PASSWORD_TEXT_BOX;
    @FindBy(xpath = "//input[@value='Sign In']")
    public WebElement LOGIN_BUTTON;

    /**
     * Method to login into the application.
     *
     * @param userName : username value
     * @param password : password value
     * @return : DashboardPage
     */
    public DashboardPage login(String userName, String password) throws Exception {
        enterUsername(userName);
        enterPassword(password);
        clickLogin();
        return new DashboardPage(browser);
    }

    private void enterUsernameSSO(String userName) throws Exception {
        VerifyPageReady(30);
        logReport("Entering UserName : " + userName);
        type(USER_NAME_TEXTBOX, userName);
    }

    /**
     * Method to enter password in the textbox.
     *
     * @param password : value of password.
     */
    private void enterPasswordSSO(String password) {
        logReport("Entering Password : " + password);
        type(PASSWORD_TEXT_BOX, password);
    }

    /**
     * Method to click on login button.
     */
    private void clickLoginSSO() {
        logReport("Click on Login Button");
        click(LOGIN_BUTTON);
    }

    public void fillLoginSSO(String email, String pwd) throws Exception {
        enterUsernameSSO(email);
        enterPasswordSSO(pwd);
        clickLoginSSO();
    }

    public void clickOnSSOLoginButton() throws Exception {
        Wait(LOGIN_SSO_BUTTON, 10);
        clickByJavaScript(LOGIN_SSO_BUTTON);
        reporter.info("Successfully clicked on SSO Login button.");
        switchToLatestTabOrWindow();
        VerifyPageReady(30);
    }

}
