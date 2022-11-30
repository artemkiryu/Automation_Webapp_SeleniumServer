package pageObjects.Forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddFormAgendaData;
import pojo.SectionHeader;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 23-08-2017.
 */
public class AgendaPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@name='name']")
    public WebElement AGENDA_SECTION_NAME;

    public AgendaPage(WebDriver driver)throws ConfigurationException {
        PageFactory.initElements(driver,this);
    }

    public void fillAgendaPageDetails(SectionHeader sectionHeaderData, AddFormAgendaData addFormAgendaData) throws Exception {
        Wait(SAVE_BUTTON, 30);
        VerifyAjaxRequestsFinished(30);
        fillSectionHeaderDetails(sectionHeaderData);
        type(AGENDA_SECTION_NAME, addFormAgendaData.getAgendaSectionName(), true);

    }

}
