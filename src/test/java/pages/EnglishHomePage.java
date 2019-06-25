package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnglishHomePage extends BasePage{

    By searchBox = By.cssSelector("#searchInput");

    public EnglishHomePage(WebDriver driver) {
        super(driver);
    }

    public ResultPage searchPhrase(String phrase)  {
        waitVisibility(searchBox);
        driver.findElement(searchBox).sendKeys(phrase);
        return new ResultPage(driver);
    }
}
