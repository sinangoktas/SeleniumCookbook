import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class NavigationTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "utilities/linux/chromedriver");
        driver = new ChromeDriver();
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
        click() is used to click on the button in the webpage.
        submit() can be used to click on the button present in the form
        and type attribute should be "submit".
         */

        WebElement resultLink = driver.findElement(By
                .linkText("Selenium WebDriver"));
        resultLink.click();

        new WebDriverWait(driver, 10).until(ExpectedConditions
                .titleIs("Selenium (software) - Wikipedia"));

        driver.navigate().back();

        new WebDriverWait(driver, 10).until(ExpectedConditions
                .titleIs("selenium webdriver - Google Search"));

        driver.navigate().forward();

        new WebDriverWait(driver, 10).until(ExpectedConditions
                .titleIs("Selenium (software) - Wikipedia"));

        driver.navigate().refresh();

        new WebDriverWait(driver, 10).until(ExpectedConditions
                .titleIs("Selenium (software) - Wikipedia"));

    }
}
