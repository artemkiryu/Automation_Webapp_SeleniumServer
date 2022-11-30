package pageObjects.Agenda;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import java.util.List;

/**
 * Created by infoobjects on 8/3/2017.
 */
public class FeeAndDiscountPage extends CommonActionsPage {
    @FindBy(xpath = "//button[@ng-click='addNewCustomDiscountType()']")
    public WebElement ADD_NEW_FEE_DISCOUNT_TYPE_BUTTON;

    @FindBy(xpath = "//input[@ng-model='newTypeObject.name']")
    public WebElement ADD_NEW_NAME_TEXTBOX;

    @FindBy(xpath = "//button[@ng-click='save()']")
    public WebElement SAVE_BUTTON;

    @FindBy(xpath = "//h4[text()='Item List']/../..//button[@ng-click='addAgendaItem()']")
    public WebElement ADD_NEW_AGENDA_ITEM_BUTTON;

    @FindBy(xpath = "//h4[@class='modal-title']/span")
    public WebElement PAGE_TITLE_CUSTOM_TYPE;
    @FindBy(xpath = "//input[@ng-model='newTypeObject.name']")
    public WebElement NAME_TEXTBOX;
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement CANCEL_BUTTON;
    @FindBy(xpath = "//div[@class='modal-body confrmBoxHeader ng-scope ng-binding']")
    public WebElement DELETE_WARNING_MSG;
    @FindBy(xpath = "//button[text()='Yes']")
    public WebElement YES_POPUP_BUTTON;
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement CANCEL_POPUP_BUTTON;

    @FindBy(xpath = "//ul[@ng-model='pagination.customPageNo']//li[@ng-repeat='page in pages track by $index']/a")
    public List<WebElement> PAGINATION_LIST_CUSTOM_PAGES;

    // @FindBy(xpath = "//span[text()='Items Per Page']")
    @FindBy(xpath = "//div[@class='col-sm-7 pt5']//label[@class='ng-binding']")
    public WebElement PER_ITEMS_PAGE_LABEL;
    @FindBy(xpath = "//ul[@ng-model='pagination.customPageNo']")
    public WebElement PAGINATION_LIST_CUSTOM;


    public FeeAndDiscountPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public AddAgendaPage clickAddNewAgendaButton() throws Exception {
        scrollTop();
        VerifyPageReady(30);
        Wait(ADD_NEW_AGENDA_ITEM_BUTTON, 30);
        click(ADD_NEW_AGENDA_ITEM_BUTTON);
        logReport("Successfully clicked on 'Add New Agenda Item' button.");
        VerifyAngularHasFinishedProcessing(5);
        VerifyPageReady(5);
        return new AddAgendaPage(browser);
    }

    public void clickAddNewCustomTypeButton() throws Exception {
        VerifyPageReady(30);
        Wait(ADD_NEW_FEE_DISCOUNT_TYPE_BUTTON, 30);
        clickByJavaScript(ADD_NEW_FEE_DISCOUNT_TYPE_BUTTON);
        logReport("Successfully clicked on 'Add New Custom Fee & Discount Types' button.");
        VerifyPageReady(20);
    }

    public void enterNameValue(String name) {
        type(NAME_TEXTBOX, name, true);
        logReport("Entered name value " + name);
    }

    public void clickSaveButton() throws Exception {
        Wait(SAVE_BUTTON, 30);
        clickByJavaScript(SAVE_BUTTON);
        logReport("Save button clicked successfully");
        VerifyAngularHasFinishedProcessing(5);
        VerifyAjaxRequestsFinished(5);
        VerifyPageReady(5);
    }

    public void clickSaveButtonWithoutAngular() throws Exception {
        Wait(SAVE_BUTTON, 30);
        click(SAVE_BUTTON);
        logReport("Save button clicked successfully");

    }

    public void clickCancelButton() throws Exception {
        click(CANCEL_BUTTON);
        logReport("Cancel button clicked successfully");
        VerifyAngularHasFinishedProcessing(5);
        VerifyPageReady(5);
    }

    public boolean isCustomFeeAndDiscountTypeFound(String type) throws Exception {
        boolean found = false;
        String xpath = "//tr[@ng-repeat='item in customDiscountItemsWithLimit']//td[1][text()='" + type + "']";
        if (VerifyElementPresent(By.xpath(xpath), 2)) {
            found = true;
        } else {
            for (int i = 0; i < PAGINATION_LIST_CUSTOM_PAGES.size(); i++) {
                clickByJavaScript(PAGINATION_LIST_CUSTOM_PAGES.get(i));
                if (VerifyElementPresent(By.xpath(xpath), 2)) {
                    found = true;
                }
            }
        }
        return found;

    }

