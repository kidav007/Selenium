package google.search.tests;

import google.search.pages.HomePage;
import google.search.pages.ResultPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class SearchResultsTest extends BaseTest {

    private HomePage homePage;
    private ResultPage resultPage;

    private static final String SEARCH_PHRASE = "monachium";

    @BeforeClass
    public void beforeClass() {
        logger.info("Step - Open Chrome browser");
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void beforeTest() {
        logger.info("Step - Open url https://www.google.com/");
        homePage.getHomePage();
    }

    @Test
    public void checkIfResultsDisplayedAfterTypingAndAcceptingWord() {
        logger.info("Step - Type a text " + SEARCH_PHRASE);
        homePage.writeText(SEARCH_PHRASE);
        logger.info("Step - Press Enter");
        resultPage = homePage.pressEnterKey();
        logger.info("Step - Check if results displayed a searched word");
        List<WebElement> list = resultPage.getListOfSearchedResult();
        assertThat("Not each element on the list contains searched phrase",
                list.stream().allMatch(e -> e.getText().toLowerCase().contains(SEARCH_PHRASE.toLowerCase())));
    }

    @Test
    public void checkIfEachReasultHaveALink() {
        logger.info("Step - Type a text " + SEARCH_PHRASE);
        homePage.writeText(SEARCH_PHRASE);
        logger.info("Step - Press Enter");
        resultPage = homePage.pressEnterKey();
        logger.info("Step - Check if each search result have a link");
        List<WebElement> headerList = resultPage.getHeaderList();
        assertThat("Not each element on the list contains a link",
                headerList.stream().allMatch(e -> e.getAttribute("href").startsWith("http://")
                        || e.getAttribute("href").startsWith("https://")));
    }

    @Test
    public void checkIfNoResultsDisplayedAfterTypingIncorrectPhrase() {
        String incorrectPhrase = "yyyyyyaaaaa blalala";
        logger.info("Step - Type a text " + incorrectPhrase);
        homePage.writeText(incorrectPhrase);
        logger.info("Step - Press Enter");
        resultPage = homePage.pressEnterKey();
        logger.info("Step - Check if any results match a searched phrase");
        assertThat("Result list present", resultPage.checkIfResultsListNotVisible());
        assertThat("Message no results not available", resultPage.checkIfMessageNoResultsAvailable(incorrectPhrase));
    }
}
