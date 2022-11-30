package pageObjects.Badges;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddBarcodes;

import java.util.List;

/**
 * Created by infoobjects on 22-08-2017.
 */
public class BarcodesPage extends CommonActionsPage {
    @FindBy(xpath = "//input[@value='Add New']")
    public WebElement ADD_NEW_BUTTON;
    @FindBy(xpath = "//input[@ng-model='barcode.name']")
    public WebElement BARCODE_NAME;
    @FindBy(xpath = "//button[text()='Select Fields to Add or Remove']")
    public WebElement SELECT_FIELDS_TO_ADD_REMOVE_BUTTON;
    @FindBy(xpath = "//select[@ng-model='selectedFieldFilter']")
    public WebElement SELECT_FIELD_DROPDOWN;
    @FindBy(xpath = "//div[@id='fieldsDiv']//a")
    public List<WebElement> FIELDS_OPTIONS_DROPDOWN;
    @FindBy(xpath = "//input[@id='search']")
    public WebElement SEARCH_TEXTBOX;
    @FindBy(xpath = "//input[@value='Use Selections']")
    public WebElement USE_SELECTIONS_BUTTON;
    @FindBy(xpath = "//select[@ng-model='barcode.delimiter']")
    public WebElement BARCODE_DELIMITER_DROPDOWN;
    @FindBy(xpath = "//button[text()='Save']")
    public WebElement SAVE_BUTTON;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Badges']")
    public WebElement BADGES_TAB;

    public BarcodesPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void clickAddNewButton() throws Exception {
        VerifyPageReady(20);
        Wait(ADD_NEW_BUTTON, 20);
        click(ADD_NEW_BUTTON);
        VerifyPageReady(20);
        logReport("Add New button clicked successfully");
    }

    private void enterBarcodesName(String barcodeName) throws Exception {
        Wait(BARCODE_NAME, 20);
        type(BARCODE_NAME, barcodeName, true);
        logReport("Entered Barcode name " + barcodeName);

    }

    private void selectBarCodeFormatOptions(String formatCode) throws Exception {
        String xpath = "//label[contains(.,'" + formatCode + "')]/..//input";
        click(browser.findElement(By.xpath(xpath)));
        logReport("Barcode format options " + formatCode);

    }

    public void selectDDF(String field, String fieldOptions) throws Exception {
        Wait(SELECT_FIELDS_TO_ADD_REMOVE_BUTTON, 20);
        click(SELECT_FIELDS_TO_ADD_REMOVE_BUTTON);

        Wait(SELECT_FIELD_DROPDOWN, 10);
        select(SELECT_FIELD_DROPDOWN, field);

        String fields[] = fieldOptions.split(",");

        for (int i = 0; i < fields.length; i++) {
            type(SEARCH_TEXTBOX, fields[i], true);
            String xpath = "//div[@class='dropdown-list-block']//span[text()='" + fields[i] + "']//input";
            WebElement element = browser.findElement(By.xpath(xpath));
            if (!element.isSelected()) {
                element.click();
            }
            logReport("DDfs selected successfully " + fields[i]);
        }
        click(USE_SELECTIONS_BUTTON);
    }

    private void selectBarcodeDelimiter(String delimiterType) throws Exception {
        select(BARCODE_DELIMITER_DROPDOWN, delimiterType);
        logReport("Selected Barcode delimiter dropdown value " + delimiterType);

    }

    public void clickSaveButton() throws Exception {
        click(SAVE_BUTTON);
        logReport("Save button clicked successfully");
        VerifyPageReady(30);
    }

    public void CreateBarcodes(AddBarcodes addBarcodes) throws Exception {
        enterBarcodesName(addBarcodes.getBarcodeName());
        selectBarCodeFormatOptions(addBarcodes.getBarcodeFormat());
        selectDDF(addBarcodes.getFieldName(), addBarcodes.getFieldOptions());
        selectBarcodeDelimiter(addBarcodes.getBarcodeDelimiter());
    }

    public void editBarcodes(String barcodeName) throws Exception {
        String xpath = "//table//td[text()='" + barcodeName + "']/..//td//img[@title='Edit']";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 20);
        click(element);
        logReport("Barcode edited successfully");
        VerifyPageReady(20);
    }

    public BadgesPage clickBadgesTab() throws Exception {
        Wait(BADGES_TAB, 20);
        click(BADGES_TAB);
        logReport("Badges tab clicked successfully");
        VerifyPageReady(20);
        return new BadgesPage(browser);
    }

}
