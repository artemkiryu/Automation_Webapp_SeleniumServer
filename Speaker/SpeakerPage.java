package pageObjects.Speaker;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pageObjects.Forms.VerifyPage;
import pageObjects.Sessions.SessionSetupPage;
import pojo.AddSpeakerData;
import pojo.SpeakerInformation;

import java.util.List;

public class SpeakerPage extends CommonActionsPage{

    @FindBy(xpath = "//a[@ng-click='openSpeakerImportDialog()']")
    public static WebElement IMPORT_BUTTON;

    @FindBy(xpath = "//button[@ng-click='addSpeaker()']")
    public WebElement ADD_NEW_BUTTON;

    @FindBy(xpath = "//input[@placeholder='Speaker Name']")
    public WebElement SEARCH_TEXTBOX;

    @FindBy(xpath = "//button[@ng-click='filterSearchSession()']")
    public WebElement SEARCH_BUTTON;

    @FindBy(xpath = "//tbody[@ng-repeat='speaker in speakerList']")
    public List<WebElement> SPEAKER_LIST;

    @FindBy(xpath = "//span[@ng-click='removeAllFilters()']")
    public WebElement REMOVE_FILTERS;

    @FindBy(xpath = "//div[contains(text(),'No Speaker(s) found.')]")
    public WebElement NO_SPEAKER_FOUND_TEXT;

    public SpeakerPage (WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }


    private void clickOnImportButton()throws Exception{
        Wait(IMPORT_BUTTON,20);
        click(IMPORT_BUTTON);
        logReport("Import button clicked successfully");
    }

    public void clickOnSearchButton() throws Exception {
        Wait(SEARCH_BUTTON, 2);
        click(SEARCH_BUTTON);
        logReport("Search button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
    }

    public void enterValueInSearchTextBox(String value) throws Exception {
        Wait(SEARCH_TEXTBOX,20);
        type(SEARCH_TEXTBOX, value, true);
        logReport("successfully entered value : "+value+ " in search text box.");
    }



    public AddSpeakerPage clickOnAddNewSpeakerButton()throws Exception{
        Wait(ADD_NEW_BUTTON,20);
        clickByJavaScript(ADD_NEW_BUTTON);
        logReport("Add new button clicked successfully");
        return new AddSpeakerPage(browser);
    }

    public AddSpeakerPage clickOnEditSpeakerButton(String email)throws Exception{
        WebElement editButton = browser.findElement(By.xpath("//tr//td[text()='" + email + "']/..//i[@title='Edit Speaker']"));
        Wait(editButton,20);
        click(editButton);
        logReport("edit speaker  button clicked successfully");
        return new AddSpeakerPage(browser);
    }

    public void clickOnDeleteSpeakerButton(String email)throws Exception{
        WebElement editButton = browser.findElement(By.xpath("//tr//td[text()='" + email + "']/..//i[@title='Delete Speaker']"));
        Wait(editButton,20);
        click(editButton);
        logReport("delete speaker  button clicked successfully");
        acceptAlert();

    }

    public void clickClearFiltersButton() throws Exception {
        Wait(REMOVE_FILTERS, 20);
        click(REMOVE_FILTERS);
        logReport("Remove filters button clicked successfully");
    }

    public AddSpeakerPage searchSpeakerAndClickOnEditButton(AddSpeakerData addSpeakerData) throws Exception {
        enterValueInSearchTextBox(addSpeakerData.getFirstName());
        clickOnSearchButton();
        int listSize = SPEAKER_LIST.size();
        logReport("List size after searching " + listSize);
        if (listSize >= 1) {
            for (int i = 0; i < listSize; i++) {
                //String editXpath = "//tbody[@ng-repeat='speaker in speakerList'][1]//tr[2]//td[2][text()='Neha']//following-sibling::td[1][text()='Goyal']//following-sibling::td//i[@title='Edit Speaker']";
                String xpath = "//tbody[@ng-repeat='speaker in speakerList'][" + (i + 1) + "]//tr[2]//td[2][text()='" + addSpeakerData.getFirstName() + "']//following-sibling::td[1][text()='" + addSpeakerData.getLastName() + "']//following-sibling::td//i[@title='Edit Speaker']";
                WebElement element = browser.findElement(By.xpath(xpath));
                if (verifyElementDisplayed(By.xpath(xpath), 2)) {
                    clickByJavaScript(element);
                    VerifyAngularHasFinishedProcessing(10);

                } else
                    logReport("Speaker : " + addSpeakerData.getFirstName() + " is not found in speaker list.");
            }
        }

        return new AddSpeakerPage(browser);
    }

    public boolean searchSpeaker(AddSpeakerData addSpeakerData) throws Exception {
        boolean found = false;
        enterValueInSearchTextBox(addSpeakerData.getFirstName());
        clickOnSearchButton();
        int listSize = SPEAKER_LIST.size();
        logReport("List size after searching " + listSize);
        if (listSize >= 1) {
            for (int i = 0; i < listSize; i++) {
                String xpath = "//tbody[@ng-repeat='speaker in speakerList'][" + (i + 1) + "]//tr[2]//td[2][text()='" + addSpeakerData.getFirstName() + "']//following-sibling::td[1][text()='" + addSpeakerData.getLastName() + "']//following-sibling::td//i[@title='Edit Speaker']";
                WebElement element = browser.findElement(By.xpath(xpath));
                if (VerifyElementPresent(By.xpath(xpath), 2)) {
                    clickByJavaScript(element);
                    VerifyAngularHasFinishedProcessing(10);
                    found = true;

                } else
                    logReport("Speaker : " + addSpeakerData.getFirstName() + " is not found in speaker list.");
            }
        }

        return found;
    }

    public boolean searchSpeaker(SpeakerInformation addSpeakerData) throws Exception {
        boolean found = false;
        enterValueInSearchTextBox(addSpeakerData.getFirstName());
        clickOnSearchButton();
        int listSize = SPEAKER_LIST.size();
        logReport("List size after searching " + listSize);
        if (listSize >= 1) {
            for (int i = 0; i < listSize; i++) {
                String xpath = "//tbody[@ng-repeat='speaker in speakerList'][" + (i + 1) + "]//tr[2]//td[2][text()='" + addSpeakerData.getFirstName() + "']//following-sibling::td[1][text()='" + addSpeakerData.getLastName() + "']//following-sibling::td//i[@title='Edit Speaker']";
                WebElement element = browser.findElement(By.xpath(xpath));
                if (VerifyElementPresent(By.xpath(xpath), 2)) {
                    found = true;

                } else
                    logReport("Speaker : " + addSpeakerData.getFirstName() + " is not found in speaker list.");
            }
        }

        return found;
    }

}
