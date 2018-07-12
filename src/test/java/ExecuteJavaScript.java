import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class ExecuteJavaScript {

    private WebDriver driver;

    @Test
    public void testJavaScriptCalls() throws Exception {
        System.setProperty("webdriver.chrome.driver", "utilities/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://google.co.uk");

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String title = (String) js.executeScript("return document.title");
            assertEquals("Google", title);

            long links = (Long) js.executeScript("var links = document.getElementsByTagName('A'); " +
                    "return links.length");
            assertEquals(45, links);
        } finally {
            driver.quit();
        }

    }
}
