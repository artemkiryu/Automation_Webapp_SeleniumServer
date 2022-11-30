package pageObjects.Planning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 25-08-2017.
 */
public class BudgetPage extends CommonActionsPage {

    public BudgetPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public OverviewPage clickOnBudgetSaveButton() throws Exception {
        click(SAVE_BUTTON);
        logReport("Save button clicked successfully");
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
        return new OverviewPage(browser);
    }

}
