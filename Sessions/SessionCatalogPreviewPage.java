package pageObjects.Sessions;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

public class SessionCatalogPreviewPage extends CommonActionsPage {
    @FindBy(xpath = "//button[@id='login-label']")
    public WebElement LOGIN_BUTTON;

    @FindBy(xpath = "//input[@id='username-label']")
    public WebElement USERNAME;

    @FindBy(xpath = "//input[@id='password-label']")
    public WebElement PASSWORD;

    @FindBy(xpath = "//button[contains(.,'Log-in')]")
    public WebElement LOGIN_BUTTONEND;

    @FindBy(xpath = "//i[@title='Cart']")
    public WebElement CART_BUTTON;

    @FindBy(xpath = "//div[@title='Favorites']")
    public WebElement FAVORITE_TAB;

    @FindBy(xpath = "//div[@title='Selected']")
    public WebElement SELECTED_TAB;

    @FindBy(xpath = "//button[@id='add-to-cart-label']")
    public WebElement ADD_ALL_TO_CART;

    @FindBy(xpath = "//button[@id='add-schedule-label']")
    public WebElement ADD_TO_SCHEDULE_BUTTON;

    @FindBy(xpath = "//button[text()='1 Sessions Successfully Added to Your Schedule ']")
    public WebElement BTN_MESSAGE;

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement BUTTON_OK;


    public SessionCatalogPreviewPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void fillLoginUsingRegisteredUser(String username, String pwd) throws Exception {
        Wait(LOGIN_BUTTON, 30);
        click(LOGIN_BUTTON);
        switchToLatestTabOrWindow();
        type(USERNAME, username, true);
        type(PASSWORD, pwd, true);
        click(LOGIN_BUTTONEND);
        logReport("Logged in");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
    }

    public void addSessionToFavourites(String sessionName) {
        String xpath = "//div[@title='Show Session Details']//span[text()='" + sessionName + "']/../..//following-sibling::div//i[@title='Add Session to Favorites']";
        click(browser.findElement(By.xpath(xpath)));
        logReport("Session added to favourites");
    }

    public void clickCartIcon() throws Exception {
        click(CART_BUTTON);
        logReport("Cart button clicked");
        VerifyAngularHasFinishedProcessing(3);
        VerifyPageReady(30);
    }

    public void clickFavoriteTab() throws Exception {
        click(FAVORITE_TAB);
        logReport("Favorite button clicked");
        VerifyAngularHasFinishedProcessing(3);
        VerifyPageReady(30);
    }

    public void clickSelectedTab() throws Exception {
        click(SELECTED_TAB);
        logReport("Selected button clicked");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
    }

    public void clickAddAllToCart() throws Exception {
        click(ADD_ALL_TO_CART);
        logReport("Add all to cart button clicked");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(10);
    }

    public void ClickAddToSchedule() throws Exception {
        click(ADD_TO_SCHEDULE_BUTTON);
        logReport("Add to schedule button clicked");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(10);
    }


}

