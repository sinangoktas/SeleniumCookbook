import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JSClickExample {

    private WebDriver driver;

    @Test
    public void testClickJS() throws Exception {
        System.setProperty("webdriver.gecko.driver", "utilities/geckodriver");
        driver = new FirefoxDriver();
        GenericUtilities genericUtilities = new GenericUtilities(driver);
        driver.get("http://amazon.co.uk");
        WebElement searchTextBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchTextBox.sendKeys("Laptops");
        WebElement goButton = driver.findElement(By.cssSelector("input[value=Go]"));
        genericUtilities.safeJavaScriptClick(goButton);
        driver.close();

    }


}
