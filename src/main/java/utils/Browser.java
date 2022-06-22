package utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
    private static ChromeDriver driver;

    public static ChromeDriver getCurrentDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "/home/cleilton/IdeaProjects/selenium/Selenium/selenium_driver/chromedriver");
            System.setProperty("webdriver.chrome.whitelistedIps", "");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
            driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        }
        return driver;
    }
}