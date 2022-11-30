package pageObjects.AccountSettings;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pageObjects.Implementation.ProductsPage;
import pageObjects.Login.DashboardPage;
import pageObjects.PrivacyComplianceSettingsPage;
import pageObjects.Registration.CustomProfileDataPage;
import pageObjects.SubAccount.SubAccountsPage;
import pageObjects.TagsPage;

/**
 * Created by infoobjects on 8/3/2017.
 */
public class AccountSettingsPage extends CommonActionsPage{

    @FindBy(xpath = "//a[@title='Select the products available to this account']")
    public WebElement productsDropdownLink;
    @FindBy(xpath = "//a[@title='Sub-Accounts']")
    public WebElement subAccountsLink;
    @FindBy(xpath = "//a[@title='Implementation settings for this account.']")
    public WebElement implementationDropdownLink;


    @FindBy(xpath = "//a[@class='events-module']//i")
    public WebElement EVENTS_OPTION;

    @FindBy(xpath = "//a[@title='Tags']")
    public WebElement TAGS_LINK;

    @FindBy(xpath = "//a[@title='Suppliers']")
    public WebElement EVNT_PRFL_SUPPL_MENU;
    @FindBy(xpath = "//a[@class='supplier-module']//i")
    public WebElement SUPPLIERS_OPTION;
    @FindBy(xpath = "//a[@title='Industries']")
    public WebElement INDUSTRIES_LINK;
    @FindBy(xpath = "//a[@title='Menu']")
    public WebElement MENU_LINK;
    @FindBy(xpath = "//a[@title='Registration settings for this account.']")
    public WebElement REGISTRATION_MENU_ITEM;
    @FindBy(xpath = "//a[@title='Define the custom data fields to collect for all profiles in the current account']")
    public WebElement PROFILE_DATA_MENU_ITEM;

    @FindBy(xpath = "//div[text()='Certain System root']")
    public WebElement ROOT_ACCOUNT_LINK;

    @FindBy(xpath = "//a[@id='accountDropdown']//div[@class='actSelector']")
    public WebElement accountSelector;

    @FindBy(xpath = "//iframe[@id='accountSelectorFrame']")
    public WebElement accountFrame;

    @FindBy(xpath = "//a[@title='Single Sign-On']")
    public WebElement singleSignOnLink;

    @FindBy(xpath = "//a[@title='Privacy Compliance Settings']")
    public WebElement privacyComplianceLink;

    @FindBy(xpath = "//a[@title='Configure data privacy for this account.']")
    public WebElement privacyComplianceOption;

    public AccountSettingsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public SubAccountsPage clickSubAccounts() throws Exception {
        clickByJavaScript(subAccountsLink);
        logReport("Clicked on Sub Accounts Link");
        VerifyAjaxRequestsFinished(20);
        VerifyPageReady(20);
        return new SubAccountsPage(browser);
    }
    /**
     * Method for clicking on the Products from the Drop Down
     *
     * @return ProductsPage
     */
    public ProductsPage clickProductsFromDropDown() throws Exception{
        clickImplementationDropDown();
        Wait(productsDropdownLink, 40);
        productsDropdownLink.click();
        logReport("Clicked on Products Dropdown Link");
        VerifyPageReady(30);
        titleContains("Products | Certain");
        return new ProductsPage(browser);
    }

    private void clickImplementationDropDown() throws Exception{
        Wait(implementationDropdownLink, 30);
        clickByJavaScript(implementationDropdownLink);
        // implementationDropdownLink.click();
        logReport("Clicked on Implementation drop Dwon");
        Thread.sleep(5000);
    }


    public CustomProfileDataPage clickProfileDataFromRegistrationDropdown()throws Exception{
        VerifyPageReady(30);
        Wait(REGISTRATION_MENU_ITEM, 30);
        clickByJavaScript(REGISTRATION_MENU_ITEM);
        logReport("Clicked on Registration drop Down");
        Wait(PROFILE_DATA_MENU_ITEM, 10);
        PROFILE_DATA_MENU_ITEM.click();
        logReport("Clicked on profile data drop Down");
        return new CustomProfileDataPage(browser);
    }

    public void switchToAccountFrame() throws Exception {
        VerifyPageReady(30);
        browser.switchTo().frame(accountFrame);
        logReport("Switched to account frame successfully");
        //webDriver.switchTo().defaultContent();
    }

    public DashboardPage selectRootAccount() throws Exception {
        VerifyAjaxRequestsFinished(30);
        accountSelector.click();
        VerifyAjaxRequestsFinished(30);
        switchToAccountFrame();
        ROOT_ACCOUNT_LINK.click();
        logReport("Root account link clicked successfully");
        VerifyAjaxRequestsFinished(30);
        VerifyPageReady(30);
        return new DashboardPage(browser);
    }


    public TagsPage clickTagsLink() throws Exception {
        Wait(TAGS_LINK, 10);
        clickByJavaScript(TAGS_LINK);
        logReport("Tags link clicked successfully");
        VerifyAngularHasFinishedProcessing(20);
        VerifyPageReady(20);
        return new TagsPage(browser);

    }

    public SupplierPage clickEventsProfilesSuppliersMenu() throws Exception {
        VerifyPageReady(20);
        click(MENU_LINK);
        Wait(EVNT_PRFL_SUPPL_MENU, 20);
        click(EVNT_PRFL_SUPPL_MENU);
        logReport("Clicked on Event Profile Suppliers Menu");
        return new SupplierPage(browser);
    }

    public void clickManagementDropDown() throws Exception {
        Wait(ManagementDropdownLink, 30);
        click(ManagementDropdownLink);
        logReport("Clicked on Management dropDwon");
        Thread.sleep(5000);
    }

    public TagsPage clickManagmentTagsLink() throws Exception {

        clickManagementDropDown();
        Wait(ManagementTagsDropdownLink, 40);
        ManagementTagsDropdownLink.click();
        logReport("Management Tags link clicked successfully");
        VerifyPageReady(30);
        return new TagsPage(browser);

    }

    public PrivacyComplianceSettingsPage clickPrivacyComplianceUnderImplementation() throws Exception {
        Wait(implementationDropdownLink, 30);
        clickByJavaScript(implementationDropdownLink);
        Wait(privacyComplianceOption, 5);
        click(privacyComplianceOption);
        logReport("Successfully clicked on 'Privacy compliance' tab.");
        return new PrivacyComplianceSettingsPage(browser);
    }


}
