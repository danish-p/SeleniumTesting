package com.selenium.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class OpenIEBrowser {

	public static void main(String[] args) {
		
		String currentDirectory = System.getProperty("user.dir");
		System.out.println(currentDirectory);
		
		// open IE Browser
		System.setProperty("webdriver.ie.driver", currentDirectory+"//BrowserDriver//IEDriverServer.exe");
		InternetExplorerDriver ieDriver = new InternetExplorerDriver();
		
		ieDriver.get("https://www.google.com/");
		
		// to find web element by using xpath
		WebElement googleSearchBarElement = ieDriver.findElement(By.xpath(BaseUtilities.googleSearchBar));
		googleSearchBarElement.sendKeys("Danish");
		googleSearchBarElement.submit();
		
		// to close the browser.
//		ieDriver.close();
	}
}
