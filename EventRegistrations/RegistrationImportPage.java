package pageObjects.EventRegistrations;


import globals.WebGlobals;
import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CommonActionsPage;
import pageObjects.Events.EventDashboardPage;

import java.io.File;
import java.util.List;

public class RegistrationImportPage extends CommonActionsPage {

    public static final String FILE_COLUMNS[] = {"FirstName", "LastName", "Email"};
    @FindBy(xpath = "//input[@id='wzdNextBtn']")
    public WebElement NEXT_BUTTON;
    @FindBy(xpath = "//input[@id='wzdFinishBtn']")
    public WebElement FINISH_BUTTON;

    public static final By FINISH1_BUTTON = By.xpath("//input[@id='wzdFinishBtn']");

    @FindBy(xpath = "//input[@value='Upload File']")
    public WebElement UPLOAD_FILE_BUTTON;
    @FindBy(xpath = "//select[@id='lstImport']")
    public WebElement REGISTRATION_IMPORT_DROPDOWN;
    @FindBy(xpath = "//iframe[@id='importRegistrationWizard']")
    public WebElement IMPORT_REGISTRATION_IFRAME;
    @FindBy(xpath = "//input[@name='fileToUpload']")
    public WebElement BROWSE_BUTTON;
    @FindBy(xpath = "//input[@value='Skip']")
    public WebElement DONT_UPLOAD_RADIOBUTTON;
    @FindBy(xpath = "//input[@value='Overwrite']")
    public WebElement OVERWRITE_RADIOBUTTON;
    @FindBy(xpath = "//input[@value='MakeUnique']")
    public WebElement UPLOAD_RADIOBUTTON;
    @FindBy(xpath = "//select[@id='importFile']")
    public WebElement IMPORT_DATAFILE_DROPDOWN;
    @FindBy(xpath = "//input[@name='preview']")
    public WebElement PREVIEW_FIRST_ROW_BTN;
    @FindBy(xpath = "//select[@id='regCatFee']")
    public WebElement ATTENDEE_TYPE_DROPDOWN;
    @FindBy(xpath = "//select[@id='firstRowData']//option")
    public List<WebElement> FIRST_ROW_DATA;
    @FindBy(xpath = "//input[@name='maxRows']")
    public WebElement MAX_NO_ROWS_TEXTBOX;

    public RegistrationImportPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void selectRegistrationImportValue(String value) throws Exception {
        select(REGISTRATION_IMPORT_DROPDOWN, value);
        logReport("Import/update Registration select successfully");
        VerifyAjaxRequestsFinished(30);
        VerifyPageReady(30);
    }

    /**
     * Method to switch to Import Registration iframe.
     */
    public void switchToImportRegistrationIframe() throws Exception {
        Wait(IMPORT_REGISTRATION_IFRAME, 30);
        browser.switchTo().frame(IMPORT_REGISTRATION_IFRAME);
        logReport("Switched into Iframe ");
    }

    public void clickNextButton() {
        //switchToImportRegistrationIframe();
        logReport("Clicking on Next Button");
        clickByJavaScript(NEXT_BUTTON);
    }

    public void clickNextButtonWithoutFrameSwitch() throws Exception {
        //  webDriver.switchTo().defaultContent();
        clickByJavaScript(NEXT_BUTTON);
        VerifyPageReady(30);
        Thread.sleep(4000);
    }

