import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

// import WebElementExtender;

public class ScreenShotTest {

    private WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "utilities/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.co.uk");

    }

    @Test
    public void testTakesScreenshot() throws Exception {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("target/main_page.png"));

    }

    @Test
    public void testElementScreenshot() throws Exception {
        WebElement searchButton = driver.findElement(By.name("btnK"));
        /*FileUtils.copyFile(
                WebElementExtender.captureElementPicture(searchButton),
                new File("target/searchButton.png"));*/

    }

    @After
    public void tearDown() {

        driver.quit();

    }
}
