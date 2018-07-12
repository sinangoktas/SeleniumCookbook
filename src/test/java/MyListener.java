import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.File;

public  class MyListener implements WebDriverEventListener {

    public void afterChangeValueOf(WebElement element, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void afterClickOn(WebElement element, WebDriver driver) {
        // TODO Auto-generated method stub
        System.out.println("Click actioned ..... ");

    }

    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        // TODO Auto-generated method stub
        System.out.println("Found the element .... ");

    }

    public void afterNavigateBack(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void afterNavigateForward(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    public void afterNavigateTo(String url, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void afterScript(String script, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void beforeSwitchToWindow(String s, WebDriver webDriver) {

    }

    public void afterSwitchToWindow(String s, WebDriver webDriver) {

    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver) {
        element.clear();
    }

    public void beforeClickOn(WebElement element, WebDriver driver) {
        // TODO Auto-generated method stub
        System.out.println("Clicking ..... ");

    }

    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        // TODO Auto-generated method stub
        System.out.println("Finding the element ..... ");

    }

    public void beforeNavigateBack(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void beforeNavigateForward(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void beforeAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertDismiss(WebDriver webDriver) {

    }

    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    public void beforeNavigateTo(String url, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void beforeScript(String script, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void onException(Throwable exception, WebDriver driver) {
        try {
            if (driver.getClass().getName().equals("org.openqa.selenium.remote.RemoteWebDriver")) {
                driver = new Augmenter().augment(driver);
            }
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("target/screenshots/error.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
