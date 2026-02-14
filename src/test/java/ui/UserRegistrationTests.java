package ui;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utils.DriverManager;
import utils.TestListener;

@Listeners(TestListener.class)
public class UserRegistrationTests {

    private HomePage homePage;
    private LoginPage loginPage;
    private SignupPage signupPage;

    @BeforeMethod
    public void setup() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        signupPage = new SignupPage();
    }

    @Test(priority = 1)
    @Description("Test Case 1: Register User")
    public void testRegisterUser() {
        homePage.openHomePage();
        homePage.clickSignupLogin();
        loginPage.fillSignupForm("Giorgi", "giorgi" + System.currentTimeMillis() + "@test.com");
        loginPage.clickSignupButton();
        signupPage.selectTitle();
        signupPage.fillAccountInformation("Test123", "Giorgi", "Malkhaziani");
        signupPage.fillAddressInformation("123 Main St", "Georgia", "Tbilisi", "0100", "555-1234");
        signupPage.clickCreateAccount();
        Assert.assertTrue(signupPage.isAccountCreated());
        signupPage.clickContinue();
    }

    @Test(priority = 2)
    @Description("Test Case 2: Login User with correct email and password")
    public void testLoginWithValidCredentials() {
        homePage.openHomePage();
        homePage.clickSignupLogin();
        String email = "testuser" + System.currentTimeMillis() + "@test.com";
        loginPage.fillSignupForm("TestUser", email);
        loginPage.clickSignupButton();
        signupPage.selectTitle();
        signupPage.fillAccountInformation("Pass123", "TestUser", "TestLast");
        signupPage.fillAddressInformation("123 St", "State", "City", "12345", "5550000");
        signupPage.clickCreateAccount();
        signupPage.clickContinue();
        homePage.clickLogout();
        homePage.clickSignupLogin();
        loginPage.fillLoginForm(email, "Pass123");
        loginPage.clickLoginButton();
        Assert.assertTrue(homePage.isLogoutVisible());
    }

    @Test(priority = 3)
    @Description("Test Case 3: Login User with incorrect email and password")
    public void testLoginWithInvalidCredentials() {
        homePage.openHomePage();
        homePage.clickSignupLogin();
        loginPage.fillLoginForm("invalid@test.com", "wrongpass");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isLoginErrorVisible());
    }

    @Test(priority = 4)
    @Description("Test Case 4: Logout User")
    public void testLogoutUser() {
        homePage.openHomePage();
        homePage.clickSignupLogin();
        String email = "user" + System.currentTimeMillis() + "@test.com";
        loginPage.fillSignupForm("User", email);
        loginPage.clickSignupButton();
        signupPage.selectTitle();
        signupPage.fillAccountInformation("Pass123", "User", "Last");
        signupPage.fillAddressInformation("123 St", "State", "City", "12345", "5551234");
        signupPage.clickCreateAccount();
        signupPage.clickContinue();
        homePage.clickLogout();
        Assert.assertFalse(homePage.isLogoutVisible());
    }

    @Test(priority = 5)
    @Description("Test Case 5: Register User with existing email")
    public void testRegisterWithExistingEmail() {
        homePage.openHomePage();
        homePage.clickSignupLogin();
        loginPage.fillSignupForm("Test", "existing@test.com");
        loginPage.clickSignupButton();
    }

    @AfterMethod
    public void teardown() {
        DriverManager.quitDriver();
    }
}
