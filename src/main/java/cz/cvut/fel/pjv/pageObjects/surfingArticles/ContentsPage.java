package cz.cvut.fel.pjv.pageObjects.surfingArticles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContentsPage {
    private WebDriver driver;
    @FindBy(how = How.CSS, using = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > main:nth-child(1) > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > dl:nth-child(16) > dd:nth-child(1) > a:nth-child(9)")
    private WebElement contentButton;

    public ContentsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ArticlePage clickContent(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(contentButton));
        contentButton.click();
        return new ArticlePage(driver);
    }
}
