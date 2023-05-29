package cz.cvut.fel.pjv.pageObjects.lastChangesUpdate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountManager2 {
    private WebDriver driver;
    @FindBy(how = How.CSS, using = "#pt-notifications-alert")
    private WebElement notificButton;

    @FindBy(how = How.CSS, using = "#mw-content-text > div > div > div.mw-echo-ui-notificationsInboxWidget-main.mw-echo-ui-notificationsInboxWidget-cell > div.mw-echo-ui-notificationsInboxWidget-toolbarWrapper > div > div > div.mw-echo-ui-notificationsInboxWidget-main-toolbar-settings.mw-echo-ui-notificationsInboxWidget-cell > span > a")
    private WebElement preferencesButton;

    @FindBy(how = How.CSS, using = "#ooui-1")
    private WebElement transitionButton;
    public AccountManager2(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public AccountManager2 openNotif(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(notificButton));
        notificButton.click();
        return this;
    }

    public AccountManager2 openPreferences(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(preferencesButton));
        preferencesButton.click();
        return this;
    }

    public LastChangesPage openTransition(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(transitionButton));
        transitionButton.click();
        return new LastChangesPage(driver);
    }

}

