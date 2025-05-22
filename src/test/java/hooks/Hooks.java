package hooks;

import driver.DriverManager;
import io.cucumber.java.AfterStep;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


import java.io.File;
import java.io.IOException;

public class Hooks {
    WebDriver driver = DriverManager.driver.get();
    int count = 1;

    @AfterStep
    public void takeScreenShot(){
        TakesScreenshot ts = (TakesScreenshot)driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File folder = new File(System.getProperty("user.dir")+"/target/Screenshots");
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


        File destFile = new File(System.getProperty("user.dir")+"/target/Screenshots/"+DriverManager.browser.get()+"screenshot"+count+".png");
        try {
            FileHandler.copy(srcFile, destFile);
            System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
            count = count+1;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
