package helpers;

import base.DriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class KeyboardHelper {
    @SneakyThrows
    public static void keybordESC() throws Exception {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.sendKeys(Keys.chord(Keys.chord(Keys.ESCAPE))).build().perform();
    }

    @SneakyThrows
    public static void keybordTAB() throws Exception {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.sendKeys(Keys.chord(Keys.chord(Keys.TAB))).build().perform();
    }

    @SneakyThrows
    public static void keybordEnter() throws Exception {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.sendKeys(Keys.chord(Keys.chord(Keys.ENTER))).build().perform();
    }

    @SneakyThrows
    public static void keybordCtrlA() throws Exception {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
    }

    @SneakyThrows
    public static void keybordDelete() throws Exception {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.sendKeys(Keys.chord(Keys.chord(Keys.DELETE))).build().perform();
    }

    @SneakyThrows
    public static void keybordBack() throws Exception {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.sendKeys(Keys.chord(Keys.chord(Keys.BACK_SPACE))).build().perform();
    }
}
