package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChordClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// to perform multiple keyword at same time
		WebDriver driver = BaseUtilities.getChromeDriver("https://www.demoqa.com/automation-practice-form", false);
		
		driver.findElement(By.cssSelector(BaseUtilities.closeAddArrow)).click();
		
		WebElement selectStateElement = driver.findElement(By.xpath("//input[@id='react-select-3-input']"));
		selectStateElement.sendKeys(Keys.ARROW_DOWN);
		selectStateElement.sendKeys(Keys.ENTER);
		
		// chord class for multiple keyboard button
		WebElement firstNameElement = driver.findElement(By.cssSelector("#currentAddress"));
		firstNameElement.sendKeys("Danish");
		String viewInspect = Keys.chord(Keys.CONTROL+"A");
		firstNameElement.sendKeys(viewInspect);
	}
}
