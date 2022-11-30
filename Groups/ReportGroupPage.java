package pageObjects.Groups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;
import java.util.List;

/**
 * Created by infoobjects on 29-08-2017.
 */
public class ReportGroupPage extends CommonActionsPage {

    @FindBy(xpath = "//div[text()='Group Summary Report']")
    WebElement PANEL_HEADING;
    @FindBy(xpath = "//table//th")
    List<WebElement> COLUMN_HEADING;
    @FindBy(xpath = "//input[@ng-model='search']")
    WebElement SEARCH_TEXTBOX;

    public ReportGroupPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

}
