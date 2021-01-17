package com.alfresco.site.pages;

import org.openqa.selenium.support.FindBy;

import com.alfresco.common.Keywords;

import net.serenitybdd.core.pages.WebElementFacade;

public class FolderFunctionalityPage  extends Keywords{
	
	@FindBy(xpath = "//input[contains(@id,'checkbox-yui-rec')]")
	private WebElementFacade checkbox;
	
	@FindBy(id = "template_x002e_documentlist_v2_x002e_documentlibrary_x0023_default-selectedItems-button-button")
	private WebElementFacade selectItembutton;
	
	@FindBy(xpath = "//span[contains(text(),'Download as Zip') and contains(@class,'onActionDownload')]")
	private WebElementFacade downloadAsZip;
	
	
	@FindBy(xpath = "//span[contains(text(),'Copy to...') and contains(@class,'onActionCopyTo')]")
	private WebElementFacade copyTo;
	
	@FindBy(xpath = "//span[contains(text(),'Move to...') and contains(@class,'onActionMoveTo')]")
	private WebElementFacade moveTo;
	
	
	
	@FindBy(xpath = "//h4[contains(text(),'01Automation-Site')]")
	private WebElementFacade recentlycreatesite;
	
	@FindBy(id = "template_x002e_documentlist_v2_x002e_documentlibrary_x0023_default-copyMoveTo-ok-button")
	private WebElementFacade copyButton;
	
	
	@FindBy(id = "template_x002e_documentlist_v2_x002e_documentlibrary_x0023_default-copyMoveTo-ok-button")
	private WebElementFacade moveButton;
	
	@FindBy(xpath = "//span[contains(text(),'Delete') and contains(@class,'onActionDelete')]")
	private WebElementFacade deleteOption;
	
	
	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	private WebElementFacade deleteButton;
	
	
	public void clickOnDeleteOption() 
	{
		clickOn(deleteOption);
	}
	
	public void clickOnDeleteButton() 
	{
		deleteButton.waitUntilVisible();
		clickOn(deleteButton);
	}
	
	public void clickOnCheckbox() 
	{
		clickOn(checkbox);
	}


	public void clickOnSelectItemsDropDown() 
	{
		clickOn(selectItembutton);
	}
	
	public void clickOnDownloadAsZipButton() 
	{
		clickOn(downloadAsZip);
	}
	
	public void clickOnCopyToButton() 
	{
		clickOn(copyTo);
	}
	
	public void clickOnMoveToButton() 
	{
		clickOn(moveTo);
	}
		
	public void clickOnSiteFromList() 
	{
		clickOn(recentlycreatesite);
	}
	
	public void clickOnCopyButton() 
	{
		clickOn(copyButton);
	}
	
	public void clickOnMoveButton() 
	{
		clickOn(moveButton);
	}

}
