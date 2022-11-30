package pageObjects.Registration;



import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.ECommerceAccount;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by bludshot on 22/7/15.
 */
public class ECommerceAccountDetailsPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@name='proc_acnt_name']")
    public WebElement NAME_TEXTBOX;
    @FindBy(xpath = "//select[@id='proc_acnt_frn_proc_id']")
    public WebElement ONLINE_PROCESSOR_DROPDOWN;
    @FindBy(xpath = "//select[@name='proc_acnt_frn_cur_id']")
    public WebElement CURRENCY_DROPDOWN;
    @FindBy(xpath = "//input[@name='proc_acnt_dba_name']")
    public WebElement EXACT_BUSINESS_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@name='proc_acnt_proc_id']")
    public WebElement ACCOUNT_MERCHANT_TEXTBOX;
    @FindBy(xpath = "//input[@name='proc_acnt_partner_id']")
    public WebElement ACCOUNT_PARTNER_ID_TEXTBOX;

    @FindBy(xpath = "//textarea[@name='proc_acnt_partner_id']")
    public WebElement ACCOUNT_PARTNER_ID_TEXTAREA;

    @FindBy(xpath = "//textarea[@name='proc_wddx']")
    public WebElement TEST_TRANSACTION;

    @FindBy(xpath = "//input[@name='proc_acnt_partner_id_confirm']")
    public WebElement ACCOUNT_PARTNER_ID_CONFIRM_TEXTBOX;
    @FindBy(xpath = "//input[@name='proc_acnt_user']")
    public WebElement ACCOUNT_USER_ID_TEXTBOX;
    @FindBy(xpath = "//input[@name='proc_acnt_proc_key']")
    public WebElement ACCOUNT_PASSWORD_TEXTBOX;
    @FindBy(xpath = "//input[@name='proc_acnt_proc_key_confirm']")
    public WebElement CONFIRM_ACCOUNT_PASSWORD_TEXTBOX;
    @FindBy(xpath = "//input[@name='proc_acnt_admin_url']")
    public WebElement PAYPAL_MANAGER_URL_TEXTBOX;
    @FindBy(xpath = "//input[@id='proc_acnt_is_primary']")
    public WebElement PRIMARY_PROCESSING_ACCOUNT_checkByJavascriptBOX;
    @FindBy(xpath = "//input[@id='proc_acnt_sub_access']")
    public WebElement ACCOUNT_ACCESSIBILITY_checkByJavascriptBOX;
    @FindBy(xpath = "//input[@name='proc_acnt_limit']")
    public WebElement SINGLE_TRANSACTION_LIMIT_TEXTBOX;
    @FindBy(xpath = "//label[contains(.,'Visa')]/input")
    public WebElement VISA_checkByJavascriptBOX;
    @FindBy(xpath = "//label[contains(.,'MasterCard')]/input")
    public WebElement MASTERCARD_checkByJavascriptBOX;
    @FindBy(xpath = "//label[contains(.,'Amex')]/input")
    public WebElement AMEX_checkByJavascriptBOX;
    @FindBy(xpath = "//label[contains(.,'Diners')]/input")
    public WebElement DINERS_checkByJavascriptBOX;
    @FindBy(xpath = "//label[contains(.,'Discover')]/input")
    public WebElement DISCOVER_checkByJavascriptBOX;
    @FindBy(xpath = "//label[contains(.,'JCB')]/input")
    public WebElement JCB_checkByJavascriptBOX;
    @FindBy(xpath = "//label[contains(.,'ACH')]/input")
    public WebElement ACH_checkByJavascriptBOX;
    @FindBy(xpath = "//label[contains(.,'Eurocard')]/input")
    public WebElement EUROCARD_checkByJavascriptBOX;
    @FindBy(xpath = "//label[contains(.,'Laser')]/input")
    public WebElement LASER_checkByJavascriptBOX;
    @FindBy(xpath = "//label[contains(.,'UnionPay')]/input")
    public WebElement UNIONPAY_checkByJavascriptBOX;

    @FindBy(xpath = "//label[contains(.,'Collect Billing Address')]/input")
    public WebElement COLLECT_BILLING_ADDRESS_checkByJavascriptBOX;
    @FindBy(xpath = "//label[contains(.,'Match Zip Code')]/input")
    public WebElement MATCH_ZIP_CODE_checkByJavascriptBOX;
    @FindBy(xpath = "//label[contains(.,'Match Street Number')]/input")
    public WebElement MATCH_STREET_NUMBER_checkByJavascriptBOX;
    @FindBy(xpath = "//label[contains(.,'Require AVS')]/input")
    public WebElement REQUIRE_AVS_checkByJavascriptBOX;
    @FindBy(xpath = "//label[contains(.,'Collect CSC Number')]/input")
    public WebElement COLLECT_CSC_NUMBER;
    @FindBy(xpath = "//label[contains(.,'Require CSC')]/input")
    public WebElement REQUIRE_CSC_YES_RESPONSE;
    @FindBy(xpath = "//textarea[@id='proc_acnt_notes']")
    public WebElement USER_NOTES;
    @FindBy(xpath = "//input[@id='submitForm']")
    public WebElement SAVE_BUTTON;

    @FindBy(xpath = "//input[@name='proc_acnt_post_test_url']")
    public WebElement TEST_PAYMENT_URL;

    @FindBy(xpath = "//input[@name='proc_acnt_post_live_url']")
    public WebElement LIVE_PAYMENT_URL;

    @FindBy(xpath = "//label[contains(.,'Auto-enforce CSC')]/input")
    public WebElement AUTOENFORCE_CSC_NUMBER;

    @FindBy(xpath = "//input[@name='proc_acnt_SHAstring']")
    public WebElement SHASTRING_SIGNATURE;

    public ECommerceAccountDetailsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for clicking save button
     *
     * @return FinancialDataSettingPage
     */
    public FinancialDataSettingPage clickSaveButton() throws Exception {
        click(SAVE_BUTTON);
        reporter.info("Clicked on Save Button");
        return new FinancialDataSettingPage(browser);
    }

    /**
     * Method for entering name
     *
     * @param name value of name
     */
    public void enterName(String name) throws Exception {
        Wait(NAME_TEXTBOX, 10);
        type(NAME_TEXTBOX, name, true);
    }

    /**
     * Method for select online processor
     *
     * @param onlineProcessor value of online processor
     */
    public void selectOnlineProcessor(String onlineProcessor) throws Exception {
        //    if(!webDriver.element().getSelectedOption(ONLINE_PROCESSOR_DROPDOWN).equals(onlineProcessor))
        select(ONLINE_PROCESSOR_DROPDOWN, onlineProcessor);
        logReport("Selected online processor " + onlineProcessor);
        VerifyAjaxRequestsFinished(30);
        VerifyPageReady(30);
    }


    /**
     * Method for select currency
     *
     * @param currency value of currency
     */
    public void selectCurrency(String currency) {
        select(CURRENCY_DROPDOWN, currency);
    }

    /**
     * Method for entering exact business name
     *
     * @param exactBusinessName value of business name
     */
    public void enterExactBusinessName(String exactBusinessName) {
        type(EXACT_BUSINESS_NAME_TEXTBOX, exactBusinessName, true);
    }

    /**
     * Method for entering account merchant or vendor id
     *
     * @param accountMerchantOrVendorID value of account merchant id
     */
    public void enterAccountMerchantOrVendorID(String accountMerchantOrVendorID) {
        if (accountMerchantOrVendorID != null)
            type(ACCOUNT_MERCHANT_TEXTBOX, accountMerchantOrVendorID, true);
    }

    /**
     * Method for entering account partner id
     *
     * @param accountPartnerID value of account partner id
     */
    public void enterAccountPartnerID(String accountPartnerID, String processorType) {
        if (processorType.equalsIgnoreCase("Cybersource")) {
            if (accountPartnerID != null)
                type(ACCOUNT_PARTNER_ID_TEXTAREA, accountPartnerID);
        } else if (accountPartnerID != null)
            type(ACCOUNT_PARTNER_ID_TEXTBOX, accountPartnerID, true);
    }

    public void enterAccountPartnerIDConfirm(String accountPartnerID) {
        if (accountPartnerID != null)
            type(ACCOUNT_PARTNER_ID_CONFIRM_TEXTBOX, accountPartnerID, true);
    }

    public void enterAccountPartnerIDTextArea(String accountPartnerID) {
        if (accountPartnerID != null)
            type(ACCOUNT_PARTNER_ID_TEXTAREA, accountPartnerID, true);
    }

    /**
     * Method for entering account user id
     *
     * @param accountUserID value of account userid
     */
    public void enterAccountUserID(String accountUserID) {
        if (accountUserID != null)
            type(ACCOUNT_USER_ID_TEXTBOX, accountUserID, true);
    }

    /**
     * Method for entering account password
     *
     * @param accountPassword value of account pwd
     */
    public void enterAccountPassword(String accountPassword) {
        if (accountPassword != null)
            type(ACCOUNT_PASSWORD_TEXTBOX, accountPassword, true);
    }

    /**
     * Method for entering confirm account password
     *
     * @param confirmAccountPassword value of confirm pwd
     */
    public void enterConfirmAccountPassword(String confirmAccountPassword) {
        if (confirmAccountPassword != null)
            type(CONFIRM_ACCOUNT_PASSWORD_TEXTBOX, confirmAccountPassword, true);
    }

    /**
     * Method for entering paypal manager url
     *
     * @param paypalManagerURL value of manager url
     */
    public void enterPaypalManagerURL(String paypalManagerURL) {
        if (paypalManagerURL != null)
            type(PAYPAL_MANAGER_URL_TEXTBOX, paypalManagerURL, true);
    }

    public void enterTestTransaction(String testTransaction) {
        type(TEST_TRANSACTION, testTransaction, true);
        logReport("Entered cybersource test transaction url " + testTransaction);
    }
    /**
     * Method for checkByJavascript primary processing account
     *
     * @param checkByJavascript value of checkByJavascript(i.e. true or false)
     */
    public void checkByJavascriptPrimaryProcessingAccount(boolean checkByJavascript) {
        if (verifyElementDisplayed(PRIMARY_PROCESSING_ACCOUNT_checkByJavascriptBOX, 2)) {
            if (checkByJavascript) {
                checkByJavascript(PRIMARY_PROCESSING_ACCOUNT_checkByJavascriptBOX);
                acceptAlert();
            } else
                uncheckByJavascript(PRIMARY_PROCESSING_ACCOUNT_checkByJavascriptBOX);

        }
    }

    public void checkByJavascriptAccountForAccessibility(boolean checkByJavascript) {
        if (verifyElementDisplayed(ACCOUNT_ACCESSIBILITY_checkByJavascriptBOX, 2)) {
            if (checkByJavascript)
                checkByJavascript(ACCOUNT_ACCESSIBILITY_checkByJavascriptBOX);
            else
                uncheckByJavascript(ACCOUNT_ACCESSIBILITY_checkByJavascriptBOX);
        }
    }

    /**
     * Method for entering single transaction limit
     *
     * @param singleTransactionLimit value of single transaction limit
     */
    public void enterSingleTransactionLimit(String singleTransactionLimit) {
        if (singleTransactionLimit != null)
            type(SINGLE_TRANSACTION_LIMIT_TEXTBOX, singleTransactionLimit, true);
    }

    /**
     * Method for select available payment methods
     *
     * @param paymentMethodsToSelect value of payment methods to select
     */
    public void selectAvailablePaymentMethods(String paymentMethodsToSelect) {
        String[] paymentMethodsToSelectArray = paymentMethodsToSelect.split(",");
        Set<String> paymentMethodsToSelectSet = new HashSet<>(Arrays.asList(paymentMethodsToSelectArray));
        Set<String> allAvailablePaymentMethodsSet = new HashSet<>(Arrays.asList("Visa", "MasterCard", "Amex", "Diners", "Discover", "JCB", "ACH", "Eurocard", "Laser", "UnionPay"));
        for (String paymentMethod : paymentMethodsToSelectSet) {
            if (paymentMethod.equalsIgnoreCase("Visa")) checkByJavascript(VISA_checkByJavascriptBOX);
            if (paymentMethod.equalsIgnoreCase("MasterCard")) checkByJavascript(MASTERCARD_checkByJavascriptBOX);
            if (paymentMethod.equalsIgnoreCase("Amex")) checkByJavascript(AMEX_checkByJavascriptBOX);
            if (paymentMethod.equalsIgnoreCase("Diners")) checkByJavascript(DINERS_checkByJavascriptBOX);
            if (paymentMethod.equalsIgnoreCase("Discover")) checkByJavascript(DISCOVER_checkByJavascriptBOX);
            if (paymentMethod.equalsIgnoreCase("JCB")) checkByJavascript(JCB_checkByJavascriptBOX);
            if (paymentMethod.equalsIgnoreCase("ACH")) checkByJavascript(ACH_checkByJavascriptBOX);
            if (paymentMethod.equalsIgnoreCase("Eurocard")) checkByJavascript(EUROCARD_checkByJavascriptBOX);
            if (paymentMethod.equalsIgnoreCase("Laser")) checkByJavascript(LASER_checkByJavascriptBOX);
            if (paymentMethod.equalsIgnoreCase("UnionPay")) checkByJavascript(UNIONPAY_checkByJavascriptBOX);
        }

        allAvailablePaymentMethodsSet.removeAll(paymentMethodsToSelectSet);
        for (String paymentMethodToRemove : allAvailablePaymentMethodsSet) {
            if (paymentMethodToRemove.equalsIgnoreCase("Visa")) uncheckByJavascript(VISA_checkByJavascriptBOX);
            if (paymentMethodToRemove.equalsIgnoreCase("MasterCard"))
                uncheckByJavascript(MASTERCARD_checkByJavascriptBOX);
            if (paymentMethodToRemove.equalsIgnoreCase("Amex")) uncheckByJavascript(AMEX_checkByJavascriptBOX);
            if (paymentMethodToRemove.equalsIgnoreCase("Diners")) uncheckByJavascript(DINERS_checkByJavascriptBOX);
            if (paymentMethodToRemove.equalsIgnoreCase("Discover")) uncheckByJavascript(DISCOVER_checkByJavascriptBOX);
            if (paymentMethodToRemove.equalsIgnoreCase("JCB")) uncheckByJavascript(JCB_checkByJavascriptBOX);
            if (paymentMethodToRemove.equalsIgnoreCase("ACH")) uncheckByJavascript(ACH_checkByJavascriptBOX);
            if (paymentMethodToRemove.equalsIgnoreCase("Eurocard")) uncheckByJavascript(EUROCARD_checkByJavascriptBOX);
            if (paymentMethodToRemove.equalsIgnoreCase("Laser")) uncheckByJavascript(LASER_checkByJavascriptBOX);
            if (paymentMethodToRemove.equalsIgnoreCase("UnionPay")) uncheckByJavascript(UNIONPAY_checkByJavascriptBOX);
        }
    }

    public void selectAvailablePaymentMethodsTest(String paymentMethodsToSelect) {
        String[] paymentMethodsToSelectArray = paymentMethodsToSelect.split(",");
        Set<String> paymentMethodsToSelectSet = new HashSet<>(Arrays.asList(paymentMethodsToSelectArray));
        Set<String> allAvailablePaymentMethodsSet = new HashSet<>(Arrays.asList("Visa", "MasterCard", "Amex", "Diners", "Discover", "JCB", "ACH", "Eurocard", "Laser", "UnionPay"));
        for (String paymentMethod : paymentMethodsToSelectSet) {
            if (paymentMethod.equalsIgnoreCase("Visa")) checkByJavascript(VISA_checkByJavascriptBOX);
            if (paymentMethod.equalsIgnoreCase("MasterCard")) checkByJavascript(MASTERCARD_checkByJavascriptBOX);
            if (paymentMethod.equalsIgnoreCase("Amex")) checkByJavascript(AMEX_checkByJavascriptBOX);
            if (paymentMethod.equalsIgnoreCase("Diners")) checkByJavascript(DINERS_checkByJavascriptBOX);
            if (paymentMethod.equalsIgnoreCase("Discover")) checkByJavascript(DISCOVER_checkByJavascriptBOX);
            if (paymentMethod.equalsIgnoreCase("JCB")) checkByJavascript(JCB_checkByJavascriptBOX);
            if (paymentMethod.equalsIgnoreCase("ACH")) checkByJavascript(ACH_checkByJavascriptBOX);
            if (paymentMethod.equalsIgnoreCase("Eurocard")) checkByJavascript(EUROCARD_checkByJavascriptBOX);
            if (paymentMethod.equalsIgnoreCase("Laser")) checkByJavascript(LASER_checkByJavascriptBOX);
            if (paymentMethod.equalsIgnoreCase("UnionPay")) checkByJavascript(UNIONPAY_checkByJavascriptBOX);
        }

    }

    /**
     * Method to select collect billing address option checkByJavascriptbox
     *
     * @param checkByJavascript value of checkByJavascript (i.e. true/false)
     */
    public void selectCollectBillingAddressOption(boolean checkByJavascript) {
        if (verifyElementDisplayed(COLLECT_BILLING_ADDRESS_checkByJavascriptBOX, 2)) {
            if (checkByJavascript)
                checkByJavascript(COLLECT_BILLING_ADDRESS_checkByJavascriptBOX);
            else
                uncheckByJavascript(COLLECT_BILLING_ADDRESS_checkByJavascriptBOX);
        }
    }

    /**
     * Method for select match zip code option
     *
     * @param checkByJavascript value of checkByJavascript (i.e. true/false)
     */
    public void selectMatchZIPCodeOption(boolean checkByJavascript) {
        if (verifyElementDisplayed(MATCH_ZIP_CODE_checkByJavascriptBOX, 2)) {
            if (checkByJavascript)
                checkByJavascript(MATCH_ZIP_CODE_checkByJavascriptBOX);
            else
                uncheckByJavascript(MATCH_ZIP_CODE_checkByJavascriptBOX);
        }
    }

    /**
     * Method for select match street number option
     *
     * @param checkByJavascript value of checkByJavascript (i.e. true/false)
     */
    public void selectMatchStreetNumberOption(boolean checkByJavascript) {
        if (verifyElementDisplayed(MATCH_STREET_NUMBER_checkByJavascriptBOX, 2)) {
            if (checkByJavascript)
                checkByJavascript(MATCH_STREET_NUMBER_checkByJavascriptBOX);
            else
                uncheckByJavascript(MATCH_STREET_NUMBER_checkByJavascriptBOX);
        }
    }

    /**
     * Method for select require AVS yes response option
     *
     * @param checkByJavascript value of checkByJavascript (i.e. true/false)
     */
    public void selectRequireAVSYesResponseOption(boolean checkByJavascript) {
        if (verifyElementDisplayed(REQUIRE_AVS_checkByJavascriptBOX, 2)) {
            if (checkByJavascript)
                checkByJavascript(REQUIRE_AVS_checkByJavascriptBOX);
            else
                uncheckByJavascript(REQUIRE_AVS_checkByJavascriptBOX);
        }
    }

    /**
     * Method for select collect CSC number option
     *
     * @param checkByJavascript value of checkByJavascript (i.e. true/false)
     */
    public void selectCollectCSCNumberOption(boolean checkByJavascript) {
        if (verifyElementDisplayed(COLLECT_CSC_NUMBER, 2)) {
            if (checkByJavascript)
                checkByJavascript(COLLECT_CSC_NUMBER);
            else
                uncheckByJavascript(COLLECT_CSC_NUMBER);
        }
    }

    /**
     * Method for select require CSC yes response option
     *
     * @param checkByJavascript value of checkByJavascript (i.e. true/false)
     */
    public void selectRequireCSCYesResponseOption(boolean checkByJavascript) {
        if (verifyElementDisplayed(REQUIRE_CSC_YES_RESPONSE, 2)) {
            if (checkByJavascript)
                checkByJavascript(REQUIRE_CSC_YES_RESPONSE);
            else
                uncheckByJavascript(REQUIRE_CSC_YES_RESPONSE);
        }
    }

    public void selectAutoEnforceCSCOption(boolean checkByJavascript) {
        if (verifyElementDisplayed(AUTOENFORCE_CSC_NUMBER, 2)) {
            if (checkByJavascript)
                checkByJavascript(AUTOENFORCE_CSC_NUMBER);
            else
                uncheckByJavascript(AUTOENFORCE_CSC_NUMBER);
        }
    }

    /**
     * Method for entering user notes
     *
     * @param userNotes value of user notes
     */
    public void enterUserNotes(String userNotes) {
        if (userNotes != null)
            type(USER_NOTES, userNotes, true);
    }

    public void enterTestPaymentUrl(String paymentUrl) {
        if (paymentUrl != null)
            type(TEST_PAYMENT_URL, paymentUrl, true);
    }

    public void enterLivePaymentUrl(String paymentUrl) {
        if (paymentUrl != null)
            type(LIVE_PAYMENT_URL, paymentUrl, true);
    }

    public void enterShaString(String shastring) {
        if (shastring != null)
            type(SHASTRING_SIGNATURE, shastring, true);
    }

    /**
     * Method for entering details of account
     *
     * @param eCommerceAccount Page object of ECommerceAccount
     */
    public void enterDetails(ECommerceAccount eCommerceAccount) throws Exception {
        enterName(eCommerceAccount.getName());
        selectOnlineProcessor(eCommerceAccount.getOnlineProcessor());
        selectCurrency(eCommerceAccount.getCurrency());
        enterExactBusinessName(eCommerceAccount.getExactBusinessName());
        enterAccountMerchantOrVendorID(eCommerceAccount.getAccountMerchantOrVendorId());
        //enterAccountPartnerID(eCommerceAccount.getAccountPartnerId());
        enterAccountUserID(eCommerceAccount.getAccountUserId());
        enterAccountPassword(eCommerceAccount.getAccountPassword());
        enterConfirmAccountPassword(eCommerceAccount.getConfirmAccountPassword());
        if (eCommerceAccount.getPaypalManagerURL() != null)
            enterPaypalManagerURL(eCommerceAccount.getPaypalManagerURL());
        checkByJavascriptPrimaryProcessingAccount(eCommerceAccount.isPrimaryProcessingAccount());
        enterSingleTransactionLimit(eCommerceAccount.getSingleTransactionLimit());
        selectAvailablePaymentMethods(eCommerceAccount.getAvailablePaymentMethods());
        selectCollectBillingAddressOption(eCommerceAccount.isCollectBillingAddress());
        selectMatchZIPCodeOption(eCommerceAccount.isMatchZipCode());
        selectMatchStreetNumberOption(eCommerceAccount.isMatchStreetNumber());
        selectRequireAVSYesResponseOption(eCommerceAccount.isRequireAVSYesResponse());
        selectCollectCSCNumberOption(eCommerceAccount.isCollectCSCNumber());
        selectRequireCSCYesResponseOption(eCommerceAccount.isRequireCSCYesResponse());
        enterUserNotes(eCommerceAccount.getUserNotes());
    }

    public void selectBINRadiobutton(String value) {
        String xpath = "//label[text()='BIN']//following-sibling::div//input[@value='" + value + "']";
        WebElement element = browser.findElement(By.xpath(xpath));
        clickByJavaScript(element);
        logReport("Selected bin radiobutton value " + value);

    }

    public void fillAccountDetailsForProcessorTypes(ECommerceAccount eCommerceAccount, String processorType) throws Exception {
        enterName(eCommerceAccount.getName());
        selectOnlineProcessor(eCommerceAccount.getOnlineProcessor());
        Thread.sleep(2000);
        enterExactBusinessName(eCommerceAccount.getExactBusinessName());
        enterAccountMerchantOrVendorID(eCommerceAccount.getAccountMerchantOrVendorId());
        enterAccountPartnerID(eCommerceAccount.getAccountPartnerId(), processorType);
        enterAccountUserID(eCommerceAccount.getAccountUserId());
        enterAccountPassword(eCommerceAccount.getAccountPassword());
        checkByJavascriptPrimaryProcessingAccount(eCommerceAccount.isPrimaryProcessingAccount());
        enterSingleTransactionLimit(eCommerceAccount.getSingleTransactionLimit());
        selectAvailablePaymentMethodsTest(eCommerceAccount.getAvailablePaymentMethods());
        selectCollectBillingAddressOption(eCommerceAccount.isCollectBillingAddress());
        selectMatchZIPCodeOption(eCommerceAccount.isMatchZipCode());
        selectMatchStreetNumberOption(eCommerceAccount.isMatchStreetNumber());
        selectRequireAVSYesResponseOption(eCommerceAccount.isRequireAVSYesResponse());
        selectCollectCSCNumberOption(eCommerceAccount.isCollectCSCNumber());
        selectRequireCSCYesResponseOption(eCommerceAccount.isRequireCSCYesResponse());
        enterUserNotes(eCommerceAccount.getUserNotes());
        checkByJavascriptAccountForAccessibility(eCommerceAccount.isAccountAccessibility());
        if (processorType.equalsIgnoreCase("Chase Orbital")) {
            selectCurrency(eCommerceAccount.getCurrency());
            selectBINRadiobutton(eCommerceAccount.getBin());

        }
        if (processorType.equalsIgnoreCase("Card Connect")) {
            selectCurrency(eCommerceAccount.getCurrency());
            enterTestPaymentUrl(eCommerceAccount.getTestPaymentUrl());
            enterLivePaymentUrl(eCommerceAccount.getLivePaymentUrl());
            selectAutoEnforceCSCOption(eCommerceAccount.isAutoEnforceCsc());
        }
        if (processorType.equalsIgnoreCase("Stripe")) {
            selectCurrency(eCommerceAccount.getCurrency());
            selectAutoEnforceCSCOption(eCommerceAccount.isAutoEnforceCsc());
            enterPaypalManagerURL(eCommerceAccount.getPaypalManagerURL());
            //password field not exist
        }
        if (processorType.equalsIgnoreCase("Merchant Link")) {
            selectCurrency(eCommerceAccount.getCurrency());
            selectAutoEnforceCSCOption(eCommerceAccount.isAutoEnforceCsc());
            //user id not exist
        }
        if (processorType.equalsIgnoreCase("EPX")) {
            selectCurrency(eCommerceAccount.getCurrency());
            enterPaypalManagerURL(eCommerceAccount.getPaypalManagerURL());
            selectAutoEnforceCSCOption(eCommerceAccount.isAutoEnforceCsc());
        }
        if (processorType.equalsIgnoreCase("CASHNet")) {
            enterPaypalManagerURL(eCommerceAccount.getPaypalManagerURL());
            enterConfirmAccountPassword(eCommerceAccount.getConfirmAccountPassword());
            enterLivePaymentUrl(eCommerceAccount.getLivePaymentUrl());
            //collect billing address and collect csc number
        }
        if (processorType.equalsIgnoreCase("TouchNet")) {
            selectCurrency(eCommerceAccount.getCurrency());
            enterTestPaymentUrl(eCommerceAccount.getTestPaymentUrl());
            enterLivePaymentUrl(eCommerceAccount.getLivePaymentUrl());
            //collect billing address and collect csc number
        }
        if (processorType.equalsIgnoreCase("DPS")) {
            selectCurrency(eCommerceAccount.getCurrency());
            enterPaypalManagerURL(eCommerceAccount.getPaypalManagerURL());
            enterConfirmAccountPassword(eCommerceAccount.getConfirmAccountPassword());
            enterTestPaymentUrl(eCommerceAccount.getTestPaymentUrl());
            enterLivePaymentUrl(eCommerceAccount.getLivePaymentUrl());
            selectAutoEnforceCSCOption(eCommerceAccount.isAutoEnforceCsc());

        }
        if (processorType.equalsIgnoreCase("SecurePay")) {
            selectCurrency(eCommerceAccount.getCurrency());
            enterPaypalManagerURL(eCommerceAccount.getPaypalManagerURL());
            enterConfirmAccountPassword(eCommerceAccount.getConfirmAccountPassword());
            enterTestPaymentUrl(eCommerceAccount.getTestPaymentUrl());
            enterLivePaymentUrl(eCommerceAccount.getLivePaymentUrl());
            selectAutoEnforceCSCOption(eCommerceAccount.isAutoEnforceCsc());
            //collect csc and require csc yes
        }
        if (processorType.equalsIgnoreCase("Realex")) {
            selectCurrency(eCommerceAccount.getCurrency());
            enterConfirmAccountPassword(eCommerceAccount.getConfirmAccountPassword());
            enterAccountPartnerIDConfirm(eCommerceAccount.getAccountPartnerIdConfirm());
            enterLivePaymentUrl(eCommerceAccount.getLivePaymentUrl());
            enterPaypalManagerURL(eCommerceAccount.getPaypalManagerURL());
            selectAutoEnforceCSCOption(eCommerceAccount.isAutoEnforceCsc());
        }
        if (processorType.equalsIgnoreCase("WorldPay")) {
            selectCurrency(eCommerceAccount.getCurrency());
            enterConfirmAccountPassword(eCommerceAccount.getConfirmAccountPassword());
            selectAutoEnforceCSCOption(eCommerceAccount.isAutoEnforceCsc());
        }
        if (processorType.equalsIgnoreCase("Authorize.Net")) {
            selectCurrency(eCommerceAccount.getCurrency());
            enterPaypalManagerURL(eCommerceAccount.getPaypalManagerURL());
            enterTestPaymentUrl(eCommerceAccount.getTestPaymentUrl());
            enterLivePaymentUrl(eCommerceAccount.getLivePaymentUrl());
            //collect billing address and csc number
        }
        if (processorType.equalsIgnoreCase("Cybersource")) {
            selectCurrency(eCommerceAccount.getCurrency());
            enterConfirmAccountPassword(eCommerceAccount.getConfirmAccountPassword());
            enterTestTransaction(eCommerceAccount.getAccountPartnerId());
            enterPaypalManagerURL(eCommerceAccount.getPaypalManagerURL());
            selectAutoEnforceCSCOption(eCommerceAccount.isAutoEnforceCsc());
        }
        if (processorType.equalsIgnoreCase("Pay.gov")) {
            enterConfirmAccountPassword(eCommerceAccount.getConfirmAccountPassword());
            selectAutoEnforceCSCOption(eCommerceAccount.isAutoEnforceCsc());
        }
        if (processorType.equalsIgnoreCase("QuikPay")) {
            enterTestPaymentUrl(eCommerceAccount.getTestPaymentUrl());
            enterPaypalManagerURL(eCommerceAccount.getPaypalManagerURL());
            enterLivePaymentUrl(eCommerceAccount.getLivePaymentUrl());
            enterConfirmAccountPassword(eCommerceAccount.getConfirmAccountPassword());
            //collect billing address and csc number
        }
        if (processorType.equalsIgnoreCase("Ogone")) {
            selectCurrency(eCommerceAccount.getCurrency());
            enterConfirmAccountPassword(eCommerceAccount.getConfirmAccountPassword());
            enterShaString(eCommerceAccount.getShaString());
            selectAutoEnforceCSCOption(eCommerceAccount.isAutoEnforceCsc());
        }
        if (processorType.equalsIgnoreCase("PayPal")) {

            enterConfirmAccountPassword(eCommerceAccount.getConfirmAccountPassword());
            enterPaypalManagerURL(eCommerceAccount.getPaypalManagerURL());
            selectAutoEnforceCSCOption(eCommerceAccount.isAutoEnforceCsc());
        }


    }
}
