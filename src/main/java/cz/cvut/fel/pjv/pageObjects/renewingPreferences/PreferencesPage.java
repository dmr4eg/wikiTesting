package cz.cvut.fel.pjv.pageObjects.renewingPreferences;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PreferencesPage {
    private WebDriver driver;

    @FindBy(how = How.CSS, using = "#mw-input-wpecho-subscriptions > table > tbody > tr:nth-child(3) > td:nth-child(3)")
    private WebElement checkboxButton;
    @FindBy(how = How.CSS, using = "#prefcontrol > button")
    private WebElement saveButton;

    public PreferencesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public PreferencesPage clickChechbox(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(checkboxButton));
        checkboxButton.click();
        return this;
    }

    public PreferencesPage saveChanges(){
        saveButton.click();
        return this;
    }
}
