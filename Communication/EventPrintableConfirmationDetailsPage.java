package pageObjects.Communication;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.EventEmailTemplate;

/**
 * Created by infoobjects on 25-05-2017.
 */
public class EventPrintableConfirmationDetailsPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@id='txtComName']")
    public WebElement Name_Text_Box;

    @FindBy(xpath = "//input[@id='txtComDescription']")
    public WebElement Description_Text_Box;

    @FindBy(xpath = "//input[@id='submitForm']")
    public WebElement Save_Button;

    @FindBy(xpath = "//input[@id='submitNewForm']")
    public WebElement Save_And_New_Button;

    @FindBy(xpath = "//input[@id='cancelForm']")
    public WebElement Cancel_Button;


    public EventPrintableConfirmationDetailsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void fillPrintableConfirmation(EventEmailTemplate eventEmailTemplate) throws Exception {

        enterPrintableConfirmationName(eventEmailTemplate.getPrintableConfirmationName());
        enterPrintableConfirmationDescription(eventEmailTemplate.getPrintableConfirmationDescription());


    }

    public void enterPrintableConfirmationName(String name) throws Exception {
        type(Name_Text_Box, name, true);
        logReport("Entered Printable Confirmation Template Name" + name + "Successfully");
    }

    public void enterPrintableConfirmationDescription(String description) throws Exception {
        type(Description_Text_Box, description, true);
        logReport("Entered Printable Confirmation Template Description " + description + "Successfully");

    }

    public EventPrintableConfirmationPage clickSave() throws Exception {
        click(Save_Button);
        logReport("Save Button Clicked Successfully");

        return new EventPrintableConfirmationPage(browser);

    }

    public void clickSaveAndNew() throws Exception {
        click(Save_And_New_Button);
        logReport("Save and New Button Clicked Successfully");

    }

    public void clickCancel() throws Exception {
        click(Cancel_Button);
        logReport("Cancel Button Clicked Successfully");

    }

}
