package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;
import utils.TestParameters;


@CucumberOptions(
        features = "src/test/java/resources/features",
        glue = {"stepdefinitions", "hooks"},
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty/report.html"},
        monochrome = true,
        tags = ""
)
public class TestRunner extends AbstractTestNGCucumberTests {


    @BeforeTest(alwaysRun = true)
    @Parameters({"browser", "gridURL"})
    public void initiateDriver(String browser, @Optional("") String gridURL){
        System.out.println("Setting the browser before class:" +TestParameters.getBrowser());
        TestParameters.setBrowser(browser);
        TestParameters.setGridURL(gridURL);
        System.out.println("Setting the browser after class:" +TestParameters.getBrowser());
    }

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}