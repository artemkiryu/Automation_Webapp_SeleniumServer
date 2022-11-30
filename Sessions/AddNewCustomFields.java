package pageObjects.Sessions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pageObjects.CommonActionsPage;
import pojo.AddCustomFieldsData;

import javax.naming.ConfigurationException;
import java.util.ArrayList;
import java.util.List;

public class AddNewCustomFields extends CommonActionsPage {

    @FindBy(xpath = "//select[@data-placeholder='Choose a Field Type']")
    public WebElement FIELD_TYPE_DROPDOWN;

    @FindBy(xpath = "//input[@id='customFieldName']")
    public WebElement FIELD_NAME_TEXTBOX;

    @FindBy(xpath = "//input[@id='customFieldCode']")
    public WebElement FIELD_CODE_TEXTBOX;

    @FindBy(xpath = "//select[@id='customFieldClass']")
    public WebElement FIELD_CLASS_DROPDOWN;

    @FindBy(xpath = "//span[@x-ng-click='addNewOption()']//i")
    public WebElement ADD_ANOTHER_OPTION_BUTTON;

    @FindBy(xpath = "//button[@x-ng-click='saveCustomField()']")
    public WebElement SAVE_CUSTOM_FIELD_BUTTON;

    @FindBy(xpath = "//button[@x-ng-click='cancel()']")
    public WebElement CANCEL_CUSTOM_FIELD_BUTTON;

    // @FindBy(xpath = "//label[text()='*Class']/..//div[@id='s2id_customFieldType']")
    @FindBy(xpath = "//div[@class='modal-body']//label[text()='*Class']//following-sibling::div//span[@class='select2-chosen']")
    public WebElement CLASS_DROPDOWN;

    // @FindBy(xpath = "//label[text()='*Field Type']/..//div[@id='s2id_autogen1']")
    @FindBy(xpath = "//div[@class='modal-body']//label[text()='*Field Type']//following-sibling::div//span[@class='select2-chosen']")
    public WebElement FIELD_TYPES_DROPDOWN;

    //Custom File type field's Details
    @FindBy(xpath = "//i[@class='fa fa-file-image-o fs50']")
    public WebElement FILE_IMAGE;

    @FindBy(xpath = "//button[text()='Upload']")
    public WebElement FILE_UPLOAD_BUTTON;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement FILE_CHOOSE_BUTTON;

    @FindBy(xpath = "//p[contains(.,' This Custom Field Type will display the file path to the document as well as a thumbnail, file name and file size. It has no additional options')]")
    public WebElement FILE_NOTE_P;

    //Custom Textarea type field's Details
    @FindBy(xpath = "//input[@x-ng-model='customField.isRichTextType']")
    public WebElement RICH_TEXT_CHECKBOX;

    @FindBy(xpath = "//strong[text()='Rich Text']")
    public WebElement RICH_TEXT_TITLE;

    @FindBy(xpath = "//p[text()='Allow this field to have styled text and links.']")
    public WebElement RICH_TEXT_P;

    @FindBy(xpath = "//h4[text()='Field Size']")
    public WebElement FIELD_SIZE_HEADER;

    @FindBy(xpath = "//label[contains(text(),'Short')]/..//input[@type='radio']")
    public WebElement SHORT_RADIO;

    @FindBy(xpath = "//label[contains(text(),'Large')]/..//input[@type='radio']")
    public WebElement LARGE_RADIO;

    @FindBy(xpath = "//p[text()='NOTE :- Text fields can accommodate a maximum of 4000 characters.']")
    public WebElement LIMIT_NOTE;

    //Custom Radio type field's Details
    @FindBy(xpath = "//input[@x-ng-model='customField.isOption']")
    public WebElement INCLUDE_OPTION_CHECKBOX;

    @FindBy(xpath = "//input[@x-ng-model='customField.isOption']/..//strong")
    public WebElement INCLUDE_TITLE;

    @FindBy(xpath = "//p[text()='Enter what you want to appear in the list here.']")
    public WebElement INCLUDE_P;

    @FindBy(xpath = "//input[@x-ng-model='customField.optionText']")
    public WebElement INCLUDE_OPTION_TEXTBOX;

    @FindBy(xpath = "//h4[text()='List Options']")
    public WebElement LIST_OPTIONS_HEADER;

