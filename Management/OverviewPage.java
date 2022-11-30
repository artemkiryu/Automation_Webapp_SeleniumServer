package pageObjects.Management;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 30-08-2017.
 */
public class OverviewPage extends CommonActionsPage {

    public OverviewPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public EventDataPage clickEventDataTab() throws Exception {
        click(EVENT_DATA_TAB);
        logReport("Event Data tab clicked successfully.");
        return new EventDataPage(browser);
    }

    public RolesPage clickRolesTab() throws Exception {
        click(ROLES_TAB);
        log("Roles tab clicked successfully");
        return new RolesPage(browser);
    }

    public TagsPage clickTagsTab() throws Exception {
        click(TAGS_TAB);
        log("Tags tab clicked successfully");
        return new TagsPage(browser);
    }

    public JobFunctionsPage clickJobFunctionsTab() throws Exception {
        click(JOB_FUNCTIONS_TAB);
        log("Job functions tab clicked successfully");
        return new JobFunctionsPage(browser);
    }

    public IndustriesPage clickIndustriesTab() throws Exception {
        click(INDUSTRIES_TAB);
        log("Industries tab clicked successfully");
        return new IndustriesPage(browser);
    }
}
