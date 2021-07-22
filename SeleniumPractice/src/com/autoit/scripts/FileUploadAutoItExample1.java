package com.autoit.scripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.practice.BaseUtilities;

public class FileUploadAutoItExample1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriver driver = BaseUtilities.getChromeDriver("https://demoqa.com/automation-practice-form", false);

		driver.findElement(By.cssSelector(BaseUtilities.closeAddArrow)).click();
		Thread.sleep(3000);

		WebElement uploadBtn = driver.findElement(By.cssSelector("#uploadPicture"));
		
		// to execute java script 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();arguments[0].click();", uploadBtn);
		Thread.sleep(3000);
		// to execute autoIt file upload code
		Runtime.getRuntime().exec("G:\\DanishTesting\\SeleniumRepo\\SeleniumPractice\\FileUploadAutoItExample1.exe");
	}
}
