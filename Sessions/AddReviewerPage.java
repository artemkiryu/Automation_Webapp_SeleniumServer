package pageObjects.Sessions;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddReviewer;

public class AddReviewerPage extends CommonActionsPage {
    @FindBy(xpath = "//label[text()='First Name']//following-sibling::div/input")
    public WebElement firstName;

    @FindBy(xpath = "//label[text()='Last Name']//following-sibling::div/input")
    public WebElement lastName;

    @FindBy(xpath = "//label[text()='Email']//following-sibling::div/input")
    public WebElement email;

    @FindBy(xpath = "//label[text()='Username']//following-sibling::div/input")
    public WebElement username;

    @FindBy(xpath = "//label[text()='Password']//following-sibling::div/input")
    public WebElement password;

    @FindBy(xpath = "//label[text()='Track(s)']//following-sibling::select")
    public WebElement track_dropdown;

    @FindBy(xpath = "//label[text()='Tier']//following-sibling::select")
    public WebElement tier_dropdown;

    @FindBy(xpath = "//input[@value='Save']")
    public WebElement saveButton;

    public AddReviewerPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void fillReviewerMandatoryDetails(AddReviewer addReviewer) throws Exception {
        Wait(firstName, 30);
        type(firstName, addReviewer.getFirstName(), true);
        type(lastName, addReviewer.getLastName(), true);
        type(email, addReviewer.getEmail(), true);
        type(username, addReviewer.getUsername(), true);
        type(password, addReviewer.getPassword(), true);
        select(track_dropdown, addReviewer.getTrack());
       // select(tier_dropdown, addReviewer.getTier());
        logReport("Values entered successfully for reviewer details");
    }

    public ReviewersPage clickSaveButton() throws Exception {
        Wait(saveButton, 30);
        click(saveButton);
        logReport("Save button clicked");
        VerifyPageReady(30);
        return new ReviewersPage(browser);
    }

}
