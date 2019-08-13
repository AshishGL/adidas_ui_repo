package com.alfresco.site.steps;

import org.openqa.selenium.support.FindBy;

import com.objectslocation.PageReferences;

import cucumber.api.java.en.Given;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class AlfrescoBackgroundSteps extends PageReferences {

	@FindBy(id= "page_x002e_components_x002e_slingshot-login_x0023_default-username")
	private WebElementFacade username_TextField;
	
	@FindBy(id= "page_x002e_components_x002e_slingshot-login_x0023_default-password")
	private WebElementFacade password_TextField;
	
	@FindBy(id = "page_x002e_components_x002e_slingshot-login_x0023_default-submit-button")
	private WebElementFacade loginButton;
	
	String username;
	String password;

	@Given("^Open alfresco aplication in chrome browser$")
	public void open_alfresco_aplication_in_chrome_browser() throws InterruptedException {

		loginPage.openAlfrescoUrl();
	}

	@Given("^logged into application$")
	public void logged_into_application() {

		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		username = variables.getProperty("username");
		password = variables.getProperty("password");
		try {
			loginPage.loginWithCredentials(username, password);
		} catch (Exception e) {
			getDriver().close();
		}

	}

}
