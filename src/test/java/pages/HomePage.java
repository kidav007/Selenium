package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    By englishButton = By.cssSelector("#js-link-box-en > strong");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage getHomePage() {
        driver.get("https://www.wikipedia.org/");
        return this;
    }

    public EnglishHomePage goToEnglishVersionPage() {
        click(englishButton);
        return new EnglishHomePage(driver);
    }
}
