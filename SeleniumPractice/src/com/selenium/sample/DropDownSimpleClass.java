package com.selenium.sample;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownSimpleClass {

	public static void main(String[] args) {
	
		WebDriver driver = BaseUtilities.getChromeDriver(BaseUtilities.demoQAURL, false);
		
		WebElement addDownArrowElement = driver.findElement(By.cssSelector(BaseUtilities.closeAddArrow));
		addDownArrowElement.click();
		
		WebElement colorDDLElement = driver.findElement(By.cssSelector(BaseUtilities.simpleDDL));
		Select colorSelectOptions = new Select(colorDDLElement);
		
		List<WebElement> colorList = colorSelectOptions.getOptions();
		for(int i=0;i<colorList.size();i++) {
			System.out.println(colorList.get(i).getText());
		}
		
		colorSelectOptions.selectByIndex(1);		
		System.out.println("Selected Option selectByIndex = "+colorSelectOptions.getFirstSelectedOption().getText());

		colorSelectOptions.selectByVisibleText("Indigo");
		System.out.println("Selected Option selectByVisibleText= "+colorSelectOptions.getFirstSelectedOption().getText());

		colorSelectOptions.selectByValue("9");   // it will set according to the value 
		System.out.println("Selected Option selectByValue= "+colorSelectOptions.getFirstSelectedOption().getText());
		
		// NoSuchElementException  -- Selenium exception
		// findelement and findelements
		// for ddl there is a class Select it contains following methods
		// selectByVisibleText(), selectByValue(), selectByIndex(), getOptions(),
	}
}
