package nju.yufan.webstore.order.dao;

import nju.yufan.webstore.order.entity.AfterSale;
import nju.yufan.webstore.order.entity.Order;
import nju.yufan.webstore.order.entity.OrderItem;
import nju.yufan.webstore.order.vo.OrderVo;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface OrderDao {
	List<Order> getOrders(int userid);
	List<Order> getOrders2(int storeid);
	List<Order> getOrders4TimerTask();
	void insert(OrderVo order);
	void insertBatch(List<OrderVo> order);
	void insertItems(List<OrderItem> items);
	void update(Order order);
	Order getWholeById(int oid);
	Order getOrder(int oid);
	Order getByOrderItemId(int orderItemId);
	void insertAfterSale(AfterSale afterSale);
	void receiveReturn(int orderItemId);
	AfterSale getAfterSale(int orderItemId);

	//以下为对外接口
	List<OrderVo> getOrdersOfUser(int userid);
	List<OrderVo> getOrdersOfUserByTime(int userid, Timestamp start,Timestamp end);
	List<OrderVo> getOrdersOfStore(int storeid);
	List<OrderVo> getOrdersOfStoreByTime(int storeid, Timestamp start,Timestamp end);
}
