package pageObjects.Agenda;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pageObjects.CommonActionsPage;
import pojo.AddAgenda;
import pojo.FeeStructureData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by infoobjects on 03-08-2017.
 */
public class AddAgendaPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@ng-model='agendaItem.name']")
    public WebElement AGENDA_NAME_TEXTBOX;

    //Details Section Xpath
    @FindBy(xpath = "//label[text()='Type']/..//button")
    public WebElement AGENDA_TYPE_BUTTON;

    @FindBy(xpath = "//label[text()='Type']/..//following-sibling::div/ul/div[2]//div")
    public List<WebElement> AGENDA_DROPDOWN_LIST;
    @FindBy(xpath = "//label[text()='Type']/..//following-sibling::div/ul//input[@ng-model='newAgendaType']")
    public WebElement AGENDA_TEXTBOX;
    @FindBy(xpath = "//label[text()='Type']/..//following-sibling::div/ul//span[text()='Add New']")
    public WebElement AGENDA_ADDNEW_BUTTON;

    @FindBy(xpath = "//input[@ng-model='agendaItem.code']")
    public WebElement UNIQUE_CODE_TEXTBOX;
    @FindBy(xpath = "//input[@ng-model='agendaItem.orderRank']")
    public WebElement SORT_ORDER_TEXTBOX;
    @FindBy(xpath = "//input[@ng-model='agendaItem.ceuNum']")
    public WebElement CEU_TEXTBOX;
    @FindBy(xpath = "//input[@ng-model='agendaItem.points']")
    public WebElement POINTS_TEXTBOX;
    @FindBy(xpath = "//input[@ng-model='agendaItem.inventory']")
    public WebElement CAPACITY_TEXTBOX;
    @FindBy(xpath = "//input[@ng-model='agendaItem.limit']")
    public WebElement MAXIMUM_ORDER_TEXTBOX;
    @FindBy(xpath = "//input[@ng-model='agendaItem.endDate']/..//following-sibling::div//a//i[@aria-label='Time']")
    public WebElement END_TIME_CLOCK;
    @FindBy(xpath = "//input[@ng-model='agendaItem.startDate']/..//following-sibling::div//a//i[@aria-label='Time']")
    public WebElement START_TIME_CLOCK;
    @FindBy(xpath = "//i[@aria-label='Time']/../../../..//input[@ng-model='agendaItem.startDate']")
    public WebElement START_TIME;
    @FindBy(xpath = "//input[@name='startDate']")
    public WebElement START_DATE_TEXTBOX;
    @FindBy(xpath = "//input[@name='date']")
    public WebElement END_DATE_TEXTBOX;
    @FindBy(xpath = "//i[@aria-label='Time']/../../../..//input[@ng-model='agendaItem.endDate']")
    public WebElement END_TIME;
    @FindBy(xpath = "//table[@ng-model='agendaItem.startDate']//input[@ng-model='hours']")
    public WebElement START_TIME_HOURS_TEXTBOX;
    @FindBy(xpath = "//table[@ng-model='agendaItem.startDate']//input[@ng-model='minutes']")
    public WebElement START_TIME_MINUTES_TEXTBOX;
    @FindBy(xpath = "//table[@ng-model='agendaItem.startDate']//button[@ng-click='toggleMeridian()']")
    public WebElement START_TIME_MERIDIAN_BUTTON;
    @FindBy(xpath = "//table[@ng-model='agendaItem.endDate']//input[@ng-model='hours']")
    public WebElement END_TIME_HOURS_TEXTBOX;
    @FindBy(xpath = "//table[@ng-model='agendaItem.endDate']//input[@ng-model='minutes']")
    public WebElement END_TIME_MINUTES_TEXTBOX;
    @FindBy(xpath = "//table[@ng-model='agendaItem.endDate']//button[@ng-click='toggleMeridian()']")
    public WebElement END_TIME_MERIDIAN_BUTTON;

    @FindBy(xpath = "//select[@id='tagBox']")
    public WebElement TAG_DROPDOWN;

    //Scheduled management section
    @FindBy(xpath = "//label[text()='Location']/..//following-sibling::div/button")
    public WebElement LOCATION_BUTTON;
    @FindBy(xpath = "//label[text()='Location']/..//following-sibling::div/ul/div[2]//div")
    public List<WebElement> LOCATION_DROPDOWN_LIST;
    @FindBy(xpath = "//label[text()='Location']/..//following-sibling::div/ul//input[@ng-model='location.newValue']")
    public WebElement LOCATION_TEXTBOX;
    @FindBy(xpath = "//label[text()='Location']/..//following-sibling::div/ul//span[text()='Add New']")
    public WebElement LOCATION_ADDNEW_BUTTON;
    @FindBy(xpath = "//label[text()='Track']/..//following-sibling::div/ul/div[2]//div")
    public List<WebElement> TRACK_DROPDOWN_LIST;
    @FindBy(xpath = "//label[text()='Track']/..//following-sibling::div/ul//input[@ng-model='track.newValue']")
    public WebElement TRACK_TEXTBOX;
    @FindBy(xpath = "//label[text()='Track']/..//following-sibling::div/ul//span[text()='Add New']")
    public WebElement TRACK_ADDNEW_BUTTON;
    @FindBy(xpath = "//label[text()='Group']/..//following-sibling::div/ul/div[2]//div")
    public List<WebElement> GROUP_DROPDOWN_LIST;
    @FindBy(xpath = "//label[text()='Track']/..//following-sibling::div/button")
    public WebElement TRACK_BUTTON;
    @FindBy(xpath = "//label[text()='Group']/..//following-sibling::div/button")
    public WebElement GROUP_BUTTON;
    @FindBy(xpath = "//label[text()='Group']/..//following-sibling::div/ul//input[@ng-model='group.newValue']")
    public WebElement GROUP_TEXTBOX;
    @FindBy(xpath = "//label[text()='Group']/..//following-sibling::div/ul//span[text()='Add New']")
    public WebElement GROUP_ADDNEW_BUTTON;

    @FindBy(xpath = "//label[text()='Classification']/..//following-sibling::div/ul/div[2]//div")
    public List<WebElement> CLASSIFICATION_DROPDOWN_LIST;
    @FindBy(xpath = "//label[text()='Classification']/..//following-sibling::div/button")
    public WebElement CLASSIFICATION_BUTTON;
    @FindBy(xpath = "//label[text()='Classification']/..//following-sibling::div/ul//input[@ng-model='track.newValue']")
    public WebElement CLASSIFICATION_TEXTBOX;
    @FindBy(xpath = "//label[text()='Classification']/..//following-sibling::div/ul//span[text()='Add New']")
    public WebElement CLASSIFICATION_ADDNEW_BUTTON;

    @FindBy(xpath = "//input[@value='Save']")
    public WebElement SAVE_BUTTON;
    @FindBy(xpath = "//input[@value='Save & New']")
    public WebElement SAVE_NEW_BUTTON;
    @FindBy(xpath = "//input[@value='Cancel']")
    public WebElement CANCEL_BUTTON;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[contains(.,'Scheduled')]")
    public WebElement SCHEDULED_TAB;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[contains(.,'Merchandise')]")
    public WebElement MERCHANDISE_TAB;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[contains(.,'Discounts')]")
    public WebElement FEES_DISCOUNTS_TAB;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[contains(.,'Other')]")
    public WebElement OTHER_TAB;

    @FindBy(xpath = "//select[@ng-model='feeTypeRules.isDiscountable']")
    public WebElement DISCOUNT_RULES_DROPDOWN;

    @FindBy(xpath = "//select[@ng-model='agendaItem.taxCodeId']")
    public WebElement TAX_RULES_DROPDOWN;

    @FindBy(xpath = "//input[@ng-model='isCancelledEnable.value']")
    public WebElement CANCELLATION_ITEM_CHK;

    @FindBy(xpath = "//input[@ng-model='feeItem.code']")
    public WebElement UNIQUE_FEECODE_TEXTBOX;
    @FindBy(xpath = "//input[@ng-model='feeItem.name']")
    public WebElement LABEL_REGFORM_TEXTBOX;
    @FindBy(xpath = "//input[@ng-model='feeItem.percentage']")
    public WebElement PERCENTAGE_TEXTBOX;
    @FindBy(xpath = "//input[@ng-model='feeItem.amount']")
    public WebElement AMOUNTTAX_TEXTBOX;
    @FindBy(xpath = "//input[@ng-model='feeItem.glNum']")
    public WebElement GL_ACCOUNT_TEXTBOX;
    @FindBy(xpath = "//input[@ng-model='feeItem.amount']")
    public WebElement AMOUNT_TEXTBOX;

    //Label and description section

    @FindBy(xpath = "//div[@id='cke_editor1']//iframe")
    public WebElement LABEL_IFRAME;

    @FindBy(xpath = "//div[@id='cke_editor2']//iframe")
    public WebElement DESCRIPTION_IFRAME;

    @FindBy(xpath = "//textarea[@ng-model='agendaItem.notes']")
    public WebElement NOTES_TEXTAREA;

    @FindBy(xpath = "//div[@ng-if='feeSectionShow']//input[@type='radio']")
    public List<WebElement> FEE_TYPE_RADIOBUTTON;



    public AddAgendaPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void enterName(String name) throws Exception {
        VerifyPageReady(10);
        Wait(AGENDA_NAME_TEXTBOX, 30);
        type(AGENDA_NAME_TEXTBOX, name);
        logReport("Successfully entered: " + name + " in agenda name textbox.");
    }

    public boolean isAgendaTypeValueFound(String locType) {
        boolean found = false;
        if (AGENDA_DROPDOWN_LIST.size() > 0) {
            for (WebElement e : AGENDA_DROPDOWN_LIST) {
                logReport("Get value of dropdown " + e.getText().trim());
                if (e.getText().trim().equalsIgnoreCase(locType)) {
                    logReport("Agenda type found and clicked successfully");
                    found = true;
                    break;
                }

            }
        }
        return found;
    }

    public void selectAgendaType(String agendaType) throws Exception {
        Wait(AGENDA_TYPE_BUTTON, 10);
        click(AGENDA_TYPE_BUTTON);
        logReport("click on agenda dropdown button.");
        if (isAgendaTypeValueFound(agendaType)) {
            for (WebElement e : AGENDA_DROPDOWN_LIST) {
                if (e.getText().trim().equalsIgnoreCase(agendaType)) {
                    clickByJavaScript(e);
                    logReport("Agenda type exist and clicked successfully");

                }
            }
        } else {
            type(AGENDA_TEXTBOX, agendaType);
            logReport("Entered agenda type text value " + agendaType);
            click(AGENDA_ADDNEW_BUTTON);
            logReport("Agenda Type add new button clicked successfully");
            click(AGENDA_TYPE_BUTTON);
            logReport("Agenda Type button clicked");
        }

    }

    public void enterUniqueCode(String code) throws Exception {
        type(UNIQUE_CODE_TEXTBOX, code);
        logReport("Successfully entered: " + code + " in unique code textbox.");
    }

    private void enterSortOrder(String order) throws Exception {
        type(SORT_ORDER_TEXTBOX, order);
        logReport("Successfully entered: " + order + " in sort order textbox.");
    }

    private void enterCEU(String ceuNumber) throws Exception {
        type(CEU_TEXTBOX, ceuNumber);
        logReport("Successfully entered: " + ceuNumber + " in CEU textbox.");
    }

    private void enterPoints(String points) throws Exception {
        type(POINTS_TEXTBOX, points);
        logReport("Successfully entered: " + points + " in Points textbox.");
    }

    private void enterCapacity(String capacity) throws Exception {
        type(CAPACITY_TEXTBOX, capacity);
        logReport("Successfully entered: " + capacity + " in Capacity textbox.");
    }

    private void enterMaximumOrder(String maxOrder) throws Exception {
        type(MAXIMUM_ORDER_TEXTBOX, maxOrder);
        logReport("Successfully entered: " + maxOrder + " in Maximum Order textbox.");
    }

    private void enterStartDate(String startDate) throws Exception {
        scrollIntoView(START_DATE_TEXTBOX);
        Wait(START_DATE_TEXTBOX, 10);
        START_DATE_TEXTBOX.clear();
        START_DATE_TEXTBOX.sendKeys(startDate);
        //webDriver.type(START_DATE_TEXTBOX, startDate);
        // webDriver.click(START_DATE_TEXTBOX);
        reporter.info("Entered Value: " + startDate + " in 'Start Date' TextBox");
    }

    /**
     * Method to enter start time of the agenda
     *
     * @param startTime : starting time of agenda
     */
    private void enterStartTime(String startTime) throws Exception {
        scrollIntoView(START_TIME_CLOCK);
        String[] times = startTime.split(":");
        String hours = times[0];
        String minutes = times[1].substring(0, 2);
        String meridian = times[1].substring(2, times[1].length());
        Wait(START_TIME_CLOCK, 10);
        clickByJavaScript(START_TIME_CLOCK);
        Wait(START_TIME_HOURS_TEXTBOX, 10);
        type(START_TIME_HOURS_TEXTBOX, hours, true);
        type(START_TIME_MINUTES_TEXTBOX, minutes, true);
        WebElement element = START_TIME_MERIDIAN_BUTTON;
        if (!element.getText().equalsIgnoreCase(meridian)) {
            element.click();
        }
        clickByJavaScript(START_TIME_CLOCK);
        reporter.info("Entered Value: " + startTime + " in 'Start Time' TextBox");
    }

    /**
     * Method to select end date in end date textbox.
     *
     * @param endDate : date of agenda when it need to finish
     */
    private void enterEndDate(String endDate) throws Exception {
        scrollIntoView(END_DATE_TEXTBOX);
        Wait(END_DATE_TEXTBOX, 10);
        VerifyPageReady(10);
        END_DATE_TEXTBOX.clear();
        END_DATE_TEXTBOX.sendKeys(endDate);
        //webDriver.click(END_DATE_TEXTBOX);
        reporter.info("Entered Value: " + endDate + " in 'End Date' TextBox");
    }

    /**
     * Method to enter end time of the agenda
     *
     * @param endTime : time of the agenda when it need to finish
     */
    private void enterEndTime(String endTime) throws Exception {
        scrollIntoView(END_TIME_CLOCK);
        String[] times = endTime.split(":");
        String hours = times[0];
        String minutes = times[1].substring(0, 2);
        String meridian = times[1].substring(2, times[1].length());
        Wait(END_TIME_CLOCK, 10);
        clickByJavaScript(END_TIME_CLOCK);
        Wait(END_TIME_HOURS_TEXTBOX, 10);
        type(END_TIME_HOURS_TEXTBOX, hours, true);
        type(END_TIME_MINUTES_TEXTBOX, minutes, true);
        WebElement element = END_TIME_MERIDIAN_BUTTON;
        if (!element.getText().equalsIgnoreCase(meridian)) {
            element.click();
        }
        clickByJavaScript(END_TIME_CLOCK);
        reporter.info("Entered Value: " + endTime + " in 'Start Time' TextBox");
    }


    public void clickSaveButton() throws Exception {
        VerifyPageReady(10);
        Wait(SAVE_BUTTON, 30);
        click(SAVE_BUTTON);
        logReport("Successfully clicked on 'Save' button.");
    }

    public void clickOnScheduledTab() throws Exception {
        VerifyPageReady(10);
        Wait(SCHEDULED_TAB, 30);
        clickByJavaScript(SCHEDULED_TAB);
        logReport("Successfully clicked on scheduled tab.");

    }

    public void clickOnOtherTab() throws Exception {
        VerifyPageReady(10);
        Wait(OTHER_TAB, 30);
        click(OTHER_TAB);
        logReport("Successfully clicked on Other tab.");

    }

    public void clickOnFeesAndDiscountsTab() throws Exception {
        VerifyPageReady(10);
        Wait(FEES_DISCOUNTS_TAB, 30);
        click(FEES_DISCOUNTS_TAB);
        logReport("Successfully clicked on Fees & Discounts tab.");

    }

    public void clickOnMerchandiseTab() throws Exception {
        scrollTop();
        VerifyPageReady(10);
        Wait(MERCHANDISE_TAB, 30);
        click(MERCHANDISE_TAB);
        logReport("Successfully clicked on Merchandise tab.");

    }

    public void selectTagValue(String tag) throws Exception {
        scrollIntoView(TAG_DROPDOWN);
        if (tag != null && !tag.isEmpty()) {
            Wait(TAG_DROPDOWN, 10);
            Select dropDown = new Select(TAG_DROPDOWN);
            dropDown.selectByVisibleText(tag);
            // select(TAG_DROPDOWN, tag);
            logReport("Selected tag value " + tag);
        }
    }

    public boolean isLocationValueFound(String locType) {
        boolean found = false;
        if (LOCATION_DROPDOWN_LIST.size() > 0) {
            for (WebElement e : LOCATION_DROPDOWN_LIST) {
                if (e.getText().trim().equalsIgnoreCase(locType)) {
                    logReport("Location type found and clicked successfully");
                    found = true;
                    break;
                }
            }
        }
        return found;
    }


    public void selectLocationValue(String locType) throws Exception {
        scrollIntoView(LOCATION_BUTTON);
        Wait(LOCATION_BUTTON, 10);
        clickByJavaScript(LOCATION_BUTTON);
        logReport("Location button clicked");
        if (isLocationValueFound(locType)) {
            for (WebElement e : LOCATION_DROPDOWN_LIST) {
                if (e.getText().trim().equalsIgnoreCase(locType)) {
                    logReport("Location type found and clicked successfully");
                    //e.click();
                    clickByJavaScript(e);

                }
            }
        } else {
            type(LOCATION_TEXTBOX, locType);
            logReport("Entered location text value " + locType);
            click(LOCATION_ADDNEW_BUTTON);
            logReport("Location add new button clicked successfully");
            //click(LOCATION_BUTTON);
            logReport("Location button clicked");
        }
    }

    public boolean isTrackValueFound(String trackType) {
        boolean found = false;
        if (TRACK_DROPDOWN_LIST.size() > 0) {
            for (WebElement e : TRACK_DROPDOWN_LIST) {
                if (e.getText().trim().equalsIgnoreCase(trackType)) {
                    logReport("Track type found and clicked successfully");
                    found = true;
                    break;
                }
            }
        }
        return found;
    }

    public void selectTrackValue(String trackType) throws Exception {
        logReport("Track function");
        scrollIntoView(TRACK_BUTTON);
        Wait(TRACK_BUTTON, 10);
        clickByJavaScript(TRACK_BUTTON);
        logReport("Track button clicked");
        if (isTrackValueFound(trackType)) {
            for (WebElement e : TRACK_DROPDOWN_LIST) {
                if (e.getText().trim().equalsIgnoreCase(trackType)) {
                    logReport("Track found and clicked successfully");
                    //e.click();
                    clickByJavaScript(e);

                }
            }
        } else {
            type(TRACK_TEXTBOX, trackType);
            logReport("Entered track text value " + trackType);
            click(TRACK_ADDNEW_BUTTON);
            logReport("Track add new button clicked successfully");
            // click(TRACK_BUTTON);
            logReport("Track button clicked");
        }
    }

    public boolean isGroupValueFound(String groupType) {
        boolean found = false;
        if (GROUP_DROPDOWN_LIST.size() > 0) {
            for (WebElement e : GROUP_DROPDOWN_LIST) {
                if (e.getText().trim().equalsIgnoreCase(groupType)) {
                    logReport("Group type found and clicked successfully");
                    found = true;
                    break;
                }
            }
        }
        return found;
    }

    public List<String> getGroupValues() {
        List<String> groupList = new ArrayList<>();
        clickByJavaScript(GROUP_BUTTON);
        if (GROUP_DROPDOWN_LIST.size() > 0) {
            for (WebElement e : GROUP_DROPDOWN_LIST) {
                groupList.add(e.getText().trim());
            }
        }
        clickByJavaScript(GROUP_BUTTON);
        return groupList;
    }

    public List<String> getCustomTypeValues() {
        List<String> groupList = new ArrayList<>();
        clickByJavaScript(AGENDA_TYPE_BUTTON);
        if (AGENDA_DROPDOWN_LIST.size() > 0) {
            for (WebElement e : AGENDA_DROPDOWN_LIST) {
                groupList.add(e.getText().trim());
            }
        }
        clickByJavaScript(GROUP_BUTTON);
        return groupList;
    }

    public List<String> getCustomTypeValuesForFeeAndDiscount() {
        List<String> customTypeList = new ArrayList<>();
        clickByJavaScript(AGENDA_TYPE_BUTTON);
        if (AGENDA_DROPDOWN_LIST.size() > 0) {
            for (WebElement e : AGENDA_DROPDOWN_LIST) {
                customTypeList.add(e.getText().trim());
            }
        }
        // clickByJavaScript(GROUP_BUTTON);
        return customTypeList;
    }

    public List<String> getLocationValues() {
        List<String> groupList = new ArrayList<>();
        clickByJavaScript(LOCATION_BUTTON);
        if (LOCATION_DROPDOWN_LIST.size() > 0) {
            for (WebElement e : LOCATION_DROPDOWN_LIST) {
                groupList.add(e.getText().trim());
            }
        }
        clickByJavaScript(LOCATION_BUTTON);
        return groupList;
    }

    public List<String> getTrackValues() {
        List<String> groupList = new ArrayList<>();
        clickByJavaScript(TRACK_BUTTON);
        if (TRACK_DROPDOWN_LIST.size() > 0) {
            for (WebElement e : TRACK_DROPDOWN_LIST) {
                groupList.add(e.getText().trim());
            }
        }
        clickByJavaScript(TRACK_BUTTON);
        return groupList;
    }

    public List<String> getClassificationValues() {
        List<String> classificationList = new ArrayList<>();
        clickByJavaScript(CLASSIFICATION_BUTTON);
        if (CLASSIFICATION_DROPDOWN_LIST.size() > 0) {
            for (WebElement e : CLASSIFICATION_DROPDOWN_LIST) {
                classificationList.add(e.getText().trim());
            }
        }
        clickByJavaScript(CLASSIFICATION_BUTTON);
        return classificationList;
    }


    public void selectGroupValue(String groupType) throws Exception {
        scrollIntoView(GROUP_BUTTON);
        Wait(GROUP_BUTTON, 10);
        clickByJavaScript(GROUP_BUTTON);
        logReport("Group button clicked");
        if (isGroupValueFound(groupType)) {
            for (WebElement e : GROUP_DROPDOWN_LIST) {
                if (e.getText().trim().equalsIgnoreCase(groupType)) {
                    logReport("Group type found and clicked successfully");
                    // e.click();
                    clickByJavaScript(e);

                }
            }
        } else {
            type(GROUP_TEXTBOX, groupType);
            logReport("Entered group text value " + groupType);
            click(GROUP_ADDNEW_BUTTON);
            logReport("Group add new button clicked successfully");
            //click(GROUP_BUTTON);
            logReport("Group button clicked");
        }
    }

    public void switchToLabelIframe() {
        scrollIntoView(LABEL_IFRAME);
        browser.switchTo().frame(LABEL_IFRAME);
    }

    public void switchToDescriptionIframe() {
        scrollIntoView(DESCRIPTION_IFRAME);
        browser.switchTo().frame(DESCRIPTION_IFRAME);
    }




    public void enterLabelValue(String label) {
        //scrollDown();
        //scrollIntoView();
        switchToLabelIframe();
        browser.findElement(By.cssSelector("body")).sendKeys(label);
        logReport("Entered label value " + label);
        browser.switchTo().defaultContent();
    }

    public void enterDescriptionValue(String desc) {
        switchToDescriptionIframe();
        browser.findElement(By.cssSelector("body")).sendKeys(desc);
        logReport("Entered description value " + desc);
        browser.switchTo().defaultContent();
    }

    public void enterRegistrationFeeDetails(FeeStructureData feeStructureData, int rowNo) throws Exception {
        if (!feeStructureData.getFeeType().equalsIgnoreCase("None")) {
            WebElement addAnotherFee = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index']/following-sibling::div//button[text()='Add another Fee Schedule']"));

            if (rowNo > 1) {
                click(addAnotherFee);
            }
            WebElement date = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index'][" + rowNo + "]//input[@name='date']"));
            WebElement clock = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index'][1]//input[@class='form-control ng-pristine ng-valid'][@ng-model='feeItem.expDate']/..//following-sibling::div//a[@aria-label='Time']"));
            WebElement hours = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index'][" + rowNo + "]//table[@ng-model='feeItem.expDate']//input[@ng-model='hours']"));
            WebElement minutes = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index'][" + rowNo + "]//table[@ng-model='feeItem.expDate']//input[@ng-model='minutes']"));
            WebElement meridian = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index'][" + rowNo + "]//table[@ng-model='feeItem.expDate']//button[@ng-click='toggleMeridian()']"));

            WebElement feeCode = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index'][" + rowNo + "]//input[@ng-model='feeItem.code']"));
            WebElement label = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index'][" + rowNo + "]//input[@ng-model='feeItem.name']"));
            WebElement amount = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index'][" + rowNo + "]//input[@ng-model='feeItem.amount']"));
            WebElement glAccount = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index'][" + rowNo + "]//input[@ng-model='feeItem.glNum']"));

            type(date, feeStructureData.getExpirationDate(), true);
            logReport("Typed expiration date value " + feeStructureData.getExpirationDate());

            selectTime(hours, clock, minutes, meridian, feeStructureData.getExpirationTime());

            type(feeCode, feeStructureData.getUniqueFeeCode(), true);
            logReport("Typed Fee code " + feeStructureData.getUniqueFeeCode());
            type(label, feeStructureData.getLabelRegForm(), true);
            logReport("Typed Display form value" + feeStructureData.getLabelRegForm());
            type(amount, feeStructureData.getAmount(), true);
            logReport("Typed Amount code " + feeStructureData.getAmount());
            type(glAccount, feeStructureData.getGlAccount(), true);
            logReport("Typed Gl Amount code " + feeStructureData.getGlAccount());
        }
    }

    public void enterRegistrationFeeDetailsByCurrentDate(FeeStructureData feeStructureData, int rowNo, int days) throws Exception {
        if (!feeStructureData.getFeeType().equalsIgnoreCase("None")) {
            WebElement addAnotherFee = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index']/following-sibling::div//button[text()='Add another Fee Schedule']"));

            if (rowNo > 1) {
                click(addAnotherFee);
            }
            WebElement date = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index'][" + rowNo + "]//input[@class='form-control ng-isolate-scope ng-pristine ng-valid ng-valid-date']"));
            WebElement clock = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index'][" + rowNo + "]//input[@class='form-control ng-pristine ng-valid'][@ng-model='feeItem.expDate']/..//following-sibling::div//a[@id='dLabel']"));
            WebElement hours = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index'][" + rowNo + "]//table[@ng-model='feeItem.expDate']//input[@ng-model='hours']"));
            WebElement minutes = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index'][" + rowNo + "]//table[@ng-model='feeItem.expDate']//input[@ng-model='minutes']"));
            WebElement meridian = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index'][" + rowNo + "]//table[@ng-model='feeItem.expDate']//button[@ng-click='toggleMeridian()']"));

            WebElement feeCode = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index'][" + rowNo + "]//input[@ng-model='feeItem.code']"));
            WebElement label = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index'][" + rowNo + "]//input[@ng-model='feeItem.name']"));
            WebElement amount = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index'][" + rowNo + "]//input[@ng-model='feeItem.amount']"));
            WebElement glAccount = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index'][" + rowNo + "]//input[@ng-model='feeItem.glNum']"));

            String nextDaysDateValue = addDaysInDate(getCurrentDate("MM/dd/yyyy"), days, "MM/dd/yyyy");
            type(date, nextDaysDateValue, true);
            logReport("Typed expiration date value " + nextDaysDateValue);

            selectTime(hours, clock, minutes, meridian, feeStructureData.getExpirationTime());

            type(feeCode, feeStructureData.getUniqueFeeCode(), true);
            logReport("Typed Fee code " + feeStructureData.getUniqueFeeCode());
            type(label, feeStructureData.getLabelRegForm(), true);
            logReport("Typed Display form value" + feeStructureData.getLabelRegForm());
            type(amount, feeStructureData.getAmount(), true);
            logReport("Typed Amount code " + feeStructureData.getAmount());
            type(glAccount, feeStructureData.getGlAccount(), true);
            logReport("Typed Gl Amount code " + feeStructureData.getGlAccount());
        }
    }

    public void enterMerchandiseRegistrationFeeDetails(FeeStructureData feeStructureData, int rowNo) throws Exception {
        if (!feeStructureData.getFeeType().equalsIgnoreCase("None")) {
            WebElement addAnotherFee = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees']/following-sibling::div//button[text()='Add another Fee Schedule']"));

            if (rowNo > 1) {
                click(addAnotherFee);
            }
            WebElement date = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees'][" + rowNo + "]//input[@class='form-control ng-isolate-scope ng-pristine ng-valid ng-valid-date']"));
            WebElement clock = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees'][" + rowNo + "]//input[@class='form-control ng-pristine ng-valid'][@ng-model='feeItem.expDate']/..//following-sibling::div//a[@aria-label='Time']"));
            WebElement hours = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees'][" + rowNo + "]//table[@ng-model='feeItem.expDate']//input[@ng-model='hours']"));
            WebElement minutes = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees'][" + rowNo + "]//table[@ng-model='feeItem.expDate']//input[@ng-model='minutes']"));
            WebElement meridian = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees'][" + rowNo + "]//table[@ng-model='feeItem.expDate']//button[@ng-click='toggleMeridian()']"));

            WebElement feeCode = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees'][" + rowNo + "]//input[@ng-model='feeItem.code']"));
            WebElement label = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees'][" + rowNo + "]//input[@ng-model='feeItem.name']"));
            WebElement amount = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees'][" + rowNo + "]//input[@ng-model='feeItem.amount']"));
            WebElement glAccount = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees'][" + rowNo + "]//input[@ng-model='feeItem.glNum']"));

            type(date, feeStructureData.getExpirationDate(), true);
            logReport("Typed expiration date value " + feeStructureData.getExpirationDate());

            selectTime(hours, clock, minutes, meridian, feeStructureData.getExpirationTime());

            type(feeCode, feeStructureData.getUniqueFeeCode(), true);
            logReport("Typed Fee code " + feeStructureData.getUniqueFeeCode());
            type(label, feeStructureData.getLabelRegForm(), true);
            logReport("Typed Display form value" + feeStructureData.getLabelRegForm());
            type(amount, feeStructureData.getAmount(), true);
            logReport("Typed Amount code " + feeStructureData.getAmount());
            type(glAccount, feeStructureData.getGlAccount(), true);
            logReport("Typed Gl Amount code " + feeStructureData.getGlAccount());
        }
    }

    public void enterCancellationFeeDetails(FeeStructureData feeStructureData, int rowNo) throws Exception {
        if (verifyElementDisplayed(CANCELLATION_ITEM_CHK, 0)) {
            if (CANCELLATION_ITEM_CHK.isSelected()) {
                WebElement addAnotherFee = browser.findElement(By.xpath("//div[@ng-if='isCancelledEnable.value']//button[text()='Add another Fee Schedule']"));

                if (rowNo > 1) {
                    click(addAnotherFee);
                }
                WebElement date = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in cancelFees track by $index'][" + rowNo + "]//input[@class='form-control ng-isolate-scope ng-pristine ng-valid ng-valid-date']"));

                WebElement clock = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in cancelFees track by $index'][" + rowNo + "]//input[@class='form-control ng-pristine ng-valid'][@ng-model='feeItem.expDate']/..//following-sibling::div//a[@aria-label='Time']"));
                WebElement hours = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in cancelFees track by $index'][" + rowNo + "]//table[@ng-model='feeItem.expDate']//input[@ng-model='hours']"));
                WebElement minutes = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in cancelFees track by $index'][" + rowNo + "]//table[@ng-model='feeItem.expDate']//input[@ng-model='minutes']"));
                WebElement meridian = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in cancelFees track by $index'][" + rowNo + "]//table[@ng-model='feeItem.expDate']//button[@ng-click='toggleMeridian()']"));

                WebElement feeCode = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in cancelFees track by $index'][" + rowNo + "]//input[@ng-model='feeItem.code']"));
                WebElement label = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in cancelFees track by $index'][" + rowNo + "]//input[@ng-model='feeItem.name']"));
                WebElement amount = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in cancelFees track by $index'][" + rowNo + "]//input[@ng-model='feeItem.amount']"));
                WebElement glAccount = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in cancelFees track by $index'][" + rowNo + "]//input[@ng-model='feeItem.glNum']"));

                type(date, feeStructureData.getExpirationDate(), true);
                logReport("Typed expiration date value " + feeStructureData.getExpirationDate());
                selectTime(hours, clock, minutes, meridian, feeStructureData.getExpirationTime());
                type(feeCode, feeStructureData.getUniqueFeeCode(), true);
                logReport("Typed Fee code " + feeStructureData.getUniqueFeeCode());
                type(label, feeStructureData.getLabelRegForm(), true);
                logReport("Typed Display form value" + feeStructureData.getLabelRegForm());
                type(amount, feeStructureData.getAmount(), true);
                logReport("Typed Amount code " + feeStructureData.getAmount());
                type(glAccount, feeStructureData.getGlAccount(), true);
                logReport("Typed Gl Amount code " + feeStructureData.getGlAccount());
            }
        }

    }

    public void enterCancellationFeeDetailsByCurrentDate(FeeStructureData feeStructureData, int rowNo, int days) throws Exception {
        if (verifyElementDisplayed(CANCELLATION_ITEM_CHK, 0)) {
            if (CANCELLATION_ITEM_CHK.isSelected()) {
                WebElement addAnotherFee = browser.findElement(By.xpath("//div[@ng-if='isCancelledEnable.value']//button[text()='Add another Fee Schedule']"));

                if (rowNo > 1) {
                    clickByJavaScript(addAnotherFee);
                }
                WebElement date = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in cancelFees track by $index'][" + rowNo + "]//input[@class='form-control ng-isolate-scope ng-pristine ng-valid ng-valid-date']"));

                WebElement clock = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in cancelFees track by $index'][" + rowNo + "]//input[@class='form-control ng-pristine ng-valid'][@ng-model='feeItem.expDate']/..//following-sibling::div//a[@id='dLabel']"));
                WebElement hours = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in cancelFees track by $index'][" + rowNo + "]//table[@ng-model='feeItem.expDate']//input[@ng-model='hours']"));
                WebElement minutes = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in cancelFees track by $index'][" + rowNo + "]//table[@ng-model='feeItem.expDate']//input[@ng-model='minutes']"));
                WebElement meridian = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in cancelFees track by $index'][" + rowNo + "]//table[@ng-model='feeItem.expDate']//button[@ng-click='toggleMeridian()']"));

                WebElement feeCode = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in cancelFees track by $index'][" + rowNo + "]//input[@ng-model='feeItem.code']"));
                WebElement label = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in cancelFees track by $index'][" + rowNo + "]//input[@ng-model='feeItem.name']"));
                WebElement amount = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in cancelFees track by $index'][" + rowNo + "]//input[@ng-model='feeItem.amount']"));
                WebElement glAccount = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in cancelFees track by $index'][" + rowNo + "]//input[@ng-model='feeItem.glNum']"));

                String nextDaysDateValue = addDaysInDate(getCurrentDate("MM/dd/yyyy"), days, "MM/dd/yyyy");
                type(date, nextDaysDateValue, true);

                logReport("Typed expiration date value " + nextDaysDateValue);
                selectTime(hours, clock, minutes, meridian, feeStructureData.getExpirationTime());
                type(feeCode, "CF" + feeStructureData.getUniqueFeeCode(), true);
                logReport("Typed Fee code " + feeStructureData.getUniqueFeeCode());
                type(label, feeStructureData.getLabelRegForm(), true);
                logReport("Typed Display form value" + feeStructureData.getLabelRegForm());
                type(amount, feeStructureData.getAmount(), true);
                logReport("Typed Amount code " + feeStructureData.getAmount());
                type(glAccount, feeStructureData.getGlAccount(), true);
                logReport("Typed Gl Amount code " + feeStructureData.getGlAccount());
            }
        }

    }

    public void selectTime(WebElement hoursW, WebElement clockW, WebElement minW, WebElement meridianW, String startTime) throws Exception {
        String[] times = startTime.split(":");
        String hours = times[0];
        String minutes = times[1].substring(0, 2);
        String meridian = times[1].substring(2, times[1].length());
        Wait(clockW, 10);
        clickByJavaScript(clockW);
        Wait(hoursW, 10);
        type(hoursW, hours, true);
        type(minW, minutes, true);
        WebElement element = meridianW;
        if (!element.getText().equalsIgnoreCase(meridian)) {
            element.click();
        }
        clickByJavaScript(clockW);
        logReport("Entered Value: " + startTime + " in 'Expiration Time' TextBox");
    }
    public void enterNotesValue(String notes) {
        scrollDown();
        type(NOTES_TEXTAREA, notes, true);
        logReport("Entered notes value " + notes);

    }

    public void clickSaveAndNewButton() throws Exception {
        Wait(SAVE_NEW_BUTTON, 20);
        clickByJavaScript(SAVE_NEW_BUTTON);
        logReport("Save and new button clicked successfully");
        VerifyPageReady(10);
    }

    public void clickCancelButton() throws Exception {
        Wait(CANCEL_BUTTON, 20);
        clickByJavaScript(CANCEL_BUTTON);
        logReport("Cancel button clicked successfully");
        VerifyPageReady(10);
    }

    public void selectFeeStructure(String feeType) throws Exception {
        String xpath = "//label[contains(.,'"+feeType+"')]//input";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 30);
        clickByJavaScript(element);
        logReport("Successfully clicked on "+feeType+" fee structure radio button.");

    }

    private void selectTaxRules(String rule) throws Exception {
        // VerifyPageReady(30);
        Wait(TAX_RULES_DROPDOWN, 30);
        select(TAX_RULES_DROPDOWN, rule);
        logReport("Successfully selected: " + rule + " in Tax rule textbox.");
    }
    private void selectDiscountRules(String rule) throws Exception {
        //  VerifyPageReady(30);
        Wait(DISCOUNT_RULES_DROPDOWN, 30);
        select(DISCOUNT_RULES_DROPDOWN, rule);
        logReport("Successfully selected: " + rule + " in discount rule textbox.");
    }

    private void enterUniqueFeeCode(String code) throws Exception {
        // VerifyPageReady(30);
        Wait(UNIQUE_FEECODE_TEXTBOX, 30);
        type(UNIQUE_FEECODE_TEXTBOX, code);
        logReport("Successfully entered: " + code + " in unique fee code textbox.");
    }

    private void enterLabelRegForm(String label) throws Exception {
        // VerifyPageReady(30);
        Wait(LABEL_REGFORM_TEXTBOX, 30);
        type(LABEL_REGFORM_TEXTBOX, label);
        logReport("Successfully entered: " + label + " in label reg form textbox.");
    }

    private void enterPercentage(String percentage) throws Exception {
        // VerifyPageReady(30);
        Wait(PERCENTAGE_TEXTBOX, 30);
        type(PERCENTAGE_TEXTBOX, percentage);
        logReport("Successfully entered: " + percentage + " in %Percentage textbox.");
    }

    private void enterAmount(String amount) throws Exception {
        // VerifyPageReady(30);
        Wait(AMOUNTTAX_TEXTBOX, 30);
        type(AMOUNTTAX_TEXTBOX, amount);
        logReport("Successfully entered: " + amount + " in Amount textbox.");
    }

    private void enterGLAccount(String accountNo) throws Exception {
        //  VerifyPageReady(30);
        Wait(GL_ACCOUNT_TEXTBOX, 30);
        type(GL_ACCOUNT_TEXTBOX, accountNo);
        logReport("Successfully entered: " + accountNo + " in General Ledger Account textbox.");
    }

    public void fillPercentageAndTaxFeeStructure(FeeStructureData feeStructureData) throws Exception {
        enterUniqueFeeCode(feeStructureData.getUniqueFeeCode());
        enterLabelRegForm(feeStructureData.getLabelRegForm());
        enterPercentage(feeStructureData.getPercentage());
        enterGLAccount(feeStructureData.getGlAccount());
    }

    public void fillShippingHandlingFeeStructure(FeeStructureData feeStructureData) throws Exception {
        enterUniqueFeeCode(feeStructureData.getUniqueFeeCode());
        enterLabelRegForm(feeStructureData.getLabelRegForm());
        enterAmount(feeStructureData.getAmount());
        enterGLAccount(feeStructureData.getGlAccount());
    }

    public FeeStructureData getPercentageAndTaxFeeData() {
        String feeType = getFeeType();
        String discountRules = getSelectedOption(DISCOUNT_RULES_DROPDOWN);
        String uniqueFeeCode = UNIQUE_FEECODE_TEXTBOX.getAttribute("value").trim();
        String label = LABEL_REGFORM_TEXTBOX.getAttribute("value").trim();
        String percentage = PERCENTAGE_TEXTBOX.getAttribute("value").trim();
        String glAccount = GL_ACCOUNT_TEXTBOX.getAttribute("value").trim();
        FeeStructureData feeStructureData = new FeeStructureData(feeType, discountRules, uniqueFeeCode, label, "", glAccount, percentage);
        return feeStructureData;
    }

    public FeeStructureData getShippingHandlingFeeData() {
        String feeType = getFeeType();
        String discountRules = getSelectedOption(DISCOUNT_RULES_DROPDOWN);
        String uniqueFeeCode = UNIQUE_FEECODE_TEXTBOX.getAttribute("value").trim();
        String label = LABEL_REGFORM_TEXTBOX.getAttribute("value").trim();
        String amount = AMOUNTTAX_TEXTBOX.getAttribute("value").trim();
        String glAccount = GL_ACCOUNT_TEXTBOX.getAttribute("value").trim();
        FeeStructureData feeStructureData = new FeeStructureData(feeType, discountRules, uniqueFeeCode, label, amount, glAccount, "");
        return feeStructureData;
    }
    public void fillScheduledAgendaDetails(AddAgenda addAgendaData) throws Exception {
        enterName(addAgendaData.getAgendaName());
        selectAgendaType(addAgendaData.getAgendaType());
        enterUniqueCode(addAgendaData.getUniqueCode());
        enterSortOrder(addAgendaData.getSortOrder());
        enterCEU(addAgendaData.getCeu());
        enterPoints(addAgendaData.getPoints());
        enterCapacity(addAgendaData.getCapacity());
        enterMaximumOrder(addAgendaData.getMaxOrder());
        enterStartDate(addAgendaData.getStartDate());
        enterStartTime(addAgendaData.getStartTime());
        enterEndDate(addAgendaData.getEndDate());
        enterEndTime(addAgendaData.getEndTime());
        selectTagValue(addAgendaData.getTags());
        selectLocationValue(addAgendaData.getLocation());
        selectTrackValue(addAgendaData.getTrack());
        selectGroupValue(addAgendaData.getGroup());
        enterLabelValue(addAgendaData.getLabelText());
        enterDescriptionValue(addAgendaData.getDescriptionText());
        enterNotesValue(addAgendaData.getUserNotes());
    }

    public void fillFeesDiscountsAgendaDetails(AddAgenda addAgendaData) throws Exception {
        enterName(addAgendaData.getAgendaName());
        selectAgendaType(addAgendaData.getAgendaType());
        enterUniqueCode(addAgendaData.getUniqueCode());
        enterSortOrder(addAgendaData.getSortOrder());
        enterLabelValue(addAgendaData.getLabelText());
        enterDescriptionValue(addAgendaData.getDescriptionText());
        enterNotesValue(addAgendaData.getUserNotes());
    }

    public void checkUncheckCancellationItem(String val) {
        if (Boolean.valueOf(val)) {
            checkByJavascript(CANCELLATION_ITEM_CHK);
            logReport("Cancellation item checkbox checked successfully");
        } else {
            uncheckByJavascript(CANCELLATION_ITEM_CHK);
            logReport("Cancellation item checkbox unchecked successfully");
        }
    }

    public void fillScheduledAndMerchandiseFeeDetails(FeeStructureData feeStructureData) throws Exception {
        selectFeeStructure(feeStructureData.getFeeType());
        if (feeStructureData.getFeeType().equalsIgnoreCase("None")) {
            logReport("no need to select fees");
        } else {
            selectTaxRules(feeStructureData.getTaxRules());
            selectDiscountRules(feeStructureData.getDiscountRules());
            checkUncheckCancellationItem(feeStructureData.getCancellationFeeChk());
        }
    }

    public void fillFeesAndOtherFeeDetails(FeeStructureData feeStructureData) throws Exception {
        selectFeeStructure(feeStructureData.getFeeType());
        if (feeStructureData.getFeeType().equalsIgnoreCase("None")) {
            logReport("no need to select fees");
        } else if (feeStructureData.getFeeType().equalsIgnoreCase("Fixed Fee/Discount")) {
            selectTaxRules(feeStructureData.getTaxRules());
            selectDiscountRules(feeStructureData.getDiscountRules());
            checkUncheckCancellationItem(feeStructureData.getCancellationFeeChk());
        } else {
            selectDiscountRules(feeStructureData.getDiscountRules());
        }

    }


    public boolean isClassificationValueFound(String type) {
        boolean found = false;
        if (CLASSIFICATION_DROPDOWN_LIST.size() > 0) {
            for (WebElement e : CLASSIFICATION_DROPDOWN_LIST) {
                if (e.getText().trim().equalsIgnoreCase(type)) {
                    logReport("Classification type found and clicked successfully");
                    found = true;
                    break;
                }
            }
        }
        return found;
    }

    public void selectClassificationValue(String type) throws Exception {
        Wait(CLASSIFICATION_BUTTON, 10);
        clickByJavaScript(CLASSIFICATION_BUTTON);
        logReport("Classification button clicked");
        if (isClassificationValueFound(type)) {
            for (WebElement e : CLASSIFICATION_DROPDOWN_LIST) {
                if (e.getText().trim().equalsIgnoreCase(type)) {
                    logReport("Classification type found and clicked successfully");
                    e.click();

                }
            }
        } else {
            type(CLASSIFICATION_TEXTBOX, type);
            logReport("Entered Classification text value " + type);
            click(CLASSIFICATION_ADDNEW_BUTTON);
            logReport("Classification add new button clicked successfully");
            click(CLASSIFICATION_BUTTON);
            logReport("Classification button clicked");
        }
    }

    public void fillMerchandiseAgendaDetails(AddAgenda addAgendaData) throws Exception {
        enterName(addAgendaData.getAgendaName());
        selectAgendaType(addAgendaData.getAgendaType());
        enterUniqueCode(addAgendaData.getUniqueCode());
        enterSortOrder(addAgendaData.getSortOrder());
        enterCapacity(addAgendaData.getCapacity());
        enterMaximumOrder(addAgendaData.getMaxOrder());
        selectClassificationValue(addAgendaData.getClassification());
        selectGroupValue(addAgendaData.getGroup());
        enterLabelValue(addAgendaData.getLabelText());
        enterDescriptionValue(addAgendaData.getDescriptionText());
        enterNotesValue(addAgendaData.getUserNotes());
    }

    public AddAgenda getAgendaDetails() throws Exception {
        Wait(AGENDA_NAME_TEXTBOX, 10);
        String agendaName = AGENDA_NAME_TEXTBOX.getAttribute("value").trim();
        String type = AGENDA_TYPE_BUTTON.getText().trim();
        String agendaCode = UNIQUE_CODE_TEXTBOX.getAttribute("value").trim();
        String sortOrder = SORT_ORDER_TEXTBOX.getAttribute("value").trim();
        String ceu = CEU_TEXTBOX.getAttribute("value").trim();
        String points = POINTS_TEXTBOX.getAttribute("value").trim();
        String capacity = CAPACITY_TEXTBOX.getAttribute("value").trim();
        String maxOrder = MAXIMUM_ORDER_TEXTBOX.getAttribute("value").trim();
        String startDate = START_DATE_TEXTBOX.getAttribute("value").trim();
        String startTime = START_TIME.getAttribute("value").trim().replace(" ", "");
        String endDate = END_DATE_TEXTBOX.getAttribute("value").trim();
        String endTime = END_TIME.getAttribute("value").trim().replace(" ", "");
        String tags = getSelectedOption(TAG_DROPDOWN);
        String location = LOCATION_BUTTON.getText().trim();
        String track = TRACK_BUTTON.getText().trim();
        String group = GROUP_BUTTON.getText().trim();
        String label = getLabelValue();
        String desc = getDescriptionValue();
        String notes = getNotesValue();

        AddAgenda addAgenda = new AddAgenda(type, agendaName, agendaCode, startDate, startTime, endDate, endTime, sortOrder, ceu, capacity, maxOrder, points,
                tags, location, track, group, label, desc, notes, "");
        logReport("Actual value of agenda data " + addAgenda);
        return addAgenda;
    }

    public AddAgenda getAgendaMerchandiseDetails() throws Exception {
        Wait(AGENDA_NAME_TEXTBOX, 10);
        String agendaName = AGENDA_NAME_TEXTBOX.getAttribute("value").trim();
        String type = AGENDA_TYPE_BUTTON.getText().trim();
        String agendaCode = UNIQUE_CODE_TEXTBOX.getAttribute("value").trim();
        String sortOrder = SORT_ORDER_TEXTBOX.getAttribute("value").trim();
        String capacity = CAPACITY_TEXTBOX.getAttribute("value").trim();
        String maxOrder = MAXIMUM_ORDER_TEXTBOX.getAttribute("value").trim();
        String group = GROUP_BUTTON.getText().trim();
        String label = getLabelValue();
        String desc = getDescriptionValue();
        String notes = getNotesValue();
        String classification = CLASSIFICATION_BUTTON.getText().trim();

        AddAgenda addAgenda = new AddAgenda(type, agendaName, agendaCode, sortOrder, capacity, maxOrder,
                group, label, desc, notes, classification);
        logReport("Actual value of agenda data " + addAgenda);
        return addAgenda;
    }

    public AddAgenda getAgendaFeeDiscountsDetails() throws Exception {
        Wait(AGENDA_NAME_TEXTBOX, 10);
        String agendaName = AGENDA_NAME_TEXTBOX.getAttribute("value").trim();
        String type = AGENDA_TYPE_BUTTON.getText().trim();
        String agendaCode = UNIQUE_CODE_TEXTBOX.getAttribute("value").trim();
        String sortOrder = SORT_ORDER_TEXTBOX.getAttribute("value").trim();
        String label = getLabelValue();
        String desc = getDescriptionValue();
        String notes = getNotesValue();


        AddAgenda addAgenda = new AddAgenda(type, agendaName, agendaCode, sortOrder, label, desc, notes);
        logReport("Actual value of agenda data " + addAgenda);
        return addAgenda;
    }

    public String getLabelValue() {
        switchToLabelIframe();
        String labelVal = browser.findElement(By.cssSelector("body")).getText().trim();
        browser.switchTo().defaultContent();
        return labelVal;
    }

    public String getDescriptionValue() {
        switchToDescriptionIframe();
        String labelVal = browser.findElement(By.cssSelector("body")).getText().trim();
        browser.switchTo().defaultContent();
        return labelVal;
    }

    public String getNotesValue() {
        String labelVal = NOTES_TEXTAREA.getAttribute("value").trim();
        return labelVal;
    }

    public FeeStructureData getAgendaCancellationFeeDetails(int rowNo) {
        String cancellationChk = String.valueOf(CANCELLATION_ITEM_CHK.isSelected());
        String feeType = getFeeType();
        String taxRules = getSelectedOption(TAX_RULES_DROPDOWN);
        String discountRules = getSelectedOption(DISCOUNT_RULES_DROPDOWN);
        WebElement date = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in cancelFees track by $index'][" + rowNo + "]//input[contains(@class,'ng-valid-date')]"));

        WebElement time = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in cancelFees track by $index'][" + rowNo + "]//a[@aria-label='Time']/../../..//input[@ng-model='feeItem.expDate']"));

        WebElement feeCode = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in cancelFees track by $index'][" + rowNo + "]//input[@ng-model='feeItem.code']"));
        WebElement label = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in cancelFees track by $index'][" + rowNo + "]//input[@ng-model='feeItem.name']"));
        WebElement amount = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in cancelFees track by $index'][" + rowNo + "]//input[@ng-model='feeItem.amount']"));
        WebElement glAccount = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in cancelFees track by $index'][" + rowNo + "]//input[@ng-model='feeItem.glNum']"));

        String dateValue = date.getAttribute("value").trim();
        String timeValue = time.getAttribute("value").trim().replace(" ", "");
        String feeCodeValue = feeCode.getAttribute("value").trim();
        String labelValue = label.getAttribute("value").trim();
        String amtValue = amount.getAttribute("value").trim();
        String glAccountVal = glAccount.getAttribute("value").trim();

        FeeStructureData feeStructureData = new FeeStructureData(feeType, taxRules, discountRules, dateValue, timeValue, feeCodeValue, labelValue, amtValue, glAccountVal, "", cancellationChk);
        return feeStructureData;
    }

    public FeeStructureData getAgendaRegistrationFeeDetails(int rowNo) {
        String feeType = getFeeType();
        String taxRules = getSelectedOption(TAX_RULES_DROPDOWN);
        String discountRules = getSelectedOption(DISCOUNT_RULES_DROPDOWN);

        WebElement date = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index'][" + rowNo + "]//input[contains(@class,'ng-valid-date')]"));
        WebElement time = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index'][" + rowNo + "]//a[@aria-label='Time']/../../..//input[@ng-model='feeItem.expDate']"));

        WebElement feeCode = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index'][" + rowNo + "]//input[@ng-model='feeItem.code']"));
        WebElement label = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index'][" + rowNo + "]//input[@ng-model='feeItem.name']"));
        WebElement amount = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index'][" + rowNo + "]//input[@ng-model='feeItem.amount']"));
        WebElement glAccount = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees track by $index'][" + rowNo + "]//input[@ng-model='feeItem.glNum']"));

        String dateValue = date.getAttribute("value").trim();
        String timeValue = time.getAttribute("value").trim().replace(" ", "");
        String feeCodeValue = feeCode.getAttribute("value").trim();
        String labelValue = label.getAttribute("value").trim();
        String amtValue = amount.getAttribute("value").trim();
        String glAccountVal = glAccount.getAttribute("value").trim();

        String cancellationChk = String.valueOf(CANCELLATION_ITEM_CHK.isSelected());

        FeeStructureData feeStructureData = new FeeStructureData(feeType, taxRules, discountRules, dateValue, timeValue, feeCodeValue, labelValue, amtValue, glAccountVal, "", cancellationChk);
        return feeStructureData;
    }

    public FeeStructureData getAgendaMerchandiseRegistrationFeeDetails(int rowNo) {
        String feeType = getFeeType();
        String taxRules = getSelectedOption(TAX_RULES_DROPDOWN);
        String discountRules = getSelectedOption(DISCOUNT_RULES_DROPDOWN);

        WebElement date = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees'][" + rowNo + "]//input[contains(@class,'ng-valid-date')]"));
        WebElement time = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees'][" + rowNo + "]//a[@aria-label='Time']/../../..//input[@ng-model='feeItem.expDate']"));

        WebElement feeCode = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees'][" + rowNo + "]//input[@ng-model='feeItem.code']"));
        WebElement label = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees'][" + rowNo + "]//input[@ng-model='feeItem.name']"));
        WebElement amount = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees'][" + rowNo + "]//input[@ng-model='feeItem.amount']"));
        WebElement glAccount = browser.findElement(By.xpath("//div[@ng-repeat='feeItem in regularFees'][" + rowNo + "]//input[@ng-model='feeItem.glNum']"));

        String dateValue = date.getAttribute("value").trim();
        String timeValue = time.getAttribute("value").trim().replace(" ", "");
        String feeCodeValue = feeCode.getAttribute("value").trim();
        String labelValue = label.getAttribute("value").trim();
        String amtValue = amount.getAttribute("value").trim();
        String glAccountVal = glAccount.getAttribute("value").trim();

        String cancellationChk = String.valueOf(CANCELLATION_ITEM_CHK.isSelected());

        FeeStructureData feeStructureData = new FeeStructureData(feeType, taxRules, discountRules, dateValue, timeValue, feeCodeValue, labelValue, amtValue, glAccountVal, "", cancellationChk);
        return feeStructureData;
    }

    public String getFeeType() {
        for (WebElement e : FEE_TYPE_RADIOBUTTON) {
            if (e.isSelected()) {
                WebElement element = e.findElement(By.xpath("./.."));
                return element.getText().trim();
            }
        }
        return null;


    }


}
