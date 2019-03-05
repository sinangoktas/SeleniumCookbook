import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.fail;

public class ElementStateTest {

    private static WebDriver driver;
    ElementValidators elementValidators = new ElementValidators(driver);

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "utilities/linux/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://cookbook.seleniumacademy.com/Config.html");
    }

    @Test
    public void testElementIsEnabled() {
        WebElement leadHeadLamp = driver.findElement(By.name("ledheadlamp"));
        if(elementValidators.isElementPresent(leadHeadLamp) && leadHeadLamp.isEnabled()) {
            if (!leadHeadLamp.isSelected()) {
                leadHeadLamp.click();
            }

        } else {
            fail("LED Lamp Checkbox is disabled ");
        }
    }

    @Test
    public void testIsElementPresent() {
        if(elementValidators.isElementPresent(By.name("airbags"))) {
            WebElement airbag = driver.findElement(By.name("airbags"));
            if(!airbag.isSelected()) {
                airbag.click();
            }
        } else {
            fail("Airbag Checkbox does not exist");
        }
    }



    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}

