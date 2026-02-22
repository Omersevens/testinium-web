package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                //  "classpath:features/Zara.feature",
                  "src/test/java/features/Zara.feature"
        },

        glue = {"hooks", "steps"},
        plugin = {"pretty",
                "html:target/cucumber-report/cucumber-report.html",
                "json:target/cucumber-report/cucumber-report.json",
                "junit:target/cucumber-report/cucumber-report.xml"
        },
        monochrome = true)
public class Runner extends AbstractTestNGCucumberTests {
}