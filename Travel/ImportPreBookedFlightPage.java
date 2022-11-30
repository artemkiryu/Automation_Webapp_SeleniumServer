package pageObjects.Travel;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

public class ImportPreBookedFlightPage extends CommonActionsPage {

    @FindBy(xpath = "//button[text()='Import']")
    public WebElement IMPORT_BTN;

    public ImportPreBookedFlightPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public ImportTravelPage clickImportButton() throws Exception {
        Thread.sleep(2000);
        Wait(IMPORT_BTN, 30);
        //webDriver.waitFor().waitForPageToLoad();
        click(IMPORT_BTN);
        VerifyAngularHasFinishedProcessing(30);
        reporter.info("Import button clicked successfully");
        return new ImportTravelPage(browser);
    }

}
