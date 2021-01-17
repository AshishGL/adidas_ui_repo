Feature: Update file on alfresco and validate it on intranet
Background: 

	Given Open alfresco aplication in chrome browser 
	And logged into application 
	
@AlfrescoIntranetValidation 
Scenario: Verify that Update done on alfresco for knowledge express site is reflected on intranet 
	When navigate to site finder
	And search for the "Knowledge and Expertise Express" site 
	And navigate to Knowledge and Expertise Express site dashboard
	And click on Document library link 
	And click on Practice folder
	And click on application folder
	And click on NEW 181031 Intranet Search Terms.xlsx file
	And download the file
	And Update the downloaded file with header first column value to "Header name updated for automation3"
	And click on upload new version
	And upload the file
	And click on upload button
	And open intranet qa environment
	And click on consulting link
	And navigate to knowledge and Expertise express page
	And click on Application Strategy from Practice tab
	And download the file from intranet
	Then check value "Header name updated for automation3" updated on alfresco resflect on intranet
	When navigate to site finder
	And search for the "Knowledge and Expertise Express" site 
	And navigate to Knowledge and Expertise Express site dashboard
	And click on Document library link 
	And click on Practice folder
	And click on application folder
	And click on NEW 181031 Intranet Search Terms.xlsx file
	And click on upload new version
	And reset the file for next iteration

	
