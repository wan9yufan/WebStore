package nju.yufan.webstore.cart.service;

import nju.yufan.webstore.cart.dao.CartItemDao;
import nju.yufan.webstore.cart.entity.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartItemDao cartItemDao;

	@Override
	public void insert(CartItem item) {
		cartItemDao.insert(item);
	}

	@Override
	public void changeQuantity(int id, int num) {
		cartItemDao.changeQuantity(id,num);
	}

	@Override
	public void delete(int id) {
		cartItemDao.delete(id);
	}

	@Override
	public List<Map.Entry<Integer, List<CartItem>>> getCartItems(int userid){
		List<Map.Entry<Integer, List<CartItem>>> list = new ArrayList<>(cartItemDao.getCartItems(userid).stream().collect(Collectors.groupingBy(CartItem::getStoreid))
				.entrySet());
		list.sort(Comparator.
				comparing(entry-> entry.getValue().stream().map(CartItem::getTime).max(Timestamp::compareTo).get(), Comparator.reverseOrder()));
		for(Map.Entry<Integer, List<CartItem>> items : list)
		{
			items.getValue().sort(Comparator.comparing(CartItem::getTime).reversed());
		}
		return list;
	}
}
