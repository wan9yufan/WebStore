package nju.yufan.webstore.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

	@RequestMapping("/fallback")
	public String fallback(){
		return "service not available";
	}
}