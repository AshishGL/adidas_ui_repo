package com.alfresco.site.steps;

import com.objectslocation.PageReferences;

import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class DashboardHeaderListValidationSteps extends PageReferences {

	@Then("^user see home link on the dashboard as \"([^\"]*)\"$")
	public void user_see_home_link_on_the_dashboard_as(String arg1) {
		Assert.assertEquals(arg1, dashBoardMenu.fetchHomePageTitle());

	}

	@Then("^user see my files link on the dashboard as \"([^\"]*)\"$")
	public void user_see_my_files_link_on_the_dashboard_as(String arg1) {
		Assert.assertEquals(arg1, dashBoardMenu.fetchMyFilesTitle());
	}

	@Then("^user see sites link on the dashboard as \"([^\"]*)\"$")
	public void user_see_sites_link_on_the_dashboard_as(String arg1) {
		Assert.assertEquals(arg1, dashBoardMenu.fetchSitesTitle());
	}

	@Then("^user see tasks link on the dashboard as \"([^\"]*)\"$")
	public void user_see_tasks_link_on_the_dashboard_as(String arg1) {
		Assert.assertEquals(arg1, dashBoardMenu.fetchTasksTitle());

	}

	@Then("^user see people link on the dashboard as \"([^\"]*)\"$")
	public void user_see_people_link_on_the_dashboard_as(String arg1) {
		Assert.assertEquals(arg1, dashBoardMenu.fetchPeopleTitle());

	}

}
