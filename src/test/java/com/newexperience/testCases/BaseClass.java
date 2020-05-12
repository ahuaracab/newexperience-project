package com.newexperience.testCases;

import com.newexperience.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

public class BaseClass {

    ReadConfig readconfig = new ReadConfig();

    public String baseURL = readconfig.getBaseURL();
    public static WebDriver driver;
    public static Logger logger;

    @BeforeClass
    public void setup() {

        logger = Logger.getLogger("NewExperience");
        PropertyConfigurator.configure("log4j.properties");
        System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }
}
	

