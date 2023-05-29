package cz.cvut.fel.pjv.pageObjects.loggingIn;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;
    @FindBy(how = How.CSS, using = "#pt-login-2")
    private WebElement loginButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public MainPage openEShop(){
        driver.get("https://cs.wikipedia.org/wiki/Hlavn%C3%AD_strana");
        return this;
    }

    public AccountLoginPage clickLogin(){
        loginButton.click();
        return new AccountLoginPage(driver);
    }
}
