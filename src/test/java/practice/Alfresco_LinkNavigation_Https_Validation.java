package practice;

import java.sql.Date;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Collections;
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

public class Alfresco_LinkNavigation_Https_Validation {
	static WebDriver driver = null;
	static String check = "http://sharepv.";
     static String check1 = "https://sharepv.";

	public static void main(String[] args) throws Exception {
		String url = null;
	
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ankrana\\Desktop\\practice bug\\chromedriver.exe");

	    DesiredCapabilities caps = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        driver = new ChromeDriver(caps);
		driver.get("https://sharepv.gartner.com/share/page?pt=login");
		Thread.sleep(5000);
		driver.findElement(By.id("page_x002e_components_x002e_slingshot-login_x0023_default-username")).sendKeys("ankrana");
		driver.findElement(By.id("page_x002e_components_x002e_slingshot-login_x0023_default-password")).sendKeys("Ctli@111");
        driver.findElement(By.id("page_x002e_components_x002e_slingshot-login_x0023_default-submit-button")).click();

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        System.out.println("**************PRINT CONSOLE LOGS OF APPLICATION************************");
		for (LogEntry entry : logEntries) 
		{
         System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
          
       }
	


	
String[] elements = { "img","a" };
//String[] elements = { "a" };
int numberOfItems = elements.length;
List<String> hrefs = new ArrayList<String>();
ArrayList<String> resList = new ArrayList<String>();
      //  String check = "http://sharepv.";
       // String check1 = "https://sharepv.";
        
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
System.out.println(" ");
System.out.println("***************list contains all url under Anchor and IMG tags*******************************************************************************");
        
hrefs.removeAll(Collections.singletonList(null));

printList(hrefs, "initial list");

if (hrefs != null && !hrefs.isEmpty()) {
	for (String curVal : hrefs) {
		
		if (curVal.contains(check1) || curVal.contains(check)) {
			resList.add(curVal);
		}
	}

}
System.out.println("*****************list contains all url under http://sharepv and https://sharepv.*******************************************************************");

printList(resList, "final result");

execute(repalceUrl(resList));
	
	
	}

	private static List<String> repalceUrl(ArrayList<String> resList) {
		
		
		List<String> finalReplacedList = new ArrayList<>();
		int toBeReplace=0;
		for (String url : resList) {
			if(url.contains(check))
			{
				toBeReplace++;
			}
			finalReplacedList.add(url.replace(check, check1));
			

		}
		System.out.println("  ");
		
		System.out.println("total count of link starts with http://sharepv which need to be replace :"+ toBeReplace);
		
	
		System.out.println("*****************list contains all url under Anchor and IMG tags after replacing any existing HTTP with HTTPS//*******************************");
		printList(finalReplacedList, "final replaced list");
		return finalReplacedList;

	}


	private static void printList(List<String> hrefs, String string) {
		for (String webElement : hrefs) {
				System.out.println(string + ":" + webElement);
			}
			
		}
	
	public static void execute(List<String> finalReplacedList)  {
		int i = 0, j = 0;
		int count = 0;
		for (String url : finalReplacedList) {
			if (driver == null) {
				driver = new ChromeDriver();
			}
			System.out.println("link is going to open now");
			try {
				driver.get(url);
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
				System.out.println("************Geeting Login PopUp error:****************");
				driver = new ChromeDriver();
				driver.get(url);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
			
			
			String errorcode = "404";
			String errorcode1="err";
			String errorcode2="error";
			
			
			String currenturl = driver.getCurrentUrl();
			if (currenturl.contains(errorcode) || currenturl.contains(errorcode1) || currenturl.contains(errorcode2)) {
				count++;
				System.out.println("WARNING!!!!! This link is broken");
				System.out.println("Broken Url is: " + currenturl);
				System.out.println("original Url is: " + url);

			} else {
				System.out.println("This link is Working Fine :"+ url);
				System.out.println();
				 i++;
			}



		}
		System.out.println("link open successfully total count is: " + i);
		System.out.println("Total broken links are: " + count);
		
	}

	
	}
	
