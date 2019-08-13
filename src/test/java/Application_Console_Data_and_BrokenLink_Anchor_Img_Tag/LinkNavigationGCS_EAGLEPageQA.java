package Application_Console_Data_and_BrokenLink_Anchor_Img_Tag;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LinkNavigationGCS_EAGLEPageQA {
	static WebDriver driver = null;
	

	public static void main(String[] args) throws Exception {

		String url = null;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ankrana\\Desktop\\practice bug\\chromedriver.exe");
		
		    DesiredCapabilities caps = DesiredCapabilities.chrome();
	        LoggingPreferences logPrefs = new LoggingPreferences();
	        logPrefs.enable(LogType.BROWSER, Level.ALL);
	        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
	        driver = new ChromeDriver(caps);
			driver.get("https://intranetqa.gartner.com/gcs/");
			LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
	        System.out.println("**************PRINT CONSOLE LOGS OF APPLICATION************************");
			for (LogEntry entry : logEntries) 
			{
	         System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
	          
           }
		


		
String[] elements = { "img","a" };
int numberOfItems = elements.length;
List<String> hrefs = new ArrayList<String>();
ArrayList<String> resList = new ArrayList<String>();
String check = "http://intranet.";
String check1 = "https://intranetqa.";
int i = 0;

for( int w=0; w<numberOfItems; w++)
{

	
		List<WebElement> anchors = driver.findElements(By.tagName(elements[w]));
		Thread.sleep(1500);
		for (WebElement anchor : anchors) {
			if (elements[w].contains("img")) {
				hrefs.add(anchor.getAttribute("src"));
			}
			else if (elements[w].contains("a")) {
				hrefs.add(anchor.getAttribute("href"));
			}
		
			
			i++;
		}
	}

System.out.println("total innitial entries:" + i);
System.out.println("***************list contains all url under Anchor and IMG tags*******************************************************************************");
printList(hrefs, "initial list");

if (hrefs != null && !hrefs.isEmpty()) {
	for (String curVal : hrefs) {
		if (curVal.contains(check1) || curVal.contains(check)) {
			resList.add(curVal);
		}
	}

}
System.out.println("*****************list contains all url under http://intranet and https://intranetqa.*******************************************************************");

printList(resList, "final result");
execute(repalceUrl(resList));
	}

	public static List<String> repalceUrl(ArrayList<String> resList) {
		
		
		List<String> finalReplacedList = new ArrayList<>();
		int toBeReplace=0;
		for (String url : resList) {
			
			if(url.contains("http://intranet."))
			{
				toBeReplace++;
			}
			
			finalReplacedList.add(url.replace("http://intranet.", "https://intranetqa."));
		

		}
		System.out.println("  ");
		
		System.out.println("total count of link starts with http://intranet which need to be replace :"+ toBeReplace);
		
	
		System.out.println("*****************list contains all url under Anchor and IMG tags after replacing all http with https//intranetdv*******************************");
		printList(finalReplacedList, "final replaced list");
		return finalReplacedList;

	}

	private static void printList(List<String> hrefs, String text) {
		for (String webElement : hrefs) {
			System.out.println(text + ":" + webElement);
		}

	}

	public static void execute(List<String> finalReplacedList) throws Exception {
		int i = 0, j = 0;
		int count = 0;
		for (String url : finalReplacedList) {
		driver.get(url);
			// i++;
			String errorcode = "404";
			
			String currenturl = driver.getCurrentUrl();
			if (currenturl.contains(errorcode)) {
				count++;
				System.out.println("WARNING!!!!! This link is broken");
				System.out.println("Broken Url is: " + currenturl);
				System.out.println("original Url is: " + url);

			} else {
				System.out.println("This link is Working Fine :"+ url);
				 i++;
			}
			Thread.sleep(500);

			System.out.println("link open");
		}
		System.out.println("link open successfully total count is:" + i);
		System.out.println("Total broken links are" + count);
		
	}

}
