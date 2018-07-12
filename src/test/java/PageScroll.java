import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class PageScroll {

    private WebDriver driver;
    GenericUtilities genericUtilities = new GenericUtilities(driver);
    String URL = "https://www.amazon.co.uk/";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "utilities/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @Test
    public void scrollingToBottomOfAPage() {
        driver.navigate().to(URL);
        genericUtilities.scrollToBottom(driver);

    }

    @Test()
    public void scrollingToElementOfAPage() {
        driver.navigate().to(URL+"gp/video/offers/ref=nav_swm_dvm_uk_pv_un_t_006");
        WebElement element = driver.findElement(By.linkText("Conditions of Use & Sale"));
        genericUtilities.scrollTo(driver, element);
    }

    @Test()
    public void scrollingByCoordinatesOfAPage() {
        driver.navigate().to(URL+"gp/deals/ref=nav_cs_gb");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
}
