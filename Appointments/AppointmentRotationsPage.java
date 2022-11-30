package pageObjects.Appointments;


import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AppointmentRotationsData;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by infoobjects on 11/3/2015.
 */
public class AppointmentRotationsPage extends CommonActionsPage {
    @FindBy(xpath = "//input[@id='add-rotation']")
    public WebElement ADD_NEW_BUTTON;
    @FindBy(xpath = "//td[text()='Rotation Name']/..//input[@id='name']")
    public WebElement ROTATION_NAME_TEXTBOX;
    @FindBy(xpath = "//td[text()='Rotation Description']/..//input[@id='description']")
    public WebElement ROTATION_DESCRIPTION_TEXTBOX;
    @FindBy(xpath = "//td[text()='Start Date']/..//input[@id='startDate']")
    public WebElement START_DATE_TEXTBOX;
    @FindBy(xpath = "//td[text()='Start Date']/..//input[@id='startTime']")
    public WebElement START_TIME_TEXTBOX;
    @FindBy(xpath = "//td[text()='End Date']/..//input[@id='endDate']")
    public WebElement END_DATE_TEXTBOX;
    @FindBy(xpath = "//td[text()='End Date']/..//input[@id='endTime']")
    public WebElement END_TIME_TEXTBOX;
    @FindBy(xpath = "//td[text()='Notes']/..//textarea[@id='notes']")
    public WebElement TEXT_AREA_NOTES;
    @FindBy(xpath = "//td[text()='Appointment Template']/..//select[@id='apptTemplateId']")
    public WebElement APPOINTMENT_TEMPLATE_DROPDOWN;
    @FindBy(xpath = "//td[text()='Agenda Items']/..//ul[@id='agenda_selection']//li")
    public List<WebElement> AGENDA_ITEM_LISTBOX;
    @FindBy(xpath = "//input[@value='Save']")
    public WebElement SAVE_BUTTON;
    @FindBy(xpath = "//td[text()='Start Date']/..//img[@class='ui-datepicker-trigger']")
    public WebElement START_DATE_CALENDAR_ICON;
    @FindBy(xpath = "//td[text()='End Date']/..//img[@class='ui-datepicker-trigger']")
    public WebElement END_DATE_CALENDAR_ICON;
    @FindBy(xpath = "//input[@value='Cancel']")
    public WebElement CANCEL_BUTTON;
    @FindBy(xpath = "//div[@id='form-success'][@class='alert alert-success']")
    public WebElement SUCCESS_MESSAGE;
    @FindBy(xpath = "//div[@id='form-error']//button")
    public WebElement MESSAGE_CLOSE_BUTTON;

    public AppointmentRotationsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for clicking add new button
     */
    public void clickOnAddNewButton() throws Exception {
        Wait(ADD_NEW_BUTTON, 10);
        click(ADD_NEW_BUTTON);
        logReport("Successfully clicked on 'Add New' button.");
        VerifyAjaxRequestsFinished(20);
        VerifyPageReady(20);

    }

    /**
     * Method for entering rotation name
     *
     * @param rotationName rotation name
     */
    private void enterRotationName(String rotationName) throws Exception {
        Wait(ROTATION_NAME_TEXTBOX, 10);
        type(ROTATION_NAME_TEXTBOX, rotationName, true);
        logReport("Successfully entered value: " + rotationName + " in 'Rotation Name' textbox.");
    }

    /**
     * Method for entering rotation description
     *
     * @param rotationDescription description of rotation
     */
    private void enterRotationDescription(String rotationDescription) {
        type(ROTATION_DESCRIPTION_TEXTBOX, rotationDescription, true);
        logReport("Successfully entered value: " + rotationDescription + " in 'Rotation Description' textbox.");
    }

    /**
     * Method for entering rotation start date
     *
     * @param date start date of rotation
     */
    private void enterRotationStartDate(String date) {
        type(START_DATE_TEXTBOX, date, true);
        logReport("Successfully entered value: " + date + " in 'Start Date' textbox.");
    }

    /**
     * Method for entering rotation start time
     *
     * @param time value of time
     */
    private void enterRotationStartTime(String time) {
        type(START_TIME_TEXTBOX, time, true);
        logReport("Successfully entered value: " + time + " in 'Start Time' textbox.");
    }

    /**
     * Method for entering rotation end date
     *
     * @param date value of end date
     */
    private void enterRotationEndDate(String date) {
        type(END_DATE_TEXTBOX, date, true);
        logReport("Successfully entered value: " + date + " in 'End Date' textbox.");
    }

    /**
     * Method for entering rotation end time
     *
     * @param time value of end time
     */
    private void enterRotationEndTime(String time) {
        type(END_TIME_TEXTBOX, time, true);
        logReport("Successfully entered value: " + time + " in 'End Time' textbox.");
    }

