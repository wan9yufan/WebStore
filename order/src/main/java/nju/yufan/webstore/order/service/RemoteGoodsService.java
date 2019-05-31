package nju.yufan.webstore.order.service;

import nju.yufan.webstore.order.vo.OrderItemVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@FeignClient(name = "goods-service")
public interface RemoteGoodsService {
	@RequestMapping("/getOrderItemBySkus")
	List<OrderItemVo> getOrderItemVOs (List<String> skus);
}
