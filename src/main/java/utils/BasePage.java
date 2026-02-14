package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage {
    
    protected void click(By locator) {
        try {
            WebElement element = waitForElementToBeClickable(locator);
            scrollToElement(element);
            element.click();
        } catch (Exception e) {
            clickWithJS(locator);
        }
    }

    protected void sendKeys(By locator, String text) {
        WebElement element = waitForElementToBeVisible(locator);
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return waitForElementToBeVisible(locator).getText();
    }

    protected boolean isElementDisplayed(By locator) {
        try {
            return waitForElementToBeVisible(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected WebElement waitForElementToBeVisible(By locator) {
        return DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForElementToBeClickable(By locator) {
        return DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitForUrlContains(String urlFragment) {
        DriverManager.getWait().until(ExpectedConditions.urlContains(urlFragment));
    }

    protected void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void clickWithJS(By locator) {
        WebElement element = waitForElementToBeVisible(locator);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].click();", element);
    }
}
