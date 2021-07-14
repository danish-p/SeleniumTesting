package com.selenium.practice;

import org.openqa.selenium.chrome.ChromeDriver;

public class BaseUtilities {
	
	public static String googleURL = "https://google.com";
	public static String demoQAURL = "https://demoqa.com/select-menu";
	public static String demoQAFormURL = "https://demoqa.com/automation-practice-form";
	public static String demoQAToolTip = "https://demoqa.com/tool-tips";
	
	public static String googleSearchBar = "//input[@aria-label='Search']";
	public static String closeAddArrow = "#close-fixedban";
	public static String simpleDDL = "#oldSelectMenu";
	public static String dynamicddlInput = "#react-select-2-input";
	public static String multipleSelectOption = "#cars";
	public static String formStateDDL = "//input[@id='react-select-6-input']";
	public static String tooltip = "//div[@class='tooltip-inner']";
	public static String toolTipButton = "//button[@id='toolTipButton']";
	
	
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
	
	// Assignments
	// driver capabilities and options
	// create seperate methods for multiple waits
	// flipkart search for samsung galaxy mobile hit enter and print all mobile names
}
