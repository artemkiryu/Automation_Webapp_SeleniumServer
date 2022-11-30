package pageObjects.Implementation;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import java.util.List;

/**
 * Created by infoobjects on 8/3/2017.
 */
public class ProductsPage extends CommonActionsPage {

    public static final By CHECKBOXES = By.xpath("//input[@type='checkbox']");

    public static final By CHECK_IN_CHECKBOX = By.xpath("//strong[text()='Certain Check-In']//..//input[@type='checkbox']");

    public static final By SIGNAL_CHECKBOX = By.xpath("//label[text()='Signal - Real-Time Data Integration']//..//input[@type='checkbox']");

    public static final By INTELLIGENCE_CHECKBOX = By.xpath("//label[text()='Intelligence - Understanding your data']/..//input");

    public static final By SIGNAL_CHECKBOX_OLD = By.xpath("//label[text()='Signal - Real time Data Integration']//..//input[@type='checkbox']");

    //label[text()='Signal - Real time Data Integration']//..//input[@type='checkbox']

    public static final By FULL_CC_NUMBER_ACCESS_CHECKBOXES = By.xpath("//strong[text()='Full CC Number Access']/preceding-sibling::input");

    @FindBy(xpath = "//input[@id='Signal - Real-Time Data Integration']")
    public WebElement SIGNAL_CHK_MODULE;

    @FindBy(xpath = "//input[@id='acnt_max_mobile_web_apps']")
    public WebElement MAX_MOBILE_WEB_APPS;

    @FindBy(xpath = "//input[@id='acnt_max_mobile_native_apps']")
    public WebElement MAX_MOBILE_NATIVE_APPS;
    @FindBy(xpath = "//table[@id='event-views-module']//input[@id='acnt_max_event_views']")
    public WebElement MAX_EVENT_ACCOUNT;
    @FindBy(xpath = "//table[@id='event-views-module']//input[@id='acnt_max_event_views_evt']")
    public WebElement MAX_EVENT_VIEWS_PER_EVENT;
    @FindBy(xpath = "//input[@id='submitForm']")
    public WebElement SAVE_BUTTON;
    @FindBy(xpath = "//input[@id='Global Compliance Module']")
    public WebElement GLOBAL_COMPLIANCE_MODULE_CHECKBOX;

    @FindBy(xpath = "//input[@id='Single Sign-On Module']")
    public WebElement SINGLE_SIGNON_CHK;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Privacy Compliance']")
    public WebElement PRIVACY_COMPLIANCE_TAB;
    @FindBy(xpath = "//input[@id='Data Privacy Module']")
    public WebElement DATA_PRIVACY_MODULE_CHECKBOX;


    @FindBy(xpath = "//strong[text()='Russian Data Privacy']/../input")
    public WebElement RUSSIANDATA_PRIVACY_MODULE_CHK;


    public ProductsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * method to enable all products.
     */
    public void enableAllProducts() throws Exception {
        VerifyPageReady(30);
        List<WebElement> checkboxList = browser.findElements(CHECKBOXES);
        List<WebElement> fullCCNumbercheckboxList = browser.findElements(FULL_CC_NUMBER_ACCESS_CHECKBOXES);
        List<WebElement> checkInCheckBox = browser.findElements(CHECK_IN_CHECKBOX);
        List<WebElement> signalCheckbox = browser.findElements(SIGNAL_CHECKBOX);
        List<WebElement> intelligenceChk = browser.findElements(INTELLIGENCE_CHECKBOX);
        checkboxList.removeAll(checkInCheckBox);
        checkboxList.removeAll(fullCCNumbercheckboxList);
        checkboxList.removeAll(signalCheckbox);
        checkboxList.removeAll(intelligenceChk);

        for (WebElement checkbox : checkboxList) {
            //executeJavascript("arguments[0].scrollIntoView();", checkbox);
            if (!checkbox.isSelected()) {
                clickByJavaScript(checkbox);

            }
            // checkbox.click();
        }
        type(MAX_EVENT_ACCOUNT, "1", true);
        type(MAX_EVENT_VIEWS_PER_EVENT, "1", true);
        SAVE_BUTTON.click();

        VerifyPageReady(30);
    }

    public void enableGlobalComplianceModule()throws Exception{
        //  scrollIntoView(GLOBAL_COMPLIANCE_MODULE_CHECKBOX);
        checkByJavascript(GLOBAL_COMPLIANCE_MODULE_CHECKBOX);
        logReport("Successfully clicked on 'Global compliance Module' checkbox.");

    }

    public void enableSingleSignOnModule() throws Exception {
        checkByJavascript(SINGLE_SIGNON_CHK);
        logReport("Successfully clicked on 'Single Sign On Module' checkbox.");

    }

