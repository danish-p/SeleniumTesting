package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenFirefoxBrowser {

	public static void main(String[] args) {

		String currentDirectory = System.getProperty("user.dir");

		System.setProperty("webdriver.gecko.driver", currentDirectory+"//BrowserDriver//geckodriver.exe");
		FirefoxDriver firefox = new FirefoxDriver();

		firefox.get("https://www.google.com/");

		// to find web element by using xpath
		WebElement googleSearchBarElement = firefox.findElement(By.xpath(BaseUtilities.googleSearchBar));
		googleSearchBarElement.sendKeys("Danish");
		googleSearchBarElement.submit();

	}
}
