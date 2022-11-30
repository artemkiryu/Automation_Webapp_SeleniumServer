package pageObjects.Reports;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;


/**
 * Created by infoobjects on 11/23/2015.
 */
public class CommonReportsPage extends CommonActionsPage {
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Display']")
    public WebElement DISPLAY_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Groups'][contains(@class,'groups-module list-group-item')]")
    public WebElement GROUPS_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Subtotals']")
    public WebElement SUBTOTALS_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Columns']")
    public WebElement COLUMNS_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Filters']")
    public WebElement FILTERS_TAB;
    @FindBy(xpath = "//a[text()='Page']")
    public WebElement PAGE_TAB;
    @FindBy(xpath = "//a[text()='Export']")
    public WebElement EXPORT_TAB;
    @FindBy(xpath = "//a[text()='Custom']")
    public WebElement CUSTOM_TAB;
    @FindBy(xpath = "//input[@value='Run Report']")
    public WebElement RUN_REPORT_BUTTON;
    @FindBy(xpath = "//a[text()='Add Report']")
    public WebElement ADDREPORT_BUTTON;
    @FindBy(xpath = "//input[@value='Save']")
    public WebElement SAVE_BUTTON;

    public CommonReportsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public CommonReportsPage() {

    }

    /**
     * Method for clicking display tab
     *
     * @return ReportDisplayPage
     */
    public ReportDisplayPage clickDisplayTab() throws Exception {
        click(DISPLAY_TAB);
        logReport("Display tab clicked successfully");
        VerifyPageReady(20);
        return new ReportDisplayPage(browser);
    }

    /**
     * Method for clicking groups tab
     *
     * @return ReportGroupsPage
     */
    public ReportGroupsPage clickGroupsTab() throws Exception {
        click(GROUPS_TAB);
        logReport("Groups tab clicked successfully");
        VerifyPageReady(20);
        return new ReportGroupsPage(browser);
    }

    public ReportSubtotalsPage clickSubtotalsTab() throws Exception {
        click(SUBTOTALS_TAB);
        logReport("Subtotals tab clicked successfully");
        VerifyPageReady(20);
        return new ReportSubtotalsPage(browser);
    }

    /**
     * Method for clicking columns tab
     *
     * @return ReportColumnsPage
     */
    public ReportColumnsPage clickColumnsTab() throws Exception {
        click(COLUMNS_TAB);
        logReport("Columns tab clicked successfully");
        VerifyPageReady(20);
        return new ReportColumnsPage(browser);
    }

    /**
     * Method for clicking filters tab
     *
     * @return ReportFiltersPage
     */
    public ReportFiltersPage clickFiltersTab() throws Exception {
        click(FILTERS_TAB);
        logReport("Filters tab clicked successfully");
        VerifyPageReady(20);
        return new ReportFiltersPage(browser);
    }

    /**
     * Method for clicking page tab
     *
     * @return ReportPage
     */
    public ReportPage clickPageTab() throws Exception {
        click(PAGE_TAB);
        logReport("Page tab clicked successfully");
        VerifyPageReady(20);
        return new ReportPage(browser);
    }

    /**
     * Method for clicking export tab
     *
     * @return ReportExportPage
     */
    public ReportExportPage clickExportTab() throws Exception {
        click(EXPORT_TAB);
        logReport("Export tab clicked successfully");
        VerifyPageReady(20);
        return new ReportExportPage(browser);
    }

    /**
     * Method for clicking custom tab
     *
     * @return ReportCustomPage
     */
    public ReportCustomPage clickCustomTab() throws Exception {
        click(CUSTOM_TAB);
        logReport("Custom tab clicked successfully");
        VerifyPageReady(20);
        return new ReportCustomPage(browser);
    }

    /**
     * Method for clicking run report button
     *
     * @return ReportResultsPage
     */
    public ReportResultsPage clickRunReportButton() throws Exception {
        click(RUN_REPORT_BUTTON);
        logReport("Run report button clicked successfully");
        VerifyPageReady(20);
        return new ReportResultsPage(browser);
    }

    /**
     * Method to click on Add report button
     *
     * @return : SetupReportPage
     */
    public SetupReportPage clickAddReportButton() throws Exception {
        click(ADDREPORT_BUTTON);
        logReport("Add Report button clicked successfully");
        VerifyPageReady(20);
        return new SetupReportPage(browser);
    }

    public void clickRunReportButtonWithoutRedirect() throws Exception {
        click(RUN_REPORT_BUTTON);
        logReport("Run report button clicked successfully");
        VerifyPageReady(20);

    }

    public void clickSaveButton() throws Exception {
        click(SAVE_BUTTON);
        logReport("Save button clicked successfully");
        VerifyPageReady(20);
    }

    public SetupReportPage clickEditReportButton(String reportName) throws Exception {

        String xpath = "//div[@id='certainReports']//td//a[text()='" + reportName + "']/../..//a[@title='Edit this report']";
        WebElement element = browser.findElement(By.xpath(xpath));
        clickByJavaScript(element);
        logReport("Edit Report button clicked successfully");
        VerifyPageReady(20);
        return new SetupReportPage(browser);
    }
}
