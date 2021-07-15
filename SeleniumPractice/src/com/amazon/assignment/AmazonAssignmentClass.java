package com.amazon.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import FlipkartAssignment.ProductClass;

public class AmazonAssignmentClass {

	static WebDriver driver;
	private int totalNumberOfPages;
	private ArrayList<ProductClass> productList = new ArrayList<ProductClass>();

	void searchForProduct() throws InterruptedException {
		System.out.println("\n ****** Please Enter Product to be search ****** \n");
		Scanner sc = new Scanner(System.in);
		// get the search bar element and pass the search value here..
		WebElement searchBarElement = driver.findElement(By.cssSelector(AmazonUtilities.searchBar));

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
		List<WebElement> productNamesWebElements = driver.findElements(By.xpath(AmazonUtilities.productName));
		List<WebElement> productImageWebElements = driver.findElements(By.xpath(AmazonUtilities.productImge));
//		List<WebElement> productPriceWebElements = driver.findElements(By.xpath(AmazonUtilities.productPrice));

		totalNumberOfPages++;
		System.out.println("Fetching page number : "+totalNumberOfPages);
		for(int i=0; i<productNamesWebElements.size(); i++) {
			ProductClass productClass = new ProductClass();
			productClass.setProductName(productNamesWebElements.get(i).getText());
			productClass.setProductImage(productImageWebElements.get(i).getAttribute("src"));

//			List<String> productSpecificationList = new ArrayList<String>();
//			if(!productPriceWebElements.isEmpty()) {
//				productSpecificationList.add(productPriceWebElements.get(0).getText());
//				productClass.setSpecificatoinList(productSpecificationList);
//			}
			productList.add(productClass);
		}
	}

	void printProductList(ArrayList<ProductClass> productList) {
		System.out.println("\n************** All Product Names **************\n");
		for(int i=0; i<productList.size(); i++) {
			System.out.println("\n#"+(i+1));
			System.out.println("Product Title : "+productList.get(i).getProductName());
			System.out.println("Product Image : "+productList.get(i).getProductImage());
//			System.out.println("Product Price : ");
//			for(int j=0; j<productList.get(i).getSpecificatoinList().size(); j++) {
//				System.out.println(productList.get(i).getSpecificatoinList().get(j));
//			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		AmazonAssignmentClass obj = new AmazonAssignmentClass();
		driver = AmazonUtilities.getChromeDriver(AmazonUtilities.amazonHomeURL, false);

		// get the search bar element and pass the search value here..
		obj.searchForProduct();

		// fetch product names once page gets load
		obj.fetchProductListFromSite();

		try {		
			List<WebElement> nextPageElement = driver.findElements(By.xpath(AmazonUtilities.nextPage));
			while(nextPageElement != null && !nextPageElement.isEmpty() && nextPageElement.get(0).isDisplayed()) {
				nextPageElement.get(0).click();
				obj.fetchProductListFromSite();
				nextPageElement = driver.findElements(By.xpath(AmazonUtilities.nextPage));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		obj.printProductList(obj.productList);
	}
}
