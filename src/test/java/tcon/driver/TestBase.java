package tcon.driver;

import com.google.common.base.Strings;
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

import static com.google.common.base.Strings.isNullOrEmpty;

public class TestBase {

    // Get a new WebDriver Instance.
    // Refer http://getgauge.io/documentation/user/current/managing_environments/README.html
    public static WebDriver getDriver() {

        String browser = System.getProperty("browser");
        String hub = System.getProperty("hub");
        //String browser = System.getenv("BROWSER");
        System.out.println("FFFFFFFFFFFFFFFFFff browser: " + browser);
        System.out.println("FFFFFFFFFFFFFFFFFff hub: " + hub);

        if ("IE".equals(browser)) {
            throw new RuntimeException("IE is not available");
        }
        if ("FIREFOX".equals(browser)) {
            throw new RuntimeException("FIREFOX is not available");
        }

        if (isNullOrEmpty(hub)){
            hub = "http://163.172.177.145:4444/wd/hub";
        }

   /*     ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");*/

        DesiredCapabilities dr=DesiredCapabilities.chrome();
        dr.setBrowserName("chrome");
       /* DesiredCapabilities dr=DesiredCapabilities.firefox();
        dr.setBrowserName("firefox");*/
        //dr.setPlatform(Platform.WINDOWS);
        dr.setPlatform(Platform.LINUX);
        //dr.setVersion("2.42");
        //dr.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        RemoteWebDriver driver = null;



        try {
            //driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), dr);
            //driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dr);
            //driver = new RemoteWebDriver(new URL("http://51.15.235.92:4444/wd/hub"), dr);
            //driver = new RemoteWebDriver(new URL("http://163.172.177.145:4444/wd/hub"), dr);
            driver = new RemoteWebDriver(new URL(hub), dr);
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
