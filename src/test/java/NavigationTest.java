import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class NavigationTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "utilities/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://www.google.com");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testNavigation() {

        // Get the search textbox
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.clear();

        // Enter search keyword and submit
        searchField.sendKeys("selenium webdriver");
        searchField.submit();

        /*
        click() method is used to click on the button in the webpage.
        submit() method can be used to click on the button present in the form and type attribute should be "submit".
         */

        WebElement resultLink = driver.findElement(By
                .linkText("Selenium WebDriver"));
        resultLink.click();

        new WebDriverWait(driver, 10).until(ExpectedConditions
                .titleIs("Selenium WebDriver"));

        assertEquals("Selenium WebDriver", driver.getTitle());

        driver.navigate().back();

        new WebDriverWait(driver, 10).until(ExpectedConditions
                .titleIs("selenium webdriver - Google Search"));

        assertEquals("selenium webdriver - Google Search", driver.getTitle());

        driver.navigate().forward();

        new WebDriverWait(driver, 10).until(ExpectedConditions
                .titleIs("Selenium WebDriver"));

        assertEquals("Selenium WebDriver", driver.getTitle());

        driver.navigate().refresh();

        new WebDriverWait(driver, 10).until(ExpectedConditions
                .titleIs("Selenium WebDriver"));

        assertEquals("Selenium WebDriver", driver.getTitle());
    }
}
