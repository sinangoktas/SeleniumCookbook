import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class WebDriverWithJava8 {

    private WebDriver driver;


    @Test
    public void  java8Example() {

        List list = new ArrayList();
        list.add("Selenium");
        list.add("Cucumber");
        list.add("SoapUI");

        for(Object item:list){

            System.out.println(item);

        }

        // above loop with Java8

        list.forEach(item -> System.out.println(item));


        // Another example

        Select select = new Select(driver.findElement(By.id("xyz")));
        select.getOptions().stream().anyMatch(item -> item.getText().equals(""));
    }

}
