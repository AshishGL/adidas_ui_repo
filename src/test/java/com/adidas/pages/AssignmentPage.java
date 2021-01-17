package com.adidas.pages;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adidas.common.Keywords;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.By;

	public class AssignmentPage extends Keywords{


		@FindBy(xpath = "//input[@id='name']")
	private WebElementFacade nameTextField;
	
	@FindBy(xpath = "//input[@id='country']")
	private WebElementFacade countryTextField;

	@FindBy(xpath = "//input[@id='city']")
	private WebElementFacade cityTextField;

	@FindBy(xpath = "//input[@id='card']")
	private WebElementFacade creditCardTextField;
	
	@FindBy(xpath = "//input[@id='month']")
	private WebElementFacade monthTextField;
	
	@FindBy(xpath = "//input[@id='year']")
	private WebElementFacade yearTextField;
	
	@FindBy(xpath = "//button[contains(text(),'Purchase')]")
	private WebElementFacade purchaseButton;
	
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	private WebElementFacade okButton;

	@FindBy(xpath = "//tbody/tr[2]/td[4]/a[1]")
	private WebElementFacade deleteLink;
	
	
	@FindBy(css = "p.lead.text-muted ")
	private WebElementFacade amount;
	
	
	public String fetchActualAmount()
	{
		String []result=amount.getText().split("\\n");
		String  actualamount=result[1].split(":")[1].split(" ")[1];
		System.out.println("Actual amount value is:"+actualamount);
		return actualamount;
		
		
	}
	
	public void fetchActualID()
	{
		String []result=amount.getText().split("\\n");
		String ID=result[0].split(":")[1];
		System.out.println("Unique ID is :"+ID);
	
		
	}
	
	
	public void enterName()
	{
		typeInto(nameTextField, "Ankur Rana");
	}
	
	public void clickOnDeleteIcon() 
	{
	WebElement table=getDriver().findElement(By.id("tbodyid"));
    List<WebElement>row=table.findElements(By.tagName("tr"));
    for(int i=0;i<row.size();i++)
    {
    	List<WebElement>col=row.get(i).findElements(By.tagName("td"));
    	
    		if(col.get(1).getText().equals("Dell i7 8gb"))
    		{
    			col.get(3).findElement(By.tagName("a")).click();
    		}
    		
        
    }
	}
	
	public void enterCountry()
	{
		typeInto(countryTextField, "India");
	}
	
	public void enterCity()
	{
		typeInto(cityTextField, "Delhi");
	}
	
	public void enterCreditCardNumber()
	{
		typeInto(creditCardTextField, "1234567890");
	}
	
	public void enterMonth()
	{
		typeInto(monthTextField, "November");
	}
	
	public void enterYear()
	{
		typeInto(yearTextField, "2020");
	}
	
	public void clickOnPurchaseButton()
	{
		clickOn(purchaseButton);
	}
	
	
	public void clickOnOkButton()
	{
		clickOn(okButton);
	}
	
	public void selectcategory(String lap) 
	{ WebElement selectproduct= getDriver().findElement(By.xpath("//a[contains(text(),'"+lap+"')]"));
       clickOn(selectproduct);	
	}
	
	public void clickOnCartMenu(String cart)  
	{ WebElement clickOnCart= getDriver().findElement(By.xpath("//a[contains(text(),'"+cart+"')]"));
       clickOn(clickOnCart);
	waitABit(4000);
	}
	
	public void openApplication()
	{
		open();
		getDriver().manage().window().maximize();
	}
	
	

	public void selectLaptopModel01(String lap01) 
	{ WebElement selectLaptopModel= getDriver().findElement(By.xpath("//a[contains(text(),'"+lap01+"')]"));
      clickOn(selectLaptopModel);	
	}
	
	
	

	public void clickOnAddToCartButton(String addtoCart) 
	{ WebElement addtoCartButton= getDriver().findElement(By.xpath("//a[contains(text(),'"+addtoCart+"')]"));
      clickOn(addtoCartButton);	
	}
	

	public void clickOnHomeLink(String homeLink) 
	{ WebElement clickOnHomeLinkHeader= getDriver().findElement(By.xpath("//a[contains(text(),'"+homeLink+"')]"));
      clickOn(clickOnHomeLinkHeader);	
	}
	
public void selectLaptopModel02(String lap02) 
	{ WebElement selectLaptopModel= getDriver().findElement(By.xpath("//a[contains(text(),'"+lap02+"')]"));
      clickOn(selectLaptopModel);	
	}
	
	
	public void clickOnPlaceOrderButton(String placeOrder) 
	{waitABit(4000);
		WebElement clickOnPlaceOrderButton= getDriver().findElement(By.xpath("//button[contains(text(),'"+placeOrder+"')]"));
      clickOn(clickOnPlaceOrderButton);	
     
	}
	
	
	

	
	
	
	
	
	
	
	
	




}
