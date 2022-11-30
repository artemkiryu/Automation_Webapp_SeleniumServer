package pageObjects.Forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 23-08-2017.
 */
public class ConfirmPage extends CommonActionsPage {

    public ConfirmPage(WebDriver driver) throws ConfigurationException{
        PageFactory.initElements(driver, this);
    }
}
