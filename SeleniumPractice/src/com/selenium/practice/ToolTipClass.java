package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ToolTipClass {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = BaseUtilities.getChromeDriver(BaseUtilities.demoQAToolTip, false);

		WebElement addDownArrowElement = driver.findElement(By.cssSelector(BaseUtilities.closeAddArrow));
		addDownArrowElement.click();

		WebElement toolTipButton = driver.findElement(By.xpath(BaseUtilities.toolTipButton));
		
		Actions mouseAction = new Actions(driver);
		mouseAction.moveToElement(toolTipButton);
		mouseAction.perform();
		
		WebElement toopTipDivElement = driver.findElement(By.xpath(BaseUtilities.tooltip));
		System.out.println("Tool Tip Text = "+toopTipDivElement.getText());
	}
}
