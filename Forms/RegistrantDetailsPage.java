package pageObjects.Forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 22-08-2017.
 */
public class RegistrantDetailsPage extends CommonActionsPage {
    @FindBy(xpath = "//select[@id='ShowFields']")
    public WebElement availableFieldsDropdown;
    @FindBy(xpath = ("//input[@title='Move Selected Item(s) to the Right']"))
    public WebElement moveRightButton;

    public RegistrantDetailsPage (WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void selectAvailableFieldItem(String item) throws Exception {
        VerifyPageReady(30);
        select(availableFieldsDropdown, item);
        click(moveRightButton);
    }
}
