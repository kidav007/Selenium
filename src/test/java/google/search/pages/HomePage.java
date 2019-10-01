package google.search.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private static final By SEARCH_BOX = By.cssSelector("input.gLFyf");
    private static final By KEYBOARD = By.cssSelector("span.MiYK0e");
    private static final By MICROPHONE = By.cssSelector("span.hb2Smf");
    private static final By GOOGLE_LOGO = By.cssSelector("#hplogo");

    private WebElement element;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage getHomePage() {
        driver.get("https://www.google.com/");
        return this;
    }

    public boolean isSearchBoxVisible() {
        return checkIfElementIsVisible(SEARCH_BOX);
    }

    private boolean checkIfElementIsVisible(By element) {
        waitVisibility(element);
        return driver.findElement(element).isDisplayed();
    }

    public boolean isKeyboardVisible() {
        return checkIfElementIsVisible(KEYBOARD);
    }

    public boolean isMicrophoneVisible() {
        return checkIfElementIsVisible(MICROPHONE);
    }

    public boolean isLogoVisible() {
        return checkIfElementIsVisible(GOOGLE_LOGO);
    }

    public String getPhraseFromLogo() {
        return driver.findElement(GOOGLE_LOGO).getAttribute("alt");
    }

    public void writeText(String textToType) {
        element = driver.findElement(SEARCH_BOX);
        element.sendKeys(textToType);
    }

    public ResultPage pressEnterKey() {
        element.sendKeys(Keys.ENTER);
        return new ResultPage(driver);
    }
}
