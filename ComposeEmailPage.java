package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.naming.ConfigurationException;

public class ComposeEmailPage extends CommonActionsPage {

    @FindBy(xpath = "//select[@id='my_select']")
    public WebElement EMAIL_TEMPLATE_DROPDOWN;

    @FindBy(xpath = "//input[@value='Send Email NOW']")
    public WebElement SEND_EMAIL_BUTTON;


    public ComposeEmailPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void selectEmailTemplateDropdown(String templateName) throws Exception {
        Wait(EMAIL_TEMPLATE_DROPDOWN, 30);
        select(EMAIL_TEMPLATE_DROPDOWN, templateName);
        VerifyAjaxRequestsFinished(30);
        logReport("Selected email template value " + templateName);
    }

    public void clickEmailSendButton() throws Exception {
        click(SEND_EMAIL_BUTTON);
        logReport("Send email button clicked successfully");
        //VerifyPageReady(30);

    }
}
