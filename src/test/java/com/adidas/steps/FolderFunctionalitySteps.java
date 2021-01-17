package com.alfresco.site.steps;

import com.objectslocation.PageReferences;

import cucumber.api.java.en.When;

public class FolderFunctionalitySteps extends PageReferences {

	@When("^delete it from dashboard if site already exist$")
	public void delete_it_from_dashboard_if_site_or_already_exist() throws Exception {
		waitABit(900);
		siteCreateDelete.deleteSiteFromDashboard();
		siteCreateDelete.clickOnHomePage();
		waitABit(2000);

	}

	@When("^click on checkbox of recently created folder$")
	public void click_on_checkbox_of_recently_created_folder() {

		folderOption.clickOnCheckbox();
	}

	@When("^click on selected item dropdown$")
	public void click_on_selected_item_dropdown() {
		waitABit(3000);
		folderOption.clickOnSelectItemsDropDown();
	}

	@When("^select copy option$")
	public void select_copy_option() {
		folderOption.clickOnCopyToButton();
	}

	@When("^copy it to other site location$")
	public void copy_it_to_other_site_location() {
		folderOption.clickOnSiteFromList();
		waitABit(3000);
		folderOption.clickOnCopyButton();
		waitABit(5000);
	}

	@When("^select download as zip option$")
	public void select_download_as_zip_option() {

		folderOption.clickOnDownloadAsZipButton();
		waitABit(5000);

	}

	@When("^select move To option$")
	public void select_move_To_option() {
		waitABit(2000);
		folderOption.clickOnMoveToButton();
	}

	@When("^move it to other site location$")
	public void move_it_to_other_site_location() {

		folderOption.clickOnSiteFromList();
		waitABit(3000);
		folderOption.clickOnMoveButton();
		waitABit(5000);
	}
	
	@When("^select delete option$")
	public void select_delete_option() {

		folderOption.clickOnDeleteOption();

	}
	
	@When("^click on delete button$")
	public void click_on_delete_button() {

		folderOption.clickOnDeleteButton();

	}

}
