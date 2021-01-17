package com.alfresco.site.steps;

import com.objectslocation.PageReferences;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class AlfrescoIntranetValidationSteps extends PageReferences {
	
	@When("^navigate to site finder$")
	public void navigate_to_site_finder() {
		
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		String siteFinderUrl = variables.getProperty("siteFinderUrl");
		getDriver().get(siteFinderUrl);
	}

	@When("^search for the \"([^\"]*)\" site$")
	public void search_for_the_site(String arg1) {
		alfrescoIntranetvalidation.enterSiteName(arg1);
	}

	@When("^navigate to Knowledge and Expertise Express site dashboard$")
	public void navigate_to_Knowledge_and_Expertise_Express_site_dashboard() {
		alfrescoIntranetvalidation.clickOnSiteName();
	}
	
	@When("^click on Document library link$")
	public void click_on_Document_library_link() {
		alfrescoIntranetvalidation.clickOnDocumentlibrarylink();

	}
	@When("^click on Practice folder$")
	public void click_on_Practice_folder() {
		alfrescoIntranetvalidation.clickOnpracticeFolder();
	}

	@When("^click on application folder$")
	public void click_on_application_folder() {
		alfrescoIntranetvalidation.clickOnapplicationFolder();
	}

	@When("^click on NEW 181031 Intranet Search Terms.xlsx file$")
	public void click_on_file() {
		alfrescoIntranetvalidation.clickOnfileName();
	}

	@When("^download the file$")
	public void download_the_file() {
		alfrescoIntranetvalidation.clickOnDownloadLink();
	}

	@When("^Update the downloaded file with header first column value to \"([^\"]*)\"$")
	public void update_the_downloaded_file_with_header_first_column_value_to(String arg1) {
		try {
			alfrescoIntranetvalidation.updateValueInFile(arg1);
		} catch (Exception e) {
			System.out.println("Value update having some Code problem");
			getDriver().close();
		}
	}

	@When("^click on upload new version$")
	public void click_on_upload_new_version() {
		waitABit(3000);
		alfrescoIntranetvalidation.clickOnuploadNewVersionLink();
	}

	@When("^upload the file$")
	public void upload_the_file() {
		try {
			
			alfrescoIntranetvalidation.clickOnSelectFilesToUploadButton();
			alfrescoIntranetvalidation.uploadFileFromLocalDrive();
			waitABit(3000);
			
		
		} catch (Exception e) {
			System.out.println("Upload functionality is not working");
			e.printStackTrace();
		}
	}

	@When("^click on upload button$")
	public void click_on_upload_button() {
		
    	alfrescoIntranetvalidation.enterComments();
		alfrescoIntranetvalidation.clickOnUploadButton();
		waitABit(5000);
		alfrescoIntranetvalidation.clickOnSaveButtonToUploadFile();
		System.out.println("file uploaded successfully");
		waitABit(2500);
	}

	@When("^open intranet qa environment$")
	public void open_intranet_qa_environment() {
		
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		String intranetUrl = variables.getProperty("intranetUrl");
		getDriver().get(intranetUrl);
		
	}

	@When("^click on consulting link$")
	public void click_on_consulting_link() {
		
		alfrescoIntranetvalidation.clickOnConsultingTab();
	}

	@When("^navigate to knowledge and Expertise express page$")
	public void navigate_to_knowledge_and_Expertise_express_page() {
		
		alfrescoIntranetvalidation.clickOnKnowledgeExpressLink();
	}

	@When("^click on Application Strategy from Practice tab$")
	public void click_on_Application_Strategy_from_Practice_tab() {
		alfrescoIntranetvalidation.clickOnApplicationStrategyTab();
}
	
	@When("^download the file from intranet$")
	public void download_the_file_from_intranet() {
		
		alfrescoIntranetvalidation.downloadFileFromIntranet();
		System.out.println("File get downloaded successfully!!");
	}

	@Then("^check value \"([^\"]*)\" updated on alfresco resflect on intranet$")
	public void compareAlfrescoValueWithIntranetValue(String arg1)  {
		
		try {
			alfrescoIntranetvalidation.fetchUpdatedValueFromFile(arg1);
		} catch (Exception e) {
			System.out.println("there is some problem while fetching data");
		//	getDriver().close();
		}
	   
	}
	
	@When("^reset the file for next iteration$")
	public void resetDataForNextIteration() throws Exception {
		waitABit(5000);
		alfrescoIntranetvalidation.clickOnSelectFilesToUploadButton();
		alfrescoIntranetvalidation.resetData();
		alfrescoIntranetvalidation.enterComments();
		alfrescoIntranetvalidation.clickOnUploadButton();
		waitABit(5000);
		alfrescoIntranetvalidation.clickOnSaveButtonToUploadFile();
		System.out.println("file uploaded successfully");
		waitABit(5000);
	}

	


}
