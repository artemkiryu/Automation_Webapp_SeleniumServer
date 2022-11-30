package pageObjects.Sessions;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

public class CatalogListAdminPage extends CommonActionsPage {
    @FindBy(xpath = "//button[text()='Go to Catalog List']")
    public WebElement CATALOGLIST_BUTTON;

    @FindBy(xpath = "//span[text()='Add a catalog']")
    public WebElement ADDCATALOG_BUTTON;

    @FindBy(xpath = "//input[@id='catalogName']")
    public WebElement CATALOGNAME_TEXTBOX;

    @FindBy(xpath = "//ng-select[@aria-label='Catalog Type']")
    public WebElement CATALOGTYPE_DROPDOWN;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement SAVE_BUTTON;

    @FindBy(xpath = "//div[@class='alert flash-message alert-success']")
    public WebElement FLASH_SUCCESS_MSG;


    public CatalogListAdminPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void clickCatalogListButton() throws Exception {
        Wait(CATALOGLIST_BUTTON, 30);
        click(CATALOGLIST_BUTTON);
        logReport("Catalog list button clicked");

    }

    public void selectCatalogType(String type) {
        //scrollBottom();
        scrollIntoView(CATALOGTYPE_DROPDOWN);
        click(CATALOGTYPE_DROPDOWN);
        logReport("Catalog type category dropdown clicked");
        String xpath = "//span[contains(@class,'ng-option-label')][text()='" + type + "']";
        click(browser.findElement(By.xpath(xpath)));

        logReport("Content category value selected successfully" + type);
    }

    public void addCatalog(String catalogName, String catalogType) throws Exception {
        String xpath = "//div[text()='" + catalogName + "']";
        if (!verifyElementDisplayed(By.xpath(xpath), 2)) {
            click(ADDCATALOG_BUTTON);
            logReport("Add catalog button clicked");
            VerifyPageReady(30);
            Thread.sleep(2000);
            type(CATALOGNAME_TEXTBOX, catalogName, true);
            selectCatalogType(catalogType);
            logReport("Selected catalog type " + catalogType);
            click(SAVE_BUTTON);
            VerifyPageReady(30);

        }
    }

    public SessionCatalogAdminPage editCatalog(String name) throws Exception {
        String xpath = "//span[text()='" + name + "']/../../..//following-sibling::div//i[@title='Edit Catalog']";
        WebElement element = browser.findElement(By.xpath(xpath));
        clickByJavaScript(element);
        logReport("Catalog edited by name " + name);
        VerifyAngularHasFinishedProcessing(5);
        VerifyPageReady(30);
        return new SessionCatalogAdminPage(browser);

    }

    public SpeakerCatalogAdminPage editCatalogBySpeaker(String name) throws Exception {
        String xpath = "//span[text()='" + name + "']/../../..//following-sibling::div//i[@title='Edit Catalog']";
        WebElement element = browser.findElement(By.xpath(xpath));
        click(element);
        logReport("Catalog edited by name " + name);
        VerifyAngularHasFinishedProcessing(5);
        VerifyPageReady(30);
        return new SpeakerCatalogAdminPage(browser);

    }

    public boolean isCatalogSaved() {
        if (verifyElementDisplayed(FLASH_SUCCESS_MSG, 2))
            return true;
        return true;
    }

}
