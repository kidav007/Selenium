package google.search.tests;

import google.search.pages.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeClass
    public void beforeTest() {
        logger.info("Step - Open Chrome browser");
        homePage = new HomePage(driver);
        logger.info("Step - Open url https://www.google.com/");
        homePage.getHomePage();
    }

    @Test
    public void checkIfGoogleLogoIsAvailable() {
        logger.info("Step - Check if a logo is visible");
        assertThat("The logo is not visible", homePage.isLogoVisible());
        logger.info("Step - Check if the logo is Google");
        assertThat("The logo is not Google", homePage.getPhraseFromLogo(), equalTo("Google"));
    }

    @Test
    public void checkIfSearchBoxVisible() {
        logger.info("Step - Check if the search box visible");
        assertThat("The search box is not visible", homePage.isSearchBoxVisible());
    }

    @Test
    public void checkIfKeyboardIsAvailable() {
        logger.info("Step - Check if a keyboard is visible in the search box");
        assertThat("The keyboard is not visible", homePage.isKeyboardVisible());
    }

    @Test
    public void checkIfMicrophoneIsAvailable() {
        logger.info("Step - Check if a microphone is visible in the search box");
        assertThat("The microphone is not visible", homePage.isMicrophoneVisible());
    }
}
