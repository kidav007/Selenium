package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium {
    public static void main(String[] args){
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chrome Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        WebDriver driver = new RemoteWebDriver("http://localhost:9515", DesiredCapabilities.chrome());
//        driver.get("http://www.google.com");
//        ChromeDriver driver=new ChromeDriver();
        driver.get("http://demo.guru99.com/");
        WebElement element=driver.findElement(By.xpath("//input[@name='emailid']"));
        element.sendKeys("abc@gmail.com");

        WebElement button=driver.findElement(By.xpath("//input[@name='btnLogin']"));
        button.click();
        driver.close();
    }
}

