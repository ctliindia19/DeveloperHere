package com.developerhere.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.deps.com.thoughtworks.xstream.mapper.OuterClassMapper;

public class Utility {

	public static void captureScreenshot(WebDriver driver,String screeshotName  ){
	try {
		TakesScreenshot ts=(TakesScreenshot)driver;
		String destFile="/target/"+screeshotName+".png";
		File source=ts.getScreenshotAs(OutputType.FILE);
		
			FileUtils.copyFile(source, new File(destFile));
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot"+e.getMessage());
			
		}
	}
}
