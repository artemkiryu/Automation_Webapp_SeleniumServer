package pageObjects.Implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;

public class PrivacyCompliancePage extends CommonActionsPage {

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Profile Anonymization']")
    public WebElement PROFILE_ANONYMIZATION_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Russian Data Privacy']")
    public WebElement RUSSIAN_DATA_PRIVACY_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Products']")
    public WebElement PRODUCTS_TAB;


    public PrivacyCompliancePage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public ProfileAnonymizationPage clickOnProfileAnonymizationTab() throws Exception {
        VerifyPageReady(40);
        click(PROFILE_ANONYMIZATION_TAB);
        logReport("Successfully clicked on Profile Anonymization tab.");
        VerifyAngularHasFinishedProcessing(30);
        VerifyPageReady(30);
        return new ProfileAnonymizationPage(browser);
    }

    public ProductsPage clickOnProductsTab() throws Exception {
        VerifyPageReady(40);
        click(PRODUCTS_TAB);
        logReport("Successfully clicked on Products tab.");
        VerifyAngularHasFinishedProcessing(30);
        VerifyPageReady(30);
        return new ProductsPage(browser);
    }
}
