package pageObjects.Events;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pageObjects.EventRegistrations.CreateRegistrationPage;
import pageObjects.Reports.ReportResultsPage;

/**
 * Created by infoobjects on 8/3/2017.
 */
public class EventDashboardPage extends CommonActionsPage {

    @FindBy(xpath = "//div[@id='actions']//a[text()='Add Registration']")
    public WebElement ADD_REGISTRATION_BUTTON;

    @FindBy(xpath = "//table[@class='table table-striped table-hover tablesorter-default tablesorter tablesorter-bootstrap']//tr//td[1]//a[text()='Total']")
    public WebElement ROW_TOTAL;

    @FindBy(xpath = "//button[contains(.,'Event Details')]")
    public WebElement EVENT_DETAILS_BUTTON;

    public EventDashboardPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public CreateRegistrationPage clickOnAddRegistrationButton() throws Exception {
        VerifyPageReady(30);
        Wait(ADD_REGISTRATION_BUTTON, 20);
        click(ADD_REGISTRATION_BUTTON);
        logReport("Successfully clicked on 'Add Registration' button.");
        return new CreateRegistrationPage(browser);

    }

    @FindBy(xpath = "//span[text()='DASHBOARD']/../../..")
    public WebElement DASHBOARD_BUTTON;

    @FindBy(xpath = "//button[@id='table-view']")
    public WebElement TABULAR_VIEW_BTN;

    @FindBy(xpath = "//iframe[@id='iFrameEventDashboard']")
    public WebElement IFRAME_EVENT_DASHBOARD;

    private String columnNameComplete = "Complete";
    private String columnNameIncomplete = "Incomplete";
    private String columnNameTotal = "Total";


    public void clickDashboardButton() throws Exception {
        DASHBOARD_BUTTON.click();
        logReport("Dashboard button clicked successfiully");
        VerifyAjaxRequestsFinished(30);
        VerifyAngularHasFinishedProcessing(30);

    }

    public EventDetailsPage clickEventDetailsTab() throws Exception {
        Wait(EVENT_DETAILS_BUTTON, 30);
        click(EVENT_DETAILS_BUTTON);
        logReport("Event Details button clicked successfiully");
        VerifyAjaxRequestsFinished(10);
        VerifyAngularHasFinishedProcessing(10);
        return new EventDetailsPage(browser);

    }

    public void clickTabularButton() throws Exception {
        clickDashboardButton();
        browser.switchTo().frame(IFRAME_EVENT_DASHBOARD);
        Wait(TABULAR_VIEW_BTN, 10);
        click(TABULAR_VIEW_BTN);
        logReport("Tabular button clicked successfully");
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
        browser.switchTo().defaultContent();
    }

    public ReportResultsPage openAllRegisteredUsers() throws Exception {
        clickTabularButton();
        // webDriver.navigate().refresh();
        browser.switchTo().frame(IFRAME_EVENT_DASHBOARD);
        Wait(ROW_TOTAL, 20);
        clickByJavaScript(ROW_TOTAL);
        VerifyPageReady(20);
        browser.switchTo().defaultContent();
        return new ReportResultsPage(browser);
        //Thread.sleep(4000);
    }

    public int getRegistrationCountByStatus(String columnName, String statusType) {
        browser.switchTo().frame(IFRAME_EVENT_DASHBOARD);
        String xpath;
        int count = 0;
        if (columnName.equals(columnNameComplete)) {
            xpath = "//div[contains(.,'All Registrations By Status')]//..//table//td//label[contains(.,'" + statusType + "')]/../..//td[2]/a";
            WebElement element = browser.findElement(By.xpath(xpath));
            count = Integer.parseInt(element.getText().trim());
        } else if (columnName.equals(columnNameIncomplete)) {
            xpath = "//div[contains(.,'All Registrations By Status')]//..//table//td//label[contains(.,'" + statusType + "')]/../..//td[3]/a";
            WebElement element = browser.findElement(By.xpath(xpath));
            count = Integer.parseInt(element.getText().trim());
        } else if (columnName.equals(columnNameTotal)) {
            xpath = "//div[contains(.,'All Registrations By Status')]//..//table//td//label[contains(.,'" + statusType + "')]/../..//td[4]/a";
            WebElement element = browser.findElement(By.xpath(xpath));
            count = Integer.parseInt(element.getText().trim());
        } else
            logReport("Enter right values");
        logReport("registration count" + count);
        browser.switchTo().defaultContent();
        return count;
    }
}
