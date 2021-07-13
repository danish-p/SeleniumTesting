package com.selenium.friends;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.selenium.sample.BaseUtilities;

public class DDLClass {

	public static void main(String[] args) {
		
		ChromeDriver driver = BaseUtilities.getChromeDriver(BaseUtilities.demoQAFormURL, false);
				
		WebElement addDownArrowElement = driver.findElement(By.cssSelector(BaseUtilities.closeAddArrow));
		addDownArrowElement.click();
		
		WebElement dynamicDDL = driver.findElement(By.xpath(BaseUtilities.formStateDDL));
		dynamicDDL.click();
	}

}
