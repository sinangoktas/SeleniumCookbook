import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;


public class DoubleClickTest2 {

    @Test
    public void testDoubleClick() throws Exception {
        System.setProperty("webdriver.gecko.driver", "utilities/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");

        try {
            WebElement message = driver.findElement(By.id("message"));
            // Verify colour is blue
            assertEquals("rgb(0, 0, 255)", message.getCssValue("background-color"));

            Actions builder = new Actions(driver);
            builder.doubleClick(message).perform();

            // Verify colour is yellow
            assertEquals("rgb(255, 255, 0)", message.getCssValue("background-color"));


        }finally {
            driver.quit();

        }
    }
}
