package pageObjects.Communication;


import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by infoobjects on 5/3/2017.
 */
public class EventScheduleEmailPage extends CommonActionsPage {


    @FindBy(xpath = "//table[@id='list-templates']/tbody/tr/td[1]")
    public List<WebElement> SPEAKER_EMAIL_TEMPLATE_LIST;

    public EventScheduleEmailPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public List<String> getScheduleEmailItems() throws Exception {
        logReport("" + SPEAKER_EMAIL_TEMPLATE_LIST.size() + "Items");
        List<String> items = new ArrayList<>();
        for (WebElement e : SPEAKER_EMAIL_TEMPLATE_LIST) {
            items.add(e.getText().trim());
        }
        return items;
    }

}
