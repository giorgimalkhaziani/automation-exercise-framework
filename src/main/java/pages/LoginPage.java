package pages;

import org.openqa.selenium.By;
import utils.BasePage;

public class LoginPage extends BasePage {
    private By signupNameField = By.xpath("//input[@data-qa='signup-name']");
    private By signupEmailField = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");
    
    private By loginEmailField = By.xpath("//input[@data-qa='login-email']");
    private By loginPasswordField = By.xpath("//input[@data-qa='login-password']");
    private By loginButton = By.xpath("//button[@data-qa='login-button']");
    private By loginErrorMessage = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");

    public void fillSignupForm(String name, String email) {
        sendKeys(signupNameField, name);
        sendKeys(signupEmailField, email);
    }

    public void clickSignupButton() {
        click(signupButton);
    }

    public void fillLoginForm(String email, String password) {
        sendKeys(loginEmailField, email);
        sendKeys(loginPasswordField, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public boolean isLoginErrorVisible() {
        return isElementDisplayed(loginErrorMessage);
    }
}
