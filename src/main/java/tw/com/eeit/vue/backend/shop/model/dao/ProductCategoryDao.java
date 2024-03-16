package tw.com.eeit.vue.backend.shop.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.eeit.vue.backend.shop.model.entity.ProductCategory;

public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {

}
