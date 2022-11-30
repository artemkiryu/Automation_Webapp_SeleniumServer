package pageObjects.Reports;


import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pojo.AddReportData;

import java.util.List;


/**
 * Created by infoobjects on 5/25/2015.
 */
public class SetupReportPage extends CommonReportsPage {
    public static final String SUB_REPORT_VALUE1 = "Registration Approval Statuses";
    public static final String SUB_REPORT_VALUE2 = "EventRegistrations";
    public static final String SUB_REPORT_VALUE3 = "Registration History";
    public static final String SUB_REPORT_VALUE4 = "Registration Modifications";
    public static final String SUB_REPORT_VALUE5 = "Charges";
    public static final String SUB_REPORT_VALUE6 = "Invoices";
    public static final String SUB_REPORT_VALUE7 = "Payments and Refunds";
    public static final String SUB_REPORT_VALUE8 = "Transactions";
    public static final String SUB_REPORT_VALUE9 = "Hotel Room Inventory";
    public static final String SUB_REPORT_VALUE10 = "Roommates";
    public static final String SUB_REPORT_VALUE11 = "Room Reservations";
    public static final String SUB_REPORT_VALUE12 = "Room Reservation Modifications";
    public static final String SUB_REPORT_VALUE13 = "Registration Agenda";
    public static final String SUB_REPORT_VALUE14 = "Registration Agenda with Travel Questions";
    public static final String SUB_REPORT_VALUE15 = "EventRegistrations with Agenda Items";
    public static final String SUB_REPORT_VALUE16 = "EventRegistrations with Agenda Groups/Sessions";
    public static final String SUB_REPORT_VALUE17 = "EventRegistrations with Agenda Items and Questions";
    public static final String SUB_REPORT_VALUE18 = "EventRegistrations with Agenda Start Times";
    public static final String SUB_REPORT_VALUE19 = "Registration Reports";
    public static final String SUB_REPORT_VALUE20 = "Financial Reports";
    public static final String SUB_REPORT_VALUE21 = "Accommodation Reports";
    public static final String SUB_REPORT_VALUE22 = "Agenda Data Reports";
    public static final String SUB_REPORT_VALUE23 = "Package Reports";
    public static final String SUB_REPORT_VALUE24 = "Planning";
    public static final String SUB_REPORT_VALUE25 = "Viral EventRegistrations";
    public static final String SUB_REPORT_VALUE26 = "Travel Reports";
    public static final String SUB_REPORT_VALUE27 = "Registration and Travel";
    public static final String SUB_REPORT_VALUE28 = "Travel Flights";
    public static final String SUB_REPORT_VALUE29 = "Roommates and Travel";
    public static final String SUB_REPORT_VALUE30 = "Room Reservations and Travel";
    public static final String SUB_REPORT_VALUE31 = "Registration Group Reports";
    public static final String SUB_REPORT_VALUE32 = "Registration Groups";
    @FindBy(xpath = "//div[@id='ReportNameId']")
    public WebElement REPORT_NAME_SECTION;
    @FindBy(xpath = "//div[@id='VisibilityId']")
    public WebElement VISIBILITY_SECTION;
    @FindBy(xpath = "//div[@id='ReportTypeId']")
    public WebElement REPORT_TYPE_SECTION;
    @FindBy(xpath = "//input[@id='rpt_name']")
    public WebElement REPORT_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@name='rpt_desc']")
    public WebElement DESCRIPTION_TEXTBOX;
    @FindBy(xpath = "//input[@name='new_rpt_group']")
    public WebElement GROUP_TEXTBOX;
    @FindBy(xpath = "//input[@name='new_rpt_group']")
    public WebElement ENTER_NEWGROUP_TEXTBOX;
    @FindBy(xpath = "//input[@id='bitShowSelectList']")
    public WebElement SHOW_SELECTEDUSER_CHECKBOX;
    @FindBy(xpath = "//input[@id='bitIsRptApiAccessible']")
    public WebElement ALLOWACCESS_WEBSERVICES_CHECKBOX;
    @FindBy(xpath = "//select[@id='rpt_show_to_frn_usr_id']")
    public WebElement SELECTUSER_COMBOBOX;
    @FindBy(xpath = "//label[text() = 'Registration Approval Statuses']")
    public WebElement APPROVALSTATUS_RADIOBUTTON;
    @FindBy(xpath = "//input[@value='eventRegistration']")
    public WebElement REGISTRATION_RADIOBUTTON;
    @FindBy(xpath = "//label[text() = 'Registration History']")
    public WebElement REGISTRATIONHISTORY_RADIOBUTTON;
    @FindBy(xpath = "//label[text() = 'Viral EventRegistrations']")
    public WebElement VIRAL_REGISTRATION_RADIOBUTTON;
    @FindBy(xpath = "//label[text() = 'Registration Modifications']")
    public WebElement REGISTRATIONMODIFICATIONS_RADIOBUTTON;
    @FindBy(xpath = "//label[text() = 'Charges']")
    public WebElement CHARGES_RADIOBUTTON;
    @FindBy(xpath = "//label[text() = 'Invoices']")
    public WebElement INVOICES_RADIOBUTTON;
    @FindBy(xpath = "//label[text() = 'Payments and Refunds']")
    public WebElement PAYMENTSANDREFUNDS_RADIOBUTTON;
    @FindBy(xpath = "//label[text() = 'Transactions']")
    public WebElement TRANSACTIONS_RADIOBUTTON;
    @FindBy(xpath = "//label[text() = 'Hotel Room Inventory']")
    public WebElement HOTEL_ROOMINVENTARY_RADIOBUTTON;
    @FindBy(xpath = "//label[text() = 'Roommates']")
    public WebElement ROOMMATES_RADIOBUTTON;
    @FindBy(xpath = "//label[text() = 'Room Reservations']")
    public WebElement ROOM_RESERVATION_RADIOBUTTON;
    @FindBy(xpath = "//label[text() = 'Room Reservation Modifications']")
    public WebElement ROOM_RESERVATION_MODIFICATION_RADIOBUTTON;
    @FindBy(xpath = "//label[text() = 'Registration Agenda']")
    public WebElement REGISTRATION_AGENDA_RADIOBUTTON;
    @FindBy(xpath = "//label[text() = 'Registration Agenda with Travel Questions']")
    public WebElement REGISTRATION_AGENDA_TRAVEL_RADIOBUTTON;
    @FindBy(xpath = "//label[text() = 'EventRegistrations with Agenda Items']")
    public WebElement REGISTRATION_WITHAGENDA_RADIOBUTTON;
    @FindBy(xpath = "//label[text() = 'EventRegistrations with Agenda Groups/Sessions']")
    public WebElement REGISTRATION_WITHAGENDA_GROUP_RADIOBUTTON;
    @FindBy(xpath = "//label[text() = 'EventRegistrations with Agenda Items and Questions']")
    public WebElement REGISTRATION_WITHAGENDA_ITEMSANDQUESTIONS_RADIOBUTTON;
    @FindBy(xpath = "//label[text() = 'EventRegistrations with Agenda Start Times']")
    public WebElement REGISTRATION_WITHAGENDA_STARTTIME_RADIOBUTTON;
    @FindBy(xpath = "//label[text() = 'Registration and Travel']")
    public WebElement REGISTRATION_AND_TRAVEL_RADIOBUTTON;
    @FindBy(xpath = "//label[text() = 'Travel Flights']")
    public WebElement TRAVEL_FLIGHTS_RADIOBUTTON;
    @FindBy(xpath = "//label[text() = 'Roommates and Travel']")
    public WebElement ROOMMATES_AND_TRAVEL_RADIOBUTTON;
    @FindBy(xpath = "//label[text() = 'EventRegistrations with Packages']")
    public WebElement REGISTRATION_WITHPACKAGE_RADIOBUTTON;
    @FindBy(xpath = "//label[text() = 'Registration Groups']")
    public WebElement REGISTRATION_GROUPS_RADIOBUTTON;
    @FindBy(xpath = "//label[contains(text(),'Tasks')]")
    public WebElement TASKS_RADIOBUTTON;
    @FindBy(xpath = "//input[@id='bitLock']")
    public WebElement LOCKREPORT_CHECKBOX;
    @FindBy(xpath = "//label[text() = 'Roommates and Travel']")
    public WebElement ROOM_RESERVATIONS_RADIOBUTTON;
    @FindBy(xpath = "//table[@class='table-condensed']//tbody//tr//td//label")
    public WebElement REPORTCHANGES_OPTION_CHECKBOX;
    @FindBy(xpath = "//table[@id='dspShowModifyRow']//tbody//tr//td//label")
    public WebElement SHOW_MODIFIEDERCORDS_RADIOBUTTON;
    @FindBy(xpath = "//a[@title='Reports']")
    public WebElement REPORT_SUBTAB;
    @FindBy(xpath = "//input[@id='bitShowNew']")
    public WebElement SHOW_NEWRECORDS_CHECKBOX;
    @FindBy(xpath = "//input[@id='bitShowRemoved']")
    public WebElement SHOW_REMOVEDRECORDS_CHECKBOX;
    @FindBy(xpath = "//input[@id='bitShowModified']")
    public WebElement SHOW_MODIFIEDERECORDS_CHECKBOX;
    @FindBy(xpath = "//label[contains(.,'Show changed fields within the row')]")
    public WebElement SHOWCHANGEDFIELDS_WITHINROW_RADIOBUTTON;
    @FindBy(xpath = "//label[contains(.,'Show changed fields in separate rows')]")
    public WebElement SHOWCHANGEDFIELDS_SEPERATEROW_RADIOBUTTON;
    @FindBy(xpath = "//h4[contains(.,'Success')]")
    public WebElement MESSAGE_BOX;
    @FindBy(xpath = "//input[@id='bitLock']")
    public WebElement COLOR_CHECKBOX;
    @FindBy(xpath = "//input[@id='bitShowBold']")
    public WebElement BOLD_CHECKBOX;
    @FindBy(xpath = "//input[@id='bolShowBrackets']")
    public WebElement BRACKETS_CHECKBOX;
    @FindBy(xpath = "//input[@id='bitShowUnderline']")
    public WebElement UNDERLINE_CHECKBOX;
    @FindBy(xpath = "//input[@id='bitShowChangesInSeparateColumn']")
    public WebElement SHOWCHANGES_UNDERLABEL_CHECKBOX;
    @FindBy(xpath = "//div[@id='ReportTypeId']//td[contains(.,'Report Type')]/following-sibling::td")
    public WebElement REPORT_TYPE_VALUE;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[contains(.,'Display')]")
    public WebElement DISPLAY_SIDE_MENU_LINK;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[contains(.,'Columns')]")
    public WebElement COLUMNS_SIDE_MENU_TAB;
    @FindBy(xpath = "//input[@value='Delete']")
    public WebElement DELETE_BUTTON;
    @FindBy(xpath = "//input[@value='Restore']")
    public WebElement RESTORE_BUTTON;
    @FindBy(xpath = "//div[contains(text(), 'Report Type')]//following-sibling::div//table[@class='forms']//strong")
    public WebElement REPORT_TYPE_CHANGE;
    @FindBy(xpath = "//label[text()='Lock report to allow Changes Report options']")
    public WebElement LOCK_REPORT_CHECKBOX;
    @FindBy(xpath = "//label[text()='Show new records under label']")
    public WebElement SHOW_NEW_RECORDS_CHECKBOX;
    @FindBy(xpath = "//label[text()='Show removed records under label']")
    public WebElement SHOW_REMOVED_RECORDS_CHECKBOX;
    @FindBy(xpath = "//label[text()='Show modified records under label']")
    public WebElement SHOW_MODIFIED_RECORDS_CHECKBOX;
    @FindBy(xpath = "//label[text()='Show changed fields within the row:']")
    public WebElement SHOW_WITHIN_ROW_RADIO_BUTTON;
    @FindBy(xpath = "//label[text()='Show changed fields in separate rows:']")
    public WebElement SHOW_IN_SEPARATE_ROWS_RADIO_BUTTON;
    @FindBy(xpath = "//label[text()='Show changes in a separate column under label']")
    public WebElement SHOW_CHANGES_IN_SEPARATE_COLUMN_CHECKBOX;
    @FindBy(xpath = "//input[@name='txtshowNewLabel']")
    public WebElement NEW_RECORDS_LABEL_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@name='txtShowRemovedLabel']")
    public WebElement REMOVED_RECORDS_LABEL_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@name='txtShowModifiedLabel']")
    public WebElement MODIFIED_RECORDS_LABEL_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@name='txtShowChangesInSeparateColumnLabel']")
    public WebElement SEPARATE_COLUMN_NAME_TEXTBOX;
    @FindBy(xpath = "//div[@class='panel-heading' and contains(text(), 'Changes Report Options')]")
    public WebElement CHANGES_REPORT_OPTIONS_SECTION;
    @FindBy(xpath = "//div[@class='panel-heading' and contains(text(), 'Roles-Based Access')]")
    public WebElement ROLE_BASED_ACCESS_SECTION;
    @FindBy(xpath = "//strong[text()='Registration Group Reports']")
    public WebElement REGISTRATION_GROUP_REPORTS;

    @FindBy(xpath = "//select[@id='data_fields']")
    public WebElement AVAILABLE_DATA_FIELDS_DROPDOWN;
    @FindBy(xpath = "//input[@value='»']")
    public WebElement MOVE_SELECTED_ITEM_TO_RIGHT_BUTTON;

    @FindBy(xpath = "//input[@id='eventConfSessionSpeakers']")
    public WebElement SPEAKERS_RADIOBUTTON;

    public SetupReportPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to enter room name in the textbox.
     *
     * @param reportName : name of report
     */
    private void enterReportName(String reportName) {
        type(REPORT_NAME_TEXTBOX, reportName, true);
        logReport("Entered value: " + reportName + " in 'Name' textbox.");
    }

    /**
     * Method to enter description about room in the textbox.
     *
     * @param description : description about the report.
     */
    private void enterDescription(String description) {
        type(DESCRIPTION_TEXTBOX, description, true);
        logReport("Entered value: " + description + " in 'Description' textbox.");
    }

    /**
     * Method to enter group of report in the textbox.
     *
     * @param group : value of group of report
     */
    private void enterReportGroup(String group) {
        type(GROUP_TEXTBOX, group, true);
        logReport("Entered value: " + group + " in 'Group' textbox.");
    }

    /**
     * Method to enter Report Name
     *
     * @param addReportData Page object of AddReportData.
     */
    public void fillReportName(AddReportData addReportData) {
        enterReportName(addReportData.getReportName());
        enterDescription(addReportData.getDescription());
        enterReportGroup(addReportData.getReportGroup());
        checkUncheckShowToSelectedUserCheckBox(addReportData.isShowSelectedUser());
        checkUncheckAllowAccessCheckBox(addReportData.isAllowAccessWebService());
    }

    public void fillReportName(String reportName) {
        enterReportName(reportName);
        enterDescription(reportName);
        checkUncheckShowToSelectedUserCheckBox(true);
        checkUncheckAllowAccessCheckBox(true);
    }

    /**
     * Method to modified Report Name.
     *
     * @param addReportData Page object of AddReportData.
     */
    public void modifiedReportName(AddReportData addReportData) throws Exception {
        enterReportName(addReportData.getReportName());
        enterDescription(addReportData.getDescription());
        clickSaveButton();
    }

    /**
     * Method to check the show to selected user checkbox.
     */
    public void checkUncheckShowToSelectedUserCheckBox(boolean state) {
        if (state) {
            check(SHOW_SELECTEDUSER_CHECKBOX);
            logReport("Show selected user checkbox checked successfully");
        } else {
            unCheck(SHOW_SELECTEDUSER_CHECKBOX);
            logReport("Show selected user checkbox unchecked successfully");
        }
    }

    /**
     * Method to check the show allow access checkbox.
     */
    public void checkUncheckAllowAccessCheckBox(boolean state) {
        if (state) {
            checkByJavascript(ALLOWACCESS_WEBSERVICES_CHECKBOX);
            logReport("Allow access webservices checkbox checked successfully");
        } else {
            unCheck(ALLOWACCESS_WEBSERVICES_CHECKBOX);
            logReport("Allow access webservices checkbox unchecked successfully");
        }

    }


    /**
     * Method to select registration report.
     *
     * @param subReport: registration report name.
     */

    private void setRegistrationReports(String subReport) {
        if (subReport.equalsIgnoreCase(SUB_REPORT_VALUE1)) {
            click(APPROVALSTATUS_RADIOBUTTON);
        } else if (subReport.equalsIgnoreCase(SUB_REPORT_VALUE2)) {
            click(REGISTRATION_RADIOBUTTON);
        } else if (subReport.equalsIgnoreCase(SUB_REPORT_VALUE3)) {
            click(REGISTRATIONHISTORY_RADIOBUTTON);
        } else if (subReport.equalsIgnoreCase(SUB_REPORT_VALUE4)) {
            click(REGISTRATIONMODIFICATIONS_RADIOBUTTON);
        } else if (subReport.equalsIgnoreCase(SUB_REPORT_VALUE25))
            click(VIRAL_REGISTRATION_RADIOBUTTON);

    }

    private void setTravelReport(String subReport) {
        if (subReport.equalsIgnoreCase(SUB_REPORT_VALUE27)) {
            click(REGISTRATION_AND_TRAVEL_RADIOBUTTON);
        } else if (subReport.equalsIgnoreCase(SUB_REPORT_VALUE28)) {
            click(TRAVEL_FLIGHTS_RADIOBUTTON);
        } else if (subReport.equalsIgnoreCase(SUB_REPORT_VALUE29)) {
            click(ROOMMATES_AND_TRAVEL_RADIOBUTTON);
        } else if (subReport.equalsIgnoreCase(SUB_REPORT_VALUE30)) {
            click(ROOM_RESERVATIONS_RADIOBUTTON);
        }
    }

    private void setGroupReport(String subReport) {
        if (subReport.equalsIgnoreCase(SUB_REPORT_VALUE32)) {
            click(REGISTRATION_GROUPS_RADIOBUTTON);
        }
    }

    /**
     * Method to set financial report.
     *
     * @param subReport : sub report name.
     */
    private void setFinancialReports(String subReport) {
        if (subReport.equalsIgnoreCase(SUB_REPORT_VALUE5)) {
            click(CHARGES_RADIOBUTTON);
        } else if (subReport.equalsIgnoreCase(SUB_REPORT_VALUE6)) {
            click(INVOICES_RADIOBUTTON);
        } else if (subReport.equalsIgnoreCase(SUB_REPORT_VALUE7)) {
            click(PAYMENTSANDREFUNDS_RADIOBUTTON);
        } else if (subReport.equalsIgnoreCase(SUB_REPORT_VALUE8)) {
            click(TRANSACTIONS_RADIOBUTTON);
        }
    }

    /**
     * Method to set Accommodation report.
     *
     * @param subReport : sub report name.
     */
    private void setAccommodationReports(String subReport) {
        if (subReport.equalsIgnoreCase(SUB_REPORT_VALUE9)) {
            click(HOTEL_ROOMINVENTARY_RADIOBUTTON);
        } else if (subReport.equalsIgnoreCase(SUB_REPORT_VALUE10)) {
            click(ROOMMATES_RADIOBUTTON);
        } else if (subReport.equalsIgnoreCase(SUB_REPORT_VALUE11)) {
            click(ROOM_RESERVATION_RADIOBUTTON);
        } else if (subReport.equalsIgnoreCase(SUB_REPORT_VALUE12)) {
            click(ROOM_RESERVATION_MODIFICATION_RADIOBUTTON);
        }
    }

    /**
     * Method to set Agenda data report.
     *
     * @param subReport : sub report name.
     */
    private void setAgendaDataReports(String subReport) {
        if (subReport.equalsIgnoreCase(SUB_REPORT_VALUE13)) {
            click(REGISTRATION_AGENDA_RADIOBUTTON);
        } else if (subReport.equalsIgnoreCase(SUB_REPORT_VALUE14)) {
            click(REGISTRATION_AGENDA_TRAVEL_RADIOBUTTON);
        } else if (subReport.equalsIgnoreCase(SUB_REPORT_VALUE15)) {
            click(REGISTRATION_WITHAGENDA_RADIOBUTTON);
        } else if (subReport.equalsIgnoreCase(SUB_REPORT_VALUE16)) {
            click(REGISTRATION_WITHAGENDA_GROUP_RADIOBUTTON);
        } else if (subReport.equalsIgnoreCase(SUB_REPORT_VALUE17)) {
            click(REGISTRATION_WITHAGENDA_ITEMSANDQUESTIONS_RADIOBUTTON);
        } else if (subReport.equalsIgnoreCase(SUB_REPORT_VALUE18)) {
            click(REGISTRATION_WITHAGENDA_STARTTIME_RADIOBUTTON);
        }
    }

    /**
     * Method to set Package report.
     */
    private void setPackageReport() {
        click(REGISTRATION_WITHPACKAGE_RADIOBUTTON);
    }

    /**
     * Method to set Planning of the report.
     */
    private void setPlanning() {
        click(TASKS_RADIOBUTTON);
    }


    /**
     * Method to click on report sub tab.
     */
    public ReportHomePage clickReportsSubTab() throws Exception {
        click(REPORT_SUBTAB);
        VerifyPageReady(20);
        return new ReportHomePage(browser);
    }

    /**
     * Method to check the Lock Report checkbox.
     */
    public void checkLockReportToAllowChangesCheckBox() {
        if (!LOCKREPORT_CHECKBOX.isSelected()) {
            click(LOCKREPORT_CHECKBOX);
        }
    }

    /**
     * Method to check the show new records checkbox.
     */
    private void checkShowNewRecordsCheckBox() {
        if (!SHOW_NEWRECORDS_CHECKBOX.isSelected()) {
            click(SHOW_NEWRECORDS_CHECKBOX);
        }
    }

    /**
     * Method to check the show removed records checkbox.
     */
    private void checkShowRemovedRecordsCheckBox() {
        if (!SHOW_REMOVEDRECORDS_CHECKBOX.isSelected()) {
            click(SHOW_REMOVEDRECORDS_CHECKBOX);
        }
    }

    /**
     * Method to check the show modified reports checkbox.
     */
    private void checkShowModifiedRecordsCheckBox() {
        if (!SHOW_MODIFIEDERECORDS_CHECKBOX.isSelected()) {
            click(SHOW_MODIFIEDERECORDS_CHECKBOX);
        }
    }

    /**
     * Method to set allow changes options.
     */
    public void setAllowChangesReportOptions() {
        checkShowNewRecordsCheckBox();
        checkShowRemovedRecordsCheckBox();
        checkShowModifiedRecordsCheckBox();
    }

    /**
     * Method to select show change fields radio button.
     */
    private void selectShowChangeFieldsRadioButton() {
        //  if(!webDriver.element().isSelected(SHOWCHANGEDFIELDS_WITHINROW_RADIOBUTTON)){
        click(SHOWCHANGEDFIELDS_WITHINROW_RADIOBUTTON);

    }

    /**
     * Method to check the color checkbox.
     */
    private void checkColorCheckBox() {
        if (!COLOR_CHECKBOX.isSelected()) {
            click(COLOR_CHECKBOX);
        }
    }

    /**
     * Method to check the bold checkbox.
     */
    private void checkBoldCheckBox() {
        if (!BOLD_CHECKBOX.isSelected()) {
            click(BOLD_CHECKBOX);
        }
    }

    /**
     * Method to check the brackets checkbox.
     */
    private void checkBracketsCheckBox() {
        if (!BRACKETS_CHECKBOX.isSelected()) {
            click(BRACKETS_CHECKBOX);
        }
    }

    /**
     * Method to check the underline checkbox.
     */
    private void checkUnderlineCheckBox() {
        if (!UNDERLINE_CHECKBOX.isSelected()) {
            click(UNDERLINE_CHECKBOX);
        }
    }

    /**
     * Method to check the show changes checkbox.
     */
    private void checkShowChangesCheckBox() {
        if (!SHOWCHANGES_UNDERLABEL_CHECKBOX.isSelected()) {
            click(SHOWCHANGES_UNDERLABEL_CHECKBOX);
        }
    }

    /**
     * Method to set changes in report checkbox.
     */
    public void setChangesInReport() {
        selectShowChangeFieldsRadioButton();
        checkBoldCheckBox();
        checkBracketsCheckBox();
        checkUnderlineCheckBox();
        checkColorCheckBox();
        checkShowChangesCheckBox();
    }


    /**
     * Method to click on report sub tab.
     *
     * @return : ReportHomePage
     */
    public ReportHomePage clickReportSubTab() throws Exception {
        click(REPORT_SUBTAB);
        VerifyPageReady(20);
        return new ReportHomePage(browser);
    }

    /**
     * Method to get report type
     *
     * @return : report tytle
     */
    public String getReportType() {
        logReport(REPORT_TYPE_VALUE.getText().trim());
        return REPORT_TYPE_VALUE.getText().trim();
    }

    /**
     * Method to select the report type.
     *
     * @param addReportData : Page  object of AddReportData.
     */
    public void setReportType(AddReportData addReportData) {
        if (addReportData.getReport().equalsIgnoreCase(SUB_REPORT_VALUE19)) {
            setRegistrationReports(addReportData.getSubReport());
        } else if (addReportData.getReport().equalsIgnoreCase(SUB_REPORT_VALUE20)) {
            setFinancialReports(addReportData.getSubReport());
        } else if (addReportData.getReport().equalsIgnoreCase(SUB_REPORT_VALUE21)) {
            setAccommodationReports(addReportData.getSubReport());
        } else if (addReportData.getReport().equalsIgnoreCase(SUB_REPORT_VALUE22)) {
            setAgendaDataReports(addReportData.getSubReport());
        } else if (addReportData.getReport().equalsIgnoreCase(SUB_REPORT_VALUE23)) {
            setPackageReport();
        } else if (addReportData.getReport().equalsIgnoreCase(SUB_REPORT_VALUE24)) {
            setPlanning();
        } else if (addReportData.getReport().equalsIgnoreCase(SUB_REPORT_VALUE26)) {
            setTravelReport(addReportData.getSubReport());
        } else if (addReportData.getReport().equalsIgnoreCase(SUB_REPORT_VALUE31)) {
            setGroupReport(addReportData.getSubReport());
        }
    }


    public void clickDeleteButton() throws Exception {
        Wait(DELETE_BUTTON, 20);
        click(DELETE_BUTTON);
        logReport("Clicked on Delete Report Button");
    }

    public void clickOKInPopup() throws Exception {
        Alert alert = browser.switchTo().alert();
        alert.accept();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        VerifyPageReady(20);
    }

    public void clickRestoreButton() throws Exception {
        Wait(RESTORE_BUTTON, 20);
        click(RESTORE_BUTTON);
        logReport("Clicked on Restore Report Button");
    }

    public void checkLockReportCheckBox() {
        click(LOCK_REPORT_CHECKBOX);
        logReport("Lock Report Checkbox clicked");
    }

    public String getNewRecordUnderLabelName() {
        return NEW_RECORDS_LABEL_NAME_TEXTBOX.getAttribute("value").trim();
    }

    public String getRemovedRecordUnderLabelName() {
        return REMOVED_RECORDS_LABEL_NAME_TEXTBOX.getAttribute("value").trim();
    }

    public String getModifiedRecordUnderLabelName() {
        return MODIFIED_RECORDS_LABEL_NAME_TEXTBOX.getAttribute("value").trim();
    }

    public String getSeparateColumnName() {
        return SEPARATE_COLUMN_NAME_TEXTBOX.getAttribute("value").trim();
    }

    public boolean isChangesReportOptionsSectionPresent() {
        return verifyElementDisplayed(CHANGES_REPORT_OPTIONS_SECTION, 2);
    }

    public boolean isRoleBasedAccessSectionPresent() {
        return verifyElementDisplayed(ROLE_BASED_ACCESS_SECTION, 2);
    }

    public void fillProfileAnonymizeReport(AddReportData addReportData) {
        enterReportName(addReportData.getReportName());
        enterDescription(addReportData.getDescription());
        checkUncheckShowToSelectedUserCheckBox(true);
        checkUncheckAllowAccessCheckBox(true);
    }

    public boolean isAvailableDataFieldsPresent(String fieldName) throws Exception {
        Select selectList = new Select(AVAILABLE_DATA_FIELDS_DROPDOWN);
        List<WebElement> options = selectList.getOptions();
        for (WebElement element : options) {
            if (element.getAttribute("title").equalsIgnoreCase(fieldName)) {
                logReport("" + fieldName + " is present in the 'Available Data Fields list'.");
                return true;
            }
        }
        return false;

    }

    public void moveAvailableDataFieldsToRight(String fieldName) throws Exception {
        if (isAvailableDataFieldsPresent(fieldName)) {
            Wait(AVAILABLE_DATA_FIELDS_DROPDOWN, 10);
            select(AVAILABLE_DATA_FIELDS_DROPDOWN, fieldName);
            Wait(MOVE_SELECTED_ITEM_TO_RIGHT_BUTTON, 20);
            clickByJavaScript(MOVE_SELECTED_ITEM_TO_RIGHT_BUTTON);
            logReport("" + fieldName + " is moved into the right.");
        } else {
            logReport("" + fieldName + " is already moved into the right.");
        }

    }

    public void checkSpeakerReport() {
        clickByJavaScript(SPEAKERS_RADIOBUTTON);
        logReport("Speakers radiobutton clicked successfully");
    }

}
