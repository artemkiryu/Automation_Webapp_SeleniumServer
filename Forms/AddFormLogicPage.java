package pageObjects.Forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddFormLogicRulesPageData;

import javax.naming.ConfigurationException;


/**
 * Created by infoobjects on 23-08-2017.
 */
public class AddFormLogicPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@name='log_rule_name']")
    public WebElement LOGIC_NAME_TEXTBOX;
    @FindBy(xpath = "//select[@name='log_rule_action_item']")
    public WebElement SELECT_QUESTION_DROPDOWN;
    @FindBy(xpath = "//select[@name='log_rule_action']")
    public WebElement SELECT_ACTIONS_DROPDOWN;
    @FindBy(xpath = "//select[@id='log_rule_action_item']")
    public WebElement SELECT_ACTIONS_DROPDOWN_VALUE;
    @FindBy(xpath = "//select[@name='log_rule_action_item']")
    public WebElement SELECT_QUESTION_TEXT;

    public AddFormLogicPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void selectConditionsRadioButton(String text) throws Exception {
        String xpath = "//label[contains(.,'" + text + "')]/input";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 10);
        click(element);
        logReport("Selected conditions radio button " + text);
    }
    public void enterLogicName(String logicName) throws Exception{
        Wait(LOGIC_NAME_TEXTBOX, 30);
        type(LOGIC_NAME_TEXTBOX, logicName);
        logReport("Entered Name: " + logicName + " in 'Logic Name' TextBox");
    }

    public void selectActionsDropdown(String actions) throws  Exception{
        select(SELECT_ACTIONS_DROPDOWN,actions);
        logReport("Selected Action: " + actions + "in 'Actions' Dropdown");
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
    }

    public void selectActionsDropdownValue(String item) throws Exception {
        Wait(SELECT_ACTIONS_DROPDOWN_VALUE, 20);
        select(SELECT_ACTIONS_DROPDOWN_VALUE, item);
        logReport("Selected Action: " + item + "in 'Actions' Dropdown");
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
    }


    public void selectQuestionDropdown(String question) throws Exception{
        Wait(SELECT_QUESTION_DROPDOWN, 30);
        select(SELECT_QUESTION_DROPDOWN, question);
        logReport("Selected Question: " + question + "in 'Questions' Dropdown");
    }

    public void fillFormLogicRulesDetails(AddFormLogicRulesPageData addFormLogicRulesPageData) throws Exception{
        Wait(SAVE_BUTTON_FORM,30);
        VerifyAjaxRequestsFinished(30);
        enterLogicName(addFormLogicRulesPageData.getLogicName());
        selectActionsDropdown(addFormLogicRulesPageData.getActionType());
        selectQuestionDropdown(addFormLogicRulesPageData.getQuestion());
    }

    public void fillFormLogicRulesWithActions(AddFormLogicRulesPageData addFormLogicRulesPageData, String item) throws Exception {
        Wait(SAVE_BUTTON_FORM, 30);
        VerifyAjaxRequestsFinished(30);
        enterLogicName(addFormLogicRulesPageData.getLogicName());
        selectConditionsRadioButton(addFormLogicRulesPageData.getCondition());
        selectActionsDropdown(addFormLogicRulesPageData.getActionType());
        selectActionsDropdownValue(item);
    }

}