    /**
     * Method for entering rotation notes
     *
     * @param notes value of notes
     */
    private void enterRotationNotes(String notes) {
        type(TEXT_AREA_NOTES, notes, true);
        logReport("Successfully entered value: " + notes + " in 'Notes' textarea.");
    }

    /**
     * Method for select appointment template
     *
     * @param template value of appointment template
     */
    public void selectAppointmentTemplate(String template) throws Exception {
        if (!template.equals(null)) {
            Wait(APPOINTMENT_TEMPLATE_DROPDOWN, 10);
            select(APPOINTMENT_TEMPLATE_DROPDOWN, template);
            logReport("Successfully select value: " + template + " from 'Appointment Template' dropdown.");
            VerifyPageReady(20);
        }
    }

    /**
     * Method for selecting agenda items
     *
     * @param agendaItems value of agenda items
     */
    private void selectAgendaItems(String agendaItems) throws Exception {
        if (!agendaItems.equals(null)) {
            String agenda[] = agendaItems.split(",");
            for (int i = 0; i < agenda.length; i++) {

                List<WebElement> elements = AGENDA_ITEM_LISTBOX;
                for (int j = 0; j < elements.size(); j++) {
                    if (elements.get(j).getText().trim().contains(agenda[i])) {
                        elements.get(j).findElement(By.xpath("./input")).click();
                        logReport("Agenda item checkbox checked" + agenda);

                    }
                }
            }
        }
    }

    /**
     * Method for clicking save button
     */
    public void clickSaveButton() throws Exception {
        Wait(SAVE_BUTTON, 10);
        click(SAVE_BUTTON);
        logReport("Successfully clicked on 'Save' button.");
        VerifyAjaxRequestsFinished(20);
        VerifyPageReady(20);
    }

    /**
     * Method for create appointment rotation
     *
     * @param appointmentRotationsData page object of appointmentRotationsData
     * @throws Exception
     */
    public void createAppointmentRotations(AppointmentRotationsData appointmentRotationsData) throws Exception {
        enterRotationName(appointmentRotationsData.getRotationName());
        enterRotationDescription(appointmentRotationsData.getRotationDescription());
        enterRotationStartDate(getCurrentDate());
        enterRotationStartTime(appointmentRotationsData.getStartTime());
        enterRotationEndDate(getDateByDays(1));
        enterRotationEndTime(appointmentRotationsData.getEndTime());
        enterRotationNotes(appointmentRotationsData.getRotationNotes());
    }

    /**
     * Method for fill appointment rotations with agenda and template
     *
     * @param appointmentRotationsData page object of appointmentRotationsData
     * @param template                 value of appointment template
     * @param agenda                   value of agenda
     * @throws Exception
     */
    public void fillAppointmentRotations(AppointmentRotationsData appointmentRotationsData, String template, String agenda) throws Exception {
        enterRotationName(appointmentRotationsData.getRotationName());
        enterRotationDescription(appointmentRotationsData.getRotationDescription());
        enterRotationStartDate(getCurrentDate());
        enterRotationStartTime(appointmentRotationsData.getStartTime());
        enterRotationEndDate(getDateByDays(3));
        enterRotationEndTime(appointmentRotationsData.getEndTime());
        enterRotationNotes(appointmentRotationsData.getRotationNotes());
        selectAppointmentTemplate(template);
        selectAgendaItems(agenda);
    }

    /**
     * Method for get rotation name attribute length
     *
     * @return int - length
     */
    public int getRotationNameLength() {
        logReport(ROTATION_NAME_TEXTBOX.getAttribute("maxlength"));
        return Integer.parseInt(ROTATION_NAME_TEXTBOX.getAttribute("maxlength"));
    }

    /**
     * Method for get rotation name text length
     *
     * @return int - length
     */
    public int getRotationNameTextLength() {

        return ROTATION_NAME_TEXTBOX.getAttribute("value").length();
    }

    /**
     * Method for get rotation description max length
     *
     * @return int - length
     */
    public int getRotationDescriptionLength() {
        return Integer.parseInt(ROTATION_DESCRIPTION_TEXTBOX.getAttribute("maxlength"));
    }

    /**
     * Method for get rotation description text length
     *
     * @return int - length
     */
    public int getRotationDescriptionTextLength() {
        return ROTATION_DESCRIPTION_TEXTBOX.getAttribute("value").length();

    }

    /**
     * Method for get rotation notes max length
     *
     * @return int - length
     */
    public int getNotesLength() {
        return Integer.parseInt(TEXT_AREA_NOTES.getAttribute("maxlength"));
    }

    /**
     * Method for get rotation notes text length
     *
     * @return int - length
     */
    public int getNotesTextLength() {
        return TEXT_AREA_NOTES.getAttribute("value").length();

    }

