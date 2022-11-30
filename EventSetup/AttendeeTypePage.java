package pageObjects.EventSetup;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Agenda.AgendaPage;
import pageObjects.CommonActionsPage;
import pojo.AttendeeTypeData;
import pojo.FeeStructureData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by infoobjects on 8/18/2017.
 */
public class AttendeeTypePage extends CommonActionsPage{

    public AttendeeTypePage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//table[@id='type-list']//tr/td[2]")
    public List<WebElement> ATTENDEE_CODE_LIST;

    //table[@id='type-list']//tr/td[2]

    @FindBy(id = "create-link")
    public WebElement addNewButton;

    @FindBy(id = "txtRegCatName")
    public WebElement nameTextBox;

    @FindBy(id = "txtRegCatCode")
    public WebElement codeTextBox;

    @FindBy(id = "intRegCatOrder")
    public WebElement sortOrderTextBox;

    @FindBy(id = "txtRegCatLabel")
    public WebElement displayRegNameFormTextBox;

    @FindBy(id = "txtRegCatPasscode")
    public WebElement passcodeTextBox;

    @FindBy(id = "intRegCatInventory")
    public WebElement capacityTextBox;

    @FindBy(xpath = "//select[@id='intRegCatFrnRegStsId']")
    public WebElement defaultStatusDropdown;

    @FindBy(xpath = "//select[@id='existingTypeNameSelect']")
    public WebElement attendeeTypeGroupDropdown;


    @FindBy(id = "txtRegCatTypeName")
    public WebElement addNewTypeTextBox;

    @FindBy(id="txtRegCatConfHeader")
    public WebElement textHeaderTextArea;

    @FindBy(id="txtRegCatConfFooter")
    public WebElement textFooterTextArea;

    @FindBy(xpath = "//select[@id='regintFeeFrnFeeTypeId']")
    public WebElement regFeeTypeDropdown;

    @FindBy(xpath = "//select[@id='intRegCatFrnTaxCodeId']")
    public WebElement regTaxRulesDropdown;

    @FindBy(xpath = "//select[@id='intTypeIsDiscountable']")
    public WebElement regDiscountRuledDropdown;

    @FindBy(xpath = "//select[@id='regCancelintFeeFrnFeeTypeId']")
    public WebElement canceelationFeeTypeDropdown;

    @FindBy(xpath = "//input[@id='reg1dteFeeExpDatefixed']")
    public WebElement regFeeExpirationDateTextBox;

    @FindBy(xpath = "//select[@id='reg1dteFeeExpTimefixed']")
    public WebElement regFeeExpiryTimeDropdown;

    @FindBy(xpath = "//input[@id='reg1txtFeeCodefixed']")
    public WebElement regFeeCodeTextBox;

    @FindBy(xpath = "//input[@id='reg1txtFeeNamefixed']")
    public WebElement regFeeDisplayRegFormTextBox;

    @FindBy(xpath = "//input[@id='reg1txtFeeAmountfixed']")
    public WebElement regFeeAmountTextBox;

    @FindBy(xpath = "//input[@id='reg1txtFeeGLNumfixed']")
    public WebElement regFeeGLAccountBox;

    @FindBy(xpath = "//select[@id='NotAvailableCatIds']")
    public WebElement availableHotelRoomType;

    @FindBy(xpath = "//input[@value='-»']")
    public WebElement moveRightButton;

    @FindBy(xpath = "//input[@id='bitRegCatIsExhibitor']")
    public WebElement exhibitorManagementCheckbox;

    @FindBy(xpath = "//input[@id='submitForm']")
    public WebElement SAVE_BUTTON;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[contains(.,'Agenda')]")
    public WebElement AGENDA_TAB;

    //@FindBy(xpath = "//label[text()='Tags']//following-sibling::div[1]//select")
    @FindBy(xpath = "//select[@id='lstTagIds']")
    public WebElement TAGS_DROPDOWN;

    public void clickAddNewButton()throws Exception{
        addNewButton.click();
        logReport("Clicked on 'Add New Button'");
        VerifyPageReady(30);
    }

    public void enterAttendeeName(String attendeeName) {
        type(nameTextBox, attendeeName, true);
        logReport("Successfully enter " + attendeeName + " in name textbox.");
    }

    public void enterAttendeeCode(String attendeeCode) {
        type(codeTextBox, attendeeCode, true);
        logReport("Successfully enter " + attendeeCode + " in code textbox.");
    }

    private void enterSortOrder(String order){
        type(sortOrderTextBox, order, true);
        logReport("Successfully enter "+order+" in sort order textbox.");
    }


    public void enterDisplayRegForm(String regForm) {
        type(displayRegNameFormTextBox, regForm, true);
        logReport("Successfully enter "+regForm+" in display reg form textbox.");
    }

