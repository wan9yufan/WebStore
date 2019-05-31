package nju.yufan.webstore.order.vo;

import lombok.Getter;
import lombok.Setter;
import nju.yufan.webstore.order.entity.OrderItem;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class OrderVo {
	private int id;
	private int userid;
	private int storeid;
	private int addressid;
	private Timestamp time;
	private double money;
	List<OrderItem> items;
}
