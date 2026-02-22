package steps;

import helpers.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.plugin.event.Node;
import objectFinder.FindHelper;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.prefs.Preferences;

import static hooks.Hooks.commonProperties;

public class Steps {

    public static Preferences prefs = Preferences.userNodeForPackage(Node.Example.class);
    ElementActionsHelper elementActionsHelper = new ElementActionsHelper();
    AssertHelper assertHelper = new AssertHelper();
    FindHelper findHelper = new FindHelper();

    NavigationHelper navigationHelper = new NavigationHelper();
    WaitHelper waitHelper = new WaitHelper();

    @Given("Zara uygulamasını aç")
    public void launchUrl() throws Exception {
        String URL = commonProperties.getProperty("URL");
        navigationHelper.navigateTo(URL);
        waitHelper.waitForAngularLoad();
    }

    @And("{string} elementine tıkla")
    public void clickElement(String element) throws Exception {
        try {
            elementActionsHelper.click(findHelper.createBy(element));
        } catch (StaleElementReferenceException e) {
            elementActionsHelper.click(findHelper.createBy(element));
        }
    }

    @And("{string} elementine {string} değerini yaz")
    public void sendKeysElement(String element, String text) throws Exception {
        elementActionsHelper.enterText(findHelper.createBy(element), text);
    }

    @And("{string} sayfasını gör")
    public void seePage(String page) {
        prefs.put("Sayfa", page);
    }

    @And("{string} elementinin sayfada olduğunu kontrol et")
    public void checkElementVisible(String element) throws IOException {
        assertHelper.checkElementVisible(findHelper.createBy(element));
    }

    @And("{int} saniye bekle")
    public void saniyeBekle(int second) throws InterruptedException {
        Thread.sleep(second * 1000);
    }


    @And("{string} elementinin değerini temizle")
    public void clearText(String element) throws Exception {
        elementActionsHelper.click(findHelper.createBy(element));
        KeyboardHelper.keybordCtrlA();
        KeyboardHelper.keybordDelete();
        for (int i = 1; i <= 20; i++) {
            KeyboardHelper.keybordBack();
        }
    }
    @And("{string} a bas")
    public void press(String key) throws Exception {
        switch (key) {
            case "Enter":
                KeyboardHelper.keybordEnter();
                break;
            case "ESC":
                KeyboardHelper.keybordESC();
                break;
            case "TAB":
                KeyboardHelper.keybordTAB();
                break;
        }
    }

    @And("{string} elementini {int} saniye içinde görürsen tıkla")
    public void clickElementVisibleWithTime(String element, int time) throws Exception {
        if (assertHelper.isElementVisible(findHelper.createBy(element), time))
            elementActionsHelper.click(findHelper.createBy(element));
    }

    @And("{string} elementine çift tıkla")
    public void tripleClickElement(String element) throws Exception {
        elementActionsHelper.click(findHelper.createBy(element));
        elementActionsHelper.click(findHelper.createBy(element));
    }


    @And("{string} elementine ait metni al ve {string} key ile kaydet")
    public void getTextAndSaveItAsKey(String elemet, String key) throws Exception {
        String text = elementActionsHelper.getText(findHelper.createBy(elemet));
        prefs.put(key, text);
    }

    @Then("{string} elementinin değerinin {string} key değerini içerdiği kontrol edilir")
    public void checkElementContainsTextByKey(String elemet, String text) throws Exception {
        String actualText = elementActionsHelper.getText(findHelper.createBy(elemet));
        String expectedText = prefs.get(text, null);
        assertHelper.containsElementText(actualText, expectedText);
    }

}
