package pageObjects.Badges;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.CreateBadgeData;


import java.io.File;
import java.util.List;

/**
 * Created by infoobjects on 22-08-2017.
 */
public class BadgesPage extends CommonActionsPage {
    @FindBy(xpath = "//input[@id='create-link']")
    public WebElement ADDNEW_BUTTON;
    @FindBy(xpath = "//input[@class='form-control ng-pristine ng-valid']")
    public WebElement NAME_TEXTBOX;
    @FindBy(xpath = "//button[text()='Save']")
    public WebElement SAVE_BUTTON;
    @FindBy(xpath = "//select[@ng-model='selectedFieldFilter']")
    public WebElement SELECT_FIELD_DROPDOWN;
    @FindBy(xpath = "//div[@id='fieldsDiv']//a")
    public List<WebElement> FIELDS_OPTIONS_DROPDOWN;
    @FindBy(xpath = "//select[@ng-model='averyTemplate']")
    public WebElement TEMPLATE_DROPDOWN;
    @FindBy(xpath = "//li[@heading='Barcodes']")
    public WebElement BARCODES_TAB;
    @FindBy(xpath = "//li[@heading='Logo']")
    public WebElement LOGO_TAB;
    @FindBy(xpath = "//input[@id='fileUpload']")
    public WebElement CHOOSE_FILE;
    @FindBy(xpath = "//input[@value='Upload']")
    public WebElement UPLOAD_BUTTON;
    @FindBy(xpath = "//button[@title='Save Badge layout.']")
    public WebElement SAVE_BADGE_LAYOUT;
    @FindBy(xpath = "//span[@class='select2-chosen']")
    public WebElement BARCODE_DROPDOWN_ARROW;
    @FindBy(xpath = "//ul[@role='listbox']//li//div")
    public List<WebElement> BARCODE_DROPDOWN_LIST;

    public BadgesPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for clicking add new button
     */
    public void clickAddNew() throws Exception {
        logReport("Click on Add new Button");
        Wait(ADDNEW_BUTTON, 20);
        click(ADDNEW_BUTTON);
        VerifyAngularHasFinishedProcessing(20);
        logReport("Successfully clicked on Add new Button");
    }

    /**
     * Method for entering badge name
     *
     * @param badgeName : badge name
     */
    public void enterBadgeName(String badgeName) throws Exception {
        Wait(NAME_TEXTBOX, 10);
        logReport("Enter : " + badgeName + " into the name textbox");
        NAME_TEXTBOX.sendKeys(badgeName);
        logReport("Successfully entered : " + badgeName + " into name textbox");
    }


    /**
     * Method to click on save button.
     */
    public void clickSaveButton() throws Exception {
        Wait(SAVE_BUTTON, 20);
        click(SAVE_BUTTON);
        logReport("Save button clicked successfully");
        VerifyAngularHasFinishedProcessing(20);
    }

    /**
     * Method for create badges
     *
     * @param createBadgeData: page object of CreateBadgeData
     */
    public void createBadges(CreateBadgeData createBadgeData) throws Exception {
        clickAddNew();
        waitForWindowToAppear();
        enterBadgeName(createBadgeData.getBadgeName());
        try {
            while (browser.getWindowHandles().size() > 1)
                Thread.sleep(1000);
        } catch (Exception e) {
            logReport("Error : " + e.getMessage());
        }
        clickSaveButton();
        selectFields(createBadgeData.getSelectField());
        selectFieldOptions(createBadgeData.getFieldOptions());
        selectTemplate(createBadgeData.getTemplate());
        clickSaveLayout();
    }

    public void selectTemplate(String template) throws Exception {
        Wait(TEMPLATE_DROPDOWN, 20);
        select(TEMPLATE_DROPDOWN, template);
        logReport("Selected template value " + template);
        VerifyAjaxRequestsFinished(20);
    }

    public void selectFields(String field) throws Exception {
        Wait(SELECT_FIELD_DROPDOWN, 20);
        select(SELECT_FIELD_DROPDOWN, field);
        logReport("Selected field value " + field);
        VerifyAjaxRequestsFinished(20);
    }

    public void selectFieldOptions(String options) {
        String list[] = options.split(",");
        for (int i = 0; i < list.length; i++) {
            for (WebElement e : FIELDS_OPTIONS_DROPDOWN) {
                if (e.getText().trim().equalsIgnoreCase(list[i])) {
                    e.click();
                    break;
                }
            }
        }
    }

    public void clickBarcodesTab() {
        click(BARCODES_TAB);
        logReport("Barcodes tab clicked successfully");
    }

    public void clickLogoTab() {
        click(LOGO_TAB);
        logReport("Logo tab clicked successfully");
    }

    public void selectLogoPicture(String logo) throws Exception {
        Wait(CHOOSE_FILE, 20);
        File file = new File("target/test-classes/" + logo);
        String absolutePath = file.getAbsolutePath();

        CHOOSE_FILE.sendKeys(absolutePath);
        logReport("Selected file Absolute Path = " + absolutePath + "logo " + logo);
    }

    public void clickUploadButton() throws Exception {
        click(UPLOAD_BUTTON);
        logReport("Upload button clicked successfully");
        Thread.sleep(5000);
    }

    public void clickSaveLayout() throws Exception {
        Wait(SAVE_BADGE_LAYOUT, 20);
        click(SAVE_BADGE_LAYOUT);
        logReport("Save button clicked successfully");
        VerifyAngularHasFinishedProcessing(20);
    }

    public void selectBarcodeValue(String barcode) throws Exception {
        Wait(BARCODE_DROPDOWN_ARROW, 10);
        click(BARCODE_DROPDOWN_ARROW);
        for (WebElement e : BARCODE_DROPDOWN_LIST) {
            if (e.getText().trim().equalsIgnoreCase(barcode)) {
                e.click();
                logReport("Selected barcode value " + barcode);
            }
        }
        VerifyAjaxRequestsFinished(20);
    }

}