    public void enableSignalModule() throws Exception {
        checkByJavascript(SIGNAL_CHK_MODULE);
        logReport("Signal module checkbox checked successfully");
        if (isAlertPresent()) {
            acceptAlert();
        }

    }

    public PrivacyCompliancePage clickOnPrivacyComplianceTab() throws Exception {
        VerifyPageReady(40);
        click(PRIVACY_COMPLIANCE_TAB);
        logReport("Successfully clicked on Privacy Compliance tab.");
        VerifyAngularHasFinishedProcessing(30);
        VerifyPageReady(30);
        return new PrivacyCompliancePage(browser);
    }

    public void enableProduct(String moduleLabel, String productLabel) throws Exception {
        String xpathProduct = "//strong[text()='" + productLabel + "']/..//input";
        enableModule(moduleLabel);
        WebElement elementProduct = browser.findElement(By.xpath(xpathProduct));
        if (!elementProduct.isSelected()) {
            clickByJavaScript(elementProduct);
            logReport("Successfully enabled " + productLabel + " Product.");
        }
    }

    public void disableProduct(String moduleLabel, String productLabel) throws Exception {
        String xpathProduct = "//strong[text()='" + productLabel + "']/..//input";
        if (isModuleEnabled(moduleLabel)) {
            WebElement elementProduct = browser.findElement(By.xpath(xpathProduct));
            if (isProductEnabled(productLabel)) {
                clickByJavaScript(elementProduct);
                if (isAlertPresent()) {
                    acceptAlert();
                }
                logReport("Successfully disabled " + productLabel + " Product.");
            }
            logReport(productLabel + " already disabled.");
        }
    }

    public void enableModule(String moduleLabel) throws Exception {
        String xpathModule = "//label[text()='" + moduleLabel + "']/..//input";
        if (VerifyElementPresent(By.xpath(xpathModule), 10)) {
            WebElement elementModule = browser.findElement(By.xpath(xpathModule));
            if (!elementModule.isSelected()) {
                clickByJavaScript(elementModule);
                logReport("Successfully enabled " + moduleLabel + " Module.");

            }
            logReport(moduleLabel + " Module already enabled.");
        }

    }

    public void disableModule(String moduleLabel) throws Exception {
        String xpathModule = "//label[text()='" + moduleLabel + "']/..//input";
        if (VerifyElementPresent(By.xpath(xpathModule), 10)) {
            WebElement elementModule = browser.findElement(By.xpath(xpathModule));
            if (isModuleEnabled(moduleLabel)) {
                clickByJavaScript(elementModule);
                if (isAlertPresent()) {
                    acceptAlert();
                }
                logReport("Successfully disabled " + moduleLabel + " Module.");
            }
            logReport(moduleLabel + " already disabled.");

        }

    }

    public void clickSaveProduct() throws Exception {
        clickByJavaScript(SAVE_BUTTON);
        VerifyPageReady(30);
        logReport("Successfully clicked on Save button.");
    }

    public boolean isModuleEnabled(String moduleLabel) throws Exception {
        boolean found = false;
        String xpathModule = "//label[text()='" + moduleLabel + "']/..//input";
        if (VerifyElementPresent(By.xpath(xpathModule), 10)) {
            WebElement elementModule = browser.findElement(By.xpath(xpathModule));
            if (elementModule.isSelected()) {
                found = true;
                logReport(moduleLabel + " is enabled.");

            } else {
                found = false;
                logReport(moduleLabel + " is disabled.");
            }

        }
        return found;
    }

    public boolean isProductEnabled(String productLabel) throws Exception {
        boolean found = false;
        String xpathProduct = "//strong[text()='" + productLabel + "']/..//input";
        if (VerifyElementPresent(By.xpath(xpathProduct), 10)) {
            WebElement elementProduct = browser.findElement(By.xpath(xpathProduct));
            if (elementProduct.isSelected()) {
                found = true;
                logReport(productLabel + " is enabled.");

            } else {
                found = false;
                logReport(productLabel + " is disabled.");
            }

        }
        return found;
    }


    public void enableDataPrivacyModule() throws Exception {
        //  scrollIntoView(GLOBAL_COMPLIANCE_MODULE_CHECKBOX);
        if (verifyElementDisplayed(DATA_PRIVACY_MODULE_CHECKBOX, 2)) {
            checkByJavascript(DATA_PRIVACY_MODULE_CHECKBOX);
            checkByJavascript(RUSSIANDATA_PRIVACY_MODULE_CHK);
        }
        logReport("Successfully clicked on 'Global compliance Module' checkbox.");

    }

}
