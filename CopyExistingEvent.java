package pageObjects;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CopyExistingEvent extends CommonActionsPage {
    @FindBy(xpath = "//input[@id='wzdNextBtn']")
    public WebElement nextButton;

    @FindBy(xpath = "//input[@id='wzdFinishBtn']")
    public WebElement finishButton;

    @FindBy(xpath = "//span[text()='The event has been copied!']")
    public WebElement copiedEventText;


    @FindBy(xpath = "//iframe[@id='bufferPreview']")
    public WebElement iframeBuffer;

    @FindBy(xpath = "//input[@id='wzdEventCode']")
    public WebElement eventCodeTextbox;

    @FindBy(xpath = "//input[@id='wzdLocNameCode']")
    public WebElement uniqueCodeTextbox;

    @FindBy(xpath = "//input[@id='wzdLocName']")
    public WebElement nameTextbox;

    @FindBy(xpath = "//input[@id='wzdConName']")
    public WebElement nameContactTextbox;

    @FindBy(xpath = "//input[@id='wzdConEmail']")
    public WebElement emailTextbox;

    @FindBy(xpath = "//input[@id='wzdLocAdrLine1']")
    public WebElement streetAddressTextbox;


    public CopyExistingEvent(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void switchToBuffer() {
        browser.switchTo().frame(iframeBuffer);
    }

    public void clickNextButton() throws Exception {
        Wait(nextButton, 20);
        clickByJavaScript(nextButton);
        logReport("Next button clicked successfully");
        VerifyAjaxRequestsFinished(30);
        VerifyPageReady(30);
        Thread.sleep(2000);
    }

    public void enterEventCode(String eventcode) {
        type(eventCodeTextbox, eventcode, true);
        logReport("Entered event code value " + eventcode);
    }

    public void fillLocationInfo(String uniqueCode, String name, String address) {
        type(uniqueCodeTextbox, uniqueCode+generateRandomNumber(4), true);
        type(nameTextbox, name, true);
        type(streetAddressTextbox, address, true);
    }

    public void fillRegistrationContact(String name, String email) {
        type(nameContactTextbox, name, true);
        type(emailTextbox, email, true);
    }

    public void clickFinishButton() throws Exception {
        Wait(finishButton, 20);
        clickByJavaScript(finishButton);
        logReport("Finish button clicked successfully");
        //VerifyAjaxRequestsFinished(30);
        //VerifyPageReady(30);
    }
    public boolean isCopiedTextFound(){
        return verifyElementDisplayed(copiedEventText,60);
    }
}
