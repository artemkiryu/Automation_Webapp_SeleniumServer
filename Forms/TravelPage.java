package pageObjects.Forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddFormTravelData;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 23-08-2017.
 */
public class TravelPage extends CommonActionsPage {

    @FindBy(xpath = "//select[@name='queAndAty']//option[contains(text(), 'Text - Travel Request Confirmation')]")
    public WebElement TRAVEL_CUSTOM_QUESTION;
    @FindBy(xpath = "//input[@title='Move Selected Item(s) to the Right']")
    public WebElement MOVE_RIGHT_BUTTON;
    @FindBy(xpath = "//select[@id='FormTravelQueIds']")
    public WebElement SHOW_ONLINE;

    public TravelPage(WebDriver driver) throws ConfigurationException{
        PageFactory.initElements(driver, this);
    }

    public void selectTravelCustomQuestion(String travelQuestionName) throws Exception {
        String xpath = "//select[@name='queAndAty']//option[contains(text(), '" + travelQuestionName + "')]";
        browser.findElement(By.xpath(xpath)).click();
        VerifyPageReady(30);
        click(MOVE_RIGHT_BUTTON);
        logReport("Selected Travel Question: " + travelQuestionName + " in 'Travel Custom question' TextArea");
    }

    public void fillFormTravelDetails(AddFormTravelData addFormTravelData) throws Exception {
        Wait(CommonActionsPage.SAVE_BUTTON, 30);
        VerifyAjaxRequestsFinished(30);
        selectTravelCustomQuestion(addFormTravelData.getTravelQuestionName());
    }
}
