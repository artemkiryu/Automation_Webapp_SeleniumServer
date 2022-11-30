package pageObjects.Forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;

public class FormPreviewHomePage extends CommonActionsPage {
    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement CONTINUE_BUTTON;

    public FormPreviewHomePage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public FormPreviewRegistrantDetailsPage clickContinueButton() throws Exception {
        Wait(CONTINUE_BUTTON, 20);
        click(CONTINUE_BUTTON);
        VerifyPageReady(30);
        reporter.info("Continue button clicked successfully");
        return new FormPreviewRegistrantDetailsPage(browser);

    }

}

