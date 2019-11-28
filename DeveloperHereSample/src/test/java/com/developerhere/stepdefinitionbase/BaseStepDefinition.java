package com.developerhere.stepdefinitionbase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.maven.plugin.logging.SystemStreamLog;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

import com.developerhere.base.BaseClass;
import com.developerhere.elementbase.BaseElements;
import com.developerhere.util.Utility;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

public class BaseStepDefinition extends BaseClass {

    BaseElements be = PageFactory.initElements(driver, BaseElements.class);
    
    @After
    public static void captureScreenshot(Scenario scenario){
    	System.out.println("AfterMethod Executing...");
    		if(scenario.isFailed()){
    			try {
		    		TakesScreenshot ts=(TakesScreenshot)driver;
		    		String destFile="/target/screenshot.png";
		    		File source=ts.getScreenshotAs(OutputType.FILE);
	    		
					FileUtils.copyFile(source, new File(destFile));
					System.out.println("Screenshot has been taken..");
    			} catch (IOException e) {
    				System.out.println("Exception occured "+e.getMessage());
    			}
    		}
    	}

}
