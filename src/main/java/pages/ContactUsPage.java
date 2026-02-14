package pages;

import org.openqa.selenium.By;
import utils.BasePage;

public class ContactUsPage extends BasePage {
    private By nameField = By.xpath("//input[@data-qa='name']");
    private By emailField = By.xpath("//input[@data-qa='email']");
    private By subjectField = By.xpath("//input[@data-qa='subject']");
    private By messageField = By.xpath("//textarea[@data-qa='message']");
    private By uploadFileInput = By.name("upload_file");
    private By submitButton = By.xpath("//input[@data-qa='submit-button']");
    private By successMessage = By.xpath("//div[contains(text(),'Success! Your details have been submitted successfully.')]");

    public void fillContactForm(String name, String email, String subject, String message) {
        sendKeys(nameField, name);
        sendKeys(emailField, email);
        sendKeys(subjectField, subject);
        sendKeys(messageField, message);
    }

    public void clickSubmit() {
        click(submitButton);
    }

    public boolean isSuccessMessageDisplayed() {
        return isElementDisplayed(successMessage);
    }
}
