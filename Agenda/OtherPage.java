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
 * Created by infoobjects on 8/3/2017.
 */
public class OtherPage extends CommonActionsPage{

    public static final List<String> customHeaders = new ArrayList<>(Arrays.asList("Type Name", "Used by # of Items", "Actions"));

    public static final List<String> customLocationHeaders = new ArrayList<>(Arrays.asList("Name", "Designation", "Actions"));

    @FindBy(xpath = "//h4[text()='Item List']/../..//button[@ng-click='addAgendaItem()']")
    public WebElement ADD_NEW_AGENDA_ITEM_BUTTON;
    @FindBy(xpath = "//button[contains(@ng-click,'addNewCustomOtherType')]")
    public WebElement ADD_NEW_CUSTOM_TYPE_BUTTON;
    @FindBy(xpath = "//input[@ng-model='newTypeObject.name']")
    public WebElement NAME_TEXTBOX;
    @FindBy(xpath = "//button[@ng-click='save()']")
    public WebElement SAVE_BUTTON;
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement CANCEL_BUTTON;
    @FindBy(xpath = "//h4[@class='modal-title']/span")
    public WebElement PAGE_TITLE_CUSTOM_TYPE;
    @FindBy(xpath = "//ul[@ng-model='pagination.customPageNo']//li[@ng-repeat='page in pages track by $index']/a")
    public List<WebElement> PAGINATION_LIST_CUSTOM_PAGES;
    @FindBy(xpath = "//ul[@ng-model='pagination.groupingPageNo']//li[@ng-repeat='page in pages track by $index']/a")
    public List<WebElement> PAGINATION_LIST_GROUP_LOCATION_TRACK_PAGES;
    @FindBy(xpath = "//div[@ng-if='showCustomOtherType']//table//tr//th")
    public List<WebElement> LIST_HEADERS_CUSTOM_TYPE;
    @FindBy(xpath = "//tr[@ng-repeat='item in customOtherItemsWithLimit']//td[3]//a[@title='Edit']")
    public WebElement EDIT_ICON_CUSTOM_TYPE;
    @FindBy(xpath = "//tr[@ng-repeat='item in customOtherItemsWithLimit']//td[3]//a[@title='Delete']")
    public WebElement DELETE_ICON_CUSTOM_TYPE;
    @FindBy(xpath = "//tr[@ng-repeat='item in customOtherItemsWithLimit']//td[3]//a[@title='Copy']")
    public WebElement COPY_ICON_CUSTOM_TYPE;
    @FindBy(xpath = "//div[@class='col-sm-7 pt5']//label[@class='ng-binding']")
    public WebElement PER_ITEMS_PAGE_LABEL;
    @FindBy(xpath = "//ul[@ng-model='pagination.groupingPageNo']")
    public WebElement PAGINATION_LIST;
    @FindBy(xpath = "//ul[@ng-model='pagination.customPageNo']")
    public WebElement PAGINATION_LIST_CUSTOM;
    @FindBy(xpath = "//div[@class='modal-body confrmBoxHeader ng-scope ng-binding']")
    public WebElement DELETE_WARNING_MSG;
    @FindBy(xpath = "//button[text()='Yes']")
    public WebElement YES_POPUP_BUTTON;
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement CANCEL_POPUP_BUTTON;
    @FindBy(xpath = "//button[@ng-click='addNewOtherManagementItem()']")
    public WebElement ADD_NEW_GROUP_LOCATION_TRACK_BUTTON;
    @FindBy(xpath = "//input[@value='Group']")
    public WebElement GROUP_RADIOBUTTON;
    @FindBy(xpath = "//input[@value='Track']")
    public WebElement TRACK_RADIOBUTTON;
    @FindBy(xpath = "//input[@value='Location']")
    public WebElement LOCATION_RADIOBUTTON;
    @FindBy(xpath = "//input[@ng-model='searchForGroupTrackLocationModel.search']")
    public WebElement SEARCH_TEXTBOX;
    @FindBy(xpath = "//input[@ng-model='searchForGroupTrackLocationModel.search']/../span")
    public WebElement SEARCH_ICON;
    @FindBy(xpath = "//tr[@ng-repeat='item in itemsByLocationGroupTrackWithLimit']//td[3]//a[@title='Edit']")
    public WebElement EDIT_ICON;
    @FindBy(xpath = "//tr[@ng-repeat='item in itemsByLocationGroupTrackWithLimit']//td[3]//a[@title='Delete']")
    public WebElement DELETE_ICON;
    @FindBy(xpath = "//div[@ng-if='showOtherManagementItem']//tbody//tr//th")
    public List<WebElement> LIST_HEADERS_CUSTOM_LOCATION;

