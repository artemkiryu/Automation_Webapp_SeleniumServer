package pageObjects.Forms;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

/**
 * Created by infoobjects on 21-08-2017.
 */
public class FormListPage extends CommonActionsPage {

    @FindBy(xpath = "//*[text()[contains(.,'Add Form')]]")
    public WebElement ADD_FORM_BUTTON;

    @FindBy(xpath = "//td[contains(.,'Registration Form')]//..//..//a[@title='Edit this form']")
    public WebElement EDIT_PRIMARY_FORM_BUTTON;

    public FormListPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public AddFormPage clickAddFormButton() throws Exception {
        Wait(ADD_FORM_BUTTON, 30);
        click(ADD_FORM_BUTTON);
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
        return new AddFormPage(browser);
    }

    public SetUpPage clickEditPrimaryFormButton() throws Exception {
        Wait(EDIT_PRIMARY_FORM_BUTTON, 30);
        clickByJavaScript(EDIT_PRIMARY_FORM_BUTTON);
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
        return new SetUpPage(browser);
    }
}
