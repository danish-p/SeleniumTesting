package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenChromeBrowser {

	public static void main(String[] args) {
		
		// open google Chrome browser 
		String currentDirectory = System.getProperty("user.dir");
		System.out.println(currentDirectory);
		System.setProperty("webdriver.chrome.driver", currentDirectory+"//BrowserDriver//chromedriver.exe");
		ChromeDriver chrome = new ChromeDriver();
		
		chrome.get("https://www.google.com/");
		
		// to find web element by using XPath
		WebElement googleSearchBarElement = chrome.findElement(By.xpath(BaseUtilities.googleSearchBar));
		googleSearchBarElement.sendKeys("Danish");
		System.out.println("value = "+googleSearchBarElement.getAttribute("value"));
		googleSearchBarElement.submit();
		
		System.out.println("Page Title = "+chrome.getTitle());
		System.out.println("Current URL = "+chrome.getCurrentUrl());
	
		chrome.navigate().to(chrome.getCurrentUrl());

		googleSearchBarElement = chrome.findElement(By.xpath(BaseUtilities.googleSearchBar));
		googleSearchBarElement.clear();
		googleSearchBarElement.sendKeys("Danish Aleem");
		System.out.println("value = "+googleSearchBarElement.getAttribute("value"));
		googleSearchBarElement.submit();
		
		// to close the browser
//		chrome.close();
	}
}