    public OtherPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public AddAgendaPage clickAddNewAgendaButton() throws Exception {
        scrollTop();
        VerifyPageReady(10);
        Wait(ADD_NEW_AGENDA_ITEM_BUTTON, 30);
        clickByJavaScript(ADD_NEW_AGENDA_ITEM_BUTTON);
        logReport("Successfully clicked on 'Add New Agenda Item of Other type' button.");
        VerifyAngularHasFinishedProcessing(5);
        VerifyPageReady(5);
        return new AddAgendaPage(browser);
    }

    public void clickAddNewCustomTypeButton() throws Exception {
        VerifyPageReady(10);
        Wait(ADD_NEW_CUSTOM_TYPE_BUTTON, 30);
        clickByJavaScript(ADD_NEW_CUSTOM_TYPE_BUTTON);
        logReport("Successfully clicked on 'Add New Custom Merchandise Type' button.");
        //VerifyAngularHasFinishedProcessing(20);
        VerifyPageReady(5);
    }

    public void enterNameValue(String name) {
        type(NAME_TEXTBOX, name, true);
        logReport("Entered name value " + name);
    }

    public void clickSaveButton() throws Exception {
        Wait(SAVE_BUTTON, 10);
        click(SAVE_BUTTON);
        logReport("Save button clicked successfully");
        VerifyAngularHasFinishedProcessing(5);
        VerifyAjaxRequestsFinished(5);
        VerifyPageReady(5);
    }

