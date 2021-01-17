package com.alfresco.common;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.support.FindBy;

import com.alfresco.common.Keywords;

import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends Keywords{
	@FindBy(id= "page_x002e_components_x002e_slingshot-login_x0023_default-username")
	private WebElementFacade username_TextField;
	
	@FindBy(id= "page_x002e_components_x002e_slingshot-login_x0023_default-password")
	private WebElementFacade password_TextField;
	
	@FindBy(id = "page_x002e_components_x002e_slingshot-login_x0023_default-submit-button")
	private WebElementFacade loginButton;
	
		
	String username;
	String password;

	
	public void openAlfrescoUrl() throws InterruptedException
	{open();
	getDriver().manage().window().maximize();
	}
	
	public void enterUserName(String uname) throws InterruptedException {
		username_TextField.sendKeys(uname);
	}
	
	public void enterPassword(String pwd) {
		password_TextField.sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		loginButton.click();
	}
	
	public void loginWithCredentials(String uname, String pwd) throws Exception {
		
		enterUserName(uname);
		enterPassword(pwd);
		clickOnLogin();
	}
	
}