    public void enterRegDisplayFeeRegForm(String regForm) {
        type(regFeeDisplayRegFormTextBox, regForm, true);
        logReport("Successfully enter " + regForm + " in display reg form textbox.");
    }


    private void enterPassCode(String passCode){
        type(passcodeTextBox, passCode, true);
        logReport("Successfully enter "+passCode+" in pass code textbox.");
    }

    private void enterCapacity(String capacity){
        type(capacityTextBox, capacity, true);
        logReport("Successfully enter "+capacity+" in capacity textbox.");
    }

    private void selectDefaultStatus(String status){
        select(defaultStatusDropdown, status);
        logReport("Successfully selected "+status+" in default status dropdown.");
    }

    private void selectAttendeeTypeGroup(String groupName){
        select(attendeeTypeGroupDropdown, groupName);
        logReport("Successfully selected "+groupName+" in attendee type group dropdown.");
    }

    private void enterAddNewType(String typeValue){
        type(addNewTypeTextBox, typeValue, true);
        logReport("Successfully enter "+typeValue+" in new type textbox.");
    }

    private void selectRegistrationFeeType(String feeType){
        select(regFeeTypeDropdown, feeType);
        logReport("Successfully selected " + feeType + " in fee type dropdown.");
    }

    private void selectRegistrationTaxRules(String rule){
        select(regTaxRulesDropdown,rule);
        logReport("Successfully selected " + rule + " in tax rules dropdown.");
    }

    private void selectRegistrationDiscountRules(String rule){
        select(regDiscountRuledDropdown, rule);
        logReport("Successfully selected " + rule + " in registration rules dropdown.");
    }

    private void selectExpirationDate(String date){
        type(regFeeExpirationDateTextBox, date);
        logReport("Successfully enter "+date+" in expiration date textbox.");
    }

    private void selectExpirationTime(String time){
        select(regFeeExpiryTimeDropdown, time);
        logReport("Successfully selected " + time + " in expiration time dropdown.");
    }
    private void enterRegFeeCode(String code){
        type(regFeeCodeTextBox, code);
        logReport("Successfully enter "+code+" in reg fee code in textbox.");
    }

    private void enterDisplayForRegForm(String regForm){
        type(displayRegNameFormTextBox, regForm);
        logReport("Successfully enter "+regForm+" in display reg form in textbox.");

    }

    private void enterRegAmount(String amount){
        type(regFeeAmountTextBox, amount, true);
        logReport("Successfully enter " + amount + " in registration fee amount textbox.");

    }

    private void enterGLAccount(String account){
        type(regFeeGLAccountBox, account);
        logReport("Successfully enter " + account + " in registration fee GL account textbox.");

    }
    public void fillAttendeeTypeDetail(AttendeeTypeData attendeeTypeData){

        enterAttendeeName(attendeeTypeData.getName());
        enterAttendeeCode(attendeeTypeData.getCode());
        enterSortOrder(attendeeTypeData.getSortOrder());
        enterDisplayRegForm(attendeeTypeData.getDisplayRegForm());
        enterPassCode(attendeeTypeData.getPassCode());
        enterCapacity(attendeeTypeData.getCapacity());
        selectDefaultStatus(attendeeTypeData.getDefaultStatus());
        //  selectAttendeeTypeGroup(attendeeTypeData.getAttendeeGroup());
        enterAddNewType(attendeeTypeData.getAddNewType());

    }
    private void enterConfirmationHeaderText(String text){
        type(textHeaderTextArea, text);
        logReport("Successfully enter " + text + " in confirmation header textarea.");
    }

    private void enterConfirmationFooterText(String text){
        type(textFooterTextArea, text);
        logReport("Successfully enter " + text + " in confirmation footer textarea.");
    }

    public void fillConfirmationText(AttendeeTypeData attendeeTypeData){
        enterConfirmationHeaderText(attendeeTypeData.getConfirmationHeader());
        enterConfirmationFooterText(attendeeTypeData.getConfirmationFooter());
    }

    public void fillRegistrationFees(AttendeeTypeData attendeeTypeData){
        selectRegistrationFeeType(attendeeTypeData.getRegistrationFeeType());
        selectRegistrationTaxRules(attendeeTypeData.getRegistrationTaxRules());
        selectRegistrationDiscountRules(attendeeTypeData.getRegistrationDiscountRules());
        selectExpirationDate(attendeeTypeData.getExpiryDate());
        selectExpirationTime(attendeeTypeData.getTime());
        enterRegFeeCode(attendeeTypeData.getCode());
        enterRegDisplayFeeRegForm(attendeeTypeData.getDisplayRegForm());
        enterRegAmount(attendeeTypeData.getRegistrationFeeAmount());
        enterGLAccount(attendeeTypeData.getRegistrationFeeGLAccount());
    }

