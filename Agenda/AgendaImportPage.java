package pageObjects.Agenda;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import java.io.File;
import java.util.List;

/**
 * Created by infoobjects on 18-08-2017.
 */
public class AgendaImportPage extends CommonActionsPage {
    @FindBy(xpath = "//button[contains(text(),'Next')]")
    public WebElement NEXT_BUTTON;
    @FindBy(xpath = "//button[contains(text(),'Back')]")
    public WebElement BACK_BUTTON;
    @FindBy(xpath = "//input[@type='file']")
    public WebElement FILE_CHOOSER_BUTTON;
    @FindBy(xpath = "//button[contains(text(),'Complete Import')]")
    public WebElement COMPLETE_IMPORT_BUTTON;
    @FindBy(xpath = "//button[text()='Close'][@class='btn btn-primary cursor-pointer boldFont ng-binding']")
    public WebElement CLOSE_BUTTON;
    @FindBy(xpath = "//span[@class='form-control importDefaultHeader ng-binding']")
    public List<WebElement> LIST_IMPORT_ITEMS;

    public AgendaImportPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void selectFile(String fileName) throws Exception {
        File file = new File("target/test-classes/files/" + fileName);
        String absolutePath = file.getAbsolutePath();
        reporter.info("file path " + absolutePath);
        //webDriver.type(FILE_CHOOSER_BUTTON,absolutePath);
        if (FILE_CHOOSER_BUTTON.getAttribute("class").contains("hidden")) {
            setElementAttribute(FILE_CHOOSER_BUTTON, "btn btn-info fileChooser");
        }
        Thread.sleep(2000);
        FILE_CHOOSER_BUTTON.sendKeys(absolutePath);
        VerifyAjaxRequestsFinished(10);
        VerifyAngularHasFinishedProcessing(20);

    }


    public void clickNextButton() throws Exception {
        Wait(NEXT_BUTTON, 10);
        click(NEXT_BUTTON);
        VerifyAjaxRequestsFinished(10);
        logReport("Next Button clicked successfully");
    }

    public void clickBackButton() throws Exception {
        Wait(BACK_BUTTON, 10);
        click(BACK_BUTTON);
        logReport("Back Button clicked successfully");
    }

    /* public void selectFile(String fileName) throws Exception {
         File file = new File("target/test-classes/files/" + fileName);
         String absolutePath = file.getAbsolutePath();
         logReport("file path " + absolutePath);
         FILE_CHOOSER_BUTTON.sendKeys(absolutePath);
         VerifyAjaxRequestsFinished(20);

     }
 */
    public void selectAgendaType(String agendaType) {
        String xpath = "//label[contains(.,'" + agendaType + "')]/input[@ng-model='importCategory.value']";
        WebElement element = browser.findElement(By.xpath(xpath));
        element.click();
        logReport("Selected Agenda Type " + agendaType);

    }

    public void clickCloseButton() throws Exception {
        Wait(CLOSE_BUTTON, 10);
        click(CLOSE_BUTTON);
        VerifyAjaxRequestsFinished(10);
        logReport("Close Button clicked successfully");
    }

    public void clickCompleteImportButton() throws Exception {
        Wait(COMPLETE_IMPORT_BUTTON, 10);
        click(COMPLETE_IMPORT_BUTTON);
        VerifyAjaxRequestsFinished(10);
        logReport("Complete import Button clicked successfully");
    }

    public void selectImportFields() {
        for (int i = 0; i < LIST_IMPORT_ITEMS.size() - 1; i++) {
            String text = LIST_IMPORT_ITEMS.get(i).getText();
            String buttonXpath = "//div[@ng-repeat='header in headers track by $index'][" + (i + 1) + "]//button";
            String dropdownVal = "//div[@ng-repeat='header in headers track by $index'][" + (i + 1) + "]//button/following-sibling::ul/div/div";
            WebElement button = browser.findElement(By.xpath(buttonXpath));
            if (!button.getText().trim().contains(text)) {
                click(button);
                logReport("Button clicked successfully");
                List<WebElement> dropdown = browser.findElements(By.xpath(dropdownVal));
                for (WebElement e : dropdown) {
                    logReport("Expected Value " + text);
                    //logReport("Actual value " + e.getText().trim());
                    String actualText = e.getText().trim();
                    if (actualText.contains(text)) {
                        e.click();
                        break;
                    }
                }
            }
        }
    }

    public void importFile(String fileName, String agendaType) throws Exception {
        clickNextButton();
        Thread.sleep(5000);
        selectFile(fileName);
        selectAgendaType(agendaType);
        clickNextButton();
        selectImportFields();
        clickCompleteImportButton();
        clickCloseButton();
        waitForWindowToDispose();
    }
}
