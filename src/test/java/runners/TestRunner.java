package runners;

import driver.DriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;


@CucumberOptions(
        features = "src/test/Features",
        glue = {"stepdefinitions","hooks"},
        plugin = {"html:target/cucumber-reports/cucumber-pretty/report.html"},
        tags = ""

)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters({"browser","grid"})
    public void initiateDriver(String browser,@Optional("") String grid) {
        DriverManager.initiateDriver(browser,grid);
    }
    @AfterClass
    public void quitDriver() {
        DriverManager.quitDriver();
    }
}