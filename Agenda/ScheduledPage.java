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
 * Created by infoobjects on 02-08-2017.
 */
public class ScheduledPage extends CommonActionsPage {
    public static final List<String> customHeaders = new ArrayList<>(Arrays.asList("Type Name", "Used by # of Items", "Actions"));

    public static final List<String> customLocationHeaders = new ArrayList<>(Arrays.asList("Name", "Designation", "Actions"));

    public static final List<String> customAgendaHeaders = new ArrayList<>(Arrays.asList("Item Name", "Type", "Start Date & Time", "Cap", "Reg", "Avail", "Wait", "Actions"));

    public static final List<String> sectionsList = new ArrayList<>(Arrays.asList("Item List", "Custom Scheduled Types", "Groups, Locations & Tracks"));

    @FindBy(xpath = "//h4[text()='Item List']/../..//button[@ng-click='addAgendaItem()']")
    public WebElement ADD_NEW_AGENDA_ITEM_BUTTON;
    @FindBy(xpath = "//h4[text()='Custom Scheduled Types']/../..//button[text()='Add New']")
    public WebElement ADD_NEW_SCHEDULED_TYPE_BUTTON;
    @FindBy(xpath = "//button[@ng-click='addNewScheduledManagementItem()']")
    public WebElement ADD_NEW_GROUP_LOCATION_BUTTON;
    @FindBy(xpath = "//input[@ng-model='newTypeObject.name']")
    public WebElement NAME_TEXTBOX;
    @FindBy(xpath = "//input[@ng-model='searchForGroupTrackLocationModel.search']")
    public WebElement SEARCH_TEXTBOX;
    @FindBy(xpath = "//input[@ng-model='searchForGroupTrackLocationModel.search']/../span")
    public WebElement SEARCH_ICON;
    @FindBy(xpath = "//button[text()='Save']")
    public WebElement SAVE_BUTTON;
    @FindBy(xpath = "//button[@class='btn btn-primary ng-binding']")
    public WebElement SAVE_BUTTON1;
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement CANCEL_BUTTON;
    @FindBy(xpath = "//input[@value='Group']")
    public WebElement GROUP_RADIOBUTTON;
    @FindBy(xpath = "//input[@value='Track']")
    public WebElement TRACK_RADIOBUTTON;
    @FindBy(xpath = "//input[@value='Location']")
    public WebElement LOCATION_RADIOBUTTON;
    //@FindBy(xpath = "//span[text()='Items Per Page']")
    @FindBy(xpath = "//div[@class='col-sm-7 pt5']//label[@class='ng-binding']")
    public WebElement PER_ITEMS_PAGE_LABEL;
    @FindBy(xpath = "//ul[@ng-model='pagination.groupingPageNo']")
    public WebElement PAGINATION_LIST;
    @FindBy(xpath = "//ul[@ng-model='pagination.customPageNo']")
    public WebElement PAGINATION_LIST_CUSTOM;
    @FindBy(xpath = "//ul[@ng-model='pagination.customPageNo']//li//a[text()='Next']")
    public WebElement PAGINATION_LIST_CUSTOM_NEXT;
    @FindBy(xpath = "//ul[@ng-model='pagination.customPageNo']//li//a[text()='First']")
    public WebElement PAGINATION_LIST_CUSTOM_FIRST;
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
    @FindBy(xpath = "//tr[@ng-repeat='item in customScheduledItemsWithLimit']//td[3]//a[@title='Edit']")
    public WebElement EDIT_ICON_CUSTOM_TYPE;
    @FindBy(xpath = "//tr[@ng-repeat='item in customScheduledItemsWithLimit']//td[3]//a[@title='Delete']")
    public WebElement DELETE_ICON_CUSTOM_TYPE;
    @FindBy(xpath = "//tr[@ng-repeat='item in customScheduledItemsWithLimit']//td[3]//a[@title='Copy']")
    public WebElement COPY_ICON_CUSTOM_TYPE;
    @FindBy(xpath = "//div[@ng-if='showCustomScheduledType']//table//tr//th")
    public List<WebElement> LIST_HEADERS_CUSTOM_TYPE;

    @FindBy(xpath = "//div[@ng-if='showItemList']//tbody//tr//th")
    public List<WebElement> LIST_HEADERS_AGENDA_ITEMS;

