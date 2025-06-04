package runners;

import driver.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;


@CucumberOptions(
        features = "src/test/Features",
        glue = {"stepdefinitions", "hooks"},
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty/report.html"},
        monochrome = true,
        tags = ""
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeTest
    @Parameters({"browser", "gridURL"})
    public void initiateDriver(String browser, @Optional("") String gridURL) {
        DriverManager.browser.set(browser);
        DriverManager.gridURL.set(gridURL);
    }
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}