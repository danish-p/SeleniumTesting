package com.selenium.practice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseUtilities {
	
// URLs
	public static String googleURL = "https://google.com";
	public static String demoQAURL = "https://demoqa.com/select-menu";
	public static String demoQAFormURL = "https://demoqa.com/automation-practice-form";
	public static String demoQAToolTip = "https://demoqa.com/tool-tips";
	public static String demoQAWindow = "https://demoqa.com/browser-windows";

// locators	
	public static String googleSearchBar = "//input[@aria-label='Search']";
	public static String closeAddArrow = "#close-fixedban";
	public static String simpleDDL = "#oldSelectMenu";
	public static String dynamicddlInput = "#react-select-2-input";
	public static String multipleSelectOption = "#cars";
	public static String formStateDDL = "//input[@id='react-select-6-input']";
	public static String tooltip = "//div[@class='tooltip-inner']";
	public static String toolTipButton = "//button[@id='toolTipButton']";
	public static String newWindowBtn = "//button[@id='windowButton']";
	public static String newWindowBtnWithMsg = "//button[@id='messageWindowButton']";
	
	
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
	
	public static String getCurrentWindowId(WebDriver driver) {
		String currentWindowId = "";
//		String currentPageURL = driver.getCurrentUrl();
		Set<String> allWindows = driver.getWindowHandles();
		
		Iterator<String> ir = allWindows.iterator();
		for(int i=0; i<allWindows.size();i++) {
			if(driver.getCurrentUrl().equals("https://demoqa.com/sample")) {
				currentWindowId = ir.next();
			}
		}
		
		return currentWindowId;
	}
	
	// Assignments
	// driver capabilities and options
	// create seperate methods for multiple waits
	// flipkart search for samsung galaxy mobile hit enter and print all mobile names
}
