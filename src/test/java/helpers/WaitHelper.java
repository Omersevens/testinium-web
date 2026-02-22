package helpers;

import base.DriverManager;
import lombok.SneakyThrows;
import objectFinder.FindHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static hooks.Hooks.commonProperties;

public class WaitHelper {
    private WebDriverWait wait;
    long pollingEveryValue;
    private int waitTime = Integer.valueOf(commonProperties.getProperty("WAIT"));

    private FindHelper findHelper = new FindHelper();

    @SneakyThrows
    public void waitAndFindElement(By by) throws Exception {
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    @SneakyThrows
    public void waitForAngularLoad() throws Exception {
        long startTime = System.currentTimeMillis();
        long estimatedTime;
        try {
            Thread.sleep(250);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        boolean stillRunningAngular = (Boolean) executor
                .executeScript("return (window.angular != undefined) && (angular.element(document.body).injector() != undefined) &&"
                        + " (angular.element(document.body).injector().get('$http').pendingRequests.length === 0)");

        try {
            while (!stillRunningAngular) {

                stillRunningAngular = (Boolean) executor.executeScript(
                        "return (window.angular != undefined) && (angular.element(document.body).injector() != undefined) &&"
                                + " (angular.element(document.body).injector().get('$http').pendingRequests.length === 0)");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }

                estimatedTime = System.currentTimeMillis() - startTime;

                if (estimatedTime >= 8000) {
                    stillRunningAngular = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @SneakyThrows
    public void waitUntilElementVisible(By by, long time) throws Exception {
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    @SneakyThrows
    public void waitUntilElementVisible(By by) throws Exception {
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    @SneakyThrows
    public void waitUntilElementClickable(By by) throws Exception {
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

}
