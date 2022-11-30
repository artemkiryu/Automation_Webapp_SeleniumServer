package pageObjects.Accommodation;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import org.openqa.selenium.support.FindBy;
import pojo.HotelData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by infoobjects on 8/21/2017.
 */
public class BlocksPage extends CommonActionsPage {

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Import']")
    public WebElement IMPORT_SUB_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Blocks']")
    public WebElement BLOCKS_SUB_TAB ;
    @FindBy(xpath ="//table[@id='blockListTable']//tbody/tr[1]//td")
    public WebElement FIRSTROW_IMPORT_BLOCKS;
    @FindBy(xpath ="//table[@id='blockListTable']//tbody/tr[5]//td")
    public WebElement LASTROW_IMPORT_BLOCKS ;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Hotels']")
    public WebElement HOTEL_SUB_TAB ;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Room Types']")
    public WebElement ROOM_TYPES_SUB_TAB ;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Configure']")
    public WebElement CONFIGURE_TAB ;
    @FindBy(xpath ="//button[@title='Add a new block']")
    public WebElement ADD_NEW_BUTTON ;
    @FindBy(xpath ="//img[@title='Edit block']")
    public WebElement EDIT_BLOCK_ICON;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Sub-Blocks']")
    public WebElement SUB_BLOCK_TAB;
    @FindBy(xpath ="//button[text()='Date']")
    public WebElement DATE_SUBTAB_BUTTON;
    @FindBy(xpath ="//button[text()='Hotel']")
    public WebElement HOTEL_SUBTAB_BUTTON;
    @FindBy(xpath ="//button[text()='Room Type']")
    public WebElement ROOMTYPE_SUBTAB_BUTTON ;
    @FindBy(xpath ="//button[text()='Block']")
    public WebElement BLOCK_SUBTAB_BUTTON;
    @FindBy(xpath ="//label[contains(.,'Utilization:')]/..//button[text()='By Hotel']")
    public WebElement BYHOTEL_SUBTAB_BUTTON;
    @FindBy(xpath ="//h4[text()='Error']")
    public WebElement ERROR_MESSAGE;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//button[text()='Show Inactive']")
    public WebElement SHOW_INACTIVE_TAB;
    @FindBy(xpath ="//h3[text()='Hotels']")
    public WebElement PAGE_HEADING;
    @FindBy(xpath ="//div[@class='pull-right']//a[text()='Next']")
    public WebElement PAGINATION_NEXT_TAB ;

    @FindBy(xpath ="//h3[text()='Accommodation Blocks']")
    public WebElement PAGE_HEADER;
    @FindBy(xpath ="//select[@name='capacity']//option")
    public WebElement OCCUPANCY;
    @FindBy(xpath ="//div[@class='row no-records-found ng-scope']//p")
    public WebElement NO_ACTIVE_BLOCK ;

