package google.search.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

    public boolean isElementPresent(By locatorKey) {
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean checkIfElementIsVisible(By element) {
        waitVisibility(element);
        return driver.findElement(element).isDisplayed();
    }

}