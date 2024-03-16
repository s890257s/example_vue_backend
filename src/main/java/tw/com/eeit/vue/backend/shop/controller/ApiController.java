package tw.com.eeit.vue.backend.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop/api")
public class ApiController {

	@GetMapping("/tt")
	public String hello() {
		return "Hi!";
	}
}
