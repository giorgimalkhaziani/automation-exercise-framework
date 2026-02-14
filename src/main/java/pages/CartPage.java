package pages;

import org.openqa.selenium.By;
import utils.BasePage;

public class CartPage extends BasePage {
    private By proceedToCheckoutButton = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    private By firstProductInCart = By.xpath("(//tr[@id='product-1'])[1]");
    
    public void clickProceedToCheckout() {
        click(proceedToCheckoutButton);
    }

    public boolean isProductInCart() {
        return isElementDisplayed(firstProductInCart);
    }
}
