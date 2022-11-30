package pageObjects.Forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;

public class FormPreviewConfirmPage extends CommonActionsPage {
    public FormPreviewConfirmPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public String getPaymentReceivedValue(String paymentDetail) throws Exception {
        VerifyPageReady(30);
        String xpath = "//font[text()='Payments']/../..//following-sibling::tr//td[2]//font[text()='" + paymentDetail + "']/../following-sibling::td[1]//font";
        verifyElementDisplayed(By.xpath(xpath), 20);
        return browser.findElement(By.xpath(xpath)).getText().trim();
    }
}