    public boolean isCustomOtherTypeFound(String type) throws Exception {
        boolean found = false;
        String xpath = "//tr[@ng-repeat='item in customOtherItemsWithLimit']//td[1][text()='" + type + "']";
        if (VerifyElementPresent(By.xpath(xpath), 2)) {
            found = true;
        } else {
            for (int i = 0; i < PAGINATION_LIST_CUSTOM_PAGES.size(); i++) {
                clickByJavaScript(PAGINATION_LIST_CUSTOM_PAGES.get(i));
                VerifyAngularHasFinishedProcessing(20);
                if (VerifyElementPresent(By.xpath(xpath), 2)) {
                    found = true;
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

    public boolean isMultibyteCharacterFound(String value) throws Exception {
        boolean found = false;
        String xpath = "//tr[@ng-repeat='item in customOtherItemsWithLimit']//td[1]";
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

    public void copyMultibyteCharacter(String value) throws Exception {
        String xpath = "//tr[@ng-repeat='item in customOtherItemsWithLimit']//td[1]";
        for (int i = 0; i < PAGINATION_LIST_CUSTOM_PAGES.size(); i++) {
            clickByJavaScript(PAGINATION_LIST_CUSTOM_PAGES.get(i));
            VerifyAngularHasFinishedProcessing(10);
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

    public void editCustomTypeField(String type) throws Exception {
        String xpath = "//tr[@ng-repeat='item in customOtherItemsWithLimit']//td[1][text()='" + type + "']/..//td/a[@title='Edit']";
        if (VerifyElementPresent(By.xpath(xpath), 2)) {
            clickByJavaScript(browser.findElement(By.xpath(xpath)));
            VerifyPageReady(20);
        } else {
            for (int i = 0; i < PAGINATION_LIST_CUSTOM_PAGES.size(); i++) {
                clickByJavaScript(PAGINATION_LIST_CUSTOM_PAGES.get(i));
                VerifyAngularHasFinishedProcessing(10);
                if (VerifyElementPresent(By.xpath(xpath), 2)) {
                    clickByJavaScript(browser.findElement(By.xpath(xpath)));
                    VerifyPageReady(20);
                    return;
                }
            }
        }
    }

    public void deleteCustomTypeField(String type) throws Exception {
        String xpath = "//tr[@ng-repeat='item in customOtherItemsWithLimit']//td[1][text()='" + type + "']/..//td/a[@title='Delete']";
        if (VerifyElementPresent(By.xpath(xpath), 2)) {
            clickByJavaScript(browser.findElement(By.xpath(xpath)));
        } else {
            for (int i = 0; i < PAGINATION_LIST_CUSTOM_PAGES.size(); i++) {
                clickByJavaScript(PAGINATION_LIST_CUSTOM_PAGES.get(i));
                VerifyAngularHasFinishedProcessing(10);
                if (VerifyElementPresent(By.xpath(xpath), 2)) {
                    clickByJavaScript(browser.findElement(By.xpath(xpath)));
                    return;
                }
            }
        }
    }

    public void deleteMultibyteCharacter(String value) throws Exception {
        String xpath = "//tr[@ng-repeat='item in customOtherItemsWithLimit']//td[1]";
        for (int i = 0; i < PAGINATION_LIST_CUSTOM_PAGES.size(); i++) {
            clickByJavaScript(PAGINATION_LIST_CUSTOM_PAGES.get(i));
            VerifyAngularHasFinishedProcessing(10);
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

    public void copyCustomTypeField(String type) throws Exception {
        String xpath = "//tr[@ng-repeat='item in customOtherItemsWithLimit']//td[1][text()='" + type + "']/..//td/a[@title='Copy']";
        if (VerifyElementPresent(By.xpath(xpath), 2)) {
            clickByJavaScript(browser.findElement(By.xpath(xpath)));
        } else {
            for (int i = 0; i < PAGINATION_LIST_CUSTOM_PAGES.size(); i++) {
                clickByJavaScript(PAGINATION_LIST_CUSTOM_PAGES.get(i));
                VerifyAngularHasFinishedProcessing(10);
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

    public void clickYesButton() throws Exception {
        Wait(YES_POPUP_BUTTON, 30);
        clickByJavaScript(YES_POPUP_BUTTON);
        logReport("Yes popup button clicked successfully");
        VerifyPageReady(5);
    }

    public void clickCancelPopupButton() throws Exception {
        Wait(CANCEL_POPUP_BUTTON, 30);
        clickByJavaScript(CANCEL_POPUP_BUTTON);
        logReport("Cancel popup button clicked successfully");
        VerifyPageReady(5);
    }

    public void clickAddNewGroupLocationTrackButton() throws Exception {
        VerifyPageReady(10);
        Wait(ADD_NEW_GROUP_LOCATION_TRACK_BUTTON, 30);
        clickByJavaScript(ADD_NEW_GROUP_LOCATION_TRACK_BUTTON);
        logReport("Successfully clicked on 'Add New Agenda Group Location Track' button.");
        VerifyAngularHasFinishedProcessing(5);
        VerifyPageReady(5);
    }

    public void clearFilters() throws Exception {
        SEARCH_TEXTBOX.clear();
        VerifyPageReady(10);
    }
    public void fillCustomLocationData(String name, String designation) throws Exception {
        enterNameValue(name);
        selectDesignationType(designation);
        clickSaveButton();
    }

    public void selectDesignationType(String value) {
        WebElement element = browser.findElement(By.xpath("//input[@type='radio'][@value='" + value + "']"));
        clickByJavaScript(element);
        logReport("Selected Designation type " + value);
    }

    public boolean isCustomLocationNameAndDesignationFound(String name, String type) throws Exception {
        searchCustomData(name);
        String xpath = "//tr[@ng-repeat='item in itemsByLocationGroupTrackWithLimit']//td[1][text()='" + name + "']//following-sibling::td[text()='" + type + "']";
        return VerifyElementPresent(By.xpath(xpath), 2);
    }

    public void searchCustomData(String name) throws Exception {
        type(SEARCH_TEXTBOX, name, true);
        logReport("Entered custom data value " + name);
        clickByJavaScript(SEARCH_ICON);
        logReport("Search icon clicked successfully");
        VerifyPageReady(5);
        VerifyAjaxRequestsFinished(5);
    }

    public List<String> getCustomLocationListHeaders() {
        List<String> customHeadersList = new ArrayList<>();
        for (WebElement e : LIST_HEADERS_CUSTOM_LOCATION) {
            customHeadersList.add(e.getText().trim());
        }
        return customHeadersList;
    }

    public int getCustomNameLength(String name) throws Exception {
        searchCustomData(name);
        String xpath = "//tr[@ng-repeat='item in itemsByLocationGroupTrackWithLimit']//td[1][contains(text(),'" + name + "')]";
        WebElement element = browser.findElement(By.xpath(xpath));
        return element.getText().trim().length() + 1;
    }

    public void editCustomLocationData(String name, String designation) throws Exception {
        searchCustomData(name);
        String xpath = "//tr[@ng-repeat='item in itemsByLocationGroupTrackWithLimit']//td[1][text()='" + name + "']//following-sibling::td[text()='" + designation + "']/..//td[3]//a[@title='Edit']";
        WebElement element = browser.findElement(By.xpath(xpath));
        clickByJavaScript(element);
        logReport("Successfully edit on custom location data " + name);
    }

    public void deleteCustomLocationData(String name, String designation) throws Exception {
        searchCustomData(name);
        String xpath = "//tr[@ng-repeat='item in itemsByLocationGroupTrackWithLimit']//td[1][text()='" + name + "']//following-sibling::td[text()='" + designation + "']/..//td[3]//a[@title='Delete']";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 30);
        clickByJavaScript(element);
        logReport("Successfully delete on custom location data " + name);
    }

    public String getWarningMessage() throws Exception {
        Wait(DELETE_WARNING_MSG, 30);
        return DELETE_WARNING_MSG.getText().trim();
    }

    public boolean isMultibyteCharacterFoundForGroupLocationTrack(String value) throws Exception {
        searchCustomData(value);
        boolean found = false;
        String xpath = "//tr[@ng-repeat='item in itemsByLocationGroupTrackWithLimit']//td[1]";
        for (int i = 0; i < PAGINATION_LIST_GROUP_LOCATION_TRACK_PAGES.size(); i++) {
            clickByJavaScript(PAGINATION_LIST_GROUP_LOCATION_TRACK_PAGES.get(i));
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
