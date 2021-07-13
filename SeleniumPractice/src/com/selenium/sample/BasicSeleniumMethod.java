package com.selenium.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasicSeleniumMethod {

	public static void main(String[] args) {
		WebDriver driver = BaseUtilities.getChromeDriver(BaseUtilities.demoQAURL, false);
		
		WebElement addDownArrowElement = driver.findElement(By.cssSelector(BaseUtilities.closeAddArrow));
		addDownArrowElement.click();
		
		System.out.println("getTitle : "+driver.getTitle());
		System.out.println("getCurrentUrl : "+driver.getCurrentUrl());
		
		driver.navigate().to("https://demoqa.com/radio-button");
		System.out.println("getTitle : "+driver.getTitle());
		System.out.println("getCurrentUrl : "+driver.getCurrentUrl());
		
		WebElement noRadioButton = driver.findElement(By.cssSelector("#noRadio"));
		String isEnabledValue = noRadioButton.getAttribute("class");
		if(isEnabledValue.endsWith("disabled")) {
			System.out.println("noRadioButton is disabled");
		}else {
			System.out.println("noRadioButton is Enabled");
		}
		
	}

}
