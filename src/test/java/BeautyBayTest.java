import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class BeautyBayTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "utilities/linux/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.beautybay.com/l/makeup/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void testPriceSlider() {

        WebElement slider1 = driver.findElement(By.xpath("//div[@id='slider-range']//span[1]"));
        assertTrue("Left slide handle is not displayed", slider1.isDisplayed());
        WebElement slider2 = driver.findElement(By.xpath("//div[@id='slider-range']//span[2]"));
        assertTrue("Right slide handle is not displayed", slider2.isDisplayed());
        WebElement slideBar = driver.findElement(By.id("slider-range"));
        assertTrue("Slide bar is not displayed", slideBar.isDisplayed());

        Actions moveAndSlide = new Actions(driver);
        moveAndSlide.moveToElement(slideBar)
                .dragAndDropBy(slider1, 30, 0)
                .dragAndDropBy(slider2, -30, 0)
                .build().perform();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /*
    There should be a way to parse the filtered prices on the page and verify if all the prices fall into
    specified range.

     */
}
