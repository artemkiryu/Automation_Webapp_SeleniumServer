package pageObjects.Forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddFormAddlRegsPageData;
import pojo.SectionHeader;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 23-08-2017.
 */
public class AddlRegsPage extends CommonActionsPage {

    @FindBy(xpath = "//textarea[@name='instructions']")
    public WebElement INSTRUCTIONS_TEXTBOX;

    public AddlRegsPage(WebDriver driver) throws ConfigurationException{
        PageFactory.initElements(driver, this);
    }

   public void fillFormAddlRegsDetails(SectionHeader sectionHeaderData, AddFormAddlRegsPageData addFormAddlRegsPageData) throws Exception{
        Wait(SAVE_BUTTON_FORM, 30);
       VerifyAjaxRequestsFinished(30);
       fillSectionHeaderDetails(sectionHeaderData);
       type(INSTRUCTIONS_TEXTBOX, addFormAddlRegsPageData.getInstructionText());
   }
}
