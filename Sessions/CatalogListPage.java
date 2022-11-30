package pageObjects.Sessions;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

public class CatalogListPage extends CommonActionsPage {
    @FindBy(xpath = "//button[text()='Go to Catalog List']")
    public WebElement CATALOGLIST_BUTTON;


    public CatalogListPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public CatalogListAdminPage clickCatalogListButton() throws Exception {
        Wait(CATALOGLIST_BUTTON, 30);
        click(CATALOGLIST_BUTTON);
        logReport("Catalog list button clicked");
        VerifyPageReady(30);
        return new CatalogListAdminPage(browser);

    }
}
