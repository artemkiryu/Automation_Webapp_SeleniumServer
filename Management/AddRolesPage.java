package pageObjects.Management;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddRolesData;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 31-08-2017.
 */
public class AddRolesPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@id='rle_name']")
    public WebElement ROLE_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@id='rle_order']")
    public WebElement SORT_ORDER_TEXTBOX;
    @FindBy(xpath = "//input[@id='rle_access_level_by_type']")
    public WebElement USERs_TYPE_CHK;


    public AddRolesPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void fillRolesDetails(AddRolesData addRolesData) throws Exception {
        Wait(SAVE_BUTTON, 30);
        type(ROLE_NAME_TEXTBOX, addRolesData.getName());
        type(SORT_ORDER_TEXTBOX, addRolesData.getSortOrder());
        //click(USERs_TYPE_CHK);
        logReport("New Roles added successfully");
    }

}
