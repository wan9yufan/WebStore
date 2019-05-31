package nju.yufan.webstore.order.service;

import nju.yufan.webstore.order.vo.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@FeignClient(name = "userservice")
public interface RemoteUserService {
	@RequestMapping("/getAddress")
	List<Address> getAddress(int userid);

	@RequestMapping("/getAddress2")
	List<Address> getAddress2(List<Integer>  ids);

	@RequestMapping("/getAddressById")
	Address getAddressById(int addressid);

//	@RequestMapping("/modifyUserBalance")
//	void modifyUserBalance(@RequestParam int userid,@RequestParam double amount);

	@RequestMapping("/pay")
	boolean pay(@RequestParam int userid, @RequestParam int storeid, @RequestParam double amount);
}
