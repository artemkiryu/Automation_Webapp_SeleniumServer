package pageObjects.Forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddFormQuestionsData;
import pojo.SectionHeader;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 22-08-2017.
 */
public class QuestionsPage extends CommonActionsPage {

    @FindBy(xpath = "//div[contains(.,'Questions Sections')]/button[text()='Add New']")
    public WebElement ADD_NEW_QUESTION_SECTIONS_BUTTON;
    @FindBy(xpath = "//input[@name='questionName']")
    public static WebElement EVENT_QUESTION_NAME;

    public QuestionsPage(WebDriver driver) throws ConfigurationException{
        PageFactory.initElements(driver, this);
    }

    public void fillQuestionPageDetails(SectionHeader sectionHeaderData, AddFormQuestionsData addFormQuestionsData) throws Exception {
         Wait(SAVE_BUTTON_FORM, 30);
        VerifyAjaxRequestsFinished(30);
        fillSectionHeaderDetails(sectionHeaderData);
        enterEventQuestionName(addFormQuestionsData.getQuestionSectionName());

    }

    public void enterEventQuestionName(String eventQuestionName) throws Exception {
        Wait(EVENT_QUESTION_NAME, 30);
        type(EVENT_QUESTION_NAME, eventQuestionName, true);
        logReport("Entered Value: " + eventQuestionName + " in 'event question Name' TextBox");
    }
}

