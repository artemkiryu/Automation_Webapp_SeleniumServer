package pageObjects.EventConfigure;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.IntegrationLinks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by infoobjects on 6/5/2017.
 */
public class IntegrationLinksPage extends CommonActionsPage {
    @FindBy(xpath = "//input[@id='txtWilName']")
    public WebElement NAME_TEXTBOX;
    @FindBy(xpath = "//input[@id='txtWilLabel']")
    public WebElement LABEL_TEXTBOX;
    @FindBy(xpath = "//input[@value='Web Address']")
    public WebElement WEBADDRESS_BUTTON;
    @FindBy(xpath = "//button[@id='create-link']")
    public WebElement ADDNEW_BUTTON;

    public IntegrationLinksPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void fillIntegrationDetails(IntegrationLinks integrationLinks) throws Exception {
        Wait(ADDNEW_BUTTON, 30);
        click(ADDNEW_BUTTON);
        logReport("Add New button clicked successfully");
        VerifyPageReady(30);
        type(NAME_TEXTBOX, integrationLinks.getName());
        logReport("Entered name value " + integrationLinks.getName());
        type(LABEL_TEXTBOX, integrationLinks.getLabel());
        logReport("Entered label value " + integrationLinks.getLabel());
        click(WEBADDRESS_BUTTON);
        logReport("Web Address button clicked successfully");
        clickSaveButtonCommon();
    }

    public List<ArrayList<String>> getIntegrationsLinkList() {
        /*List<String>
        int Row_count = browser.findElements(By.xpath("//table[@id='dataGridTable-settings-integration']//tbody//tr")).size();
        logReport("Number Of Rows = "+Row_count);

        //Get number of columns In table.
        int Col_count = driver.findElements(By.xpath("//table[@id='dataGridTable-settings-integration']//tbody//tr/td")).size();
        logReport("Number Of Columns = "+Col_count);


        for(int i=1;i<=Row_count;i++){
            for(int j=1;j<=Col_count;j++){

            }
        }
        String name = "";
        String label = "";*/

        List<WebElement> rows = browser.findElements(By.xpath("//table[@id='dataGridTable-settings-integration']//tbody//tr"));
        List<ArrayList<String>> rowsData = new ArrayList<>();


        for (WebElement row : rows) {
            List<WebElement> rowElements = row.findElements(By.xpath("./td"));

            ArrayList<String> rowData = new ArrayList<>();

            for (WebElement column : rowElements) {
                rowData.add(column.getText().trim());
            }
            rowsData.add(rowData);
        }
        return rowsData;


    }


}
