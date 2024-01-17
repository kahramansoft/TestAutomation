package com.yunus.uitest.pages;


import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final By emailInput = new By.ById("login-email");
    private final By passwordInput = new By.ById("login-password-input");
    private final By loginButton = new By.ByXPath("//body/div[@id='container']/div[@id='login-register']/div[3]/div[1]/form[1]/button[1]");
    private final By errorText = new By.ByXPath("//span[contains(text(),'E-posta adresiniz ve/veya şifreniz hatalı.')]");
    private final By emptyErrorText = new By.ByXPath("//span[contains(text(),'Lütfen geçerli bir e-posta adresi giriniz.')]");
    private final By emptyPasswordText = new By.ByXPath("//span[contains(text(),'Lütfen şifrenizi giriniz.')]");
    private final By invalidEmailCharacters = new By.ByXPath("//span[contains(text(),'Lütfen geçerli bir e-posta adresi giriniz.')]");

    public void setEmail(String value) {
        sendKeys(emailInput, value);
    }

    public void setPassword(String value) {
        sendKeys(passwordInput, value);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public String getErrorText() {
        return getText(errorText);
    }

    public String getEmptyErrorText() {
        return getText(emptyErrorText);
    }

    public String getEmptyPasswordText() {
        return getText(emptyPasswordText);
    }

    public String getInvalidEmailCharacters() {
        return getText(invalidEmailCharacters);
    }
}

