package tw.com.eeit.vue.backend.shop.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.eeit.vue.backend.shop.model.entity.Member;
import tw.com.eeit.vue.backend.shop.model.entity.MemberDetail;

public interface MemberDetailDao extends JpaRepository<MemberDetail,  Member> {

}
