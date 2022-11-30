package pageObjects.Forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 22-08-2017.
 */
public class AttendeeTypePage extends CommonActionsPage {

    public AttendeeTypePage(WebDriver driver) throws ConfigurationException{
        PageFactory.initElements(driver, this);
    }
}
