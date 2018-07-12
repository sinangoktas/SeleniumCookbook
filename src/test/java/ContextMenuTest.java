import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class ContextMenuTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "utilities/geckodriver");
        driver = new FirefoxDriver();
        driver.get("http://bit.ly/1CAV05I");
    }

    @Test
    public void testContextMenu() {
        WebElement rightClickMeElement =
                driver.findElement(By.cssSelector("span.context-menu-one.btn.btn-neutral"));
        WebElement editMenuItem =
                driver.findElement(By.cssSelector("li.context-menu-item.context-menu-icon.context-menu-icon-edit"));

        Actions builder = new Actions(driver);
        builder.contextClick(rightClickMeElement)
                .moveToElement(editMenuItem)
                .click()
                .perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("clicked: edit", alert.getText());
        alert.dismiss();
    }

    @Test
    public void testContextMenuWithKeys() {
        WebElement clickMeElement =
                driver.findElement(By.cssSelector("span.context-menu-one.btn.btn-neutral"));

        Actions builder = new Actions(driver);
        builder.contextClick(clickMeElement)
                .sendKeys(Keys.chord(Keys.ALT, "e"))
                .perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("clicked: edit", alert.getText());
        alert.dismiss();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
