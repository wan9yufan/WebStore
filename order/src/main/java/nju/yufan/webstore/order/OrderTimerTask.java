package nju.yufan.webstore.order;

import nju.yufan.webstore.order.dao.OrderDao;
import nju.yufan.webstore.order.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;
import java.util.TimerTask;

@Component
public class OrderTimerTask extends TimerTask {
	@Autowired
	private OrderDao orderDao;
	private final static long payTimeout = 21600000;  //6个小时
	private final static long receiveTimeout = 432000000;  //5天
	private final static long successTimeout = 604800000;  //7天
	final static long period = 600000;  //10分钟
	final static long delay = 60000;  //1分钟

	@Override
	public void run() {
		List<Order> orders = orderDao.getOrders4TimerTask();
		long current = System.currentTimeMillis();
		long time;
		for (Order order : orders) {
			if (order.getStatus() == 1) {
				time = order.getTime().getTime();
				if (current - time > payTimeout) {
					order.setStatus(0);
					orderDao.update(order);
				}
			} else if (order.getStatus() == 4) {
				time = order.getArriveTime().getTime();
				if (current - time > receiveTimeout) {
					order.setReceiveTime(new Timestamp(current));
					orderDao.update(order);
				}
			} else if (order.getStatus() == 5) {
				time = order.getReceiveTime().getTime();
				if (current - time > successTimeout) {
					order.setStatus(6);
					orderDao.update(order);
				}
			}
		}
	}
}
