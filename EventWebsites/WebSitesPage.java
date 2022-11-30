package pageObjects.EventWebsites;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by infoobjects on 6/5/2017.
 */
public class WebSitesPage extends CommonActionsPage {
    @FindBy(xpath = "//a[text()='Add Website']")
    public WebElement ADDWEBSITE_BUTTON;

    @FindBy(xpath = "//table[@id='list-web']//tbody//tr//td[2]")
    public List<WebElement> websitesList;


    @FindBy(xpath = "//td[text()='Event Website']//following-sibling::td//a[@title='Edit']")
    public WebElement EDITWEBSITE_BUTTON;



    public WebSitesPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public AddWebsitesPage clickAddWebsiteButton() throws Exception {
        Wait(ADDWEBSITE_BUTTON, 30);
        click(ADDWEBSITE_BUTTON);
        logReport("Add Website button clicked successfully");
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
        return new AddWebsitesPage(browser);
    }

    public List<String> getWebsitesName() {
        List<String> websiteNames = new ArrayList<>();
        for (WebElement e : websitesList) {
            websiteNames.add(e.getText().trim());
        }
        return websiteNames;
    }

    public AddWebsitesPage EditWebsite() throws Exception {
        Wait(EDITWEBSITE_BUTTON, 30);
        click(EDITWEBSITE_BUTTON);
        logReport("edit website button clicked");
        VerifyPageReady(30);
        return new AddWebsitesPage(browser);

    }

}
