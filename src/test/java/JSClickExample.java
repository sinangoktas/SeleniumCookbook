import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSClickExample {

    private WebDriver driver;

    @Test
    public void testClickJS() throws Exception {
        System.setProperty("webdriver.chrome.driver", "utilities/linux/chromedriver");
        driver = new ChromeDriver();
        GenericUtilities genericUtilities = new GenericUtilities(driver);
        driver.get("http://amazon.co.uk");

        WebElement searchTextBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchTextBox.sendKeys("Laptops");
        WebElement goButton = driver.findElement(By.cssSelector("input[value=Go]"));
        genericUtilities.safeJavaScriptClick(goButton);

        driver.close();

    }


}
