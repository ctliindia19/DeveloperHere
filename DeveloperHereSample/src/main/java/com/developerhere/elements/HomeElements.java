package com.developerhere.elements;





import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.junit.Assert;
import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.developerhere.base.BaseClass;
import com.developerhere.util.AdditionalConditions;






public class HomeElements extends BaseClass {
	private static final Logger logger =LoggerFactory.getLogger(HomeElements.class);

    
	public void openApplicationURL() {
		driver.get(homePage);
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(AdditionalConditions.angularHasFinishedProcessing());
		System.out.println("Angular was initialized.."+AdditionalConditions.angularHasFinishedProcessing());
	}
     
	@FindBy (partialLinkText="Sign up")
	private WebElement signUp;
	
    public void verifyHomePage(){
    	if (signUp.isDisplayed())
    	{
    		System.out.println("User is in Home page");
    		wait(5);
    	}
    }
    
    public void verifyLinks() {
        
        List<WebElement> links = driver.findElements(By.xpath("//a"));
        Iterator<WebElement> it = links.iterator();
        while(it.hasNext()){
            url = it.next().getAttribute("href");
            //System.out.println(url);
            
            if(url.startsWith(homePage))
          //if (!url.contains("/documentation"))
            {
//                System.out.println("URL belongs to another domain, skipping it.");
//                continue;
            
            
            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = huc.getResponseCode();
                
                
                if(respCode >=300 && respCode <200){
                    //System.out.println(url+" is a broken link");
                    invalidUrlList.add(url);
                }
                else{
                    //System.out.println(url+" is a valid link");
                	WebDriverWait wait = new WebDriverWait(driver, 15, 100);
                    wait.until(AdditionalConditions.angularHasFinishedProcessing());
                    validUrlList.add(url);
                    
                }
                    
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        }
    }
    public void closeBrowser(){
    	driver.quit();
    }
	
}

  


