package hooks;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import pages.BasePage;
import utils.TestParameters;

import java.io.File;
import java.io.IOException;

public class Hooks {


    @Before
    public void initiateDriver() {
        DriverManager.initiateDriver();
        TestParameters.setScreeShotCount(1);
    }

    @After
    public void quitDriver() {
        DriverManager.quitDriver();

    }

    @AfterStep
    public void takeScreenShot(Scenario scenario) {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.driver.get();
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File folder = new File(System.getProperty("user.dir") + "/target/Screenshots/"+TestParameters.getBrowser()+"/"+scenario.getName().replaceAll("\\s+",""));
        if (!folder.exists()) {
            boolean created = folder.mkdirs(); // Use mkdirs() to create parent dirs if needed
            if (created) {
                System.out.println("Folder created: " + folder.getAbsolutePath());
            } else {
                System.out.println("Failed to create folder.");
            }
        } else {
            System.out.println("Folder already exists: " + folder.getAbsolutePath());
        }


        File destFile = new File(System.getProperty("user.dir") + "/target/Screenshots/"+TestParameters.getBrowser()+"/"+scenario.getName().replaceAll("\\s+","")+"/" + TestParameters.getScreeShotCount() + ".png");
        try {
            FileHandler.copy(srcFile, destFile);
            System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
            TestParameters.setScreeShotCount(TestParameters.getScreeShotCount()+1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
