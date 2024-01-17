package com.yunus.uitest.tests;

import com.yunus.uitest.pages.LoginPage;
import com.yunus.uitest.util.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.time.Duration;

public class LoginTest {

    private final LoginPage loginPage = new LoginPage();

    @And("Enter valid email on login page")
    public void enterValidEmailOnLoginPage() {
        loginPage.setEmail(Config.validEmail);
    }

    @And("Enter valid password on login page")
    public void enterValidPasswordOnLoginPage() {
        loginPage.setPassword(Config.validPassword);
    }

    @When("Click login button on login page")
    public void clickLoginButtonOnLoginPage() {
        loginPage.clickLoginButton();
    }

    @And("Enter invalid password on login page")
    public void enterInvalidPasswordOnLoginPage() {
        loginPage.setPassword(Config.invalidPassword);
    }

    @Then("User should encounter a login failure on the login page")
    public void userShouldEncounterALoginFailureOnTheLoginPage() {
        Assert.assertEquals("User logged in successfully", loginPage.getErrorText().toLowerCase(), "e-posta adresiniz ve/veya şifreniz hatalı.");
    }

    @Then("User should encounter a login failure on the login page with empty username")
    public void userShouldEncounterALoginFailureOnTheLoginPageWithEmptyUsername() {
        Assert.assertEquals("User logged in successfully", loginPage.getEmptyErrorText().toLowerCase(), "lütfen geçerli bir e-posta adresi giriniz.");
    }

    @Then("User should encounter a login failure on the login page with empty password")
    public void userShouldEncounterALoginFailureOnTheLoginPageWithEmptyPassword() {
        Assert.assertEquals("User logged in successfully", loginPage.getEmptyPasswordText().toLowerCase(), "lütfen şifrenizi giriniz.");
    }

    @And("Enter empty password on login page")
    public void enterEmptyPasswordOnLoginPage() {
        loginPage.setPassword("");
    }

    @And("Enter empty user on login page")
    public void enterEmptyUserOnLoginPage() {
        loginPage.setEmail("");
    }

    @And("Enter invalid email on login page")
    public void enterInvalidEmailOnLoginPage() {
        loginPage.setEmail(Config.invalidEmail);
    }

    @Then("User should encounter a login failure on the login page with wrong email characters")
    public void userShouldEncounterALoginFailureOnTheLoginPageWithWrongEmailCharacters() {
        Assert.assertEquals("User logged in successfully", loginPage.getInvalidEmailCharacters().toLowerCase(), "lütfen geçerli bir e-posta adresi giriniz.");
    }

    @And("Enter invalid characters email on login page")
    public void enterInvalidCharactersEmailOnLoginPage() {
        loginPage.setPassword(Config.invalidEmailCharacter);
    }

    @Then("User should encounter a login failure on the login page with wrong email")
    public void userShouldEncounterALoginFailureOnTheLoginPageWithWrongEmail() {
        Assert.assertEquals("User logged in successfully", loginPage.getErrorText().toLowerCase(), "e-posta adresiniz ve/veya şifreniz hatalı.");
    }
}
