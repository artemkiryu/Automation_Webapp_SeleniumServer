package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pojo.CreateRegistrationData;
import pojo.FormPreviewRegistrantDetails;

import javax.naming.ConfigurationException;
import java.util.ArrayList;
import java.util.List;

public class EloquaHomePage extends CommonActionsPage {

    @FindBy(xpath = "//li[@id='navigation-list-item-audience']")
    public WebElement AUDIENCE_TAB;

    @FindBy(xpath = "//label[@title='Enter search term']//input")
    public WebElement SEARCH_TEXTBOX;

    @FindBy(xpath = "//div[@class='sc-view sc-collection-view sc-list-view']//div[contains(@class,'sc-view sc-table-row-view sc-collection-item')]")
    public List<WebElement> TABLE_ITEMS;

    public EloquaHomePage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void selectValueUnderAudienceDropdown(String value) throws Exception {
        Wait(AUDIENCE_TAB, 20);
        Actions action = new Actions(browser);
        action.moveToElement(AUDIENCE_TAB).build().perform();
        logReport("Audience tab clicked successfully");
        WebElement element = browser.findElement(By.xpath("//ul[@class='dropdown-menu normal']//li/a[text()='" + value + "']"));
        action.moveToElement(element).build().perform();
        click(element);
        logReport("Selected value under " + value + "audience tab");
        VerifyPageReady(30);
    }

    public void enterSearchValue(String regEmail) throws Exception {
        Wait(SEARCH_TEXTBOX, 20);
        type(SEARCH_TEXTBOX, regEmail, true);
        logReport("Entered search value " + regEmail);
        SEARCH_TEXTBOX.sendKeys(Keys.ENTER);
        VerifyPageReady(30);
    }

    public boolean getRegistrationDetails(FormPreviewRegistrantDetails formPreviewRegistrantDetails) {
        List<String> detailsList = new ArrayList<>();
        if (TABLE_ITEMS.size() > 0) {
            for (WebElement e : TABLE_ITEMS) {
                String email = e.findElement(By.xpath("./div[1]/label")).getText().trim();
                String firstName = e.findElement(By.xpath("./div[2]/label")).getText().trim();
                String lastName = e.findElement(By.xpath("./div[3]/label")).getText().trim();
                logReport("First name " + firstName + "last name " + lastName + "email value " + email);
                if (firstName.equalsIgnoreCase(formPreviewRegistrantDetails.getFirstName())
                        && lastName.equalsIgnoreCase(formPreviewRegistrantDetails.getLastName())
                        && email.equalsIgnoreCase(formPreviewRegistrantDetails.getEmail())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean getRegistrationDetails(CreateRegistrationData formPreviewRegistrantDetails) {
        List<String> detailsList = new ArrayList<>();
        if (TABLE_ITEMS.size() > 0) {
            for (WebElement e : TABLE_ITEMS) {
                String email = e.findElement(By.xpath("./div[1]/label")).getText().trim();
                String firstName = e.findElement(By.xpath("./div[2]/label")).getText().trim();
                String lastName = e.findElement(By.xpath("./div[3]/label")).getText().trim();
                logReport("First name " + firstName + "last name " + lastName + "email value " + email);
                if (firstName.equalsIgnoreCase(formPreviewRegistrantDetails.getContactInformation().getFirstName())
                        && lastName.equalsIgnoreCase(formPreviewRegistrantDetails.getContactInformation().getLastName())
                        && email.equalsIgnoreCase(formPreviewRegistrantDetails.getContactInformation().getEmail())) {
                    return true;
                }
            }
        }
        return false;
    }
}
