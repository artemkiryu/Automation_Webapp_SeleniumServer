package pageObjects.ReviewerPortal;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

public class ReviewSessionsPage extends CommonActionsPage {
    @FindBy(xpath = "//span[@class='rz-pointer rz-pointer-min']")
    public WebElement MIN_DRAG_VALUE;

    @FindBy(xpath = "//span[@class='rz-pointer rz-pointer-min'][@aria-valuenow='3']")
    public WebElement MAX_DRAG_VALUE;


    @FindBy(xpath = "//textarea[@ng-model='reviewer.comment']")
    public WebElement REVIEWER_COMMENT_TEXTAREA;

    @FindBy(xpath = "//input[@value='SUBMIT REVIEW']")
    public WebElement SUBMITREVIEW;


    public ReviewSessionsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void openSession(String sessionName) throws Exception {
        String xpath = "//div[@ng-repeat='session in sessionList']//div[contains(.,'" + sessionName + "')][@data-toggle='collapse']";
        WebElement element = browser.findElement(By.xpath(xpath));
        clickByJavaScript(element);
        logReport("Session opened successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
    }

    public void dragSlider() throws Exception {
        scrollIntoView(REVIEWER_COMMENT_TEXTAREA);
        Thread.sleep(3000);
        Wait(MIN_DRAG_VALUE, 20);
        Actions builder = new Actions(browser);
        /*Action dragAndDrop = builder.clickAndHold(MIN_DRAG_VALUE)
                .moveToElement(MAX_DRAG_VALUE)
                .release(MAX_DRAG_VALUE)
                .build();

        dragAndDrop.perform();
        */
        int xOffset1 = MIN_DRAG_VALUE.getLocation().getX();

        int yOffset1 = MIN_DRAG_VALUE.getLocation().getY();

        logReport("xOffset1--->" + xOffset1 + " yOffset1--->" + yOffset1);
        Thread.sleep(5000);
        //Secondly, get x and y offset for to object
        int xOffset = 398;

        int yOffset = 177;

        logReport("xOffset--->" + xOffset + " yOffset--->" + yOffset);

        xOffset = (xOffset - xOffset1) + 10;
        yOffset = (yOffset1 - yOffset) + 20;


        //Perform dragAndDropBy
        builder.dragAndDropBy(MIN_DRAG_VALUE, xOffset, yOffset).perform();
    }

    public void enterCommentValue(String comment) {
        type(REVIEWER_COMMENT_TEXTAREA, comment, true);
        logReport("Entered reviewer comment value " + comment);
    }

    public void submitReviewButton() throws Exception {
        Wait(SUBMITREVIEW, 30);
        click(SUBMITREVIEW);
        logReport("Submit review button clicked");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
    }

    public boolean isSessionStatus(String sessionName, String status) {
        String xpath = "//div[@ng-repeat='session in sessionList']//div[contains(.,'" + sessionName + "')]//a//span[text()='" + status + "']";
        return verifyElementDisplayed(By.xpath(xpath), 10);

    }

}

