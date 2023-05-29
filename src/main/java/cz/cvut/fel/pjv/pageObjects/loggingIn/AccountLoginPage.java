package cz.cvut.fel.pjv.pageObjects.loggingIn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountLoginPage {
    private WebDriver driver;

    @FindBy(how = How.CSS, using = "#wpName1")
    private WebElement nameInput;
    @FindBy(how = How.CSS, using = "#wpPassword1")
    private WebElement passwordInput;
    @FindBy(how = How.CSS, using = "#wpLoginAttempt")
    private WebElement continueButton;
    @FindBy(how = How.CSS, using = "#wpRemember")
    private WebElement rememberMeCheckbox;

    public AccountLoginPage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public AccountLoginPage fillName(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(nameInput));
        nameInput.sendKeys(email);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
    public AccountLoginPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public AccountLoginPage checkRememberMe() {
        rememberMeCheckbox.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public AccountLoginPage clickContinue() {
        continueButton.click();
        return this;
    }

    public MainPage returnMainPage() {
        driver.get("https://cs.wikipedia.org/wiki/Hlavn%C3%AD_strana");
        return new MainPage(driver);
    }
}
