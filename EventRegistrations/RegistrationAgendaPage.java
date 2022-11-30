package pageObjects.EventRegistrations;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pageObjects.CommonActionsPage;
import pojo.RegistrationAgendaData;

import java.util.List;

/**
 * Created by infoobjects on 8/29/2017.
 */
public class RegistrationAgendaPage extends CommonActionsPage {


    @FindBy(xpath = "//button[text()='Add New']")
    public WebElement ADD_AGENDA_BUTTON;

    @FindBy(xpath = "//select[@name='reg_to_aty_frn_aty_id']")
    public WebElement AGENDA_ITEM_DROPDOWN;

    @FindBy(xpath = "//input[@name='reg_to_aty_qty']")
    public WebElement QUANTITY_TEXTBOX;

    @FindBy(xpath = "//select[@name='reg_to_aty_frn_aty_sts_id']")
    public WebElement STATUS_DROPDOWN;

    @FindBy(xpath = "//input[@value='Save']")
    public WebElement SAVE_BUTTON;

    @FindBy(xpath = "//span[@id='balance_due']")
    public WebElement BALANCE_DUE;

    @FindBy(xpath = "//a[@title='Attendee profile and registration information.']")
    public WebElement ATTENDEE_PROFILE_TAB;


    public RegistrationAgendaPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    private void clickOnAddNewAgendaButton()throws Exception{
        VerifyPageReady(30);
        Wait(ADD_AGENDA_BUTTON,20);
        click(ADD_AGENDA_BUTTON);
        logReport("Successfully clicked on Add Agenda button.");
    }

    private void selectAgendaItem(String agendaItem)throws Exception{
        VerifyPageReady(30);
        Wait(AGENDA_ITEM_DROPDOWN,20);
        select(AGENDA_ITEM_DROPDOWN, agendaItem);
        logReport("Successfully selected item : "+agendaItem+" in 'Agenda Item' dropdown.");
    }

    public void selectAgendaItemValue(String agendaItem) throws Exception {
        Select select = new Select(AGENDA_ITEM_DROPDOWN);
        List<WebElement> allOptions = select.getOptions();
        for (WebElement e : allOptions) {
            if (e.getText().trim().contains(agendaItem)) {
                select(AGENDA_ITEM_DROPDOWN, e.getText());
                return;
            }
        }
    }

    public void enterQuantity(String quantity) throws Exception {
        VerifyPageReady(30);
        Wait(QUANTITY_TEXTBOX,20);
        type(QUANTITY_TEXTBOX, quantity, true);
        logReport("Successfully entered value: "+quantity+" in 'Quantity' textbox.");
    }

    public void selectStatus(String status) throws Exception {
        VerifyPageReady(30);
        Wait(STATUS_DROPDOWN, 20);
        select(STATUS_DROPDOWN, status);
        logReport("Successfully selected item : "+status+" in 'Status' dropdown.");
    }

    public void clickOnSaveButton() throws Exception {
        VerifyPageReady(30);
        Wait(SAVE_BUTTON,20);
        click(SAVE_BUTTON);
        logReport("Successfully clicked on 'Save' button.");
    }
    public void addRegistrationAgenda(RegistrationAgendaData registrationAgendaData) throws Exception{
        clickOnAddNewAgendaButton();
        selectAgendaItem(registrationAgendaData.getAgendaItem());
        enterQuantity(registrationAgendaData.getQuantity());
        selectStatus(registrationAgendaData.getStatus());
        clickOnSaveButton();
    }

    public void addRegistrationAgenda(String agendaItem, String quantity, String status) throws Exception {
        clickOnAddNewAgendaButton();
        selectAgendaItemValue(agendaItem);
        enterQuantity(quantity);
        selectStatus(status);
        clickOnSaveButton();
    }

    public void editAgenda(String agendaCode) {
        String xpath = "//td[contains(text(),'" + agendaCode + "')]";
        click(browser.findElement(By.xpath(xpath)));
        logReport("Edit agenda successfully by code " + agendaCode);

    }

    public void editAgendaAndFillDetails(String agendaCode, String status) throws Exception {
        editAgenda(agendaCode);
        selectStatus(status);
        clickOnSaveButton();
    }

    public float getBalanceDue() {
        float f = Float.parseFloat(BALANCE_DUE.getText().trim().replace(",", ""));
        return f;
    }

    public AttendeeProfilePage clickAttendeeProfileTab() throws Exception {
        Wait(ATTENDEE_PROFILE_TAB, 30);
        click(ATTENDEE_PROFILE_TAB);
        logReport("Attendee profile tab clicked ");
        VerifyPageReady(30);
        return new AttendeeProfilePage(browser);
    }
}
