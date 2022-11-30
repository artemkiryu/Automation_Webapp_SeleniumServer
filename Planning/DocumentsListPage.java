package pageObjects.Planning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 25-08-2017.
 */
public class DocumentsListPage extends CommonActionsPage {

    @FindBy(xpath = "//div[contains(.,'Event Documents')]/button[text()='Add New']")
    public WebElement ADD_NEW_DOCUMENTS_BUTTON;

    public DocumentsListPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public AddDocumentPage clickAddNewDocumentBtn() throws Exception {
        click(ADD_NEW_DOCUMENTS_BUTTON);
        logReport("Documents add new button clicked successfully");
        return new AddDocumentPage(browser);
    }
}