    /**
     * Method for edit rotation name
     *
     * @param rotationName value of rotation name
     */
    public void editRotationName(String rotationName) throws Exception {
        VerifyPageReady(20);
        String xpath = "//td//p[@title='" + rotationName + "']/../..//td//img[@title='Edit']";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 10);
        element.click();
        logReport("Rotation edited successfully by rotation name" + rotationName);
        VerifyAjaxRequestsFinished(20);
    }

    /**
     * Method for deleting rotation name
     *
     * @param rotationName name of rotation
     */
    public void deleteRotationName(String rotationName) throws Exception {
        VerifyPageReady(20);
        String xpath = "//td//p[@title='" + rotationName + "']/../..//td//img[@title='Delete this row']";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 10);
        element.click();
        logReport("Rotation deleted successfully by rotation name" + rotationName);

    }


    /**
     * Method for get header names of table
     *
     * @return List - list of header names
     */
    public List<String> getHeaderNames() {
        String xpath = "//table//thead//tr//th//div";
        List<WebElement> elements = browser.findElements(By.xpath(xpath));
        List<String> headerNamesList = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            headerNamesList.add(elements.get(i).getText());
        }
        return headerNamesList;
    }

    /**
     * Method for clicking cancel button
     */
    public void clickCancelButton() throws Exception {
        Wait(CANCEL_BUTTON, 10);
        click(CANCEL_BUTTON);
        logReport("Successfully clicked on 'Cancel' button.");
        VerifyAjaxRequestsFinished(20);
        VerifyPageReady(20);
    }

    /**
     * Method for check rotation name present
     *
     * @param rotationName name of rotation
     * @return boolean : true if rotation name found else false
     */
    public boolean isRotationNamePresent(String rotationName) throws Exception {
        VerifyPageReady(20);
        String xpath = "//table//td//p[text()='" + rotationName + "']";
        return isElementDisplayed(By.xpath(xpath), browser);
    }

    /**
     * Method for check error message text present
     *
     * @param errorText error message text
     * @return boolean : true if error message text present else false
     */
    public boolean isErrorMessageTextPresent(String errorText) {
        String xpath = "//div[@id='form-error']//p";
        List<WebElement> elements = browser.findElements(By.xpath(xpath));

        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().trim().contains(errorText)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method for get appointment template selected value
     *
     * @return String - return selected value of appointment template
     */
    public String getAppointmentTemplateText() {
        return getSelectedOption(APPOINTMENT_TEMPLATE_DROPDOWN);
    }

    /**
     * Method for get rotation name list
     *
     * @return List - list of rotation names
     */
    public List<String> getRotationNameList() {
        int nameIndex = getColumnIndex("Name");
        String xpath = "//table//tbody//tr//td[" + nameIndex + "]//p";
        List<WebElement> elements = browser.findElements(By.xpath(xpath));
        List<String> rotationsList = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            rotationsList.add(elements.get(i).getText().trim());
        }
        return rotationsList;
    }

    public List<String> getRotationDescriptionList() {
        int nameIndex = getColumnIndex("Description");
        String xpath = "//table//tbody//tr//td[" + nameIndex + "]//p";
        List<WebElement> elements = browser.findElements(By.xpath(xpath));
        List<String> rotationsList = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            rotationsList.add(elements.get(i).getText().trim());
        }
        return rotationsList;
    }

    public List<String> getRotationNotesList() {
        int nameIndex = getColumnIndex("Notes");
        String xpath = "//table//tbody//tr//td[" + nameIndex + "]";
        List<WebElement> elements = browser.findElements(By.xpath(xpath));
        List<String> rotationsList = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            rotationsList.add(elements.get(i).getText().trim());
        }
        return rotationsList;
    }

    /**
     * Method for click column headers
     *
     * @param columnName name of column
     */
    public void clickColumnName(String columnName) throws Exception {
        String xpath = "//table//thead//tr//th//div[text()='" + columnName + "']";
        WebElement element = browser.findElement(By.xpath(xpath));
        element.click();
        element.click();
        logReport("Column name clicked successfully");
        VerifyPageReady(20);
    }

    public void clickCloseMessageBox() throws Exception {
        if (verifyElementDisplayed(MESSAGE_CLOSE_BUTTON, 10)) {
            click(MESSAGE_CLOSE_BUTTON);
            VerifyPageReady(20);
            logReport("Message close button clicked successfully");
        }
    }

    /**
     * Method for get column index
     *
     * @param columnName name of column
     * @return int - column index
     */
    public int getColumnIndex(String columnName) {
        String headerPath = "//table//thead//tr//th//div";
        List<WebElement> columnHeader = browser.findElements(By.xpath(headerPath));
        for (int i = 0; i < columnHeader.size(); i++) {
            if (columnHeader.get(i).getText().trim().contains(columnName)) {
                return i + 1;

            }
        }
        return 0;
    }
}
