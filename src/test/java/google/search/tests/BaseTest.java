package google.search.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.logging.Logger;

public class BaseTest {

    public WebDriver driver;
    public final Logger logger = Logger.getLogger(getClass().getName());

    @BeforeClass
    public void setup() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("-incognito");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
