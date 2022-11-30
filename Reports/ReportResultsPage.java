package pageObjects.Reports;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.EventRegistrations.AttendeeOverviewPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by infoobjects on 23-08-2017.
 */
public class ReportResultsPage extends CommonReportsPage {

    @FindBy(xpath = "//table[@id='reportResults']//thead//th//div")
    public List<WebElement> REPORT_RESULTS_HEADER_LIST;

    @FindBy(xpath = "//a[@title = 'Actions']")
    public WebElement ACTION_MENUITEM;

    @FindBy(xpath = "//a[text()=' Compose Email']")
    public WebElement COMPOSEMAIL_MENUITEM;

    @FindBy(xpath = "//table[@id='reportResults']//thead//tr//th[1]//div[@class='tablesorter-header-inner']//input")
    public WebElement SELECTALL_CHECKBOX;


    public ReportResultsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void clickActionsMenuItem() throws Exception {
        Wait(ACTION_MENUITEM, 20);
        click(ACTION_MENUITEM);

    }

    // public static final String SELECTALL_CHECKBOX = "//table[@id='reportResults']//thead//tr//th[1]//div[@class='tablesorter-header-inner']//input";


    /**
     * Method to check select all checkbox.
     */
    public void checkSelectAllCheckbox() throws Exception {
        Wait(SELECTALL_CHECKBOX, 30);
        checkByJavascript(SELECTALL_CHECKBOX);
        //webDriver.click(SELECTALL_CHECKBOX);
        VerifyPageReady(30);
        reporter.info("Records select all select successfully");
    }

    /**
     * Method to click on compose mails sub menu item
     */
    private void clickComposeMailSubMenuItem() {
        click(COMPOSEMAIL_MENUITEM);
    }

    public AttendeeOverviewPage clickRowByName(String firstName) throws Exception {
        String xpath = "//table[@id='reportResults']//tbody//tr//td[contains(.,'" + firstName + "')]";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 20);
        click(element);
        logReport("Row clicked successfully");
        //VerifyPageReady(20);
        return new AttendeeOverviewPage(browser);
    }

    public boolean reportResultsTitle(String reportName) {
        String xpath = " //div[@class='navbar-brand'][contains(.,'" + reportName + "')]";
        if (verifyElementDisplayed(browser.findElement(By.xpath(xpath)), 10)) {
            logReport("" + reportName + " is present in the report results title.");
            return true;
        }
        return false;
    }

    public void clickActionAndComposeMail() throws Exception {
        clickActionsMenuItem();
        clickComposeMailSubMenuItem();
    }
    public boolean isReportResultsListHeaderDisplayed(String headerName) {
        String xpath = "//table[@id='reportResults']//thead//th//div[contains(.,'" + headerName + "')]";
        return verifyElementDisplayed(By.xpath(xpath), 1);
    }

    public boolean isAnonymizedProfileFoundWithDate(String headerName) {
        boolean found = false;
        int i = getColumnIndex(REPORT_RESULTS_HEADER_LIST, headerName);
        int j = getColumnIndex(REPORT_RESULTS_HEADER_LIST, "Profile Anonymized Date");

        String xpath = "//table[@id='reportResults']//tbody//tr//td[" + i + "]";
        List<WebElement> elements = browser.findElements(By.xpath(xpath));
        List<String> values = new ArrayList<>();

        for (WebElement e : elements) {
            found = false;
            values.add(e.getText().trim());
            if (e.getText().trim().equalsIgnoreCase("Yes")) {
                WebElement date = e.findElement(By.xpath("./..//td[" + j + "]"));
                logReport("----------" + date.getText().trim());
                if (!date.getText().trim().equalsIgnoreCase(null) || !date.getText().trim().equalsIgnoreCase("")) {
                    logReport("Anonymized profiles are present in the Report results list with Profile anonymized date." + date.getText().trim());
                    found = true;

                } else {
                    logReport("Anonymized profiles are present in the Report results list without Profile anonymized date.");
                    found = false;
                }
            }
        }

        return found;
    }

    public int getColumnIndexForReports(String columnName) {
        String headerPath = "//table[@id='reportResults']//thead//tr//th//div[@class='tablesorter-header-inner']";
        List<WebElement> columnHeader = browser.findElements(By.xpath(headerPath));
        for (int i = 0; i < columnHeader.size(); i++) {
            if (columnHeader.get(i).getText().trim().contains(columnName)) {
                return i + 1;

            }
        }
        return 0;
    }

    public boolean isRegistrantPrivacyCompliant(String attendeeEmail, String columnsList) {
        String columnHeaders[] = columnsList.split(",");
        boolean found = false;
        for (String s : columnHeaders) {
            WebElement row = browser.findElement(By.xpath("//table[@id='reportResults']//tbody//tr//td[contains(.,'" + attendeeEmail + "')]/.."));
            int ColIndex = getColumnIndexForReports(s);
            if (row.findElement(By.xpath("./td[" + ColIndex + "]")).getText() != null) {
                found = true;
            } else
                found = false;
            break;
        }
        return found;
    }
}
