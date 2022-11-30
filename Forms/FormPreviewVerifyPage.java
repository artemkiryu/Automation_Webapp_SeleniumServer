package pageObjects.Forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;

public class FormPreviewVerifyPage extends CommonActionsPage {
    public FormPreviewVerifyPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public FormPreviewConfirmPage clickContinueButton() throws Exception {
        Wait(CONTINUE_BUTTON, 20);
        click(CONTINUE_BUTTON);
        VerifyPageReady(30);
        reporter.info("Continue button clicked successfully");
        return new FormPreviewConfirmPage(browser);

    }

    public FormPreviewPaymentPage clickContinueButtonPayment() throws Exception {
        Wait(CONTINUE_BUTTON, 20);
        click(CONTINUE_BUTTON);
        VerifyPageReady(30);
        reporter.info("Continue button clicked successfully");
        return new FormPreviewPaymentPage(browser);

    }
}
