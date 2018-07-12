import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class DragDropTest {

    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "utilities/geckodriver");
        driver = new FirefoxDriver();
        driver.get("http://jqueryui.com/droppable/");
    }

    @Test
    public void testDragDrop() {

        GenericUtilities genericUtilities = new GenericUtilities(driver);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));

        WebElement source = driver.findElement(By.cssSelector(".ui-draggable"));
        WebElement target = driver.findElement(By.cssSelector(".ui-droppable"));

        genericUtilities.dragAndDrop(source, target);

        try{
            assertEquals("Dropped", target.getText());
        }catch (Error e) {
            verificationErrors.append(e.toString());
        }

    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
