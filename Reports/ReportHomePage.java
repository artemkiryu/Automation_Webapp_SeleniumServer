package pageObjects.Reports;


import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddReportData;


/**
 * Created by infoobjects on 5/25/2015.
 */
public class ReportHomePage extends CommonActionsPage {

    @FindBy(xpath = "//a[text()='Reports']")
    public WebElement REPORT_SUBTAB;
    @FindBy(xpath = "//a[text()='Add Report']")
    public WebElement ADDREPORT_BUTTON;
    @FindBy(xpath = "//div[@class='add-event-reports']//table//tr//td")
    public WebElement DATAGRID_ROW;
    @FindBy(xpath = "//div[@class='add-event-reports']//thead//tr//th//div//div")
    public WebElement DATAGRID_HEADER;
    @FindBy(xpath = "//select[@id='filter']")
    public WebElement FILTER_REPORT_TYPE;

    public ReportHomePage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to click on report sub tab.
     */

    public void clickReportSubTab() {
        click(REPORT_SUBTAB);
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


    /**
     * Method to click on edit report icon.
     *
     * @param report : Page object of AddReportData.
     * @return : SetupReportPage
     */
    public SetupReportPage clickEditReportIcon(AddReportData report) throws Exception {
        String editIcon;
        if (report.getReportGroup().equals(""))
            editIcon = "//div[@class='event-reports']//table//tr//td//a[text()= '" + report.getReportName() + "']//..//..//td/a[@title='Edit this report']";
        else
            editIcon = "//div[contains(.,'" + report.getReportGroup() + "')]//tbody//td//a[text()='" + report.getReportName() + "']//..//..//td/a[@title='Edit this report']";
        click(browser.findElement(By.xpath(editIcon)));
        return new SetupReportPage(browser);

    }

    public SetupReportPage editReportIconWithoutGroup(AddReportData addReportData) throws Exception {
        String xpath = "//td//a[text()='" + addReportData.getReportName() + "']/../..//td//a[@title='Edit this report']";
        click(browser.findElement(By.xpath(xpath)));
        return new SetupReportPage(browser);
    }

    /**
     * Method to click on report name.
     *
     * @param report : Page object of AddReportData.
     */
    public void clickReportName(AddReportData report) {
        if (report.getReportGroup().equals(""))
            click(browser.findElement(By.xpath("//div[@class='event-reports']//table//td[2]/a[text()='" + report.getReportName() + "']")));
        else
            click(browser.findElement(By.xpath("//div[contains(@class, '" + report.getReportGroup().toLowerCase() + "-event-reports')]//table//td[2]/a[text()='" + report.getReportName() + "']")));
    }

    public boolean isReportPresentUnderGroup(String groupName, String reportName) {
        String xpath = "//div[@class='panel-heading'][contains(text(),'" + groupName + "')]/..//tbody//td//a[text()='" + reportName + "']";
        return isElementDisplayed(By.xpath(xpath), browser);
    }

    public boolean isReportNotPresentUnderGroup(String reportName) {
        String xpath = "//td//a[text()='" + reportName + "']";
        return isElementDisplayed(By.xpath(xpath), browser);
    }

    public String getReportType(String reportName, String groupName) {
        String xpath = "//div[contains(@class, translate('" + groupName + "', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'))]//tbody//td//a[text()='" + reportName + "']/../following-sibling::td[1]";
        return getTextBetweetParanthesis(browser.findElement(By.xpath(xpath)).getText().trim());
    }

    public String getReportTypeWithoutGroupName(String reportName) {
        String xpath = "//td//a[text()='" + reportName + "']/../..//td[3]";
        return browser.findElement(By.xpath(xpath)).getText().trim();
    }

    private String getTextBetweetParanthesis(String text) {
        String reportType = text.substring(text.indexOf('(') + 1, text.indexOf(')'));
        logReport("Report Type = " + reportType);
        return reportType;
    }

    public void selectFilter(String filterName) throws Exception {
        select(FILTER_REPORT_TYPE, filterName);
        logReport("Filter selected from drop down : " + filterName);
        VerifyAjaxRequestsFinished(20);
    }

    public boolean isInactiveReportPresentInGrid(AddReportData reportData) {
        String xpath = "//div[@id='inactive-reports-']//td/a[text()='" + reportData.getReportName() + "']";
        return isElementDisplayed(By.xpath(xpath), browser);
    }
}


