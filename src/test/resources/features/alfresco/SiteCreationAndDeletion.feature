Feature: Site creation validation and deletion with visibility as public and Private 
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
	
	
@Public_Site_Creation_And_Deletion 
Scenario: Create new public site  validate its name and then delete it 
	When navigate to userSite page 
	And click on trashcan tab 
	And search for "01Automation-Site" site 
	And delete site permanently if exist 
	And click on create new site 
	And enter public site name as "01Automation-Site" 
	And enter description as "Welcome to the QA world Site" 
	And Click on OK button 
	Then new public site get create successfully with label as "01Automation-Site" 
	And click on delete button from dashboard my site section 
	And validate message for public site "Are you sure you want to remove the site ''01Automation-Site''?" on popup 
	And click on Delete button to delete Site 
	
	
@Private_Site_Creation_And_Deletion 
Scenario: Create new private site validate its name and then delete it 

	When navigate to userSite page 
	And click on trashcan tab 
	And search for "02Automation-Site" site 
	And delete site permanently if exist 
	And click on create new site 
	And enter private site name as "02Automation-Site" 
	And enter description as "Welcome to the QA world Site" 
	And select Private as visibility type 
	And Click on OK button 
	Then new private site get create successfully with label as "02Automation-Site" 
	And click on delete button from dashboard my site section 
	And validate message for private site "Are you sure you want to remove the site ''02Automation-Site''?" on popup 
	And click on Delete button to delete Site 