    public boolean isAlertPresent() {
        try {
            Alert alert = browser.switchTo().alert();
            return true;
        }   // try
        catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    /**
     * Method to click on finish button.
     */
    public void clickFinishButton() throws Exception {
        logReport("Clicking on Finish Button");
        Thread.sleep(3000);
        browser.findElement(FINISH1_BUTTON).click();
        //click(FINISH_BUTTON);
        logReport("Check for Alert is present");
        if(isAlertPresent()){
            Alert alert = browser.switchTo().alert();
            logReport("alert text found " + alert.getText());
            alert.accept();
        }
    }


    /**
     * Method to select image type radio button.
     *
     * @param : Page object of ImportRegistrationData
     */
    public void selectImageTypeRadioButton(String actionType) {
        if (actionType.equalsIgnoreCase("Don't Upload"))
            DONT_UPLOAD_RADIOBUTTON.click();

        else if (actionType.equalsIgnoreCase("Overwrite Existing"))
            click(OVERWRITE_RADIOBUTTON);

        else
            click(UPLOAD_RADIOBUTTON);

    }

    /**
     * Method to select the image
     *
     * @param : Page object of ImportRegistrationData.
     */
    public void selectImage(String fileName) throws Exception {
        Wait(BROWSE_BUTTON, 30);
        VerifyPageReady(30);

        // switchToImportRegistrationIframe();

        //File file = new File("src/test/resources/files/" + importRegistrationData.getFileName());

        File file = new File("target/test-classes/files/" + fileName);
        String absolutePath = file.getAbsolutePath();

        BROWSE_BUTTON.sendKeys(absolutePath);
        logReport("Absolute Path = " + absolutePath);


    }

    /**
     * Method to click on upload file button.
     */
    public void clickUploadFileButton() throws Exception {
        clickByJavaScript(UPLOAD_FILE_BUTTON);
        VerifyPageReady(30);
        Thread.sleep(3000);
    }

    public void selectFileFromDataDropdown(String fileName, String actionFile) throws Exception {

        Thread.sleep(5000);
        Wait(PREVIEW_FIRST_ROW_BTN, 30);

        // switchToImportRegistrationIframe();

        //closeSuccessMessage();
        select(IMPORT_DATAFILE_DROPDOWN, fileName);
        scrollTop();

        String jsCmd = "document.getElementsByName('importFile')[0].value='" + fileName + "'";
        executeJavascript(jsCmd);
        try {
            reporter.info("Try sendKeys");
            IMPORT_DATAFILE_DROPDOWN.sendKeys(actionFile);
            reporter.info("SendKeys Worked");
            reporter.info("Value in drop down is : " + getSelectedOption(IMPORT_DATAFILE_DROPDOWN));
        } catch (Exception e) {
            reporter.info("Send keys did not worked for file : " + e.getMessage());
        }

        Thread.sleep(2000);
        reporter.info("file " + fileName + " is selected in the dropdown.");
        scrollTop();
    }

    /**
     * Method to click Preview first row button
     */
    public void clickPreviewFirstRowButton() throws Exception {
        click(PREVIEW_FIRST_ROW_BTN);
        VerifyPageReady(30);
    }

    public void showAttendeeTypeValue() {
        select(ATTENDEE_TYPE_DROPDOWN, "Attendee");
        logReport("selected value found successfully");
    }

    public void enterNoOfRows(String rows) {
        type(MAX_NO_ROWS_TEXTBOX, rows, true);
        logReport("Max no of rows textbox value " + rows);
    }

    /**
     * Method to show status value.
     */

    public EventDashboardPage clickFinalFinishButton() throws Exception {
        click(FINISH_BUTTON);
        logReport("Final finish button");
        if(isAlertPresent()){
            Alert alert = browser.switchTo().alert();
            logReport("alert text found " + alert.getText());
            alert.accept();
        }
        // browser.switchTo().defaultContent();
        VerifyPageReady(30);
        return new EventDashboardPage(browser);
    }

    public boolean verifyColumnsInDataFile() {

        boolean isColumnsPresent = false;

        //  switchToImportRegistrationIframe();

        List<WebElement> columnNames = FIRST_ROW_DATA;

        for (int i = 0; i < FILE_COLUMNS.length; i++) {
            if (FILE_COLUMNS[i].equalsIgnoreCase(columnNames.get(i).getAttribute("title")))
                isColumnsPresent = true;
            else {
                isColumnsPresent = false;
                break;
            }
        }

        return isColumnsPresent;
    }
}

