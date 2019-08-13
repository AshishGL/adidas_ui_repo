package com.alfresco.site.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.alfresco.common.Keywords;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.By;

public class SiteCreationAndDeletionPage extends Keywords{

	@FindBy(id = "HEADER_SITES_MENU_text")
	private WebElementFacade sitesDropDown;

	@FindBy(id = "page_x002e_component-1-1_x002e_user_x007e_ankrana_x007e_dashboard_x0023_default-createSite-button")
	private WebElementFacade createNewSite;
	
	@FindBy(id = "alfresco-createSite-instance-title")
	private WebElementFacade siteName;
	
	@FindBy(id = "alfresco-createSite-instance-description")
	private WebElementFacade sitedescription;
	
	
	@FindBy(id = "alfresco-createSite-instance-ok-button-button")
	private WebElementFacade okButton;
	
	
	@FindBy(xpath = "//h1[contains(@id,'HEADER_TITLE')]/span[1]")
	private WebElementFacade SiteName;
	
	@FindBy(id = "HEADER_HOME_text")
	private WebElementFacade homePage;
	
	@FindBy(xpath = "//div[contains(@id,'page_x002e_component-1-1_x002e_user_x007e_ankrana_x007e_dashboard_x0023_default-sites')]/table[1]/tbody[2]/tr[1]/td[3]/div[1]/a[1]")
	private WebElementFacade publicSiteDeleteButton;
	
	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	private WebElementFacade deleteButtonPopUp;
	
	@FindBy(xpath = "//div[@id='prompt_c']//div[@class='bd']")
	private WebElementFacade deleteButtonPopUpText;
	
	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	private WebElementFacade deleteButtonconfirmation;
	
	@FindBy(xpath = "//div[@id='prompt']//div[@class='bd']")
	private WebElementFacade deleteButtonconfirmationText;
	
	@FindBy(id = "alfresco-createSite-instance-isPrivate")
	private WebElementFacade privateCheckBox;
	
String newUser="01Automation-Site";
	@FindBy(xpath = "//a[contains(text(),'01Automation-Site')]")
	private WebElementFacade sitecheckdashboard1;
	
	@FindBy(xpath = "//a[contains(text(),'02Automation-Site')]")
	private WebElementFacade sitecheckdashboard2;

	public void deleteSiteFromDashboard() throws Exception 
	{

	  if(sitecheckdashboard1.isCurrentlyVisible() && sitecheckdashboard2.isCurrentlyVisible())
	  {
		 clickOnPublicSiteDeleteIcon();
		clickOndeleteButtonOnPopUp();
		clickOnDeleteButtonconfirmation();
		waitABit(3000);
		clickOnPublicSiteDeleteIcon();
		clickOndeleteButtonOnPopUp();
		clickOnDeleteButtonconfirmation();
	  }
	  else
				  if(sitecheckdashboard1.isCurrentlyVisible())
						{
							clickOnPublicSiteDeleteIcon();
							clickOndeleteButtonOnPopUp();
							clickOnDeleteButtonconfirmation();
						}
			  
						  else 
							  if(sitecheckdashboard2.isCurrentlyVisible())
								{
									clickOnPublicSiteDeleteIcon();
									clickOndeleteButtonOnPopUp();
									clickOnDeleteButtonconfirmation();
								}
							  else
							  {
								  System.out.println("site already deleted");
							  }
							
	}
	
	
	
	public void clickOnHomePage() 
	{
		clickOn(homePage);
	}
	
	public void clickOnCreateNewSites() 
	{
		clickOn(createNewSite);
	}
	
	public void enterSiteName(String name) 
	{

		typeInto(siteName, name);
	}
	
	
	public void enterSiteDescription(String description)
	{

		typeInto(sitedescription, description);
	}
	
	
	public void clickOkButton() 
	{

		clickOn(okButton);
	}
	
	public String checkSiteName()
	{
		return SiteName.getText();
		
	}
	
	public void clickOnPublicSiteDeleteIcon() throws Exception 
	{    Thread.sleep(5000);
	
	WebElement searchBtn = getDriver().findElement(By.xpath("//div[contains(@id,'page_x002e_component-1-1_x002e_user_x007e_ankrana_x007e_dashboard_x0023_default-sites')]/table[1]/tbody[2]/tr[1]/td[3]/div[1]/a[1]"));

	Actions action = new Actions(getDriver());
	action.moveToElement(searchBtn).perform();
		clickOn(publicSiteDeleteButton);
	}
	
	public String checkdeleteSitePopUpMessage()
	{
		return deleteButtonPopUpText.getText();
		
	}
	public void clickOndeleteButtonOnPopUp() 
	{
		clickOn(deleteButtonPopUp);
	}
	
	public String checkDeleteButtonconfirmationText() 
	{
		return deleteButtonPopUpText.getText();
	}
	
	public void clickOnDeleteButtonconfirmation() 
	{
		clickOn(deleteButtonconfirmation);
		waitABit(3000);
	}

	

	public void clickOnPrivateVisibilityCheckBox() 
	{
		clickOn(privateCheckBox);
	}

	
	
}
