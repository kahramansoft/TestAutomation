package com.yunus.uitest.tests;


import com.yunus.uitest.util.Config;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BaseTest {
    public static WebDriver driver;

    @Before
    public void beforeTest() {
        configureDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        takeScreenshot(scenario);
        closeDriver();
    }

    void configureDriver() {
        try {
            if (Config.selectedDriver.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", Config.chromeDriverPath);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-plugins-discovery");
                options.addArguments("--incognito");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
                driver.manage().deleteAllCookies();
                driver.get(Config.baseURL);
            }
        }catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Driver could not be configured!");
        }
    }
    private void closeDriver() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
           // e.printStackTrace("Failed to close driver!");
            System.out.println("Failed to close driver!");
        }
    }

    void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
            File screenShotName = new File("src/test/resources/screenshots/" + scenario.getName() + "_" + timeStamp + ".png");
            try {
                FileUtils.copyFile(scrFile, screenShotName);
            } catch (IOException e) {
                System.out.println("Screenshot could not be taken!");
            }
        }
    }
}
