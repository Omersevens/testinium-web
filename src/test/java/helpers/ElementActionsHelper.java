package helpers;

import base.DriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementActionsHelper {

    private WebDriverWait wait;
    private WaitHelper waitHelper = new WaitHelper();

    @SneakyThrows
    public void click(By by) throws Exception {
        waitHelper.waitUntilElementVisible(by);
        waitHelper.waitUntilElementClickable(by);
        DriverManager.getDriver().findElement(by).click();
    }


    @SneakyThrows
    public void enterText(By by, String input) throws Exception {
        waitHelper.waitUntilElementVisible(by);
        click(by);
        DriverManager.getDriver().findElement(by).sendKeys(input);
    }


    @SneakyThrows
    public String getText(By by) throws Exception {
        waitHelper.waitAndFindElement(by);
        return DriverManager.getDriver().findElement(by).getText();
    }


    public void selectOption(By by, String option) {
    }
}
