package pageObjects.EventSetup;


import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddJobs;

public class ConnectorsPage extends CommonActionsPage {
    @FindBy(xpath = "//input[@value='Job History By Event']//following-sibling::input[@value='New Event Job']")
    public WebElement NEWEVENTJOB_BUTTON;

    @FindBy(xpath = "//select[@id='templates']")
    public WebElement APPLICATION_DROPDOWN;

    @FindBy(xpath = "//select[@id='jobs']")
    public WebElement JOBNAME_DROPDOWN;

    @FindBy(xpath = "//input[@id='jobTitle']")
    public WebElement JOBDESCRIPTION_TEXTBOX;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement EMAIL_TEXTBOX;

    @FindBy(xpath = "//input[@id='maxRecords']")
    public WebElement MAXRECORDS_TEXTBOX;

    @FindBy(xpath = "//iframe[@id='certainJobs']")
    public WebElement IFRAME_JOBS;

    @FindBy(xpath = "//input[@id='submitForm']")
    public WebElement SAVE_BUTTON;

    @FindBy(xpath = "//select[@id='attendeeTypeCodeSelectName']")
    public WebElement ATTENDEETYPECODE_DROPDOW;

    @FindBy(xpath = "//select[@id='registrationStatusLabelSelectName']")
    public WebElement REGSTATUS_DROPDOWN;

    @FindBy(xpath = "//input[@id='eloqua_search']")
    public WebElement ELOQUALISTNAME_TEXTBOX;

    @FindBy(xpath = "//input[@id='marketo_static_list']")
    public WebElement MARKETOLISTNAME_TEXTBOX;

    @FindBy(xpath = "//input[@id='eloqua_pagesize']")
    public WebElement PAGESIZE_TEXTBOX;

    @FindBy(xpath = "//input[@id='marketo_pagesize']")
    public WebElement MARKETOPAGESIZE_TEXTBOX;


    @FindBy(xpath = "//input[@id='eloqua_startpage']")
    public WebElement STARTPAGE_TEXTBOX;

    @FindBy(xpath = "//input[@id='eloqua_endpage']")
    public WebElement ENDPAGE_TEXTBOX;

    @FindBy(xpath = "//input[@title='Click to view the messages for Import Marketo Leads as Registrations']")
    public WebElement MARKETOMESSAGE;

    @FindBy(xpath = "//input[@title='Click to view the messages for Import Eloqua Contacts as Registrations']")
    public WebElement ELOQUAMESSAGE;


    public ConnectorsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void switchToCertainFrame() {
        browser.switchTo().frame(IFRAME_JOBS);
        logReport("switched to iframe successfully");
    }

    public void clickNewEventJob() throws Exception {
        Wait(NEWEVENTJOB_BUTTON, 20);
        clickByJavaScript(NEWEVENTJOB_BUTTON);
        logReport("New event job clicked");
        // VerifyAngularHasFinishedProcessing(30);
        VerifyPageReady(30);
    }

    public void selectRegStatuses(AddJobs addJobs) {
        String xpath = "//label[contains(.,'" + addJobs.getRegStatus() + "')]//input[@id='Registration']";
        WebElement element = browser.findElement(By.xpath(xpath));
        check(element);
        logReport("selected reg statuses " + addJobs.getRegStatus());

    }

    public void selectProfileEntryDuplication(AddJobs addJobs) {
        String xpath = "//td[contains(.,'" + addJobs.getProfileDeduplication() + "')][@class='ng-scope ng-binding']/input";
        click(browser.findElement(By.xpath(xpath)));
        logReport("Selected profile entry duplication value " + addJobs.getProfileDeduplication());
    }

    public void selectRegStatusOverwrite(AddJobs addJobs) {
        String xpath = "//td[contains(.,'" + addJobs.getRegStatusOverwrite() + "')][@class='ng-scope ng-binding']/input";
        click(browser.findElement(By.xpath(xpath)));
        logReport("Selected profile entry duplication value " + addJobs.getProfileDeduplication());
    }

    public void openMarketoMessages() throws Exception {
        Wait(MARKETOMESSAGE, 30);
        clickByJavaScript(MARKETOMESSAGE);
        logReport("Marketo msg opened");

    }

    public String getLogMessageText() {
        String xpath = "//pre";
        return browser.findElement(By.xpath(xpath)).getText().trim();
    }

    public void openEloquaMessages() throws Exception {
        scrollTop();
        Wait(ELOQUAMESSAGE, 30);
        clickByJavaScript(ELOQUAMESSAGE);
        logReport("Eloqua msg opened");
    }

    public void fillJobDetails(AddJobs addJobs) throws Exception {
        Wait(APPLICATION_DROPDOWN, 30);
        select(APPLICATION_DROPDOWN, addJobs.getApplication());
        select(JOBNAME_DROPDOWN, addJobs.getJobName());
        type(JOBDESCRIPTION_TEXTBOX, addJobs.getJobDescription(), true);
        if (addJobs.getJobName().equalsIgnoreCase("Create or Update Contacts in Eloqua")) {
            selectRegStatuses(addJobs);
        }
        if (addJobs.getJobName().equalsIgnoreCase("Import Eloqua Contacts as Registrations")) {
            selectProfileEntryDuplication(addJobs);
            select(ATTENDEETYPECODE_DROPDOW, addJobs.getAttendeeTypeCode());
            select(REGSTATUS_DROPDOWN, addJobs.getRegStatus());
            selectRegStatusOverwrite(addJobs);
            type(ELOQUALISTNAME_TEXTBOX, addJobs.getListName(), true);
            type(PAGESIZE_TEXTBOX, addJobs.getRetrievalPage(), true);
            type(STARTPAGE_TEXTBOX, addJobs.getStartingPage(), true);
            type(ENDPAGE_TEXTBOX, addJobs.getEndingPage(), true);
            type(EMAIL_TEXTBOX, addJobs.getEmail(), true);


        }
        if (addJobs.getJobName().equalsIgnoreCase("Import Marketo Leads as Registrations")) {
            selectProfileEntryDuplication(addJobs);
            type(MARKETOLISTNAME_TEXTBOX, addJobs.getListName());
            type(MARKETOPAGESIZE_TEXTBOX, addJobs.getRetrievalPage(), true);
            select(ATTENDEETYPECODE_DROPDOW, addJobs.getAttendeeTypeCode());
            select(REGSTATUS_DROPDOWN, addJobs.getRegStatus());
            selectRegStatusOverwrite(addJobs);
            type(MAXRECORDS_TEXTBOX, addJobs.getEndingPage(), true);
            type(EMAIL_TEXTBOX, addJobs.getEmail(), true);


        }

    }

    public void clickSaveButton() throws Exception {
        Wait(SAVE_BUTTON, 30);
        clickByJavaScript(SAVE_BUTTON);
        logReport("Save button clicked successfully");
        Thread.sleep(3000);
        //VerifyAngularHasFinishedProcessing(20);
        if (isAlertPresent()) {
            Alert alert = browser.switchTo().alert();
            logReport("Alert text found " + alert.getText());
            alert.accept();
        }
        // VerifyPageReady(30);

    }

}
