package com.sikuli.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.selenium.practice.BaseUtilities;

public class FileUploadSikuliExample1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = BaseUtilities.getChromeDriver("https://demoqa.com/automation-practice-form", false);

		driver.findElement(By.cssSelector(BaseUtilities.closeAddArrow)).click();
		Thread.sleep(3000);

		WebElement uploadBtn = driver.findElement(By.cssSelector("#uploadPicture"));

		// to execute java script 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();arguments[0].click();", uploadBtn);
		Thread.sleep(3000);

		Screen sc = new Screen();
		
		try {
			sc.find("G:\\DanishTesting\\SeleniumRepo\\SeleniumPractice\\SikuliImages\\filePath.PNG");
			Thread.sleep(3000);
			sc.type("G:\\DanishTesting\\SeleniumRepo\\SeleniumPractice\\SikuliImages\\filePath.PNG","C:\\Users\\danishp\\Pictures\\ironman.jpg");
			Thread.sleep(3000);
			sc.click("G:\\DanishTesting\\SeleniumRepo\\SeleniumPractice\\SikuliImages\\openButton.PNG");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
// todo 1 check for download 2 for file upload take file name dynamically 