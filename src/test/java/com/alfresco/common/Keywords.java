package com.alfresco.common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import net.serenitybdd.core.pages.PageObject;

public class Keywords extends PageObject {
	private Connection con = null;
	private Statement stmt;
	private ResultSet rs;
	private Robot robot;


	public String getCurrentDate() {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
	}

	public String randomString() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String strDate = formatter.format(date);
		String randomValue = strDate.replaceAll("-", "").replaceAll(":", "").replaceAll(" ", "");
		// System.out.println(randomValue);
		return randomValue;
	}

	public Connection getSqlServerConnectionAdmin() throws Exception {
		Properties props = null;
		String uName = getPropertyDetails("AdminDB_username");
		String password = getPropertyDetails("AdminDB_password");
		String url = getPropertyDetails("AdminDB_URL");
		String driverClass = getPropertyDetails("msSQLDriverName");

		Class.forName(driverClass);
		con = DriverManager.getConnection(url, uName, password);

		if (con != null) {
			System.out.println("connection created successfully using properties file");
		}
		return con;
	}

	public ResultSet execute_query(String query) throws Throwable {
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		return rs;
	}

	private String getPropertyDetails(String name) throws Exception {
		String a = new FileUtil().readPropertiesFile("JDBC").getProperty(name);
		return a;
	}

	public void openNewIncognitoWindow() throws AWTException, InterruptedException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_N);
		Thread.sleep(1000);
		for(String winHandle : getDriver().getWindowHandles()){
		    getDriver().switchTo().window(winHandle);
		}
	}
	
	public void openNewNonIncognitoWindow() throws AWTException, InterruptedException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_N);
		Thread.sleep(1000);
		for(String winHandle : getDriver().getWindowHandles()){
		    getDriver().switchTo().window(winHandle);
		}
	}

	public void openSecondUrlInIncognitoWindow(String url) throws AWTException, InterruptedException {
		openNewIncognitoWindow();
		openUrl(url);
	}
	
	public void openSecondUrlInNonIncognitoWindow(String url) throws AWTException, InterruptedException {
		openNewNonIncognitoWindow();
		openUrl(url);
	}

}
