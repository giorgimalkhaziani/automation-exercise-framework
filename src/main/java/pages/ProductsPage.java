package pages;

import org.openqa.selenium.By;
import utils.BasePage;

public class ProductsPage extends BasePage {
    private By searchProductField = By.id("search_product");
    private By searchButton = By.id("submit_search");
    private By firstProduct = By.xpath("(//div[@class='product-image-wrapper'])[1]");
    private By firstProductViewLink = By.xpath("(//a[contains(text(),'View Product')])[1]");
    private By addToCartButton = By.xpath("(//a[@data-product-id='1'])[1]");

    public void searchProduct(String productName) {
        sendKeys(searchProductField, productName);
        click(searchButton);
    }

    public void clickFirstProduct() {
        click(firstProductViewLink);
    }

    public void clickAddToCart() {
        click(addToCartButton);
    }

    public boolean isFirstProductDisplayed() {
        return isElementDisplayed(firstProduct);
    }
}
