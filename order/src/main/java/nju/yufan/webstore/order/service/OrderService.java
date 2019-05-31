package nju.yufan.webstore.order.service;

import nju.yufan.webstore.order.entity.AfterSale;
import nju.yufan.webstore.order.entity.Order;
import nju.yufan.webstore.order.vo.OrderVo;

import java.sql.Timestamp;
import java.util.List;

public interface OrderService {
	List<Order> getOrders4User(int userid);
	List<Order> getOrders4Store(int storeid);
	void insert(OrderVo order);
	void insertBatch(List<OrderVo> orders);
	Order getWholeById(int oid);
	Order getOrder(int oid);
	Order getOrderByOrderItemId(int orderItemId);
	void update(Order order);
	void insertAfterSale(AfterSale afterSale);
	AfterSale getAfterSale(int orderItemId);
	void receiveReturn(int orderItemId);

	List<OrderVo> getOrdersOfUser(int userid);
	List<OrderVo> getOrdersOfUserByTime(int userid, Timestamp start, Timestamp end);
	List<OrderVo> getOrdersOfStore(int storeid);
	List<OrderVo> getOrdersOfStoreByTime(int storeid, Timestamp start, Timestamp end);
}
