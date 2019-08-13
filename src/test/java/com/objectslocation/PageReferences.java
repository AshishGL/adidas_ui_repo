package com.objectslocation;

import com.alfresco.common.LoginPage;
import com.alfresco.site.pages.AlfrescoIntranetValidationPage;
import com.alfresco.site.pages.DashboardPage;
import com.alfresco.site.pages.FolderFunctionalityPage;
import com.alfresco.site.pages.SiteCreationAndDeletionPage;
import com.alfresco.site.pages.Site_DocumentPage;
import com.alfresco.site.pages.UserSitePage;
import com.hippo.pages.ArticlePage;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;

public class PageReferences extends PageObject {

	@Steps

	public LoginPage loginPage;
	public SiteCreationAndDeletionPage siteCreateDelete;
	public DashboardPage dashBoardMenu;
	public Site_DocumentPage siteDocument;
	public UserSitePage usersite;
	public FolderFunctionalityPage folderOption;
	public AlfrescoIntranetValidationPage alfrescoIntranetvalidation;
	public ArticlePage createArticle;

}
