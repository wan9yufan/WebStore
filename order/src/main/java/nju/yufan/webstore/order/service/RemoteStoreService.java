package nju.yufan.webstore.order.service;

import nju.yufan.webstore.order.vo.Store;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@FeignClient(name = "storeservice")
public interface RemoteStoreService {
	@RequestMapping("/getStoreNames")
	List<String>  getStoreNames (List<Integer>  ids );

//	@RequestMapping("/modifyStoreTurnover")
//	void modifyStoreTurnover(@RequestParam int storeid,@RequestParam double amount);

	@RequestMapping("/payBack")
	boolean payBack(@RequestParam int userid, @RequestParam int storeid, @RequestParam double amount);

	@RequestMapping("/getStoreById")
	Store getStoreById(int storeid);
}
