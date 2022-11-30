package pageObjects.Events;

import excelFunctions.ExcelDataPool;
import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pageObjects.CopyExistingEvent;
import pageObjects.Forms.VerifyPage;

import java.util.List;

/**
 * Created by infoobjects on 8/3/2017.
 */
public class EventListPage extends CommonActionsPage {

    public static final By EVENT_LIST_TABLE_ROWS = By.xpath("//table[@class='tablesorter-bootstrap table table-striped table-hover tablesorter-default event-list']//tbody/tr");

    @FindBy(xpath = "//action-tab[@title='Add a New Event']")
    public WebElement addEventButton;

    @FindBy(xpath = "//a[text()='Copy Event']")
    public WebElement COPY_EVENT_BUTTON;

    @FindBy(xpath= "//a[@title='Plan your event.']")
    public WebElement PLAN_DROPDOWN;

    @FindBy(xpath= "//a[@title='Event Configuration']")
    public WebElement CONFIGURE_LINK_PLAN_DROPDOWN;

    @FindBy(xpath = "//button[text()='All Events']")
    public WebElement VIEWALL_EVENTS_BUTTON;

    @FindBy(xpath = "//div[@id='eventListView']//table//tr//td[5]")
    public WebElement SELECT_SEARCHED_EVENT;

    @FindBy(xpath = "//span[text()='Clear Filters']")
    public WebElement CLEAR_FILTER_BUTTON;
    @FindBy(xpath = "//div[@x-ng-if='!showCalendar']/button")
    public WebElement BUTTON_ALL_EVENTS;
    @FindBy(xpath = "//input[@x-ng-model='search.value']")
    public WebElement EVENT_SEARCH_TEXTBOX;

    @FindBy(xpath = "//button[@ng-click='searchEvents()']")
    public WebElement EVENT_SEARCH_ICON;

    @FindBy(xpath = "//button[@ng-click='openNewEvent()']")
    public WebElement DontUseTemplateButton;

    public EventListPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public EventDetailsPage clickAddNewEvent() throws Exception{
        Wait(addEventButton,30);
        //VerifyAngularHasFinishedProcessing(30);
        VerifyAjaxRequestsFinished(30);
        addEventButton.click();
        VerifyAngularHasFinishedProcessing(5);
        DontUseTemplateButton.click();
        VerifyAjaxRequestsFinished(30);
        return new EventDetailsPage(browser);
    }

    public void searchEvent(String eventCode) throws Exception {
        if (searchEventWithAddEvent(eventCode)) {
            selectEventInList(eventCode);
        }

    }
    public boolean searchEventWithAddEvent(String eventCode) throws Exception {
        boolean found = false;
        clickByJavaScript(CLEAR_FILTER_BUTTON);
        VerifyAngularHasFinishedProcessing(5);
        type(EVENT_SEARCH_TEXTBOX, eventCode, true);
        logReport("Entered Event Code " + eventCode + " in the search box");
        Thread.sleep(2000);
        selectAllEvents();
        Thread.sleep(2000);
        EVENT_SEARCH_ICON.click();
        VerifyAjaxRequestsFinished(10);
        VerifyAngularHasFinishedProcessing(10);
        String xpath = "//div[text()='We didn’t find any Events that match these Filters.']";
        if (verifyElementDisplayed(By.xpath(xpath), 2)) {
            logReport("Entered Event Code " + eventCode + " is not found in event list");
            found = true;
        }

        return found;
    }

    public CopyExistingEvent clickCopyEventIcon(String eventCode) throws Exception {
        String xpath = "//div[@id='eventListView']//table//tr//td[5][contains(.,'" + eventCode + "')]//following-sibling::td/a[@aria-label='Copy Event']";
        WebElement element = browser.findElement(By.xpath(xpath));
        click(element);
        VerifyAjaxRequestsFinished(30);
        VerifyPageReady(30);
        return new CopyExistingEvent(browser);
    }

    public void selectAllEvents() {
        BUTTON_ALL_EVENTS.click();
        String xpath = "//div[@ng-repeat='dateFilter in dateFilters']//label[text()='All Events']/preceding-sibling::input";
        WebElement element = browser.findElement(By.xpath(xpath));
        checkByJavascript(element);
        logReport("All Events dropdown value clicked successfully");
        BUTTON_ALL_EVENTS.click();
    }

    public void selectEventInList(String eventCode) throws Exception {
        click(SELECT_SEARCHED_EVENT);
        VerifyPageReady(30);

    }


    /**
     * Method for select searched event
     *
     * @return DashboardPage
     */
    public EventDashboardPage selectSearchedEvent() throws Exception {
        Thread.sleep(2000);
        clickByJavaScript(SELECT_SEARCHED_EVENT);
        VerifyPageReady(30);
        return new EventDashboardPage(browser);
    }
}
