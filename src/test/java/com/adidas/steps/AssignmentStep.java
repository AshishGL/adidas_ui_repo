package com.adidas.steps;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.objectslocation.PageReferences;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class AssignmentStep extends PageReferences  {


	
	@When("^click on \"([^\"]*)\" category$")
	public void click_on_category(String arg1) {
		assignment.selectcategory(arg1);
	}

	@When("^select \"([^\"]*)\" from laptop category$")
	public void select_from_laptop_category(String arg1) {
		assignment.selectLaptopModel01(arg1);
	}

	@When("^click on \"([^\"]*)\" button1$")
	public void click_on_button(String arg1) throws InterruptedException {
		Thread.sleep(5000);
		assignment.clickOnAddToCartButton(arg1);
		Thread.sleep(5000);
	}


	@When("^click on Accept button for confirmation of second order$")
	public void click_on_Accept_button_for_confirmation_of_second_order() {
		getDriver().switchTo().alert().accept();
		waitABit(4000);
		// Thread.sleep(5000);
	}

	@When("^Navigate to \"([^\"]*)\" page$")
	public void navigate_to_home_page(String arg) {
     assignment.clickOnHomeLink(arg);
	}
	
	@When("^click on \"([^\"]*)\" page from header$")
	public void click_on_page_from_header(String arg)  {
	   assignment.clickOnCartMenu(arg);
	}
	


	@When("^click on delete button for \"([^\"]*)\" from cart$")
	public void click_on_delete_button_for_from_cart(String arg1)  {
	   assignment.clickOnDeleteIcon();
	}

	@When("^Click on \"([^\"]*)\"$")
	public void click_on(String arg1)  {
		 
		 assignment.clickOnPlaceOrderButton(arg1);
	  
	}
	
	@When("^fill all mandatory details$")
	public void fill_all_mandatory_details() {
		assignment.enterName();
		assignment.enterCountry();
		assignment.enterCity();
		assignment.enterCreditCardNumber();
		assignment.enterMonth();
		assignment.enterYear();
		assignment.clickOnPurchaseButton();
	}

	@When("^Capture and log purchase Id and Amount$")
	public void capture_and_log_purchase_Id_and_Amount() {
assignment.fetchActualAmount();
assignment.fetchActualID();
	}

	@Then("^Verify purchase amount is equal to \"([^\"]*)\"$")
	public void verify_purchase_amount_is_equal_to(String arg1) {
		Assert.assertEquals(arg1, assignment.fetchActualAmount());
		
	}

	@Then("^click on ok button$")
	public void click_On_Ok_Button() {
     assignment.clickOnOkButton();
	}

}
