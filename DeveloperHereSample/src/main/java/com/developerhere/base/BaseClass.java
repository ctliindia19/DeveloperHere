package com.developerhere.base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.logging.Level;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


@SuppressWarnings("deprecation")
public class BaseClass {
	

    protected static WebDriver driver;
    protected static String browser = null;
    protected static Properties prop;
    protected String url = "";
    protected HttpURLConnection huc = null;
    protected int respCode = 200;
    protected String homePage = prop.getProperty("Application_Url");
    protected static List<String> invalidUrlList=new ArrayList();
    protected static List<String> validUrlList=new ArrayList();

    static {
    	
    	try {
			configFileReader();
			browser =prop.getProperty("Browser");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "exefiles/chromedriver.exe");
        	DesiredCapabilities caps = DesiredCapabilities.chrome();
        	
            LoggingPreferences logPrefs = new LoggingPreferences();
            logPrefs.enable(LogType.BROWSER, Level.SEVERE);
            logPrefs.enable(LogType.DRIVER, Level.SEVERE);
            caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            // This size works well on local machine
            //options.addArguments("window-size=1024,768");
            // This size works well for remote VDI session
            //options.addArguments("window-size=900,700");
            options.addArguments("start-maximized");
            caps.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            
        } else if (browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "exefiles/geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/internetexplorerdriver.exe");
            driver = new InternetExplorerDriver();
        }
    }
    
    public static void configFileReader() throws Exception, FileNotFoundException
	{

		
    	String propertyFilePath=System.getProperty("user.dir")+"/src/main/java/com/developerhere/config/configuration.properties";

    	BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath));
		prop = new Properties();
		prop.load(reader);
		reader.close();
		System.out.println("ConfigFile is ready to be used");
	}

    

    public WebElement waitTillElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitTillElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    public void wait(int seconds) {
        try {
            synchronized (driver) {
                seconds = (seconds * 1000);
                driver.wait(seconds);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}