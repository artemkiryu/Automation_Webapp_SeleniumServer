package pageObjects.Sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;
import java.io.File;
import java.util.List;

public class SessionImportPage extends CommonActionsPage {

    @FindBy(xpath = "//button[@class='btn btn-primary cursor-pointer boldFont ng-binding'][text()='Next ']")

    public WebElement SESSION_NEXT_BUTTON;
    @FindBy(xpath = "//div[contains(@x-ng-click,'session_instances')]//div[@class='img-box']")

    public WebElement SESSION_INSTANCE_IMPORT;
    @FindBy(xpath = "//input[@type='file']")

    public WebElement SESSION_IMPORT_CHOOSE_FILE_BUTTON;
    @FindBy(xpath = "//span[text()='Close']")

    public WebElement CLOSE_SESSION_BUTTON;
    @FindBy(xpath = "//h4/span[text()='Session import']")

    public WebElement HEADER_SESSION;
    @FindBy(xpath = "//button[@ng-click='goToStep(step-1)']")

    public WebElement SESSION_BACK_BUTTON;
    @FindBy(xpath = "//div[contains(@x-ng-click,'conference_sessions')]")

    public WebElement CONFERENCE_SESSION_IMPORT;
    @FindBy(xpath = "//button[@ng-click='importFile()']")

    public WebElement COMPLETE_IMPORT_BUTTON;
    @FindBy(xpath = "//div[@x-ng-repeat='mapping in csvImportMapping.mappings']")
    public List<WebElement> LIST_IMPORT_FIELDS;
    @FindBy(xpath = "//span[text()='Excel Column']")

    public WebElement EXCEL_COLUMN_SECTION;
    @FindBy(xpath = "//span[contains(.,'Session Field')]")

    public WebElement SESSION_FIELD_SECTION;

    @FindBy(xpath = "//span[contains(.,'Instance Field')]")

    public WebElement INSTANCE_FIELD_SECTION;

    @FindBy(xpath = "//div[contains(@x-ng-click,'conference_sessions')]//a[text()='Download a sample template for your reference.']")

    public WebElement SAMPLE_TEMPLATE_LINK;

    @FindBy(xpath = "//div[contains(@x-ng-click,'session_instances')]//a[text()='Download a sample template for your reference.']")

    public WebElement SAMPLE_TEMPLATE_LINK_INSTANCES;

    @FindBy(xpath = "//a[text()='Download a sample template for your reference.']")

    public WebElement STANDARD_SESSION_TEMPLATE_LINK;

    public SessionImportPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void clickBackButton() throws Exception {
        Wait(SESSION_BACK_BUTTON, 10);
        clickByJavaScript(SESSION_BACK_BUTTON);
        logReport("Session back button clicked successfully");
    }

    public void clickDownloadTemplateFileInSessionImport() throws Exception {
        Wait(SAMPLE_TEMPLATE_LINK, 30);
        click(SAMPLE_TEMPLATE_LINK);
        logReport("Sample template link clicked successfully");
    }

    public void clickDownloadTemplateFileInStandardSessionImport() throws Exception {
        Wait(STANDARD_SESSION_TEMPLATE_LINK, 30);
        click(STANDARD_SESSION_TEMPLATE_LINK);
        logReport("Standard Session Sample template link clicked successfully");
    }

    public void clickDownloadTemplateFileInSessionInstanceImport() throws Exception {
        Wait(SAMPLE_TEMPLATE_LINK_INSTANCES, 30);
        click(SAMPLE_TEMPLATE_LINK_INSTANCES);
        logReport("Sample template link clicked successfully");
    }

    public void selectSessionImportSection() throws Exception {
        Actions action = new Actions(browser);
        action.moveToElement(CONFERENCE_SESSION_IMPORT).build().perform();
        clickByJavaScript(CONFERENCE_SESSION_IMPORT);
        VerifyAngularHasFinishedProcessing(10);
        logReport("Conference session Import is selected SuccessFully");
    }

    public void clickNextButton() throws Exception {
        Wait(SESSION_NEXT_BUTTON, 20);
        click(SESSION_NEXT_BUTTON);
        logReport("Next Button is clicked SuccessFully");
    }

    public void selectSessionInstanceImportSection() throws Exception {
        Actions action = new Actions(browser);
        action.moveToElement(SESSION_INSTANCE_IMPORT).build().perform();
        clickByJavaScript(SESSION_INSTANCE_IMPORT);
        VerifyAngularHasFinishedProcessing(10);
        logReport("Session Instance Import is selected SuccessFully");

    }

    public void selectImportFile(String fileName) throws Exception {
        File file = new File("target/test-classes/files/" + fileName);
        String absolutePath = file.getAbsolutePath();
        reporter.info("file path " + absolutePath);
        if (SESSION_IMPORT_CHOOSE_FILE_BUTTON.getAttribute("class").contains("hidden")) {
            setElementAttribute(SESSION_IMPORT_CHOOSE_FILE_BUTTON, "btn btn-info fileChooser");
        }
        Thread.sleep(2000);
        SESSION_IMPORT_CHOOSE_FILE_BUTTON.sendKeys(absolutePath);
        VerifyAjaxRequestsFinished(20);
    }

