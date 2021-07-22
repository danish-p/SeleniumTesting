package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHandlingClass {

	public static void main(String[] args) {
		
		WebDriver driver = BaseUtilities.getChromeDriver("https://www.demoqa.com/frames", false);
	
		WebElement addDownArrowElement = driver.findElement(By.cssSelector(BaseUtilities.closeAddArrow));
		addDownArrowElement.click();
		
		WebElement iframeElement = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(iframeElement);
//		driver.switchTo().frame(1);  // by passing the index of the frame
		
		WebElement frameText = driver.findElement(By.id("sampleHeading"));
		System.out.println(frameText.getText());
		
		driver.switchTo().defaultContent();  // it will navigate to the top window or frame
		driver.switchTo().frame(2);  // by passing the index of the frame
		
		WebElement frameText2 = driver.findElement(By.id("sampleHeading"));
		System.out.println(frameText2.getText());
	}

}
