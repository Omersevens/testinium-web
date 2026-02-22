package hooks;

import base.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Hooks {
    public static Properties commonProperties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("./src/test/resources/common.properties");
            commonProperties.load(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() {
        DriverManager.setBrowserType(commonProperties.getProperty("BROWSER"));
    }
    @After
    public void tearDown(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        DriverManager.quitDriver();
    }
}