package tcon;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tcon.driver.TestBase;

import java.net.MalformedURLException;

public class SeleniumTest {
    @Test
    public void runTest() throws MalformedURLException {

        String fileName = System.getProperty("driverName");
        System.out.println(fileName+"----------------");

        WebDriver driver;

        driver = TestBase.getDriver();

        //driver = TestBase.newDriver();

        //driver = newCloudDriverFromSauceLab();

        //driver = newCloudDriver();

        //driver = newCloudDriver2();

        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        //element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        //element.submit();

        // Check the title of the page
        System.out.println("AAPage title is: " + driver.getTitle());


        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
       /* (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });*/

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());

        Assertions.assertThat(driver.getTitle()).isEqualTo("Google");

        //Close the browser
        driver.quit();
    }
}