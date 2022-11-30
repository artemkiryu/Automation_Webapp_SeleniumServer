package pageObjects.Events;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Agenda.AgendaPage;
import pageObjects.CommonActionsPage;
import pageObjects.EventSetup.EventContactPage;
import pageObjects.Registration.CustomProfileDataPage;

/**
 * Created by infoobjects on 16-08-2017.
 */
public class EventSetupPage extends CommonActionsPage {
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Scheduled items, fees, merchandise and others.']")
    public static WebElement AGENDA_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[contains(.,'Contact')]")
    public WebElement CONTACT_SIDE_MENU_ITEM;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Custom questions for registrations.']")
    public static WebElement QUESTIONS_TAB;

    public EventSetupPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public AgendaPage clickOnAgendaTab() throws Exception {
        VerifyPageReady(30);
        Wait(AGENDA_TAB, 30);
        click(AGENDA_TAB);
        logReport("Successfully clicked on agenda tab.");
        VerifyAngularHasFinishedProcessing(2);
        VerifyPageReady(3);
        return new AgendaPage(browser);
    }

    public EventContactPage clickOnContactsTab()throws Exception {
        VerifyPageReady(30);
        Wait(CONTACT_SIDE_MENU_ITEM, 30);
        click(CONTACT_SIDE_MENU_ITEM);
        logReport("Clicked on 'Contact' menu item.");
        return new EventContactPage(browser);
    }

    public CustomProfileDataPage clickOnEventSetUpQuestionsTab() throws Exception {
        Wait(QUESTIONS_TAB, 30);
        click(QUESTIONS_TAB);
        logReport("Clicked on 'Questions' menu item.");
        return new CustomProfileDataPage(browser);
    }
}
