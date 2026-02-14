package pages;

import org.openqa.selenium.By;
import utils.BasePage;

public class SignupPage extends BasePage {
    private By titleMr = By.id("id_gender1");
    private By passwordField = By.id("password");
    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By addressField = By.id("address1");
    private By countryDropdown = By.id("country");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipcodeField = By.id("zipcode");
    private By mobileNumberField = By.id("mobile_number");
    private By createAccountButton = By.xpath("//button[@data-qa='create-account']");
    private By accountCreatedMessage = By.xpath("//h2[@data-qa='account-created']");
    private By continueButton = By.xpath("//a[@data-qa='continue-button']");

    public void selectTitle() {
        click(titleMr);
    }

    public void fillAccountInformation(String password, String firstName, String lastName) {
        sendKeys(passwordField, password);
        sendKeys(firstNameField, firstName);
        sendKeys(lastNameField, lastName);
    }

    public void fillAddressInformation(String address, String state, String city, String zipcode, String mobile) {
        sendKeys(addressField, address);
        sendKeys(stateField, state);
        sendKeys(cityField, city);
        sendKeys(zipcodeField, zipcode);
        sendKeys(mobileNumberField, mobile);
    }

    public void clickCreateAccount() {
        click(createAccountButton);
    }

    public boolean isAccountCreated() {
        return isElementDisplayed(accountCreatedMessage);
    }

    public void clickContinue() {
        click(continueButton);
    }
}
