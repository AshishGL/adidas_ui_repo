package com.hippo.steps;

import com.objectslocation.PageReferences;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Hippo_Article_Creation_Background extends PageReferences {


@Given("^Open hippo aplication in chrome browser$")
public void open_hippo_aplication_in_chrome_browser() throws Exception {
   
	createArticle.open_hippo_cms_application();
}
@When("^click on content tab$")
public void click_on_content_tab() {
    createArticle.clickOnContentTab();
}

@When("^click on hippointranet$")
public void click_on_hippointranet() throws Exception {
    createArticle.clickOnhippoIntranet();
}

@When("^click on gartner at work$")
public void click_on_gartner_at_work() {
	createArticle.clickOnGartnerAtWork();
}

@When("^click on new article from need to know dropdown$")
public void click_on_article_from_need_to_know_dropdown() throws Exception {
  
	createArticle.expandIcon();
	createArticle.select_article_from_list();
}

@When("^create new article with name as \"([^\"]*)\"$")
public void create_new_article_with_name_as(String arg1) throws Exception {
	createArticle.enterArticleName(arg1);
	
	
	
}

@When("^click on Save button$")
public void click_on_Save_button() throws Exception {

	createArticle.clickOnPopUpOkButton();
	Thread.sleep(17000);
    
}

@When("^fill all mandatory information$")
public void fill_all_mandatory_information() throws Exception {
	createArticle.enterArticleTitle();
	Thread.sleep(4000);
	createArticle.pageScrollDown();
	Thread.sleep(4000);
	
    
}

@When("^click on Save and close button$")
public void click_on_Save_and_close_button() {

	createArticle.clickOnSaveAndCloseButton();
}

@When("^make document publish$")
public void make_document_publish() {

	createArticle.clickOnpublicationButton();
	createArticle.clickOnpublishButton();
}

	
}
