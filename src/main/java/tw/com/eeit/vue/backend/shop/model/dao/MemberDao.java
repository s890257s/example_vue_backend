package tw.com.eeit.vue.backend.shop.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.eeit.vue.backend.shop.model.entity.Member;

public interface MemberDao extends JpaRepository<Member, Integer> {

}