    public void selectImportFile(String fileName, String filePath) throws Exception {
        File file = new File(filePath + fileName);
        String absolutePath = file.getAbsolutePath();
        reporter.info("file path " + absolutePath);
        if (SESSION_IMPORT_CHOOSE_FILE_BUTTON.getAttribute("class").contains("hidden")) {
            setElementAttribute(SESSION_IMPORT_CHOOSE_FILE_BUTTON, "btn btn-info fileChooser");
        }
        Thread.sleep(2000);
        SESSION_IMPORT_CHOOSE_FILE_BUTTON.sendKeys(absolutePath);
        VerifyAjaxRequestsFinished(20);
    }

    public void importSessionInstance(String fileName) throws Exception {
        selectSessionInstanceImportSection();
        selectImportFile(fileName);
        clickCompleteImportButton();
        Thread.sleep(10000);
    }

    public void importSession(String fileName) throws Exception {
        selectSessionImportSection();
        selectImportFile(fileName);
        clickCompleteImportButton();
        Thread.sleep(10000);
    }

    public void clickCompleteImportButton() throws Exception {
        Wait(COMPLETE_IMPORT_BUTTON, 10);
        clickByJavaScript(COMPLETE_IMPORT_BUTTON);
        logReport("Complete Session Import Button is clicked SuccessFully");
    }

    public void selectImportFieldsForStandardFields() {

        for (int i = 0; i < LIST_IMPORT_FIELDS.size(); i++) {
            String excelxpath = "//div[@x-ng-repeat='mapping in csvImportMapping.mappings'][" + (i + 1) + "]/input";
            String mappedxpath = "//div[@x-ng-repeat='mapping in csvImportMapping.mappings'][" + (i + 1) + "]//select//option[@selected='selected']";
            WebElement elementExcel = browser.findElement(By.xpath(excelxpath));
            WebElement elementmapped = browser.findElement(By.xpath(mappedxpath));
            String excelName = elementExcel.getAttribute("value").trim().split(" :")[0].trim();
            if (excelName.contains("Industries")) {
                excelName = "Industry";
            } else if (excelName.contains("Job Functions")) {
                excelName = "Job Function";
            } else if (excelName.contains("No of Instances")) {
                excelName = "No.of Instances";
            } else if (excelName.contains("Speakers")) {
                excelName = "Speaker";
            }
            String selectedValue = elementmapped.getAttribute("innerText");
            logReport("-------"+ selectedValue);
            try {

            } catch (Exception e) {
            }
            Select selectList = new Select(elementmapped);
            List<WebElement> options = selectList.getOptions();
            for (WebElement we : options) {
                if (we.getText().trim().contains(excelName)) {
                    we.click();
                    break;
                }
            }

        }
    }

    public void mappedOnlyMandatoryFields() {
        for (int i = 0; i < 3; i++) {
            String excelxpath = "//div[@x-ng-repeat='mapping in csvImportMapping.mappings'][" + (i + 1) + "]/input";
            String mappedxpath = "//div[@x-ng-repeat='mapping in csvImportMapping.mappings'][" + (i + 1) + "]//select";
            WebElement elementExcel = browser.findElement(By.xpath(excelxpath));
            WebElement elementmapped = browser.findElement(By.xpath(mappedxpath));
            String excelName = elementExcel.getAttribute("value").trim().split(" :")[0].trim();
            try {
                String selectedValue = getSelectedOption(elementmapped);
            } catch (Exception e) {
            }
            logReport("--------------Excel column name is " + excelName);
            //  logReport("Selected value is " + selectedValue);
            // if (selectedValue.isEmpty() || selectedValue == null) {
            Select selectList = new Select(elementmapped);
            List<WebElement> options = selectList.getOptions();
            logReport("element of options " + options);
            for (WebElement we : options) {
                logReport("---dropdown options " + we.getText().trim());
                if (we.getText().trim().contains(excelName)) {
                    logReport("Option value matched");
                    we.click();
                    break;
                }
                }
            //}
        }
    }

    public void clearDropdownValues(String label) throws Exception {
        String xpath = "//div[@x-ng-repeat='mapping in csvImportMapping.mappings']/input[contains(@value,'" + label + "')]/following-sibling::div//abbr";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 20);
        element.click();
        logReport("Dropdown value cleared by label " + label);
    }

    public void clearAllMappedValues() throws Exception {
        for (int i = 0; i < LIST_IMPORT_FIELDS.size(); i++) {
            String xpath = "//div[@x-ng-repeat='mapping in csvImportMapping.mappings'][" + (i + 1) + "]/input/following-sibling::div//a/abbr";
            WebElement element = browser.findElement(By.xpath(xpath));
            clickByJavaScript(element);
            Thread.sleep(1000);
        }
    }

}
