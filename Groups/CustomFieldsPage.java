package pageObjects.Groups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.GroupCustomFieldData;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 29-08-2017.
 */
public class CustomFieldsPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@x-ng-model='addCustomField.code']")
    public WebElement CUSTOM_FIELD_TEXTBOX;
    @FindBy(xpath = "//input[@title='Add Custom Field']")
    public WebElement ADD_NEW_CUSTOM_BUTTON;

    public CustomFieldsPage(WebDriver driver) throws ConfigurationException{
        PageFactory.initElements(driver, this);
    }

    public void addCustomField(GroupCustomFieldData groupCustomFieldData) throws Exception{
        Wait(ADD_NEW_CUSTOM_BUTTON, 15);
        type(CUSTOM_FIELD_TEXTBOX, groupCustomFieldData.getCustomFieldName());
        click(ADD_NEW_CUSTOM_BUTTON);
        logReport("Add custom field clicked successfully");
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
    }
}