    /* public void fillCancellationFee(AttendeeTypeData attendeeTypeData){
         selectRegistrationFeeType(attendeeTypeData.getRegistrationFeeType());
         selectRegistrationTaxRules(attendeeTypeData.getRegistrationTaxRules());
         selectRegistrationDiscountRules(attendeeTypeData.getRegistrationDiscountRules());
         selectExpirationDate(attendeeTypeData.getExpiryDate());
         selectExpirationTime(attendeeTypeData.getTime());
         enterRegFeeCode(attendeeTypeData.getCode());
         enterDisplayRegForm(attendeeTypeData.getDisplayRegForm());
         enterRegAmount(attendeeTypeData.getRegistrationFeeAmount());
         enterGLAccount(attendeeTypeData.getRegistrationFeeGLAccount());
     }*/
    public void clickOnSaveButton()throws Exception{
        VerifyPageReady(30);
        Wait(SAVE_BUTTON, 30);
        click(SAVE_BUTTON);
        logReport("Successfully clicked on save button.");
    }

    public void fillAttendeeDetails(AttendeeTypeData attendeeTypeData){
        fillAttendeeTypeDetail(attendeeTypeData);
        fillConfirmationText(attendeeTypeData);
        fillRegistrationFees(attendeeTypeData);
    }

    public void fillMandatoryAttendeeTypeDetails(AttendeeTypeData attendeeTypeData) {
        enterAttendeeName(attendeeTypeData.getName());
    }


    public AgendaPage clickOnAgendaTab()throws Exception{
        VerifyPageReady(30);
        Wait(AGENDA_TAB, 30);
        click(AGENDA_TAB);
        logReport("Successfully clicked on agenda tab.");
        return new AgendaPage(browser);
    }

    public List<String> getAttendeeData() {
        String xpath = "//table[@id='type-list']//tr[2]//td[@class='tableContent']";
        List<WebElement> elements = browser.findElements(By.xpath(xpath));
        List<String> attendeeData = new ArrayList<>();
        for (WebElement e : elements) {
            attendeeData.add(e.getText().trim());
        }
        return attendeeData;
    }

    public boolean isAttendeeTypePresent(String attendeeCode) {
        for (WebElement e : ATTENDEE_CODE_LIST) {
            if (e.getText().trim().equalsIgnoreCase(attendeeCode)) {
                return true;
            }
        }
        return false;
    }

    public void fillMandatoryAttendeeTypeWithTagDetails(AttendeeTypeData attendeeTypeData) {
        enterAttendeeName(attendeeTypeData.getName());
        enterAttendeeCode(attendeeTypeData.getCode());
        enterDisplayRegForm(attendeeTypeData.getDisplayRegForm());
        enterCapacity(attendeeTypeData.getCapacity());
        selectDefaultStatus(attendeeTypeData.getDefaultStatus());
        selectTags(attendeeTypeData.getAttendeeTag());
    }

    private void selectTags(String tag) {
        String a[] = tag.split(",");
        for (int i = 0; i < a.length; i++) {
            select(TAGS_DROPDOWN, a[i].trim());
            logReport("Selected Tag is : " + a[i].trim());
        }
    }

    public void enterRegistrationFeeDetails(FeeStructureData feeStructureData, int rowNo) throws Exception {
        selectRegistrationFeeType(feeStructureData.getFeeType());
        if (feeStructureData.getFeeType().equalsIgnoreCase("None")) {
            logReport("no need to select fees");
        } else {
            selectRegistrationTaxRules(feeStructureData.getTaxRules());
            selectRegistrationDiscountRules(feeStructureData.getDiscountRules());

        }
        if (!feeStructureData.getFeeType().equalsIgnoreCase("None")) {
            selectExpirationDate(feeStructureData.getExpirationDate());
            // selectExpirationTime(feeStructureData.getExpirationTime());
            enterRegFeeCode(feeStructureData.getUniqueFeeCode());
            enterRegDisplayFeeRegForm(feeStructureData.getLabelRegForm());
            enterRegAmount(feeStructureData.getAmount());
            enterGLAccount(feeStructureData.getGlAccount());

        }
    }

    public void selectTime(WebElement hoursW, WebElement clockW, WebElement minW, WebElement meridianW, String startTime) throws Exception {
        String[] times = startTime.split(":");
        String hours = times[0];
        String minutes = times[1].substring(0, 2);
        String meridian = times[1].substring(2, times[1].length());
        Wait(clockW, 10);
        click(clockW);
        Wait(hoursW, 10);
        type(hoursW, hours, true);
        type(minW, minutes, true);
        WebElement element = meridianW;
        if (!element.getText().equalsIgnoreCase(meridian)) {
            element.click();
        }
        click(clockW);
        logReport("Entered Value: " + startTime + " in 'Expiration Time' TextBox");
    }


}
