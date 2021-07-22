package com.selenium.friends;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.selenium.practice.BaseUtilities;

public class DragDropActions {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = BaseUtilities.getChromeDriver("https://www.seleniumeasy.com/test/drag-and-drop-demo.html", false);

		WebElement drag1 = driver.findElement(By.xpath("//span[text()='Draggable 1']"));
		WebElement drag2 = driver.findElement(By.xpath("//span[text()='Draggable 2']"));
		WebElement drag3 = driver.findElement(By.xpath("//span[text()='Draggable 3']"));
		WebElement drag4 = driver.findElement(By.xpath("//span[text()='Draggable 4']"));

		WebElement drop = driver.findElement(By.cssSelector("#mydropzone"));

		
		Actions act = new Actions(driver);
//		act.clickAndHold(drag1).moveToElement(drop).release(drop).build().perform();
		act.clickAndHold(drag1).pause(3000).moveToElement(drop).pause(3000).release(drag1).build().perform();

		System.out.println("ends....");
	
	}

}
