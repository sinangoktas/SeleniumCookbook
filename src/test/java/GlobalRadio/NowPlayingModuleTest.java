package GlobalRadio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NowPlayingModuleTest extends TestBase {

    private WebDriver driver;
    private WebDriverWait wait;
    private int timeoutSecs = 10;
    private Homepage homepage;
    private String baseUrl = "http://capitalfm.com";


    @Before
    public void setUp() {
        driver = createDriver();
        driver.manage().timeouts().implicitlyWait(timeoutSecs, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, timeoutSecs);
        driver.get(baseUrl);

        homepage = new Homepage(driver, timeoutSecs);
    }

    @Test
    public void testCalvinHarrisIsPlayingOrHasRecentlyPlayed() {

        // verify that now_playing_card is loaded
        WebDriverWait wait = new WebDriverWait(driver, 10, 200);
        wait.until(ExpectedConditions.visibilityOf(homepage.NOW_PLAYING_CARD));
        assertTrue("Now Playing Card is not being displayed", homepage.NOW_PLAYING_CARD.isDisplayed());

        boolean found = false;

        try {
            // verify if Calvin Harris is playing now
            assertFalse("Calvin Harris is playing at the moment",
                    !homepage.NOW_PLAYING_ARTIST.getText().contains("Calvin Harris"));
        } finally {
            List<String> recentlyPlayeds = homepage.getRecentlyPlayedArtists();
            // verify the recently played artists
            for (String artist : recentlyPlayeds) {
                if (artist.contains("Calvin Harris")) {
                    found = true;
                    System.out.println("Calvin Harris has recently played");
                    break;
                }
            }

            if(!found)
                System.out.println("Calvin Harris has not recently played");
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}