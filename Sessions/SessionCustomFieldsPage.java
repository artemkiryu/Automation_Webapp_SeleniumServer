package pageObjects.Sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pageObjects.CommonActionsPage;
import pojo.AddCustomFieldsData;

import javax.naming.ConfigurationException;
import java.util.ArrayList;
import java.util.List;

public class SessionCustomFieldsPage extends CommonActionsPage {

    //@FindBy(xpath = "//button[@x-ng-click='addCustomField()']")
    @FindBy(xpath = "//button[text()='Add Custom Field']")

    public WebElement ADD_CUSTOM_FIELD_BUTTON;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Sessions']")

    public WebElement SESSIONS_TAB;

    @FindBy(xpath = "//span[text()='Class : All']")

    public WebElement HEADER_CLASS;

    @FindBy(xpath = "//span[text()='Field Type(s) :']")

    public WebElement HEADER_FIELD_TYPES;

    @FindBy(xpath = "//span[text()='Used in session layout :']")

    public WebElement HEADER_USED_SESSION_LAYOUT;

    @FindBy(xpath = "//input[@placeholder='Custom Field Name, Code']")

    public WebElement CUSTOM_FIELD_SEARCH_BOX;

    @FindBy(xpath = "//button[@ng-click='filterSearchSession()']")

    public WebElement CUSTOM_FIELD_SEARCH_BUTTON;

    @FindBy(xpath = "//button[@ng-click='removeAllFilters()']")

    public WebElement SEARCH_CLEAR_ICON;

    @FindBy(xpath = "//div[contains(text(),'No Custom Fields')]")

    public WebElement EMPTY_CUSTOM_FIELDS_LIST;

    @FindBy(xpath = "//select[@ng-model='meta.limit']")

    public WebElement ITEMS_PERPAGE_DROPDOWN;

    @FindBy(xpath = "//button[@x-ng-click='cancel()']")

    public WebElement CUSTOM_FIELD_CANCEL_BUTTON;

    @FindBy(xpath = "//div[contains(text(),'No Custom Fields')]")

    public WebElement NO_CUSTOM_FIELDS_TEXT;




    public SessionCustomFieldsPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public AddNewCustomFields clickOnAddCustomField() throws Exception {
        VerifyPageReady(30);
        Wait(ADD_CUSTOM_FIELD_BUTTON, 20);
        clickByJavaScript(ADD_CUSTOM_FIELD_BUTTON);
        logReport("Successfully clicked on add custom fields button.");
        VerifyAngularHasFinishedProcessing(10);
        return new AddNewCustomFields(browser);
    }

