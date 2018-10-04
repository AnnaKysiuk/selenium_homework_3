package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {

    protected static WebDriver driver;

    @BeforeClass
    public static void start() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions().setHeadless(true);
        driver = new ChromeDriver(opt);
    }

    @AfterClass
    public static void stop() {
        driver.quit();
    }

}
