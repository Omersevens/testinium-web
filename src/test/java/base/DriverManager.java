package base;

import enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManager {
    public static WebDriver driver;

    private static String browserType;

    public static void setBrowserType(String browser) {
        browserType = browser;
    }

    public static WebDriver getDriver() throws Exception {

        BrowserType browser = BrowserType.valueOf(browserType);

        if (driver == null) {
            switch (browser) {
                case Chrome:
                    System.out.println("Launching Chrome Browser");
                    ChromeOptions options = new ChromeOptions();

                    if (System.getProperty("os.name").contains("Win"))
                        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
                    else if (System.getProperty("os.name").contains("Mac"))
                        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver");
                    else
                        throw new Exception(System.getProperty("os.name") + " işletim sistemi için uygun firefox driver dosyası bulunmamaktadır!!!");

                    options.addArguments("--window-size=1920,1080");
                    options.addArguments("--remote-allow-origins=*");

                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                    break;
                case Firefox:
                    System.out.println("Launching Firefox");
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case MicrosoftEdge:
                    System.out.println("Launching MicrosoftEdge");
                    WebDriverManager.edgedriver().arch32().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    break;
            }
        }
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
        return driver;
    }

    public static void quitDriver() {
        driver.close();
        driver.quit();
        driver = null;
    }

}
