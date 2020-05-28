package config;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static config.Settings.*;

public class ApplicationConfig {

    private static WebDriver driver;

    public static void invokeBrowser() {

        try {

            System.setProperty(CHROME_DRIVER_KEY, CHROME_DRIVER_PATH);
            //setUpSeleniumGrid();
            driver = new ChromeDriver();

            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

            driver.get(WESTERNACHER_TEST_URL);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public static WebDriver getDriver(){
        return driver;
    }
}