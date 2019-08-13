package com.hippo.pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.alfresco.common.Keywords;

import junit.framework.Assert;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import practice.WaitHelper;

public class ArticlePage extends Keywords {

	@FindBy(xpath = "//span[contains(text(),'Content')]")
	private WebElementFacade contenttab;

	@FindBy(xpath = "//a[contains(@title,'hippointranet')]")
	private WebElementFacade hippoIntranet;

	@FindBy(xpath = "//span[contains(text(),'gaw')]")
	private WebElementFacade gaw;

	@FindBy(xpath = "//a[contains(@title,'Need to Know')]")
	private WebElementFacade needToKnow;

	@FindBy(xpath = "//span[contains(text(),'Edit allowed content...')]")
	private WebElementFacade EditAllowedContent;

	@FindBy(xpath = "//select[contains(@name,'query-selection')]")
	private WebElementFacade templateDropdownList;

	@FindBy(xpath = "//input[contains(@type,'submit') and contains(@value,'OK')]")
	private WebElementFacade okButton;

	@FindBy(xpath = "//input[contains(@class,'hippo-form-input')]")
	private WebElementFacade articleName;

	@FindBy(xpath = "//input[contains(@value,'OK')]")
	private WebElementFacade articleOkButton;

	@FindBy(xpath = "//div[@id='id8cc9bc09e95d260d8fe4b541d54473fa']//div[@class='hippo-editor-field-value-container']/input")
	private WebElementFacade articleTitleName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h3[1]")
	private WebElementFacade titleHeader;

	@FindBy(xpath = "//span[contains(@title,'Save & Close')]")
	private WebElementFacade saveCloseButton;

	@FindBy(xpath = "//span[contains(text(),'Publication')]")
	private WebElementFacade publicationButton;

	@FindBy(xpath = "//span[contains(@title,'Publish')]")
	private WebElementFacade publishButton;

	@FindBy(xpath = "//a[contains(@data-href,'https://intranetqa.gartner.com/gaw/archive?regions=&archive=need-to-know&nodeType=hippointranet%3AannouncementDocument&folder=need-to-know')]")
	private WebElementFacade needToKnowLink;

	@FindBy(xpath = "//a[contains(text(),'titleName1')]")
	private WebElementFacade newlyCreatedArticleName;

	@FindBy(xpath = "//img[contains(@title,'Share')]")
	private WebElementFacade shareButton;

	@FindBy(xpath = "//input[contains(@placeholder,'Add name or email')]")
	private WebElementFacade employeeEmailId;

	@FindBy(xpath = "//*[@id=\"emailsListBox\"]/div[2]")
	private WebElementFacade employeeIdFromList;

	@FindBy(xpath = "//textarea[contains(@id,'messageTextArea')]")
	private WebElementFacade enterComments;

	@FindBy(xpath = "//button[contains(@id,'shareSend')]")
	private WebElementFacade shareMailSendButton;

	@FindBy(xpath = "//img[contains(@title,'Comment')]")
	private WebElementFacade commentButton;

	@FindBy(xpath = "//textarea[contains(@id,'commentTextArea')]")
	private WebElementFacade commenttextArea;

	@FindBy(id = "commentSubmit")
	private WebElementFacade commentSubmitButton;

	@FindBy(xpath = "//*[@id=\"commentBox\"]/div/div[2]/div[2]/span[1]/i")
	private WebElementFacade commentEditButton;

	@FindBy(xpath = "//*[@id=\"commentBox\"]/div/div[2]/div[1]/textarea")
	private WebElementFacade EditCommentTextArea;

	@FindBy(xpath = "//*[@id=\"commentBox\"]/div/div[2]/div[2]/button/i")
	private WebElementFacade commentSaveButton;

	@FindBy(xpath = "//*[@id=\"commentBox\"]/div/div[2]/div[2]/span[2]")
	private WebElementFacade commentDeleteButton;

	@FindBy(xpath = "//img[contains(@title,'Like')]")
	private WebElementFacade likeButton;

	@FindBy(xpath = "//*[@id=\"likesCount\"]")
	private WebElementFacade likecount;

	@FindBy(xpath = "//span[contains(@title,'Take offline...')]")
	private WebElementFacade takeOfflineButton;

