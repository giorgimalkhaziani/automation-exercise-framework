package pages;

import org.openqa.selenium.By;
import utils.BasePage;

public class ProductDetailPage extends BasePage {
    private By productName = By.xpath("//div[@class='product-information']//h2");
    private By productPrice = By.xpath("//div[@class='product-information']//span//span");
    private By quantityField = By.id("quantity");
    private By addToCartButton = By.xpath("//button[@class='btn btn-default cart']");

    public String getProductName() {
        return getText(productName);
    }

    public String getProductPrice() {
        return getText(productPrice);
    }

    public void setQuantity(String quantity) {
        sendKeys(quantityField, quantity);
    }

    public void clickAddToCart() {
        click(addToCartButton);
    }
}
