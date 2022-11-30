package pageObjects.Agenda;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by infoobjects on 21-09-2017.
 */
public class MerchandisePage extends CommonActionsPage {

    public static final List<String> customHeaders = new ArrayList<>(Arrays.asList("Type Name", "Used by # of Items", "Actions"));
    @FindBy(xpath = "//h4[text()='Item List']/../..//button[@ng-click='addAgendaItem()']")
    public WebElement ADD_NEW_AGENDA_ITEM_BUTTON;
    @FindBy(xpath = "//button[@ng-click='addNewMerchandiseManagementItem()']")
    public WebElement ADD_NEW_GROUP_CLASSIFICATION_BUTTON;
    @FindBy(xpath = "//input[@ng-model='newTypeObject.name']")
    public WebElement NAME_TEXTBOX;
    @FindBy(xpath = "//button[text()='Save']")
    public WebElement SAVE_BUTTON;
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement CANCEL_BUTTON;
    @FindBy(xpath = "//input[@value='Group']")
    public WebElement GROUP_RADIOBUTTON;
    @FindBy(xpath = "//input[@value='Track']")
    public WebElement CLASSIFICATION_RADIOBUTTON;
    @FindBy(xpath = "//input[@ng-model='searchForGroupTrackLocationModel.search']")
    public WebElement SEARCH_TEXTBOX;
    @FindBy(xpath = "//input[@ng-model='searchForGroupTrackLocationModel.search']/../span")
    public WebElement SEARCH_ICON;
    @FindBy(xpath = "//div[@class='col-sm-7 pt5']//label[@class='ng-binding']")
    public WebElement PER_ITEMS_PAGE_LABEL;
    @FindBy(xpath = "//ul[@ng-model='pagination.groupingPageNo']")
    public WebElement PAGINATION_LIST;
    @FindBy(xpath = "//tr[@ng-repeat='item in itemsByLocationGroupTrackWithLimit']//td[3]//a[@title='Edit']")
    public WebElement EDIT_ICON;
    @FindBy(xpath = "//tr[@ng-repeat='item in itemsByLocationGroupTrackWithLimit']//td[3]//a[@title='Delete']")
    public WebElement DELETE_ICON;
    @FindBy(xpath = "//div[@class='modal-body confrmBoxHeader ng-scope ng-binding']")
    public WebElement DELETE_WARNING_MSG;
    @FindBy(xpath = "//button[text()='Yes']")
    public WebElement YES_POPUP_BUTTON;
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement CANCEL_POPUP_BUTTON;
    @FindBy(xpath = "//h4[@class='modal-title']/span")
    public WebElement PAGE_TITLE_CUSTOM_TYPE;
    @FindBy(xpath = "//h4[text()='Custom Merchandise Types']/../..//button[text()='Add New']")
    public WebElement ADD_NEW_MERCHANDISE_TYPE_BUTTON;
    @FindBy(xpath = "//ul[@ng-model='pagination.customPageNo']//li[@ng-repeat='page in pages track by $index']/a")
    public List<WebElement> PAGINATION_LIST_CUSTOM_PAGES;
    @FindBy(xpath = "//div[@ng-if='showCustomMerchandiseType']//table//tr//th")
    public List<WebElement> LIST_HEADERS_CUSTOM_TYPE;
    @FindBy(xpath = "//tr[@ng-repeat='item in customMerchandiseItemsWithLimit']//td[3]//a[@title='Edit']")
    public WebElement EDIT_ICON_CUSTOM_TYPE;
    @FindBy(xpath = "//tr[@ng-repeat='item in customMerchandiseItemsWithLimit']//td[3]//a[@title='Delete']")
    public WebElement DELETE_ICON_CUSTOM_TYPE;
    @FindBy(xpath = "//tr[@ng-repeat='item in customMerchandiseItemsWithLimit']//td[3]//a[@title='Copy']")
    public WebElement COPY_ICON_CUSTOM_TYPE;
    @FindBy(xpath = "//ul[@ng-model='pagination.customPageNo']")
    public WebElement PAGINATION_LIST_CUSTOM;
    @FindBy(xpath = "//ul[@ng-model='pagination.groupingPageNo']//li[@ng-repeat='page in pages track by $index']/a")
    public List<WebElement> PAGINATION_LIST_GROUP_CLASSIFICATION_PAGES;

