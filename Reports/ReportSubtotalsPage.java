package pageObjects.Reports;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


/**
 * Created by infoobjects on 11/24/2015.
 */
public class ReportSubtotalsPage extends CommonReportsPage {
    @FindBy(xpath = "//input[@id='showCountPerGroup']")
    public WebElement DISPLAY_RECORDS_CHECKBOX;
    @FindBy(xpath = "//input[@id='showTotalCount']")
    public WebElement DISPLAY_GRANDTOTAL_RECORDS_CHECKBOX;

    public ReportSubtotalsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void checkDisplayRecordsCheckbox() {
        check(DISPLAY_RECORDS_CHECKBOX);
        logReport("Display records checkbox checked successfully");
    }

    public void checkDisplayGrandTotalCheckbox() {
        check(DISPLAY_GRANDTOTAL_RECORDS_CHECKBOX);
        logReport("Display grand total records checkbox checked successfully");
    }

    public void checkColumnsCheckoxes(String columnName) {
        String xpath = "//td[text()='" + columnName + "']/following-sibling::td//input";
        List<WebElement> elements = browser.findElements(By.xpath(xpath));
        for (int i = 0; i < elements.size(); i++) {
            if (!elements.get(i).isSelected()) {
                elements.get(i).click();

            }
        }
    }

    public void clickSaveButton() throws Exception {
        click(SAVE_BUTTON);
        logReport("Save button clicked successfully");
        VerifyPageReady(20);
    }

}
