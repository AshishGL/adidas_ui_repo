package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkNavigationIMG {
	static WebDriver driver = null;

	public static void main(String[] args) throws Exception {
		String url = null;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ankrana\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://intranetdv.gartner.com/gaw/");

		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

		List<String> hrefs = new ArrayList<String>();
		List<WebElement> anchors = driver.findElements(By.tagName("img"));
		System.out.println("Total links are " + anchors.size());
		Thread.sleep(4000);
		ArrayList<String> resList = new ArrayList<String>();
		String check = "http://intranet.";
		String check1 = "https://intranetdv.";
		int i = 0;
		for (WebElement anchor : anchors) {
			hrefs.add(anchor.getAttribute("src"));
		//	System.out.println("**********INITIAL LIST CONTAINS ALL URL UNDER SRC **************");
		//	printList(hrefs, "initial list");
			i++;
		}
		System.out.println("**********INITIAL LIST CONTAINS ALL URL UNDER SRC **************");
			printList(hrefs, "initial list");
		System.out.println("total innitial entries:" + i);

		if (hrefs != null && !hrefs.isEmpty()) {
			for (String curVal : hrefs) {
				if (curVal.contains(check1) || curVal.contains(check)) {
					resList.add(curVal);
				}
			}

		}
		System.out.println("**********FILTERED LIST CONTAINS URL OF HTTP://INTRANET AND HTTPS://INTRANETDV**************");

		printList(resList, "intial list");

		// executing final list after replacing the urls.
		execute(repalceUrl(resList));

	}

	public static List<String> repalceUrl(ArrayList<String> resList) {
		List<String> finalReplacedList = new ArrayList<>();
		for (String url : resList) {
			finalReplacedList.add(url.replace("http://intranet.", "https://intranetdv."));
		}
		System.out.println("**********LIST CONTAINS URL AFTER HTTP://INTRANET IS REPLACE BY HTTPS://INTRANETDV**************8");

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
		for (String url : finalReplacedList) {
			
			if (driver == null) {
				driver = new ChromeDriver();
			}
			driver.get(url);
			 i++;
			String errorcode = "404";
			String currenturl = driver.getCurrentUrl();
			if (currenturl.contains(errorcode)) {
				System.out.println("WARNING!!!!! This link is broken");
				System.out.println("Broken Url is: " + currenturl);
				System.out.println("original Url is: " + url);

			} else {
				System.out.println("This link is Working Fine : "+url);
			}
			Thread.sleep(700);

			System.out.println("link open");
		}
		System.out.println("link open successfully total count is:" + i);
	}

}
