package wikipediaTests;

import org.testng.annotations.Test;
import pages.HomePage;

public class WikipediaSearch extends BaseTest {

    @Test
    public void searchTest_TestAutomationQuery() {
        HomePage homePage = new HomePage(driver);
        homePage.getHomePage()
                .goToEnglishVersionPage()
                .searchPhrase("test automation");
    }


}
