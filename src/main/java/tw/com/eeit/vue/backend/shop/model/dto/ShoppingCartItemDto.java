package tw.com.eeit.vue.backend.shop.model.dto;

public class ShoppingCartItemDto {

	private Integer productId;
	private String productPhotoId;
	private String productName;
	private Integer productPrice;
	private Integer quantity;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductPhotoId() {
		return productPhotoId;
	}

	public void setProductPhotoId(String productPhotoId) {
		this.productPhotoId = productPhotoId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