    @FindBy(xpath = "//div[@ng-if='showScheduledManagementItem']//tbody//tr//th")
    public List<WebElement> LIST_HEADERS_CUSTOM_LOCATION;

    @FindBy(xpath = "//ul[@ng-model='pagination.customPageNo']//li[@ng-repeat='page in pages track by $index']/a")
    public List<WebElement> PAGINATION_LIST_CUSTOM_PAGES;

    @FindBy(xpath = "//ul[@ng-model='pagination.groupingPageNo']//li[@ng-repeat='page in pages track by $index']//a")
    public List<WebElement> PAGINATION_LIST_LOCATIONS_PAGES;

    @FindBy(xpath = "//ul[@ng-model='pagination.listPageNo']//li[@ng-repeat='page in pages track by $index']//a")
    public List<WebElement> PAGINATION_LIST_AGENDA_LIST_PAGES;

    @FindBy(xpath = "//select[@ng-model='typeForLocationGroupTrackModel.value']")
    public WebElement FILTER_DROPDOWN_CUSTOM;

    @FindBy(xpath = "//input[@ng-model='searchForScheduledItemList.search']")
    public WebElement SEARCH_TEXTBOX_AGENDALIST;
    @FindBy(xpath = "//input[@ng-model='searchForScheduledItemList.search']/../span")
    public WebElement SEARCH_ICON_AGENDALIST;

    @FindBy(xpath = "//select[@ng-model='typeForScheduledItemList.value']")
    public WebElement FILTERBY_DROPDOWN_AGENDALIST;

    @FindBy(xpath = "//div[@class='container ng-scope']//h4[@class='boldFont ng-binding']")
    public List<WebElement> LIST_OF_SECTIONS;

    @FindBy(xpath = "//button[@class='pull-right'][contains(@ng-click,'list')]")
    public WebElement LIST_ICON_RIGHT;

    @FindBy(xpath = "//button[@class='pull-right'][contains(@ng-click,'calendar')]")
    public WebElement CALENDAR_ICON_RIGHT;

    public ScheduledPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void editCustomLocationData(String name, String designation) throws Exception {
        searchCustomData(name);
        String xpath = "//tr[@ng-repeat='item in itemsByLocationGroupTrackWithLimit']//td[1][text()='" + name + "']//following-sibling::td[text()='" + designation + "']/..//td[3]//a[@title='Edit']";
        WebElement element = browser.findElement(By.xpath(xpath));
        element.click();
        logReport("Successfully edit on custom location data " + name);
        VerifyAngularHasFinishedProcessing(10);
    }

