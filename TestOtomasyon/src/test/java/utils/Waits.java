package utils;

import core.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class Waits  {
    private static final long TIMEOUT_SEC = Long
            .parseLong(System.getProperty("wait.timeout","20"));

    private static final long POLL_MS = Long
            .parseLong(System.getProperty("wait.poll","500"));

    private static WebDriver d() {
        return DriverManager.get();
    }

    private static FluentWait<WebDriver> fluentWait() {
        return new FluentWait<>(DriverManager.get())
                .withTimeout(Duration.ofSeconds(TIMEOUT_SEC))
                .pollingEvery(Duration.ofMillis(POLL_MS))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    public static void humanPause(Duration duration) {
        new FluentWait<>(DriverManager.get())
                .withTimeout(duration)
                .pollingEvery(Duration.ofMillis(POLL_MS))
                .until(driver -> true);
    }
    // Element bulana kadar bekle
    public static WebElement untilPresent(By locator){
        return fluentWait().until(driver ->  driver.findElement(locator));
    }
    // Görünür olana kadar bekle
    public static WebElement untilVisible(By locator){
        return fluentWait().until(driver ->  {
            WebElement el = driver.findElement(locator);
            return el.isDisplayed() ? el : null;
        });
    }
    // Tıklanabilir olana kadar bekle
    public static WebElement untilClickable(By locator){
        return fluentWait().until(driver -> {
            WebElement el = driver.findElement(locator);
            return (el.isDisplayed() && el.isEnabled()) ? el : null;
        });
    }

    // URL belirli bir parçayı içerene kadar bekle
    public static boolean untilURLContains(String text)
    {
        return fluentWait().until(driver ->driver.getCurrentUrl().contains(text));
    }

    //başlığı belirli bir parçayı içerene kadar bekle
    public static boolean untilTiteContains(String text){
        return fluentWait().until(driver ->driver.getTitle().contains(text));
    }
    // --- YENİ: İnsan benzeri davranış yardımcıları ---


    // Custom koşul
    public static <T> T until(Function<WebDriver, T> condition) {
        return fluentWait().until(condition);
    }
}
