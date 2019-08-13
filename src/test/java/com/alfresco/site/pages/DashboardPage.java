package com.alfresco.site.pages;

import org.openqa.selenium.support.FindBy;

import com.alfresco.common.Keywords;

import net.serenitybdd.core.pages.WebElementFacade;

public class DashboardPage extends Keywords{
	

	@FindBy(xpath = "//a[contains(@title,'Home')]")
	private WebElementFacade home;
	
	@FindBy(xpath = "//a[contains(@title,'My Files')]")
	private WebElementFacade myFiles;
	
	@FindBy(xpath = "//span[contains(@id,'HEADER_SITES_MENU_text')]")
	private WebElementFacade sites;
	
	@FindBy(xpath = "//span[contains(@id,'HEADER_TASKS_text')]")
	private WebElementFacade tasks;
	
	@FindBy(xpath = "//a[contains(@title,'People')]")
	private WebElementFacade people;

	
	
	public String fetchHomePageTitle() 
	{
		return home.getText();
		
	}
	
	public String fetchMyFilesTitle() 
	{
		return myFiles.getText();
		
	}
	public String fetchSitesTitle() 
	{
		return sites.getText();
		
	}
	
	public String fetchTasksTitle() 
	{
		return tasks.getText();
		
	}
	public String fetchPeopleTitle() 
	{
		return people.getText();
		
	}
	

	
	
}
