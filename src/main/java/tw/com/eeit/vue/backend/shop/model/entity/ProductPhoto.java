package tw.com.eeit.vue.backend.shop.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class ProductPhoto {

	@Id
	private String productPhotoId;

	@Column(columnDefinition = "varbinary(max)")
	private byte[] productPhoto;

	private Integer sortOrder;

	@ManyToOne
	@JoinColumn(name = "product_id")
	@JsonIgnore
	private Product product;


	public String getProductPhotoId() {
		return productPhotoId;
	}

	public void setProductPhotoId(String productPhotoId) {
		this.productPhotoId = productPhotoId;
	}

	public byte[] getProductPhoto() {
		return productPhoto;
	}

	public void setProductPhoto(byte[] productPhoto) {
		this.productPhoto = productPhoto;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
