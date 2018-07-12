import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class EventFiringTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "utilities/geckodriver");
        driver = new FirefoxDriver();
    }

    @Test
    public void testEventFiringWebDriver() throws Exception {

        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
        MyListener myListener = new MyListener();
        eventDriver.register(myListener);

        eventDriver.get("https://google.com");
        eventDriver.findElement(By.name("q"))
                .sendKeys("Selenium Testing Tools Cookbook");
        eventDriver.findElement(By.name("btnK")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
