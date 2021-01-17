Feature: Create folder and upload file under that folder of newly created site and delete it 

Background: 

	Given Open alfresco aplication in chrome browser 
	And logged into application 
	When delete it from dashboard if site already exist 
	And navigate to userSite page 
	And click on trashcan tab 
	And search for "01Automation-Site" site 
	And delete site permanently if exist 
	And navigate to userSite page 
	And click on trashcan tab 
	And search for "02Automation-Site" site 
	And delete site permanently if exist 
	
@Site_Document_Upload_Download_delete 
Scenario: Upload , Download and Delete a document under document library of newly created public Site 


	When click on create new site 
	And enter public site name as "01Automation-Site" 
	And enter description as "Welcome to the QA world Site" 
	And Click on OK button 
	And click on document library link 
	And click on create button from document library page 
	And enter folder name as "automation document" folder 
	And enter title as "automation title" title 
	And enter description as "welcome to automation document" description 
	And click on Save button of folder creation 
	Then folder will be created with name as "automation document" 
	And upload the new file 
	And download the uploaded file 
	And delete document from document action tab 
	And click on delete button from dashboard my site section 
	And validate message for public site "Are you sure you want to remove the site ''01Automation-Site''?" on popup 
	And click on Delete button to delete Site