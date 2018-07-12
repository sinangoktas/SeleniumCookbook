import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;

public class DoubleClickTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "utilities/geckodriver");
        driver = new FirefoxDriver();
        driver.get("http://api.jquery.com/dblclick/");
    }

    @Test
    public void testDoubleClick() {
        driver.switchTo().frame(0);
        WebElement element = driver.findElement(By.cssSelector("html>body>div"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        Actions builder = new Actions(driver);
        builder.doubleClick(element).build().perform();

        assertEquals("dbl", element.getAttribute("class"));

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
