package cz.cvut.fel.pjv.pageObjects;

import cz.cvut.fel.pjv.pageObjects.lastChangesUpdate.AccountManager2;
import cz.cvut.fel.pjv.pageObjects.loggingIn.MainPage;
import cz.cvut.fel.pjv.pageObjects.renewingPreferences.AccountManager;
import cz.cvut.fel.pjv.pageObjects.searchingThrough.SearchPage;
import cz.cvut.fel.pjv.pageObjects.surfingArticles.RecommendationsPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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

    @Test
    public void registrationTest() {
        new MainPage(driver)
                .openEShop()
                .clickLogin()
                .fillName("Seleniumtestcvut")
                .fillPassword("hellotests")
                .checkRememberMe()
                .clickContinue();
    }

    @Test
    public void searchContentsTest() {
        registrationTest();
        new RecommendationsPage(driver)
                .tryContents()
                .clickContent()
                .addToFavourites()
                .reloadPage();
    }

    @Test
    public void changeNotificTest(){
        registrationTest();
        new AccountManager(driver)
                .openNotif()
                .openPreferences()
                .openTransition()
                .clickChechbox()
                .saveChanges();
    }

    @Test
    public void lastChangesUpdateTest(){
        registrationTest();
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
        registrationTest();
        new SearchPage(driver)
                .typeSomething("quality assurance")
                .clickSearch();
    }


}
