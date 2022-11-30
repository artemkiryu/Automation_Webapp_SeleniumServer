package pageObjects.Accommodation;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import pojo.SubBlockData;

/**
 * Created by infoobjects on 8/21/2017.
 */
public class SubBlocksPage extends CommonActionsPage {
    @FindBy(xpath ="//input[@name='subBlockLabel']")
    public WebElement SUBBLOCK_NAME_TEXTBOX;

    @FindBy(xpath ="//input[contains(@id,'s2id_autogen')]")
    public WebElement SELECT_BLOCK_TEXTBOX;

    @FindBy(xpath ="//button[text()='Save']")
    public WebElement SAVE_BUTTON;

    @FindBy(xpath ="//a[text()='Blocks']")
    public WebElement BLOCKS_SUB_TAB ;

    @FindBy(xpath ="//h3[text()='Accommodation Sub-Block Detail']")
    public WebElement PAGE_HEADER ;

    @FindBy(xpath ="//label[@class='requiredField control-label ng-binding']")
    public WebElement REQUIRED_FIELD ;

    @FindBy(xpath ="//button[text()='Save & New']")
    public WebElement SAVE_NEW_BUTTON;

    @FindBy(xpath ="//button[text()='Cancel']")
    public WebElement CANCEL_BUTTON ;

    @FindBy(xpath ="//button[text()='Add New']")
    public WebElement ADD_NEW_BUTTON;

    @FindBy(xpath ="//div[@class='modal-header ng-scope']//span")
    public WebElement CLOSE_LINK;
    public SubBlocksPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }


     public void enterSubBlockName(String subBlockName) {
        type(SUBBLOCK_NAME_TEXTBOX, subBlockName);
        reporter.info("Entered Value: " + subBlockName + " in 'Sub Block' TextBox");
    }

    /**
     * Method for select value of block
     *
     * @param block : name of block which we need to select
     */
    public void selectBlock(String block) {
        type(SELECT_BLOCK_TEXTBOX,block);
        type(SELECT_BLOCK_TEXTBOX, "{TAB}");
        reporter.info("Selected block type code = " + block);

    }

    public BlocksPage clickBlockSubTab() throws Exception{
        click(BLOCKS_SUB_TAB);
        return new BlocksPage(browser);
    }

    /**
     * Method for entering allocated value according to date
     *
     * @param allocatedValue allocated value of subblock
     * @param date           date value of subblock
     */
    private void enterAllocatedValue(String allocatedValue, String date) {
        String xpath = "//table[@class='table table-hover table-bordered']//tbody//tr//td//span[text()='" + date + "']/../..//td//input";
        type(browser.findElement(By.xpath(xpath)), allocatedValue);
        reporter.info("Entered Value: " + allocatedValue + " under 'Allocated; column corresponding to " + date + " date.");
    }

    /**
     * Method for select allocate value by no of days
     *
     * @param allocatedValue value which need to be allocated
     * @param days           no of days
     * @throws Exception
     */
    public void selectAllocatedValue(String allocatedValue, int days) throws Exception {
        for (int i = 0; i < days - 1; i++) {
            String dateValue = getDateByDays(i);
            String xpath = "//table[@class='table table-hover table-bordered']//tbody//tr//td//span[text()='" + dateValue + "']/../..//td//input";
            type(browser.findElement(By.xpath(xpath)), allocatedValue);
            reporter.info("Entered Value: " + allocatedValue + " under 'Allocated; column corresponding to " + dateValue + " date.");
        }
    }

    /**
     * Method for clicking on Save button under sub blocks page
     *
     * @return SubBlocksPage
     */
    public SubBlocksPage clickOnSaveButton() throws Exception{
        Wait(SAVE_BUTTON,30);
        click(SAVE_BUTTON);
        //webDriver.waitFor().waitforAngularJS();
        return new SubBlocksPage(browser);
    }

    /**
     * Method for filling sub block page details
     *
     * @param subBlockData: page object of SubBlockData
     */

    public void fillSubBlockDetail(SubBlockData subBlockData, int days) throws Exception {
        enterSubBlockName(subBlockData.getName());
        selectBlock(subBlockData.getBlockCode());
        selectAllocatedValue(subBlockData.getAllocatedValue(), days);

    }


    public void clickOnAddNewButton() throws Exception{
        Wait(ADD_NEW_BUTTON, 30);
        VerifyAngularHasFinishedProcessing(30);
        click(ADD_NEW_BUTTON);

    }


}
