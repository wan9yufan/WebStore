package nju.yufan.webstore.cart.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@FeignClient(name = "storeservice")
public interface RemoteStoreService {
	@RequestMapping("/getStoreNames")
	List<String>  getStoreNames(List<Integer> ids);
}
