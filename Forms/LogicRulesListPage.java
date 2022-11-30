package pageObjects.Forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;
import java.util.List;

/**
 * Created by infoobjects on 23-08-2017.
 */
public class LogicRulesListPage extends CommonActionsPage {

    @FindBy(xpath = "//div[@id='ListofLogicRulesId']//button[@id='create-link']")
    public static WebElement ADD_NEW_LOGIC_BUTTON;

    public LogicRulesListPage(WebDriver driver) throws ConfigurationException{
        PageFactory.initElements(driver, this);
    }

    public AddFormLogicPage clickOnAddNewLogic()throws Exception{
        Wait(ADD_NEW_LOGIC_BUTTON, 10);
        click(ADD_NEW_LOGIC_BUTTON);
        logReport("Add new logic button clicked successfully");
        VerifyAjaxRequestsFinished(20);
        VerifyPageReady(30);
        return new AddFormLogicPage(browser);
    }


}
