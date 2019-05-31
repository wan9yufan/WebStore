package nju.yufan.webstore.comment.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@FeignClient(name = "goods-service")
public interface RemoteGoodsService {

	@RequestMapping("/getSkus")
	List<String> getSkus(List<String> skuid);
}
