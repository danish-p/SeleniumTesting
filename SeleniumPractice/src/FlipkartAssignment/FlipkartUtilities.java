package FlipkartAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartUtilities {

	public static String flipkartHomeURL = "https://www.flipkart.com/";

	//locators
	public static String loginPopupCloseButton = "//button[@class='_2KpZ6l _2doB4z']";
	public static String searchBarDiv = "//div[@class='col-12-12 _2oO9oE']";
	public static String searchBar = "//input[@title='Search for products, brands and more'][@placeholder='Search for products, brands and more']";
	public static String productName = "//div[@class='_4rR01T']";
	public static String nextPage = "//span[text()='Next']";
	public static String productImge = "//div//div[@class='CXW8mj']//img[@class='_396cs4 _3exPp9']";
	public static String productSpecificationDiv = "//li[@class='rgWa7D']";
	public static String productSpecification = "//div[text()='APPLE iPhone SE (Black, 64 GB)']/following-sibling::div[2]/ul/li";
	public static String flipkartFashionMenu = "//div[text()='Fashion']";
	public static String mensTopWearMenu = "//div[@class='_3XS_gI _7qr1OC']/a[1]";
	public static String mensFabricMenu = "//div[@class='_3XS_gI']/a[11]";
//	public static String productSpecificationli = "//div[@class='fMghEO']/ul";
	
	//data
	public static String searchBarKeys = "samsung galaxy mobile";
	
	public static ChromeDriver getChromeDriver(String URL, boolean isMaximize) {
		String currentDirectory = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", currentDirectory+"//BrowserDriver//chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		if(isMaximize) {
			driver.manage().window().maximize();
		}
		driver.get(URL); // it takes 30 seconds to load a url else it will give timeout error

		return driver;
	}
	
	public static void checkLoginPopupFlipkart(WebDriver driver) {
		// check weather login pop-up is appearing or not if yes then close it
		WebElement loginPopupCloseBtn = driver.findElement(By.xpath(FlipkartUtilities.loginPopupCloseButton));
		if(loginPopupCloseBtn.isDisplayed()) {
			loginPopupCloseBtn.click();
		}
	}
}
