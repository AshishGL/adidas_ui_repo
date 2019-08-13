package practice;

import java.sql.Date;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PrintConsoleData {
	
	public static void main(String[] args) throws Exception {
		
		
		//Printing console window for browser, WORKING PERFECTLY		
		
				System. setProperty("webdriver.chrome.driver", "C:\\Users\\ankrana\\Downloads\\chromedriver.exe");
				   WebDriver driver;
				   DesiredCapabilities caps = DesiredCapabilities.chrome();
			        LoggingPreferences logPrefs = new LoggingPreferences();
			        logPrefs.enable(LogType.BROWSER, Level.ALL);
			        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
			        driver = new ChromeDriver(caps);
					driver.get("https://intranetdv.gartner.com/gaw/");
					LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
			        for (LogEntry entry : logEntries) {
			            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
			          
	}

}
}