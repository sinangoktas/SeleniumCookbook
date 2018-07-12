import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class RadioButtonTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "utilities/geckodriver");
        driver = new FirefoxDriver();
        driver.get("http://www.seleniumeasy.com/test/basic-radiobutton-demo.html");

    }

    @Test
    public void testRadioButton() {

        WebElement maleRadio = driver.findElement(By.xpath("//input[@value='Male']"));
        if(!maleRadio.isSelected())
            maleRadio.click();

        assertTrue(maleRadio.isSelected());

        List<WebElement> ageGroup = driver.findElements(By.name("ageGroup"));
        for(WebElement element : ageGroup)
            if(element.getAttribute("value").equals("0 - 5")) {
            if(!element.isSelected())
                element.click();
            assertTrue(element.isSelected());
            break;
            }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
