package tcon.driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {

    // Get a new WebDriver Instance.
    // Refer http://getgauge.io/documentation/user/current/managing_environments/README.html
    public static WebDriver getDriver() {

        String browser = System.getProperty("BROWSER");
        //String browser = System.getenv("BROWSER");
        System.out.println("FFFFFFFFFFFFFFFFFff" + browser);

        if ("IE".equals(browser)) {
            throw new RuntimeException("IE is not available");
        }
        if ("FIREFOX".equals(browser)) {
            throw new RuntimeException("FIREFOX is not available");
        }


        DesiredCapabilities dr=DesiredCapabilities.chrome();
        dr.setBrowserName("chrome");
        dr.setPlatform(Platform.WINDOWS);
        //dr.setPlatform(Platform.LINUX);

        RemoteWebDriver driver = null;

        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;

    }

    public static WebDriver newDriver() {
        System.setProperty("webdriver.chrome.driver", "C:/chrome-v2-33/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
        //WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);

        return driver;
    }


}
