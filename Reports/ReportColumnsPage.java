package pageObjects.Reports;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


/**
 * Created by infoobjects on 11/24/2015.
 */
public class ReportColumnsPage extends CommonReportsPage {

    @FindBy(xpath = "//select[@name='data_fields']")
    public WebElement AVAILABLE_DATA_FIELDS_LISTBOX;
    @FindBy(xpath = "//select[@id='dataFields']")
    public WebElement SELECTED_DATA_FIELDS_LISTBOX;
    @FindBy(xpath = "//input[@title='Move Selected Item(s) to the Right']")
    public WebElement MOVE_RIGHT_BUTTON;
    @FindBy(xpath = "//input[@title='Move Selected Item(s) to the Left']")
    public WebElement MOVE_LEFT_BUTTON;
    @FindBy(xpath = "//input[@value='Save']")
    public WebElement SAVE_BUTTON;
    @FindBy(xpath = "//select[@name='orderBy1']")
    public WebElement ORDER_BY1_DROPDOWN;
    @FindBy(xpath = "//select[@name='orderBy2']")
    public WebElement ORDER_BY2_DROPDOWN;
    @FindBy(xpath = "//select[@name='orderBy3']")
    public WebElement ORDER_BY3_DROPDOWN;
    @FindBy(xpath = "//select[@name='orderBy4']")
    public WebElement ORDER_BY4_DROPDOWN;
    @FindBy(xpath = "//select[@name='sortOrder1']")
    public WebElement SORT_BY1_DROPDOWN;
    @FindBy(xpath = "//select[@name='sortOrder2']")
    public WebElement SORT_BY2_DROPDOWN;
    @FindBy(xpath = "//select[@name='sortOrder3']")
    public WebElement SORT_BY3_DROPDOWN;
    @FindBy(xpath = "//select[@name='sortOrder4']")
    public WebElement SORT_BY4_DROPDOWN;
    @FindBy(xpath = "//input[@value='Customize Reports Columns']")
    public WebElement CUSTOMIZE_REPORT_COLUMN_BUTTON;
    @FindBy(xpath = "//input[@id='showRowNumbers']")
    public WebElement SHOW_ROW_NUMBER_CHECKBOX;

    public ReportColumnsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void selectAvailableDataFieldsItem(String regFields) {
        select(AVAILABLE_DATA_FIELDS_LISTBOX, regFields);
        logReport("Selected available data fields item " + regFields);
    }

    public void moveItemsInList(String a) {
        String b[] = a.split(",");
        for (String s : b) {
            selectAvailableDataFieldsItem(s);
            clickMoveRightButton();
        }
    }
    public void clickAvailableDataFieldsItem(String fieldName) throws Exception {
        String xpath = "//select[@name='data_fields']/option[text()='" + fieldName + "']";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 20);
        click(element);
    }

    public void clickMoveRightButton() {
        click(MOVE_RIGHT_BUTTON);
        logReport("Move right button clicked successfully");
    }

    public void moveAvailableItemsToDataFields(String regFields) {
        selectAvailableDataFieldsItem(regFields);
        clickMoveRightButton();
    }

    public void checkShowRowNumberCheckbox() {
        check(SHOW_ROW_NUMBER_CHECKBOX);
        logReport("Show row number checkbox checked successfully");
    }

    public void selectOrder1Value(String regField) {
        select(ORDER_BY1_DROPDOWN, regField);
        logReport("Selected order by 1 dropdown value " + regField);
    }

    public void selectOrder2Value(String regField) {
        select(ORDER_BY2_DROPDOWN, regField);
        logReport("Selected order by 2 dropdown value " + regField);
    }

    public void selectOrder3Value(String regField) {
        select(ORDER_BY3_DROPDOWN, regField);
        logReport("Selected order by 3 dropdown value " + regField);
    }

    public void selectOrder4Value(String regField) {
        select(ORDER_BY4_DROPDOWN, regField);
        logReport("Selected order by 4 dropdown value " + regField);
    }

    public void selectSortBy1Value(String sortType) {
        select(SORT_BY1_DROPDOWN, sortType);
        logReport("Selected sort by 1 value " + sortType);
    }

    public void selectSortBy2Value(String sortType) {
        select(SORT_BY2_DROPDOWN, sortType);
        logReport("Selected sort by 2 value " + sortType);
    }

    public void selectSortBy3Value(String sortType) {
        select(SORT_BY3_DROPDOWN, sortType);
        logReport("Selected sort by 3 value " + sortType);
    }

    public void selectSortBy4Value(String sortType) {
        select(SORT_BY4_DROPDOWN, sortType);
        logReport("Selected sort by 4 value " + sortType);
    }

    public CustomizeReportColumnsPage clickCustomizeReportButton() throws Exception {
        click(CUSTOMIZE_REPORT_COLUMN_BUTTON);
        logReport("Customize report column button clicked successfully");
        return new CustomizeReportColumnsPage(browser);
    }

    public void clickSaveButton() throws Exception {
        click(SAVE_BUTTON);
        logReport("Save button clicked successfully");
        VerifyPageReady(30);
    }

    public ReportResultsPage clickRunReportButton() throws Exception {
        click(RUN_REPORT_BUTTON);
        logReport("Clicked on Run Report button");
        return new ReportResultsPage(browser);
    }

    public void selectAvailableDataItemFieldsOptions(String option) {
        String xpath = "//select[@name='data_fields']//option";
        List<WebElement> elements = browser.findElements(By.xpath(xpath));
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().trim().contains(option)) {
                elements.get(i).click();
            }
        }
    }

}
