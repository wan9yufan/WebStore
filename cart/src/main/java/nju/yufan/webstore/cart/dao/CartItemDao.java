package nju.yufan.webstore.cart.dao;

import nju.yufan.webstore.cart.entity.CartItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemDao {
	void insert(CartItem item);

	void changeQuantity(int id, int num);

	void delete(int id);

	List<CartItem> getCartItems(int userid);

}
