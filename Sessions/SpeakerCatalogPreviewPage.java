package pageObjects.Sessions;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import java.util.List;

public class SpeakerCatalogPreviewPage extends CommonActionsPage {
    @FindBy(xpath = "//div[@class='speaker-info-container general-speaker-header-text-style general-speaker-header-text-style-no-image-or-banner-or-card']//strong")
    public List<WebElement> SPEAKER_TEXT;


    public SpeakerCatalogPreviewPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public boolean isSpeakerFound(String speakerName) throws Exception {
        for (WebElement e : SPEAKER_TEXT) {
            if (e.getText().trim().contains(speakerName))
                return true;
        }
        return false;
    }
}
