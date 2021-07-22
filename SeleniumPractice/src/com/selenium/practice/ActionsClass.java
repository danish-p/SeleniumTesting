package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = BaseUtilities.getChromeDriver("https://www.demoqa.com/droppable", false);
		
		driver.findElement(By.cssSelector(BaseUtilities.closeAddArrow)).click();
		Thread.sleep(3000);

		WebElement dragElement = driver.findElement(By.cssSelector("#draggable"));
		WebElement dropElement = driver.findElement(By.cssSelector("#droppable"));
		
		//action class
		Actions act = new Actions(driver);
		act.dragAndDrop(dragElement, dropElement).perform();

		driver.get("https://www.demoqa.com/resizable");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(BaseUtilities.closeAddArrow)).click();
		
		WebElement oneElement = driver.findElement(By.xpath("//span[@class='react-resizable-handle react-resizable-handle-se']"));
		act.dragAndDropBy(oneElement, 100, 100).perform();
	}
}
