package pages;

import org.openqa.selenium.By;
import utils.BasePage;
import utils.DriverManager;

public class HomePage extends BasePage {
    private By signupLoginLink = By.xpath("//a[@href='/login']");
    private By contactUsLink = By.xpath("//a[@href='/contact_us']");
    private By productsLink = By.xpath("//a[@href='/products']");
    private By cartLink = By.xpath("//a[@href='/view_cart']");
    private By logoutLink = By.xpath("//a[@href='/logout']");
    private By deleteAccountLink = By.xpath("//a[@href='/delete_account']");
    
    public void openHomePage() {
        DriverManager.getDriver().get("https://automationexercise.com");
    }

    public void clickSignupLogin() {
        click(signupLoginLink);
    }

    public void clickContactUs() {
        click(contactUsLink);
    }

    public void clickProducts() {
        click(productsLink);
    }

    public void clickCart() {
        click(cartLink);
    }

    public void clickLogout() {
        click(logoutLink);
    }

    public void clickDeleteAccount() {
        click(deleteAccountLink);
    }

    public boolean isLogoutVisible() {
        return isElementDisplayed(logoutLink);
    }
}
