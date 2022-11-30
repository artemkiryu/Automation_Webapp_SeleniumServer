package pageObjects.Reports;


import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pojo.ReportPrintSettings;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by infoobjects on 11/23/2015.
 */
public class ReportDisplayPage extends CommonReportsPage {

    @FindBy(xpath = "//div[@class='panel-heading']")
    public List<WebElement> PANEL_HEADING;
    @FindBy(xpath = "//input[@name='searchStartRow']")
    public WebElement START_ROWS_TEXTBOX;
    @FindBy(xpath = "//input[@name='searchRowsPerPage']")
    public WebElement PER_PAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='searchMaxRows']")
    public WebElement MAX_ROWS_TEXTBOX;
    @FindBy(xpath = "//select[@name='txtPrintWidth']")
    public WebElement REPORT_WIDTH_DROPDOWN;
    @FindBy(xpath = "//select[@name='txtPrintFontFace']")
    public WebElement FONT_FACE_DROPDOWN;
    @FindBy(xpath = "//select[@name='txtPrintFontSize']")
    public WebElement FONT_SIZE_DROPDOWN;
    @FindBy(xpath = "//select[@name='txtPrintAligment']")
    public WebElement REPORT_ALIGNMENT_DROPDOWN;
    @FindBy(xpath = "//select[@name='txtPrintGroupAligment']")
    public WebElement GROUP_ALIGNMENT_DROPDOWN;
    @FindBy(xpath = "//select[@name='txtPrintColumnAligment']")
    public WebElement COLUMN_ALIGNMENT_DROPDOWN;
    @FindBy(xpath = "//input[@id='bitGroupLineBreak']")
    public WebElement INSERT_EXTRA_LINE_CHK;
    @FindBy(xpath = "//input[@id='bitGroupAddBoldLine']")
    public WebElement ADD_BOLD_LINE_CHK;
    @FindBy(xpath = "//input[@id='bitPrintPageBreak']")
    public WebElement INSERT_PAGE_BREAKS_CHK;
    @FindBy(xpath = "//input[@id='bitShowGridlines']")
    public WebElement SHOW_GRIDLINES_CHK;

    public ReportDisplayPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public List<String> getSectionsName() {
        List<WebElement> elements = PANEL_HEADING;
        List<String> sectionNames = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            sectionNames.add(elements.get(i).getText());
        }
        return sectionNames;
    }

    public List<String> getReportFormatOptions() {
        List<WebElement> elements = browser.findElements(By.xpath("//div[@id='DisplayFormatId']//tbody//tr[1]//label"));
        List<String> reportFormatList = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            reportFormatList.add(elements.get(i).getText());
        }
        return reportFormatList;
    }

    public List<String> getDataFormatOptions() {
        List<WebElement> elements = browser.findElements(By.xpath("//div[@id='DisplayFormatId']//tbody//tr[3]//label"));
        List<String> dataFormatList = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            dataFormatList.add(elements.get(i).getText());
        }
        return dataFormatList;
    }

    public List<String> getPrintSettingCheckboxesOptions() {
        String xpath = "//div[@id='PrintSettingsId']//tbody//td//label";
        List<WebElement> elements = browser.findElements(By.xpath(xpath));
        List<String> printSettingCheckboxesOptions = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            printSettingCheckboxesOptions.add(elements.get(i).getText());
        }
        return printSettingCheckboxesOptions;

    }

    public List<String> getPrintSettingOptions() {
        String xpath = "//div[@id='PrintSettingsId']//tbody//td";
        List<WebElement> elements = browser.findElements(By.xpath(xpath));
        List<String> printSettingOptions = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            printSettingOptions.add(elements.get(i).getText());
        }
        return printSettingOptions;

    }

    public void selectReportFormatRadioButton(String label) {
        List<WebElement> elements = browser.findElements(By.xpath("//div[@id='DisplayFormatId']//tbody//tr[1]//label"));
        //List<String> reportFormatList = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().contains(label)) {
                elements.get(i).click();
                logReport("Radio button clicked successfully" + label);
            }
        }
    }

    public void enterStartRowValue(String startRow) {
        type(START_ROWS_TEXTBOX, startRow, true);
        logReport("Entered start row value" + startRow);
    }

    public void enterPerPageValue(String pageValue) {
        type(PER_PAGE_TEXTBOX, pageValue, true);
        logReport("Entered per page row value" + pageValue);
    }

    public void enterMaxRowValue(String maxRow) {
        type(MAX_ROWS_TEXTBOX, maxRow, true);
        logReport("Entered max row value" + maxRow);
    }

    public void clickSaveButton() throws Exception {
        click(SAVE_BUTTON);
        logReport("Save button clicked successfully");
        VerifyPageReady(30);
    }

    public void selectDataFormatRadioButton(String label) {
        List<WebElement> elements = browser.findElements(By.xpath("//div[@id='DisplayFormatId']//tbody//tr[3]//label"));
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().contains(label)) {
                elements.get(i).click();
                logReport("Selected data format radio button" + label);
            }
        }
    }

    public void selectReportWidthValue(String width) {
        select(REPORT_WIDTH_DROPDOWN, width);
        logReport("Selected report width value" + width);
    }

    public void selectFontFaceValue(String fontFace) {
        select(FONT_FACE_DROPDOWN, fontFace);
        logReport("Selected font face value" + fontFace);
    }

    public void selectFontSizeValue(String size) {
        select(FONT_SIZE_DROPDOWN, size);
        logReport("Selected font size value" + size);
    }

    public void selectReportAlignment(String alignmentType) {
        select(REPORT_ALIGNMENT_DROPDOWN, alignmentType);
        logReport("Selected report alignment type" + alignmentType);
    }

    public void selectGroupAlignment(String alignmentType) {
        select(GROUP_ALIGNMENT_DROPDOWN, alignmentType);
        logReport("Selected group alignment type" + alignmentType);
    }

    public void selectColumnAlignment(String alignmentType) {
        select(COLUMN_ALIGNMENT_DROPDOWN, alignmentType);
        logReport("Selected column alignment type" + alignmentType);
    }

    public void checkunCheckAddBoldLineChcekbox(boolean state) {
        if (state) {
            check(ADD_BOLD_LINE_CHK);
            logReport("Add bold line checkbox checked successfully");
        } else {
            unCheck(ADD_BOLD_LINE_CHK);
            logReport("Add bold line checkbox unChecked successfully");
        }
    }

    public void checkunCheckInsertExtraLineChcekbox(boolean state) {
        if (state) {
            check(INSERT_EXTRA_LINE_CHK);
            logReport("Insert extra line checkbox checked successfully");
        } else {
            unCheck(INSERT_EXTRA_LINE_CHK);
            logReport("Insert extra line checkbox unChecked successfully");
        }
    }

    public void checkunCheckInsertPageBreaksChcekbox(boolean state) {
        if (state) {
            check(INSERT_PAGE_BREAKS_CHK);
            logReport("Insert page breaks checkbox checked successfully");
        } else {
            unCheck(INSERT_PAGE_BREAKS_CHK);
            logReport("Insert page breaks checkbox unChecked successfully");
        }
    }

    public void checkunCheckShowGridLinesChcekbox(boolean state) {
        if (state) {
            check(SHOW_GRIDLINES_CHK);
            logReport("Show grid lines checkbox checked successfully");
        } else {
            unCheck(SHOW_GRIDLINES_CHK);
            logReport("Show grid lines checkbox unChecked successfully");
        }
    }

    public void fillPrintSettingsData(ReportPrintSettings reportPrintSettings) {
        selectReportWidthValue(reportPrintSettings.getReportWidth());
        selectFontFaceValue(reportPrintSettings.getFontFace());
        selectFontSizeValue(reportPrintSettings.getFontSize());
        selectReportAlignment(reportPrintSettings.getReportAlignment());
        selectGroupAlignment(reportPrintSettings.getGroupAlignment());
        selectColumnAlignment(reportPrintSettings.getColumnAlignment());
        checkunCheckInsertExtraLineChcekbox(reportPrintSettings.isInsertExtraLine());
        checkunCheckAddBoldLineChcekbox(reportPrintSettings.isAddBoldLine());
        checkunCheckInsertPageBreaksChcekbox(reportPrintSettings.isInsertPageBreak());
        checkunCheckShowGridLinesChcekbox(reportPrintSettings.isShowGridlines());
    }
}
