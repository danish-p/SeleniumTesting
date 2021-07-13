package com.selenium.sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImplicitWaitClass {

	public static void main(String[] args) {
		
		WebDriver driver = BaseUtilities.getChromeDriver(BaseUtilities.demoQAURL,true);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Completed 10 seconds!!!!!!!!!!!!!!!!!!!!!");
		WebElement addDownArrowElement = driver.findElement(By.cssSelector(BaseUtilities.closeAddArrow));
		addDownArrowElement.click();
	}
}