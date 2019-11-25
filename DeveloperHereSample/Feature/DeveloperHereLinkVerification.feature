
Feature: Open application and verify all links are accessible

@SanityRun
	Scenario: Verify all links into the webpage contains documentation and ignore anything not matched with application url
	 Given User enter the Application URL
	 When User navigate to Home page
	 Then User verify all links contains documentation and ignore anything outside Application URL
	 And User close the browser
	 


	
	 


	 
	 
	 
	 
	 


