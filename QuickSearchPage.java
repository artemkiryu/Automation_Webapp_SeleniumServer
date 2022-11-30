package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.naming.ConfigurationException;
import java.util.List;

public class QuickSearchPage extends CommonActionsPage {

    @FindBy(xpath = "//select[@name='searchIn']")
    public WebElement SEARCH_IN_DROPDOWN;
    @FindBy(xpath = "//select[@name='searchBy']")
    public WebElement SEARCH_BY_DROPDOWN;
    @FindBy(xpath = "//input[@name='searchFor']")
    public WebElement SEARCH_FOR_TEXTBOX;
    @FindBy(xpath = "//input[@id='submitForm']")
    public WebElement SEARCH_BUTTON;
    @FindBy(xpath = "//input[@id='closeModal']")
    public WebElement CLOSE_BUTTON;
    @FindBy(xpath = "//iframe[@id='certainModaliFrame']")
    public WebElement IFRAME_LINK;
    @FindBy(xpath = "//span[@class='strong']")
    public WebElement SEARCH_RECORDS_TEXT;

    public QuickSearchPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void selectSearchInValue(String value) throws Exception {
        Wait(SEARCH_IN_DROPDOWN, 10);
        select(SEARCH_IN_DROPDOWN, value);
        logReport("Selected search in value " + value);
    }

    public void selectSearchByValue(String value) {
        select(SEARCH_BY_DROPDOWN, value);
        logReport("Selected search by value " + value);
    }

    public void enterSearchForValue(String value) {
        type(SEARCH_FOR_TEXTBOX, value);
        logReport("Entered search for value " + value);
    }

    public void clickSearchButton() {
        click(SEARCH_BUTTON);
        logReport("Search button clicked successfully");
    }

    public void selectSearchedRowByRegCode(String regCode) {
        String xpath = "//table//tr//td[@class='tableContent'][2]";
        List<WebElement> elements = browser.findElements(By.xpath(xpath));
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().trim().equalsIgnoreCase(regCode)) {
                clickByJavaScript(elements.get(i));
                logReport("Selected searched row by reg code " + regCode);
                return;
            }
        }
    }

    public void selectSearchedRowByProfileUniqueId(String profileUniqueId) {
        //String xpath = "//table//tr[@title='Edit record']//td[contains(.,'" + firstName + "')]";
        String xpath = "//table//tr[@title='Edit record']//td[1]";
        List<WebElement> elements = browser.findElements(By.xpath(xpath));
        for (int i = 0; i < elements.size(); i++) {
            // if (elements.get(i).getText().trim().equalsIgnoreCase(firstName)) {
            clickByJavaScript(elements.get(i));
            logReport("Selected searched row by first " + profileUniqueId);
            return;
            //}
        }
    }

    public void clickCloseButton() {
        click(CLOSE_BUTTON);
        logReport("Close button clicked successfully");

    }

    public boolean isSearchRecordsEmpty() {
        boolean found = false;
        String records = SEARCH_RECORDS_TEXT.getText().trim();
        if (records.equalsIgnoreCase("Records 0 to 0 of 0 are shown")) {
            found = true;
            logReport("Searched record is not found.");
        } else {
            logReport("Searched record is found.");
        }
        return found;
    }

}
