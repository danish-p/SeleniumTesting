package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitClass2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = BaseUtilities.getChromeDriver(BaseUtilities.ebayURL,false);
		
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		
		WebElement electronicsMenu = driver.findElement(By.xpath(BaseUtilities.ebayElectronics));
		
		// move mouse pointer to an web element
		Actions action = new Actions(driver);
		action.moveToElement(electronicsMenu).perform();
		
		// explicit wait 
		WebElement appleSubMenu = driver.findElement(By.xpath(BaseUtilities.ebayApple));
		wait.until(ExpectedConditions.visibilityOf(appleSubMenu)).click();
	}
}