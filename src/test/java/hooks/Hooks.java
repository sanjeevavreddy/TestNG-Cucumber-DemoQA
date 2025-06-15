package hooks;


import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import utils.TestParameters;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class Hooks {

    @Before
    public void initiateDriver() {
        DriverManager.initiateDriver();
    }

    @After(order = 2)
    public void attachScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failure Screenshot", new ByteArrayInputStream(screenshot));
        }
    }
    @After(order = 1)
    public void quitDriver() {
        DriverManager.quitDriver();
    }

    @AfterStep
    public void takeScreenShot(Scenario scenario) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        StringBuilder folderPath = new StringBuilder()
                .append(System.getProperty("user.dir"))
                .append(File.separator)
                .append("target")
                .append(File.separator)
                .append("Screenshots")
                .append(File.separator)
                .append(TestParameters.getBrowser())
                .append(File.separator)
                .append(scenario.getName().replaceAll("\\s+", ""));

        File folder = new File(folderPath.toString());
        if (!folder.exists()) {
            boolean created = folder.mkdirs();
            if (created) {
                System.out.println("Folder created: " + folder.getAbsolutePath());
            } else {
                System.out.println("Failed to create folder.");
            }
        } else {
            System.out.println("Folder already exists: " + folder.getAbsolutePath());
        }

        File destFile = new File(folderPath.append(File.separator).append(TestParameters.getScreeShotCount()).append(".png").toString());
        FileHandler.copy(srcFile, destFile);
        System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
        TestParameters.setScreeShotCount(TestParameters.getScreeShotCount() + 1);
    }
}
