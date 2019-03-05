import com.opencsv.CSVReader;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CsvTestData {

    private static WebDriver driver;

    private String height;
    private String weight;
    private String bmi;
    private String bmiCategory;

    @Parameterized.Parameters
    public static List<String[]> testDta() throws Exception {
        return getTestData("./src/test/resources/data.csv");
    }

    public CsvTestData(String height, String weight, String bmi,
                       String bmiCategory) {
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.bmiCategory = bmiCategory;
    }

    public static List<String[]> getTestData(String filename)
            throws IOException {
        CSVReader reader = new CSVReader(new FileReader(filename));
        List<String[]> myEntries = reader.readAll();
        reader.close();
        return myEntries;
    }

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "utilities/linux/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://cookbook.seleniumacademy.com/bmicalculator.html");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        // Close the browser
        driver.quit();
    }

    @Test
    public void testBMICalculator() throws Exception {
        WebElement heightField = driver.findElement(By.name("heightCMS"));
        heightField.clear();
        heightField.sendKeys(height);

        WebElement weightField = driver.findElement(By.name("weightKg"));
        weightField.clear();
        weightField.sendKeys(weight);

        WebElement calculateButton = driver.findElement(By.id("Calculate"));
        calculateButton.click();

        WebElement bmiCategoryLabel = driver.findElement(By
                .name("bmi_category"));
        assertEquals(bmiCategory, bmiCategoryLabel.getAttribute("value"));

        WebElement bmiLabel = driver.findElement(By.name("bmi"));
        assertEquals(bmi, bmiLabel.getAttribute("value"));


    }

}
