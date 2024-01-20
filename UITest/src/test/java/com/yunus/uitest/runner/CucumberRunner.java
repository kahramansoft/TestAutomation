package com.yunus.uitest.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "com.yunus.uitest.tests",//        glue = {"com.yunus.uitest.tests", "parallel"},
        plugin = {"pretty", "html:target/cucumber-reports"},
       // tags = "@login_feature", // "@login_feature or @search_feature"
        dryRun = false,
        monochrome = true
)
public class CucumberRunner {
}

