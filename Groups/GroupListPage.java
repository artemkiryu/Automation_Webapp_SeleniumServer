package pageObjects.Groups;

import org.apache.commons.configuration.ConfigurationRuntimeException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

/**
 * Created by infoobjects on 28-08-2017.
 */
public class GroupListPage extends CommonActionsPage{

    @FindBy(xpath = "//input[@class='btn btn-primary btn-xs pull-right btn-manual ng-scope']")
    public WebElement ADD_NEW_GROUP_BUTTON;
    @FindBy(xpath = "//a[text()='Import Groups']")
    public WebElement IMPORT_GROUPS_BUTTON;

    public GroupListPage(WebDriver driver) throws ConfigurationRuntimeException{
        PageFactory.initElements(driver, this);
    }

    public AddGroupPage clickAddNewGroupListBtn() throws Exception {
        click(ADD_NEW_GROUP_BUTTON);
        logReport("Add New Group List button clicked successfully");
        return new AddGroupPage(browser);
    }

    public CustomFieldsPage clickCustomFieldsSideTab() throws Exception {
        click(CUSTOM_FIELDS_TAB);
        logReport("Custom Fields tab clicked successfully");
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
        return new CustomFieldsPage(browser);
    }

    public AssignGroupsPage clickAssignGroupsSideTab() throws Exception {
        click(ASSIGN_GROUPS_TAB);
        logReport("Assign groups tab clicked successfully");
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
        return new AssignGroupsPage(browser);
    }

    public ReportGroupPage clickReportGroupsSideTab() throws Exception {
        click(REPORTS_GROUPS_TAB);
        logReport("Reports groups tab clicked successfully");
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
        return new ReportGroupPage(browser);
    }
}
