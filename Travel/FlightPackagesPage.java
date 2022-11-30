package pageObjects.Travel;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.ImportTravel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by infoobjects on 21-08-2017.
 */
public class FlightPackagesPage extends CommonActionsPage {
    @FindBy(xpath = "//input[@value='Add New']")
    public WebElement ADD_NEW_BUTTON;
    @FindBy(xpath = "//input[@x-ng-model='travelPackage.name']")
    public WebElement DESCRIPTION_INPUTBOX;
    @FindBy(xpath = "//input[@value='Add Flights to Package']")
    public WebElement ADD_FLIGHTS_TO_PACKAGES_BUTTON;
    @FindBy(xpath = "//input[@value='Save']")
    public WebElement SAVE_BUTTON;
    @FindBy(xpath = "//input[@value='Cancel']")
    public WebElement CANCEL_BUTTON;
    @FindBy(xpath = "//button[text()='Add Flights']")
    public WebElement ADD_FLIGHTS_BUTTON;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Flights']")
    public WebElement FLIGHTS_TAB;
    @FindBy(xpath = "//img[@title='Export to Excel']")
    public WebElement EXPORT_TO_EXCEL_ICON;
    @FindBy(xpath = "//select[@x-ng-model='travelPackageFilter.selectedOption']")
    public WebElement TRAVEL_PACKAGE_FILTER_DROPDOWN;

    public FlightPackagesPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for clicking add new button
     */
    public void clickAddNewButton() throws Exception {
        Wait(ADD_NEW_BUTTON, 20);
        click(ADD_NEW_BUTTON);
        VerifyAngularHasFinishedProcessing(20);
    }

    /**
     * Method for entering description value
     *
     * @param description value of description
     */
    private void enterDescription(String description) throws Exception {
        Wait(DESCRIPTION_INPUTBOX, 20);
        type(DESCRIPTION_INPUTBOX, description, true);
    }

    private void clickAddFlightsToPackageButton() throws Exception {
        Wait(ADD_FLIGHTS_TO_PACKAGES_BUTTON, 20);
        click(ADD_FLIGHTS_TO_PACKAGES_BUTTON);
    }

    /**
     * Method for clicking save button
     */
    public void clickSaveButton() throws Exception {
        click(SAVE_BUTTON);
        VerifyAngularHasFinishedProcessing(20);
        VerifyPageReady(20);
    }


    /**
     * Method for creating flight package
     *
     * @param description value of description
     */
    public void createFlightPackage(String description) throws Exception {
        clickAddNewButton();
        enterDescription(description);
        clickSaveButton();
    }

    /**
     * Method for add flights to package
     *
     * @param importTravel page object of ImportTravel
     */
    public void addFlightToPackage(ImportTravel importTravel) throws Exception {
        Wait(ADD_FLIGHTS_TO_PACKAGES_BUTTON, 20);
        click(ADD_FLIGHTS_TO_PACKAGES_BUTTON);
        check("//table[@class='flight-summary-table']//td[text()='" + importTravel.getFlight().getFlightCode() + "']//ancestor::tr[@x-ng-repeat='flight in flights']//input[@type='checkbox']");
        //    webDriver.click(By.xpath("//table[@class='flight-summary-table']//td[text()='"+importTravel.getFlight().getFlightCode()+"']//ancestor::tr[@x-ng-repeat='flight in flights']//input[@type='checkbox']"));
        selectRefNumberAndInventory(importTravel.getFlight().getFlightCode(), importTravel.getFlightInventory().getSeatBlockId());
        click(ADD_FLIGHTS_BUTTON);
        click(SAVE_BUTTON);
    }

    /**
     * Method for select ref number and inventory using flight code
     *
     * @param flightCode  value of flight code
     * @param seatBlockId value of seat block id
     */
    private void selectRefNumberAndInventory(String flightCode, String seatBlockId) {
        WebElement select = browser.findElement(By.xpath("//table[@class='flight-summary-table']//td[text()='" + flightCode + "']//ancestor::tr[@x-ng-repeat='flight in flights']/td[3]/select"));
        List<WebElement> options = select.findElements(By.tagName("option"));
        for (WebElement element : options) {
            if (element.getText().contains(seatBlockId)) {
                element.click();
            }
        }
    }

    public void clickOnDeleteFlightPackageIcon(String flightCode) throws Exception {
        String xpath = "//td[contains(.,'" + flightCode + "')]/../../../..//img[@title='Delete Flight Association']";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 20);
        click(element);
        logReport("Clicked On Delete Icon.");
        VerifyPageReady(20);
    }

    public void clickOnEditFlightPackageIcon(String flightPackage) throws Exception {
        String xpath = "//td[contains(.,'" + flightPackage + "')]/..//img[@title='Edit Travel Package']";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 20);
        click(element);
        logReport("Clicked On Edit Icon.");
        VerifyAngularHasFinishedProcessing(20);
        VerifyPageReady(20);
    }

    public void clickDeleteFlightPackageIcon(String flightPackage) throws Exception {
        String xpath = "//td[contains(.,'" + flightPackage + "')]/..//td//img[@title='Delete Travel Package']";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 20);
        click(element);
        logReport("Clicked On Flight Package Delete Icon.");
        switchToLatestTabOrWindow();


    }

    public void clickExportExcelIcon() {
        click(EXPORT_TO_EXCEL_ICON);
        logReport("Export to excel icon clicked successfully");
    }

    public List<String> getFlightPackagesData(String flightCode) {
        String code = browser.findElement(By.xpath("//table[@id='tpl-table']//tbody//tr//td[text()='" + flightCode + "']")).getText().trim();
        String departureDateTime = browser.findElement(By.xpath("//table[@id='tpl-table']//tbody//tr//td[text()='" + flightCode + "']/../td[2]")).getText().trim();
        String departurePort = browser.findElement(By.xpath("//table[@id='tpl-table']//tbody//tr//td[text()='" + flightCode + "']/../td[3]")).getText().trim();
        String arrivalDateTime = browser.findElement(By.xpath("//table[@id='tpl-table']//tbody//tr//td[text()='" + flightCode + "']/../td[4]")).getText().trim();
        String arrivalPort = browser.findElement(By.xpath("//table[@id='tpl-table']//tbody//tr//td[text()='" + flightCode + "']/../td[5]")).getText().trim();
        String airline = browser.findElement(By.xpath("//table[@id='tpl-table']//tbody//tr//td[text()='" + flightCode + "']/../td[6]")).getText().trim();
        String packageName = browser.findElement(By.xpath("//table[@id='tpl-table']//tbody//tr//td[text()='" + flightCode + "']/../..//tr[1]//td[2]")).getText().trim();

        List<String> flightPackageList = new ArrayList<>();
        flightPackageList.add(code);
        flightPackageList.add(departureDateTime);
        flightPackageList.add(departurePort);
        flightPackageList.add(arrivalDateTime);
        flightPackageList.add(arrivalPort);
        flightPackageList.add(airline);
        flightPackageList.add(packageName);

        return flightPackageList;
    }

    public void selectTravelPackageFilterValue(String type) throws Exception {
        Wait(TRAVEL_PACKAGE_FILTER_DROPDOWN, 20);
        select(TRAVEL_PACKAGE_FILTER_DROPDOWN, type);
        logReport("Selected travel package filter value " + type);
    }

}
