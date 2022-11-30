package pageObjects.Implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddPlugins;

import javax.naming.ConfigurationException;

public class PluginsPage extends CommonActionsPage {

    public PluginsPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='create-link']")
    public WebElement ADD_NEW_BUTTON;

    @FindBy(xpath = "//select[@id='third_party_id']")
    public WebElement THIRDPARTYID_DROPDOWN;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement SOAPID_TEXTBOX;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement SOAPENCRYPTION_ID_TEXTBOX;

    @FindBy(xpath = "//input[@id='partner_id']")
    public WebElement SOAPENDPOINT_TEXTBOX;

    @FindBy(xpath = "//input[@id='submitForm']")
    public WebElement SAVE_BUTTON;


    public void clickAddNewButton() throws Exception {
        Wait(ADD_NEW_BUTTON, 20);
        click(ADD_NEW_BUTTON);
        logReport("Add new button clicked successfully");
        VerifyPageReady(30);
    }

    public void selectThirdPartyValue(String value) throws Exception {
        Wait(THIRDPARTYID_DROPDOWN, 20);
        select(THIRDPARTYID_DROPDOWN, value);
        logReport("Selected third party value " + value);
        VerifyAjaxRequestsFinished(30);
    }

    public void fillPluginDetails(AddPlugins addPlugins) throws Exception {
        selectThirdPartyValue(addPlugins.getPluginName());
        type(SOAPID_TEXTBOX, addPlugins.getUserId(), true);
        type(SOAPENCRYPTION_ID_TEXTBOX, addPlugins.getPassword(), true);
        type(SOAPENDPOINT_TEXTBOX, addPlugins.getRestUrl(), true);

    }

    public void clickSaveButton() throws Exception {
        click(SAVE_BUTTON);
        logReport("Save button clicked");
        VerifyPageReady(30);
    }
}
