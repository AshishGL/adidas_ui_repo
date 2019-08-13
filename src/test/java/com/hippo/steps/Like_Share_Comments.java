package com.hippo.steps;

import com.objectslocation.PageReferences;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Like_Share_Comments extends PageReferences{
	

@When("^click on need to know link$")
public void click_on_need_to_know_link() {
	createArticle.clickOnNeedToKnowLink();
}

@When("^click on newly created article$")
public void click_on_newly_created_article() {
	createArticle.clickOnnewlyCreatedArticleNameLink();
}

@Then("^check share functionality is working fine or not$")
public void check_share_functionality_is_working_fine_or_not() throws Exception {
	createArticle.clickAndVerifyShareButtonFunctionality();
	
  
}

@Then("^check user is able to enter comment or not as \"([^\"]*)\"$")
public void check_user_is_able_to_enter_comment_or_not(String enterComment) throws Exception {
	createArticle.clickOnComentButton();
	createArticle.enterComentsInTextBox(enterComment);
	createArticle.clickOnComentSubmitButton();
 
}

@Then("^also check edit and delete comment functionality$")
public void also_check_edit_and_delete_comment_functionality() {
	
	createArticle.clickOnComentEditButton();
	waitFor(2000);
	createArticle.enterComentInEditSection();
	waitFor(2000);
	createArticle.clickOnCommentSaveButton();
	waitFor(2000);
	createArticle.clickOnCommentDeleteButton();
	
}

@Then("^check like button is woring fine or not$")
public void check_like_button_is_woring_fine_or_not() throws Exception {
	
	createArticle.VerifyNumberOfLike();
}

@Then("^delete above created article from hippo$")
public void delete_above_created_article_from_hippo() {
	createArticle.deleteArticleFromHippo();
    
}


}
