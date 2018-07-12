import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class TableExample {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "utilities/geckodriver");
        driver = new FirefoxDriver();
        driver.get("http://www.seleniumeasy.com/test/table-search-filter-demo.html");

    }

    @Test
    public void testWeTable() {
        WebElement simpleTable = driver.findElement(By.id("task-table"));

        List<WebElement> rows = simpleTable.findElements(By.tagName("tr"));
        assertEquals(8, rows.size());

        for(WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                System.out.println(col.getText() + "\t");
            }
        }
    }

    @After
    public void tearDown() {
        driver.close();
    }


}
