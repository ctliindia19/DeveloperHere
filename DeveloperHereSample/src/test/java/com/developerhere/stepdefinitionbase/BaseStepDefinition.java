package com.developerhere.stepdefinitionbase;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;

import com.developerhere.base.BaseClass;
import com.developerhere.elementbase.BaseElements;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

public class BaseStepDefinition extends BaseClass {

    BaseElements be = PageFactory.initElements(driver, BaseElements.class);

    @Then("^Wait for these seconds (\\d+)$")
    public void wait_for_these_seconds(int data) throws Throwable {
        be.wait(data);
    }
}
