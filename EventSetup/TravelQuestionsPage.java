package pageObjects.EventSetup;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.CustomQuestionData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by infoobjects on 8/18/2017.
 */
public class TravelQuestionsPage extends CommonActionsPage {
    public TravelQuestionsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[contains(.,'Custom Travel Questions')]/button[text()='Add New']")
    public WebElement ADD_NEW_BUTTON;
    @FindBy(xpath = "//select[@id = 'que_frn_que_typ_id']")
    public WebElement QUESTION_TYPE_DROPDWON;
    @FindBy(xpath = "//iframe[@id='certainModaliFrame']")
    public WebElement iframe;
    @FindBy(xpath = "//input[@name='que_name']")
    public WebElement NAME_TEXTBOX;
    @FindBy(xpath = "//input[@name='que_code']")
    public WebElement CODE_TEXTBOX;
    @FindBy(xpath = "//input[@name='que_label']")
    public WebElement DISPLAY_REG_FORM;
    @FindBy(xpath = "//input[@name='que_error_message']")
    public WebElement ERROR_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@id = 'que_size']")
    public WebElement INPUT_SIZE_TEXTBOX;
    @FindBy(xpath = "//input[@id = 'que_min']")
    public WebElement MINIMUM_CHARACTER_TEXTBOX;
    @FindBy(xpath = "//input[@id = 'que_max']")
    public WebElement MAXIMUM_CHARACTER_TEXTBOX;
    @FindBy(xpath = "//input[@name='que_default']")
    public WebElement DEFAULT_ANSWER;
    @FindBy(xpath = "//select[@id='que_is_req']")
    public WebElement SHOW_ONLINE_DROPDOWN;
    @FindBy(xpath = "//select[@name = 'queAnsAlign']]")
    public WebElement QUESTION_ANSWER_DROPDOWN;
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
    @FindBy(id = "queClass")
    public WebElement CLASS_TEXTBOX;
    @FindBy(xpath = "//input[@id='submitAndClose']")
    public static WebElement SAVE_BUTTON;
    @FindBy(xpath = "//select[@name = 'ansGlobalAlign']")
    public WebElement MULTIPLE_ANSWER_DROPDOWN;
    @FindBy(xpath = "//select[@name = 'ansGlobalOrder']")
    public WebElement ANSWER_ORDER_DROPDOWN;
    @FindBy(id = "que_answers")
    public WebElement ANSWER_OPTION_TEXTAREA;
    @FindBy(xpath = "//div[contains(.,'Question Headers')]/button[text()='Add New']")
    public WebElement ADD_NEW_QUESTION_HEADER_BUTTON;
    @FindBy(xpath = "//select[@name = 'que_name']")
    public WebElement TITLE_TEXTBOX;
    @FindBy(xpath = "//select[@name = 'que_code']")
    public WebElement HEADER_NAME_TEXTBOX;


    public void clickOnAddNewButton()throws Exception{
        VerifyPageReady(30);
        Wait(ADD_NEW_BUTTON, 30);
        click(ADD_NEW_BUTTON);
        logReport("Successfully clicked on 'Add New' button.");
        Thread.sleep(30);
        switchToFrame();
        switchToLatestTabOrWindow();
    }
    private void switchToFrame(){
        switchTo().frame("certainModaliFrame");
    }

    private void selectQuestionType(String questionType) throws Exception{
        VerifyPageReady(30);
        Wait(QUESTION_TYPE_DROPDWON, 30);
        select(QUESTION_TYPE_DROPDWON, questionType);
        logReport("Successfully selected value :" + questionType + " in 'Question Type' dropdown.");
    }

    public void enterName(String questionName) throws Exception{
        VerifyPageReady(30);
        Wait(NAME_TEXTBOX, 30);
        type(NAME_TEXTBOX, questionName);
        logReport("Successfully entered value "+questionName+" in name textbox.");
    }

    private void enterCode(String questionCode) throws Exception{
        VerifyPageReady(30);
        Wait(CODE_TEXTBOX, 30);
        type(CODE_TEXTBOX, questionCode);
        logReport("Successfully entered value " + questionCode + " in code textbox.");
    }

    private void enterDisplayRegForm(String displayRegForm) throws Exception{
        VerifyPageReady(30);
        Wait(DISPLAY_REG_FORM, 30);
        type(DISPLAY_REG_FORM, displayRegForm);
        logReport("Successfully entered value "+displayRegForm+" in display reg form textbox.");
    }

    private void enterErrorMessage(String message) throws Exception{
        VerifyPageReady(30);
        Wait(ERROR_MESSAGE_TEXTBOX, 30);
        type(ERROR_MESSAGE_TEXTBOX, message);
        logReport("Successfully entered value "+message+" in error message textbox.");
    }

    private void enterInputFieldSize(String size) throws Exception{
        VerifyPageReady(30);
        Wait(INPUT_SIZE_TEXTBOX, 30);
        clearTextBoxValue(INPUT_SIZE_TEXTBOX);
        type(INPUT_SIZE_TEXTBOX, size);
        logReport("Successfully entered value "+size+" in input field size textbox.");
    }

    private void enterMinimumCharacter(String size) throws Exception{
        VerifyPageReady(30);
        Wait(MINIMUM_CHARACTER_TEXTBOX, 30);
        clearTextBoxValue(MINIMUM_CHARACTER_TEXTBOX);
        type(MINIMUM_CHARACTER_TEXTBOX, size);
        logReport("Successfully entered value "+size+" in minimum character textbox.");
    }

    private void enterMaximumCharacter(String size) throws Exception{
        VerifyPageReady(30);
        Wait(MAXIMUM_CHARACTER_TEXTBOX, 30);
        clearTextBoxValue(MAXIMUM_CHARACTER_TEXTBOX);
        type(MAXIMUM_CHARACTER_TEXTBOX, size);
        logReport("Successfully entered value "+size+" in maximum character textbox.");
    }

    private void enterDefaultAnswer(String answer) throws Exception{
        VerifyPageReady(30);
        Wait(DEFAULT_ANSWER, 30);
        type(DEFAULT_ANSWER, answer);
        logReport("Successfully entered value "+answer+" in default answer textbox.");
    }

    private void selectShowOnline(String value)throws Exception{
        VerifyPageReady(30);
        Wait(SHOW_ONLINE_DROPDOWN,30);
        select(SHOW_ONLINE_DROPDOWN, value);
        logReport("Successfully selected value: "+value+" from show online dropdown.");
    }

    private void selectQuestionAnswer(String value)throws Exception{
        VerifyPageReady(30);
        Wait(QUESTION_ANSWER_DROPDOWN, 30);
        select(QUESTION_ANSWER_DROPDOWN, value);
        logReport("Successfully selected value: "+value+" from Question Answer dropdown.");
    }

    private void selectQuestionFont(String value)throws Exception{
        VerifyPageReady(30);
        Wait(QUESTION_FONT_DROPDOWN, 30);
        select(QUESTION_FONT_DROPDOWN, value);
        logReport("Successfully selected value: "+value+" from Question font dropdown.");
    }

    private void selectQuestionHorizontalFont(String value)throws Exception{
        VerifyPageReady(30);
        Wait(QUESTION_FONT_HORIZONTAL_DROPDOWN, 30);
        select(QUESTION_FONT_HORIZONTAL_DROPDOWN, value);
        logReport("Successfully selected value: "+value+" from Question font horizontal dropdown.");
    }

    private void selectQuestionVerticalFont(String value)throws Exception{
        VerifyPageReady(30);
        Wait(QUESTION_FONT_VERTICAL_DROPDOWN, 30);
        select(QUESTION_FONT_VERTICAL_DROPDOWN, value);
        logReport("Successfully selected value: "+value+" from Question font vertical dropdown.");
    }

    private void selectAnswerFont(String value)throws Exception{
        VerifyPageReady(30);
        Wait(ANSWER_FONT_DROPDWON, 30);
        select(ANSWER_FONT_DROPDWON, value);
        logReport("Successfully selected value: "+value+" from Answer font dropdown.");
    }

    private void selectAnswerHorizontalFont(String value)throws Exception{
        VerifyPageReady(30);
        Wait(ANSWER_FONT_HORIZONTAL_DROPDWON, 30);
        select(ANSWER_FONT_HORIZONTAL_DROPDWON, value);
        logReport("Successfully selected value: "+value+" from Answer font horizontal dropdown.");
    }

    private void selectAnswerVerticalFont(String value)throws Exception{
        VerifyPageReady(30);
        Wait(ANSWER_FONT_VERTICAL_DROPDWON, 30);
        select(ANSWER_FONT_VERTICAL_DROPDWON, value);
        logReport("Successfully selected value: "+value+" from Answer font vertical dropdown.");
    }

    private void enterClass(String className)throws Exception{
        VerifyPageReady(30);
        Wait(CLASS_TEXTBOX, 30);
        type(CLASS_TEXTBOX, className);
        logReport("Successfully entered value "+className+" in class textbox.");
    }

    public void fillCustomTravelQuestionDetails(CustomQuestionData customQuestionData)throws Exception{
        switchToFrame();
        selectQuestionType(customQuestionData.getQuestionType());
        enterName(customQuestionData.getName());
        enterCode(customQuestionData.getCode());
        enterDisplayRegForm(customQuestionData.getDisplayRegForm());
        enterErrorMessage(customQuestionData.getErrorMessage());
        enterInputFieldSize(customQuestionData.getInputSize());
        enterMinimumCharacter(customQuestionData.getMinimumCharacter());
        enterMaximumCharacter(customQuestionData.getMinimumCharacter());
        enterDefaultAnswer(customQuestionData.getDefaultAnswer());
       /* selectShowOnline(customQuestionData.getShowOnline());
        selectQuestionAnswer(customQuestionData.getQuestionAnswer());
        selectQuestionFont(customQuestionData.getQuestionFont());
        selectQuestionHorizontalFont(customQuestionData.getQuestionHorizontalFont());
        selectQuestionVerticalFont(customQuestionData.getQuestionVerticalFont());
        selectAnswerFont(customQuestionData.getAnswerFont());
        selectAnswerHorizontalFont(customQuestionData.getQuestionHorizontalFont());
        selectAnswerVerticalFont(customQuestionData.getQuestionVerticalFont());
        enterClass(customQuestionData.getClassName());*/
        clickOnSaveButton();
        switchTo().defaultContent();
        switchToLatestTabOrWindow();
    }

    public void clickOnSaveButton()throws Exception{
        VerifyPageReady(30);
        Wait(SAVE_BUTTON, 30);
        click(SAVE_BUTTON);
        logReport("Successfully clicked on 'Save' button.");
    }

    public List<String> getTravelQuestionData() {
        String xpath = "//table[@id='dataGridTable-event-survey']//tr//td[@class='center' or @class='tableContent']";
        List<WebElement> elements = browser.findElements(By.xpath(xpath));
        List<String> travelQuestionData = new ArrayList<>();
        for (WebElement e : elements) {
            travelQuestionData.add(e.getText().trim());
        }
        return travelQuestionData;
    }
}
