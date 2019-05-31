package nju.yufan.webstore.cart.controller;

import nju.yufan.webstore.cart.entity.CartItem;
import nju.yufan.webstore.cart.service.CartService;
import nju.yufan.webstore.cart.service.RemoteGoodsService;
import nju.yufan.webstore.cart.service.RemoteStoreService;
import nju.yufan.webstore.cart.model.CartItem1;
import nju.yufan.webstore.cart.vo.CartItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class CartController {
	@Autowired
	private CartService cartService;
	@Autowired
	private RemoteGoodsService goodsService;
	@Autowired
	private RemoteStoreService storeService;

	@RequestMapping("/insert")
	public void add2cart(CartItem item){
		cartService.insert(item);
	}

	@RequestMapping("/changeQuantity")
	public void changeQuantity(int id, int num){
		cartService.changeQuantity(id, num);
	}

	@RequestMapping("/showCart")
	public List<Map.Entry<String,List<CartItem1>>> showCart(int userid){
		List<Map.Entry<Integer, List<CartItem>>> entryList = cartService.getCartItems(userid);
		List<Integer> storeidList = entryList.stream().map(Map.Entry::getKey).collect(Collectors.toList());
		List<CartItem> cartItemList = entryList.stream().map(Map.Entry::getValue).flatMap(List::stream).collect(Collectors.toList());
		List<String> skuidList = cartItemList.stream().map(CartItem::getSkuid).collect(Collectors.toList());
		List<String> storeNames = storeService.getStoreNames(storeidList);
		List<CartItemVo> vos = goodsService.getCartItemVOs(skuidList);
		int n = entryList.size();
		List<Map.Entry<String,List<CartItem1>>> result = new ArrayList<>(n);
		Map.Entry<String,List<CartItem1>> entry;
		List<CartItem1> item1List;
		int k = 0;
		for(int i = 0; i < n; i++){
			item1List = new ArrayList<>();
			for(int j = 0; j < entryList.get(i).getValue().size();j++){
				item1List.add(new CartItem1(cartItemList.get(k), vos.get(k)));
				k++;
			}
			entry = new AbstractMap.SimpleEntry<>(storeNames.get(i), item1List);
			result.add(entry);
		}
		return result;
	}

	@RequestMapping("/delete")
	public void delete(int id){
		cartService.delete(id);
	}
}
