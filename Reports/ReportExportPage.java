package pageObjects.Reports;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by infoobjects on 11/27/2015.
 */
public class ReportExportPage extends CommonReportsPage {
    @FindBy(xpath = "//h3[contains(.,'Define Report Export Actions')]")
    public WebElement PAGE_HEADER;
    @FindBy(xpath = "//select[@id='rptMassActionExport1']")
    public WebElement MASS_ACTION_DROPDOWN1;
    @FindBy(xpath = "//select[@id='rptMassActionExport2']")
    public WebElement MASS_ACTION_DROPDOWN2;
    @FindBy(xpath = "//select[@id='rptMassActionExport3']")
    public WebElement MASS_ACTION_DROPDOWN3;
    @FindBy(xpath = "//input[@value='Save']")
    public WebElement SAVE_BUTTON;

    public ReportExportPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void clickSaveButton() throws Exception {
        click(SAVE_BUTTON);
        logReport("Save button clicked successfully");
        VerifyPageReady(20);
    }

    public void selectMassActionFirstDropdownValue(String massActionType) {
        select(MASS_ACTION_DROPDOWN1, massActionType);
        logReport("Selected mass action dropdown 1 value" + massActionType);
    }

    public void selectMassActionSecondDropdownValue(String massActionType) {
        select(MASS_ACTION_DROPDOWN2, massActionType);
        logReport("Selected mass action dropdown 2 value" + massActionType);
    }

    public void selectMassActionThirdDropdownValue(String massActionType) {
        select(MASS_ACTION_DROPDOWN3, massActionType);
        logReport("Selected mass action dropdown 3 value" + massActionType);
    }
}
