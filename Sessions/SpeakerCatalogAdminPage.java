package pageObjects.Sessions;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

public class SpeakerCatalogAdminPage extends CommonActionsPage {
    @FindBy(xpath = "//a[@aria-label='Data']")
    public WebElement DATA_TAB;

    @FindBy(xpath = "//a[@title='General']")
    public WebElement GENERAL_TAB;

    @FindBy(xpath = "//button[text()='Preview']")
    public WebElement SAVEPREVIEW_BUTTON;

    public SpeakerCatalogAdminPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void clickOnDataTab() throws Exception {
        Wait(DATA_TAB, 30);
        click(DATA_TAB);
        logReport("Data tab clicked successfully");
        VerifyPageReady(30);
    }

    public void clickOnGeneralTab() throws Exception {
        Wait(GENERAL_TAB, 30);
        clickByJavaScript(GENERAL_TAB);
        logReport("General tab clicked successfully");
        VerifyAngularHasFinishedProcessing(3);
        VerifyPageReady(30);
    }

    public SpeakerCatalogPreviewPage clickSaveAndPreviewButton() throws Exception {
        Wait(SAVEPREVIEW_BUTTON, 30);
        click(SAVEPREVIEW_BUTTON);
        logReport("Save and preview button clicked");
        VerifyAngularHasFinishedProcessing(3);
        VerifyPageReady(30);
        return new SpeakerCatalogPreviewPage(browser);

    }

}
