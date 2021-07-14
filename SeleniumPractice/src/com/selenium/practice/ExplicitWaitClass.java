package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitClass {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = BaseUtilities.getChromeDriver(BaseUtilities.demoQAURL,false);
//		Thread.sleep(10000);
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
//		webDriverWait.until(expectedConditions);
		
		webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BaseUtilities.closeAddArrow)));
		
//		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(profile object));
		
		System.out.println("Completed 10 seconds!!!!!!!!!!!!!!!!!!!!!");
		WebElement addDownArrowElement = driver.findElement(By.cssSelector(BaseUtilities.closeAddArrow));
		addDownArrowElement.click();
	}
}

// Assignments
// create seperate methods for multiple waits