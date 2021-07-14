package FlipkartAssignment;

import java.util.List;

public class ProductClass {

	private String productName;
	private String productImage;
	private List<String> specificatoinList;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public List<String> getSpecificatoinList() {
		return specificatoinList;
	}

	public void setSpecificatoinList(List<String> specificatoinList) {
		this.specificatoinList = specificatoinList;
	}	
}
