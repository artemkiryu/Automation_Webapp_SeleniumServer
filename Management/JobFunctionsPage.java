package pageObjects.Management;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddJobFunctionData;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 31-08-2017.
 */
public class JobFunctionsPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@placeholder='Name']")
    public WebElement JOB_FUNCTION_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@title='Add Job Function']")
    public WebElement JOB_FUNCTION_ADD_BTN;

    public JobFunctionsPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void addNewJobFunction(AddJobFunctionData addJobFunctionData) throws Exception {
        Wait(JOB_FUNCTION_ADD_BTN, 30);
        type(JOB_FUNCTION_NAME_TEXTBOX, addJobFunctionData.getJobFunctionName(), true);
        clickByJavaScript(JOB_FUNCTION_ADD_BTN);
        logReport("Job function added successfully");
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
    }
}
