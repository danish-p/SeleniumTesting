package FlipkartAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartMenus {

	public static void main(String[] args) {
	
		WebDriver driver = FlipkartUtilities.getChromeDriver(FlipkartUtilities.flipkartHomeURL, false);
		FlipkartUtilities.checkLoginPopupFlipkart(driver);
		
		WebElement fashionMenuElement = driver.findElement(By.xpath(FlipkartUtilities.flipkartFashionMenu));
		
		// now move mouse pointer on fashion menu
		Actions moveToFashionAction = new Actions(driver);
		moveToFashionAction.moveToElement(fashionMenuElement).perform();
		
		// find mens top wear menu and then check whether mens top wear element is visible or not
		WebElement mensTopWearMenuElement = driver.findElement(By.xpath(FlipkartUtilities.mensTopWearMenu));
		WebDriverWait waitMenu = new WebDriverWait(driver, 10);
		boolean isMenuVisible = waitMenu.until(ExpectedConditions.visibilityOf(mensTopWearMenuElement)).isDisplayed();
		
		if(isMenuVisible) {
			System.out.println("Top Wear is Visible now...");
			// move the mouse on mens top wear menu then move the mouse on mens fabric menu and then click...
			moveToFashionAction.moveToElement(mensTopWearMenuElement).perform();
			WebElement mensFabricMenuElement = driver.findElement(By.xpath(FlipkartUtilities.mensFabricMenu));
			moveToFashionAction.moveToElement(mensFabricMenuElement).click().perform();
		}
	}
}
