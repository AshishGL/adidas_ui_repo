Feature: Verify DEMO ONLINE SHOP

Background:
Given Open DemoBlaze application in chrome browser 
	
Scenario:
When click on "Laptop" category
And select "Sony vaio i5" from laptop category
And click on "Add to cart" button1
And click on Accept button for confirmation of second order
And Navigate to "Home " page
And click on "Laptop" category
And select "Dell i7 8gb" from laptop category
And click on "Add to cart" button1
And click on Accept button for confirmation of second order
And click on "Cart" page from header
And click on delete button for "Dell i7 8gb" from cart
And Capture and log purchase Id and Amount
Then Verify purchase amount is equal to "700"
When Click on "Place Order"
And fill all mandatory details

