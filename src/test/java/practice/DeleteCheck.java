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

public class DeleteCheck {
	
	

	public static void main(String[] args) throws Exception {
		
		
	    // TODO Auto-generated method stub
/*		
//		C:/Users/ankrana/Downloads/index.html
		File file = new File("C:/Users/ankrana/Downloads/NEW 181031 Intranet Search Terms.xlsx"); 
	   if(file.delete())
	   System.out.println("file deleted");
	   else
		   System.out.println("not");

		File f1 =new File("C:/Users/ankrana/Downloads/NEW 181031 Intranet Search Terms.xlsx");  
	     FileInputStream fis1=new FileInputStream(f1);
	 //    org.apache.poi.xssf.usermodel.XSSFWorkbook;
	     XSSFWorkbook wb1=new XSSFWorkbook(fis1);
	     XSSFSheet sheet1= wb1.getSheetAt(0);
	//   sheet1.getRow(0).getCell(0).getStringCellValue();
	     sheet1.getRow(0).createCell(0).setCellValue("updated value1");  
	     FileOutputStream fout=new FileOutputStream(f1);
	     wb1.write(fout);
	     fout.close();
	     Thread.sleep(4000);
	     System.out.println("value get updated successfully");

		
		Robot robot = new Robot();
		String a="ankrana";
		//Create instance of Clipboard class

		   Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		//Set the String to Enter

		  StringSelection stringSelection = new StringSelection(a);
		//Copy the String to Clipboard
        clipboard.setContents(stringSelection, null);
		//Use Robot class instance to simulate CTRL+C and CTRL+V key events :
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		
*/

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
	            //do something useful with the data
	        }
	        
	   
		
		
		
		   
		   
	}

		
		
}
