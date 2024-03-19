package tw.com.eeit.vue.backend.shop.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.util.Base64;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import tw.com.eeit.vue.backend.shop.model.dao.MemberDao;
import tw.com.eeit.vue.backend.shop.model.dao.ProductDao;
import tw.com.eeit.vue.backend.shop.model.dao.ProductPhotoDao;
import tw.com.eeit.vue.backend.shop.model.dao.ShoppingCartItemDao;
import tw.com.eeit.vue.backend.shop.model.dto.MemberDto;
import tw.com.eeit.vue.backend.shop.model.dto.ProductDto;
import tw.com.eeit.vue.backend.shop.model.dto.ShoppingCartItemDto;
import tw.com.eeit.vue.backend.shop.model.entity.Member;
import tw.com.eeit.vue.backend.shop.model.entity.Product;
import tw.com.eeit.vue.backend.shop.model.entity.ProductPhoto;
import tw.com.eeit.vue.backend.shop.model.entity.ShoppingCartItem;

@Service
public class ShopService {
	@Autowired
	private ProductDao productDao;

	@Autowired
	private ProductPhotoDao productPhotoDao;

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private ShoppingCartItemDao shoppingCartItemDao;

	// 根據頁碼搜尋商品
	public Page<ProductDto> findProductByPage(Integer pageNumber) {
		Page<Product> products = productDao.findAll(PageRequest.of(pageNumber, 6));

		Page<ProductDto> productDtos = products.map(p -> {
			ProductDto pt = new ProductDto();
			BeanUtils.copyProperties(p, pt);

			List<ProductPhoto> productPhotos = p.getProductPhotos();
			if (productPhotos != null && productPhotos.size() != 0) {
				ProductPhoto firstPhoto = productPhotos.get(0);
				pt.setPhotoId(firstPhoto.getProductPhotoId());
			}

			return pt;
		});
		return productDtos;
	}

	// 根據圖片ID搜尋商品圖片
	public byte[] findProductPhotoById(String id) {
		ProductPhoto productPhoto = productPhotoDao.findById(id).get();
		if (productPhoto == null) {
			return null;
		}

		return productPhoto.getProductPhoto();
	}

	// 登入
	public MemberDto login(String email, String password) {

		// 根據帳密取得物件
		Member member = memberDao.findByMemberEmailAndMemberPassword(email, password);

		// 不存在return空，表示登入失敗
		if (member == null) {
			return null;
		}

		// 存在建立Dto，儲存登入資訊
		MemberDto memberDto = new MemberDto();
		BeanUtils.copyProperties(member, memberDto);

		byte[] memberPhoto = member.getMemberDetail().getMemberPhoto();

		String mimetype = "image/*";
		try {
			mimetype = URLConnection.guessContentTypeFromStream(new ByteArrayInputStream(memberPhoto));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String base64 = Base64.getEncoder().encodeToString(memberPhoto);

		memberDto.setMemberPhoto("data:%s;base64,%s".formatted(mimetype, base64));

		return memberDto;
	}

	// 加入指定商品到指定會員的購物車
	public ShoppingCartItem addOneProductToCart(Integer memberId, Integer productId) {
		Member m = new Member(memberId);
		Product p = new Product(productId);

		ShoppingCartItem shoppingCartItem = shoppingCartItemDao.findByMemberAndProduct(m, p);

		if (shoppingCartItem != null) {
			shoppingCartItem.setQuantity(shoppingCartItem.getQuantity() + 1);
		}

		if (shoppingCartItem == null) {
			shoppingCartItem = new ShoppingCartItem();
			shoppingCartItem.setMember(m);
			shoppingCartItem.setProduct(p);
			shoppingCartItem.setQuantity(1);
		}

		ShoppingCartItem item = shoppingCartItemDao.save(shoppingCartItem);
		return item;
	}

	// 根據會員ID取得購物車
	public List<ShoppingCartItemDto> findShoppingCartByMemberId(Integer memberId) {
		List<ShoppingCartItem> shoppingCartItems = shoppingCartItemDao.findByMember(new Member(memberId));

	List<ShoppingCartItemDto> shoppingCartItemDtos = shoppingCartItems.stream().map(c -> {
			ShoppingCartItemDto ct = new ShoppingCartItemDto();
			Product p = c.getProduct();
			BeanUtils.copyProperties(p, ct);
			BeanUtils.copyProperties(c, ct);

			List<ProductPhoto> productPhotos = p.getProductPhotos();
			if (productPhotos != null && productPhotos.size() != 0) {
				ProductPhoto firstPhoto = productPhotos.get(0);
				ct.setProductPhotoId(firstPhoto.getProductPhotoId());
			}			
			
			return ct;
		}).toList();

		return shoppingCartItemDtos;

	}
}
