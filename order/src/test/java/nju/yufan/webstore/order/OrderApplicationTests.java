package nju.yufan.webstore.order;

import nju.yufan.webstore.order.entity.Order;
import nju.yufan.webstore.order.entity.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderApplicationTests {

	@Test
	public void contextLoads() {
		List<Order> orders = new ArrayList<>();;
		Order order;
		List<OrderItem> items;
		OrderItem item;
		for(int i=0;i<10;i++){
			order = new Order();
			items = new ArrayList<>();
			item = new OrderItem();
			item.setSkuid(String.valueOf(i*5));
			items.add(item);
			item = new OrderItem();
			item.setSkuid(String.valueOf(i*5+2));
			items.add(item);
			item = new OrderItem();
			item.setSkuid(String.valueOf(i*5+4));
			items.add(item);
			order.setItems(items);
			orders.add(order);
		}
		System.out.println(orders.stream().flatMap(a->a.getItems().stream().map(OrderItem::getSkuid)).collect(Collectors.toList()));
	}

	@Test
	public void test_timestamp(){
		System.out.println(System.currentTimeMillis());
	}
}