	@FindBy(xpath = "//input[contains(@value,'OK')]")
	private WebElementFacade offlineOkButton;

	@FindBy(xpath = "//a[contains(@class,'hippo-toolbar-section-button menu-item-inactive')]/span[contains(text(),'Document')]")
	private WebElementFacade documentDropDown;

	@FindBy(xpath = "//a[contains(@class,'hippo-toolbar-menu-item-button')]/span[2]/span[contains(text(),'Delete...')]")
	private WebElementFacade deleteButton;
	
	@FindBy(xpath = "//span[contains(@title,'Automation QA article for testing')]")
	private WebElementFacade articleExistanceCheck;
	 

	String newlyCreatedArticleHippoUrl = "https://intranetqa.gartner.com/cms/?1&path=/content/documents/hippointranet/gaw/need-to-know/automation-qa-article-for-testing";

	public void deleteArticleFromHippo() {
		getDriver().get(newlyCreatedArticleHippoUrl);
		waitABit(10000);
		clickOnpublicationButton();
		clickOn(takeOfflineButton);
		waitFor(offlineOkButton);
		clickOn(offlineOkButton);
		waitABit(5000);
		clickOn(documentDropDown);
		clickOn(deleteButton);
		clickOn(offlineOkButton);
		waitABit(5000);
	}

	public void clickOnContentTab() {
		clickOn(contenttab);
	}

	public void clickOnNeedToKnowTab() {

		clickOn(needToKnow);
	}

