package tw.com.eeit.vue.backend.shop.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class MemberDetail {

	@Id
	private Integer memberId;

	@JoinColumn(name = "member_id", foreignKey = @ForeignKey(name = "fk_member_detail_member", foreignKeyDefinition = "FOREIGN KEY (member_id) REFERENCES Member(member_id) ON DELETE CASCADE ON UPDATE CASCADE"))
	@OneToOne
	@MapsId
	private Member member;

	private Integer memberAge;

	@Column(columnDefinition = "nvarchar(50)")
	private String memberGender;

	private Date birthDate;

	@Column(columnDefinition = "nvarchar(100)")
	private String memberAddress;

	@Column(columnDefinition = "varbinary(max)")
	private byte[] memberPhoto;

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Integer getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(Integer memberAge) {
		this.memberAge = memberAge;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public byte[] getMemberPhoto() {
		return memberPhoto;
	}

	public void setMemberPhoto(byte[] memberPhoto) {
		this.memberPhoto = memberPhoto;
	}

}