    @FindBy(xpath = "//button[@x-ng-click='resetDefault()']")
    public WebElement CLEAR_DEFAULT_BUTTON;

    @FindBy(xpath = "//span[@x-ng-click='addNewOption()']")
    public WebElement ADD_ANOTHER_OPTIONS_BUTTON;

    @FindBy(xpath = "//div[@class='optionHeader']//div")
    public List<WebElement> OPTION_HEADER_LIST;

    @FindBy(xpath = "//div[contains(text(),'Default')]")
    public WebElement OPTION_DEFAULT_HEADER;

    @FindBy(xpath = "//li[1]//i[@aria-label='Drag Handle Icon']")
    public WebElement OPTION_DRAG_ICON;

    @FindBy(xpath = "//li[1]//input[@aria-label='Default']")
    public WebElement OPTION_DEFAULT_RADIO;

    @FindBy(xpath = "//li[1]//i[@class='fa fa-remove delete-icon']")
    public WebElement OPTION_DEFAULT_CANCEL;

    @FindBy(xpath = "//p[@ng-repeat='error in errors']")
    public List<WebElement> ERRORS_LIST;


    public AddNewCustomFields(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void fillCustomFieldData(AddCustomFieldsData addCustomFieldsData) throws Exception {
        Wait(FIELD_CLASS_DROPDOWN, 20);
        try {
            selectFieldClass(addCustomFieldsData.getFieldClass());
            selectFieldType(addCustomFieldsData.getFieldType());
            enterFieldName(addCustomFieldsData.getFieldName());
            enterFieldCode(addCustomFieldsData.getFieldCode());


            String fieldType = addCustomFieldsData.getFieldType();
            if (fieldType.equalsIgnoreCase("Radio") || fieldType.equalsIgnoreCase("Checkbox") || fieldType.equalsIgnoreCase("Select") || fieldType.equalsIgnoreCase("Select Multiple")) {
                logReport("In the loop for radio/checkbox,select,select multiple field type");
                String a[] = addCustomFieldsData.getOptions().split(",");
                System.out.println("---length of array " + a.length);
                for (int i = 0; i < a.length; i++) {
                    wait(3);
                    if (i >= 2) {
                        click(ADD_ANOTHER_OPTION_BUTTON);
                        Thread.sleep(50);
                    }
                    WebElement optionName = browser.findElement(By.xpath("//div[@class='optionset']//li[" + (i + 1) + "]//div[@class='optiondata']//div//input[@x-ng-model='option.name']"));
                    WebElement optionValue = browser.findElement(By.xpath("//div[@class='optionset']//li[" + (i + 1) + "]//div[@class='optiondata']//div//input[@x-ng-model='option.value']"));
                    WebElement optionCode = browser.findElement(By.xpath("//div[@class='optionset']//li[" + (i + 1) + "]//div[@class='optiondata']//div//input[@x-ng-model='option.code']"));

                    type(optionName, a[i]);
                    logReport("Typed field option name " + a[i]);

                    optionValue.click();
                    wait(3);
                    type(optionValue, a[i], true);
                    logReport("Typed field option value " + a[i]);

                    type(optionCode, a[i], true);
                    logReport("Typed field option code " + a[i]);
                    wait(3);
                }
            }
            saveCustomFieldDetails();
        } catch (Exception e) {
            logReport("Field type : " + addCustomFieldsData.getFieldType() + " is not a valid field type.Please select a valid field type.");
            cancelCustomFieldDetails();
        }

    }

    public void fillCustomFieldDataForSession(AddCustomFieldsData addCustomFieldsData) throws Exception {
        Wait(FIELD_TYPE_DROPDOWN, 20);
        try {
            selectFieldType(addCustomFieldsData.getFieldType());
            enterFieldName(addCustomFieldsData.getFieldName());
            enterFieldCode(addCustomFieldsData.getFieldCode());
            // selectFieldClass(addCustomFieldsData.getFieldClass());

            String fieldType = addCustomFieldsData.getFieldType();
            if (fieldType.equalsIgnoreCase("Radio") || fieldType.equalsIgnoreCase("Checkbox") || fieldType.equalsIgnoreCase("Select") || fieldType.equalsIgnoreCase("Select Multiple")) {
                logReport("In the loop for radio/checkbox,select,select multiple field type");
                String a[] = addCustomFieldsData.getOptions().split(",");
                System.out.println("---length of array " + a.length);
                for (int i = 0; i < a.length; i++) {
                    wait(3);
                    if (i >= 2) {
                        click(ADD_ANOTHER_OPTION_BUTTON);
                        Thread.sleep(50);
                    }
                    WebElement optionName = browser.findElement(By.xpath("//div[@class='optionset']//li[" + (i + 1) + "]//div[@class='optiondata']//div//input[@x-ng-model='option.name']"));
                    WebElement optionValue = browser.findElement(By.xpath("//div[@class='optionset']//li[" + (i + 1) + "]//div[@class='optiondata']//div//input[@x-ng-model='option.value']"));
                    WebElement optionCode = browser.findElement(By.xpath("//div[@class='optionset']//li[" + (i + 1) + "]//div[@class='optiondata']//div//input[@x-ng-model='option.code']"));

                    type(optionName, a[i], true);
                    logReport("Typed field option name " + a[i]);

                    type(optionValue, a[i], true);
                    logReport("Typed field option value " + a[i]);

                    type(optionCode, a[i], true);
                    logReport("Typed field option code " + a[i]);
                    wait(3);
                }
            }
            saveCustomFieldDetails();

        } catch (Exception e) {
            logReport("Field type : " + addCustomFieldsData.getFieldType() + " is not a valid field type.Please select a valid field type.");
            cancelCustomFieldDetails();
        }

    }

    public void editCustomFieldDataForSession(AddCustomFieldsData addCustomFieldsData) throws Exception {
        Wait(FIELD_TYPE_DROPDOWN, 20);
        try {
            selectFieldType(addCustomFieldsData.getFieldType());
            enterFieldName(addCustomFieldsData.getFieldName());
            enterFieldCode(addCustomFieldsData.getFieldCode());

            String fieldType = addCustomFieldsData.getFieldType();
            if (fieldType.equalsIgnoreCase("Radio") || fieldType.equalsIgnoreCase("Checkbox") || fieldType.equalsIgnoreCase("Select") || fieldType.equalsIgnoreCase("Select Multiple")) {
                logReport("In the loop for radio/checkbox,select,select multiple field type");
                String a[] = addCustomFieldsData.getOptions().split(",");
                System.out.println("---length of array " + a.length);
                for (int i = 0; i < a.length; i++) {
                    wait(3);
                    /*if (i >= 2) {
                        click(ADD_ANOTHER_OPTION_BUTTON);
                        Thread.sleep(50);
                    }*/
                    WebElement optionName = browser.findElement(By.xpath("//div[@class='optionset']//li[" + (i + 1) + "]//div[@class='optiondata']//div//input[@x-ng-model='option.name']"));
                    WebElement optionValue = browser.findElement(By.xpath("//div[@class='optionset']//li[" + (i + 1) + "]//div[@class='optiondata']//div//input[@x-ng-model='option.value']"));
                    WebElement optionCode = browser.findElement(By.xpath("//div[@class='optionset']//li[" + (i + 1) + "]//div[@class='optiondata']//div//input[@x-ng-model='option.code']"));

                    type(optionName, a[i], true);
                    logReport("Typed field option name " + a[i]);

                    type(optionValue, a[i], true);
                    logReport("Typed field option value " + a[i]);

                    type(optionCode, a[i], true);
                    logReport("Typed field option code " + a[i]);
                    wait(3);
                }
            }
            saveCustomFieldDetails();
        } catch (Exception e) {
            logReport("Field type : " + addCustomFieldsData.getFieldType() + " is not a valid field type.Please select a valid field type.");
            cancelCustomFieldDetails();
        }

    }

    public void selectFieldType(String fieldType) throws Exception {
        select(FIELD_TYPE_DROPDOWN, fieldType);
        logReport("Selected field type value " + fieldType);
    }

    public void enterFieldName(String fieldName) throws Exception {
        type(FIELD_NAME_TEXTBOX, fieldName, true);
        logReport("Entered field name value " + fieldName);
    }


    public void enterFieldCode(String fieldCode) throws Exception {
        type(FIELD_CODE_TEXTBOX, fieldCode, true);
        logReport("Entered field code value " + fieldCode);
    }

    public void selectFieldClass(String fieldClass) throws Exception {
        Wait(FIELD_CLASS_DROPDOWN, 10);
        select(FIELD_CLASS_DROPDOWN, fieldClass);
        wait(5);
        logReport("Selected field class value " + fieldClass);
    }

    public SessionCustomFieldsPage saveCustomFieldDetails() throws Exception {
        Wait(SAVE_CUSTOM_FIELD_BUTTON, 20);
        clickByJavaScript(SAVE_CUSTOM_FIELD_BUTTON);
        logReport("Successfully clicked on Custom field save button");
        VerifyAngularHasFinishedProcessing(10);
        //waitForWindowToDispose();
        return new SessionCustomFieldsPage(browser);
    }

    public void clickOnSaveCustomFieldButton() throws Exception {
        Wait(SAVE_CUSTOM_FIELD_BUTTON, 20);
        clickByJavaScript(SAVE_CUSTOM_FIELD_BUTTON);
        logReport("Successfully clicked on Custom field save button");

    }

    public SessionCustomFieldsPage cancelCustomFieldDetails() throws Exception {
        clickByJavaScript(CANCEL_CUSTOM_FIELD_BUTTON);
        logReport("Successfully clicked on Custom field cancel button");
        return new SessionCustomFieldsPage(browser);
    }

    //for random letters
    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length + 1);
    }

    public void fillCustomFieldDataWithoutSave(AddCustomFieldsData addCustomFieldsData) throws Exception {
        Wait(FIELD_CLASS_DROPDOWN, 20);
        try {
            selectFieldClass(addCustomFieldsData.getFieldClass());
            selectFieldType(addCustomFieldsData.getFieldType());
            enterFieldName(addCustomFieldsData.getFieldName());
            enterFieldCode(addCustomFieldsData.getFieldCode());


            String fieldType = addCustomFieldsData.getFieldType();
            if (fieldType.equalsIgnoreCase("Radio") || fieldType.equalsIgnoreCase("Checkbox") || fieldType.equalsIgnoreCase("Select") || fieldType.equalsIgnoreCase("Select Multiple")) {
                logReport("In the loop for radio/checkbox,select,select multiple field type");
                String a[] = addCustomFieldsData.getOptions().split(",");
                System.out.println("---length of array " + a.length);
                for (int i = 0; i < a.length; i++) {
                    wait(3);
                    if (i >= 2) {
                        click(ADD_ANOTHER_OPTION_BUTTON);
                        Thread.sleep(50);
                    }
                    WebElement optionName = browser.findElement(By.xpath("//div[@class='optionset']//li[" + (i + 1) + "]//div[@class='optiondata']//div//input[@x-ng-model='option.name']"));
                    WebElement optionValue = browser.findElement(By.xpath("//div[@class='optionset']//li[" + (i + 1) + "]//div[@class='optiondata']//div//input[@x-ng-model='option.value']"));
                    WebElement optionCode = browser.findElement(By.xpath("//div[@class='optionset']//li[" + (i + 1) + "]//div[@class='optiondata']//div//input[@x-ng-model='option.code']"));

                    type(optionName, a[i], true);
                    logReport("Typed field option name " + a[i]);

                    type(optionValue, a[i], true);
                    logReport("Typed field option value " + a[i]);

                    type(optionCode, a[i], true);
                    logReport("Typed field option code " + a[i]);
                    wait(3);
                }
            }

        } catch (Exception e) {
            logReport("Field type : " + addCustomFieldsData.getFieldType() + " is not a valid field type.Please select a valid field type.");
            cancelCustomFieldDetails();
        }

    }

    public void editCustomFieldDataWithoutSave(AddCustomFieldsData addCustomFieldsData) throws Exception {
        Wait(FIELD_CLASS_DROPDOWN, 20);
        try {
            selectFieldClass(addCustomFieldsData.getFieldClass());
            selectFieldType(addCustomFieldsData.getFieldType());
            enterFieldName(addCustomFieldsData.getFieldName());
            enterFieldCode(addCustomFieldsData.getFieldCode());


            String fieldType = addCustomFieldsData.getFieldType();
            if (fieldType.equalsIgnoreCase("Radio") || fieldType.equalsIgnoreCase("Checkbox") || fieldType.equalsIgnoreCase("Select") || fieldType.equalsIgnoreCase("Select Multiple")) {
                logReport("In the loop for radio/checkbox,select,select multiple field type");
                String a[] = addCustomFieldsData.getOptions().split(",");
                System.out.println("---length of array " + a.length);
                for (int i = 0; i < a.length; i++) {
                    wait(3);
                    /*if (i >= 2) {
                        click(ADD_ANOTHER_OPTION_BUTTON);
                        Thread.sleep(50);
                    }*/
                    WebElement optionName = browser.findElement(By.xpath("//div[@class='optionset']//li[" + (i + 1) + "]//div[@class='optiondata']//div//input[@x-ng-model='option.name']"));
                    WebElement optionValue = browser.findElement(By.xpath("//div[@class='optionset']//li[" + (i + 1) + "]//div[@class='optiondata']//div//input[@x-ng-model='option.value']"));
                    WebElement optionCode = browser.findElement(By.xpath("//div[@class='optionset']//li[" + (i + 1) + "]//div[@class='optiondata']//div//input[@x-ng-model='option.code']"));

                    type(optionName, a[i], true);
                    logReport("Typed field option name " + a[i]);

                    type(optionValue, a[i], true);
                    logReport("Typed field option value " + a[i]);

                    type(optionCode, a[i], true);
                    logReport("Typed field option code " + a[i]);
                    wait(3);
                }
            }

        } catch (Exception e) {
            logReport("Field type : " + addCustomFieldsData.getFieldType() + " is not a valid field type.Please select a valid field type.");
            cancelCustomFieldDetails();
        }

    }

    public List<String> getClassDropdownListValues() throws Exception {
        Select dropdown = new Select(FIELD_CLASS_DROPDOWN);
        List<WebElement> dropdownList = dropdown.getOptions();
        List<String> dropdownArray = new ArrayList<>();
        for (WebElement e : dropdownList) {
            dropdownArray.add(e.getText().trim());

        }

        return dropdownArray;
    }

    public List<String> getFieldTypeDropdownListValues() throws Exception {
        Select dropdown = new Select(FIELD_TYPE_DROPDOWN);
        List<WebElement> dropdownList = dropdown.getOptions();
        List<String> dropdownArray = new ArrayList<>();
        for (WebElement e : dropdownList) {
            dropdownArray.add(e.getText().trim());

        }

        return dropdownArray;
    }

    public List<String> getOptionHeaderList() throws Exception {
        List<String> headerArray = new ArrayList<>();
        for (WebElement e : OPTION_HEADER_LIST) {
            headerArray.add(e.getText().trim());
        }
        return headerArray;
    }

    public List<String> getErrorsList() throws Exception {
        List<String> errorsArray = new ArrayList<>();
        for (WebElement e : ERRORS_LIST) {
            errorsArray.add(e.getText().trim());
        }
        return errorsArray;
    }

    public void fillOptionValues(AddCustomFieldsData addCustomFieldsData) throws Exception {
        String fieldType = addCustomFieldsData.getFieldType();
        if (fieldType.equalsIgnoreCase("Radio") || fieldType.equalsIgnoreCase("Checkbox") || fieldType.equalsIgnoreCase("Select") || fieldType.equalsIgnoreCase("Select Multiple")) {
            logReport("In the loop for radio/checkbox,select,select multiple field type");
            String a[] = addCustomFieldsData.getOptions().split(",");
            System.out.println("---length of array " + a.length);
            for (int i = 0; i < a.length; i++) {
                wait(3);
                    /*if (i >= 2) {
                        click(ADD_ANOTHER_OPTION_BUTTON);
                        Thread.sleep(50);
                    }*/
                WebElement optionName = browser.findElement(By.xpath("//div[@class='optionset']//li[" + (i + 1) + "]//div[@class='optiondata']//div//input[@x-ng-model='option.name']"));
                WebElement optionValue = browser.findElement(By.xpath("//div[@class='optionset']//li[" + (i + 1) + "]//div[@class='optiondata']//div//input[@x-ng-model='option.value']"));
                WebElement optionCode = browser.findElement(By.xpath("//div[@class='optionset']//li[" + (i + 1) + "]//div[@class='optiondata']//div//input[@x-ng-model='option.code']"));

                type(optionName, a[i], true);
                logReport("Typed field option name " + a[i]);

                type(optionValue, a[i], true);
                logReport("Typed field option value " + a[i]);

                type(optionCode, a[i], true);
                logReport("Typed field option code " + a[i]);
                wait(3);
            }
        }
    }

}
