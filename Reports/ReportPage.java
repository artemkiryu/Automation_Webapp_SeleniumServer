package pageObjects.Reports;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by infoobjects on 11/27/2015.
 */
public class ReportPage extends CommonReportsPage {
    @FindBy(xpath = "//select[@id='selectEventDataHeader']")
    public WebElement HEADER_DROPDOWN;
    @FindBy(xpath = "//input[@value='Add to Header']")
    public WebElement ADD_TO_HEADER_BUTTON;
    @FindBy(xpath = "//select[@id='selectEventDataFooter']")
    public WebElement FOOTER_DROPDOWN;
    @FindBy(xpath = "//input[@value='Add to Footer']")
    public WebElement ADD_TO_FOOTER_BUTTON;
    @FindBy(xpath = "//input[@value='Save']")
    public WebElement SAVE_BUTTON;

    public ReportPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void selectHeaderDropdown(String headerType) {
        select(HEADER_DROPDOWN, headerType);
        logReport("Selected header type value " + headerType);
    }

    public void selectFooterDropdown(String footerType) {
        select(FOOTER_DROPDOWN, footerType);
        logReport("Selected footer type value" + footerType);
    }

    public void clickAddHeaderButton() {
        click(ADD_TO_HEADER_BUTTON);
        logReport("Add to header button clicked successfully");
    }

    public void clickAddFooterButton() {
        click(ADD_TO_FOOTER_BUTTON);
        logReport("Add to footer button clicked successfully");
    }

    public void clickSaveButton() throws Exception {
        click(SAVE_BUTTON);
        logReport("Save button clicked successfully");
        VerifyPageReady(20);
    }
}
