package cz.cvut.fel.pjv.pageObjects.lastChangesUpdate;

import cz.cvut.fel.pjv.pageObjects.renewingPreferences.PreferencesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LastChangesPage {
    private WebDriver driver;
    @FindBy(how = How.CSS, using = "#ooui-php-409")
    private WebElement lastChangesButton;

    @FindBy(how = How.CSS, using = "#ooui-php-166")
    private WebElement daysField;

    @FindBy(how = How.CSS, using = "#ooui-php-167")
    private WebElement historyField;

    @FindBy(how = How.CSS, using = "#prefcontrol > button")
    private WebElement saveButton;

    public LastChangesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public LastChangesPage clickLastChangesButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(lastChangesButton));
        lastChangesButton.click();
        return this;
    }
    public LastChangesPage fillDaysField(int days){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(daysField));
        daysField.sendKeys(String.valueOf(days));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public LastChangesPage fillHistoryField(int history){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(historyField));
        historyField.sendKeys(String.valueOf(history));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public LastChangesPage saveChanges(){
        saveButton.click();
        return this;
    }
}