    public SessionsListPage clickSessionsTab() throws Exception {
        Wait(SESSIONS_TAB, 20);
        clickByJavaScript(SESSIONS_TAB);
        logReport("Sessions tab clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyAjaxRequestsFinished(20);
        VerifyPageReady(20);
        return new SessionsListPage(browser);
    }

    public void clickOnFilter(String filterName) throws Exception {
        String xpath = "//span[text()='" + filterName + "']";
        click(browser.findElement(By.xpath(xpath)));
        wait(10);
        logReport("Filter : " + filterName + " is clicked successfully.");

    }

    public List<String> getFilterList(String filterName) {
        String xpath = "//span[text()='" + filterName + "']/../../..//ul//li[@class='sub-list']//ul//li//span";
        List<WebElement> filtersList = browser.findElements(By.xpath(xpath));
        List<String> filtersArray = new ArrayList<>();
        for (WebElement e : filtersList) {
            filtersArray.add(e.getText().trim());
        }
        // logReport("List of "+ filterName +" filter's value ------" + filtersArray);
        return filtersArray;
    }

    public void selectFilterOption(List<String> filtersList, String filterValue) throws Exception {
        for (int i = 0; i < filtersList.size(); i++) {
            logReport("List Value: " + filtersList.get(i).toString());
        }


        for (int i = 0; i < filtersList.size(); i++) {
            if (filtersList.get(i).toString().equalsIgnoreCase(filterValue)) {
                String xpath = "//span[text()='" + filterValue + " ']/..//input";
                WebElement element = browser.findElement(By.xpath(xpath));
                clickByJavaScript(element);
                VerifyPageReady(20);

            }
        }

    }

    public boolean isListOfFilterValue(String filterValue, int value) throws Exception {
        boolean found = false;
        String xpath = "//tr[@ng-repeat='customField in customFields']//td[" + value + "]";
        WebElement element = browser.findElement(By.xpath(xpath));
        String elementValue = element.getText().trim();
        logReport("Element value is : " + elementValue);
        // if (!elementValue.contains(filterValue)) {
        if (!elementValue.equalsIgnoreCase(filterValue)) {
            found = false;

        } else {
            found = true;
        }
        return found;
    }

    public void clickOnClearFilterIcon() throws Exception {

        click(SEARCH_CLEAR_ICON);
        logReport("Clear Icon is clicked successfully.");
        VerifyPageReady(30);

    }

    public void clickOnSearchButton() throws Exception {
        // Wait(CUSTOM_FIELD_SEARCH_BUTTON, 20);
        click(CUSTOM_FIELD_SEARCH_BUTTON);
        logReport("Search button is clicked successfully.");
        VerifyAngularHasFinishedProcessing(10);

    }

    public void enterCustomFieldNameCode(String code) throws Exception {
        type(CUSTOM_FIELD_SEARCH_BOX, code, true);
        logReport("Entered code value " + code + " in the search box");
    }

    public void searchUsingCode(String code) throws Exception {
        enterCustomFieldNameCode(code);
        clickOnSearchButton();
    }

    public boolean isItemPerPageDisplayed(String items) throws Exception {
        boolean found = false;
        String xpath = "//div[@class='col-sm-4 p0 ng-scope']//div//select";
        clickByJavaScript(ITEMS_PERPAGE_DROPDOWN);
        Select select = new Select(browser.findElement(By.xpath(xpath)));
        WebElement option = select.getFirstSelectedOption();
        String defaultItem = option.getText().trim();
        logReport("Default value : " + defaultItem);
        if (defaultItem.equalsIgnoreCase(items.trim())) {
            found = true;
        }
        return found;
    }

    public void clickOnCancelButton() throws Exception {

        Wait(CUSTOM_FIELD_CANCEL_BUTTON, 20);
        clickByJavaScript(CUSTOM_FIELD_CANCEL_BUTTON);
        logReport("Cancel button is clicked successfully.");
        VerifyAngularHasFinishedProcessing(10);
        VerifyAjaxRequestsFinished(20);
        VerifyPageReady(20);

    }

    public AddNewCustomFields searchAndClickOnEditCustomFieldByCode(String code) throws Exception {
        type(CUSTOM_FIELD_SEARCH_BOX, code, true);
        logReport("Entered code value " + code + " in the search box");
        Wait(CUSTOM_FIELD_SEARCH_BUTTON, 20);
        clickByJavaScript(CUSTOM_FIELD_SEARCH_BUTTON);
        logReport("Custom field search button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);

        String xpath = "//tr[@ng-repeat='customField in customFields']//td[2][text()='" + code + "']/..//following-sibling::td[@class='user-action']//i[1]";
        click(browser.findElement(By.xpath(xpath)));

        logReport("Custom field edit button clicked successfully");

        VerifyAngularHasFinishedProcessing(10);
        VerifyAjaxRequestsFinished(30);

        Thread.sleep(1000);

        return new AddNewCustomFields(browser);
    }

    public boolean isCustomFieldFound(AddCustomFieldsData addCustomFieldsData) throws Exception {
        searchUsingCode(addCustomFieldsData.getFieldCode());
        if (verifyElementDisplayed(NO_CUSTOM_FIELDS_TEXT, 0)) {
            return false;
        } /*else {
            String xpath = "//tr[@ng-repeat='customField in customFields']//td[2][text()='" + addCustomFieldsData.getFieldCode() + "']";
            return verifyElementDisplayed(By.xpath(xpath), 0);
        }*/
        return true;
    }

    public void addCustomFieldIntoSessionLayout(AddCustomFieldsData addCustomFieldsData) throws Exception {
        searchUsingCode(addCustomFieldsData.getFieldCode());
        String xpath = "//tr[@ng-repeat='customField in customFields']//td[2][text()='" + addCustomFieldsData.getFieldCode() + "']/..//following-sibling::td//i[@class='fa fa-plus-circle ml2 certain-green ng-scope']";
        if (verifyElementDisplayed(By.xpath(xpath), 2)) {
            click(browser.findElement(By.xpath(xpath)));
            logReport("Custom field added successfully into layout");
        }
    }
}
