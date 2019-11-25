$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("DeveloperHereLinkVerification.feature");
formatter.feature({
  "line": 2,
  "name": "Open application and verify all links are accessible",
  "description": "",
  "id": "open-application-and-verify-all-links-are-accessible",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Verify all links into the webpage contains documentation and ignore anything not matched with application url",
  "description": "",
  "id": "open-application-and-verify-all-links-are-accessible;verify-all-links-into-the-webpage-contains-documentation-and-ignore-anything-not-matched-with-application-url",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@SanityRun"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "User enter the Application URL",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User navigate to Home page",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "User verify all links contains documentation and ignore anything outside Application URL",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "User close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "HomeStepDefinition.user_enter_the_Application_URL()"
});
formatter.result({
  "duration": 16271133376,
  "status": "passed"
});
formatter.match({
  "location": "HomeStepDefinition.user_navigate_to_Home_page()"
});
formatter.result({
  "duration": 6815276261,
  "status": "passed"
});
formatter.match({
  "location": "HomeStepDefinition.user_verify_all_links_contains_documentation_and_ignore_anything_outside_Application_URL()"
});
formatter.result({
  "duration": 67741614832,
  "status": "passed"
});
formatter.match({
  "location": "HomeStepDefinition.user_close_the_browser()"
});
formatter.result({
  "duration": 883555625,
  "status": "passed"
});
});