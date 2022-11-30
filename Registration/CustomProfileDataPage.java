package pageObjects.Registration;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.CustomQuestionData;
import pojo.CustomQuestionDataSelect;

/**
 * Created by infoobjects on 8/3/2017.
 */
public class CustomProfileDataPage extends CommonActionsPage {

    @FindBy(xpath = "//button[text()='Add New']")
    public WebElement ADD_NEW_BUTTON;
    @FindBy(xpath = "//select[@id = 'que_frn_que_typ_id']")
    public WebElement QUESTION_TYPE_DROPDWON;
    @FindBy(xpath = "//iframe[@id='certainModaliFrame']")
    public WebElement QUESTIONS_FRAME;
    @FindBy(xpath = "//input[@name='que_name']")
    public WebElement NAME_TEXTBOX;
    @FindBy(xpath = "//input[@name='que_code']")
    public WebElement CODE_TEXTBOX;
    @FindBy(xpath = "//input[@name='que_label']")
    public WebElement DISPLAY_REG_FORM;
    @FindBy(xpath = "//input[@name='que_error_message']")
    public WebElement ERROR_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//textarea[@id='que_answers']")
    public WebElement ANSWER_OPTIONS_TEXTAREA;
    @FindBy(xpath = "//select[@id='que_is_req']")
    public WebElement SHOW_ONLINE_DROPDOWN;
    @FindBy(xpath = "//input[@id='que_default']")
    public WebElement QUESTION_ANSWER_TEXT;
    //@FindBy(xpath = "//textarea[@id='que_answers']")
    @FindBy(xpath = "//textarea[@id='que_default']")
    public WebElement QUESTION_ANSWER_TEXTAREA;

    @FindBy(xpath = "//textarea[@id='que_answers']")
    public WebElement QUESTION_ANSWER_TEXTAREA2;
    @FindBy(xpath = "//select[@name = 'queFont']")
    public WebElement QUESTION_FONT_DROPDOWN;
    @FindBy(xpath = "//select[@name = 'queAlign']")
    public WebElement QUESTION_FONT_HORIZONTAL_DROPDOWN;
    @FindBy(xpath = "//select[@name = 'queVAlign']")
    public WebElement QUESTION_FONT_VERTICAL_DROPDOWN;
    @FindBy(xpath = "//select[@name = 'ansFont']")
    public WebElement ANSWER_FONT_DROPDWON;
    @FindBy(xpath = "//select[@name = 'ansAlign']")
    public WebElement ANSWER_FONT_HORIZONTAL_DROPDWON;
    @FindBy(xpath = "//select[@name = 'ansVAlign']")
    public WebElement ANSWER_FONT_VERTICAL_DROPDWON;
    @FindBy(xpath = "//input[@id ='submitAndClose']")
    public WebElement SAVEANDCLOSE_BUTTON;

    @FindBy(xpath = "//div[@id='CustomRegistrationQuestionsId']//button")
    public WebElement ADD_NEW_CUSTOM_REG_QUES_BUTTON;

    public CustomProfileDataPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void clickOnAddNewButton()throws Exception{
        VerifyPageReady(30);
        // Wait(ADD_NEW_BUTTON, 30);
        click(ADD_NEW_BUTTON);
        logReport("Successfully clicked on 'Add New' button.");
        switchToLatestTabOrWindow();
    }

    public void clickOnAddNewCustomRegQuesButton() throws Exception {
        VerifyPageReady(30);
        click(ADD_NEW_CUSTOM_REG_QUES_BUTTON);
        logReport("Successfully clicked on custom registration question's 'Add New' button.");
        switchToLatestTabOrWindow();
    }

    private void selectQuestionType(String questionType) throws Exception{
        select(QUESTION_TYPE_DROPDWON, questionType);
        VerifyAngularHasFinishedProcessing(30);
        logReport("Successfully selected value :" + questionType + " in 'Question Type' dropdown.");
    }

    private void enterName(String questionName) throws Exception{
        type(NAME_TEXTBOX, questionName);
        logReport("Successfully entered value "+questionName+" in name textbox.");
    }

    private void enterCode(String questionCode) throws Exception{
        type(CODE_TEXTBOX, questionCode);
        logReport("Successfully entered value " + questionCode + " in code textbox.");
    }

    private void enterDisplayRegForm(String displayRegForm) throws Exception{
        type(DISPLAY_REG_FORM, displayRegForm);
        logReport("Successfully entered value " + displayRegForm + " in display reg form textbox.");
    }

    private void enterErrorMessage(String message) throws Exception{
        type(ERROR_MESSAGE_TEXTBOX, message);
        logReport("Successfully entered value "+message+" in error message textbox.");
    }

    private void enterAnswerOptions(String answerOptions) throws Exception{
        String[] answerOptionsArray = answerOptions.split(",");
        String text = "";
        for (int i = 0; i < answerOptionsArray.length; i++) {
            text = text + answerOptionsArray[i] + Keys.RETURN;
            //webDriver.type(By.id(ADD_NEW_ANSWER_OPTIONS_TEXTAREA), answerOptionsArray[i]+Keys.RETURN+);
            // webDriver.findElement(By.id(ADD_NEW_ANSWER_OPTIONS_TEXTAREA)).sendKeys(Keys.RETURN);
        }
        type(QUESTION_ANSWER_TEXTAREA2, text);
        logReport("Successfully selected value: " + text + " from Question Answer dropdown.");
    }

    private void selectQuestionFont(String value) throws Exception {
        select(QUESTION_FONT_DROPDOWN, value);
        logReport("Successfully selected value: " + value + " from Question font dropdown.");
    }

