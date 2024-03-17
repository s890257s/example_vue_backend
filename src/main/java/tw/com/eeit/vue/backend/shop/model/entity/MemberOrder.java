package tw.com.eeit.vue.backend.shop.model.entity;

import java.sql.Date;
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
public class MemberOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberOrderId;

	private Date orderDate;

	@Column(columnDefinition = "nvarchar(50)")
	private String orderStatus;

	private Integer totalAmount;

	@Column(columnDefinition = "nvarchar(100)")
	private String shippingAddress;

	@Column(columnDefinition = "nvarchar(50)")
	private String paymentMethod;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;

	@OneToMany(mappedBy = "memberOrder", cascade = CascadeType.ALL)
	private List<MemberOrderDetail> memberOrderDetails;

	public Integer getMemberOrderId() {
		return memberOrderId;
	}

	public void setMemberOrderId(Integer memberOrderId) {
		this.memberOrderId = memberOrderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List<MemberOrderDetail> getMemberOrderDetails() {
		return memberOrderDetails;
	}

	public void setMemberOrderDetails(List<MemberOrderDetail> memberOrderDetails) {
		this.memberOrderDetails = memberOrderDetails;
	}

}
