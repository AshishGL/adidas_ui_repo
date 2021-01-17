package com.alfresco.site.pages;


import org.openqa.selenium.support.FindBy;

import com.alfresco.common.Keywords;
import com.objectslocation.PageReferences;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.ClickOnElement;


public class UserSitePage extends Keywords {

	@FindBy(id = "template_x002e_toolbar_x002e_user-sites_x0023_default-user-trashcan-link")
	private WebElementFacade trashcan;

	
	@FindBy(id = "template_x002e_user-trashcan_x002e_user-trashcan_x0023_default-search-text")
	private WebElementFacade searchArea;
	
	@FindBy(id = "template_x002e_user-trashcan_x002e_user-trashcan_x0023_default-search-button-button")
	private WebElementFacade searchButton;
	
	
	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	private WebElementFacade deleteButton;
	
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	private WebElementFacade okButton;
	
	@FindBy(xpath = "//div[starts-with(@class,'name')]")
	private WebElementFacade checkSiteExistance;
	
	public void clickOnTrashcanTab() 
	{
		clickOn(trashcan);
		
	
	}
	
	public void searchForSiteName(String siteName)
	{   waitABit(2000);
		typeInto(searchArea, siteName);
	    clickOn(searchButton);
		waitABit(2000);
	}
public void deleteEntery()
{
	if(checkSiteExistance.isCurrentlyVisible())
	{clickOn(deleteButton);
	clickOn(okButton);
	waitABit(2000);
	}
	else
	{   System.out.println("NOT FOUND NOW WAITING");
		waitABit(2000);
	}
}

}
