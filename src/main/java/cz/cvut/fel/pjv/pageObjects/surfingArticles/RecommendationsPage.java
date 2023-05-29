package cz.cvut.fel.pjv.pageObjects.surfingArticles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RecommendationsPage {
    private WebDriver driver;
    @FindBy(how = How.CSS, using = "#n-featuredcontent")
    private WebElement contentsButton;

    public RecommendationsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ContentsPage tryContents() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(contentsButton));
        contentsButton.click();
        return new ContentsPage(driver);
    }
}
