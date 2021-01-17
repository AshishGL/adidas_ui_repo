package com.alfresco.site.steps;

import com.objectslocation.PageReferences;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class PublicSiteCreateAndDeleteSteps extends PageReferences {

	@When("^click on create new site$")
	public void click_on_create_new_site() {
waitABit(5000);
		siteCreateDelete.clickOnCreateNewSites();
	}

	@When("^enter public site name as \"([^\"]*)\"$")
	public void enter_public_site_name_as(String name) {

		siteCreateDelete.enterSiteName(name);
	}

	@When("^enter private site name as \"([^\"]*)\"$")
	public void enter_private_site_name_as(String name1) {
		System.out.println("sceanrio 2");
		siteCreateDelete.enterSiteName(name1);
	}

	@When("^enter description as \"([^\"]*)\"$")
	public void enter_description_as(String description) {
		siteCreateDelete.enterSiteDescription(description);
	}

	@When("^Click on OK button$")
	public void click_on_OK_button() throws Exception {
		siteCreateDelete.clickOkButton();
		Thread.sleep(5000);
	}

	@Then("^new public site get create successfully with label as \"([^\"]*)\"$")
	public void new_public_site_get_create_successfully_with_label_as(String arg1) {

		Assert.assertEquals(arg1, siteCreateDelete.checkSiteName());
		waitABit(5000);
	}

	@Then("^new private site get create successfully with label as \"([^\"]*)\"$")
	public void new_private_site_get_create_successfully_with_label_as(String arg2) {

		Assert.assertEquals(arg2, siteCreateDelete.checkSiteName());
		waitABit(5000);
	}

	@Then("^click on delete button from dashboard my site section$")
	public void click_on_delete_button_from_dashboard_my_site_section() throws Exception {
		siteCreateDelete.clickOnHomePage();
		Thread.sleep(4000);
		siteCreateDelete.clickOnPublicSiteDeleteIcon();

	}

	@Then("^validate message for public site \"([^\"]*)\" on popup$")
	public void validate_message_on_popup(String arg1) {

		Assert.assertEquals(arg1, siteCreateDelete.checkdeleteSitePopUpMessage());

	}

	@Then("^validate message for private site \"([^\"]*)\" on popup$")
	public void validate_message_for_private_site_on_popup(String arg1) {
		Assert.assertEquals(arg1, siteCreateDelete.checkdeleteSitePopUpMessage());
		waitABit(5000);

	}

	@Then("^click on Delete button to delete Site$")
	public void click_on_Delete_button_to_delete_Site() {
		siteCreateDelete.clickOndeleteButtonOnPopUp();
		siteCreateDelete.clickOnDeleteButtonconfirmation();
		getDriver().close();
	}

	@When("^select Private as visibility type$")
	public void select_Private_as_visibility_type() {
		siteCreateDelete.clickOnPrivateVisibilityCheckBox();
	}

}
