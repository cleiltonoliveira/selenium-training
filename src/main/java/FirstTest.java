import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FirstTest {

    private ChromeDriver driver;

    @BeforeAll
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "/home/cleilton/IdeaProjects/selenium/Selenium/selenium_driver/chromedriver");
        System.setProperty("webdriver.chrome.whitelistedIps", "");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @AfterAll
    public void closeWindowAfterTest() {
        driver.quit();
    }

    @Test
    public void firstTest() {
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.name("email"));
    }

    @Test
    public void testWithXpath() {
        WebElement signin = driver.findElement(By.xpath
                ("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("passwd"));
        WebElement loginbt = driver.findElement(By.id("SubmitLogin"));
    }

    @Test
    public void testActions() {
        WebElement signin = driver.findElement(By.xpath
                ("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("passwd"));
        WebElement loginbt = driver.findElement(By.id("SubmitLogin"));

        email.sendKeys("tstautotreinamento1234@gmail.com");
    }

    @Test
    public void testSignIn() {

        WebElement signin = driver.findElement(By.xpath
                ("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
        signin.click();

        assertTrue(driver.getCurrentUrl().contains("index.php?controller=authentication&back=my-account"));

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("passwd"));
        WebElement loginbt = driver.findElement(By.id("SubmitLogin"));

        email.sendKeys("email@ifba.com.br");
        password.sendKeys("12345");
        loginbt.click();

        assertTrue(driver.getCurrentUrl().contains("/index.php?controller=my-account"));
    }

    @Test
    public void testLoginWithInvalidUser() {
        WebElement signin = driver.findElement(By.xpath
                ("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
        signin.click();

        assertTrue(driver.getCurrentUrl().contains("index.php?controller=authentication&back=my-account"));

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("passwd"));
        WebElement loginbt = driver.findElement(By.id("SubmitLogin"));

        email.sendKeys("wrongUser");
        password.sendKeys("12345");
        loginbt.click();

        WebElement errorLabel = driver.findElement(By.xpath("//*[@id='center_column']/div[1]/ol/li"));
        assertTrue(errorLabel.isDisplayed());
        assertTrue(driver.getCurrentUrl().contains("index.php?controller=authentication"));
    }

    @Test
    public void testLoginWithInvalidPass() {
        WebElement signin = driver.findElement(By.xpath
                ("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
        signin.click();

        assertTrue(driver.getCurrentUrl().contains("index.php?controller=authentication&back=my-account"));

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("passwd"));
        WebElement loginbt = driver.findElement(By.id("SubmitLogin"));

        email.sendKeys("email@ifba.com.br");
        password.sendKeys("wrongPass");
        loginbt.click();

        WebElement errorLabel = driver.findElement(By.xpath("//*[@id='center_column']/div[1]/ol/li"));
        assertTrue(errorLabel.isDisplayed());
        assertTrue(driver.getCurrentUrl().contains("index.php?controller=authentication"));
    }

    @Test
    public void testForgotPass() {
        WebElement signin = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
        signin.click();

        assertTrue(driver.getCurrentUrl().contains("index.php?controller=authentication&back=my-account"));

        WebElement forgotPass = driver.findElement(By.xpath("//*[@id=\"login_form\"]/div/p[1]/a"));
        forgotPass.click();
        assertTrue(driver.getCurrentUrl().contains("index.php?controller=password"));
    }
}
