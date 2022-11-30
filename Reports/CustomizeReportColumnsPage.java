package pageObjects.Reports;


import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by infoobjects on 11/25/2015.
 */
public class CustomizeReportColumnsPage extends CommonReportsPage {
    @FindBy(xpath = "//input[@value='Save']")
    public WebElement SAVE_BUTTON;
    @FindBy(xpath = "//input[@name='txtProFName']")
    public WebElement FIRST_NAME_COLUMN_LABEL;
    @FindBy(xpath = "//input[@name='txtProLName']")
    public WebElement LAST_NAME_COLUMN_LABEL;
    @FindBy(xpath = "//input[@value='Save and Close']")
    public WebElement SAVE_AND_CLOSE_BUTTON;

    public CustomizeReportColumnsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for entering first name custom label
     *
     * @param label value of custom label
     */
    public void enterFirstNameCustomLabel(String label) {
        type(FIRST_NAME_COLUMN_LABEL, label, true);
        logReport("Entered first name column label " + label);
    }

    /**
     * Method for entering last name custom label
     *
     * @param label value of custom label
     */
    public void enterLastNameCustomLabel(String label) {
        type(LAST_NAME_COLUMN_LABEL, label, true);
        logReport("Entered last name column label " + label);
    }


    public ReportColumnsPage clickSaveAndCloseButton() throws Exception {
        click(SAVE_AND_CLOSE_BUTTON);
        logReport("Save and close button clicked successfully");
        return new ReportColumnsPage(browser);
    }

    /**
     * Method for clicking save button
     */
    public void clickSaveButton() {
        click(SAVE_BUTTON);
        logReport("Save button clicked successfully");
    }
}
