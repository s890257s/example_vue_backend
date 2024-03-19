package tw.com.eeit.vue.backend.shop.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import tw.com.eeit.vue.backend.shop.model.dto.MemberDto;
import tw.com.eeit.vue.backend.shop.model.dto.ProductDto;
import tw.com.eeit.vue.backend.shop.model.dto.ShoppingCartItemDto;
import tw.com.eeit.vue.backend.shop.model.entity.ShoppingCartItem;
import tw.com.eeit.vue.backend.shop.service.ShopService;

@RestController
@RequestMapping("/shop/api")
@CrossOrigin(allowCredentials = "true", origins = { "http://localhost:5173/", "http://127.0.0.1:5173" })
public class ApiController {

	@Autowired
	private ShopService shopService;

	// 根據商品頁面取得商品Dto
	@GetMapping("/products/{pageNumber}")
	public Page<ProductDto> findProductByPage(@PathVariable Integer pageNumber) {
		Page<ProductDto> productDtos = shopService.findProductByPage(pageNumber);

		return productDtos;
	}

	@GetMapping(path = "/product/photo/{id}", produces = "image/*")
	public byte[] findProductPhotoById(@PathVariable String id) {

		return shopService.findProductPhotoById(id);
	}

	@RequestMapping("/login")
	public MemberDto login(@RequestParam String email, @RequestParam String password, HttpSession session) {

		MemberDto loggedInMember = shopService.login(email, password);

		if (loggedInMember == null) {
			throw new RuntimeException("登入失敗");
		}

		session.setAttribute("loggedInMember", loggedInMember);

		return loggedInMember;
	}

	@RequestMapping("/check")
	public boolean checkLogin(HttpSession session) {
		MemberDto loggedInMember = (MemberDto) session.getAttribute("loggedInMember");

		return !Objects.isNull(loggedInMember);
	}

	@RequestMapping("/logout")
	public boolean logout(HttpSession session) {
		session.invalidate();
		return true;
	}

	@RequestMapping("/product/add/{productId}")
	public ShoppingCartItem addOneProductToCart(@PathVariable Integer productId, HttpSession session) {
		MemberDto loggedInMember = (MemberDto) session.getAttribute("loggedInMember");

		if (loggedInMember == null) {
			throw new RuntimeException("未登入錯誤");
		}

		ShoppingCartItem addProductToCart = shopService.addOneProductToCart(loggedInMember.getMemberId(), productId);

		return addProductToCart;
	}
	

	@RequestMapping("/cart")
	public List<ShoppingCartItemDto> getCartByMemberId( HttpSession session) {
		MemberDto loggedInMember = (MemberDto) session.getAttribute("loggedInMember");

		if (loggedInMember == null) {
			throw new RuntimeException("未登入錯誤");
		}

		List<ShoppingCartItemDto> cartItems = shopService.findShoppingCartByMemberId(loggedInMember.getMemberId());
		
		return cartItems;
	}
	
}
