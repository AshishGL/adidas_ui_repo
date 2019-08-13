Feature: Site folder move download and copy functionality 
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
	
@downloadMoveCopy 
Scenario: Create new public site along with one folder and download its folder then copy it to other folder and move it other site and delete functionality

	When click on create new site 
	And enter public site name as "01Automation-Site" 
	And enter description as "Welcome to the QA world Site" 
	And Click on OK button 
	And click on document library link 
	And click on create button from document library page 
	And enter folder name as "automation document1" folder 
	And enter title as "automation title" title 
	And enter description as "welcome to automation document" description 
	And click on Save button of folder creation 
	And click on folder name to navigate inside of folder
	And upload the new file 
	And click on the home page 
	And click on create new site 
	And enter public site name as "02Automation-Site" 
	And enter description as "Welcome to the QA world Site" 
	And Click on OK button 
	And click on document library link 
	And click on create button from document library page 
	And enter folder name as "automation document2" folder 
	And enter title as "automation title" title 
	And enter description as "welcome to automation document" description 
	And click on Save button of folder creation 
	And click on folder name to navigate inside of folder
	And upload the new file 
	And click on Document library link
	And click on checkbox of recently created folder 
	And click on selected item dropdown 
	And select move To option 
	And move it to other site location 
	And click on create button from document library page 
	And enter folder name as "automation document3" folder 
	And enter title as "automation title" title 
	And enter description as "welcome to automation document" description 
	And click on Save button of folder creation 
#	And click on folder name to navigate inside of folder
#	And upload the new file 
#	And click on Document library link
	And click on checkbox of recently created folder 
	And click on selected item dropdown 
	And select copy option 
	And copy it to other site location 
	And click on checkbox of recently created folder 
	And click on selected item dropdown 
	And select download as zip option 
	And click on selected item dropdown
	And select delete option 
	And click on delete button
	
	