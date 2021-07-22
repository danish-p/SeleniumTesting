package com.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopupClass {
	
	static WebDriver driver;
	
	void alertWithPositiveBtn() throws InterruptedException {
		WebElement btnElement = driver.findElement(By.cssSelector("#alertButton"));
		btnElement.click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println("Title :"+alert.getText());
		
		Thread.sleep(5000);
		alert.accept();
		System.out.println("You pressed accept btn");
	}
	
	void alertWithPositiveNegativeBtn() throws InterruptedException {
		WebElement btnElement = driver.findElement(By.cssSelector("#confirmButton"));
		btnElement.click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println("Title :"+alert.getText());
		
		Thread.sleep(5000);
		alert.accept();
		System.out.println("You pressed accept btn");

		btnElement.click();
		alert = driver.switchTo().alert();
		System.out.println("Title :"+alert.getText());
		
		Thread.sleep(5000);
		alert.dismiss();
		System.out.println("You pressed dismiss btn");
	}
	
	void alertWithInput() throws InterruptedException {
		WebElement btnElement = driver.findElement(By.cssSelector("#promtButton"));
		btnElement.click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println("Title :"+alert.getText());
		
		alert.sendKeys("Danish");
		
		Thread.sleep(5000);
		alert.accept();
		System.out.println("You pressed accept btn");
	}
	
	void alertWithTimeDelay() throws InterruptedException {
		WebElement btnElement = driver.findElement(By.cssSelector("#timerAlertButton"));
		btnElement.click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Alert alert = driver.switchTo().alert();
		System.out.println("Title :"+alert.getText());
				
		Thread.sleep(5000);
		alert.accept();
		System.out.println("You pressed accept btn");
	}

	public static void main(String[] args) throws InterruptedException {

		driver = BaseUtilities.getChromeDriver("https://www.demoqa.com/alerts", false);

		driver.findElement(By.cssSelector(BaseUtilities.closeAddArrow)).click();
		Thread.sleep(3000);
		
		PopupClass obj = new PopupClass();
		obj.alertWithPositiveBtn();
		obj.alertWithPositiveNegativeBtn();
		obj.alertWithInput();
		obj.alertWithTimeDelay();
	}
}
