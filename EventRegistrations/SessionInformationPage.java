package pageObjects.EventRegistrations;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import java.util.List;


/**
 * Created by infoobjects on 8/10/2015.
 */
public class SessionInformationPage extends CommonActionsPage {

    @FindBy(xpath = "//button[text()='Assign Session(s)']")
    public WebElement ASSIGN_SESSION_BUTTON;
    @FindBy(xpath = "//button[text()='Assign Session(s)'][@class='btn btn-primary ng-binding']")
    public WebElement ASSIGN_SESSION_TAB;

    @FindBy(xpath = "//input[@ng-model='searchCriteria.isWaitListed']")
    public WebElement WAITLISTED_SESSION_CHK;

    @FindBy(xpath = "//div[@ng-show='isSessionInstanceListEmpty']")
    public WebElement SESSIONS_LIST_EMPTY;

    //div[@ng-show='isSessionInstanceListEmpty']

    public SessionInformationPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for assign session to registrant user
     *
     * @param sessionName name of session
     */
    public void assignSessionToRegistrant(String sessionName) throws Exception {
        // clickAssignSessionsTab();
        clickAssignSessionsButton();
        checkSessionCheckbox(sessionName);
        clickAssignSessionButtonUnderAssignSessionPage();
    }

    public void checkWaitListedSessionCheckbox() {
        check(WAITLISTED_SESSION_CHK);
        logReport("Waitlisted session checkbox checked successully");

    }
    public void clickAssignSessionsButton() throws Exception {
        Wait(ASSIGN_SESSION_BUTTON, 20);
        click(ASSIGN_SESSION_BUTTON);
        logReport("Assign session button clicked successfully");
        VerifyAngularHasFinishedProcessing(20);
        // switchToLatestTabOrWindow();
    }

    public void checkSessionCheckbox(String sessionName) {
        String xpath = "//h4[contains(.,'" + sessionName + "')]/../../preceding-sibling::div//input";
        WebElement element = browser.findElement(By.xpath(xpath));
        check(element);
        logReport("Session checkbox checked successfully " + sessionName);
    }

    public void clickAssignSessionButtonUnderAssignSessionPage() throws Exception {
        Wait(ASSIGN_SESSION_TAB, 30);
        click(ASSIGN_SESSION_TAB);
        logReport("Assign session button clicked successfully");
        VerifyAngularHasFinishedProcessing(20);

    }

    /**
     * This method can be used to verify the name of the Session
     *
     * @param sessionName - name of the Session to be verified
     * @return - True if Session name is found , false otherwise
     * Created by infoobjects on 8/10/2015.
     */
    public boolean isSessionNamePresent(String sessionName) throws Exception {
        clickAssignSessionsButton();
        String xpath = "//div//h4";
        List<WebElement> sessionList = browser.findElements(By.xpath(xpath));
        for (int i = 0; i < sessionList.size(); i++) {
            if (sessionList.get(i).getText().trim().contains(sessionName)) {
                return true;
            }
        }
        return false;
    }

    public void changeAssignedSessionStatus(String sessionName, String status) throws Exception {
        String xpath = "//h4[@title='" + sessionName + "']/../..//following-sibling::span//select";
        WebElement element = browser.findElement(By.xpath(xpath));
        select(element, status);
        wait(30);
        logReport("Assigned session status changed into " + status + " successfully");
    }

}
