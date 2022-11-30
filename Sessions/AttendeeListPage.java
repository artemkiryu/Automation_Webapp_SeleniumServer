package pageObjects.Sessions;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class AttendeeListPage extends CommonActionsPage {

    @FindBy(xpath = "//p[text()='Attendees List']")

    public WebElement HEADERS_NAME;
    @FindBy(xpath = "//label[@for='track']")

    public WebElement DATETIME_LOCATION_LABEL;
    @FindBy(xpath = "//div[@id='mainDiv']//table//thead//th")
    public List<WebElement> HEADER_LIST;
    @FindBy(xpath = "//input[@x-ng-model='searchCriteria.value']")

    public WebElement SEARCH_TEXTBOX;
    @FindBy(xpath = "//button[@ng-click='searchWithLimits()']")

    public WebElement SEARCH_ICON;
    @FindBy(xpath = "//span[text()='CLOSE']")

    public WebElement CLOSE_BUTTON;
    @FindBy(xpath = "//button[text()='Cancel']")

    public WebElement CANCEL_BUTTON;

    public AttendeeListPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public String getDateTimeLocationText() {
        logReport("Date time value " + DATETIME_LOCATION_LABEL.getText().trim());
        return DATETIME_LOCATION_LABEL.getText().trim();
    }

    public List<String> getHeadersList() {
        List<String> headersArray = new ArrayList<>();
        for (WebElement e : HEADER_LIST) {
            headersArray.add(e.getText().trim());
        }
        logReport("List of headers ------" + headersArray);
        return headersArray;
    }

    public void enterSearchValue(String searchField) throws Exception {
        Wait(SEARCH_TEXTBOX, 30);
        type(SEARCH_TEXTBOX, searchField, true);
        logReport("Entered value in search textbox " + searchField);
    }

    public void clickSearchIcon() throws Exception {
        Wait(SEARCH_ICON, 20);
        click(SEARCH_ICON);
        logReport("Search icon clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
    }

    public boolean isColumnValueExist(String columnName, String value) throws Exception {
        int i = getColumnIndex(HEADER_LIST, columnName);
        boolean found = false;
        String xpath = "//div[@id='mainDiv']//table//tbody//tr//td[" + i + "]";
        List<WebElement> elements = browser.findElements(By.xpath(xpath));
        for (WebElement e : elements) {
            if (e.getText().trim().equalsIgnoreCase(value)) {
                found = true;
                break;
            } else
                found = false;
        }
        return found;
    }

    public List<String> getValuesByColumn(String columnName) throws Exception {
        int i = getColumnIndex(HEADER_LIST, columnName);
        String xpath = "//div[@id='mainDiv']//table//tbody//tr//td[" + i + "]";
        List<WebElement> elements = browser.findElements(By.xpath(xpath));
        List<String> values = new ArrayList<>();
        for (WebElement e : elements) {
            values.add(e.getText().trim());
        }
        return values;
    }

    public boolean isSortedInAscendingOrder(List<String> actual) {
        List<String> actualList = actual;
        Collections.sort(actual);
        return actualList.equals(actual);
    }

    public boolean isSortedInDescendingOrder(List<String> actual) {
        logReport("Actual list " + actual);
        List<String> actualList = actual;
        Collections.sort(actual, Collections.reverseOrder());
        return actualList.equals(actual);
    }

    public void clickColumnInAscendingOrDescending(String order, String column) {
        List<WebElement> columnHeader = HEADER_LIST;
        for (int i = 0; i < columnHeader.size(); i++) {
            if (columnHeader.get(i).getText().trim().equals(column)) {
                WebElement element = columnHeader.get(i).findElement(By.xpath("./span"));
                element.click();
                if (!element.getAttribute("class").contains(order)) {
                    element.click();
                    return;
                }
            }
        }
    }

    public void clickCloseButton() throws Exception {
        Wait(CLOSE_BUTTON, 20);
        click(CLOSE_BUTTON);
        logReport("Close button clicked successfully");
    }

    public void clickRowByNameAndColumn(String column, String value) {
        int i = getColumnIndex(HEADER_LIST, column);
        String xpath = "//div[@id='mainDiv']//table//tbody//tr//td[" + i + "]";
        List<WebElement> elements = browser.findElements(By.xpath(xpath));
        for (WebElement e : elements) {
            if (e.getText().trim().equalsIgnoreCase(value)) {
                e.click();
                VerifyAngularHasFinishedProcessing(10);
                return;
            }
        }
    }
}
