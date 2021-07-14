package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserOperations {

	public static void main(String[] args) throws InterruptedException {
		// browser operations
		// back forward using navigate method called as browser operations
		
		WebDriver driver = BaseUtilities.getChromeDriver(BaseUtilities.googleURL, false);
		System.out.println("Current Path : "+driver.getCurrentUrl());

		driver.navigate().to(BaseUtilities.demoQAFormURL);
		System.out.println("Current Path : "+driver.getCurrentUrl());
		
		Thread.sleep(5000);
		WebElement addDownArrowElement = driver.findElement(By.cssSelector(BaseUtilities.closeAddArrow));
		addDownArrowElement.click();
		
		driver.navigate().back();
		System.out.println("Current Path back() : "+driver.getCurrentUrl());

		driver.navigate().forward();
		System.out.println("Current Path forward() : "+driver.getCurrentUrl());

		Thread.sleep(5000);

		addDownArrowElement = driver.findElement(By.cssSelector(BaseUtilities.closeAddArrow));
		addDownArrowElement.click();
	}

}
