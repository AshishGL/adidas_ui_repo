package com.adidas.steps;

import com.objectslocation.PageReferences;

import cucumber.api.java.en.Given;

public class AssignmentBackground extends PageReferences {
	
	@Given("^Open DemoBlaze application in chrome browser$")
	public void open_DemoBlaze_application_in_chrome_browser() {
		assignment.openApplication();
		
	    
	}

}
