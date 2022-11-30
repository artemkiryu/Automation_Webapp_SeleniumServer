package pageObjects.EventRegistrations;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import java.util.List;

public class FinancialDiscountPage extends CommonActionsPage {

    @FindBy(xpath = "//span[@class='ng-binding']")
    public WebElement DISCOUNT_LABEL;

    @FindBy(xpath = "//label[text()='Choose a Discount']/..//span[@class='select2-arrow']")
    public WebElement DISCOUNT_DROPDOWN_ARROW;

    @FindBy(xpath = "//label[text()='Choose a Discount']/..//input")
    public WebElement DISCOUNT_TEXTBOX;

    @FindBy(xpath = "//ul[@id='select2-results-1']//li//div")
    public List<WebElement> DISCOUNT_ITEM_LIST;

    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement SUBMIT_BUTTON;

    //ul[@id='select2-results-2']//li//div

    public FinancialDiscountPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public boolean isDiscountText(String text) {
        String actualText = DISCOUNT_LABEL.getText().trim();
        return actualText.equalsIgnoreCase(text);
    }

    public void selectAgendaItem(String agendaItem) throws Exception {
        Wait(DISCOUNT_DROPDOWN_ARROW, 30);
        click(DISCOUNT_DROPDOWN_ARROW);
        for (WebElement e : DISCOUNT_ITEM_LIST) {
            if (e.getText().trim().contains(agendaItem)) {
                e.click();
                logReport("Selected agenda item " + agendaItem);
                return;
            }
        }

    }

    public void clickSubmitButton() throws Exception {
        click(SUBMIT_BUTTON);
        logReport("Submit button clicked successfully");
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(30);
    }

}
