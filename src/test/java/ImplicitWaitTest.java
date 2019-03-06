import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class ImplicitWaitTest {

    @Test
    public void testWithOutWait() {
        System.setProperty("webdriver.chrome.driver", "utilities/linux/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://cookbook.seleniumacademy.com/AjaxDemo.html");

        try {
            driver.findElement(By.linkText("Page 3")).click();
            WebElement message = driver.findElement(By.id("page3"));
            assertTrue(message.getText().contains("Donec in massa"));
        } finally {
            driver.quit();
        }

    }

    @Test
    public void testWithWait() {
        System.setProperty("webdriver.chrome.driver", "utilities/linux/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://cookbook.seleniumacademy.com/AjaxDemo.html");

        // Implicit wait is set for the entire duration of the webDriver object
        // Whereas explicit wait is confined to a particular web element
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
