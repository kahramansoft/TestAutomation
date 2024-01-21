package com.yunus.uitest.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.yunus.uitest.pages.HomePage;
import com.yunus.uitest.pages.LoginPage;
import com.yunus.uitest.util.Config;
import com.yunus.uitest.util.ExtentReportUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class HomeTest {
    private final HomePage homePage = new HomePage();

    private static ExtentTest test;

    private final LoginPage loginPage = new LoginPage();


    @Given("Navigate to the home page")
    public void navigateToTheHomePage() {
        homePage.navigateToPage(Config.baseURL);
    }

    @And("Click cookies accept button on home page")
    public void clickCookiesAcceptButtonOnHomePage() {
        homePage.clickOneTrustAccept();
    }

    @And("Click login button on home page")
    public void clickLoginButtonOnHomePage() {
            homePage.clickLoginButton();
   }



    @And("Hover my account button on home page")
    public void hoverMyAccountButtonOnHomePage() {
        homePage.hoverMyAccount();
    }
    @Then("User should be successfully logged in home page")
    public void userShouldBeSuccessfullyLoggedInHomePage() {
     try {
        Assert.assertEquals("Wrong email or non logged user",  homePage.getUserEmailText().toLowerCase(), Config.invalidEmail.toLowerCase());
        ExtentReportUtil.logToReport(Status.PASS, "Scenario: Success login is passed");

    } catch (AssertionError e) {
        ExtentReportUtil.logToReport(Status.FAIL, "Scenario: Success login is failed");
    }
    }
}


