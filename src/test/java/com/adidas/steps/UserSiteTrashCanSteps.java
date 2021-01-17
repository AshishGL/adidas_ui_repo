package com.alfresco.site.steps;

import com.objectslocation.PageReferences;

import cucumber.api.java.en.When;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class UserSiteTrashCanSteps extends PageReferences {

	@When("^navigate to userSite page$")
	public void navigate_To_UserSite_Page() throws Exception {
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		String username = variables.getProperty("username");
		String trashcanUrl = variables.getProperty("trashcanUrl");
		String usersite = trashcanUrl + username + "/user-sites";
		getDriver().get(usersite);

	}

	@When("^click on trashcan tab$")
	public void click_on_trashcan_tab() {
		usersite.clickOnTrashcanTab();
	}

	@When("^search for \"([^\"]*)\" site$")
	public void search_for_site(String arg1) {
		usersite.searchForSiteName(arg1);

	}

	@When("^delete site permanently if exist$")
	public void click_on_delete_button_to_remove_it_permanently() {
		usersite.deleteEntery();
		siteCreateDelete.clickOnHomePage();

	}

	@When("^click on the home page$")
	public void click_on_the_home_page() {
		waitABit(2500);
		siteCreateDelete.clickOnHomePage();
		getDriver().navigate().refresh();
		waitABit(5000);
	}

}