    public MerchandisePage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public AddAgendaPage clickAddNewAgendaButton() throws Exception {
        scrollTop();
        VerifyPageReady(10);
        Wait(ADD_NEW_AGENDA_ITEM_BUTTON, 30);
        clickByJavaScript(ADD_NEW_AGENDA_ITEM_BUTTON);
        logReport("Successfully clicked on 'Add New Agenda Item' button.");
        VerifyAngularHasFinishedProcessing(5);
        VerifyPageReady(5);
        return new AddAgendaPage(browser);
    }

    public void clickAddNewGroupClassificationButton() throws Exception {
        VerifyPageReady(10);
        Wait(ADD_NEW_GROUP_CLASSIFICATION_BUTTON, 30);
        clickByJavaScript(ADD_NEW_GROUP_CLASSIFICATION_BUTTON);
        logReport("Successfully clicked on 'Add New Agenda Group Classification' button.");
        VerifyAngularHasFinishedProcessing(5);
        VerifyPageReady(5);
    }

    public void clickCancelButton() throws Exception {
        click(CANCEL_BUTTON);
        logReport("Cancel button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(5);
    }

    public void fillCustomClassificationData(String name, String designation) throws Exception {
        enterNameValue(name);
        selectDesignationType(designation);
        clickSaveButton();
    }

    public void enterNameValue(String name) throws Exception {
        Wait(NAME_TEXTBOX, 20);
        type(NAME_TEXTBOX, name, true);
        logReport("Entered name value " + name);
    }

    public void selectDesignationType(String value) {
        //WebElement element = browser.findElement(By.xpath("//input[@type='radio'][@value='" + value + "']"));
        WebElement element = browser.findElement(By.xpath("//label[contains(.,'" + value + "')]/input"));
        clickByJavaScript(element);
        logReport("Selected Designation type " + value);
    }

    public void clearFilters() throws Exception {
        SEARCH_TEXTBOX.clear();
        VerifyPageReady(10);
    }

    public void clickSaveButton() throws Exception {
        Wait(SAVE_BUTTON, 30);
        click(SAVE_BUTTON);
        logReport("Save button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyAjaxRequestsFinished(10);
        VerifyPageReady(10);
    }

    public boolean isCustomClassificationNameAndDesignationFound(String name, String type) throws Exception {
        searchCustomData(name);
        String xpath = "//tr[@ng-repeat='item in itemsByLocationGroupTrackWithLimit']//td[1][text()='" + name + "']//following-sibling::td[text()='" + type + "']";
        return VerifyElementPresent(By.xpath(xpath), 2);
        //return verifyElementDisplayed(browser.findElement(By.xpath(xpath)), 20);
    }

    public void searchCustomData(String name) throws Exception {
        type(SEARCH_TEXTBOX, name, true);
        logReport("Entered custom data value " + name);
        clickByJavaScript(SEARCH_ICON);
        logReport("Search icon clicked successfully");
        VerifyPageReady(5);
        VerifyAjaxRequestsFinished(5);
    }

    public void clickSaveButtonWithoutAngular() throws Exception {
        Wait(SAVE_BUTTON, 30);
        click(SAVE_BUTTON);
        logReport("Save button clicked successfully");

    }

    public int getCustomNameLength(String name) throws Exception {
        searchCustomData(name);
        String xpath = "//tr[@ng-repeat='item in itemsByLocationGroupTrackWithLimit']//td[1][contains(text(),'" + name + "')]";
        WebElement element = browser.findElement(By.xpath(xpath));
        return element.getText().trim().length() + 1;
    }

    public void editCustomClassificationData(String name, String designation) throws Exception {
        searchCustomData(name);
        String xpath = "//tr[@ng-repeat='item in itemsByLocationGroupTrackWithLimit']//td[1][text()='" + name + "']//following-sibling::td[text()='" + designation + "']/..//td[3]//a[@title='Edit']";
        WebElement element = browser.findElement(By.xpath(xpath));
        clickByJavaScript(element);
        logReport("Successfully edit on custom classification data " + name);
    }

    public void deleteCustomClassificationData(String name, String designation) throws Exception {
        searchCustomData(name);
        String xpath = "//tr[@ng-repeat='item in itemsByLocationGroupTrackWithLimit']//td[1][text()='" + name + "']//following-sibling::td[text()='" + designation + "']/..//td[3]//a[@title='Delete']";
        WebElement element = browser.findElement(By.xpath(xpath));
        clickByJavaScript(element);
        logReport("Successfully delete on custom classification data " + name);
        VerifyPageReady(20);
    }

    public String getWarningMessage() throws Exception {
        Thread.sleep(2000);
        return DELETE_WARNING_MSG.getText().trim();
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
        VerifyPageReady(10);
        VerifyAngularHasFinishedProcessing(30);
    }

    public void clickAddNewCustomTypeButton() throws Exception {
        VerifyPageReady(10);
        Wait(ADD_NEW_MERCHANDISE_TYPE_BUTTON, 30);
        clickByJavaScript(ADD_NEW_MERCHANDISE_TYPE_BUTTON);
        logReport("Successfully clicked on 'Add New Custom Merchandise Type' button.");
        VerifyAngularHasFinishedProcessing(3);
        VerifyPageReady(5);
    }

    public boolean isCustomMerchandiseTypeFound(String type) throws Exception {
        boolean found = false;
        String xpath = "//tr[@ng-repeat='item in customMerchandiseItemsWithLimit']//td[1][text()='" + type + "']";
        if (VerifyElementPresent(By.xpath(xpath), 2)) {
            found = true;
        } else {
            for (int i = 0; i < PAGINATION_LIST_CUSTOM_PAGES.size(); i++) {
                clickByJavaScript(PAGINATION_LIST_CUSTOM_PAGES.get(i));
                VerifyAngularHasFinishedProcessing(10);
                if (VerifyElementPresent(By.xpath(xpath), 2)) {
                    found = true;
                }
            }
        }
        return found;

    }

    public boolean isMultibyteCharacterFound(String value) throws Exception {
        boolean found = false;
        String xpath = "//tr[@ng-repeat='item in customMerchandiseItemsWithLimit']//td[1]";
        for (int i = 0; i < PAGINATION_LIST_CUSTOM_PAGES.size(); i++) {
            clickByJavaScript(PAGINATION_LIST_CUSTOM_PAGES.get(i));
            VerifyAngularHasFinishedProcessing(10);
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

    public List<String> getCustomHeadersType() {
        List<String> customHeadersList = new ArrayList<>();
        for (WebElement e : LIST_HEADERS_CUSTOM_TYPE) {
            customHeadersList.add(e.getText().trim());
        }
        return customHeadersList;
    }

    public void editCustomTypeField(String type) throws Exception {
        String xpath = "//tr[@ng-repeat='item in customMerchandiseItemsWithLimit']//td[1][text()='" + type + "']/..//td/a[@title='Edit']";
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

    public void copyCustomTypeField(String type) throws Exception {
        String xpath = "//tr[@ng-repeat='item in customMerchandiseItemsWithLimit']//td[1][text()='" + type + "']/..//td/a[@title='Copy']";
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
        String xpath = "//tr[@ng-repeat='item in customMerchandiseItemsWithLimit']//td[1]";
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
        String xpath = "//tr[@ng-repeat='item in customMerchandiseItemsWithLimit']//td[1][text()='" + type + "']/..//td/a[@title='Delete']";
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
        String xpath = "//tr[@ng-repeat='item in customMerchandiseItemsWithLimit']//td[1]";
        for (int i = 0; i < PAGINATION_LIST_CUSTOM_PAGES.size(); i++) {
            clickByJavaScript(PAGINATION_LIST_CUSTOM_PAGES.get(i));
            List<WebElement> elements = browser.findElements(By.xpath(xpath));
            for (WebElement e : elements) {
                logReport("value of text " + e.getText());
                if (e.getText().trim().equalsIgnoreCase(value)) {
                    WebElement element = e.findElement(By.xpath("../td//a[@title='Delete']"));
                    clickByJavaScript(element);
                    return;
                }
            }
        }
    }


    public String getCustomTypeName() {
        return NAME_TEXTBOX.getAttribute("value").trim();
    }

    public boolean isMultibyteCharacterFoundForGroupClassification(String value) throws Exception {
        searchCustomData(value);
        boolean found = false;
        String xpath = "//tr[@ng-repeat='item in itemsByLocationGroupTrackWithLimit']//td[1]";
        for (int i = 0; i < PAGINATION_LIST_GROUP_CLASSIFICATION_PAGES.size(); i++) {
            clickByJavaScript(PAGINATION_LIST_GROUP_CLASSIFICATION_PAGES.get(i));
            VerifyAngularHasFinishedProcessing(10);
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
}
