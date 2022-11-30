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
public class SessionsListPage extends CommonActionsPage{

    @FindBy(xpath = "//div[@id='ListofSessionSectionsId']//button[contains(text(),'Add New')]")
    public WebElement ADD_NEW_SESSIONS_SECTION_BUTTON;


    public SessionsListPage(WebDriver driver)throws ConfigurationException {
        PageFactory.initElements(driver,this);
    }

    public AddSessionsSectionPage clickAddNewSessionsSection() throws Exception {
        click(ADD_NEW_SESSIONS_SECTION_BUTTON);
        VerifyPageReady(30);
        return new AddSessionsSectionPage(browser);
    }
}
