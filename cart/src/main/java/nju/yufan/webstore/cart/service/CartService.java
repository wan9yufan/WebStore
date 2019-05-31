package nju.yufan.webstore.cart.service;

import nju.yufan.webstore.cart.entity.CartItem;

import java.util.List;
import java.util.Map;

public interface CartService {
	void insert(CartItem item);

	void changeQuantity(int id, int num);

	void delete(int id);

	List<Map.Entry<Integer, List<CartItem>>> getCartItems(int userid);
}
