package pageObjects.EventConfigure;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by infoobjects on 11/18/2015.
 */
public class EventSalesforcePage extends CommonActionsPage {
    @FindBy(xpath = "//input[@value='Search']")
    public WebElement SEARCH_BUTTON;
    @FindBy(xpath = "//input[@value='Save']")
    public WebElement SAVE_BUTTON;

    public EventSalesforcePage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for clicking search button
     */
    public void clickSearchButton() throws Exception {
        click(SEARCH_BUTTON);
        reporter.info("Search button clicked successfully");
        VerifyPageReady(20);
    }

    /**
     * Method for select campaign name
     */
    public void selectCampaignName() {
        String xpath = "//table[@class='table table-striped table-hover tablesorter-default tablesorter tablesorter-bootstrap']//tbody//tr//td//input";
        List<WebElement> element = browser.findElements(By.xpath(xpath));

        for (int i = 0; i < element.size(); i++) {
            //WebElement inputElement = element.get(i).findElement(By.xpath("//td//input"));
            // reporter.info("selected value"+inputElement.isSelected());
            if (!element.get(i).isSelected()) {
                element.get(i).click();

            }

        }
    }

    public boolean getCampaignNameListSize() {
        String xpath = "//table[@class='table table-striped table-hover tablesorter-default tablesorter tablesorter-bootstrap']//tbody//tr//td[2]";
        List<WebElement> element = browser.findElements(By.xpath(xpath));
        return element.size() > 0;
    }

    /**
     * Method for get campaign name list
     *
     * @return List - list of campaign name
     */
    public List<String> getCampaignNameList() {
        String xpath = "//table[@class='table table-striped table-hover tablesorter-default tablesorter tablesorter-bootstrap']//tbody//tr//td[2]";
        List<WebElement> element = browser.findElements(By.xpath(xpath));
        List<String> campaignNames = new ArrayList<>();
        for (int i = 0; i < element.size(); i++) {
            element.get(i).click();
            campaignNames.add(element.get(i).getText());
        }
        return campaignNames;
    }

    /**
     * Method for clicking save button
     */
    public void clickSaveButton() {
        click(SAVE_BUTTON);
        reporter.info("Save button clicked successfully");

    }
}
