package pageObjects;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by infoobjects on 8/19/2015.
 */
public class PageHelpPage extends CommonActionsPage {

    /**
     * Page help Page Constructor for setting up page web driver
     */

    public PageHelpPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void switchToFrame() {
        String xpath = "//frameset//frame[2]";
        WebElement frame = browser.findElement(By.xpath(xpath));
        browser.switchTo().frame(frame);
        reporter.info("switched successfully to frame");
    }


}
