package pageObjects.Reports;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by infoobjects on 11/23/2015.
 */
public class ReportGroupsPage extends CommonReportsPage {
    @FindBy(xpath = "//input[@id='hideDetails']")
    public WebElement HIDE_DETAILS_CHECKBOX;
    @FindBy(xpath = "//input[@id='showHeaderWithGroup']")
    public WebElement DISPLAY_COLUMN_HEADER_ROW_CHECKBOX;
    @FindBy(xpath = "//select[@name='column1']")
    public WebElement SUMMARIZE_BY_DROPDOWN;
    @FindBy(xpath = "//select[@name='sort_order1']")
    public WebElement SUMMARIZE_BY_SORT_DROPDOWN;
    @FindBy(xpath = "//select[@name='date_group1']")
    public WebElement SUMMARIZE_BY_DATES_DROPDOWN;
    @FindBy(xpath = "//select[@name='column2']")
    public WebElement THEN_BY_DROPDOWN;
    @FindBy(xpath = "//select[@name='sort_order2']")
    public WebElement THEN_BY_SORT_DROPDOWN;
    @FindBy(xpath = "//select[@name='date_group2']")
    public WebElement THEN_BY_DATES_DROPDOWN;
    @FindBy(xpath = "//select[@name='column3']")
    public WebElement FINALLY_BY_DROPDOWN;
    @FindBy(xpath = "//select[@name='sort_order3']")
    public WebElement FINALLY_BY_SORT_DROPDOWN;
    @FindBy(xpath = "//select[@name='date_group3']")
    public WebElement FINALLY_BY_DATES_DROPDOWN;

    public ReportGroupsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void checkHideDetailsCheckbox() {
        check(HIDE_DETAILS_CHECKBOX);
        logReport("Hide report details checkbox checked successfully");
    }

    public void checkDisplayColumnRowCheckbox() {
        check(DISPLAY_COLUMN_HEADER_ROW_CHECKBOX);
        logReport("Display column header row checkbox checked successfully");
    }

    public void selectSummarizeByValue(String regField) {
        select(SUMMARIZE_BY_DROPDOWN, regField);
        logReport("Selected summarize by value " + regField);
    }

    public void selectSummarizeSortValue(String sortType) {
        select(SUMMARIZE_BY_SORT_DROPDOWN, sortType);
        logReport("Selected summarize by sort value" + sortType);
    }

    public void selectSummarizeDatesValue(String dateFormat) {
        if (!SUMMARIZE_BY_DATES_DROPDOWN.getAttribute("disabled").isEmpty()) {
            select(SUMMARIZE_BY_DATES_DROPDOWN, dateFormat);
            logReport("Selected summarize by dates value" + dateFormat);
        }

    }

    public void selectThenByValue(String regField) {
        select(THEN_BY_DROPDOWN, regField);
        logReport("Selected then by value " + regField);
    }

    public void selectThenSortValue(String sortType) {
        select(THEN_BY_SORT_DROPDOWN, sortType);
        logReport("Selected then by sort value" + sortType);
    }

    public void selectThenDatesValue(String dateFormat) {
        select(THEN_BY_DATES_DROPDOWN, dateFormat);
        logReport("Selected then by dates value" + dateFormat);
    }

    public void selectFinallyByValue(String regField) {
        select(FINALLY_BY_DROPDOWN, regField);
        logReport("Selected finally by value " + regField);
    }

    public void selectFinallySortValue(String sortType) {
        select(FINALLY_BY_SORT_DROPDOWN, sortType);
        logReport("Selected finally by sort value" + sortType);
    }

    public void selectFinallyDatesValue(String dateFormat) {
        if (!FINALLY_BY_DATES_DROPDOWN.getAttribute("disabled").isEmpty()) {
            select(FINALLY_BY_DATES_DROPDOWN, dateFormat);
            logReport("Selected finally by dates value" + dateFormat);
        }

    }

    public void clickSaveButton() throws Exception {
        click(SAVE_BUTTON);
        logReport("Save button clicked successfully");
        VerifyPageReady(20);
    }

}
