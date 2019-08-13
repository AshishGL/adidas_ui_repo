package com.alfresco.site.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;

import com.alfresco.common.Keywords;

import junit.framework.Assert;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class AlfrescoIntranetValidationPage extends Keywords {

	@FindBy(id = "template_x002e_site-finder_x002e_site-finder_x0023_default-term")
	private WebElementFacade searchArea;

	@FindBy(xpath = "//a[contains(text(),'Knowledge and Expertise Express')]")
	private WebElementFacade siteNavigation;

	@FindBy(xpath = "//a[contains(text(),'Practice Folder')]")
	private WebElementFacade practiceFolder;

	@FindBy(xpath = "//a[contains(text(),'Applications')]")
	private WebElementFacade applicationFolder;

	@FindBy(xpath = "//a[contains(text(),'NEW 181031 Intranet Search Terms.xlsx')]")
	private WebElementFacade filename;

	@FindBy(xpath = "//span[contains(text(),'Download')]")
	private WebElementFacade downloadlink;

	@FindBy(id = "template_x002e_site-finder_x002e_site-finder_x0023_default-button-button")
	private WebElementFacade searchButton;

	@FindBy(xpath = "//a[@title='Document Library']")
	private WebElementFacade documentlibrarylink;

	@FindBy(xpath = "//div[@id='onActionUploadNewVersion']//a[@title='Upload New Version']")
	private WebElementFacade uploadNewVersionLink;

	@FindBy(id = "template_x002e_dnd-upload_x002e_document-details_x0023_default-cancelOk-button-button")
	private WebElementFacade selectFilesToUploadButton;

	@FindBy(id = "template_x002e_dnd-upload_x002e_document-details_x0023_default-description-textarea")
	private WebElementFacade commentsSection;

	@FindBy(id = "template_x002e_dnd-upload_x002e_document-details_x0023_default-upload-button-button")
	private WebElementFacade uploadButton;

	@FindBy(id = "template_x002e_edit-metadata_x002e_add-metadata_x0023_default-form-submit-button")
	private WebElementFacade saveButtonToUploadFile;

	@FindBy(id = "consulting")
	private WebElementFacade consultingtab;

	@FindBy(xpath = "//a[contains(@id,'knowledge and expertise express')]")
	private WebElementFacade knowledgeExpress;

	@FindBy(xpath = "//a[contains(@class,'magic-link')][contains(text(),'Application Strategy')]")
	private WebElementFacade applicationStrategyTab;

	@FindBy(xpath = "//span[@id='PracticeApplicationStrategy']//a[contains(text(),'NEW 181031 Intranet Search Terms.xlsx')]")
	private WebElementFacade intranetfile;
	
	
	EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
	String username = variables.getProperty("username");
	String verificationfilename = variables.getProperty("fileNameToBeUploaded");
	String downloadLocation = variables.getProperty("downloadDrive");
	String downloadFolder = variables.getProperty("downloadfoldername");


	public void enterSiteName(String SiteName) {
		typeInto(searchArea, SiteName);
		clickOn(searchButton);
	}

	public void clickOnSiteName() {
		waitFor(siteNavigation);
		clickOn(siteNavigation);
		waitABit(3500);
	}

	public void clickOnDocumentlibrarylink() {
		waitABit(4000);
		waitFor(documentlibrarylink);
		clickOn(documentlibrarylink);
		waitABit(3500);
	}

	public void clickOnpracticeFolder() {
		waitABit(3000);
		waitFor(practiceFolder);
		clickOn(practiceFolder);
	}

	public void clickOnapplicationFolder() {
		waitFor(applicationFolder);
		clickOn(applicationFolder);
	}

	public void clickOnfileName() {
		waitFor(filename);
		clickOn(filename);
	}

	
	public void clickOnDownloadLink() {
		File file = new File(downloadLocation + username + downloadFolder + verificationfilename);
		if (file.delete())
			System.out.println("file deleted");
		else
			System.out.println("not");
		waitABit(3000);

		waitFor(downloadlink);
		clickOn(downloadlink);
		waitABit(4000);
	}

	public void updateValueInFile(String expected_value) throws Exception {
		File f1 = new File(downloadLocation + username + downloadFolder + verificationfilename);
		FileInputStream fis1 = new FileInputStream(f1);
		XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
		XSSFSheet sheet1 = wb1.getSheetAt(0);
		sheet1.getRow(0).createCell(0).setCellValue(expected_value);
		FileOutputStream fout = new FileOutputStream(f1);
		wb1.write(fout);
		fout.close();
		System.out.println("value get updated successfully");

	}

	public void clickOnuploadNewVersionLink() {
		waitABit(1500);
		waitFor(uploadNewVersionLink);
		clickOn(uploadNewVersionLink);
	}

	public void clickOnSelectFilesToUploadButton() throws Exception {
		waitABit(5000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		waitABit(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		waitABit(500);
	}

	public void uploadFileFromLocalDrive() throws Exception {
		waitABit(500);
		Robot robot = new Robot();
		// c:users\downloads\NEW 181031 Intranet Search Terms.xlsx
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_SEMICOLON);
		robot.keyRelease(KeyEvent.VK_SEMICOLON);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_BACK_SLASH);
		robot.keyRelease(KeyEvent.VK_BACK_SLASH);
		robot.keyPress(KeyEvent.VK_U);
		robot.keyRelease(KeyEvent.VK_U);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		robot.keyPress(KeyEvent.VK_BACK_SLASH);
		robot.keyRelease(KeyEvent.VK_BACK_SLASH);
        waitABit(1500);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection stringSelection = new StringSelection(username);

		clipboard.setContents(stringSelection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		waitABit(300);
		robot.keyPress(KeyEvent.VK_BACK_SLASH);
		robot.keyRelease(KeyEvent.VK_BACK_SLASH);
		robot.keyPress(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_D);
		robot.keyPress(KeyEvent.VK_O);
		robot.keyRelease(KeyEvent.VK_O);
		robot.keyPress(KeyEvent.VK_W);
		robot.keyRelease(KeyEvent.VK_W);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_N);
		robot.keyPress(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_L);
		robot.keyPress(KeyEvent.VK_O);
		robot.keyRelease(KeyEvent.VK_O);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyPress(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_D);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		robot.keyPress(KeyEvent.VK_BACK_SLASH);
		robot.keyRelease(KeyEvent.VK_BACK_SLASH);
		

		Clipboard clipboard4 = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection stringSelection4 = new StringSelection(verificationfilename);

		clipboard4.setContents(stringSelection4, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		waitABit(200);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void clickOnUploadButton() {
		clickOn(uploadButton);
	}

	public void enterComments() {
		waitABit(1500);
		typeInto(commentsSection, "this change is done via automation script");
		waitABit(5000);

	}

	public void clickOnSaveButtonToUploadFile() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,2000)");

		waitABit(2000);
		clickOn(saveButtonToUploadFile);
	}

	public void clickOnConsultingTab() {
		waitFor(consultingtab);
		clickOn(consultingtab);
	}

	public void clickOnKnowledgeExpressLink() {
		waitFor(knowledgeExpress);
		clickOn(knowledgeExpress);
	}

	public void clickOnApplicationStrategyTab() {
		waitFor(applicationStrategyTab);
		clickOn(applicationStrategyTab);
	}

	public void downloadFileFromIntranet() {

		File file = new File(downloadLocation + username + downloadFolder + verificationfilename);
		if (file.delete())
			System.out.println("file deleted");
		else
			System.out.println("not");
		waitABit(500);
/*		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1700)");
		System.out.println("waiting for 2mins so that, data will be uploaded on intranet site");
	*/
		waitABit(90000);

		waitFor(intranetfile);
		clickOn(intranetfile);
		waitABit(3000);

	}

	public void fetchUpdatedValueFromFile(String expected_value) throws Exception {

		File f1 = new File(downloadLocation + username + downloadFolder + verificationfilename);
		FileInputStream fis1 = new FileInputStream(f1);
		XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
		XSSFSheet sheet1 = wb1.getSheetAt(0);
		String actual_value = sheet1.getRow(0).getCell(0).getStringCellValue();

		Assert.assertEquals(expected_value, actual_value);
		waitABit(3000);
		clearTestData();

	}
	
	public void clearTestData()
	{
		File file = new File(downloadLocation + username + downloadFolder + verificationfilename);
		if (file.delete())
			System.out.println("file deleted");
		else
			System.out.println("not");
		waitABit(500);
	}
	
	public void resetData() throws Exception
	{
		Robot robot = new Robot();
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		String filename = variables.getProperty("fileNameToBeUploaded");		
		File file1 = new File("src/test/resources/FileToBeUpload/"+filename);
        String path=file1.getAbsolutePath();
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection4=new StringSelection(path);
		clipboard.setContents(stringSelection4, null);

		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		waitABit(200);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		waitABit(8000);
	}
}