    public BlocksPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }


    /**
     * Method to click on Import  tab.
     *
     * @return ImportPage
     */
    public ImportPage clickImportSubTab() {
        logReport("Click Import Sub Tab");
        click(IMPORT_SUB_TAB);
        return new ImportPage();
    }

    /**
     * Method to click on Block tab.
     *
     * @return BlocksPage
     */
    public BlocksPage clickBlockSubTab() throws Exception {
        logReport("Click Blocks Sub Tab");
        Wait(BLOCKS_SUB_TAB, 30);
        click(BLOCKS_SUB_TAB);
        Thread.sleep(3000);
       VerifyAngularHasFinishedProcessing(30);
        return new BlocksPage(browser);
    }

    /**
     * Method to click on Add New button.
     *
     * @return AccommodationBlockInformationPage
     */
    public AccommodationBlockInformationPage clickOnAddNewButton() throws Exception {
        logReport("Click Add New Button");
        Wait(ADD_NEW_BUTTON, 30);
        click(ADD_NEW_BUTTON);
        VerifyAngularHasFinishedProcessing(30);
        waitForWindowToAppear();
        return new AccommodationBlockInformationPage(browser);
    }

    /**
     * Method to click on hotel tab
     *
     * @return HotelsPage
     */
    public HotelsPage clickHotelsSubTab() throws Exception{
        logReport("Click Hotels Sub Tab");
         Wait(HOTEL_SUB_TAB, 30);
         click(HOTEL_SUB_TAB);
         VerifyAngularHasFinishedProcessing(30);
        return new HotelsPage(browser);
    }

    /**
     * Method to click on Edit Block icon.
     *
     * @return AccommodationBlockInformationPage
     */
    public AccommodationBlockInformationPage clickOnEditBlockIcon() throws Exception{
        logReport("Click on Edit Block Icon");
        click(EDIT_BLOCK_ICON);
        VerifyAngularHasFinishedProcessing(30);
        return new AccommodationBlockInformationPage(browser);
    }

    /**
     * Method to click on Sub-Block tab.
     *
     * @return SubBlocksPage
     */
    public SubBlocksPage clickOnSubBlocksTab() throws Exception{
        logReport("Click Sub Block Tab");
        click(SUB_BLOCK_TAB);
        return new SubBlocksPage(browser);
    }

    /**
     * Method to click on room Type tab.
     *
     * @return RoomTypesPage
     */
    public RoomTypesPage clickRoomTypesSubTab() throws Exception{
        logReport("Click Room Types Sub Tab");
        Wait(ROOM_TYPES_SUB_TAB, 30);
        click(ROOM_TYPES_SUB_TAB);
        return new RoomTypesPage(browser);
    }



    /**
     * Method to Add days in the mention date.
     *
     * @param dateValue : value of date in which days need to be add
     * @param days      : value of days that need to be added in the mentioned date
     * @return String
     * @throws Exception
     */
    public String getDateByDays(String dateValue, Integer days) throws Exception {
        String convertedDate;
        //SimpleDateFormat DtFormat = new SimpleDateFormat("M/dd/yyyy");
        SimpleDateFormat DtFormat = new SimpleDateFormat("M/d/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(DtFormat.parse(dateValue));
        cal.add(Calendar.DATE, days);
        convertedDate = DtFormat.format(cal.getTime());
        //logReport("Current date by no of days " + convertedDate);
        //logReport("GetDateByDays converted Date : " + convertedDate);
        return convertedDate;
    }

    /**
     * Method to find booked count on the basis of arrival and departure date
     *
     * @param arrivalDate   : start date
     * @param departureDate : end date
     * @return List<String>
     * @throws Exception
     */

    /*public List<String> getBookedCountBeforeRegistration(String arrivalDate, String departureDate) throws Exception {
        webDriver.waitFor().waitForPageToLoad();
        final long days = getDifferenceDays(departureDate, arrivalDate);
        logReport("Get DifferenceDays days : " + days);
        int i;
        String getText, getDate, getXpathByDate;
        List<String> getTextList = new ArrayList<>();
        webDriver.waitFor().waitForPageToLoad();
        for (i = 0; i < days; i++) {
            getDate = getDateByDays(arrivalDate, i);
            getXpathByDate = "//table[@id='blockListTable']//tbody//tr//td//div[contains(.,'" + getDate + "')]/../..//td[8]//div//span";
            webDriver.waitFor().elementDisplayed(By.xpath(getXpathByDate));
            getText = webDriver.findElement(By.xpath(getXpathByDate)).getText();
            getTextList.add(getText);

        }
        logReport("Booked Count Before Registration : " + getTextList);
        return getTextList;
    }*/

    /**
     * Method to verify that the booked count is increased or not.
     *
     * @param arrivalDate         : start date
     * @param departureDate       : end date
     * @param getOldList          : old list of booked count
     * @param bookedIncreaseCount : no. of count increased.
     * @return boolean
     * @throws Exception
     */
  /*  public boolean isBookedCountIncreased(String arrivalDate, String departureDate, List<String> getOldList, int bookedIncreaseCount) throws Exception {
        List<String> getNewList = new ArrayList<>();
        int j, getNewParseList, getOldParseList, count = 0;
        getNewList = getBookedCountBeforeRegistration(arrivalDate, departureDate);
        if (getNewList.size() != getOldList.size()) {
            return false;
        }
        Collections.replaceAll(getOldList, "-", "0");
        for (j = 0; j < getOldList.size(); j++) {
            getOldParseList = Integer.parseInt(getOldList.get(j));
            getNewParseList = Integer.parseInt(getNewList.get(j));
            if ((getNewParseList - getOldParseList) == bookedIncreaseCount) {
                count = count + 1;
            }

        }
        return count == getOldList.size();


    }*/

    /**
     * Method to click on configure button.
     *
     * @return AccommodationConfigurationPage
     */
    public ConfigurePage clickConfigureTab() throws Exception{
        Wait(CONFIGURE_TAB, 30);
        click(CONFIGURE_TAB);
        logReport("Configure tab clicked successfully");
        VerifyAngularHasFinishedProcessing(30);
        return new ConfigurePage(browser);
    }



    /**
     * Method to verify the existence of Edit icon corresponding to a date
     *
     * @param startDate :  date corresponding to which icon need to verify.
     * @return boolean
     * @throws Exception
     */
    public boolean isEditIconExist(String startDate) throws Exception {
        browser.navigate().refresh();
        String convertedStartDate;
        convertedStartDate = getDateByDays(startDate, 0);
        Wait(EDIT_BLOCK_ICON, 30);
        VerifyAjaxRequestsFinished(30);
        String xpath = "//table[@id='blockListTable']//tbody//tr//td//div[contains(.,'" + convertedStartDate + "')]/../..//td//img[@title='Edit inventory and rate']";
        boolean isEditIconDisplayed = isElementDisplayed((By.xpath(xpath)), browser);
        logReport("Edit Icon displayed : " + isEditIconDisplayed);
        return isEditIconDisplayed;
    }

    /**
     * Method to verify inventory rate is changed or not.
     *
     * @param rate      : value of rate that need to be compare
     * @param startDate : date corresponding to which changes need to verify.
     * @return boolean
     * @throws Exception
     */
    public boolean isInventoryRateChanged(String rate, String startDate) throws Exception {
        String convertedStartDate;
        convertedStartDate = getDateByDays(startDate, 0);
        String xpath = "//table[@id='blockListTable']//tbody//tr//td//div[contains(.,'" + convertedStartDate + "')]/../..//td[5]";
        WebElement getTextPath = browser.findElement(By.xpath(xpath));
        return getTextPath.getText().equalsIgnoreCase(rate);
    }

    /**
     * Method to get the value of working inventory rate from the block.
     *
     * @param startDate : date corresponding to which value need to get.
     * @return String
     * @throws Exception
     */
    public String getWorkingInventoryRate(String startDate) throws Exception {
        String convertedStartDate;
        convertedStartDate = getDateByDays(startDate, 0);
        VerifyPageReady(30);
        Wait(EDIT_BLOCK_ICON, 30);
        VerifyAjaxRequestsFinished(30);
        VerifyAngularHasFinishedProcessing(30);
        String xpath = "//table[@id='blockListTable']//tbody//tr//td//div[contains(.,'" + convertedStartDate + "')]/../..//td[5]//span";
        WebElement getTextPath = browser.findElement(By.xpath(xpath));
        logReport("Inventory rate " + getTextPath.getText());
        return getTextPath.getText();
    }

    /**
     * Method to get the value of working inventory+ from the block.
     *
     * @param startDate : date corresponding to which value need to get.
     * @return String
     * @throws Exception
     */
    public String getWorkingInventory(String startDate) throws Exception {
        String convertedStartDate;
        convertedStartDate = getDateByDays(startDate, 0);
        Wait(EDIT_BLOCK_ICON, 30);
        VerifyAjaxRequestsFinished(30);
        VerifyAngularHasFinishedProcessing(30);
        String xpath = "//table[@id='blockListTable']//tbody//tr//td//div[contains(.,'" + convertedStartDate + "')]/../..//td[6]/div";
        WebElement getTextPath = browser.findElement(By.xpath(xpath));
        logReport("Working Inventory " + getTextPath.getText());
        return getTextPath.getText();
    }

    /**
     * Method to get the working Inventory column value when no room is booked in a block
     *
     * @return String
     */
    public String getWorkingInventoryForNoRoomBooked() throws Exception{

        Wait(EDIT_BLOCK_ICON, 30);
        VerifyAjaxRequestsFinished(30);
        VerifyAngularHasFinishedProcessing(30);
        String xpath = "//table[@id='blockListTable']//tbody//tr//td[8]//div[contains(.,'-')]/../..//td[6]/div";
        WebElement getTextPath = browser.findElement(By.xpath(xpath));
        logReport("Working Inventory for no room booked " + getTextPath.getText());
        return getTextPath.getText();
    }

    /**
     * Method to get the contracted Inventory column value corresponding to a date in a block
     *
     * @param startDate :  date corresponding to which value need to get.
     * @return String
     * @throws Exception
     */
    public String getContractedInventory(String startDate) throws Exception {
        String convertedStartDate;
        convertedStartDate = getDateByDays(startDate, 0);
        Wait(EDIT_BLOCK_ICON,30);
       VerifyAjaxRequestsFinished(30);
        VerifyAngularHasFinishedProcessing(30);
        String xpath = "//table[@id='blockListTable']//tbody//tr//td//div[contains(.,'" + convertedStartDate + "')]/../..//td[10]/div";
        WebElement getTextPath = browser.findElement(By.xpath(xpath));
        logReport("Contracted Inventory " + getTextPath.getText());
        return getTextPath.getText();
    }

    /**
     * Method to get the contracted Inventory column value when no room is booked in a block
     *
     * @return String
     */
    public String getContractedInventoryForNoRoomBooked() throws Exception{
        Wait(EDIT_BLOCK_ICON, 30);
        VerifyAjaxRequestsFinished(30);
        VerifyAngularHasFinishedProcessing(30);
        String xpath = "//table[@id='blockListTable']//tbody//tr//td[8]//div[contains(.,'-')]/../..//td[10]/div";
        WebElement getTextPath = browser.findElement(By.xpath(xpath));
        logReport("Contracted Inventory for no room booked " + getTextPath.getText());
        return getTextPath.getText();
    }



}
