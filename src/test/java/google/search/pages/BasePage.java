package google.search.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait webDriverWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 15);
    }

    public void waitVisibility(By elementBy) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

}