package cz.cvut.fel.pjv.pageObjects.surfingArticles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ArticlePage {
    private WebDriver driver;

    @FindBy(how = How.CSS, using = "#ca-watch")
    private WebElement favouritesButton;
    public ArticlePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ArticlePage addToFavourites() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(favouritesButton));
        favouritesButton.click();
        return this;
    }

    public ArticlePage reloadPage() {
        driver.navigate().refresh();
        return this;
    }
}
