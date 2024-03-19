package tw.com.eeit.vue.backend.shop.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.eeit.vue.backend.shop.model.entity.Member;
import tw.com.eeit.vue.backend.shop.model.entity.Product;
import tw.com.eeit.vue.backend.shop.model.entity.ShoppingCartItem;

public interface ShoppingCartItemDao extends JpaRepository<ShoppingCartItem, Integer> {

	public ShoppingCartItem findByMemberAndProduct(Member m, Product p);

	public List<ShoppingCartItem> findByMember(Member m);
}
