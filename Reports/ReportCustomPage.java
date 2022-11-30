package pageObjects.Reports;


import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by infoobjects on 11/27/2015.
 */
public class ReportCustomPage extends CommonReportsPage {
    @FindBy(xpath = "//input[@value='Add New']")
    public WebElement ADD_NEW_BUTTON;
    @FindBy(xpath = "//input[@id='columnLabel']")
    public WebElement COLUMN_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@id='columnDataType2']")
    public WebElement COMBINE_TWO_COLUMNS_RADIOBUTTON;
    @FindBy(xpath = "//select[@id='columnDataType2DDL']")
    public WebElement DDL_DROPDOWN;
    @FindBy(xpath = "//input[@value='Append']")
    public WebElement APPEND_BUTTON;

    public ReportCustomPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void clickSaveButton() throws Exception {
        click(SAVE_BUTTON);
        logReport("Save button clicked successfully");
        VerifyPageReady(20);
    }

    public void enterColumnName(String columnName) throws Exception {
        Wait(COLUMN_NAME_TEXTBOX, 20);
        type(COLUMN_NAME_TEXTBOX, columnName);
        logReport("Entered custom column name" + columnName);
    }

    public void selectCombineColumnsRadioButton() {
        click(COMBINE_TWO_COLUMNS_RADIOBUTTON);
        logReport("Combine two columns radio button clicked successfully");
    }

    public void clickAddNewButton() throws Exception {
        click(ADD_NEW_BUTTON);
        logReport("Add new button clicked successfully");
        VerifyPageReady(30);
    }

    public void clickAppendButton() throws Exception {
        click(APPEND_BUTTON);
        logReport("Append button clicked successfully");
        VerifyPageReady(20);
    }

    public void selectColumnDdlDropdownValue(String columnName) {
        select(DDL_DROPDOWN, columnName);
        logReport("Selected column ddl dropdown value" + columnName);
    }

    public void selectColumnDdlAndAppendButton(String columnName) throws Exception {
        selectColumnDdlDropdownValue(columnName);
        clickAppendButton();
    }
}
