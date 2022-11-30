package pageObjects.Management;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddIndustryData;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 31-08-2017.
 */
public class IndustriesPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@placeholder='Name']")
    public WebElement INDUSTRY_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@title='Add Industry']")
    public WebElement INDUSTRY_ADD_BTN;

    public IndustriesPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void addNewIndustry(AddIndustryData addIndustryData) throws Exception {
        Wait(INDUSTRY_ADD_BTN, 30);
        type(INDUSTRY_NAME_TEXTBOX, addIndustryData.getIndustryName(), true);
        click(INDUSTRY_ADD_BTN);
        logReport("New Industry added successfully");
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
    }
}
