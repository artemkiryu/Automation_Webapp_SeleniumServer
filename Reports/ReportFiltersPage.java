package pageObjects.Reports;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by infoobjects on 11/25/2015.
 */
public class ReportFiltersPage extends CommonReportsPage {
    @FindBy(xpath = "//select[@name='dateColumn1']")
    public WebElement DATE_COLUMN1_DROPDOWN;
    @FindBy(xpath = "//select[@name='dateColumn2']")
    public WebElement DATE_COLUMN2_DROPDOWN;
    @FindBy(xpath = "//select[@name='dateRange1']")
    public WebElement DATE_RANGE1_DROPDOWN;
    @FindBy(xpath = "//select[@name='dateRange2']")
    public WebElement DATE_RANGE2_DROPDOWN;
    @FindBy(xpath = "//select[@name='drilldown_1']")
    public WebElement DRILL_DOWN_FILTER1_DROPDOWN;
    @FindBy(xpath = "//select[@name='drilldown_2']")
    public WebElement DRILL_DOWN_FILTER2_DROPDOWN;
    @FindBy(xpath = "//select[@name='drilldown_3']")
    public WebElement DRILL_DOWN_FILTER3_DROPDOWN;
    @FindBy(xpath = "//select[@name='drilldown_4']")
    public WebElement DRILL_DOWN_FILTER4_DROPDOWN;
    @FindBy(xpath = "//select[@name='drilldown_5']")
    public WebElement DRILL_DOWN_FILTER5_DROPDOWN;
    @FindBy(xpath = "//select[@name='drilldown_6']")
    public WebElement DRILL_DOWN_FILTER6_DROPDOWN;
    @FindBy(xpath = "//input[@value='Save']")
    public WebElement SAVE_BUTTON;
    @FindBy(xpath = "//select[@name='stnd_reg_complete']")
    public WebElement COMPLETE_DROPDOWN;
    @FindBy(xpath = "//select[@name='stnd_reg_registered']")
    public WebElement REGISTERED_DROPDOWN;
    @FindBy(xpath = "//select[@name='stnd_reg_statustype']")
    public WebElement STATUS_TYPE_DROPDOWN;
    @FindBy(xpath = "//select[@name='stnd_reg_appteligible']")
    public WebElement APPOINTMENT_PARTICIPANTS_DROPDOWN;
    @FindBy(xpath = "//select[@id='column1']")
    public WebElement COLUMN_DROPDOWN;
    @FindBy(xpath = "//select[@id='operator1']")
    public WebElement OPERATOR_DROPDOWN;
    @FindBy(xpath = "//input[@id='value1']")
    public WebElement VALUE_DROPDOWN;

    public ReportFiltersPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void selectDateColumn1Value(String columnName) {
        select(DATE_COLUMN1_DROPDOWN, columnName);
        logReport("Selected date column 1 value " + columnName);
    }

    public void selectDateColumn2Value(String columnName) {
        select(DATE_COLUMN2_DROPDOWN, columnName);
        logReport("Selected date column 2 value " + columnName);
    }

    public void selectDateRange1Value(String dateRange) {
        select(DATE_RANGE1_DROPDOWN, dateRange);
        logReport("Selected date range 1 value" + dateRange);
    }

    public void selectDateRange2Value(String dateRange) {
        select(DATE_RANGE2_DROPDOWN, dateRange);
        logReport("Selected date range 2 value" + dateRange);
    }

    public void selectCompleteDropdown(String completeType) {
        select(COMPLETE_DROPDOWN, completeType);
        logReport("Selected complete dropdown value" + completeType);
    }

    public void selectRegisteredDropdown(String registeredType) {
        select(REGISTERED_DROPDOWN, registeredType);
        logReport("Selected registered type value" + registeredType);
    }

    public void selectStatusTypeValue(String statusType) {
        select(STATUS_TYPE_DROPDOWN, statusType);
        logReport("Selected status type value" + statusType);
    }

    public void selectAppointmentType(String appointmentType) {
        select(APPOINTMENT_PARTICIPANTS_DROPDOWN, appointmentType);
        logReport("Selected appointment type " + appointmentType);
    }

    public void selectDrillDownFilters1Value(String filterType) {
        select(DRILL_DOWN_FILTER1_DROPDOWN, filterType);
        logReport("Selected drill down filter value" + filterType);
    }

    public void selectDrillDownFilters2Value(String filterType) {
        select(DRILL_DOWN_FILTER2_DROPDOWN, filterType);
        logReport("Selected drill down filter value" + filterType);
    }

    public void selectDrillDownFilters3Value(String filterType) {
        select(DRILL_DOWN_FILTER3_DROPDOWN, filterType);
        logReport("Selected drill down filter value" + filterType);
    }

    public void selectColumn1Value(String columnName) {
        select(COLUMN_DROPDOWN, columnName);
        logReport("Selected column1 value " + columnName);
    }

    public void selectOperator1Value(String operatorType) {
        select(OPERATOR_DROPDOWN, operatorType);
        logReport("Selected operator 1 value" + operatorType);
    }

    public void enterValue(String value) {
        type(VALUE_DROPDOWN, value, true);
        logReport("Entered value " + value);
    }

    public void clickSaveButton() throws Exception {
        click(SAVE_BUTTON);
        logReport("Save button clicked successfully");
        VerifyPageReady(20);
    }
}
