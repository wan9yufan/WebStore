package nju.yufan.webstore.order.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nju.yufan.webstore.order.entity.AfterSale;
import nju.yufan.webstore.order.entity.Order;
import nju.yufan.webstore.order.vo.Address;
import nju.yufan.webstore.order.vo.Store;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order1 {
	private int id;
	private int userid;
	private int storeid;
	private String storeName;
	private Store store;
	private Address address;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Timestamp time;
	private double money;
	private int status;
	private boolean commented;
	private List<OrderItem1> items;

	public Order1(Order order, String storeName) {
		this.id = order.getId();
		this.storeid = order.getStoreid();
		this.userid = order.getUserid();
		this.storeName = storeName;
		this.time = order.getTime();
		this.money = order.getMoney();
		this.status = order.getStatus();
		this.commented = order.isCommented();
	}
}
