package google.search.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultPage extends BasePage {

    private static final By RESULTS = By.cssSelector("span.st");
    private static final By RESULTS_HEADER = By.cssSelector("div.r > a");

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getListOfSearchedResult() {
        return driver.findElements(RESULTS);
    }

    public List<WebElement> getHeaderList() {
        return driver.findElements(RESULTS_HEADER);
    }
}
