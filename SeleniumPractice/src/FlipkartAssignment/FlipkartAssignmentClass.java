package FlipkartAssignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartAssignmentClass {

	private ArrayList<ProductClass> productList = new ArrayList<ProductClass>();
	private WebDriver driver;
	private int totalNumberOfPages;

	void checkLoginPopupFlipkart() {
		// check weather login pop-up is appearing or not if yes then close it
		WebElement loginPopupCloseBtn = driver.findElement(By.xpath(FlipkartUtilities.loginPopupCloseButton));
		if(loginPopupCloseBtn.isDisplayed()) {
			loginPopupCloseBtn.click();
		}
	}

	void searchForProduct() throws InterruptedException {
		System.out.println("\n ****** Please Enter Product to be search ****** \n");
		Scanner sc = new Scanner(System.in);
		// get the search bar element and pass the search value here..
		WebElement searchBarElement = driver.findElement(By.xpath(FlipkartUtilities.searchBar));
		//		searchBarElement.sendKeys(FlipkartUtilities.searchBarKeys);

		String searchKey = sc.nextLine().trim();
		searchBarElement.sendKeys(searchKey);
		Thread.sleep(2000);
		searchBarElement.submit();
		//		searchBarElement.sendKeys(Keys.ARROW_DOWN);
		//		searchBarElement.sendKeys(Keys.ENTER);
		sc.close();
	}

	void fetchProductListFromSite() throws InterruptedException {
		Thread.sleep(5000);
		//		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		//		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FlipkartUtilities.productName)));
		//		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FlipkartUtilities.productImge)));

		List<WebElement> productNamesWebElements = driver.findElements(By.xpath(FlipkartUtilities.productName));
		List<WebElement> productImageWebElements = driver.findElements(By.xpath(FlipkartUtilities.productImge));

		totalNumberOfPages++;
		System.out.println("Fetching page number : "+totalNumberOfPages);
		for(int i=0; i<productNamesWebElements.size(); i++) {
			ProductClass productClass = new ProductClass();
			productClass.setProductName(productNamesWebElements.get(i).getText());
			productClass.setProductImage(productImageWebElements.get(i).getAttribute("src"));
			productClass.setSpecificatoinList(fetchProductSpecification(productNamesWebElements.get(i).getText()));
			productList.add(productClass);
		}
	}

	List<String> fetchProductSpecification(String productName) {
		String xPathForSpecification = "//div[text()='"+productName+"']/following-sibling::div[2]/ul/li";
		List<WebElement> productSpecificationElements = driver.findElements(By.xpath(xPathForSpecification));

		List<String> productSpecificationList = new ArrayList<String>();
		if(!productSpecificationElements.isEmpty()) {
			for(int i=0; i<productSpecificationElements.size(); i++) {
				productSpecificationList.add(productSpecificationElements.get(i).getText());
			}
		}

		return productSpecificationList;
	}

	void printProductList(ArrayList<ProductClass> productList) {
		System.out.println("\n************** All Product Names **************\n");
		for(int i=0; i<productList.size(); i++) {
			System.out.println("\n#"+(i+1));
			System.out.println("Product Title : "+productList.get(i).getProductName());
			System.out.println("Product Image : "+productList.get(i).getProductImage());
			System.out.println("Product Specification : ");
			for(int j=0; j<productList.get(i).getSpecificatoinList().size(); j++) {
				System.out.println(productList.get(i).getSpecificatoinList().get(j));
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		FlipkartAssignmentClass obj = new FlipkartAssignmentClass();
		obj.driver = FlipkartUtilities.getChromeDriver(FlipkartUtilities.flipkartHomeURL, false);

		// check weather login pop-up is appearing or not if yes then close it
		obj.checkLoginPopupFlipkart();

		// get the search bar element and pass the search value here..
		obj.searchForProduct();

		// fetch product names once page gets load
		obj.fetchProductListFromSite();

		// print product names
		//		obj.printProductList(obj.productList);

		// check that next page is available or not
		// findElement() will generate an exception i.e. NoSuchElementException
		// findElements() will not generate any exception
		try {		
			List<WebElement> nextPageElement = obj.driver.findElements(By.xpath(FlipkartUtilities.nextPage));
			while(nextPageElement != null && !nextPageElement.isEmpty() && nextPageElement.get(0).isDisplayed()) {
				nextPageElement.get(0).click();
				obj.fetchProductListFromSite();
				nextPageElement = obj.driver.findElements(By.xpath(FlipkartUtilities.nextPage));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		// print product names
		obj.printProductList(obj.productList);
	}
}
