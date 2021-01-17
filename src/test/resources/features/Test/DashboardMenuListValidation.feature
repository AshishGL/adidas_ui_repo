Feature: Verify dashboard header list 

Background: 
	Given Open alfresco aplication in chrome browser 
	And logged into application 
	
@Dashboard_header_list 
Scenario: Verify dashboard menu list 

	Then user see home link on the dashboard as "Home" 
	And user see my files link on the dashboard as "My Files" 
	And user see sites link on the dashboard as "Sites" 
	And user see tasks link on the dashboard as "Tasks" 
	And user see people link on the dashboard as "People" 
	
                