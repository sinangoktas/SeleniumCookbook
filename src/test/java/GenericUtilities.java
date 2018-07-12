import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class GenericUtilities {

    private WebDriver driver;

    public GenericUtilities(WebDriver driver ) {
        this.driver = driver;
    }

    public void safeJavaScriptClick(WebElement element) throws Exception {
        try {
            if (element.isEnabled() && element.isDisplayed()) {
                System.out.println("Clicking on element with using java script click");

                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            } else {
                System.out.println("Unable to click on element");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document "+ e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element was not found in DOM "+ e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Unable to click on element "+ e.getStackTrace());
        }
    }


    public void dragAndDrop(WebElement sourceElement, WebElement destinationElement) {
        try {
            if (sourceElement.isDisplayed() && destinationElement.isDisplayed()) {
                Actions action = new Actions(driver);
                action.dragAndDrop(sourceElement, destinationElement).build().perform();
            } else {
                System.out.println("Element was not displayed to drag");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Element with " + sourceElement + "or" + destinationElement + "is not attached to the page document "
                    + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element " + sourceElement + "or" + destinationElement + " was not found in DOM "+ e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Error occurred while performing drag and drop operation "+ e.getStackTrace());
        }
    }

    public void scrollToBottom(WebDriver driver) {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollTo(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);
    }

}



