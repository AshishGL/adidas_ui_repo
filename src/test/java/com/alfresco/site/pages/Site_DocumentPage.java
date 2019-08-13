package com.alfresco.site.pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.support.FindBy;

import com.alfresco.common.Keywords;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class Site_DocumentPage extends Keywords {

	@FindBy(xpath = "//span[contains(@id,'HEADER_SITE_DOCUMENTLIBRARY_text')]")
	private WebElementFacade documentLibrary;

	@FindBy(id = "template_x002e_documentlist_v2_x002e_documentlibrary_x0023_default-createContent-button-button")
	private WebElementFacade create_Button;

	@FindBy(xpath = "//span[@class='folder-file']")
	private WebElementFacade new_Folder;

	@FindBy(id = "template_x002e_documentlist_v2_x002e_documentlibrary_x0023_default-createFolder_prop_cm_name")
	private WebElementFacade folder_Name;

	@FindBy(id = "template_x002e_documentlist_v2_x002e_documentlibrary_x0023_default-createFolder_prop_cm_title")
	private WebElementFacade folder_Title;

	@FindBy(id = "template_x002e_documentlist_v2_x002e_documentlibrary_x0023_default-createFolder_prop_cm_description")
	private WebElementFacade folder_Description;

	@FindBy(id = "template_x002e_documentlist_v2_x002e_documentlibrary_x0023_default-createFolder-form-submit-button")
	private WebElementFacade save_Button;

	@FindBy(xpath = "//a[contains(text(),'automation document')]")
	private WebElementFacade temp_Folder;

	@FindBy(id = "template_x002e_documentlist_v2_x002e_documentlibrary_x0023_default-fileUpload-button-button")
	private WebElementFacade upload_Button;

	@FindBy(id = "template_x002e_dnd-upload_x002e_documentlibrary_x0023_default-file-selection-button-overlay")
	private WebElementFacade select_File_to_Upload_Button;

	@FindBy(id = "template_x002e_edit-metadata_x002e_add-metadata_x0023_default-form-submit-button")
	private WebElementFacade save_Button_Edit_Property;

	@FindBy(xpath = "//span[contains(text(),'Download')]")
	private WebElementFacade download_Button;

	@FindBy(xpath = "//span[contains(text(),'Delete Document')]")
	private WebElementFacade delete_Button;

	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	private WebElementFacade delete_Button_On_PopUp;

	@FindBy(xpath = "/html[1]/body[1]/div[9]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[12]/table[1]/tbody[2]/tr[1]/td[4]/div[1]/h3[1]/span[2]/a[1]")
	private WebElementFacade folderCreated;

	
	public void clickOnFolderCreated() {
	//	folderCreated.waitUntilVisible();
		clickOn(folderCreated);
	}

	
	public void clickOnDocumentLibraryLink() {
		clickOn(documentLibrary);
		waitABit(5000);
	}

	public void clickOnCreateButton() {
		waitABit(3000);
		waitFor(create_Button);
		clickOn(create_Button);
	
	}

	public void clickOnFolder() {
		clickOn(new_Folder);
	//	waitABit(2000);
	}

	public void enterNewFolderName(String folderName) {
		typeInto(folder_Name, folderName);
	}

	public void enterNewFolderTitle(String folderTitle) {
		typeInto(folder_Title, folderTitle);
	}

	public void enterNewFolderDescription(String folderDescription) {
		typeInto(folder_Description, folderDescription);
	}

	
	
	public void clickOnSaveButton() {
		clickOn(save_Button);
	}

	public void clickOnFolderName() {
		clickOn(temp_Folder);
	}

	public String fetchFolderName() {
		return temp_Folder.getText();
	}

	public void clickOnUploadButton() {
		clickOn(upload_Button);
	}

	public void clickOnSelectFileToUploadButton() {
		clickOn(select_File_to_Upload_Button);
	}

	public void select_File_From_Local_Directory() throws Exception {
		Robot robot = new Robot();
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		String filename = variables.getProperty("FileNameForSiteCreation");		
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

	public void clickOnSaveButtonOnEditPropertyPage() {
		clickOn(save_Button_Edit_Property);
	}

	public void clickOnDownloadButton() {
		clickOn(download_Button);
	}

	public void clickOnDeleteButton() {
		clickOn(delete_Button);
	}

	public void clickOnDeleteButtonOnPopUp() {
		clickOn(delete_Button_On_PopUp);
	}

}