    private void selectQuestionHorizontalFont(String value)throws Exception{
        select(QUESTION_FONT_HORIZONTAL_DROPDOWN, value);
        logReport("Successfully selected value: "+value+" from Question font horizontal dropdown.");
    }

    private void selectQuestionVerticalFont(String value)throws Exception{
        select(QUESTION_FONT_VERTICAL_DROPDOWN, value);
        logReport("Successfully selected value: "+value+" from Question font vertical dropdown.");
    }

    private void selectAnswerFont(String value)throws Exception{
        select(ANSWER_FONT_DROPDWON, value);
        logReport("Successfully selected value: "+value+" from Answer font dropdown.");
    }

    private void selectAnswerHorizontalFont(String value)throws Exception{
        select(ANSWER_FONT_HORIZONTAL_DROPDWON, value);
        logReport("Successfully selected value: "+value+" from Answer font horizontal dropdown.");
    }

    private void selectAnswerVerticalFont(String value)throws Exception{
        select(ANSWER_FONT_VERTICAL_DROPDWON, value);
        logReport("Successfully selected value: "+value+" from Answer font vertical dropdown.");
    }


    private void enterAnswerOption(String questionType, String answerOptions) throws Exception {
        String[] answerOptionsArray = answerOptions.split(",");
        String text = "";
        for (int i = 0; i < answerOptionsArray.length; i++) {
            text = text + answerOptionsArray[i] + Keys.RETURN;
            //webDriver.type(By.id(ADD_NEW_ANSWER_OPTIONS_TEXTAREA), answerOptionsArray[i]+Keys.RETURN+);
            // webDriver.findElement(By.id(ADD_NEW_ANSWER_OPTIONS_TEXTAREA)).sendKeys(Keys.RETURN);
        }
        if (questionType.equalsIgnoreCase("Text")) {
            type(QUESTION_ANSWER_TEXT, text);
            logReport("Successfully entered text value: " + text + " from Question Answer dropdown.");

        } else if (questionType.equalsIgnoreCase("Textarea")) {
            // scrollIntoView(QUESTION_ANSWER_TEXTAREA);
            type(QUESTION_ANSWER_TEXTAREA, text);
            logReport("Successfully entered textarea value: " + text + " from Question Answer dropdown.");
        } else {
            // scrollIntoView(QUESTION_ANSWER_TEXTAREA2);
            type(QUESTION_ANSWER_TEXTAREA2, text);
            logReport("Successfully entered except text/textarea value: " + text + " from Question Answer dropdown.");
        }
    }

    public void switchToIframe() {
        browser.switchTo().frame(QUESTIONS_FRAME);
        logReport("Questions swicthed successfully to iframe");
    }

    public void fillCustomQuestionDetails(CustomQuestionData customQuestionData)throws Exception{
        if (verifyElementDisplayed(QUESTIONS_FRAME, 30)) {
            switchToIframe();
            selectQuestionType(customQuestionData.getQuestionType());
            enterName(customQuestionData.getName());
            enterCode(customQuestionData.getCode());
            enterDisplayRegForm(customQuestionData.getDisplayRegForm());
            enterErrorMessage(customQuestionData.getErrorMessage());
            // enterAnswerOptions(customQuestionData.getAnswerOptions());
            enterAnswerOption(customQuestionData.getQuestionType(), customQuestionData.getDefaultAnswer());
            Thread.sleep(3000);
            clickSaveAndClose();
            browser.switchTo().defaultContent();
        } else {
            selectQuestionType(customQuestionData.getQuestionType());
            enterName(customQuestionData.getName());
            enterCode(customQuestionData.getCode());
            enterDisplayRegForm(customQuestionData.getDisplayRegForm());
            enterErrorMessage(customQuestionData.getErrorMessage());
            //enterAnswerOptions(customQuestionData.getAnswerOptions());
            enterAnswerOption(customQuestionData.getQuestionType(), customQuestionData.getDefaultAnswer());
            clickSaveAndClose();
        }

    }

    public void fillCustomQuestionDetails(CustomQuestionDataSelect customQuestionData) throws Exception {
        if (verifyElementDisplayed(QUESTIONS_FRAME, 30)) {
            switchToIframe();
            selectQuestionType(customQuestionData.getQuestionType());
            wait(2);
            enterName(customQuestionData.getName());
            enterCode(customQuestionData.getCode());
            enterDisplayRegForm(customQuestionData.getDisplayRegForm());
            enterErrorMessage(customQuestionData.getErrorMessage());
            enterAnswerOptions(customQuestionData.getAnswerOptions());
            clickSaveAndClose();
            browser.switchTo().defaultContent();
        } else {
            selectQuestionType(customQuestionData.getQuestionType());
            wait(2);
            enterName(customQuestionData.getName());
            enterCode(customQuestionData.getCode());
            enterDisplayRegForm(customQuestionData.getDisplayRegForm());
            enterErrorMessage(customQuestionData.getErrorMessage());
            enterAnswerOptions(customQuestionData.getAnswerOptions());
            clickSaveAndClose();
        }
    }

    /**
     * Method to click on Save and close button.
     *
     * @return : CustomRegistrationQuestionsPage
     * @throws Exception
     */
    public void clickSaveAndClose() throws Exception {
        click(SAVEANDCLOSE_BUTTON);
        // waitForWindowToDispose();
        logReport("Save and close button clicked successfully");
        //switchToLatestTabOrWindow();
        Thread.sleep(2000);

    }

}
