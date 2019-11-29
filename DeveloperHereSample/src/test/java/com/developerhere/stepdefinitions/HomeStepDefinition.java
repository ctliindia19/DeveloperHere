package com.developerhere.stepdefinitions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.developerhere.base.BaseClass;
import com.developerhere.elements.HomeElements;
import com.developerhere.util.AdditionalConditions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomeStepDefinition extends BaseClass {
	HomeElements he=PageFactory.initElements(driver, HomeElements.class);
	

	@Given("^User enter the Application URL$")
	public void user_enter_the_Application_URL() throws Throwable {
	    he.openApplicationURL();
	}

	@When("^User navigate to Home page$")
	public void user_navigate_to_Home_page() throws Throwable {
	   he.verifyHomePage();
	}

	@Then("^User verify all links contains documentation and ignore anything outside Application URL$")
	public void user_verify_all_links_contains_documentation_and_ignore_anything_outside_Application_URL() throws Throwable {
	    he.verifyLinks();
	    System.out.println("List of all broken link");
	    for (String s : invalidUrlList)
	    {
	    	System.out.println(s);
	    }
	    System.out.println("List of all valid link");
	    for (String s : validUrlList)
	    {
	    	WebDriverWait wait=new WebDriverWait(driver, 20);
    		wait.until(AdditionalConditions.angularHasFinishedProcessing());
    		System.out.println("Angular was initialized.."+AdditionalConditions.angularHasFinishedProcessing());
	    	System.out.println(s);
	    }
	}
	

	@And("^User close the browser$")
	public void user_close_the_browser() throws Throwable {
	   he.closeBrowser();
	}

}
