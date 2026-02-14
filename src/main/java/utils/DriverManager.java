package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.setExperimentalOption("useAutomationExtension", false);
            driver.set(new ChromeDriver(options));
            wait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(15)));
        }
        return driver.get();
    }

    public static WebDriverWait getWait() {
        return wait.get();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
            wait.remove();
        }
    }
}
