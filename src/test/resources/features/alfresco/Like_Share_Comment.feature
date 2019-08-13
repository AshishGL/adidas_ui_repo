Feature: Create new article and check like ,share and comment functionality
Background: 

	Given Open hippo aplication in chrome browser 
	When click on content tab
	And click on hippointranet
	And click on gartner at work
	And click on new article from need to know dropdown 
	And create new article with name as "Automation QA article for testing"
	And click on Save button
	And fill all mandatory information
	And click on Save and close button
	And make document publish
	
	
Scenario: Verify that Like ,share and comment functionality working fine
	When open intranet qa environment 
	And click on need to know link
	And click on newly created article 
	Then check share functionality is working fine or not
	And check user is able to enter comment or not as "Automation_QA_Comment"
	And also check edit and delete comment functionality
	And check like button is woring fine or not
	And delete above created article from hippo
