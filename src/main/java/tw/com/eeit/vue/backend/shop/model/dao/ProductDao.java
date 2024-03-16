package tw.com.eeit.vue.backend.shop.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.eeit.vue.backend.shop.model.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
