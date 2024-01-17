package com.yunus.uitest.pages;

import com.yunus.uitest.tests.BaseTest;
import com.yunus.uitest.util.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private final WebDriver driver = BaseTest.driver;

    public void click(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, Config.DEFAULT_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(selector)).click();
    }

    public void forceClick(By selector) {
        driver.findElement(selector).click();
    }

    public void sendKeys(By selector, String value) {
        driver.findElement(selector).sendKeys(value);
    }

    public void clear(By selector) {
        driver.findElement(selector).clear();
    }

    public String getText(By selector) {
        return waitElementVisible(selector).getText();
    }

    public void navigateToPage(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void forceWait(Duration duration) {
        try {
            Thread.sleep(duration.toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public WebElement waitElementVisible(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, Config.DEFAULT_WAIT);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public void mouseOver(By selector) {
        waitElementVisible(selector);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(selector)).build().perform();
    }
}
