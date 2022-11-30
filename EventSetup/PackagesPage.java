package pageObjects.EventSetup;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddPackageData;

/**
 * Created by infoobjects on 8/21/2017.
 */
public class PackagesPage extends CommonActionsPage {

    public PackagesPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//button[@id='create-link']")
    public WebElement ADD_NEW_BUTTON;

    @FindBy(xpath = "//input[@id='pakg_name']")
    public WebElement PACKAGE_NAME_TEXTBOX;

    @FindBy(xpath = "//input[@id='pakg_code']")
    public WebElement PACKAGE_CODE_TEXTBOX;

    @FindBy(xpath = "//input[@id='pakg_sum_multiplier']")
    public WebElement PACKAGE_SUM_MULTIPLIER_TEXTBOX;

    @FindBy(xpath = "//input[@aria-controls='dataGridTableA']")
    public WebElement SEARCH_TEXTBOX;

    @FindBy(xpath = "//input[@value='Check All']']")
    public WebElement CHECK_ALL_BUTTON;

    @FindBy(xpath = "//input[@value='Clear All']']")
    public WebElement CLEAR_ALL_BUTTON;

    @FindBy(xpath = "//input[@id='submitForm']")
    public WebElement SAVE_BUTTON;


    public  void clickOnAddNewButton()throws Exception{
        VerifyPageReady(30);
        Wait(ADD_NEW_BUTTON,30);
        click(ADD_NEW_BUTTON);
        logReport("Successfully clicked on 'Add New' Button");
    }


    public  void clickOnSaveButton()throws Exception{
        VerifyPageReady(30);
        Wait(SAVE_BUTTON,30);
        click(SAVE_BUTTON);
        logReport("Successfully clicked on 'Save' Button");
    }

    public void enterPackageName(String name)throws Exception{
        VerifyPageReady(30);
        Wait(PACKAGE_NAME_TEXTBOX,30);
        type(PACKAGE_NAME_TEXTBOX, name);
        logReport("Successfully entered value: "+name+" in 'Package Name' textbox.");
    }

    public void enterPackageCode(String code)throws Exception{
        VerifyPageReady(30);
        Wait(PACKAGE_CODE_TEXTBOX,30);
        type(PACKAGE_CODE_TEXTBOX, code);
        logReport("Successfully entered value: "+code+" in 'Package Code' textbox.");
    }

    public void enterPackageMultiplier(String value)throws Exception{
        VerifyPageReady(30);
        Wait(PACKAGE_SUM_MULTIPLIER_TEXTBOX,30);
        type(PACKAGE_SUM_MULTIPLIER_TEXTBOX, value);
        logReport("Successfully entered value: "+value+" in 'Package Sum multiplier' textbox.");
    }

    public void enterSearchValue(String value)throws Exception {
        VerifyPageReady(30);
        Wait(SEARCH_TEXTBOX, 30);
        type(SEARCH_TEXTBOX, value);
        logReport("Successfully entered value: " + value + " in 'Search' textbox.");
    }

    public void clickOnCheckAllButton()throws Exception{
        VerifyPageReady(30);
        Wait(CHECK_ALL_BUTTON,30);
        click(CHECK_ALL_BUTTON);
        logReport("Successfully clicked on 'Check All' Button");
    }

    public void clickOnClearAllButton()throws Exception{
        VerifyPageReady(30);
        Wait(CLEAR_ALL_BUTTON,30);
        click(CLEAR_ALL_BUTTON);
        logReport("Successfully clicked on 'Clear All' Button");
    }

    public void fillAddPackageDetails(AddPackageData addPackageData)throws Exception{
        enterPackageName(addPackageData.getPackageName());
        enterPackageCode(addPackageData.getPackageCode());
        enterPackageMultiplier(addPackageData.getPackageMultiplier());
        clickOnCheckAllButton();
    }
}
