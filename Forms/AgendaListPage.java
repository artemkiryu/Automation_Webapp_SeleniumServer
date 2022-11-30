package pageObjects.Forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;
import java.util.List;

/**
 * Created by infoobjects on 25-09-2017.
 */
public class AgendaListPage extends CommonActionsPage {

    @FindBy(xpath = "//table[@class='table table-striped table-hover tablesorter-default list  dataTable no-footer tablesorter tablesorter-bootstrap']//tr[@id='1']")
    public WebElement AGENDA_SECTION;
    @FindBy(xpath = "//input[@type='search']")
    public WebElement SEARCH_AGENDA_TEXTBOX;
    @FindBy(xpath = "//table[@class='table table-striped table-hover tablesorter-default list  dataTable no-footer tablesorter tablesorter-bootstrap']//tr[@id='1']//*[contains(text(),'Agenda Section 1')]")
    public WebElement SELECT_SEARCHED_AGENDA_SECTION;
    // @FindBy(xpath = "//table[@class='table table-striped table-hover tablesorter-default list  dataTable no-footer tablesorter tablesorter-bootstrap']
    @FindBy(xpath = "//table[@id='agendaBlocks']//tbody//tr/td[2]")
    public List<WebElement> FORM_AGENDA_LIST;
    @FindBy(xpath = "//div[contains(.,'List of Agenda Sections')]/button[text()='Add New']")
    public WebElement ADD_NEW_AGENDA_SECTIONS_BUTTON;

    public AgendaListPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public AgendaPage clickOnAgendaSection() throws Exception {
        Wait(AGENDA_SECTION, 30);
        click(AGENDA_SECTION);
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(30);
        return new AgendaPage(browser);

    }
}
