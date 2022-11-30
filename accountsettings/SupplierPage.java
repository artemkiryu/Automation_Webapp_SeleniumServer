package pageObjects.AccountSettings;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddSuplierData;

import java.util.List;

/**
 * Created by infoobjects on 9/20/2017.
 */
public class SupplierPage extends CommonActionsPage{

    @FindBy(xpath = "//button[@x-ng-click='addSupplier()']")
    public WebElement ADD_NEW_BUTTON;
    @FindBy(xpath = "//div[contains(@id,'autogen')]//a[@class='select2-choice select2-default']//span")
    public WebElement DROP_DOWN_SPANS;
    @FindBy(xpath = "//label[text()='Type']/..//b")
    public WebElement DROP_DOWN_OPTIONS;
    @FindBy(xpath = "//input[@name='locationName']")
    public WebElement NAME_TEXTBOX;
    @FindBy(xpath = "//input[@name='locationCode']")
    public WebElement UNIQUE_CODE_TEXTBOX;
    @FindBy(xpath = "//label[text()='State']//../div/div/a/span[@class='select2-chosen']")
    public WebElement STATE_ELEMENT;

    @FindBy(xpath = "//label[text()='Country']")
    public WebElement COUNTRY_LABEL;

    @FindBy(xpath = "//input[@name='locationAddressLine4']")
    public WebElement CITY_TEXTBOX;


    @FindBy(xpath = "//label[text()='Country']//../div/div/a/span[@class='select2-chosen']")
    public WebElement COUNTRY_ELEMENT;

    @FindBy(xpath = "//input[contains(@id,'autogen') and contains(@class,'select2-input')]")
    public List<WebElement> DROP_DOWN_INPUT;
    @FindBy(xpath = "//div[@id='select2-drop']//ul[@class='select2-results']//li//div")
    public List<WebElement> DROP_DOWN_OPTIONS_LIST;
    @FindBy(xpath = "//button[@x-ng-click='saveSupplier(false)']")
    public WebElement SAVE_BUTTON;



    public SupplierPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    private void selectType(String type) throws Exception{
        // VerifyPageReady(30);
        Wait(DROP_DOWN_OPTIONS, 30);
        click(DROP_DOWN_OPTIONS);
        String xpath = "//li//div[@role='option'][text()='"+type+"']";
        WebElement supplierType = browser.findElement(By.xpath(xpath));
        Wait(supplierType,30);
        click(supplierType);
        reporter.info("Selected type = " + type);
    }



    public void enterName(String name) throws Exception{
        VerifyPageReady(30);
        Wait(NAME_TEXTBOX,30);
        type(NAME_TEXTBOX, name);
        logReport("Successfully entered value: " + name + " in name textbox.");
    }

    private void enterUniqueCode(String code) throws Exception{
        // VerifyPageReady(30);
        // Wait(UNIQUE_CODE_TEXTBOX, 30);
        type(UNIQUE_CODE_TEXTBOX, code);
        logReport("Successfully entered value: "+code+" in unique code textbox.");
    }

    private void selectCountry(String country) throws Exception{
        type(CITY_TEXTBOX, "Alaska", true);
        Wait(COUNTRY_ELEMENT, 20);
        COUNTRY_ELEMENT.click();
        VerifyAjaxRequestsFinished(20);
        //  type(COUNTRY_ELEMENT,country,true);

        for (WebElement element : DROP_DOWN_INPUT) {
            if (element.isDisplayed()) {
                element.sendKeys(country);
                VerifyAngularHasFinishedProcessing(30);
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    reporter.info("Exception thrown " + e.getMessage());
                }
                element.sendKeys(Keys.ENTER);
                VerifyPageReady(30);
                wait(10);
                VerifyAjaxRequestsFinished(30);
                VerifyAngularHasFinishedProcessing(30);
            } else {
                //  click(COUNTRY_ELEMENT);
            }
        }
        reporter.info("Selected country value " + country);
    }

    private void selectState(String state) throws Exception{
        Wait(STATE_ELEMENT,30);
        STATE_ELEMENT.click();
        VerifyAjaxRequestsFinished(20);
        // STATE_ELEMENT.click();
        for (WebElement element : DROP_DOWN_INPUT) {
            if (element.isDisplayed()) {
                element.sendKeys(state);
                VerifyAngularHasFinishedProcessing(30);
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    reporter.info("Exception thrown " + e.getMessage());
                }
                element.sendKeys(Keys.ENTER);
                VerifyPageReady(30);
                wait(10);
                VerifyAjaxRequestsFinished(30);
                VerifyAngularHasFinishedProcessing(30);
            }
        }
        reporter.info("Selected state value " + state);
    }

    public void clickSaveButton()throws Exception {
        VerifyPageReady(30);
        Wait(SAVE_BUTTON, 30);
        click(SAVE_BUTTON);
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
        VerifyAngularHasFinishedProcessing(30);
        logReport("successfully clicked on save button.");
    }

    public void clickAddNewButton()throws Exception{
        VerifyPageReady(30);
        Wait(ADD_NEW_BUTTON, 30);
        click(ADD_NEW_BUTTON);
        logReport("successfully clicked on add new button.");
        VerifyAjaxRequestsFinished(20);
        VerifyAngularHasFinishedProcessing(20);
    }

    public void fillSupplierDetailInformationTypeVenue(AddSuplierData addSuplierData) throws Exception{
        selectType(addSuplierData.getType());
        enterName(addSuplierData.getName());
        enterUniqueCode(addSuplierData.getUniqueCode());
        selectCountry(addSuplierData.getCountry());
        selectState(addSuplierData.getState());
    }
}
