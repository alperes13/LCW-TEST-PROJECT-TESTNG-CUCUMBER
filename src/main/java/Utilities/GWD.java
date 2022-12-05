package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>();

    public static WebDriverWait wait;

    public static WebDriver getDriver() {

        if (threadDriver.get() == null) {

            Logger.getLogger("").setLevel(Level.SEVERE);
            System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");

            if(threadBrowserName.get() == null){
                threadBrowserName.set("chrome");
            }

            String browserName = threadBrowserName.get();

            switch (browserName) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    threadDriver.set(new ChromeDriver());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    threadDriver.set(new FirefoxDriver());
                    break;
            }

        }
        wait = new WebDriverWait(threadDriver.get(), Duration.ofSeconds(15));
        return threadDriver.get();

    }


    public static void quitDriver() {

        if (threadDriver.get() != null) {

            threadDriver.get().quit();

            WebDriver driver = threadDriver.get();

            driver = null;

            threadDriver.set(driver);

        }



    }


}

