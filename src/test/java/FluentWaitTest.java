import com.google.common.base.Function;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class FluentWaitTest {

    @Test
    public void testFluentWait() {

        System.setProperty("webdriver.chrome.driver", "utilities/linux/chromedriver");
        WebDriver driver = new ChromeDriver();
        // Launch the sample Ajax application
        driver.get("http://cookbook.seleniumacademy.com/AjaxDemo.html");

        try {
            driver.findElement(By.linkText("Page 4")).click();

            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .pollingEvery(Duration.ofSeconds(2))
                    .withTimeout(Duration.ofSeconds(10))
                    .ignoring(NoSuchElementException.class);

            WebElement message = wait
                    .until((Function<WebDriver, WebElement>)
                            d -> d.findElement(By.id("page4")));

            assertTrue(message.getText().contains("Nunc nibh tortor"));
        } finally {
            driver.quit();
        }
    }

}
