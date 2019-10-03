package google.search.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultPage extends BasePage {

    private static final By RESULTS = By.cssSelector("span.st");
    private static final By RESULTS_HEADER = By.cssSelector("div.r > a");
    private static final By NO_RESULTS = By.cssSelector("div.med > p:nth-child(1)");

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getListOfSearchedResult() {
        return driver.findElements(RESULTS);
    }

    public List<WebElement> getHeaderList() {
        return driver.findElements(RESULTS_HEADER);
    }

    public boolean checkIfResultsListNotVisible() {
        return !isElementPresent(RESULTS);
    }

    public boolean checkIfMessageNoResultsAvailable(String incorrectPhrase) {
        String message = "Podana fraza - " + incorrectPhrase + " - nie została odnaleziona.";
        return driver.findElement(NO_RESULTS).getText().equals(message);
    }
}
