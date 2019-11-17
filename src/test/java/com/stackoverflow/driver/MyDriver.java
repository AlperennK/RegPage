package com.stackoverflow.driver;
import com.stackoverflow.configuration.AppSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MyDriver {
    public static WebDriver driver;

    //What is this
    private MyDriver(){
    }
    public static WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "src/test/resource/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(AppSettings.Instance.BaseUrl);
        return driver;
    }
}
