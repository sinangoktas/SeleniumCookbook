import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URL;

public class RemoteWebDriverScreenShot {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        driver = new RemoteWebDriver(new URL("http://192.168. ..... hub url"),
                cap.ipad());
        driver.get("http://www.google.co.uk");
    }

    @Test
    public void testRemoteDriverScreenShot() throws Exception {
        driver = new Augmenter().augment(driver);
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("target/screenshot.png"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
