package runners;

import driver.DriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

import static org.testng.TestRunner.PriorityWeight.dependsOnMethods;

@CucumberOptions(
        features = "src/test/Features",
        glue = {"stepdefinitions","hooks"},
        plugin = {"html:target/cucumber-reports/cucumber-pretty/report.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters({"browser"})
    public void initiateDriver(String browser) {
        DriverManager.initiateDriver(browser);
    }
    @AfterClass
    public void quitDriver() {
        DriverManager.quitDriver();
    }
}