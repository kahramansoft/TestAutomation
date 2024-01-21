package com.yunus.uitest.tests;


import com.aventstack.extentreports.ExtentTest;
import com.yunus.uitest.util.Config;
import com.yunus.uitest.util.ExtentReportUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BaseTest {
    public static WebDriver driver;
    static String browser = System.getProperty("browser");
    private ExtentTest test;

    private static boolean isExtentReportSetUp = false;

    private int[] array;
    private static int counter = 0;


    @Before
    public void beforeTest() {
        configureDriver();
       //ExtentReportUtil.setUp();
        if (!isExtentReportSetUp) {
            ExtentReportUtil.setUp();
            isExtentReportSetUp = true;
        }
        counter++;
        test = ExtentReportUtil.startTest("Scenario " + counter, "Extent report oluşturuldu.");

    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            takeScreenshot(scenario);
        }
        ExtentReportUtil.endTest();

        closeDriver();
    }

    void configureDriver() {
        try {
            if((browser==null)){
                if(Config.selectedDriver.equals("chrome")){
                System.setProperty("webdriver.chrome.driver", Config.chromeDriverPath);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-plugins-discovery");
                options.addArguments("--incognito");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
                driver.manage().deleteAllCookies();
            } else if (Config.selectedDriver.equals("edge")) {
                System.setProperty("webdriver.edge.driver", Config.edgeDriverPath);
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
            } else {
                System.out.println("Invalid driver selection: " + Config.selectedDriver);
            }
        }
            else if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", Config.chromeDriverPath);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-plugins-discovery");
                options.addArguments("--incognito");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
                driver.manage().deleteAllCookies();
            }
              else  if (browser.equals("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
                }
        } catch (Exception e) {
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

