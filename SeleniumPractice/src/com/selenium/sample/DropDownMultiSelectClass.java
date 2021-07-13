package com.selenium.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownMultiSelectClass {

	public static void main(String[] args) {
		
		String currentDirectory = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", currentDirectory+"//BrowserDriver//chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/select-menu");
		
		WebElement addDownArrowElement = driver.findElement(By.cssSelector(BaseUtilities.closeAddArrow));
		addDownArrowElement.click();
		
		WebElement carsListWebElement = driver.findElement(By.cssSelector(BaseUtilities.multipleSelectOption));
		Select carsOptionSelect = new Select(carsListWebElement);
				
		carsOptionSelect.selectByIndex(0);
		carsOptionSelect.selectByIndex(3);
	}

}
