package nju.yufan.webstore.order.service;

import nju.yufan.webstore.order.dao.OrderDao;
import nju.yufan.webstore.order.entity.AfterSale;
import nju.yufan.webstore.order.entity.Order;
import nju.yufan.webstore.order.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;

	@Override
	public List<Order> getOrders4User(int userid) {
		return orderDao.getOrders(userid);
	}

	@Override
	public List<Order> getOrders4Store(int storeid) {
		return orderDao.getOrders2(storeid);
	}

	@Override
	@Transactional
	public void insert(OrderVo order) {
		orderDao.insert(order);
		orderDao.insertItems(order.getItems());
	}

	@Override
	@Transactional
	public void insertBatch(List<OrderVo> orders) {
		orderDao.insertBatch(orders);
		for (OrderVo order : orders)
			orderDao.insertItems(order.getItems());
	}



	@Override
	public void update(Order order) {
		orderDao.update(order);
	}

	@Override
	public Order getWholeById(int oid) {
		return orderDao.getWholeById(oid);
	}

	@Override
	public void insertAfterSale(AfterSale afterSale) {
		orderDao.insertAfterSale(afterSale);
	}

	@Override
	public AfterSale getAfterSale(int orderItemId) {
		return orderDao.getAfterSale(orderItemId);
	}

	@Override
	public void receiveReturn(int orderItemId) {
		orderDao.receiveReturn(orderItemId);
	}

	@Override
	public Order getOrderByOrderItemId(int orderItemId) {
		return orderDao.getByOrderItemId(orderItemId);
	}

	@Override
	public Order getOrder(int oid) {
		return orderDao.getOrder(oid);
	}



	@Override
	public List<OrderVo> getOrdersOfUser(int userid) {
		return orderDao.getOrdersOfUser(userid);
	}

	@Override
	public List<OrderVo> getOrdersOfUserByTime(int userid, Timestamp start, Timestamp end) {
		return orderDao.getOrdersOfUserByTime(userid, start, end);
	}

	@Override
	public List<OrderVo> getOrdersOfStore(int storeid) {
		return orderDao.getOrdersOfStore(storeid);
	}

	@Override
	public List<OrderVo> getOrdersOfStoreByTime(int storeid, Timestamp start, Timestamp end) {
		return orderDao.getOrdersOfStoreByTime(storeid, start, end);
	}

}
