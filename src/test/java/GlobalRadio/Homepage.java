package GlobalRadio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Homepage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = ".now_playing_card")
    public WebElement NOW_PLAYING_CARD;

    @FindBy(css = ".track__track-info > div:nth-child(3)")
    public WebElement NOW_PLAYING_ARTIST;

    public Homepage(WebDriver driver, int timeoutInSecs) {
        this.wait = new WebDriverWait(driver, timeoutInSecs);
        PageFactory.initElements(driver, this);
    }

    public List<String> getRecentlyPlayedArtists() {
        List<String> recentlyPlayedArtists = new ArrayList<String>();
        List<WebElement> recentlyPlayedArtistList = driver.findElements(
                By.cssSelector("article.track.recently_played_track.no_link > div.artist"));

        for (WebElement item : recentlyPlayedArtistList) {
            recentlyPlayedArtists.add(item.getText());
        }
        return recentlyPlayedArtists;
    }


}
