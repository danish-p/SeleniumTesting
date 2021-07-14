package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownWithInputClass {

	public static void main(String[] args) {
		
		String currentDirectory = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", currentDirectory+"//BrowserDriver//chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/select-menu");
		
		WebElement addDownArrowElement = driver.findElement(By.cssSelector(BaseUtilities.closeAddArrow));
		addDownArrowElement.click();
		
		WebElement dynamicDDL = driver.findElement(By.cssSelector(BaseUtilities.dynamicddlInput));
		dynamicDDL.sendKeys("g");
	}

}
