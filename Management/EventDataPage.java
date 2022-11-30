package pageObjects.Management;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.EventQuestionData;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 30-08-2017.
 */
public class EventDataPage extends CommonActionsPage {

    @FindBy(xpath = "//div[contains(.,'Custom questions for all Events in this Account')]/button[text()='Add New']")
    public WebElement EVENT_QUESTION_ADD_NEW_BUTTON;

    //Question IFrame
    @FindBy(xpath = "//select[@id = 'que_frn_que_typ_id']")
    public WebElement QUESTION_TYPE_DROPBOX;
    @FindBy(xpath = "//input[@name = 'que_name']")
    public WebElement NAME_TEXTBOX;
    @FindBy(xpath = "//input[@name = 'que_code']")
    public WebElement CODE_TEXTBOX;
    @FindBy(xpath = "//input[@name = 'que_label']")
    public WebElement DISPLAY_TEXTBOX;
    @FindBy(xpath = "//input[@name = 'que_error_message']")
    public WebElement ERROR_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@id='que_default']")
    public WebElement SETDEFAULT_ANSWER_TEXTBOX;
    @FindBy(xpath = "//input[@id ='submitAndClose']")
    public WebElement SAVEANDCLOSE_BUTTON;
    @FindBy(xpath = "//input[@id = 'que_size']")
    public WebElement SIZE_INPUT_TEXTBOX;
    @FindBy(xpath = "//input[@id = 'que_min']")
    public WebElement MIN_TEXTBOX;
    @FindBy(xpath = "//input[@id = 'que_max']")
    public WebElement MAX_TEXTBOX;
    @FindBy(xpath = "//input[@id = 'que_default']")
    public WebElement QUESTION_TEXTBOX;
    @FindBy(xpath = "//select[@id = 'que_is_req']")
    public WebElement SHOW_ONLINE_DROPDOWN;
    @FindBy(xpath = "//select[@name = 'queAnsAlign']")
    public WebElement QUESTION_ANSWER_DROPDOWN;
    @FindBy(xpath = "//select[@name = 'queFont']")
    public WebElement QUESTION_FONT_DROPDOWN;
    @FindBy(xpath = "//select[@name = 'queAlign']")
    public WebElement QUESTION_FONT_HORIZONTAL_DROPDOWN;
    @FindBy(xpath = "//select[@name = 'queVAlign']")
    public WebElement QUESTION_FONT_VERTICAL_DROPDOWN;
    @FindBy(xpath = "//select[@name = 'ansFont']")
    public WebElement ANSWER_FONT_DROPDOWN;
    @FindBy(xpath = "//select[@name = 'ansAlign']")
    public WebElement ANSWER_FONT_HORIZONTAL_DROPDOWN;
    @FindBy(xpath = "//select[@name = 'ansVAlign']")
    public WebElement ANSWER_FONT_VERTICAL_DROPDOWN;

    public EventDataPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void createQuestionOfTypeText(EventQuestionData eventQuestionData) throws Exception {
        switchToFrame();
        Wait(SAVEANDCLOSE_BUTTON, 30);
        select(QUESTION_TYPE_DROPBOX, eventQuestionData.getQuestionType());
        Thread.sleep(1000);
        type(NAME_TEXTBOX, eventQuestionData.getName());
        type(CODE_TEXTBOX, eventQuestionData.getCode());
        type(DISPLAY_TEXTBOX, eventQuestionData.getDisplay());
        type(ERROR_MESSAGE_TEXTBOX, eventQuestionData.getErrorMessage());
        // type(SIZE_INPUT_TEXTBOX, eventQuestionData.getInputSize());
        type(MIN_TEXTBOX, eventQuestionData.getMinChar());
        // type(MAX_TEXTBOX, eventQuestionData.getMaxChar());
        type(SETDEFAULT_ANSWER_TEXTBOX, eventQuestionData.getDefaultAnswer());
        select(SHOW_ONLINE_DROPDOWN, eventQuestionData.getShowOnline());
        select(QUESTION_ANSWER_DROPDOWN, eventQuestionData.getQuestionAnswer());
        select(QUESTION_FONT_DROPDOWN, eventQuestionData.getQuestionFont());
        select(ANSWER_FONT_DROPDOWN, eventQuestionData.getAnswerFont());
        select(QUESTION_FONT_HORIZONTAL_DROPDOWN, eventQuestionData.getHorizontalQuestion());
        select(ANSWER_FONT_HORIZONTAL_DROPDOWN, eventQuestionData.getHorizontalAnswers());
        select(QUESTION_FONT_VERTICAL_DROPDOWN, eventQuestionData.getVerticalQuestion());
        select(ANSWER_FONT_VERTICAL_DROPDOWN, eventQuestionData.getVerticalAnswer());
        clickSaveAndClose();
    }

    public void clickSaveAndClose() throws Exception {
        click(SAVEANDCLOSE_BUTTON);
        waitForWindowToDispose();
        logReport("Save and close button clicked successfully");
        switchTo().defaultContent();
        switchToLatestTabOrWindow();

    }

    private void switchToFrame() {
        switchTo().frame("certainModaliFrame");
    }

    public void clickAddNewBtn() throws Exception {
        VerifyPageReady(30);
        Wait(EVENT_QUESTION_ADD_NEW_BUTTON, 30);
        click(EVENT_QUESTION_ADD_NEW_BUTTON);
        logReport("Successfully clicked on 'Add New' button.");
        Thread.sleep(30);
        switchToFrame();
        switchToLatestTabOrWindow();

    }
}
