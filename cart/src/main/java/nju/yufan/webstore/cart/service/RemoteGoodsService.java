package nju.yufan.webstore.cart.service;

import nju.yufan.webstore.cart.vo.CartItemVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@FeignClient(name = "goods-service")
public interface RemoteGoodsService {
	@RequestMapping("/getCartItemBySkus")
	List<CartItemVo> getCartItemVOs (List<String> skus);
}