	public void clickOnhippoIntranet() throws Exception {

		WebDriverWait wait = new WebDriverWait(getDriver(), 55);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@title,'hippointranet')]")));

		hippoIntranet.click();

	}

	public void clickOnGartnerAtWork() {

		clickOn(gaw);
	}

	public void expandIcon() throws Exception {
waitABit(1000);
clickOnNeedToKnowTab();
waitABit(2000);
if(articleExistanceCheck.isCurrentlyVisible())
{
clickOn(articleExistanceCheck);
waitABit(5000);
clickOnpublicationButton();
Thread.sleep(3000);
 if(takeOfflineButton.isCurrentlyEnabled())
 {
clickOn(takeOfflineButton);
waitFor(offlineOkButton);
clickOn(offlineOkButton);
waitABit(5000);
 }
 clickOn(documentDropDown);
clickOn(deleteButton);
clickOn(offlineOkButton);
waitABit(5000);
 }


		Actions action = new Actions(getDriver());

		WaitHelper waithelp = new WaitHelper(getDriver());
		action.moveToElement(needToKnow).build().perform();
		action.click(waithelp.waitForElement(By.xpath("//a[contains(@title,'Need to Know')]/following::a[1]"), 25, 500))
				.build().perform();
		waitABit(4000);
	}

	public void select_article_from_list() throws Exception {

		String data = "Add new article document...";
		WebElement ul = getDriver().findElement(By.xpath("//ul[@class='hippo-toolbar-menu-item']"));
//		Thread.sleep(3000);
		waitABit(3000);
		List<WebElement> allOptions = ul.findElements(By.tagName("li"));
		for (WebElement selectLi : allOptions) {
			String actual_value = selectLi.getText();
			System.out.println("values are :" + actual_value);

			if (actual_value.equalsIgnoreCase(data)) {
				System.out.println("required value is: " + actual_value);
				selectLi.click();
			//	Thread.sleep(7000);
				waitABit(2500);
				break;
			}
			// selectLi.click();
			/*
			 * else { System.out.println("keeps searching"); //edit(); }
			 */
		}

		// edit();

	}

	private void edit() throws Exception {
		EditAllowedContent.click();
//		Thread.sleep(4000);
		waitABit(4000);
		String data1 = "Add new article document... (new-article-document)";
		WebElement ul1 = getDriver().findElement(By.xpath("//div[@class='query-folder-workflow-list-wrapper']"));
	//	Thread.sleep(3000);
		waitABit(4000);
		List<WebElement> allOptions1 = ul1.findElements(By.tagName("div"));
		for (WebElement selectLi1 : allOptions1) {
			String actual_value1 = selectLi1.getText();
			{
				System.out.println("PopUp value are: " + actual_value1);
				//Thread.sleep(300);
				waitABit(400);
				if (actual_value1.equals(data1)) {
					System.out.println(actual_value1);
					System.out.println("value found");
					okButton.click();
					waitABit(4000);
				} else {

					waitABit(4000);
					Select drpCountry = new Select(
							getDriver().findElement(By.xpath("//select[contains(@name,'query-selection')]")));
					waitABit(4000);
					drpCountry.selectByValue("new-article-document");
					waitABit(4000);
					clickOn(okButton);
					waitABit(4000);
				}

			}
		}

		waitABit(4000);
		clickOnNeedToKnowTab();
		expandIcon();
		select_article_from_list();
	}

	public void enterArticleName(String name) throws Exception {
		typeInto(articleName, name);
	
		waitABit(2500);
	}

	public void clickOnPopUpOkButton() {
		clickOn(articleOkButton);
	}

	public void enterArticleTitle() throws Exception {

		WebDriverWait wait1 = new WebDriverWait(getDriver(), 55);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h3[1]")));

		titleHeader.click();
		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_TAB);

		WebDriverWait wait = new WebDriverWait(getDriver(), 55);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='id8cc9bc09e95d260d8fe4b541d54473fa']//div[@class='hippo-editor-field-value-container']/input")));
		waitForPresenceOf(
				"//div[@id='id8cc9bc09e95d260d8fe4b541d54473fa']//div[@class='hippo-editor-field-value-container']/input");
		typeInto(articleTitleName, "titleName1");
		System.out.println("title get entered");

	}

	public void pageScrollDown() throws Exception {

		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		rob.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		rob.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		rob.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		rob.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		rob.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		rob.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		rob.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		rob.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		String path = "Dummy text";
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection stringSelection4 = new StringSelection(path);
		clipboard.setContents(stringSelection4, null);

		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		waitABit(2000);
	}

	public void clickOnSaveAndCloseButton() {
		clickOn(saveCloseButton);
	}

	public void clickOnpublicationButton() {
		clickOn(publicationButton);
	}

	public void clickOnpublishButton() {
		clickOn(publishButton);
	}

	public void clickOnNeedToKnowLink() {
		clickOn(needToKnowLink);
	}

	public void clickOnnewlyCreatedArticleNameLink() {
		clickOn(newlyCreatedArticleName);
	}

	public void clickAndVerifyShareButtonFunctionality() throws Exception {
		System.out.println("Is Share button is visible? :" + shareButton.isDisplayed());
		Assert.assertEquals(true, shareButton.isDisplayed());
		clickOn(shareButton);
		typeInto(employeeEmailId, "ankur.rana@gartner.com ");
	
		waitABit(4000);
		clickOn(employeeIdFromList);
		typeInto(enterComments, "this mail is only for automation testing purpose ONLY");
		clickOn(shareMailSendButton);
		waitABit(4000);

	}

	public void clickOnComentButton() {
		Assert.assertEquals(true, commentButton.isDisplayed());
		clickOn(commentButton);
	}

	public void enterComentsInTextBox(String comment) {
		typeInto(commenttextArea, comment);
	}

	public void clickOnComentSubmitButton() {
		clickOn(commentSubmitButton);
	}

	public void clickOnComentEditButton() {
		clickOn(commentEditButton);

	}

	public void enterComentInEditSection() {
		typeInto(EditCommentTextArea, "Updated Comment value");
	}

	public void clickOnCommentSaveButton() {
		clickOn(commentSaveButton);
	}

	public void clickOnCommentDeleteButton() {
		clickOn(commentDeleteButton);
	
	}

	public void VerifyNumberOfLike() {
		waitABit(2000);
		Actions action = new Actions(getDriver());
		action.sendKeys(Keys.PAGE_UP).build().perform();
		clickOn(likeButton);
		String finialnumber = likecount.getText();
		int finallikecount = Integer.parseInt(finialnumber);
		System.out.println("like count is after click is :" + finallikecount);

		if (finallikecount > 0) {
			System.out.println("LIKE FUNCTIONALITY IS WORKING FINE");
		}
		waitABit(2000);
		clickOn(likeButton);

	}

	public void open_hippo_cms_application() {
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		String hippoUrl = variables.getProperty("hippoUrl");
		getDriver().get(hippoUrl);
		getDriver().navigate().refresh();
		getDriver().manage().window().maximize();
	
	}

}
