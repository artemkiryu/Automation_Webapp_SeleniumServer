package pageObjects.Forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;


/**
 * Created by infoobjects on 23-08-2017.
 */
public class PaymentPage extends CommonActionsPage {

    public PaymentPage(WebDriver driver) throws ConfigurationException{
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='form_process_online']")
    public WebElement FORM_PROCESS_ONLINE;

    @FindBy(xpath = "//select[@id='PKProc_AcntID']")
    public WebElement PAYMENT_PROCESSING_DROPDOWN;

    @FindBy(xpath = "//input[@id='flgCheckPmtReceived']")
    public WebElement CHECK_PAYMENT_RCVD;



    public void checkFormProcessOnline() throws Exception {
        Wait(FORM_PROCESS_ONLINE, 20);
        checkByJavascript(FORM_PROCESS_ONLINE);
    }

    public void checkPaymentReceivedChk() throws Exception {
        Wait(CHECK_PAYMENT_RCVD, 20);
        checkByJavascript(CHECK_PAYMENT_RCVD);
        logReport("Checkbox payment received checked");
    }

    public void selectPaymentType(String paymentType) {
        select(PAYMENT_PROCESSING_DROPDOWN, "USD-" + paymentType);
        logReport("Selected payment processing value");
    }
    public String getPaymentProcessingValue() {
        return getSelectedOption(FORM_PROCESS_ONLINE);
    }

    public boolean isPaymenyProcessorValue(String processorName) {
        return verifyElementDisplayed(By.xpath("//td[text()='Online Processor:']/..//td[contains(text(),'" + processorName + "')]"), 10);

    }

}
