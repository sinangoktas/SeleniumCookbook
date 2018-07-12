import com.google.common.base.Function;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class FluentWaitTest {

    @Test
    public void testFluentWait() {

        System.setProperty("webdriver.gecko.driver", "utilities/geckodriver");
        WebDriver driver = new FirefoxDriver();
        // Launch the sample Ajax application
        driver.get("http://cookbook.seleniumacademy.com/AjaxDemo.html");

        try {
            driver.findElement(By.linkText("Page 4")).click();

            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(10, TimeUnit.SECONDS)
                    .pollingEvery(2, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);

            WebElement message = wait
                    .until(new Function<WebDriver, WebElement>() {
                        public WebElement apply(WebDriver d) {
                            return d.findElement(By.id("page4"));
                        }
                    });

            assertTrue(message.getText().contains("Nunc nibh tortor"));
        } finally {
            driver.quit();
        }
    }

}
