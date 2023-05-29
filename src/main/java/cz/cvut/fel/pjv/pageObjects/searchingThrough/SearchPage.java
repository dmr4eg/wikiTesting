package cz.cvut.fel.pjv.pageObjects.searchingThrough;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
    private WebDriver driver;
    @FindBy(how = How.CSS, using = "#searchform > div > div > div.cdx-text-input.cdx-text-input--has-start-icon.cdx-text-input--status-default.cdx-search-input__text-input > input")
    private WebElement textField;
    @FindBy(how = How.CSS, using = "#searchform > div > button")
    private WebElement searchButton;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public SearchPage typeSomething(String something) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(textField));
        textField.sendKeys(something);
        return this;
    }

    public SearchPage clickSearch() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        searchButton.click();
        return this;
    }

}