    public void deleteCustomLocationData(String name, String designation) throws Exception {
        searchCustomData(name);
        String xpath = "//tr[@ng-repeat='item in itemsByLocationGroupTrackWithLimit']//td[1][text()='" + name + "']//following-sibling::td[text()='" + designation + "']/..//td[3]//i[@aria-label='Delete']";
        WebElement element = browser.findElement(By.xpath(xpath));
        clickByJavaScript(element);
        logReport("Successfully delete on custom location data " + name);
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
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

    public AddAgendaPage clickEditAgendaButton() throws Exception {
        String xpath = "//table//tbody//tr[@ng-repeat='item in agendaItems'][1]//td//a[@title='Edit']";
        WebElement element = browser.findElement(By.xpath(xpath));
        VerifyPageReady(10);
        Wait(element, 30);
        click(element);
        logReport("Successfully clicked on 'Edit Agenda Item' button.");
        VerifyAngularHasFinishedProcessing(5);
        VerifyPageReady(5);
        return new AddAgendaPage(browser);
    }

    public void clickAddNewGroupLocationButton() throws Exception {
        VerifyPageReady(10);
        Wait(ADD_NEW_GROUP_LOCATION_BUTTON, 30);
        clickByJavaScript(ADD_NEW_GROUP_LOCATION_BUTTON);
        logReport("Successfully clicked on 'Add New Agenda Group Location Track' button.");
        VerifyAngularHasFinishedProcessing(2);
        VerifyPageReady(2);
    }

    public void clickAddNewCustomTypeButton() throws Exception {
        VerifyPageReady(10);
        Wait(ADD_NEW_SCHEDULED_TYPE_BUTTON, 30);
        clickByJavaScript(ADD_NEW_SCHEDULED_TYPE_BUTTON);
        logReport("Successfully clicked on 'Add New Custom Scheduled Type' button.");
        VerifyAngularHasFinishedProcessing(2);
        VerifyPageReady(2);
    }

    public void enterNameValue(String name) throws Exception {
        Wait(NAME_TEXTBOX, 20);
        type(NAME_TEXTBOX, name, true);
        logReport("Entered name value " + name);
    }

    public void clickSaveButton() throws Exception {
        Wait(SAVE_BUTTON, 30);
        clickByJavaScript(SAVE_BUTTON);
        logReport("Save button clicked successfully");
        VerifyAngularHasFinishedProcessing(3);
        VerifyAjaxRequestsFinished(3);
        VerifyPageReady(3);
    }

    public void clickSaveButtonWithoutAngular() throws Exception {
        Wait(SAVE_BUTTON, 30);
        clickByJavaScript(SAVE_BUTTON);
        logReport("Save button clicked successfully");

    }
    public void clickCancelButton() throws Exception {
        click(CANCEL_BUTTON);
        logReport("Cancel button clicked successfully");
        VerifyAngularHasFinishedProcessing(3);
        VerifyPageReady(3);
    }

    public void selectDesignationType(String value) {
        WebElement element = browser.findElement(By.xpath("//input[@type='radio'][@value='" + value + "']"));
        clickByJavaScript(element);
        logReport("Selected Designation type " + value);
    }

    public void fillCustomLocationData(String name, String designation) throws Exception {
        enterNameValue(name);
        selectDesignationType(designation);
        clickSaveButton();
    }

    public boolean isCustomLocationNameAndDesignationFound(String name, String type) throws Exception {
        searchCustomData(name);
        String xpath = "//tr[@ng-repeat='item in itemsByLocationGroupTrackWithLimit']//td[1][text()='" + name + "']//following-sibling::td[text()='" + type + "']";
        return VerifyElementPresent((By.xpath(xpath)), 2);

    }
   /* public boolean isCustomLocationNameAndDesignationFound(String name, String type) throws Exception {
        boolean found = false;
        String xpath = "//tr[@ng-repeat='item in itemsByLocationGroupTrackWithLimit']//td[1][text()='" + name + "']//following-sibling::td[text()='" + type + "']";
        if (VerifyElementPresent(By.xpath(xpath), 2)) {
            found = true;
        }

        *//*try{
            searchCustomData(name);
            String xpath = "//tr[@ng-repeat='item in itemsByLocationGroupTrackWithLimit']//td[1][text()='" + name + "']//following-sibling::td[text()='" + type + "']";
            return verifyElementDisplayed(browser.findElement(By.xpath(xpath)), 2);
        }catch ()*//*

        return found;
    }
*/

    public int getCustomNameLength(String name) throws Exception {
        searchCustomData(name);
        String xpath = "//tr[@ng-repeat='item in itemsByLocationGroupTrackWithLimit']//td[1][contains(text(),'" + name + "')]";
        WebElement element = browser.findElement(By.xpath(xpath));
        logReport("element length " + element.getText().trim().length());
        //return element.getText().trim().length() + 1;
        return element.getText().trim().length();
    }

    public void searchCustomData(String name) throws Exception {
        type(SEARCH_TEXTBOX, name, true);
        logReport("Entered custom data value " + name);
        clickByJavaScript(SEARCH_ICON);
        logReport("Search icon clicked successfully");
        VerifyPageReady(5);
        VerifyAjaxRequestsFinished(5);
    }

    public void clickYesButton() throws Exception {
        Wait(YES_POPUP_BUTTON, 10);
        click(YES_POPUP_BUTTON);
        logReport("Yes popup button clicked successfully");
        VerifyPageReady(5);
        VerifyAngularHasFinishedProcessing(5);
    }

    public void clickCancelPopupButton() throws Exception {
        Wait(CANCEL_POPUP_BUTTON, 10);
        click(CANCEL_POPUP_BUTTON);
        logReport("Cancel popup button clicked successfully");
        VerifyPageReady(5);
    }

    public String getWarningMessage() {
        return DELETE_WARNING_MSG.getText().trim();
    }

    public boolean isCustomScheduledTypeFound(String type) throws Exception {
        boolean found = false;
        String xpath = "//tr[@ng-repeat='item in customScheduledItemsWithLimit']//td[1][text()='" + type + "']";
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
        String xpath = "//tr[@ng-repeat='item in customScheduledItemsWithLimit']//td[1]";
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
        String xpath = "//tr[@ng-repeat='item in customScheduledItemsWithLimit']//td[1]";
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

    public void deleteMultibyteCharacter(String value) throws Exception {
        String xpath = "//tr[@ng-repeat='item in customScheduledItemsWithLimit']//td[1]";
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
    public List<String> getCustomHeadersType() {
        List<String> customHeadersList = new ArrayList<>();
        for (WebElement e : LIST_HEADERS_CUSTOM_TYPE) {
            customHeadersList.add(e.getText().trim());
        }
        return customHeadersList;
    }

    public void clickNextButton() throws Exception {
        clickByJavaScript(PAGINATION_LIST_CUSTOM_NEXT);
        log("Next button clicked successfully");
        VerifyPageReady(10);
    }

    public void clickFirstButton() throws Exception {
        clickByJavaScript(PAGINATION_LIST_CUSTOM_FIRST);
        log("First button clicked successfully");
        VerifyPageReady(10);
    }

    public void editCustomTypeField(String type) throws Exception {
        String xpath = "//tr[@ng-repeat='item in customScheduledItemsWithLimit']//td[1][text()='" + type + "']/..//td/a[@title='Edit']";
        if (VerifyElementPresent(By.xpath(xpath), 2)) {
            clickByJavaScript(browser.findElement(By.xpath(xpath)));
            VerifyPageReady(10);
        } else {
            for (int i = 0; i < PAGINATION_LIST_CUSTOM_PAGES.size(); i++) {
                clickByJavaScript(PAGINATION_LIST_CUSTOM_PAGES.get(i));
                VerifyAngularHasFinishedProcessing(10);
                if (VerifyElementPresent(By.xpath(xpath), 2)) {
                    clickByJavaScript(browser.findElement(By.xpath(xpath)));
                    VerifyPageReady(10);
                    return;
                }
            }
        }
    }

    public void deleteCustomTypeField(String type) throws Exception {
        String xpath = "//tr[@ng-repeat='item in customScheduledItemsWithLimit']//td[1][text()='" + type + "']/..//td/a[@title='Delete']";
        if (VerifyElementPresent(By.xpath(xpath), 2)) {
            clickByJavaScript(browser.findElement(By.xpath(xpath)));
            VerifyPageReady(10);
        } else {
            for (int i = 0; i < PAGINATION_LIST_CUSTOM_PAGES.size(); i++) {
                clickByJavaScript(PAGINATION_LIST_CUSTOM_PAGES.get(i));
                VerifyAngularHasFinishedProcessing(10);
                if (VerifyElementPresent(By.xpath(xpath), 2)) {
                    clickByJavaScript(browser.findElement(By.xpath(xpath)));
                    VerifyPageReady(10);
                    return;
                }
            }
        }
    }

    public void deleteAllCustomFields() throws Exception {
        String list = "//ul[@ng-model='pagination.customPageNo']//li[@ng-repeat='page in pages track by $index']/a";
        List<WebElement> paginationList = browser.findElements(By.xpath(list));
        String xpath = "//tr[@ng-repeat='item in customScheduledItemsWithLimit']//td[3]//a[@title='Delete']";
        List<WebElement> elements = browser.findElements(By.xpath(xpath));
        while (true) {
            clickByJavaScript(elements.get(0));
            clickByJavaScript(YES_POPUP_BUTTON);
            log("Element deleted successfully ");
            VerifyAngularHasFinishedProcessing(10);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            elements = browser.findElements(By.xpath(xpath));
            if (elements.size() <= 0)
                break;
        }


    }

    public void copyCustomTypeField(String type) throws Exception {
        String xpath = "//tr[@ng-repeat='item in customScheduledItemsWithLimit']//td[1][text()='" + type + "']/..//td/a[@title='Copy']";
        if (VerifyElementPresent(By.xpath(xpath), 2)) {
            clickByJavaScript(browser.findElement(By.xpath(xpath)));
            VerifyPageReady(10);
        } else {
            for (int i = 0; i < PAGINATION_LIST_CUSTOM_PAGES.size(); i++) {
                clickByJavaScript(PAGINATION_LIST_CUSTOM_PAGES.get(i));
                VerifyAngularHasFinishedProcessing(10);
                if (VerifyElementPresent(By.xpath(xpath), 2)) {
                    clickByJavaScript(browser.findElement(By.xpath(xpath)));
                    VerifyPageReady(10);
                    return;
                }
            }
        }

    }

    public String getCustomTypeName() {
        return NAME_TEXTBOX.getAttribute("value").trim();
    }

    public List<String> getDesignationList() {
        List<String> typesArray = new ArrayList<>();
        String xpath = "//tr[@ng-repeat='item in itemsByLocationGroupTrackWithLimit']//td[2]";
        if (PAGINATION_LIST_LOCATIONS_PAGES.size() > 0) {
            for (int i = 0; i < PAGINATION_LIST_LOCATIONS_PAGES.size(); i++) {
                clickByJavaScript(PAGINATION_LIST_LOCATIONS_PAGES.get(i));
                VerifyAngularHasFinishedProcessing(10);
                List<WebElement> elements = browser.findElements(By.xpath(xpath));
                for (WebElement e : elements) {
                    typesArray.add(e.getText().trim());
                }
            }
        } else {
            List<WebElement> elements = browser.findElements(By.xpath(xpath));
            for (WebElement e : elements) {
                typesArray.add(e.getText().trim());
            }

        }
        return typesArray;
    }

    public List<String> getCustomLocationNamesList() {
        List<String> typesArray = new ArrayList<>();
        String xpath = "//tr[@ng-repeat='item in itemsByLocationGroupTrackWithLimit']//td[1]";
        if (PAGINATION_LIST_LOCATIONS_PAGES.size() > 0) {
            for (int i = 0; i < PAGINATION_LIST_LOCATIONS_PAGES.size(); i++) {
                clickByJavaScript(PAGINATION_LIST_LOCATIONS_PAGES.get(i));
                VerifyAngularHasFinishedProcessing(10);
                List<WebElement> elements = browser.findElements(By.xpath(xpath));
                for (WebElement e : elements) {
                    typesArray.add(e.getText().trim());
                }
            }
        } else {
            List<WebElement> elements = browser.findElements(By.xpath(xpath));
            for (WebElement e : elements) {
                typesArray.add(e.getText().trim());
            }

        }
        logReport("---List of Names types " + typesArray);
        return typesArray;
    }


    public void selectCustomFilterValue(String value) throws Exception {
        select(FILTER_DROPDOWN_CUSTOM, value);
        logReport("Selected custom filter value " + value);
        VerifyPageReady(5);
    }

    public boolean isValueFiltered(List<String> actual, String value) {
        int count = 0;
        if (actual.size() > 0) {
            for (int j = 0; j < actual.size(); j++) {
                if (actual.get(j).equalsIgnoreCase(value)) {
                    count = count + 1;
                }
            }
        } else {
            return false;
        }
        return count == actual.size();
    }

    public void clearSearchTextBox() {
        SEARCH_TEXTBOX.clear();
    }

    public List<String> getCombineNamesDesignationList() {
        List<String> typesArray = new ArrayList<>();
        String xpath = "//tr[@ng-repeat='item in itemsByLocationGroupTrackWithLimit']//td[1]";
        if (PAGINATION_LIST_LOCATIONS_PAGES.size() > 0) {
            for (int i = 0; i < PAGINATION_LIST_LOCATIONS_PAGES.size(); i++) {
                clickByJavaScript(PAGINATION_LIST_LOCATIONS_PAGES.get(i));
                VerifyAngularHasFinishedProcessing(10);
                List<WebElement> elements = browser.findElements(By.xpath(xpath));
                for (WebElement e : elements) {
                    String name = e.getText().trim();
                    WebElement element = e.findElement(By.xpath("../td[2]"));
                    String designation = element.getText().trim();
                    typesArray.add(name + "," + designation);
                }

            }
        } else {
            List<WebElement> elements = browser.findElements(By.xpath(xpath));
            for (WebElement e : elements) {
                String name = e.getText().trim();
                WebElement element = e.findElement(By.xpath("../td[2]"));
                String designation = element.getText().trim();
                typesArray.add(name + "," + designation);
            }

        }
        logReport("---List of Names And Designation types " + typesArray);
        return typesArray;
    }

    public void searchCustomAgendaList(String name) throws Exception {
        type(SEARCH_TEXTBOX_AGENDALIST, name, true);
        logReport("Entered custom data value " + name);
        clickByJavaScript(SEARCH_ICON_AGENDALIST);
        logReport("Search icon clicked successfully");
        VerifyPageReady(5);
        VerifyAjaxRequestsFinished(5);
    }

    public void selectAgendaListFilterValue(String type) throws Exception {
        Wait(FILTERBY_DROPDOWN_AGENDALIST, 20);
        select(FILTERBY_DROPDOWN_AGENDALIST, type);
        logReport("Selected agenda list dropdown list value " + type);
        VerifyAjaxRequestsFinished(20);
    }

    public List<String> getAgendaListNames() {
        List<String> typesArray = new ArrayList<>();
        String xpath = "//tr[@ng-repeat='item in agendaItems']//td[1]";
        if (PAGINATION_LIST_AGENDA_LIST_PAGES.size() > 0) {
            for (int i = 0; i < PAGINATION_LIST_AGENDA_LIST_PAGES.size(); i++) {
                clickByJavaScript(PAGINATION_LIST_AGENDA_LIST_PAGES.get(i));
                VerifyAngularHasFinishedProcessing(10);
                List<WebElement> elements = browser.findElements(By.xpath(xpath));
                for (WebElement e : elements) {
                    typesArray.add(e.getText().trim());
                }
            }
        } else {
            List<WebElement> elements = browser.findElements(By.xpath(xpath));
            for (WebElement e : elements) {
                typesArray.add(e.getText().trim());
            }

        }
        logReport("---List of Names types " + typesArray);
        return typesArray;
    }

    public List<String> getAgendaListTypes() {
        List<String> typesArray = new ArrayList<>();
        String xpath = "//tr[@ng-repeat='item in agendaItems']//td[2]";
        if (PAGINATION_LIST_AGENDA_LIST_PAGES.size() > 0) {
            for (int i = 0; i < PAGINATION_LIST_AGENDA_LIST_PAGES.size(); i++) {
                clickByJavaScript(PAGINATION_LIST_AGENDA_LIST_PAGES.get(i));
                VerifyAngularHasFinishedProcessing(10);
                List<WebElement> elements = browser.findElements(By.xpath(xpath));
                for (WebElement e : elements) {
                    typesArray.add(e.getText().trim());
                }
            }
        } else {
            List<WebElement> elements = browser.findElements(By.xpath(xpath));
            for (WebElement e : elements) {
                typesArray.add(e.getText().trim());
            }

        }
        logReport("---List of Names types " + typesArray);
        return typesArray;
    }

    public List<String> getAgendaListNamesWithTypes() {
        List<String> typesArray = new ArrayList<>();
        String xpath = "//tr[@ng-repeat='item in agendaItems']//td[1]";
        if (PAGINATION_LIST_AGENDA_LIST_PAGES.size() > 0) {
            for (int i = 0; i < PAGINATION_LIST_AGENDA_LIST_PAGES.size(); i++) {
                clickByJavaScript(PAGINATION_LIST_AGENDA_LIST_PAGES.get(i));
                VerifyAngularHasFinishedProcessing(10);
                List<WebElement> elements = browser.findElements(By.xpath(xpath));
                for (WebElement e : elements) {
                    String name = e.getText().trim();
                    WebElement element = e.findElement(By.xpath("../td[2]"));
                    String type = element.getText().trim();
                    typesArray.add(name + "," + type);

                }
            }
        } else {
            List<WebElement> elements = browser.findElements(By.xpath(xpath));
            for (WebElement e : elements) {
                String name = e.getText().trim();
                WebElement element = e.findElement(By.xpath("../td[2]"));
                String type = element.getText().trim();
                typesArray.add(name + "," + type);

            }

        }
        logReport("---List of Names types " + typesArray);
        return typesArray;
    }

    public List<String> getSectionsList() {
        List<String> a = new ArrayList<>();
        for (WebElement e : LIST_OF_SECTIONS) {
            a.add(e.getText().trim());
        }
        return a;
    }

    public List<String> getAgendaListHeaders() {
        List<String> customHeadersList = new ArrayList<>();
        for (WebElement e : LIST_HEADERS_AGENDA_ITEMS) {
            customHeadersList.add(e.getText().trim());
        }
        return customHeadersList;
    }

    public List<String> getCustomLocationListHeaders() {
        List<String> customHeadersList = new ArrayList<>();
        for (WebElement e : LIST_HEADERS_CUSTOM_LOCATION) {
            customHeadersList.add(e.getText().trim());
        }
        return customHeadersList;
    }

    public void clearFilters() throws Exception {
        VerifyPageReady(10);
        SEARCH_TEXTBOX.clear();

    }
}
