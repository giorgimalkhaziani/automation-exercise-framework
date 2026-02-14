package ui;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utils.DriverManager;
import utils.TestListener;

@Listeners(TestListener.class)
public class ContactAndProductTests {

    private HomePage homePage;
    private ContactUsPage contactUsPage;
    private ProductsPage productsPage;
    private ProductDetailPage productDetailPage;
    private CartPage cartPage;

    @BeforeMethod
    public void setup() {
        homePage = new HomePage();
        contactUsPage = new ContactUsPage();
        productsPage = new ProductsPage();
        productDetailPage = new ProductDetailPage();
        cartPage = new CartPage();
    }

    @Test(priority = 6)
    @Description("Test Case 6: Contact Us Form")
    public void testContactUsForm() {
        homePage.openHomePage();
        homePage.clickContactUs();
        contactUsPage.fillContactForm("Giorgi", "test@test.com", "Subject", "Test message");
        contactUsPage.clickSubmit();
        try {
            Alert alert = DriverManager.getDriver().switchTo().alert();
            alert.accept();
        } catch (Exception e) {
        }
        Assert.assertTrue(contactUsPage.isSuccessMessageDisplayed());
    }

    @Test(priority = 7)
    @Description("Test Case 8: Verify All Products")
    public void testVerifyAllProducts() {
        homePage.openHomePage();
        homePage.clickProducts();
        Assert.assertTrue(productsPage.isFirstProductDisplayed());
    }

    @Test(priority = 8)
    @Description("Test Case 9: Search Product")
    public void testSearchProduct() {
        homePage.openHomePage();
        homePage.clickProducts();
        productsPage.searchProduct("Top");
        Assert.assertTrue(productsPage.isFirstProductDisplayed());
    }

    @Test(priority = 9)
    @Description("Test Case 10: Verify Product Details")
    public void testVerifyProductDetails() {
        homePage.openHomePage();
        homePage.clickProducts();
        productsPage.clickFirstProduct();
        String name = productDetailPage.getProductName();
        Assert.assertFalse(name.isEmpty());
    }

    @Test(priority = 10)
    @Description("Test Case 12: Add Products in Cart")
    public void testAddProductsToCart() {
        homePage.openHomePage();
        homePage.clickProducts();
        productsPage.clickFirstProduct();
        productDetailPage.clickAddToCart();
        homePage.clickCart();
        Assert.assertTrue(cartPage.isProductInCart());
    }

    @AfterMethod
    public void teardown() {
        DriverManager.quitDriver();
    }
}