    public boolean isMultibyteCharacterFound(String value) throws Exception {
        boolean found = false;
        String xpath = "//tr[@ng-repeat='item in customDiscountItemsWithLimit']//td[1]";
        for (int i = 0; i < PAGINATION_LIST_CUSTOM_PAGES.size(); i++) {
            clickByJavaScript(PAGINATION_LIST_CUSTOM_PAGES.get(i));
            logReport("value of i " + i);
            List<WebElement> elements = browser.findElements(By.xpath(xpath));
            for (WebElement e : elements) {
                logReport("value of text " + e.getText());
                if (e.getText().trim().equalsIgnoreCase(value)) {
                    found = true;
                    break;
                }
            }
        }
        return found;
    }

    public void editCustomTypeField(String type) throws Exception {
        String xpath = "//tr[@ng-repeat='item in customDiscountItemsWithLimit']//td[1][text()='" + type + "']/..//td/a[@title='Edit']";
        if (VerifyElementPresent(By.xpath(xpath), 2)) {
            clickByJavaScript(browser.findElement(By.xpath(xpath)));
        } else {
            for (int i = 0; i < PAGINATION_LIST_CUSTOM_PAGES.size(); i++) {
                clickByJavaScript(PAGINATION_LIST_CUSTOM_PAGES.get(i));
                if (VerifyElementPresent(By.xpath(xpath), 2)) {
                    clickByJavaScript(browser.findElement(By.xpath(xpath)));
                    return;
                }
            }
        }
    }

    public String getCustomTypeName() {
        return NAME_TEXTBOX.getAttribute("value").trim();
    }

    public void copyCustomTypeField(String type) throws Exception {
        String xpath = "//tr[@ng-repeat='item in customDiscountItemsWithLimit']//td[1][text()='" + type + "']/..//td/a[@title='Copy']";
        if (VerifyElementPresent(By.xpath(xpath), 2)) {
            clickByJavaScript(browser.findElement(By.xpath(xpath)));
        } else {
            for (int i = 0; i < PAGINATION_LIST_CUSTOM_PAGES.size(); i++) {
                clickByJavaScript(PAGINATION_LIST_CUSTOM_PAGES.get(i));
                if (VerifyElementPresent(By.xpath(xpath), 2)) {
                    clickByJavaScript(browser.findElement(By.xpath(xpath)));
                    return;
                }
            }
        }

    }

    public void copyMultibyteCharacter(String value) throws Exception {
        String xpath = "//tr[@ng-repeat='item in customDiscountItemsWithLimit']//td[1]";
        for (int i = 0; i < PAGINATION_LIST_CUSTOM_PAGES.size(); i++) {
            clickByJavaScript(PAGINATION_LIST_CUSTOM_PAGES.get(i));
            List<WebElement> elements = browser.findElements(By.xpath(xpath));
            for (WebElement e : elements) {
                //logReport("value of text " + e.getText());
                if (e.getText().trim().equalsIgnoreCase(value)) {
                    WebElement element = e.findElement(By.xpath("../td//a[@title='Copy']"));
                    clickByJavaScript(element);
                    return;
                }
            }
        }
    }

    public void deleteCustomTypeField(String type) throws Exception {
        String xpath = "//tr[@ng-repeat='item in customDiscountItemsWithLimit']//td[1][text()='" + type + "']/..//td/a[@title='Delete']";
        if (VerifyElementPresent(By.xpath(xpath), 2)) {
            clickByJavaScript(browser.findElement(By.xpath(xpath)));
        } else {
            for (int i = 0; i < PAGINATION_LIST_CUSTOM_PAGES.size(); i++) {
                clickByJavaScript(PAGINATION_LIST_CUSTOM_PAGES.get(i));
                if (VerifyElementPresent(By.xpath(xpath), 2)) {
                    clickByJavaScript(browser.findElement(By.xpath(xpath)));
                    return;
                }
            }
        }
    }

    public void deleteMultibyteCharacter(String value) throws Exception {
        String xpath = "//tr[@ng-repeat='item in customDiscountItemsWithLimit']//td[1]";
        for (int i = 0; i < PAGINATION_LIST_CUSTOM_PAGES.size(); i++) {
            clickByJavaScript(PAGINATION_LIST_CUSTOM_PAGES.get(i));
            List<WebElement> elements = browser.findElements(By.xpath(xpath));
            for (WebElement e : elements) {
                //logReport("value of text " + e.getText());
                if (e.getText().trim().equalsIgnoreCase(value)) {
                    WebElement element = e.findElement(By.xpath("../td//a[@title='Delete']"));
                    clickByJavaScript(element);
                    return;
                }
            }
        }
    }

    public void clickCancelPopupButton() throws Exception {
        Wait(CANCEL_POPUP_BUTTON, 30);
        clickByJavaScript(CANCEL_POPUP_BUTTON);
        logReport("Cancel popup button clicked successfully");
        VerifyPageReady(5);
    }

    public void clickYesButton() throws Exception {

        Wait(YES_POPUP_BUTTON, 30);
        clickByJavaScript(YES_POPUP_BUTTON);
        logReport("Yes popup button clicked successfully");
        VerifyPageReady(5);
    }


}
