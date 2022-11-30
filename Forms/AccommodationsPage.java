package pageObjects.Forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 23-08-2017.
 */
public class AccommodationsPage extends CommonActionsPage {

    @FindBy(xpath = "//td[contains(text(),'This form cannot collect accommodation reservations, because the event does not have any accommodation blocks set up.')]")
    public WebElement EMPTY_ACCOMMODATION_MESSAGE_BOX;
    @FindBy(xpath = "//td[contains(text(),'This form cannot collect accommodation reservations, because the event does not have any accommodation blocks set up.')]//a[contains(text(),'accommodation')]")
    public WebElement ACCOMMODATION_BLOCK_HYPERLINK;

    public AccommodationsPage(WebDriver driver) throws ConfigurationException{
        PageFactory.initElements(driver, this);
    }


}
