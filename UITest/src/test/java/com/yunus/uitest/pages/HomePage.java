package com.yunus.uitest.pages;


import org.openqa.selenium.By;
import java.time.Duration;

public class HomePage extends BasePage {
    private final By oneTrustAccept = new By.ById("onetrust-accept-btn-handler");
    private final By loginButton = new By.ByXPath("//*[@id=\"account-navigation-container\"]/div/div[1]/div[1]/p");
    private final By myAccountButton = new By.ByXPath("//div[@class='account-nav-item user-login-container']");
    private final By userEmail = new By.ByClassName("user-name");

    public void clickOneTrustAccept() {
        click(oneTrustAccept);
    }

    public void clickLoginButton() {
        forceClick(loginButton);
    }

    public void hoverMyAccount() {
        forceWait(Duration.ofSeconds(1));
        mouseOver(myAccountButton);
    }

    public String getUserEmailText() {
        return getText(userEmail);
    }
}















