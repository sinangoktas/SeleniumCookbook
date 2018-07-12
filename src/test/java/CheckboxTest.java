import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class CheckboxTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "utilities/geckodriver");
        driver = new FirefoxDriver();
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
    }

    @Test
    public void testCheckbox() {
        WebElement singleCheckbox = driver.findElement(By.id("isAgeSelected"));
        if(!singleCheckbox.isSelected())
            singleCheckbox.click();

        assertTrue(singleCheckbox.isSelected());
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
