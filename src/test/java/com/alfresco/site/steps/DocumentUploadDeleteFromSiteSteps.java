package com.alfresco.site.steps;

import com.objectslocation.PageReferences;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class DocumentUploadDeleteFromSiteSteps extends PageReferences {

	@When("^click on document library link$")
	public void click_on_document_library_link() {
		siteDocument.clickOnDocumentLibraryLink();

	}

	@When("^click on create button from document library page$")
	public void click_on_create_button_from_document_library_page() {
		siteDocument.clickOnCreateButton();
		siteDocument.clickOnFolder();

	}

	@When("^enter folder name as \"([^\"]*)\" folder$")
	public void enter_name_as(String arg1) {
		siteDocument.enterNewFolderName(arg1);
	}

	@When("^enter title as \"([^\"]*)\" title$")
	public void enter_title(String arg1) {
		siteDocument.enterNewFolderTitle(arg1);
	}

	@When("^enter description as \"([^\"]*)\" description$")
	public void enter_Description(String arg1) {
		siteDocument.enterNewFolderDescription(arg1);
	}

	@When("^click on Save button of folder creation$")
	public void click_on_Save_Button_Folder_Creation() {

		siteDocument.clickOnSaveButton();
		waitABit(2500);

	}

	@When("^click on folder name to navigate inside of folder$")
	public void click_on__Folder_Name() {
          waitABit(2500);
		siteDocument.clickOnFolderCreated();
		 waitABit(2500);

	}
	
	@Then("^folder will be created with name as \"([^\"]*)\"$")
	public void folder_will_be_created_with_name_as(String arg1) {
		Assert.assertEquals(arg1, siteDocument.fetchFolderName());
		siteDocument.clickOnFolderName();
	}

	@Then("^upload the new file$")
	public void upload_the_new_file() {

		siteDocument.clickOnUploadButton();
		siteDocument.clickOnSelectFileToUploadButton();
		waitABit(2500);
		try {
			siteDocument.select_File_From_Local_Directory();
			siteDocument.clickOnSaveButtonOnEditPropertyPage();
		} catch (Exception e) {
			getDriver().close();
		}

	}

	@Then("^download the uploaded file$")
	public void download_the_uploaded_file() {
		siteDocument.clickOnDownloadButton();
	}

	@Then("^delete document from document action tab$")
	public void delete_document_from_document_action_tab() {
		siteDocument.clickOnDeleteButton();
		siteDocument.clickOnDeleteButtonOnPopUp();

	}

}
