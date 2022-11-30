package pageObjects.Forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.CreditCardData;

import javax.naming.ConfigurationException;

public class FormPreviewPaymentPage extends CommonActionsPage {
    @FindBy(xpath = "//input[@id='ccTransaction']")
    public WebElement RADIO_BUTTON_CREDIT_CARD;
    @FindBy(xpath = "//select[@name='cardtype']")
    public WebElement DROPDOWN_CARD_TYPE;
    @FindBy(xpath = "//input[@name='cardholder']")
    public WebElement TEXTBOX_NAME;
    @FindBy(xpath = "//input[@name='cardnumber']")
    public WebElement TEXTBOX_CARD_NUMBER;
    @FindBy(xpath = "//select[@id='cardxpmonth']")
    public WebElement DROPDOWN_CARD_EXPIRY_MONTH;
    @FindBy(xpath = "//select[@id='pmt_cc_exp_date']")
    public WebElement DROPDOWN_CARD_EXPIRY_YEAR;
    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement BUTTON_CONTINUE;
    @FindBy(xpath = "//input[@id='refund_cc_pmt_mtd_id']")
    public WebElement CHECKBOX_REFUND_CREDIT_CARD;
    @FindBy(xpath = "//input[@value='Continue to Cancel']")
    public WebElement CONTINUE_TO_CANCEL_BUTTON;

    @FindBy(xpath = "//input[@id='pmt_cc_csc']")
    public WebElement CSC_NUMBER;


    public FormPreviewPaymentPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    private void selectCreditCardRadioButton() throws Exception {
        VerifyPageReady(30);
        Wait(RADIO_BUTTON_CREDIT_CARD, 20);
        click(RADIO_BUTTON_CREDIT_CARD);
        logReport("Credit card radio button selected.");

    }

    private void selectCardType(String cardType) throws Exception {
        Wait(DROPDOWN_CARD_TYPE, 20);
        select(DROPDOWN_CARD_TYPE, cardType);
        logReport("value: '" + cardType + "' is selected in card type dropdown.");

    }

    private void enterCardName(String cardName) throws Exception {
        Wait(TEXTBOX_NAME, 20);
        type(TEXTBOX_NAME, cardName, true);
        logReport("entered value '" + cardName + "' in textbox.");

    }

    private void enterCardNumber(String cardNumber) throws Exception {
        Wait(TEXTBOX_CARD_NUMBER, 20);
        type(TEXTBOX_CARD_NUMBER, cardNumber);
        logReport("entered value '" + cardNumber + "' in textbox.");

    }

    private void selectExpiryMonth(String endMonth) throws Exception {
        Wait(DROPDOWN_CARD_EXPIRY_MONTH, 30);
        select(DROPDOWN_CARD_EXPIRY_MONTH, endMonth);
        logReport("value: '" + endMonth + "' is selected in expiry month dropdown.");

    }

    private void selectExpiryYear(String endYear) throws Exception {
        Wait(DROPDOWN_CARD_EXPIRY_YEAR, 20);
        select(DROPDOWN_CARD_EXPIRY_YEAR, endYear);
        logReport("value: '" + endYear + "' is selected in expiry year dropdown.");

    }

    public void enterCscNumber(String csc) throws Exception {
        Wait(CSC_NUMBER, 20);
        type(CSC_NUMBER, csc);
        logReport("value: '" + csc + "' number.");

    }
    public void fillCreditCardDetails(CreditCardData creditCardData) throws Exception {
        selectCreditCardRadioButton();
        selectCardType(creditCardData.getCardType());
        enterCardName(creditCardData.getCardName());
        enterCardNumber(creditCardData.getCardNumber());
        selectExpiryMonth(creditCardData.getCardExpiryMonth());
        selectExpiryYear(creditCardData.getCardExpiryYear());
    }

    public FormPreviewConfirmPage clickContinueButton() throws Exception {
        Wait(BUTTON_CONTINUE, 30);
        click(BUTTON_CONTINUE);
        logReport("Clicked on continue button.");
        VerifyPageReady(30);
        return new FormPreviewConfirmPage(browser);
    }


}
