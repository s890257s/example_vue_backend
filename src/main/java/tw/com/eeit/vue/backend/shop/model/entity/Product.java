package tw.com.eeit.vue.backend.shop.model.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;

	@Column(columnDefinition = "nvarchar(100)")
	private String productName;

	@Column(columnDefinition = "nvarchar(max)")
	private String productDescription;

	private Integer productPrice;

	private Integer stockQuantity;

	private Boolean productStatus;

	private Date createTime;

	private Date updateTime;

	@ManyToOne
	@JoinColumn(name = "product_category_id")
	private ProductCategory productCategory;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<ProductPhoto> productPhotos;

	@OneToMany(mappedBy = "product")
	private List<MemberOrderDetail> memberOrderDetails;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public Boolean getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(Boolean productStatus) {
		this.productStatus = productStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public List<ProductPhoto> getProductPhotos() {
		return productPhotos;
	}

	public void setProductPhotos(List<ProductPhoto> productPhotos) {
		this.productPhotos = productPhotos;
	}

}
