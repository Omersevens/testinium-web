package helpers;

import base.DriverManager;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class AssertHelper {
    WaitHelper waitHelper = new WaitHelper();


    @SneakyThrows
    public void containsElementText(String existingText, String expectedtext) {
        assertTrue(existingText + " doesn't contains " + expectedtext + " value!", existingText.contains(expectedtext));
    }


    @SneakyThrows
    public void checkElementVisible(By by) {
        Assertions.assertTrue(isElementVisible(by), by.toString() + " elementi görüntülenemedi.");
    }


    @SneakyThrows
    public boolean isElementVisible(By by) {

        try {
            waitHelper.waitUntilElementVisible(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @SneakyThrows
    public boolean isElementVisible(By by, long timeout) {

        try {
            waitHelper.waitUntilElementVisible(by, timeout);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
