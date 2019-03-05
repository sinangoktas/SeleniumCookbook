import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CookiesTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "utilities/linux/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://flipkart.com/");

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testCookies() {
        Cookie c1 = new Cookie("cookie1", "123456789");
        Cookie c2 = new Cookie("cookie2", "abcdefghi");
        Cookie c3 = new Cookie("cookie3", "0987asdfg");
        driver.manage().addCookie(c1);
        driver.manage().addCookie(c2);
        driver.manage().addCookie(c3);

        Set<Cookie> cookiesList =  driver.manage().getCookies();
        for(Cookie cookie : cookiesList) {
            System.out.println(cookie);
        }

        // useful methods
        //driver.manage().getCookieNamed("cookie2");
        //driver.manage().deleteCookieNamed("cookie1");
        //driver.manage().deleteCookie(c3);
        //driver.manage().deleteAllCookies();


        //assertEquals(null, c3);
        //assertEquals("abcdefghi", c2.getValue());

    }

}
