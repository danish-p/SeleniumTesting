package com.amazon.assignment;

import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonUtilities {

	public static String amazonHomeURL = "https://www.amazon.in";

	//locators
	public static String searchBar = "#twotabsearchtextbox";
	public static String productName = "//span[@class='a-size-medium a-color-base a-text-normal']";
	public static String productImge = "//img[@class='s-image']";
	public static String productPrice = "//span[@class='a-price-whole']";
	public static String nextPage = "//li[@class='a-last']/a[text()='Next']";

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
}
