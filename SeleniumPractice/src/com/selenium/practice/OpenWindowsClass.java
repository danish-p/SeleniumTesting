package com.selenium.practice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenWindowsClass {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		driver = BaseUtilities.getChromeDriver(BaseUtilities.demoQAWindow, false);
		
		driver.findElement(By.xpath(BaseUtilities.newWindowBtn)).click();
		Thread.sleep(5000);

		String parentWindowId = driver.getWindowHandle();
		System.out.println("ParentId = "+parentWindowId);
		
		Set<String> setAllWindows = driver.getWindowHandles();
		System.out.println("Set of all open windows : "+setAllWindows);
		
		// to switch from one browser window to another...		
		Iterator<String> ir = setAllWindows.iterator();
		System.out.println("First element from set represent the parentId = "+ir.next());
		
		for(int i=0;i<setAllWindows.size();i++) {
			String windowId = ir.next();
			if(!parentWindowId.equals(windowId)) {
				System.out.println("childId (Other than parent id)"+windowId);
				driver.switchTo().window(windowId);
				break;
			}
		}
		
		System.out.println(driver.findElement(By.cssSelector("#sampleHeading")).getText());
		System.out.println("getCurrentUrl :"+driver.getCurrentUrl());

//		driver.close(); // it will close only the current active instance
//		driver.quit(); // it will close all the window of chrome
	}
}
