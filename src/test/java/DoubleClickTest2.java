import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;


public class DoubleClickTest2 {

    private WebDriver driver;

    @Test
    public void testDoubleClick() throws Exception {
        System.setProperty("webdriver.chrome.driver", "utilities/linux/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");

        try {
            WebElement message = driver.findElement(By.id("message"));
            // Verify colour is blue
            assertEquals("rgba(0, 0, 255, 1)", message.getCssValue("background-color"));

            Actions builder = new Actions(driver);
            builder.doubleClick(message).perform();

            // Verify colour is yellow
            assertEquals("rgba(255, 255, 0, 1)", message.getCssValue("background-color"));


        }finally {
            driver.quit();

        }
    }
}
