package pageObjects.Agenda;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.ExportAgenda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by infoobjects on 16-08-2017.
 */
public class AgendaPage extends CommonActionsPage {
    //public static final String FILE_COLUMNS[] = {"FirstName", "LastName", "Email"};
    public static final List<String> headersAgenda = new ArrayList<>(Arrays.asList("Name", "Type", "Unique Code", "Sort Order", "CEU", "Points", "Inventory/Capacity", "Maximum Order", "Start Date & Time", "End Date & Time", "Location", "Track", "Group", "Registration Form Label", "Description", "Description Show", "Planner Notes", "Active", "Category"));
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[contains(.,'Scheduled')]")
    public WebElement SCHEDULED_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[contains(.,'Merchandise')]")
    public WebElement MERCHANDISE_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[contains(.,'Other')]")
    public WebElement OTHER_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[contains(.,'Fees & Discounts')]")
    public WebElement FEES_DISCOUNTS_TAB;
    @FindBy(xpath = "//a[@ng-click='openImportWizard()']")
    public WebElement IMPORT_TAB;
    @FindBy(xpath = "//a[contains(text(),'Export')]")
    public WebElement EXPORT_TAB;
    @FindBy(xpath = "//a[text()='Download']")
    public WebElement DOWNLOAD_BUTTON;
    @FindBy(xpath = "//span[text()='Scheduled']/..//following-sibling::div//span[contains(@class,'boldFont ng-binding')]")
    public WebElement SCHEDULED_AGENDA_ITEMS;
    @FindBy(xpath = "//span[text()='Fees & Discounts']/..//following-sibling::div//span[contains(@class,'boldFont ng-binding')]")
    public WebElement FEESDISCOUNTS_AGENDA_ITEMS;
    @FindBy(xpath = "//span[text()='Merchandise']/..//following-sibling::div//span[contains(@class,'boldFont ng-binding')]")
    public WebElement MERCHANDISE_AGENDA_ITEMS;
    @FindBy(xpath = "//span[text()='Other']/..//following-sibling::div//span[contains(@class,'boldFont ng-binding')]")
    public WebElement OTHER_AGENDA_ITEMS;


    public AgendaPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public ScheduledPage clickOnScheduledTab() throws Exception {
        VerifyPageReady(10);
        Wait(SCHEDULED_TAB, 30);
        click(SCHEDULED_TAB);
        logReport("Successfully clicked on scheduled tab.");
        VerifyAngularHasFinishedProcessing(5);
        VerifyPageReady(5);
        return new ScheduledPage(browser);
    }

    public MerchandisePage clickOnMerchandiseTab() throws Exception {
        VerifyPageReady(10);
        Wait(MERCHANDISE_TAB, 30);
        click(MERCHANDISE_TAB);
        logReport("Successfully clicked on merchandise tab.");
        VerifyAngularHasFinishedProcessing(5);
        VerifyPageReady(5);
        return new MerchandisePage(browser);
    }

    public OtherPage clickOnOtherTab() throws Exception {
        VerifyPageReady(5);
        Wait(OTHER_TAB, 30);
        click(OTHER_TAB);
        logReport("Successfully clicked on other tab.");
        VerifyAngularHasFinishedProcessing(5);
        VerifyPageReady(5);
        return new OtherPage(browser);
    }

    public FeeAndDiscountPage clickOnFeesDiscountTab() throws Exception {
        VerifyPageReady(10);
        Wait(FEES_DISCOUNTS_TAB, 30);
        click(FEES_DISCOUNTS_TAB);
        logReport("Successfully clicked on Fees and Discounts  tab.");
        VerifyAngularHasFinishedProcessing(5);
        VerifyPageReady(5);
        return new FeeAndDiscountPage(browser);
    }

    public AgendaImportPage clickImportButton() throws Exception {
        Wait(IMPORT_TAB, 10);
        click(IMPORT_TAB);
        logReport("Successfully clicked on import tab.");
        VerifyPageReady(5);
        return new AgendaImportPage(browser);
    }

    public void clickExportTab() throws Exception {
        Wait(EXPORT_TAB, 10);
        click(EXPORT_TAB);
        logReport("Successfully clicked on export tab.");

    }

    public void selectCategoryType(String type) {
        String xpath = "//label[contains(.,'" + type + "')]//input[@ng-model='selectedDownloadOption.categoryId']";
        browser.findElement(By.xpath(xpath)).click();
        logReport("Selected Category type " + type);
    }

    public void selectFileType(String type) {
        String xpath = "//label[contains(.,'" + type + "')]//input[@ng-model='selectedDownloadOption.fileType']";
        browser.findElement(By.xpath(xpath)).click();
        logReport("Selected file type " + type);
    }

    public void clickDownloadButton() throws Exception {
        Wait(DOWNLOAD_BUTTON, 10);
        click(DOWNLOAD_BUTTON);
        logReport("Successfully clicked on download button.");
        VerifyPageReady(5);
        VerifyAjaxRequestsFinished(5);
        Thread.sleep(2000);
    }

    public void exportFile(ExportAgenda exportAgenda) throws Exception {
        clickExportTab();
        selectCategoryType(exportAgenda.getCategoryType());
        selectFileType(exportAgenda.getFileType());
        clickDownloadButton();
    }

    public int getScheduledAgendaCount() {
        String text;
        if (verifyElementDisplayed(SCHEDULED_AGENDA_ITEMS, 2)) {
            text = SCHEDULED_AGENDA_ITEMS.getText().trim();
            return Integer.parseInt(text);
        }
        return 0;
    }

    public int getFeesAndDiscountsAgendaCount() {
        String text;
        if (verifyElementDisplayed(FEESDISCOUNTS_AGENDA_ITEMS, 2)) {
            text = FEESDISCOUNTS_AGENDA_ITEMS.getText().trim();
            return Integer.parseInt(text);
        }
        return 0;
    }

    public int getMerchandiseAgendaCount() {
        String text;
        if (verifyElementDisplayed(MERCHANDISE_AGENDA_ITEMS, 2)) {
            text = MERCHANDISE_AGENDA_ITEMS.getText().trim();
            return Integer.parseInt(text);
        }
        return 0;
    }

    public int getOtherAgendaCount() {
        String text;
        if (verifyElementDisplayed(OTHER_AGENDA_ITEMS, 2)) {
            text = OTHER_AGENDA_ITEMS.getText().trim();
            return Integer.parseInt(text);
        }
        return 0;
    }

    public int getTotalAgendaCount() {
        return getScheduledAgendaCount() + getMerchandiseAgendaCount() + getFeesAndDiscountsAgendaCount() + getOtherAgendaCount();
    }
}
