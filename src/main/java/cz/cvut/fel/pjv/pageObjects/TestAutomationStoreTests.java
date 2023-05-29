package cz.cvut.fel.pjv.pageObjects;

import cz.cvut.fel.pjv.pageObjects.lastChangesUpdate.AccountManager2;
import cz.cvut.fel.pjv.pageObjects.loggingIn.MainPage;
import cz.cvut.fel.pjv.pageObjects.renewingPreferences.AccountManager;
import cz.cvut.fel.pjv.pageObjects.searchingThrough.SearchPage;
import cz.cvut.fel.pjv.pageObjects.surfingArticles.RecommendationsPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestAutomationStoreTests {

// BEFORE LAUNCHING NEXT TEST, PLEASE PROPERLY CLOSE THE BROWSER WINDOW (or test will be implemented incorrectly)
    private static WebDriver driver;
    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
        driver = new SafariDriver();
        driver.manage().window().maximize();
    }
    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @ParameterizedTest
    @CsvSource({"Seleniumtestcvut, hellotests, true"})
    public void registrationTest(String name, String password, boolean isCorrect) {
        new MainPage(driver)
                .openEShop()
                .clickLogin()
                .fillName(name)
                .fillPassword(password)
                .checkRememberMe()
                .clickContinue();
    }

    @ParameterizedTest
    @CsvSource({"Selenium, lol", "Test, kek", "Automation, cheburek"})
    public void incorrectLoginTest(String name, String password) {
        new MainPage(driver)
                .openEShop()
                .clickLogin()
                .fillName(name)
                .fillPassword(password)
                .clickContinue();
    }

    @Test
    public void searchContentsTest() {
        registrationTest("Seleniumtestcvut", "hellotests", true);
        new RecommendationsPage(driver)
                .tryContents()
                .clickContent()
                .addToFavourites()
                .reloadPage();
    }

    @Test
    public void changeNotificTest(){
        registrationTest("Seleniumtestcvut", "hellotests", true);
        new AccountManager(driver)
                .openNotif()
                .openPreferences()
                .openTransition()
                .clickChechbox()
                .saveChanges();
    }

    @Test
    public void lastChangesUpdateTest(){
        registrationTest("Seleniumtestcvut", "hellotests", true);
        new AccountManager2(driver)
                .openNotif()
                .openPreferences()
                .openTransition()
                .clickLastChangesButton()
                .fillDaysField(14)
                .fillHistoryField(66)
                .saveChanges();
    }

    @Test
    public void relocatingBetweenSearchesTest(){
        registrationTest("Seleniumtestcvut", "hellotests", true);
        new SearchPage(driver)
                .typeSomething("quality assurance")
                .clickSearch();
    }
}
