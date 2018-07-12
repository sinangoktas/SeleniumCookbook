import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class ImplicitWaitTest {

    @Test
    public void testWithOutWait() {
        System.setProperty("webdriver.gecko.driver", "utilities/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://cookbook.seleniumacademy.com/AjaxDemo.html");

        try {
            driver.findElement(By.linkText("Page 4")).click();
            WebElement message = driver.findElement(By.id("page4"));
            assertTrue(message.getText().contains("Nunc nibh tortor"));
        } finally {
            driver.quit();
        }

    }

    @Test
    public void testWithWait() {
        System.setProperty("webdriver.gecko.driver", "utilities/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://cookbook.seleniumacademy.com/AjaxDemo.html");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            driver.findElement(By.linkText("Page 4")).click();
            WebElement message = driver.findElement(By.id("page4"));
            assertTrue(message.getText().contains("Nunc nibh tortor"));
        } finally {
            driver.quit();
        }

    }
}
