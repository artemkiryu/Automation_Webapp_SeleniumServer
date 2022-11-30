package pageObjects.Management;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.CommonActionsPage;

/**
 * Created by infoobjects on 31-08-2017.
 */
public class EditSSOConfigPage extends CommonActionsPage {

    @FindBy(xpath = "//select[@ng-model='fieldMappings[idpHeader]']//optgroup[@label='Profile Standard Fields']")
    public WebElement MAPPING_DROPDOWN;
}
