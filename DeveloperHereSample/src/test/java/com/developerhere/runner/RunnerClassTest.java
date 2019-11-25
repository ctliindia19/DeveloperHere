package com.developerhere.runner;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/Luma_Reports/cucumber.json",
                         detailedReport = true,
                         toPDF = true,
                         outputFolder = "target/Luma_Reports/ExtendedReport"
)
@CucumberOptions(
		plugin = { "html:target/Luma_Reports/cucumber-html-report",
                 "json:target/Luma_Reports/cucumber.json",
                 "pretty:target/Luma_Reports/cucumber-pretty.txt",
                 "usage:target/Luma_Reports/cucumber-usage.json",
                 "junit:target/Luma_Reports/cucumber-results.xml" },
                 dryRun = false, 
                 features = {"Feature"},
                 glue = {"com.developerhere.stepdefinitions"},
                 tags = {"@SanityRun"},
                 monochrome = true
)

public class RunnerClassTest {

}

