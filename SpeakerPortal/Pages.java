package pageObjects.SpeakerPortal;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pageObjects.Sessions.AddCustomFieldsPage;
import pageObjects.Sessions.SessionLayoutPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pages extends CommonActionsPage {
    @FindBy(xpath = "//input[@value='Save']")
    public WebElement SAVE_BUTTON;
    @FindBy(xpath = "//a[@title='Settings']")
    public WebElement SETTINGS_TAB;

    @FindBy(xpath = "//input[@id='chooseProposalPeriod']")
    public WebElement CLOSE_PROPOSAL_PERIOD;

    @FindBy(xpath = "//a[@title='Pages']")
    public WebElement PAGES_TAB;

    @FindBy(xpath = "//div[@id='add-section']//span")
    public List<WebElement> ADD_FIELDS_BUTTON_LIST;

    @FindBy(xpath = "//div[@class='hidden-div']")
    public WebElement MOUSE_MOVE;

    @FindBy(xpath = "//button[@class='custom-field-button']//span[contains(.,'Standard')]")
    public WebElement STANDARD_FIELD_BUTTON;

    public static final String[] SESSION_DETAILS_INFO_LIST = {"Session Name", "Session Type", "Track", "Sub-track", "Tags", "Session Level", "Abstract File", "Abstract Description", "Session Description", "Session Notes"};

    @FindBy(xpath = "//button[@x-ng-click='addSections()']")
    public WebElement ADD_SECTIONS_BUTTON;

    @FindBy(xpath = "//button[@x-ng-click='saveSessionLayout()']")
    public WebElement SAVE_SESSION_LAYOUT_BUTTON;

    @FindBy(xpath = "//input[@ng-model='loginConfigStr.proposalPrompt']")
    public WebElement PROPOSAL_PROMPT;

    @FindBy(xpath = "//input[@ng-model='loginConfigStr.proposalButtonText']")
    public WebElement PROPOSAL_BUTTON;

    @FindBy(xpath = "//div[text()='My Information']/../../../..")
    public WebElement MYINFORMATION_SECTION;

    @FindBy(xpath = "//div[text()='My Sessions']/../../../..")
    public WebElement MYSESSION_SECTION;

    @FindBy(xpath = "//input[@value='Add New']")
    public WebElement ADDNEW_BUTTON;

    @FindBy(xpath = "//input[@ng-model='searchIonicon']")
    public WebElement SEARCH_ICON_TEXTBOX;

    @FindBy(xpath = "//input[@value='Done']")
    public WebElement DONE_BUTTON;

    @FindBy(xpath = "//input[@id='pageTitle']")
    public WebElement PAGE_TITLE_TEXTBOX;

    @FindBy(xpath = "//button[@ng-click='livePreview()']")
    public WebElement PREVIEW_SITE_BUTTON;

    @FindBy(xpath = "//li[@x-ng-click='tabPreview(this);']")
    public WebElement TABPREVIEW_BUTTON;

    @FindBy(xpath = "//li[@x-ng-click='webPreview(this);']")
    public WebElement DESKTOPPREVIEW_BUTTON;

    @FindBy(xpath = "//div[@class='modal-content']/..")
    public WebElement PREVIEW_MODE;

    @FindBy(xpath = "//span[@class='close']")
    public WebElement CLOSE_PREVIEW_WINDOW;

    @FindBy(xpath = "//div[@ng-show='layoutForm.status']")
    public WebElement BASIC_PAGE_LAYOUT;

    @FindBy(xpath = "//select[@x-ng-model='layoutForm.content.speakerTypes']")
    public WebElement SELECT_SPEAKER_TYPE;

    public static final String[] SPEAKER_DETAILS_INFO_LIST1 = {"Email", "Phone", "Organization", "Position", "Speaker Log in Information", "Address Line 1", "Address Line 2", "City", "Postal Code", "State", "Country", "Facebook", "Google+", "LinkedIn", "Twitter", "Bio"};
    @FindBy(xpath = "//button[@class='custom-field-button']//span[contains(.,'Add a Standard or existing Custom Field')]")
    public WebElement STANDARD_CUSTOMFIELD_BUTTON;

    public static final String[] SPEAKER_DETAILS_INFO_LIST = {"Prefix", "First Name", "Middle", "Last Name", "Suffix", "Username", "Password", "Confirm Password"};
    @FindBy(xpath = "//div[@ng-show='showSubmitter']//span")
    public WebElement SUBMITTER_TEXT;
    @FindBy(xpath = "//div[@ng-show='showMyInformation']//p[@class='green-font ng-scope ng-binding']")
    public WebElement SPEAKER_DETAILS_TEXT;
    @FindBy(xpath = "//div[contains(@ng-repeat,'section in speakerSections')]//span[@class='ng-scope ng-binding']")
    public List<WebElement> SPEAKER_DETAILS_INFO;
    @FindBy(xpath = "//div[@ng-show='showMyInformation']//label[@for='customFieldType']")
    public List<WebElement> SPEAKER_DETAILS_INFO1;

    @FindBy(xpath = "//div[@ng-show='showSessionDetail']//p[@class='green-font ng-scope ng-binding']")
    public WebElement SESSION_DETAILS_TEXT;

    @FindBy(xpath = "//div[@ng-show='showSessionDetail']//label[@for='customFieldType']")
    public List<WebElement> SESSION_DETAILS_INFO;

    @FindBy(xpath = "//div[contains(@ng-repeat,'section in sections')]//span[@class='ng-scope ng-binding']")
    public List<WebElement> SESSION_DETAILS_INFO1;

    @FindBy(xpath = "//button[@ng-click='copyForMySessionPage()']/span")
    public WebElement SESSION_BUTTON_TEXT;

    @FindBy(xpath = "//div[@ng-show='showAdditionalSpeakers']//span")
    public WebElement ADDITIONAL_SPEAKERS_TEXT;

    @FindBy(xpath = "//button[@x-ng-click='ok()']")
    public WebElement OK_BUTTON;

    @FindBy(xpath = "//input[@id='query']")
    public WebElement SEARCH_ADDFIELD_TEXTBOX;

    @FindBy(xpath = "//div[@class='modal-header ttu']//span[@class='close close-modal']")
    public WebElement CLOSE_ADD_ICON;

    @FindBy(xpath = "//p[text()='Add Field(s)']")
    public WebElement ADD_FIELDS_HEADER;

    @FindBy(xpath = "//span[text()='Back To Page List']")
    public WebElement BACKTOPAGELIST_BUTTON;

    @FindBy(xpath = "//button[contains(text(),'Edit')]")
    public WebElement EDIT_BUTTON;

    @FindBy(xpath = "//button[contains(text(),'Preview')]")
    public WebElement PREVIEW_BUTTON;

    @FindBy(xpath = "//div[@class='panel panel-default']/div[2]")
    public WebElement SESSION_PAGE_PREVIEW;

    @FindBy(xpath = "//input[@name='selectedSection']")
    public List<WebElement> STANDARDANDCUSTOMFIELDS;

    @FindBy(xpath = "//div[@ng-repeat='standardSection in standardSections | filter:query']")
    public List<WebElement> STANDARD_FIELDS;

    @FindBy(xpath = "//div[@ng-repeat='customField in customFields | filter:query']")
    public List<WebElement> CUSTOM_FIELDS;

    @FindBy(xpath = "//span[@ng-if='counts.standard > 0']/span")
    public WebElement STANDARD_TEXT_COUNT;

    @FindBy(xpath = "//span[@ng-if='counts.custom > 0']/span")
    public WebElement CUSTOM_TEXT_COUNT;

    @FindBy(xpath = "//button[@ng-click='copyForMyInformationPage()']")
    public WebElement USE_LAYOUT_MYINFORMATION_BUTTON;

    @FindBy(xpath = "//button[@ng-click='changeSsoConnectionsClass()']")
    public WebElement SSO_CONNECTION_BUTTON;

    @FindBy(xpath = "//input[@ng-click='addSelections()']")
    public WebElement USE_SELECTION_BUTTON;

    public Pages(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public SpeakerPortalAdminPage clickSettingsTab() throws Exception {
        Wait(SETTINGS_TAB, 20);
        clickByJavaScript(SETTINGS_TAB);
        logReport("Settings Tab clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        return new SpeakerPortalAdminPage(browser);
    }

    public void clickSaveButton() throws Exception {
        Wait(SAVE_BUTTON, 20);
        clickByJavaScript(SAVE_BUTTON);
        logReport("Save button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
    }

    public void selectShowButtonOpenByTitle(String title) throws Exception {
        String xpath = "//div[text()='" + title + "']/../../..//following-sibling::div//input[@ng-model='module.status']";
        WebElement element = browser.findElement(By.xpath(xpath));
        checkByJavascript(element);
        logReport("Show button opened successfully by title " + title);

    }

    public void selectShowButtonCloseByTitle(String title) throws Exception {
        String xpath = "//div[text()='" + title + "']/../../..//following-sibling::div//input[@ng-model='module.status']";
        WebElement element = browser.findElement(By.xpath(xpath));
        uncheckByJavascript(element);
        logReport("Show button closed successfully by title " + title);

    }

    public void editButtonByTitle(String title) throws Exception {
        String xpath = "//div[text()='" + title + "']/../../..//following-sibling::div//i[@class='pencilClass']";
        WebElement element = browser.findElement(By.xpath(xpath));
        clickByJavaScript(element);
        logReport("Element edited successfully by title " + title);
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
    }

    public boolean isEditIconByTitle(String title) throws Exception {
        String xpath = "//div[text()='" + title + "']/../../..//following-sibling::div//i[@class='pencilClass']";
        return verifyElementDisplayed(By.xpath(xpath), 5);

    }

    public boolean isSignInOptionsDisabled(String text) {
        String xpath = "//label[contains(.,'" + text + "')]/input";
        return browser.findElement(By.xpath(xpath)).isEnabled();
    }

    public void clickSignInOptionRadioButton(String text) {
        String xpath = "//label[contains(.,'" + text + "')]/input";
        WebElement element = browser.findElement(By.xpath(xpath));
        clickByJavaScript(element);
        logReport("Sign in option radio button clicked successfully");
    }

    public void checkcloseProposalPeriod() {
        check(CLOSE_PROPOSAL_PERIOD);
        logReport("Close proposal period checkbox checked successfully");
    }

    public void uncheckcloseProposalPeriod() {
        unCheck(CLOSE_PROPOSAL_PERIOD);
        logReport("Close proposal period checkbox unchecked successfully");
    }

    public Pages clickPagesTab() throws Exception {
        Wait(PAGES_TAB, 20);
        clickByJavaScript(PAGES_TAB);
        logReport("Pages Tab clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        return new Pages(browser);
    }

    public void selectReadOnlyButtonByTitle(String title) throws Exception {
        String xpath = "//div[text()='" + title + "']/../../..//following-sibling::div//input[@ng-model='module.isReadOnly']";
        WebElement element = browser.findElement(By.xpath(xpath));
        checkByJavascript(element);
        logReport("Read only mode selected successfully by title " + title);

    }

    public void unselectReadOnlyButtonByTitle(String title) throws Exception {
        String xpath = "//div[text()='" + title + "']/../../..//following-sibling::div//input[@ng-model='module.isReadOnly']";
        WebElement element = browser.findElement(By.xpath(xpath));
        uncheckByJavascript(element);
        logReport("Read only mode unselected successfully by title " + title);

    }

    public void clickOnExistingCustomFields() throws Exception {
        VerifyPageReady(30);
        Actions action = new Actions(browser);
        action.moveToElement(MOUSE_MOVE).build().perform();
        WebElement element = ADD_FIELDS_BUTTON_LIST.get(1);
        clickByJavaScript(element);
        Thread.sleep(3000);
        Wait(STANDARD_FIELD_BUTTON, 30);
        clickByJavaScript(STANDARD_FIELD_BUTTON);
        logReport("Successfully clicked on Standard custom fields button.");
        VerifyAngularHasFinishedProcessing(10);

    }

    public void checkStandardFields(String name) {
        String xpath = "//label[contains(.,'" + name + "')]/input";
        WebElement element = browser.findElement(By.xpath(xpath));
        checkByJavascript(element);
        logReport("Standard fields checked successfully by name " + name);
    }

    public void checkAllStandardAndCustomFields() {
        for (WebElement e : STANDARDANDCUSTOMFIELDS) {
            checkByJavascript(e);
            logReport("Check all standard fields and custom fields " + e);
        }
    }

    public void addSections() throws Exception {
        Wait(ADD_SECTIONS_BUTTON, 30);
        click(ADD_SECTIONS_BUTTON);
        logReport("Add Section button clicked successfully");

    }

    public void saveLayout() throws Exception {
        VerifyPageReady(30);
        Wait(SAVE_SESSION_LAYOUT_BUTTON, 30);
        clickByJavaScript(SAVE_SESSION_LAYOUT_BUTTON);
        VerifyAngularHasFinishedProcessing(10);
    }

    public void enterProposalPrompt(String text) {
        type(PROPOSAL_PROMPT, text, true);
        logReport("Entered proposal prompt value " + text);
    }

    public void enterProposalButton(String text) {
        type(PROPOSAL_BUTTON, text, true);
        logReport("Entered proposal button value " + text);
    }

    public void DragAndDropReorderPages() {
        Actions actions = new Actions(browser);
        actions.moveToElement(MYINFORMATION_SECTION).build().perform();
        actions.dragAndDrop(MYINFORMATION_SECTION, MYSESSION_SECTION);
        logReport("Drag and drop reorder pages from source My information section to target my session section");
    }

    public void clickAddNewButton() throws Exception {
        Wait(ADDNEW_BUTTON, 30);
        click(ADDNEW_BUTTON);
        logReport("Add New button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
    }

    public boolean isNewAddedPagePresent(String title) {
        String xpath = "//div[text()='" + title + "'][@class='labels divEllipsis ng-binding']";
        return verifyElementDisplayed(By.xpath(xpath), 2);
    }

    public void selectIconByTitle(String title, String iconName) throws Exception {
        String xpath = "//div[text()='" + title + "']/../../..//preceding-sibling::div//i[@title='Select icon']";
        WebElement element = browser.findElement(By.xpath(xpath));
        click(element);
        logReport("select icon clicked successfully by title" + title);
        Wait(SEARCH_ICON_TEXTBOX, 20);
        type(SEARCH_ICON_TEXTBOX, iconName, true);
        String xpathIcon = "//li[@title='" + iconName + "']";
        WebElement element1 = browser.findElement(By.xpath(xpathIcon));
        click(element1);
        logReport("Icon name selected successfully" + iconName);
        click(DONE_BUTTON);
        logReport("Done button clicked successfully");
    }

    public boolean isIconSetByTitle(String title, String iconName) {
        String xpath = "//div[text()='" + title + "']/../../..//preceding-sibling::div/i[1]";
        WebElement element = browser.findElement(By.xpath(xpath));
        return element.getAttribute("class").contains(iconName);

    }

    public void enterTitleValue(String newTitle) {
        type(PAGE_TITLE_TEXTBOX, newTitle, true);
        logReport("Entered new title value " + newTitle);
    }

    public void deleteBasicPage(String pageTitle) {
        String xpath = "//div[text()='" + pageTitle + "']/../../..//following-sibling::div//i[@class='fa fa-remove']";
        WebElement element = browser.findElement(By.xpath(xpath));
        clickByJavaScript(element);
        logReport("Basic page deleted successfully by title " + pageTitle);
    }

    public void clickPreviewSiteButton() throws Exception {
        click(PREVIEW_SITE_BUTTON);
        logReport("Preview site button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
    }

    public void clickTabView() {
        click(TABPREVIEW_BUTTON);
        logReport("Tab preview button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
    }

    public void clickDesktopView() {
        click(DESKTOPPREVIEW_BUTTON);
        logReport("Desktop preview button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
    }

    public boolean isPreviewModeFound(String previewUI) {
        String text = PREVIEW_MODE.getAttribute("class").trim();
        return text.contains(previewUI);
    }

    public void clickClosePreviewWindow() {
        click(CLOSE_PREVIEW_WINDOW);
        logReport("Close preview window");

    }

    public void clickBasicPageLayout() {
        click(BASIC_PAGE_LAYOUT);
        logReport("Basic page layout clicked successfully");
    }

    public void selectSpeakerTypes(String speakerType) {
        select(SELECT_SPEAKER_TYPE, speakerType);
        logReport("Selected speaker type value " + speakerType);
    }

    public void expandSectionsByTitle(String sectionName) throws Exception {
        String xpath = "//div[contains(text(),'" + sectionName + "')]/i";
        WebElement element = browser.findElement(By.xpath(xpath));
        if (element.getAttribute("class").contains("down")) {
            clickByJavaScript(element);
            logReport("Expanded section by title " + sectionName);
        }
        VerifyPageReady(30);
    }

    public void collapseSectionsByTitle(String sectionName) {
        String xpath = "//div[contains(text(),'" + sectionName + "')]/i";
        WebElement element = browser.findElement(By.xpath(xpath));
        if (element.getAttribute("class").contains("up")) {
            clickByJavaScript(element);
            logReport("Expanded section by title " + sectionName);
        }
    }

    public String getSubmitterText() {
        return SUBMITTER_TEXT.getText().trim();
    }

    public String getSpeakerDetailsText() {
        return SPEAKER_DETAILS_TEXT.getText().trim();
    }

    public List<String> getSpeakerDetailsInformation1() throws Exception {
        Thread.sleep(3000);
        List<String> speakerDetailsList = new ArrayList<>();
        for (WebElement e : SPEAKER_DETAILS_INFO) {
            speakerDetailsList.add(e.getText().trim());
        }
        logReport("list of speaker details info " + speakerDetailsList);
        return speakerDetailsList;
    }

    public List<String> getSpeakerDetailsInformation() {
        List<String> speakerDetailsList = new ArrayList<>();
        for (WebElement e : SPEAKER_DETAILS_INFO1) {
            speakerDetailsList.add(e.getText().trim());
        }
        logReport("list of speaker details info " + speakerDetailsList);
        return speakerDetailsList;
    }

    public String getSessionDetailsText() {
        return SESSION_DETAILS_TEXT.getText().trim();
    }

    public List<String> getSessionDetailsInformation() {
        List<String> speakerDetailsList = new ArrayList<>();
        for (WebElement e : SESSION_DETAILS_INFO) {
            speakerDetailsList.add(e.getText().trim());
        }
        for (WebElement e : SESSION_DETAILS_INFO1) {
            speakerDetailsList.add(e.getText().trim());
        }
        logReport("list of speaker details info " + speakerDetailsList);
        return speakerDetailsList;
    }

    public String getSessionButtonText() {
        return SESSION_BUTTON_TEXT.getText().trim();
    }

    public String getAdditionalSpeakersText() {
        return ADDITIONAL_SPEAKERS_TEXT.getText().trim();
    }

    public void clickOnExistingCustomFieldsForSpecificSections() throws Exception {
        VerifyPageReady(30);
        Actions action = new Actions(browser);
        action.moveToElement(MOUSE_MOVE).build().perform();
        WebElement element = ADD_FIELDS_BUTTON_LIST.get(ADD_FIELDS_BUTTON_LIST.size() - 1);
        clickByJavaScript(element);
        Thread.sleep(3000);
        Wait(STANDARD_CUSTOMFIELD_BUTTON, 30);
        clickByJavaScript(STANDARD_CUSTOMFIELD_BUTTON);
        logReport("Successfully clicked on Standard and existing custom fields button.");
        VerifyAngularHasFinishedProcessing(10);

    }

    public void deleteStandardFieldsInSpeakerSection(String fieldName) throws Exception {
        //hoverStandardFieldsInSpeakerSection(fieldName);
        String xpath1 = "//div[contains(@ng-repeat,'section in speakerSections')]//span[@class='ng-scope ng-binding'][text()='" + fieldName + "']/../../../..//i[@class='fa fa-remove fa-lg pull-right cursor-pointer']";
        WebElement element1 = browser.findElement(By.xpath(xpath1));
        clickByJavaScript(element1);
        Thread.sleep(1000);
        clickOkButton();
        logReport("Standard field deleted successfully " + fieldName);
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
    }

    public void editStandardFieldsInSpeakerSection(String fieldName, String text) throws Exception {
        hoverStandardFieldsInSpeakerSection(fieldName);
        String xpath = "//div[contains(@ng-repeat,'section in speakerSections')]//span[@class='ng-scope ng-binding'][text()='" + fieldName + "']/../../..//div[@class='editable-label']//i";
        WebElement element = browser.findElement(By.xpath(xpath));
        clickByJavaScript(element);
        logReport("Standard fields edited successfully " + fieldName);
        String xpath1 = "//div[contains(@ng-repeat,'section in speakerSections')]//span[@class='ng-scope ng-binding'][text()='" + fieldName + "']/../../..//input";
        WebElement element1 = browser.findElement(By.xpath(xpath1));
        type(element1, text, true);
        String newText = text.substring(0, 255);
        String saveXpath = "//div[@tooltip='" + newText + "']/..//i[@class='fa fa-check green-font']";
        click(browser.findElement(By.xpath(saveXpath)));
    }

    public void clickOkButton() {
        click(OK_BUTTON);
        logReport("Ok button clicked successfully");
    }

    public void hoverStandardFieldsInSpeakerSection(String fieldName) throws Exception {
        String xpath = "//div[contains(@ng-repeat,'section in speakerSections')]//span[@class='ng-scope ng-binding'][text()='" + fieldName + "']";
        WebElement element = browser.findElement(By.xpath(xpath));
        Actions action = new Actions(browser);
        Thread.sleep(1000);
        action.sendKeys(element, Keys.TAB);
        action.moveToElement(element).build().perform();
        logReport("Hover performed successfully and appeared");
    }

    public boolean isDeleteIconExistForMinimalFields(String fieldName) throws Exception {
        String xpath1 = "//div[contains(@ng-repeat,'section in speakerSections')]//span[@class='ng-scope ng-binding'][text()='" + fieldName + "']/../../../..//i[@class='fa fa-remove fa-lg pull-right cursor-pointer']";
        return verifyElementDisplayed(By.xpath(xpath1), 20);
    }

    public void deleteStandardFieldsInSessionSection(String fieldName) throws Exception {
        // hoverStandardFieldsInSessionSection(fieldName);
        String xpath1 = "//div[contains(@ng-repeat,'section in sections')]//span[@class='ng-scope ng-binding'][text()='" + fieldName + "']/../../../..//i[@class='fa fa-remove fa-lg pull-right cursor-pointer']";
        WebElement element1 = browser.findElement(By.xpath(xpath1));
        click(element1);
        clickOkButton();
        logReport("Standard field deleted successfully " + fieldName);
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
    }

    public void hoverStandardFieldsInSessionSection(String fieldName) throws Exception {
        String xpath = "//div[contains(@ng-repeat,'section in sections')]//span[@class='ng-scope ng-binding'][text()='" + fieldName + "']";
        WebElement element = browser.findElement(By.xpath(xpath));
        Actions action = new Actions(browser);
        action.sendKeys(element, Keys.TAB);
        Thread.sleep(1000);
        action.moveToElement(element).build().perform();
        logReport("Hover performed successfully and appeared");
    }

    public boolean isDeleteIconExistForSessionSection(String fieldName) throws Exception {
        String xpath1 = "//div[contains(@ng-repeat,'section in sections')]//span[@class='ng-scope ng-binding'][text()='" + fieldName + "']/../../../..//i[@class='fa fa-remove fa-lg pull-right cursor-pointer']";
        return verifyElementDisplayed(By.xpath(xpath1), 20);
    }

    public void editStandardFieldsInSessionSection(String fieldName, String text) throws Exception {
        hoverStandardFieldsInSessionSection(fieldName);
        String xpath = "//div[contains(@ng-repeat,'section in sections')]//span[@class='ng-scope ng-binding'][text()='" + fieldName + "']/../../..//div[@class='editable-label']//i";
        if (verifyElementDisplayed(By.xpath(xpath), 10)) {
            clickByJavaScript(browser.findElement(By.xpath(xpath)));
        }
        logReport("Standard fields edited successfully " + fieldName);
        String xpath1 = "//div[contains(@ng-repeat,'section in sections')]//span[@class='ng-scope ng-binding'][text()='" + fieldName + "']/../../..//input";
        WebElement element1 = browser.findElement(By.xpath(xpath1));
        type(element1, text, true);
        String newText = text.substring(0, 255);
        String saveXpath = "//div[@tooltip='" + newText + "']/..//i[@class='fa fa-check green-font']";
        click(browser.findElement(By.xpath(saveXpath)));
    }

    public boolean isEditIconExistForSessionSection(String fieldName) throws Exception {
        String xpath = "//div[contains(@ng-repeat,'section in sections')]//span[@class='ng-scope ng-binding'][text()='" + fieldName + "']/../../..//div[@class='editable-label']//i";
        return verifyElementDisplayed(By.xpath(xpath), 10);
    }

    public void enterSearchValue(String value) {
        type(SEARCH_ADDFIELD_TEXTBOX, value);
        logReport("Entered search value " + value);

    }

    public boolean isSearchedValueDisplayed(String value) {
        String xpath = "//label[contains(.,'" + value + "')]/input";
        return verifyElementDisplayed(By.xpath(xpath), 2);
    }

    public void clickCloseAddFieldPopup() throws Exception {
        click(CLOSE_ADD_ICON);
        logReport("Close add icon button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
    }

    public void clickBackToPageListIcon() throws Exception {
        click(BACKTOPAGELIST_BUTTON);
        logReport("Back to page list button clicked successfully");
        VerifyPageReady(20);
    }

    public void clickSessionEditButton() throws Exception {
        click(EDIT_BUTTON);
        logReport("Session edit button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
    }

    public void clickSessionPreviewButton() throws Exception {
        click(PREVIEW_BUTTON);
        logReport("Session preview button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
    }

    public boolean isSessionModeNavigated(String mode) {
        return SESSION_PAGE_PREVIEW.getAttribute("class").contains(mode);
    }

    public boolean isStandardAndCustomFieldsCountMatched() {
        int standCount = Integer.parseInt(STANDARD_TEXT_COUNT.getText().trim());
        int customCount = Integer.parseInt(CUSTOM_TEXT_COUNT.getText().trim());
        return standCount == STANDARD_FIELDS.size() && customCount == CUSTOM_FIELDS.size();
    }

    public List<String> getSpeakerMyInfoLayout() throws Exception {
        List<String> infoDetails = new ArrayList<>();
        for (WebElement e : SPEAKER_DETAILS_INFO1) {
            infoDetails.add(e.getText().trim());
            Thread.sleep(1000);
        }
        for (WebElement e : SPEAKER_DETAILS_INFO) {
            infoDetails.add(e.getText().trim());
        }
        return infoDetails;
    }

    public void selectSsoConnectionField(String appName) throws Exception {
        Wait(SSO_CONNECTION_BUTTON, 30);
        clickByJavaScript(SSO_CONNECTION_BUTTON);
        logReport("Sso connection button clicked successfully");
        String xpath = "//span[text()='" + appName + "']//input";
        WebElement element = browser.findElement(By.xpath(xpath));
        checkByJavascript(element);
        logReport("SSO connection checkbox checked successfully " + appName);
        clickByJavaScript(USE_SELECTION_BUTTON);
        logReport("Use selection button clicked successfully");
    }
}

