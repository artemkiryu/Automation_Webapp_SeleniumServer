package pageObjects.EventSetup;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.SupplierData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by infoobjects on 8/18/2017.
 */
public class EventSuppliersPage extends CommonActionsPage {

    public EventSuppliersPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//button[@id='create-link']")
    public WebElement ADD_SUPPLIER_BUTTON;

    @FindBy(xpath = "//select[@id='PKsupID']")
    public WebElement SUPPLIER_DROPDOWN;

    @FindBy(xpath = "//select[@id='txtGldAcntNumber']")
    public WebElement GL_ACCOUNT_DROPDOWN;

    @FindBy(xpath = "//input[@id='decGldContract']")
    public WebElement CONTRACT_TEXTBOX;

    @FindBy(xpath = "//input[@id='decGldActual']")
    public WebElement ACCTUAL_TEXTBOX;

    @FindBy(xpath = "//input[@id='submitAndClose']")
    public WebElement SAVE_AND_CLOSE_BUTTON;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[contains(.,'Financials')]")
    public WebElement FINACIALS_TAB;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[contains(.,'Custom Statuses')]")
    public WebElement CUSTOM_STATUS_TAB;

    private void clickOnAddSupplierButton()throws  Exception{
        VerifyPageReady(30);
        Wait(ADD_SUPPLIER_BUTTON, 30);
        click(ADD_SUPPLIER_BUTTON);
        logReport("Successfully clicked on 'Supplier' button.");
    }

    private void selectSupplier(String supplierName) throws Exception{
        switchToLatestTabOrWindow();
        String tab1 = browser.getWindowHandle();
        logReport("switch to window successfully");
        logReport("window title-----------------" +browser.getTitle());
        logReport("window handle "+browser.getWindowHandle());
        //VerifyPageReady(30);
        browser.switchTo().window(tab1);
        logReport("window title 2-----------------" +browser.getTitle());
        logReport("window handle 2 " + browser.getWindowHandle());
        Wait(SUPPLIER_DROPDOWN, 30);
        select(SUPPLIER_DROPDOWN, supplierName);
        logReport("Successfully select value " + supplierName + " in supplier dropdown.");
    }

    private void selectGLAccount(String accountNumber) throws Exception{
        VerifyPageReady(30);
        Wait(GL_ACCOUNT_DROPDOWN,30);
        select(GL_ACCOUNT_DROPDOWN,accountNumber);
        logReport("Successfully select value "+accountNumber+" in G/L Account dropdown.");
    }

    private void enterContractAmount(String amount) throws Exception{
        VerifyPageReady(30);
        Wait(CONTRACT_TEXTBOX, 30);
        clearTextBoxValue(CONTRACT_TEXTBOX);
        type(CONTRACT_TEXTBOX, amount);
        logReport("Successfully entered value "+amount+" in contract textbox.");
    }

    private void enterActualAmount(String amount) throws Exception{
        VerifyPageReady(30);
        Wait(ACCTUAL_TEXTBOX, 30);
        clearTextBoxValue(ACCTUAL_TEXTBOX);
        type(ACCTUAL_TEXTBOX, amount);
        logReport("Successfully entered value "+amount+" in actual textbox.");
    }

    public void clickOnSaveAndCloseButton()throws  Exception{
        VerifyPageReady(30);
        Wait(SAVE_AND_CLOSE_BUTTON, 30);
        click(SAVE_AND_CLOSE_BUTTON);
        logReport("Successfully clicked on 'Save & close' button.");
        waitForWindowToDispose();
    }

    public void fillSupplierDetail(SupplierData supplierData)throws Exception{
        clickOnAddSupplierButton();
        selectSupplier(supplierData.getSupplierName());
        //selectGLAccount(supplierData.getSupplierGLAccount());
        enterContractAmount(supplierData.getContractAmount());
        enterActualAmount(supplierData.getActualAmount());
    }

    public CustomStatusesPage clickOnCustomTab()throws Exception{
        VerifyPageReady(30);
        Wait(CUSTOM_STATUS_TAB, 30);
        click(CUSTOM_STATUS_TAB);
        logReport("Successfully clicked on 'custom status' tab.");
        return new CustomStatusesPage(browser);
    }

    public EventFinancialPage clickOnFinancialsTab()throws Exception{
        VerifyPageReady(30);
        scrollIntoView(FINACIALS_TAB);
        Wait(FINACIALS_TAB, 30);
        click(FINACIALS_TAB);
        logReport("Successfully clicked on 'Finacial' tab.");
        return new EventFinancialPage(browser);
    }

    public List<String> getSupplierDetail() {
        List<String> supplierData = new ArrayList<>();
        List<WebElement> supplierList = browser.findElements(By.xpath("//td[@class='gridGroupHeader gridGroup1']"));
        for (WebElement element : supplierList) {
            supplierData.add(element.getText());
        }
        return supplierData;
    }

}
