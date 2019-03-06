import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GoogleSearchTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "utilities/linux/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.co.uk");

    }

    @Test
    public void testGoogleSearch() {
        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys("Selenium testing tools cookbook");
        element.submit();

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds

        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>)
                d -> d.getTitle().toLowerCase()
                .startsWith("selenium testing tools cookbook"));

        assertEquals("Selenium testing tools cookbook - Google Search",
                driver.getTitle());
    }

    @Test
    public void testFindElements() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        assertEquals(42, links.size());
        for (WebElement link : links) {
            System.out.println(link.getAttribute("href"));

        }
    }

    @Test
    public void testLinkText() {
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        assertEquals("https://mail.google.com/mail/?tab=wm", gmailLink.getAttribute("href"));

        WebElement signInLink = driver.findElement(By.partialLinkText("Sign"));
        System.out.println(signInLink.getText());
    }


    @After
    public void tearDown() throws Exception {
        // Close the browser
        driver.quit();
    }
}
