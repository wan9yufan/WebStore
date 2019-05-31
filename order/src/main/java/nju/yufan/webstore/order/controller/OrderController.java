package nju.yufan.webstore.order.controller;

import nju.yufan.webstore.order.entity.AfterSale;
import nju.yufan.webstore.order.entity.Order;
import nju.yufan.webstore.order.entity.OrderItem;
import nju.yufan.webstore.order.model.Order1;
import nju.yufan.webstore.order.model.OrderItem1;
import nju.yufan.webstore.order.service.OrderService;
import nju.yufan.webstore.order.service.RemoteGoodsService;
import nju.yufan.webstore.order.service.RemoteStoreService;
import nju.yufan.webstore.order.service.RemoteUserService;
import nju.yufan.webstore.order.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private RemoteGoodsService goodsService;
	@Autowired
	private RemoteStoreService storeService;
	@Autowired
	private RemoteUserService userService;

	@RequestMapping("/orders4user")
	public List<OrderVo> getOrdersOfUser(int userid) {
		return orderService.getOrdersOfUser(userid);
	}

	@RequestMapping("/showOrderDetail")
	public Order1 showOrderDetail(int orderid) {
		Order order = orderService.getWholeById(orderid);
		Store store = storeService.getStoreById(order.getStoreid());
		Order1 result = new Order1(order, store.getName());
		result.setStore(store);
		result.setAddress(userService.getAddressById(order.getAddressid()));
		List<OrderItem1> item1List = new ArrayList<>();
		OrderItem1 item1;
		List<OrderItem> orderItems = order.getItems();
		List<OrderItemVo> vos = goodsService.getOrderItemVOs(orderItems.stream().map(OrderItem::getSkuid).collect(Collectors.toList()));
		for (int i = 0; i < orderItems.size(); i++) {
			item1 = new OrderItem1(vos.get(i), orderItems.get(i));
			item1List.add(item1);
		}
		result.setItems(item1List);
		return result;
	}

	@RequestMapping("/showOrders")
	public List<Order1> showOrders(int userid) {
//		List<Order> orders = orderService.getOrders4User(userid);
//		List<String> stores = storeService.getStoreNames(orders.stream().map(Order::getStoreid).collect(Collectors.toList()));
//		List<OrderItemVo> itemVos = goodsService.getOrderItemVOs(orders.stream().flatMap(order -> order.getItems().stream().map(OrderItem::getSkuid)).collect(Collectors.toList()));
//		int k = 0;
//		List<Order1> list = new ArrayList<>();
//		Order order;
//		Order1 order1;
//		List<OrderItem1> item1List;
//		OrderItem1 item1;
//		for (int i = 0; i < orders.size(); i++) {
//			order = orders.get(i);
//			order1 = new Order1(order, stores.get(i));
//			item1List = new ArrayList<>();
//			for (OrderItem item : order.getItems()) {
//				item1 = new OrderItem1(itemVos.get(k), item);
//				item1List.add(item1);
//				k++;
//			}
//			order1.setItems(item1List);
//			list.add(order1);
//		}
//		return list;
		List<Order1> list = new ArrayList<>();
		List<OrderItem1> items = new ArrayList<>();
		items.add(new OrderItem1(1, 1, "雷蛇键盘", "颜色：白色", "keyboard.jpg", 899.00, 1));
		Order1 order = new Order1(1, 1, 1, "雷蛇官方旗舰店", null, null, new Timestamp(new Long("1558601647000")), 899.00, 1, false, items);
		list.add(order);
		items = new ArrayList<>();
		items.add(new OrderItem1(2, 2, "男士长袖t恤圆领纯色修身韩版百搭青年白色春秋薄款打底衫男体恤 ", "颜色：白色；尺码：XL", "whiteT.jpg", 57.24, 1));
		items.add(new OrderItem1(3, 2, "男士长袖t恤圆领纯色修身韩版百搭青年白色春秋薄款打底衫男体恤 ", "颜色：黑色；尺码：XL", "blackT.jpg", 57.24, 1));
		order = new Order1(2, 1, 2, "班迪维旗舰店", null, null, new Timestamp(new Long("1549110287000")), 114.49, 5, false, items);
		list.add(order);
		items= new ArrayList<>();
		items.add(new OrderItem1(4,3,"深入理解Java虚拟机JVM高级特性+Java多线程编程","","books.png",33.13,1));
		order = new Order1(3,1,3,"it之家书社",null,null,new Timestamp(new Long("1541919915000")),33.13,5,true,items);
		list.add(order);
		return list;
	}

	@RequestMapping("/showOrders4Store")
	public List<Order1> showOrders4Store(int storeid) {
		List<Order> orders = orderService.getOrders4Store(storeid);
		List<Address> addressList = userService.getAddress2(orders.stream().map(Order::getAddressid).collect(Collectors.toList()));
		List<OrderItemVo> itemVos = goodsService.getOrderItemVOs(orders.stream().flatMap(order -> order.getItems().stream().map(OrderItem::getSkuid)).collect(Collectors.toList()));
		int k = 0;
		List<Order1> list = new ArrayList<>();
		Order order;
		Order1 order1;
		List<OrderItem1> item1List;
		OrderItem1 item1;
		for (int i = 0; i < orders.size(); i++) {
			order = orders.get(i);
			order1 = new Order1(order, storeService.getStoreById(storeid).getName());
			order1.setAddress(addressList.get(i));
			item1List = new ArrayList<>();
			for (OrderItem item : order.getItems()) {
				item1 = new OrderItem1(itemVos.get(k), item);
				item1List.add(item1);
				k++;
			}
			order1.setItems(item1List);
			list.add(order1);
		}
		return list;
	}


	@RequestMapping("/orders4store")
	public List<OrderVo> getOrdersOfStore(int storeid) {
		return orderService.getOrdersOfStore(storeid);
	}

	@RequestMapping("/ordersOfUserByTime")
	public List<OrderVo> getOrdersOfUserByTime(int userid, Timestamp start, Timestamp end) {
		return orderService.getOrdersOfUserByTime(userid, start, end);
	}

	@RequestMapping("/ordersOfStoreByTime")
	public List<OrderVo> getOrdersOfStoreByTime(int storeid, Timestamp start, Timestamp end) {
		return orderService.getOrdersOfStoreByTime(storeid, start, end);
	}

	@RequestMapping("/insertBatch")
	public void insertBatch(List<OrderVo> orders) {
		orderService.insertBatch(orders);
	}

	@RequestMapping("/insert")
	public void insert(OrderVo order) {
		orderService.insert(order);
	}

	@RequestMapping("/setStatus")
	public void setStatus(int id, int status, HttpServletResponse response) {
		Order order = orderService.getOrder(id);
		int old = order.getStatus();
		if ((old == 1 && status == 0) || (old == 2 && status == 3)) {
			order.setStatus(status);
			orderService.update(order);
		} else if (old == 1 && status == 2) {
			if (userService.pay(order.getUserid(), order.getStoreid(), order.getMoney())) {
				order.setStatus(status);
				orderService.update(order);
			} else
				response.setStatus(400);
		} else if (old == 2 && status == 0) {
			if (storeService.payBack(order.getUserid(), order.getStoreid(), order.getMoney())) {
				order.setStatus(status);
				orderService.update(order);
			} else
				response.setStatus(500);
		} else if (old == 3 && status == 4) {
			order.setStatus(status);
			order.setArriveTime(new Timestamp(System.currentTimeMillis()));
			orderService.update(order);
		} else if (old == 4 && status == 5) {
			order.setStatus(status);
			order.setReceiveTime(new Timestamp(System.currentTimeMillis()));
			orderService.update(order);
		}
	}

	@RequestMapping("/insertAfterSale")
	@Transactional
	public void insertAfterSale(AfterSale afterSale, HttpServletResponse response) {
		Order order = orderService.getOrderByOrderItemId(afterSale.getOrderItemId());
		if (order.getStatus() == 5) {
			order.setStatus(-1);
			orderService.update(order);
			orderService.insertAfterSale(afterSale);
		} else {
			response.setStatus(400);
		}
	}

	@RequestMapping("/receiveReturn")
	@Transactional
	public void receiveReturn(int orderItemId, HttpServletResponse response) {
		Order order = orderService.getOrderByOrderItemId(orderItemId);
		if (order.getStatus() == -1) {
			if (storeService.payBack(order.getUserid(), order.getStoreid(), order.getMoney())) {
				order.setStatus(-2);
				orderService.update(order);
				orderService.receiveReturn(orderItemId);
			} else
				response.setStatus(500);
		} else {
			response.setStatus(400);
		}
	}
}
