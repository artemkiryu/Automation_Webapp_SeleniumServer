package pageObjects.Forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;
import java.util.List;

/**
 * Created by infoobjects on 23-08-2017.
 */
public class CustomHTMLListPage extends CommonActionsPage {

    @FindBy(xpath = "//table[@id='dataGridTable-form-custom']//tr[1]//td[contains(text(), 'Custom HTML Section 1')]")
    public WebElement CUSTOM_HTML_SECTION;
    @FindBy(xpath = "//table[@id='dataGridTable-form-custom']//tr//td[1]")
    public List<WebElement> FORM_CUSTOM_HTML_LIST;

    @FindBy(xpath = "//div[contains(.,'List of Custom Sections')]/button[text()='Add New']")
    public WebElement ADD_NEW_CUSTOM_SECTIONS_BUTTON;

    public CustomHTMLListPage(WebDriver driver)  throws ConfigurationException{
        PageFactory.initElements(driver, this
        );
    }

    public AddCustomHTMLSectionPage clickOnCustomHTMLSection() throws Exception {
        Wait(CUSTOM_HTML_SECTION, 30);
        click(CUSTOM_HTML_SECTION);
        VerifyPageReady(30);
        return new AddCustomHTMLSectionPage(browser);
    }
}
